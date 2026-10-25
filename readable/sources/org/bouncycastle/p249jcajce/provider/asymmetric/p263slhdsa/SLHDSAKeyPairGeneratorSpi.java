package org.bouncycastle.p249jcajce.provider.asymmetric.p263slhdsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.SLHDSAKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.SLHDSAKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.SLHDSAParameterSpec;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SLHDSAKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    SLHDSAKeyPairGenerator f21624engine;
    boolean initialised;

    /* renamed from: param */
    SLHDSAKeyGenerationParameters f21625param;

    /* renamed from: random */
    SecureRandom f21626random;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.slhdsa.SLHDSAKeyPairGeneratorSpi$Hash */
    public static class C5610Hash extends SLHDSAKeyPairGeneratorSpi {
        public C5610Hash() {
            super("HASH-SLH-DSA");
        }
    }

    public static class HashSha2_128f extends SLHDSAKeyPairGeneratorSpi {
        public HashSha2_128f() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_128f_with_sha256);
        }
    }

    public static class HashSha2_128s extends SLHDSAKeyPairGeneratorSpi {
        public HashSha2_128s() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_128s_with_sha256);
        }
    }

    public static class HashSha2_192f extends SLHDSAKeyPairGeneratorSpi {
        public HashSha2_192f() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_192f_with_sha512);
        }
    }

    public static class HashSha2_192s extends SLHDSAKeyPairGeneratorSpi {
        public HashSha2_192s() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_192s_with_sha512);
        }
    }

    public static class HashSha2_256f extends SLHDSAKeyPairGeneratorSpi {
        public HashSha2_256f() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_256f_with_sha512);
        }
    }

    public static class HashSha2_256s extends SLHDSAKeyPairGeneratorSpi {
        public HashSha2_256s() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_256s_with_sha512);
        }
    }

    public static class HashShake_128f extends SLHDSAKeyPairGeneratorSpi {
        public HashShake_128f() {
            super(SLHDSAParameterSpec.slh_dsa_shake_128f_with_shake128);
        }
    }

    public static class HashShake_128s extends SLHDSAKeyPairGeneratorSpi {
        public HashShake_128s() {
            super(SLHDSAParameterSpec.slh_dsa_shake_128s_with_shake128);
        }
    }

    public static class HashShake_192f extends SLHDSAKeyPairGeneratorSpi {
        public HashShake_192f() {
            super(SLHDSAParameterSpec.slh_dsa_shake_192f_with_shake256);
        }
    }

    public static class HashShake_192s extends SLHDSAKeyPairGeneratorSpi {
        public HashShake_192s() {
            super(SLHDSAParameterSpec.slh_dsa_shake_192s_with_shake256);
        }
    }

    public static class HashShake_256f extends SLHDSAKeyPairGeneratorSpi {
        public HashShake_256f() {
            super(SLHDSAParameterSpec.slh_dsa_shake_256f_with_shake256);
        }
    }

    public static class HashShake_256s extends SLHDSAKeyPairGeneratorSpi {
        public HashShake_256s() {
            super(SLHDSAParameterSpec.slh_dsa_shake_256s_with_shake256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.slhdsa.SLHDSAKeyPairGeneratorSpi$Pure */
    public static class C5611Pure extends SLHDSAKeyPairGeneratorSpi {
        public C5611Pure() {
            super("SLH-DSA");
        }
    }

    public static class Sha2_128f extends SLHDSAKeyPairGeneratorSpi {
        public Sha2_128f() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_128f);
        }
    }

    public static class Sha2_128s extends SLHDSAKeyPairGeneratorSpi {
        public Sha2_128s() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_128s);
        }
    }

    public static class Sha2_192f extends SLHDSAKeyPairGeneratorSpi {
        public Sha2_192f() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_192f);
        }
    }

    public static class Sha2_192s extends SLHDSAKeyPairGeneratorSpi {
        public Sha2_192s() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_192s);
        }
    }

    public static class Sha2_256f extends SLHDSAKeyPairGeneratorSpi {
        public Sha2_256f() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_256f);
        }
    }

    public static class Sha2_256s extends SLHDSAKeyPairGeneratorSpi {
        public Sha2_256s() {
            super(SLHDSAParameterSpec.slh_dsa_sha2_256s);
        }
    }

    public static class Shake_128f extends SLHDSAKeyPairGeneratorSpi {
        public Shake_128f() {
            super(SLHDSAParameterSpec.slh_dsa_shake_128f);
        }
    }

    public static class Shake_128s extends SLHDSAKeyPairGeneratorSpi {
        public Shake_128s() {
            super(SLHDSAParameterSpec.slh_dsa_shake_128s);
        }
    }

    public static class Shake_192f extends SLHDSAKeyPairGeneratorSpi {
        public Shake_192f() {
            super(SLHDSAParameterSpec.slh_dsa_shake_192f);
        }
    }

    public static class Shake_192s extends SLHDSAKeyPairGeneratorSpi {
        public Shake_192s() {
            super(SLHDSAParameterSpec.slh_dsa_shake_192s);
        }
    }

    public static class Shake_256f extends SLHDSAKeyPairGeneratorSpi {
        public Shake_256f() {
            super(SLHDSAParameterSpec.slh_dsa_shake_256f);
        }
    }

    public static class Shake_256s extends SLHDSAKeyPairGeneratorSpi {
        public Shake_256s() {
            super(SLHDSAParameterSpec.slh_dsa_shake_256s);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(SLHDSAParameterSpec.slh_dsa_sha2_128f.m16213getName(), SLHDSAParameters.sha2_128f);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_128s.m16213getName(), SLHDSAParameters.sha2_128s);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_192f.m16213getName(), SLHDSAParameters.sha2_192f);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_192s.m16213getName(), SLHDSAParameters.sha2_192s);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_256f.m16213getName(), SLHDSAParameters.sha2_256f);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_256s.m16213getName(), SLHDSAParameters.sha2_256s);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_128f.m16213getName(), SLHDSAParameters.shake_128f);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_128s.m16213getName(), SLHDSAParameters.shake_128s);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_192f.m16213getName(), SLHDSAParameters.shake_192f);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_192s.m16213getName(), SLHDSAParameters.shake_192s);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_256f.m16213getName(), SLHDSAParameters.shake_256f);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_256s.m16213getName(), SLHDSAParameters.shake_256s);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_128f_with_sha256.m16213getName(), SLHDSAParameters.sha2_128f_with_sha256);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_128s_with_sha256.m16213getName(), SLHDSAParameters.sha2_128s_with_sha256);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_192f_with_sha512.m16213getName(), SLHDSAParameters.sha2_192f_with_sha512);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_192s_with_sha512.m16213getName(), SLHDSAParameters.sha2_192s_with_sha512);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_256f_with_sha512.m16213getName(), SLHDSAParameters.sha2_256f_with_sha512);
        parameters.put(SLHDSAParameterSpec.slh_dsa_sha2_256s_with_sha512.m16213getName(), SLHDSAParameters.sha2_256s_with_sha512);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_128f_with_shake128.m16213getName(), SLHDSAParameters.shake_128f_with_shake128);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_128s_with_shake128.m16213getName(), SLHDSAParameters.shake_128s_with_shake128);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_192f_with_shake256.m16213getName(), SLHDSAParameters.shake_192f_with_shake256);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_192s_with_shake256.m16213getName(), SLHDSAParameters.shake_192s_with_shake256);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_256f_with_shake256.m16213getName(), SLHDSAParameters.shake_256f_with_shake256);
        parameters.put(SLHDSAParameterSpec.slh_dsa_shake_256s_with_shake256.m16213getName(), SLHDSAParameters.shake_256s_with_shake256);
    }

    public SLHDSAKeyPairGeneratorSpi(String str) {
        super(str);
        this.f21624engine = new SLHDSAKeyPairGenerator();
        this.f21626random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof SLHDSAParameterSpec ? ((SLHDSAParameterSpec) algorithmParameterSpec).m16213getName() : C6250Strings.toUpperCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            this.f21625param = getAlgorithm().startsWith("HASH") ? new SLHDSAKeyGenerationParameters(this.f21626random, SLHDSAParameters.sha2_128f_with_sha256) : new SLHDSAKeyGenerationParameters(this.f21626random, SLHDSAParameters.sha2_128f);
            this.f21624engine.mo14944init(this.f21625param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21624engine.generateKeyPair();
        return new KeyPair(new BCSLHDSAPublicKey((SLHDSAPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCSLHDSAPrivateKey((SLHDSAPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public SLHDSAKeyPairGeneratorSpi(SLHDSAParameterSpec sLHDSAParameterSpec) {
        super("SLH-DSA-" + C6250Strings.toUpperCase(sLHDSAParameterSpec.m16213getName()));
        this.f21624engine = new SLHDSAKeyPairGenerator();
        SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom();
        this.f21626random = secureRandom;
        this.initialised = false;
        SLHDSAKeyGenerationParameters sLHDSAKeyGenerationParameters = new SLHDSAKeyGenerationParameters(secureRandom, (SLHDSAParameters) parameters.get(sLHDSAParameterSpec.m16213getName()));
        this.f21625param = sLHDSAKeyGenerationParameters;
        this.f21624engine.mo14944init(sLHDSAKeyGenerationParameters);
        this.initialised = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        SLHDSAParameters sLHDSAParameters = (SLHDSAParameters) parameters.get(nameFromParams);
        if (sLHDSAParameters == null) {
            throw new InvalidAlgorithmParameterException("unknown parameter set name: " + nameFromParams);
        }
        SLHDSAKeyGenerationParameters sLHDSAKeyGenerationParameters = new SLHDSAKeyGenerationParameters(secureRandom, sLHDSAParameters);
        this.f21625param = sLHDSAKeyGenerationParameters;
        this.f21624engine.mo14944init(sLHDSAKeyGenerationParameters);
        this.initialised = true;
    }
}
