package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.MLDSAKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.MLDSAKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class MLDSAKeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    MLDSAKeyPairGenerator f21576engine;
    boolean initialised;
    private final MLDSAParameters mldsaParameters;

    /* renamed from: param */
    MLDSAKeyGenerationParameters f21577param;

    /* renamed from: random */
    SecureRandom f21578random;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyPairGeneratorSpi$Hash */
    public static class C5581Hash extends MLDSAKeyPairGeneratorSpi {
        public C5581Hash() {
            super("HASH-ML-DSA");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyPairGeneratorSpi$MLDSA44 */
    public static class C5582MLDSA44 extends MLDSAKeyPairGeneratorSpi {
        public C5582MLDSA44() {
            super(MLDSAParameterSpec.ml_dsa_44);
        }
    }

    public static class MLDSA44withSHA512 extends MLDSAKeyPairGeneratorSpi {
        public MLDSA44withSHA512() {
            super(MLDSAParameterSpec.ml_dsa_44_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyPairGeneratorSpi$MLDSA65 */
    public static class C5583MLDSA65 extends MLDSAKeyPairGeneratorSpi {
        public C5583MLDSA65() {
            super(MLDSAParameterSpec.ml_dsa_65);
        }
    }

    public static class MLDSA65withSHA512 extends MLDSAKeyPairGeneratorSpi {
        public MLDSA65withSHA512() {
            super(MLDSAParameterSpec.ml_dsa_65_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyPairGeneratorSpi$MLDSA87 */
    public static class C5584MLDSA87 extends MLDSAKeyPairGeneratorSpi {
        public C5584MLDSA87() {
            super(MLDSAParameterSpec.ml_dsa_87);
        }
    }

    public static class MLDSA87withSHA512 extends MLDSAKeyPairGeneratorSpi {
        public MLDSA87withSHA512() {
            super(MLDSAParameterSpec.ml_dsa_87_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyPairGeneratorSpi$Pure */
    public static class C5585Pure extends MLDSAKeyPairGeneratorSpi {
        public C5585Pure() {
            super("ML-DSA");
        }
    }

    public MLDSAKeyPairGeneratorSpi(String str) {
        super(str);
        this.f21576engine = new MLDSAKeyPairGenerator();
        this.f21578random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.mldsaParameters = null;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof MLDSAParameterSpec ? ((MLDSAParameterSpec) algorithmParameterSpec).m16205getName() : C6250Strings.toUpperCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            this.f21577param = getAlgorithm().startsWith("HASH") ? new MLDSAKeyGenerationParameters(this.f21578random, MLDSAParameters.ml_dsa_87_with_sha512) : new MLDSAKeyGenerationParameters(this.f21578random, MLDSAParameters.ml_dsa_87);
            this.f21576engine.mo14944init(this.f21577param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21576engine.generateKeyPair();
        return new KeyPair(new BCMLDSAPublicKey((MLDSAPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCMLDSAPrivateKey((MLDSAPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public MLDSAKeyPairGeneratorSpi(MLDSAParameterSpec mLDSAParameterSpec) {
        super(C6250Strings.toUpperCase(mLDSAParameterSpec.m16205getName()));
        this.f21576engine = new MLDSAKeyPairGenerator();
        this.f21578random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        MLDSAParameters parameters = C5590Utils.getParameters(mLDSAParameterSpec.m16205getName());
        this.mldsaParameters = parameters;
        if (this.f21577param == null) {
            this.f21577param = new MLDSAKeyGenerationParameters(this.f21578random, parameters);
        }
        this.f21576engine.mo14944init(this.f21577param);
        this.initialised = true;
    }

    @Override // java.security.KeyPairGenerator
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        try {
            initialize(algorithmParameterSpec, new BCJcaJceHelper().createSecureRandom("DEFAULT"));
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("unable to find DEFAULT DRBG");
        }
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        MLDSAParameters parameters = C5590Utils.getParameters(nameFromParams);
        if (parameters == null) {
            throw new InvalidAlgorithmParameterException("unknown parameter set name: " + nameFromParams);
        }
        this.f21577param = new MLDSAKeyGenerationParameters(secureRandom, parameters);
        if (this.mldsaParameters == null || parameters.m15777getName().equals(this.mldsaParameters.m15777getName())) {
            this.f21576engine.mo14944init(this.f21577param);
            this.initialised = true;
        } else {
            throw new InvalidAlgorithmParameterException("key pair generator locked to " + MLDSAParameterSpec.fromName(this.mldsaParameters.m15777getName()).m16205getName());
        }
    }
}
