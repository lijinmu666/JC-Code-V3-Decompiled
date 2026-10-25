package org.bouncycastle.p249jcajce.provider.asymmetric.p262rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p201engines.RSABlindedEngine;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.p278util.DigestFactory;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* loaded from: classes2.dex */
public class PSSSignatureSpi extends SignatureSpi {
    private InterfaceC5277Digest contentDigest;
    private AlgorithmParameters engineParams;

    /* renamed from: helper */
    private final JcaJceHelper f21610helper;
    private boolean isInitState;

    /* renamed from: isRaw */
    private boolean f21611isRaw;

    /* renamed from: key */
    private RSAKeyParameters f21612key;
    private InterfaceC5277Digest mgfDigest;
    private PSSParameterSpec originalSpec;
    private PSSParameterSpec paramSpec;

    /* renamed from: pss */
    private PSSSigner f21613pss;

    /* renamed from: random */
    private SecureRandom f21614random;
    private int saltLength;

    /* renamed from: signer */
    private AsymmetricBlockCipher f21615signer;

    /* renamed from: trailer */
    private byte f21616trailer;

    public static class NullPssDigest implements InterfaceC5277Digest {
        private InterfaceC5277Digest baseDigest;

        /* renamed from: bOut */
        private ByteArrayOutputStream f21617bOut = new ByteArrayOutputStream();

        /* renamed from: oddTime */
        private boolean f21618oddTime = true;

        public NullPssDigest(InterfaceC5277Digest interfaceC5277Digest) {
            this.baseDigest = interfaceC5277Digest;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: doFinal */
        public int mo14967doFinal(byte[] bArr, int i) {
            byte[] byteArray = this.f21617bOut.toByteArray();
            if (this.f21618oddTime) {
                System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
            } else {
                this.baseDigest.mo14970update(byteArray, 0, byteArray.length);
                this.baseDigest.mo14967doFinal(bArr, i);
            }
            mo14968reset();
            this.f21618oddTime = !this.f21618oddTime;
            return byteArray.length;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public String getAlgorithmName() {
            return "NULL";
        }

        public int getByteLength() {
            return 0;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public int getDigestSize() {
            return this.baseDigest.getDigestSize();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: reset */
        public void mo14968reset() {
            this.f21617bOut.reset();
            this.baseDigest.mo14968reset();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14969update(byte b) {
            this.f21617bOut.write(b);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14970update(byte[] bArr, int i, int i2) {
            this.f21617bOut.write(bArr, i, i2);
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA1withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA1withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA1", "SHAKE128", null, 20, 1));
        }
    }

    public static class SHA1withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA1withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA1", "SHAKE256", null, 20, 1));
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), 28, 1));
        }
    }

