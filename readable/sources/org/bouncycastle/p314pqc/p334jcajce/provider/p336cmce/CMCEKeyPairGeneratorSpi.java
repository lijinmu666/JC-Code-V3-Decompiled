package org.bouncycastle.p314pqc.p334jcajce.provider.p336cmce;

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
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.CMCEParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class CMCEKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    CMCEKeyPairGenerator f23719engine;
    boolean initialised;

    /* renamed from: param */
    CMCEKeyGenerationParameters f23720param;

    /* renamed from: random */
    SecureRandom f23721random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(CMCEParameterSpec.mceliece348864.m18042getName(), CMCEParameters.mceliece348864r3);
        parameters.put(CMCEParameterSpec.mceliece348864f.m18042getName(), CMCEParameters.mceliece348864fr3);
        parameters.put(CMCEParameterSpec.mceliece460896.m18042getName(), CMCEParameters.mceliece460896r3);
        parameters.put(CMCEParameterSpec.mceliece460896f.m18042getName(), CMCEParameters.mceliece460896fr3);
        parameters.put(CMCEParameterSpec.mceliece6688128.m18042getName(), CMCEParameters.mceliece6688128r3);
        parameters.put(CMCEParameterSpec.mceliece6688128f.m18042getName(), CMCEParameters.mceliece6688128fr3);
        parameters.put(CMCEParameterSpec.mceliece6960119.m18042getName(), CMCEParameters.mceliece6960119r3);
        parameters.put(CMCEParameterSpec.mceliece6960119f.m18042getName(), CMCEParameters.mceliece6960119fr3);
        parameters.put(CMCEParameterSpec.mceliece8192128.m18042getName(), CMCEParameters.mceliece8192128r3);
        parameters.put(CMCEParameterSpec.mceliece8192128f.m18042getName(), CMCEParameters.mceliece8192128fr3);
    }

    public CMCEKeyPairGeneratorSpi() {
        super("CMCE");
        this.f23719engine = new CMCEKeyPairGenerator();
        this.f23721random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof CMCEParameterSpec ? ((CMCEParameterSpec) algorithmParameterSpec).m18042getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            CMCEKeyGenerationParameters cMCEKeyGenerationParameters = new CMCEKeyGenerationParameters(this.f23721random, CMCEParameters.mceliece8192128fr3);
            this.f23720param = cMCEKeyGenerationParameters;
            this.f23719engine.mo14944init(cMCEKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23719engine.generateKeyPair();
        return new KeyPair(new BCCMCEPublicKey((CMCEPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCCMCEPrivateKey((CMCEPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
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
        CMCEKeyGenerationParameters cMCEKeyGenerationParameters = new CMCEKeyGenerationParameters(secureRandom, (CMCEParameters) parameters.get(nameFromParams));
        this.f23720param = cMCEKeyGenerationParameters;
        this.f23719engine.mo14944init(cMCEKeyGenerationParameters);
        this.initialised = true;
    }
}
