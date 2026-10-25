package org.bouncycastle.p314pqc.p334jcajce.provider.p335bike;

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
import org.bouncycastle.p314pqc.p334jcajce.p351spec.BIKEParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEKeyGenerationParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEKeyPairGenerator;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPublicKeyParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BIKEKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    BIKEKeyPairGenerator f23709engine;
    boolean initialised;

    /* renamed from: param */
    BIKEKeyGenerationParameters f23710param;

    /* renamed from: random */
    SecureRandom f23711random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        BIKEParameters bIKEParameters = BIKEParameters.f23947bike128;
        map.put("bike128", bIKEParameters);
        Map map2 = parameters;
        BIKEParameters bIKEParameters2 = BIKEParameters.f23948bike192;
        map2.put("bike192", bIKEParameters2);
        Map map3 = parameters;
        BIKEParameters bIKEParameters3 = BIKEParameters.f23949bike256;
        map3.put("bike256", bIKEParameters3);
        parameters.put(BIKEParameterSpec.f23893bike128.m18041getName(), bIKEParameters);
        parameters.put(BIKEParameterSpec.f23894bike192.m18041getName(), bIKEParameters2);
        parameters.put(BIKEParameterSpec.f23895bike256.m18041getName(), bIKEParameters3);
    }

    public BIKEKeyPairGeneratorSpi() {
        super("BIKE");
        this.f23709engine = new BIKEKeyPairGenerator();
        this.f23711random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof BIKEParameterSpec ? ((BIKEParameterSpec) algorithmParameterSpec).m18041getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            BIKEKeyGenerationParameters bIKEKeyGenerationParameters = new BIKEKeyGenerationParameters(this.f23711random, BIKEParameters.f23947bike128);
            this.f23710param = bIKEKeyGenerationParameters;
            this.f23709engine.mo14944init(bIKEKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23709engine.generateKeyPair();
        return new KeyPair(new BCBIKEPublicKey((BIKEPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCBIKEPrivateKey((BIKEPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
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
        BIKEKeyGenerationParameters bIKEKeyGenerationParameters = new BIKEKeyGenerationParameters(secureRandom, (BIKEParameters) parameters.get(nameFromParams));
        this.f23710param = bIKEKeyGenerationParameters;
        this.f23709engine.mo14944init(bIKEKeyGenerationParameters);
        this.initialised = true;
    }
}
