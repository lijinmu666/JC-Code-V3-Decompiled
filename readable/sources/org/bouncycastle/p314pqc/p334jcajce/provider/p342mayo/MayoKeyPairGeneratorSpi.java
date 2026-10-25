package org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo;

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
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.MayoParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class MayoKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    MayoKeyPairGenerator f23781engine;
    boolean initialised;
    private MayoParameters mayoParameters;

    /* renamed from: param */
    MayoKeyGenerationParameters f23782param;

    /* renamed from: random */
    SecureRandom f23783random;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo1 */
    public static class C6193Mayo1 extends MayoKeyPairGeneratorSpi {
        public C6193Mayo1() {
            super(MayoParameters.f23275mayo1);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo2 */
    public static class C6194Mayo2 extends MayoKeyPairGeneratorSpi {
        public C6194Mayo2() {
            super(MayoParameters.f23276mayo2);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo3 */
    public static class C6195Mayo3 extends MayoKeyPairGeneratorSpi {
        public C6195Mayo3() {
            super(MayoParameters.f23277mayo3);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.MayoKeyPairGeneratorSpi$Mayo5 */
    public static class C6196Mayo5 extends MayoKeyPairGeneratorSpi {
        public C6196Mayo5() {
            super(MayoParameters.f23278mayo5);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        MayoParameters mayoParameters = MayoParameters.f23275mayo1;
        map.put("MAYO_1", mayoParameters);
        Map map2 = parameters;
        MayoParameters mayoParameters2 = MayoParameters.f23276mayo2;
        map2.put("MAYO_2", mayoParameters2);
        Map map3 = parameters;
        MayoParameters mayoParameters3 = MayoParameters.f23277mayo3;
        map3.put("MAYO_3", mayoParameters3);
        Map map4 = parameters;
        MayoParameters mayoParameters4 = MayoParameters.f23278mayo5;
        map4.put("MAYO_5", mayoParameters4);
        parameters.put(MayoParameterSpec.f23908mayo1.m18048getName(), mayoParameters);
        parameters.put(MayoParameterSpec.f23909mayo2.m18048getName(), mayoParameters2);
        parameters.put(MayoParameterSpec.f23910mayo3.m18048getName(), mayoParameters3);
        parameters.put(MayoParameterSpec.f23911mayo5.m18048getName(), mayoParameters4);
    }

    public MayoKeyPairGeneratorSpi() {
        super("Mayo");
        this.f23781engine = new MayoKeyPairGenerator();
        this.f23783random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof MayoParameterSpec ? ((MayoParameterSpec) algorithmParameterSpec).m18048getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            MayoKeyGenerationParameters mayoKeyGenerationParameters = new MayoKeyGenerationParameters(this.f23783random, MayoParameters.f23275mayo1);
            this.f23782param = mayoKeyGenerationParameters;
            this.f23781engine.mo14944init(mayoKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23781engine.generateKeyPair();
        return new KeyPair(new BCMayoPublicKey((MayoPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCMayoPrivateKey((MayoPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public MayoKeyPairGeneratorSpi(MayoParameters mayoParameters) {
        super(mayoParameters.m17670getName());
        this.f23781engine = new MayoKeyPairGenerator();
        this.f23783random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.mayoParameters = mayoParameters;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        MayoKeyGenerationParameters mayoKeyGenerationParameters = new MayoKeyGenerationParameters(secureRandom, (MayoParameters) parameters.get(nameFromParams));
        this.f23782param = mayoKeyGenerationParameters;
        this.f23781engine.mo14944init(mayoKeyGenerationParameters);
        this.initialised = true;
    }
}
