package org.bouncycastle.p246its;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateBase;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateType;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.IssuerIdentifier;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.VerificationKeyIndicator;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ITSImplicitCertificateBuilder extends ITSCertificateBuilder {
    private final IssuerIdentifier issuerIdentifier;

    public ITSImplicitCertificateBuilder(ITSCertificate iTSCertificate, DigestCalculatorProvider digestCalculatorProvider, ToBeSignedCertificate.C5938Builder c5938Builder) throws IOException {
        IssuerIdentifier issuerIdentifierSha384AndDigest;
        super(iTSCertificate, c5938Builder);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            DigestCalculator digestCalculatorMo14763get = digestCalculatorProvider.mo14763get(algorithmIdentifier);
            try {
                OutputStream outputStream = digestCalculatorMo14763get.getOutputStream();
                outputStream.write(iTSCertificate.getEncoded());
                outputStream.close();
                byte[] digest = digestCalculatorMo14763get.getDigest();
                HashedId8 hashedId8 = new HashedId8(C6238Arrays.copyOfRange(digest, digest.length - 8, digest.length));
                if (algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    issuerIdentifierSha384AndDigest = IssuerIdentifier.sha256AndDigest(hashedId8);
                } else {
                    if (!algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
                        throw new IllegalStateException("unknown digest");
                    }
                    issuerIdentifierSha384AndDigest = IssuerIdentifier.sha384AndDigest(hashedId8);
                }
                this.issuerIdentifier = issuerIdentifierSha384AndDigest;
            } catch (IOException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        } catch (OperatorCreationException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    /* renamed from: build */
    public ITSCertificate m16005build(CertificateId certificateId, BigInteger bigInteger, BigInteger bigInteger2) {
        return m16006build(certificateId, bigInteger, bigInteger2, null);
    }

    /* renamed from: build */
    public ITSCertificate m16006build(CertificateId certificateId, BigInteger bigInteger, BigInteger bigInteger2, PublicEncryptionKey publicEncryptionKey) {
        EccP256CurvePoint eccP256CurvePointUncompressedP256 = EccP256CurvePoint.uncompressedP256(bigInteger, bigInteger2);
        ToBeSignedCertificate.C5938Builder c5938Builder = new ToBeSignedCertificate.C5938Builder(this.tbsCertificateBuilder);
        c5938Builder.m17252setId(certificateId);
        if (publicEncryptionKey != null) {
            c5938Builder.setEncryptionKey(publicEncryptionKey);
        }
        c5938Builder.setVerifyKeyIndicator(VerificationKeyIndicator.reconstructionValue(eccP256CurvePointUncompressedP256));
        CertificateBase.C5922Builder c5922Builder = new CertificateBase.C5922Builder();
        c5922Builder.setVersion(this.f21292version);
        c5922Builder.m17218setType(CertificateType.implicit);
        c5922Builder.setIssuer(this.issuerIdentifier);
        c5922Builder.setToBeSigned(c5938Builder.createToBeSignedCertificate());
        return new ITSCertificate(c5922Builder.createCertificateBase());
    }
}
