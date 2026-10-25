package org.bouncycastle.p246its.p248jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.operator.ITSContentSigner;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JcaITSContentSigner implements ITSContentSigner {

    /* renamed from: curveID */
    private final ASN1ObjectIdentifier f21311curveID;

    /* renamed from: digest */
    private final DigestCalculator f21312digest;
    private final AlgorithmIdentifier digestAlgo;

    /* renamed from: helper */
    private final JcaJceHelper f21313helper;
    private final byte[] parentData;
    private final byte[] parentDigest;
    private final ECPrivateKey privateKey;

    /* renamed from: signer */
    private final String f21314signer;
    private final ITSCertificate signerCert;

    /* renamed from: org.bouncycastle.its.jcajce.JcaITSContentSigner$Builder */
    public static class C5457Builder {

        /* renamed from: helper */
        private JcaJceHelper f21315helper = new DefaultJcaJceHelper();

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: build */
        public JcaITSContentSigner m16024build(PrivateKey privateKey) {
            return new JcaITSContentSigner((ECPrivateKey) privateKey, null, this.f21315helper);
        }

        public C5457Builder setProvider(String str) {
            this.f21315helper = new NamedJcaJceHelper(str);
            return this;
        }

        /* renamed from: build */
        public JcaITSContentSigner m16025build(PrivateKey privateKey, ITSCertificate iTSCertificate) {
            return new JcaITSContentSigner((ECPrivateKey) privateKey, iTSCertificate, this.f21315helper);
        }

        public C5457Builder setProvider(Provider provider) {
            this.f21315helper = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JcaITSContentSigner(ECPrivateKey eCPrivateKey, ITSCertificate iTSCertificate, JcaJceHelper jcaJceHelper) throws IOException {
        this.privateKey = eCPrivateKey;
        this.signerCert = iTSCertificate;
        this.f21313helper = jcaJceHelper;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(PrivateKeyInfo.getInstance(eCPrivateKey.getEncoded()).getPrivateKeyAlgorithm().getParameters());
        this.f21311curveID = aSN1ObjectIdentifier;
        if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1) && !aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
            if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP384r1)) {
                throw new IllegalArgumentException("unknown key type");
            }
            this.digestAlgo = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
            this.f21314signer = "SHA384withECDSA";
            try {
                try {
                    DigestCalculator digestCalculatorMo14763get = new JcaDigestCalculatorProviderBuilder().setHelper(jcaJceHelper).m17397build().mo14763get(this.digestAlgo);
                    this.f21312digest = digestCalculatorMo14763get;
                    if (iTSCertificate != null) {
                        this.parentData = null;
                        this.parentDigest = digestCalculatorMo14763get.getDigest();
                        return;
                    }
                    try {
                        byte[] encoded = iTSCertificate.getEncoded();
                        this.parentData = encoded;
                        OutputStream outputStream = digestCalculatorMo14763get.getOutputStream();
                        outputStream.write(encoded, 0, encoded.length);
                        outputStream.close();
                        this.parentDigest = digestCalculatorMo14763get.getDigest();
                        return;
                    } catch (IOException e) {
                        throw new IllegalStateException("signer certificate encoding failed: " + e.getMessage());
                    }
                } catch (OperatorCreationException e2) {
                    throw new IllegalStateException("cannot recognise digest type: " + this.digestAlgo.getAlgorithm(), e2);
                }
            } catch (Exception e3) {
                throw new IllegalStateException(e3.getMessage(), e3);
            }
        }
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        this.digestAlgo = algorithmIdentifier;
        this.f21314signer = "SHA256withECDSA";
        DigestCalculator digestCalculatorMo14763get2 = new JcaDigestCalculatorProviderBuilder().setHelper(jcaJceHelper).m17397build().mo14763get(this.digestAlgo);
        this.f21312digest = digestCalculatorMo14763get2;
        if (iTSCertificate != null) {
        }
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
        return this.f21311curveID;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgo;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public OutputStream getOutputStream() {
        return this.f21312digest.getOutputStream();
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public byte[] getSignature() throws SignatureException, InvalidKeyException {
        byte[] digest = this.f21312digest.getDigest();
        try {
            Signature signatureCreateSignature = this.f21313helper.createSignature(this.f21314signer);
            signatureCreateSignature.initSign(this.privateKey);
            signatureCreateSignature.update(digest, 0, digest.length);
            byte[] bArr = this.parentDigest;
            signatureCreateSignature.update(bArr, 0, bArr.length);
            return signatureCreateSignature.sign();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentSigner
    public boolean isForSelfSigning() {
        return this.parentData == null;
    }
}
