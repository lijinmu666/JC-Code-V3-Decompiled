package org.bouncycastle.p314pqc.p334jcajce.provider.p338frodo;

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
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FrodoParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class FrodoKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    FrodoKeyPairGenerator f23747engine;
    boolean initialised;

    /* renamed from: param */
    FrodoKeyGenerationParameters f23748param;

    /* renamed from: random */
    SecureRandom f23749random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        FrodoParameters frodoParameters = FrodoParameters.frodokem640aes;
        map.put("frodokem19888r3", frodoParameters);
        Map map2 = parameters;
        FrodoParameters frodoParameters2 = FrodoParameters.frodokem640shake;
        map2.put("frodokem19888shaker3", frodoParameters2);
        Map map3 = parameters;
        FrodoParameters frodoParameters3 = FrodoParameters.frodokem976aes;
        map3.put("frodokem31296r3", frodoParameters3);
        Map map4 = parameters;
        FrodoParameters frodoParameters4 = FrodoParameters.frodokem976shake;
        map4.put("frodokem31296shaker3", frodoParameters4);
        Map map5 = parameters;
        FrodoParameters frodoParameters5 = FrodoParameters.frodokem1344aes;
        map5.put("frodokem43088r3", frodoParameters5);
        Map map6 = parameters;
        FrodoParameters frodoParameters6 = FrodoParameters.frodokem1344shake;
        map6.put("frodokem43088shaker3", frodoParameters6);
        parameters.put(FrodoParameterSpec.frodokem640aes.m18045getName(), frodoParameters);
        parameters.put(FrodoParameterSpec.frodokem640shake.m18045getName(), frodoParameters2);
        parameters.put(FrodoParameterSpec.frodokem976aes.m18045getName(), frodoParameters3);
        parameters.put(FrodoParameterSpec.frodokem976shake.m18045getName(), frodoParameters4);
        parameters.put(FrodoParameterSpec.frodokem1344aes.m18045getName(), frodoParameters5);
        parameters.put(FrodoParameterSpec.frodokem1344shake.m18045getName(), frodoParameters6);
    }

    public FrodoKeyPairGeneratorSpi() {
        super("Frodo");
        this.f23747engine = new FrodoKeyPairGenerator();
        this.f23749random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof FrodoParameterSpec ? ((FrodoParameterSpec) algorithmParameterSpec).m18045getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            FrodoKeyGenerationParameters frodoKeyGenerationParameters = new FrodoKeyGenerationParameters(this.f23749random, FrodoParameters.frodokem1344shake);
            this.f23748param = frodoKeyGenerationParameters;
            this.f23747engine.mo14944init(frodoKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23747engine.generateKeyPair();
        return new KeyPair(new BCFrodoPublicKey((FrodoPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCFrodoPrivateKey((FrodoPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        FrodoKeyGenerationParameters frodoKeyGenerationParameters = new FrodoKeyGenerationParameters(secureRandom, (FrodoParameters) parameters.get(nameFromParams));
        this.f23748param = frodoKeyGenerationParameters;
        this.f23747engine.mo14944init(frodoKeyGenerationParameters);
        this.initialised = true;
    }
}
