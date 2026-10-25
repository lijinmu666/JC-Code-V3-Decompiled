package org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime;

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
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRULPRimeParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class NTRULPRimeKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    NTRULPRimeKeyPairGenerator f23822engine;
    boolean initialised;

    /* renamed from: param */
    NTRULPRimeKeyGenerationParameters f23823param;

    /* renamed from: random */
    SecureRandom f23824random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(NTRULPRimeParameterSpec.ntrulpr653.m18049getName(), NTRULPRimeParameters.ntrulpr653);
        parameters.put(NTRULPRimeParameterSpec.ntrulpr761.m18049getName(), NTRULPRimeParameters.ntrulpr761);
        parameters.put(NTRULPRimeParameterSpec.ntrulpr857.m18049getName(), NTRULPRimeParameters.ntrulpr857);
        parameters.put(NTRULPRimeParameterSpec.ntrulpr953.m18049getName(), NTRULPRimeParameters.ntrulpr953);
        parameters.put(NTRULPRimeParameterSpec.ntrulpr1013.m18049getName(), NTRULPRimeParameters.ntrulpr1013);
        parameters.put(NTRULPRimeParameterSpec.ntrulpr1277.m18049getName(), NTRULPRimeParameters.ntrulpr1277);
    }

    public NTRULPRimeKeyPairGeneratorSpi() {
        super("NTRULPRime");
        this.f23822engine = new NTRULPRimeKeyPairGenerator();
        this.f23824random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof NTRULPRimeParameterSpec ? ((NTRULPRimeParameterSpec) algorithmParameterSpec).m18049getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            NTRULPRimeKeyGenerationParameters nTRULPRimeKeyGenerationParameters = new NTRULPRimeKeyGenerationParameters(this.f23824random, NTRULPRimeParameters.ntrulpr953);
            this.f23823param = nTRULPRimeKeyGenerationParameters;
            this.f23822engine.mo14944init(nTRULPRimeKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23822engine.generateKeyPair();
        return new KeyPair(new BCNTRULPRimePublicKey((NTRULPRimePublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCNTRULPRimePrivateKey((NTRULPRimePrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
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
        NTRULPRimeKeyGenerationParameters nTRULPRimeKeyGenerationParameters = new NTRULPRimeKeyGenerationParameters(secureRandom, (NTRULPRimeParameters) parameters.get(nameFromParams));
        this.f23823param = nTRULPRimeKeyGenerationParameters;
        this.f23822engine.mo14944init(nTRULPRimeKeyGenerationParameters);
        this.initialised = true;
    }
}
