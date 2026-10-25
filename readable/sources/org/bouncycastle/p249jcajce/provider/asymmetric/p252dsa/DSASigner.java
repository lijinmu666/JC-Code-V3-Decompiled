package org.bouncycastle.p249jcajce.provider.asymmetric.p252dsa;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.NullDigest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD160Digest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p217signers.DSAEncoding;
import org.bouncycastle.p194crypto.p217signers.HMacDSAKCalculator;
import org.bouncycastle.p194crypto.p217signers.StandardDSAEncoding;
import org.bouncycastle.p194crypto.p221util.DigestFactory;

/* loaded from: classes2.dex */
public class DSASigner extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {

    /* renamed from: digest */
    private InterfaceC5277Digest f21451digest;
    private DSAEncoding encoding = StandardDSAEncoding.INSTANCE;

    /* renamed from: random */
    private SecureRandom f21452random;

    /* renamed from: signer */
    private InterfaceC5276DSAExt f21453signer;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA */
    public static class C5509detDSA extends DSASigner {
        public C5509detDSA() {
            super(DigestFactory.createSHA1(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA1())));
        }
    }

    public static class detDSA224 extends DSASigner {
        public detDSA224() {
            super(DigestFactory.createSHA224(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA224())));
        }
    }

    public static class detDSA256 extends DSASigner {
        public detDSA256() {
            super(DigestFactory.createSHA256(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA256())));
        }
    }

    public static class detDSA384 extends DSASigner {
        public detDSA384() {
            super(DigestFactory.createSHA384(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA384())));
        }
    }

    public static class detDSA512 extends DSASigner {
        public detDSA512() {
            super(DigestFactory.createSHA512(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA512())));
        }
    }

    public static class detDSASha3_224 extends DSASigner {
        public detDSASha3_224() {
            super(DigestFactory.createSHA3_224(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_224())));
        }
    }

    public static class detDSASha3_256 extends DSASigner {
        public detDSASha3_256() {
            super(DigestFactory.createSHA3_256(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_256())));
        }
    }

    public static class detDSASha3_384 extends DSASigner {
        public detDSASha3_384() {
            super(DigestFactory.createSHA3_384(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_384())));
        }
    }

    public static class detDSASha3_512 extends DSASigner {
        public detDSASha3_512() {
            super(DigestFactory.createSHA3_512(), new org.bouncycastle.p194crypto.p217signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_512())));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224 */
    public static class C5510dsa224 extends DSASigner {
        public C5510dsa224() {
            super(DigestFactory.createSHA224(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256 */
    public static class C5511dsa256 extends DSASigner {
        public C5511dsa256() {
            super(DigestFactory.createSHA256(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384 */
    public static class C5512dsa384 extends DSASigner {
        public C5512dsa384() {
            super(DigestFactory.createSHA384(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512 */
    public static class C5513dsa512 extends DSASigner {
        public C5513dsa512() {
            super(DigestFactory.createSHA512(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    public static class dsaRMD160 extends DSASigner {
        public dsaRMD160() {
            super(new RIPEMD160Digest(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    public static class dsaSha3_224 extends DSASigner {
        public dsaSha3_224() {
            super(DigestFactory.createSHA3_224(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    public static class dsaSha3_256 extends DSASigner {
        public dsaSha3_256() {
            super(DigestFactory.createSHA3_256(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    public static class dsaSha3_384 extends DSASigner {
        public dsaSha3_384() {
            super(DigestFactory.createSHA3_384(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    public static class dsaSha3_512 extends DSASigner {
        public dsaSha3_512() {
            super(DigestFactory.createSHA3_512(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA */
    public static class C5514noneDSA extends DSASigner {
        public C5514noneDSA() {
            super(new NullDigest(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA */
    public static class C5515stdDSA extends DSASigner {
        public C5515stdDSA() {
            super(DigestFactory.createSHA1(), new org.bouncycastle.p194crypto.p217signers.DSASigner());
        }
    }

    public DSASigner(InterfaceC5277Digest interfaceC5277Digest, InterfaceC5276DSAExt interfaceC5276DSAExt) {
        this.f21451digest = interfaceC5277Digest;
        this.f21453signer = interfaceC5276DSAExt;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        CipherParameters cipherParametersGeneratePrivateKeyParameter = C5516DSAUtil.generatePrivateKeyParameter(privateKey);
        SecureRandom secureRandom = this.f21452random;
        if (secureRandom != null) {
            cipherParametersGeneratePrivateKeyParameter = new ParametersWithRandom(cipherParametersGeneratePrivateKeyParameter, secureRandom);
        }
        this.f21451digest.mo14968reset();
        this.f21453signer.mo14965init(true, cipherParametersGeneratePrivateKeyParameter);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKeyParameter = C5516DSAUtil.generatePublicKeyParameter(publicKey);
        this.f21451digest.mo14968reset();
        this.f21453signer.mo14965init(false, asymmetricKeyParameterGeneratePublicKeyParameter);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f21451digest.getDigestSize()];
        this.f21451digest.mo14967doFinal(bArr, 0);
        try {
            BigInteger[] bigIntegerArrGenerateSignature = this.f21453signer.generateSignature(bArr);
            return this.encoding.mo15857encode(this.f21453signer.getOrder(), bigIntegerArrGenerateSignature[0], bigIntegerArrGenerateSignature[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f21451digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f21451digest.getDigestSize()];
        this.f21451digest.mo14967doFinal(bArr2, 0);
        try {
            BigInteger[] bigIntegerArrMo15856decode = this.encoding.mo15856decode(this.f21453signer.getOrder(), bArr);
            return this.f21453signer.verifySignature(bArr2, bigIntegerArrMo15856decode[0], bigIntegerArrMo15856decode[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f21452random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21451digest.mo14970update(bArr, i, i2);
    }
}
