package org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.MLKEMKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.MLKEMKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.KyberParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class KyberKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    MLKEMKeyPairGenerator f23769engine;
    boolean initialised;
    private MLKEMParameters kyberParameters;

    /* renamed from: param */
    MLKEMKeyGenerationParameters f23770param;

    /* renamed from: random */
    SecureRandom f23771random;

    public static class Kyber1024 extends KyberKeyPairGeneratorSpi {
        public Kyber1024() {
            super(MLKEMParameters.ml_kem_1024);
        }
    }

    public static class Kyber512 extends KyberKeyPairGeneratorSpi {
        public Kyber512() {
            super(MLKEMParameters.ml_kem_512);
        }
    }

    public static class Kyber768 extends KyberKeyPairGeneratorSpi {
        public Kyber768() {
            super(MLKEMParameters.ml_kem_768);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(KyberParameterSpec.kyber512.m18047getName(), MLKEMParameters.ml_kem_512);
        parameters.put(KyberParameterSpec.kyber768.m18047getName(), MLKEMParameters.ml_kem_768);
        parameters.put(KyberParameterSpec.kyber1024.m18047getName(), MLKEMParameters.ml_kem_1024);
    }

    public KyberKeyPairGeneratorSpi() {
        super("KYBER");
        this.f23769engine = new MLKEMKeyPairGenerator();
        this.f23771random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.kyberParameters = null;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof KyberParameterSpec ? ((KyberParameterSpec) algorithmParameterSpec).m18047getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            MLKEMParameters mLKEMParameters = this.kyberParameters;
            if (mLKEMParameters != null) {
                this.f23770param = new MLKEMKeyGenerationParameters(this.f23771random, mLKEMParameters);
            } else {
                this.f23770param = new MLKEMKeyGenerationParameters(this.f23771random, MLKEMParameters.ml_kem_1024);
            }
            this.f23769engine.mo14944init(this.f23770param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23769engine.generateKeyPair();
        return new KeyPair(new BCKyberPublicKey((MLKEMPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCKyberPrivateKey((MLKEMPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public KyberKeyPairGeneratorSpi(MLKEMParameters mLKEMParameters) {
        super(C6250Strings.toUpperCase(mLKEMParameters.m15790getName()));
        this.f23769engine = new MLKEMKeyPairGenerator();
        this.f23771random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.kyberParameters = mLKEMParameters;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null || !parameters.containsKey(nameFromParams)) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        MLKEMParameters mLKEMParameters = (MLKEMParameters) parameters.get(nameFromParams);
        this.f23770param = new MLKEMKeyGenerationParameters(secureRandom, mLKEMParameters);
        if (this.kyberParameters == null || mLKEMParameters.m15790getName().equals(this.kyberParameters.m15790getName())) {
            this.f23769engine.mo14944init(this.f23770param);
            this.initialised = true;
        } else {
            throw new InvalidAlgorithmParameterException("key pair generator locked to " + C6250Strings.toUpperCase(this.kyberParameters.m15790getName()));
        }
    }
}
