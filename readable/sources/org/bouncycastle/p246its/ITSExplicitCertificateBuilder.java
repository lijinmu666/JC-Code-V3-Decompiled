package org.bouncycastle.p246its;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p246its.operator.ECDSAEncoder;
import org.bouncycastle.p246its.operator.ITSContentSigner;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateBase;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateType;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.IssuerIdentifier;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.VerificationKeyIndicator;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashAlgorithm;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Signature;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ITSExplicitCertificateBuilder extends ITSCertificateBuilder {

    /* renamed from: signer */
    private final ITSContentSigner f21293signer;

    public ITSExplicitCertificateBuilder(ITSContentSigner iTSContentSigner, ToBeSignedCertificate.C5938Builder c5938Builder) {
        super(c5938Builder);
        this.f21293signer = iTSContentSigner;
    }

    /* renamed from: build */
    public ITSCertificate m16003build(CertificateId certificateId, ITSPublicVerificationKey iTSPublicVerificationKey) {
        return m16004build(certificateId, iTSPublicVerificationKey, null);
    }

    /* renamed from: build */
    public ITSCertificate m16004build(CertificateId certificateId, ITSPublicVerificationKey iTSPublicVerificationKey, ITSPublicEncryptionKey iTSPublicEncryptionKey) throws IOException {
        Signature signatureM16041toITS;
        IssuerIdentifier issuerIdentifierSha384AndDigest;
        HashAlgorithm hashAlgorithm;
        ToBeSignedCertificate.C5938Builder c5938Builder = new ToBeSignedCertificate.C5938Builder(this.tbsCertificateBuilder);
        c5938Builder.m17252setId(certificateId);
        if (iTSPublicEncryptionKey != null) {
            c5938Builder.setEncryptionKey(iTSPublicEncryptionKey.toASN1Structure());
        }
        c5938Builder.setVerifyKeyIndicator(VerificationKeyIndicator.verificationKey(iTSPublicVerificationKey.toASN1Structure()));
        ToBeSignedCertificate toBeSignedCertificateCreateToBeSignedCertificate = c5938Builder.createToBeSignedCertificate();
        VerificationKeyIndicator verifyKeyIndicator = this.f21293signer.isForSelfSigning() ? toBeSignedCertificateCreateToBeSignedCertificate.getVerifyKeyIndicator() : this.f21293signer.getAssociatedCertificate().toASN1Structure().getToBeSigned().getVerifyKeyIndicator();
        OutputStream outputStream = this.f21293signer.getOutputStream();
        try {
            outputStream.write(OEREncoder.toByteArray(toBeSignedCertificateCreateToBeSignedCertificate, IEEE1609dot2.ToBeSignedCertificate.m17146build()));
            outputStream.close();
            int choice = verifyKeyIndicator.getChoice();
            if (choice == 0) {
                signatureM16041toITS = ECDSAEncoder.m16041toITS(SECObjectIdentifiers.secp256r1, this.f21293signer.getSignature());
            } else if (choice == 1) {
                signatureM16041toITS = ECDSAEncoder.m16041toITS(TeleTrusTObjectIdentifiers.brainpoolP256r1, this.f21293signer.getSignature());
            } else {
                if (choice != 2) {
                    throw new IllegalStateException("unknown key type");
                }
                signatureM16041toITS = ECDSAEncoder.m16041toITS(TeleTrusTObjectIdentifiers.brainpoolP384r1, this.f21293signer.getSignature());
            }
            CertificateBase.C5922Builder c5922Builder = new CertificateBase.C5922Builder();
            ASN1ObjectIdentifier algorithm = this.f21293signer.getDigestAlgorithm().getAlgorithm();
            if (this.f21293signer.isForSelfSigning()) {
                if (algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
                    hashAlgorithm = HashAlgorithm.f22730sha256;
                } else {
                    if (!algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
                        throw new IllegalStateException("unknown digest");
                    }
                    hashAlgorithm = HashAlgorithm.f22731sha384;
                }
                issuerIdentifierSha384AndDigest = IssuerIdentifier.m17231self(hashAlgorithm);
            } else {
                byte[] associatedCertificateDigest = this.f21293signer.getAssociatedCertificateDigest();
                HashedId8 hashedId8 = new HashedId8(C6238Arrays.copyOfRange(associatedCertificateDigest, associatedCertificateDigest.length - 8, associatedCertificateDigest.length));
                if (algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
                    issuerIdentifierSha384AndDigest = IssuerIdentifier.sha256AndDigest(hashedId8);
                } else {
                    if (!algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
                        throw new IllegalStateException("unknown digest");
                    }
                    issuerIdentifierSha384AndDigest = IssuerIdentifier.sha384AndDigest(hashedId8);
                }
            }
            c5922Builder.setVersion(this.f21292version);
            c5922Builder.m17218setType(CertificateType.explicit);
            c5922Builder.setIssuer(issuerIdentifierSha384AndDigest);
            c5922Builder.setToBeSigned(toBeSignedCertificateCreateToBeSignedCertificate);
            c5922Builder.setSignature(signatureM16041toITS);
            return new ITSCertificate(c5922Builder.createCertificateBase());
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot produce certificate signature");
        }
    }
}
