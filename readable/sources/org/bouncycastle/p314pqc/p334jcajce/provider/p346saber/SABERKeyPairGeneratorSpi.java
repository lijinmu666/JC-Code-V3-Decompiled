package org.bouncycastle.p314pqc.p334jcajce.provider.p346saber;

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
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SABERParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SABERKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    SABERKeyPairGenerator f23848engine;
    boolean initialised;

    /* renamed from: param */
    SABERKeyGenerationParameters f23849param;

    /* renamed from: random */
    SecureRandom f23850random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(SABERParameterSpec.lightsaberkem128r3.m18053getName(), SABERParameters.lightsaberkem128r3);
        parameters.put(SABERParameterSpec.saberkem128r3.m18053getName(), SABERParameters.saberkem128r3);
        parameters.put(SABERParameterSpec.firesaberkem128r3.m18053getName(), SABERParameters.firesaberkem128r3);
        parameters.put(SABERParameterSpec.lightsaberkem192r3.m18053getName(), SABERParameters.lightsaberkem192r3);
        parameters.put(SABERParameterSpec.saberkem192r3.m18053getName(), SABERParameters.saberkem192r3);
        parameters.put(SABERParameterSpec.firesaberkem192r3.m18053getName(), SABERParameters.firesaberkem192r3);
        parameters.put(SABERParameterSpec.lightsaberkem256r3.m18053getName(), SABERParameters.lightsaberkem256r3);
        parameters.put(SABERParameterSpec.saberkem256r3.m18053getName(), SABERParameters.saberkem256r3);
        parameters.put(SABERParameterSpec.firesaberkem256r3.m18053getName(), SABERParameters.firesaberkem256r3);
    }

    public SABERKeyPairGeneratorSpi() {
        super("SABER");
        this.f23848engine = new SABERKeyPairGenerator();
        this.f23850random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof SABERParameterSpec ? ((SABERParameterSpec) algorithmParameterSpec).m18053getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SABERKeyGenerationParameters sABERKeyGenerationParameters = new SABERKeyGenerationParameters(this.f23850random, SABERParameters.firesaberkem256r3);
            this.f23849param = sABERKeyGenerationParameters;
            this.f23848engine.mo14944init(sABERKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23848engine.generateKeyPair();
        return new KeyPair(new BCSABERPublicKey((SABERPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCSABERPrivateKey((SABERPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
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
        SABERKeyGenerationParameters sABERKeyGenerationParameters = new SABERKeyGenerationParameters(secureRandom, (SABERParameters) parameters.get(nameFromParams));
        this.f23849param = sABERKeyGenerationParameters;
        this.f23848engine.mo14944init(sABERKeyGenerationParameters);
        this.initialised = true;
    }
}
