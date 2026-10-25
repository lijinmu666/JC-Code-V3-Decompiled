package org.bouncycastle.p246its.p247bc;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.p305bc.BcDefaultDigestProvider;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p206io.DigestOutputStream;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p217signers.DSADigestSigner;
import org.bouncycastle.p194crypto.p217signers.ECDSASigner;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.operator.ITSContentSigner;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BcITSContentSigner implements ITSContentSigner {

    /* renamed from: curveID */
    private final ASN1ObjectIdentifier f21301curveID;

    /* renamed from: digest */
    private final InterfaceC5277Digest f21302digest;
    private final AlgorithmIdentifier digestAlgo;
    private final byte[] parentData;
    private final byte[] parentDigest;

    /* renamed from: privKey */
    private final ECPrivateKeyParameters f21303privKey;
    private final ITSCertificate signerCert;

    public BcITSContentSigner(ECPrivateKeyParameters eCPrivateKeyParameters) {
        this(eCPrivateKeyParameters, null);
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public ITSCertificate getAssociatedCertificate() {
        return this.signerCert;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public byte[] getAssociatedCertificateDigest() {
        return C6238Arrays.m18231clone(this.parentDigest);
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public ASN1ObjectIdentifier getCurveID() {
        return this.f21301curveID;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgo;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public OutputStream getOutputStream() {
        return new DigestOutputStream(this.f21302digest);
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public byte[] getSignature() {
        int digestSize = this.f21302digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.f21302digest.mo14967doFinal(bArr, 0);
        DSADigestSigner dSADigestSigner = new DSADigestSigner(new ECDSASigner(), this.f21302digest);
        dSADigestSigner.mo14987init(true, this.f21303privKey);
        dSADigestSigner.mo14990update(bArr, 0, digestSize);
        byte[] bArr2 = this.parentDigest;
        dSADigestSigner.mo14990update(bArr2, 0, bArr2.length);
        return dSADigestSigner.generateSignature();
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public boolean isForSelfSigning() {
        return this.parentData == null;
    }

    public BcITSContentSigner(ECPrivateKeyParameters eCPrivateKeyParameters, ITSCertificate iTSCertificate) {
        AlgorithmIdentifier algorithmIdentifier;
        this.f21303privKey = eCPrivateKeyParameters;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM15726getName = ((ECNamedDomainParameters) eCPrivateKeyParameters.getParameters()).m15726getName();
        this.f21301curveID = aSN1ObjectIdentifierM15726getName;
        this.signerCert = iTSCertificate;
        if (aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1) || aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
            algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        } else {
            if (!aSN1ObjectIdentifierM15726getName.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP384r1)) {
                throw new IllegalArgumentException("unknown key type");
            }
            algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        this.digestAlgo = algorithmIdentifier;
        try {
            ExtendedDigest extendedDigestMo14916get = BcDefaultDigestProvider.INSTANCE.mo14916get(this.digestAlgo);
            this.f21302digest = extendedDigestMo14916get;
            if (iTSCertificate == null) {
                this.parentData = null;
                byte[] bArr = new byte[extendedDigestMo14916get.getDigestSize()];
                this.parentDigest = bArr;
                extendedDigestMo14916get.mo14967doFinal(bArr, 0);
                return;
            }
            try {
                byte[] encoded = iTSCertificate.getEncoded();
                this.parentData = encoded;
                byte[] bArr2 = new byte[extendedDigestMo14916get.getDigestSize()];
                this.parentDigest = bArr2;
                extendedDigestMo14916get.mo14970update(encoded, 0, encoded.length);
                extendedDigestMo14916get.mo14967doFinal(bArr2, 0);
            } catch (IOException e) {
                throw new IllegalStateException("signer certificate encoding failed: " + e.getMessage());
            }
        } catch (OperatorCreationException unused) {
            throw new IllegalStateException("cannot recognise digest type: " + this.digestAlgo.getAlgorithm());
        }
    }
}
