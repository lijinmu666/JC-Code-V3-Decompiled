package org.bouncycastle.p314pqc.p334jcajce.provider.sphincsplus;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SPHINCSPlusParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusKeyGenerationParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusKeyPairGenerator;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPublicKeyParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SPHINCSPlusKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    SPHINCSPlusKeyPairGenerator f23870engine;
    boolean initialised;

    /* renamed from: param */
    SPHINCSPlusKeyGenerationParameters f23871param;

    /* renamed from: random */
    SecureRandom f23872random;

    public static class Sha2_128f extends SPHINCSPlusKeyPairGeneratorSpi {
        public Sha2_128f() {
            super(SPHINCSPlusParameterSpec.sha2_128f);
        }
    }

    public static class Sha2_128s extends SPHINCSPlusKeyPairGeneratorSpi {
        public Sha2_128s() {
            super(SPHINCSPlusParameterSpec.sha2_128s);
        }
    }

    public static class Sha2_192f extends SPHINCSPlusKeyPairGeneratorSpi {
        public Sha2_192f() {
            super(SPHINCSPlusParameterSpec.sha2_192f);
        }
    }

    public static class Sha2_192s extends SPHINCSPlusKeyPairGeneratorSpi {
        public Sha2_192s() {
            super(SPHINCSPlusParameterSpec.sha2_192s);
        }
    }

    public static class Sha2_256f extends SPHINCSPlusKeyPairGeneratorSpi {
        public Sha2_256f() {
            super(SPHINCSPlusParameterSpec.sha2_256f);
        }
    }

    public static class Sha2_256s extends SPHINCSPlusKeyPairGeneratorSpi {
        public Sha2_256s() {
            super(SPHINCSPlusParameterSpec.sha2_256s);
        }
    }

    public static class Shake_128f extends SPHINCSPlusKeyPairGeneratorSpi {
        public Shake_128f() {
            super(SPHINCSPlusParameterSpec.shake_128f);
        }
    }

    public static class Shake_128s extends SPHINCSPlusKeyPairGeneratorSpi {
        public Shake_128s() {
            super(SPHINCSPlusParameterSpec.shake_128s);
        }
    }

    public static class Shake_192f extends SPHINCSPlusKeyPairGeneratorSpi {
        public Shake_192f() {
            super(SPHINCSPlusParameterSpec.shake_192f);
        }
    }

    public static class Shake_192s extends SPHINCSPlusKeyPairGeneratorSpi {
        public Shake_192s() {
            super(SPHINCSPlusParameterSpec.shake_192s);
        }
    }

    public static class Shake_256f extends SPHINCSPlusKeyPairGeneratorSpi {
        public Shake_256f() {
            super(SPHINCSPlusParameterSpec.shake_256f);
        }
    }

    public static class Shake_256s extends SPHINCSPlusKeyPairGeneratorSpi {
        public Shake_256s() {
            super(SPHINCSPlusParameterSpec.shake_256s);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(SPHINCSPlusParameterSpec.sha2_128f_robust.m18055getName(), SPHINCSPlusParameters.sha2_128f_robust);
        parameters.put(SPHINCSPlusParameterSpec.sha2_128s_robust.m18055getName(), SPHINCSPlusParameters.sha2_128s_robust);
        parameters.put(SPHINCSPlusParameterSpec.sha2_192f_robust.m18055getName(), SPHINCSPlusParameters.sha2_192f_robust);
        parameters.put(SPHINCSPlusParameterSpec.sha2_192s_robust.m18055getName(), SPHINCSPlusParameters.sha2_192s_robust);
        parameters.put(SPHINCSPlusParameterSpec.sha2_256f_robust.m18055getName(), SPHINCSPlusParameters.sha2_256f_robust);
        parameters.put(SPHINCSPlusParameterSpec.sha2_256s_robust.m18055getName(), SPHINCSPlusParameters.sha2_256s_robust);
        parameters.put(SPHINCSPlusParameterSpec.sha2_128f.m18055getName(), SPHINCSPlusParameters.sha2_128f);
        parameters.put(SPHINCSPlusParameterSpec.sha2_128s.m18055getName(), SPHINCSPlusParameters.sha2_128s);
        parameters.put(SPHINCSPlusParameterSpec.sha2_192f.m18055getName(), SPHINCSPlusParameters.sha2_192f);
        parameters.put(SPHINCSPlusParameterSpec.sha2_192s.m18055getName(), SPHINCSPlusParameters.sha2_192s);
        parameters.put(SPHINCSPlusParameterSpec.sha2_256f.m18055getName(), SPHINCSPlusParameters.sha2_256f);
        parameters.put(SPHINCSPlusParameterSpec.sha2_256s.m18055getName(), SPHINCSPlusParameters.sha2_256s);
        parameters.put(SPHINCSPlusParameterSpec.shake_128f_robust.m18055getName(), SPHINCSPlusParameters.shake_128f_robust);
        parameters.put(SPHINCSPlusParameterSpec.shake_128s_robust.m18055getName(), SPHINCSPlusParameters.shake_128s_robust);
        parameters.put(SPHINCSPlusParameterSpec.shake_192f_robust.m18055getName(), SPHINCSPlusParameters.shake_192f_robust);
        parameters.put(SPHINCSPlusParameterSpec.shake_192s_robust.m18055getName(), SPHINCSPlusParameters.shake_192s_robust);
        parameters.put(SPHINCSPlusParameterSpec.shake_256f_robust.m18055getName(), SPHINCSPlusParameters.shake_256f_robust);
        parameters.put(SPHINCSPlusParameterSpec.shake_256s_robust.m18055getName(), SPHINCSPlusParameters.shake_256s_robust);
        parameters.put(SPHINCSPlusParameterSpec.shake_128f.m18055getName(), SPHINCSPlusParameters.shake_128f);
        parameters.put(SPHINCSPlusParameterSpec.shake_128s.m18055getName(), SPHINCSPlusParameters.shake_128s);
        parameters.put(SPHINCSPlusParameterSpec.shake_192f.m18055getName(), SPHINCSPlusParameters.shake_192f);
        parameters.put(SPHINCSPlusParameterSpec.shake_192s.m18055getName(), SPHINCSPlusParameters.shake_192s);
        parameters.put(SPHINCSPlusParameterSpec.shake_256f.m18055getName(), SPHINCSPlusParameters.shake_256f);
        parameters.put(SPHINCSPlusParameterSpec.shake_256s.m18055getName(), SPHINCSPlusParameters.shake_256s);
        parameters.put(SPHINCSPlusParameterSpec.haraka_128f.m18055getName(), SPHINCSPlusParameters.haraka_128f);
        parameters.put(SPHINCSPlusParameterSpec.haraka_128s.m18055getName(), SPHINCSPlusParameters.haraka_128s);
        parameters.put(SPHINCSPlusParameterSpec.haraka_192f.m18055getName(), SPHINCSPlusParameters.haraka_192f);
        parameters.put(SPHINCSPlusParameterSpec.haraka_192s.m18055getName(), SPHINCSPlusParameters.haraka_192s);
        parameters.put(SPHINCSPlusParameterSpec.haraka_256f.m18055getName(), SPHINCSPlusParameters.haraka_256f);
        parameters.put(SPHINCSPlusParameterSpec.haraka_256s.m18055getName(), SPHINCSPlusParameters.haraka_256s);
        parameters.put(SPHINCSPlusParameterSpec.haraka_128f_simple.m18055getName(), SPHINCSPlusParameters.haraka_128f_simple);
        parameters.put(SPHINCSPlusParameterSpec.haraka_128s_simple.m18055getName(), SPHINCSPlusParameters.haraka_128s_simple);
        parameters.put(SPHINCSPlusParameterSpec.haraka_192f_simple.m18055getName(), SPHINCSPlusParameters.haraka_192f_simple);
        parameters.put(SPHINCSPlusParameterSpec.haraka_192s_simple.m18055getName(), SPHINCSPlusParameters.haraka_192s_simple);
        parameters.put(SPHINCSPlusParameterSpec.haraka_256f_simple.m18055getName(), SPHINCSPlusParameters.haraka_256f_simple);
        parameters.put(SPHINCSPlusParameterSpec.haraka_256s_simple.m18055getName(), SPHINCSPlusParameters.haraka_256s_simple);
    }

    public SPHINCSPlusKeyPairGeneratorSpi() {
        super("SPHINCS+");
        this.f23870engine = new SPHINCSPlusKeyPairGenerator();
        this.f23872random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof SPHINCSPlusParameterSpec ? ((SPHINCSPlusParameterSpec) algorithmParameterSpec).m18055getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SPHINCSPlusKeyGenerationParameters sPHINCSPlusKeyGenerationParameters = new SPHINCSPlusKeyGenerationParameters(this.f23872random, SPHINCSPlusParameters.sha2_256s);
            this.f23871param = sPHINCSPlusKeyGenerationParameters;
            this.f23870engine.mo14944init(sPHINCSPlusKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23870engine.generateKeyPair();
        return new KeyPair(new BCSPHINCSPlusPublicKey((SPHINCSPlusPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCSPHINCSPlusPrivateKey((SPHINCSPlusPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public SPHINCSPlusKeyPairGeneratorSpi(SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec) {
        super("SPHINCS+-" + C6250Strings.toUpperCase(sPHINCSPlusParameterSpec.m18055getName()));
        this.f23870engine = new SPHINCSPlusKeyPairGenerator();
        SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom();
        this.f23872random = secureRandom;
        this.initialised = false;
        SPHINCSPlusKeyGenerationParameters sPHINCSPlusKeyGenerationParameters = new SPHINCSPlusKeyGenerationParameters(secureRandom, (SPHINCSPlusParameters) parameters.get(sPHINCSPlusParameterSpec.m18055getName()));
        this.f23871param = sPHINCSPlusKeyGenerationParameters;
        this.f23870engine.mo14944init(sPHINCSPlusKeyGenerationParameters);
        this.initialised = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        SPHINCSPlusKeyGenerationParameters sPHINCSPlusKeyGenerationParameters = new SPHINCSPlusKeyGenerationParameters(secureRandom, (SPHINCSPlusParameters) parameters.get(nameFromParams));
        this.f23871param = sPHINCSPlusKeyGenerationParameters;
        this.f23870engine.mo14944init(sPHINCSPlusKeyGenerationParameters);
        this.initialised = true;
    }
}
