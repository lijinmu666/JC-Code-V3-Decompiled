package org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon;

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
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FalconParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class FalconKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    FalconKeyPairGenerator f23734engine;
    private final FalconParameters falconParameters;
    boolean initialised;

    /* renamed from: param */
    FalconKeyGenerationParameters f23735param;

    /* renamed from: random */
    SecureRandom f23736random;

    public static class Falcon1024 extends FalconKeyPairGeneratorSpi {
        public Falcon1024() {
            super(FalconParameters.falcon_1024);
        }
    }

    public static class Falcon512 extends FalconKeyPairGeneratorSpi {
        public Falcon512() {
            super(FalconParameters.falcon_512);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(FalconParameterSpec.falcon_512.m18044getName(), FalconParameters.falcon_512);
        parameters.put(FalconParameterSpec.falcon_1024.m18044getName(), FalconParameters.falcon_1024);
    }

    public FalconKeyPairGeneratorSpi() {
        super("FALCON");
        this.f23734engine = new FalconKeyPairGenerator();
        this.f23736random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.falconParameters = null;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof FalconParameterSpec ? ((FalconParameterSpec) algorithmParameterSpec).m18044getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            FalconParameters falconParameters = this.falconParameters;
            if (falconParameters != null) {
                this.f23735param = new FalconKeyGenerationParameters(this.f23736random, falconParameters);
            } else {
                this.f23735param = new FalconKeyGenerationParameters(this.f23736random, FalconParameters.falcon_512);
            }
            this.f23734engine.mo14944init(this.f23735param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23734engine.generateKeyPair();
        return new KeyPair(new BCFalconPublicKey((FalconPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCFalconPrivateKey((FalconPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public FalconKeyPairGeneratorSpi(FalconParameters falconParameters) {
        super(falconParameters.m17549getName());
        this.f23734engine = new FalconKeyPairGenerator();
        this.f23736random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.falconParameters = falconParameters;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null || !parameters.containsKey(nameFromParams)) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        FalconParameters falconParameters = (FalconParameters) parameters.get(nameFromParams);
        this.f23735param = new FalconKeyGenerationParameters(secureRandom, falconParameters);
        if (this.falconParameters == null || falconParameters.m17549getName().equals(this.falconParameters.m17549getName())) {
            this.f23734engine.mo14944init(this.f23735param);
            this.initialised = true;
        } else {
            throw new InvalidAlgorithmParameterException("key pair generator locked to " + C6250Strings.toUpperCase(this.falconParameters.m17549getName()));
        }
    }
}