    public static class SHA224withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA224withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-224", "SHAKE128", null, 28, 1));
        }
    }

    public static class SHA224withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA224withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-224", "SHAKE256", null, 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(XMSSKeyParameters.f23621SHA_256, "MGF1", new MGF1ParameterSpec(XMSSKeyParameters.f23621SHA_256), 32, 1));
        }
    }

    public static class SHA256withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA256withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec(XMSSKeyParameters.f23621SHA_256, "SHAKE128", null, 32, 1));
        }
    }

    public static class SHA256withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA256withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec(XMSSKeyParameters.f23621SHA_256, "SHAKE256", null, 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
        }
    }

    public static class SHA384withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA384withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-384", "SHAKE128", null, 48, 1));
        }
    }

    public static class SHA384withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA384withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-384", "SHAKE256", null, 48, 1));
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class SHA3_224withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_224withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "SHAKE128", null, 28, 1));
        }
    }

    public static class SHA3_224withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_224withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "SHAKE256", null, 28, 1));
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
        }
    }

    public static class SHA3_256withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_256withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "SHAKE128", null, 32, 1));
        }
    }

    public static class SHA3_256withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_256withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "SHAKE256", null, 32, 1));
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class SHA3_384withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_384withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "SHAKE128", null, 48, 1));
        }
    }

    public static class SHA3_384withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_384withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "SHAKE256", null, 48, 1));
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class SHA3_512withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA3_512withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "SHAKE128", null, 64, 1));
        }
    }

    public static class SHA3_512withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA3_512withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "SHAKE256", null, 64, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_224withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA512_224withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "SHAKE128", null, 28, 1));
        }
    }

    public static class SHA512_224withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA512_224withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "SHAKE256", null, 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512_256withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA512_256withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "SHAKE128", null, 32, 1));
        }
    }

    public static class SHA512_256withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA512_256withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "SHAKE256", null, 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(XMSSKeyParameters.f23622SHA_512, "MGF1", new MGF1ParameterSpec(XMSSKeyParameters.f23622SHA_512), 64, 1));
        }
    }

    public static class SHA512withRSAandSHAKE128 extends PSSSignatureSpi {
        public SHA512withRSAandSHAKE128() {
            super(new RSABlindedEngine(), new PSSParameterSpec(XMSSKeyParameters.f23622SHA_512, "SHAKE128", null, 64, 1));
        }
    }

    public static class SHA512withRSAandSHAKE256 extends PSSSignatureSpi {
        public SHA512withRSAandSHAKE256() {
            super(new RSABlindedEngine(), new PSSParameterSpec(XMSSKeyParameters.f23622SHA_512, "SHAKE256", null, 64, 1));
        }
    }

    public static class SHAKE128WithRSAPSS extends PSSSignatureSpi {
        public SHAKE128WithRSAPSS() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHAKE128", "SHAKE128", null, 32, 1));
        }
    }

    public static class SHAKE256WithRSAPSS extends PSSSignatureSpi {
        public SHAKE256WithRSAPSS() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHAKE256", "SHAKE256", null, 64, 1));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS */
    public static class C5605nonePSS extends PSSSignatureSpi {
        public C5605nonePSS() {
            super(new RSABlindedEngine(), null, true);
        }
    }

    public PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec) {
        this(asymmetricBlockCipher, pSSParameterSpec, false);
    }

    private byte getTrailer(int i) {
        if (i == 1) {
            return PSSSigner.TRAILER_IMPLICIT;
        }
        throw new IllegalArgumentException("unknown trailer field");
    }

    private void setupContentDigest() {
        InterfaceC5277Digest digest = DigestFactory.getDigest(this.paramSpec.getDigestAlgorithm());
        this.contentDigest = digest;
        if (this.f21611isRaw) {
            this.contentDigest = new NullPssDigest(digest);
        }
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21610helper.createAlgorithmParameters("PSS");
                this.engineParams = algorithmParametersCreateAlgorithmParameters;
                algorithmParametersCreateAlgorithmParameters.init(this.paramSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof RSAPrivateKey)) {
            throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
        }
        this.f21612key = C5606RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey);
        PSSSigner pSSSigner = new PSSSigner(this.f21615signer, this.contentDigest, this.mgfDigest, this.saltLength, this.f21616trailer);
        this.f21613pss = pSSSigner;
        SecureRandom secureRandom = this.f21614random;
        if (secureRandom != null) {
            pSSSigner.mo14987init(true, new ParametersWithRandom(this.f21612key, secureRandom));
        } else {
            pSSSigner.mo14987init(true, this.f21612key);
        }
        this.isInitState = true;
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof RSAPublicKey)) {
            throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
        }
        this.f21612key = C5606RSAUtil.generatePublicKeyParameter((RSAPublicKey) publicKey);
        PSSSigner pSSSigner = new PSSSigner(this.f21615signer, this.contentDigest, this.mgfDigest, this.saltLength, this.f21616trailer);
        this.f21613pss = pSSSigner;
        pSSSigner.mo14987init(false, this.f21612key);
        this.isInitState = true;
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        this.isInitState = true;
        try {
            return this.f21613pss.generateSignature();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f21613pss.mo14989update(b);
        this.isInitState = false;
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        this.isInitState = true;
        return this.f21613pss.verifySignature(bArr);
    }

    public PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec, boolean z) {
        this.f21610helper = new BCJcaJceHelper();
        this.isInitState = true;
        this.f21615signer = asymmetricBlockCipher;
        this.originalSpec = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.paramSpec = PSSParameterSpec.DEFAULT;
        } else {
            this.paramSpec = pSSParameterSpec;
        }
        this.mgfDigest = DigestFactory.getDigest("MGF1".equals(this.paramSpec.getMGFAlgorithm()) ? this.paramSpec.getDigestAlgorithm() : this.paramSpec.getMGFAlgorithm());
        this.saltLength = this.paramSpec.getSaltLength();
        this.f21616trailer = getTrailer(this.paramSpec.getTrailerField());
        this.f21611isRaw = z;
        setupContentDigest();
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f21614random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        String digestAlgorithm;
        PSSSigner pSSSigner;
        boolean z;
        if (algorithmParameterSpec == null && (algorithmParameterSpec = this.originalSpec) == null) {
            return;
        }
        if (!this.isInitState) {
            throw new ProviderException("cannot call setParameter in the middle of update");
        }
        if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
            throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
        }
        PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
        PSSParameterSpec pSSParameterSpec2 = this.originalSpec;
        if (pSSParameterSpec2 != null && !DigestFactory.isSameDigest(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
            throw new InvalidAlgorithmParameterException("parameter must be using " + this.originalSpec.getDigestAlgorithm());
        }
        if (pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") || pSSParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.f18498id_mgf1.m14433getId())) {
            if (!(pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec)) {
                throw new InvalidAlgorithmParameterException("unknown MGF parameters");
            }
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
            if (!DigestFactory.isSameDigest(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
            }
            digestAlgorithm = mGF1ParameterSpec.getDigestAlgorithm();
        } else {
            if (!pSSParameterSpec.getMGFAlgorithm().equals("SHAKE128") && !pSSParameterSpec.getMGFAlgorithm().equals("SHAKE256")) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            }
            digestAlgorithm = pSSParameterSpec.getMGFAlgorithm();
        }
        InterfaceC5277Digest digest = DigestFactory.getDigest(digestAlgorithm);
        if (digest == null) {
            throw new InvalidAlgorithmParameterException("no match on MGF algorithm: " + pSSParameterSpec.getMGFAlgorithm());
        }
        this.engineParams = null;
        this.paramSpec = pSSParameterSpec;
        this.mgfDigest = digest;
        this.saltLength = pSSParameterSpec.getSaltLength();
        this.f21616trailer = getTrailer(this.paramSpec.getTrailerField());
        setupContentDigest();
        if (this.f21612key != null) {
            this.f21613pss = new PSSSigner(this.f21615signer, this.contentDigest, digest, this.saltLength, this.f21616trailer);
            if (this.f21612key.isPrivate()) {
                pSSSigner = this.f21613pss;
                z = true;
            } else {
                pSSSigner = this.f21613pss;
                z = false;
            }
            pSSSigner.mo14987init(z, this.f21612key);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21613pss.mo14990update(bArr, i, i2);
        this.isInitState = false;
    }
}
