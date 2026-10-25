package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.MLKEMKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.MLKEMKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class MLKEMKeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    MLKEMKeyPairGenerator f21589engine;
    boolean initialised;
    private MLKEMParameters mlkemParameters;

    /* renamed from: param */
    MLKEMKeyGenerationParameters f21590param;

    /* renamed from: random */
    SecureRandom f21591random;

    public static class MLKEM1024 extends MLKEMKeyPairGeneratorSpi {
        public MLKEM1024() {
            super(MLKEMParameterSpec.ml_kem_1024);
        }
    }

    public static class MLKEM512 extends MLKEMKeyPairGeneratorSpi {
        public MLKEM512() {
            super(MLKEMParameterSpec.ml_kem_512);
        }
    }

    public static class MLKEM768 extends MLKEMKeyPairGeneratorSpi {
        public MLKEM768() {
            super(MLKEMParameterSpec.ml_kem_768);
        }
    }

    public MLKEMKeyPairGeneratorSpi() {
        super("ML-KEM");
        this.f21589engine = new MLKEMKeyPairGenerator();
        this.f21591random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof MLKEMParameterSpec ? ((MLKEMParameterSpec) algorithmParameterSpec).m16208getName() : C6250Strings.toUpperCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            MLKEMKeyGenerationParameters mLKEMKeyGenerationParameters = new MLKEMKeyGenerationParameters(this.f21591random, MLKEMParameters.ml_kem_768);
            this.f21590param = mLKEMKeyGenerationParameters;
            this.f21589engine.mo14944init(mLKEMKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21589engine.generateKeyPair();
        return new KeyPair(new BCMLKEMPublicKey((MLKEMPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCMLKEMPrivateKey((MLKEMPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public MLKEMKeyPairGeneratorSpi(MLKEMParameterSpec mLKEMParameterSpec) {
        super(C6250Strings.toUpperCase(mLKEMParameterSpec.m16208getName()));
        this.f21589engine = new MLKEMKeyPairGenerator();
        this.f21591random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        MLKEMParameters parameters = C5592Utils.getParameters(mLKEMParameterSpec.m16208getName());
        this.mlkemParameters = parameters;
        if (this.f21590param == null) {
            this.f21590param = new MLKEMKeyGenerationParameters(this.f21591random, parameters);
        }
        this.f21589engine.mo14944init(this.f21590param);
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
        MLKEMParameters parameters = C5592Utils.getParameters(nameFromParams);
        if (parameters == null) {
            throw new InvalidAlgorithmParameterException("unknown parameter set name: " + nameFromParams);
        }
        if (this.mlkemParameters != null && !parameters.m15790getName().equals(this.mlkemParameters.m15790getName())) {
            throw new InvalidAlgorithmParameterException("key pair generator locked to " + getAlgorithm());
        }
        MLKEMKeyGenerationParameters mLKEMKeyGenerationParameters = new MLKEMKeyGenerationParameters(secureRandom, parameters);
        this.f21590param = mLKEMKeyGenerationParameters;
        this.f21589engine.mo14944init(mLKEMKeyGenerationParameters);
        this.initialised = true;
    }
}
