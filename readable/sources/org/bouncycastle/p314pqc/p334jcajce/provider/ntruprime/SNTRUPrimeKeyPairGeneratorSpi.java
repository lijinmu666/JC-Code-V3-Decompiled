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
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimeKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimeKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimeParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SNTRUPrimeParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SNTRUPrimeKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    SNTRUPrimeKeyPairGenerator f23830engine;
    boolean initialised;

    /* renamed from: param */
    SNTRUPrimeKeyGenerationParameters f23831param;

    /* renamed from: random */
    SecureRandom f23832random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(SNTRUPrimeParameterSpec.sntrup653.m18054getName(), SNTRUPrimeParameters.sntrup653);
        parameters.put(SNTRUPrimeParameterSpec.sntrup761.m18054getName(), SNTRUPrimeParameters.sntrup761);
        parameters.put(SNTRUPrimeParameterSpec.sntrup857.m18054getName(), SNTRUPrimeParameters.sntrup857);
        parameters.put(SNTRUPrimeParameterSpec.sntrup953.m18054getName(), SNTRUPrimeParameters.sntrup953);
        parameters.put(SNTRUPrimeParameterSpec.sntrup1013.m18054getName(), SNTRUPrimeParameters.sntrup1013);
        parameters.put(SNTRUPrimeParameterSpec.sntrup1277.m18054getName(), SNTRUPrimeParameters.sntrup1277);
    }

    public SNTRUPrimeKeyPairGeneratorSpi() {
        super("SNTRUPrime");
        this.f23830engine = new SNTRUPrimeKeyPairGenerator();
        this.f23832random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof SNTRUPrimeParameterSpec ? ((SNTRUPrimeParameterSpec) algorithmParameterSpec).m18054getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SNTRUPrimeKeyGenerationParameters sNTRUPrimeKeyGenerationParameters = new SNTRUPrimeKeyGenerationParameters(this.f23832random, SNTRUPrimeParameters.sntrup953);
            this.f23831param = sNTRUPrimeKeyGenerationParameters;
            this.f23830engine.mo14944init(sNTRUPrimeKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23830engine.generateKeyPair();
        return new KeyPair(new BCSNTRUPrimePublicKey((SNTRUPrimePublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCSNTRUPrimePrivateKey((SNTRUPrimePrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
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
        SNTRUPrimeKeyGenerationParameters sNTRUPrimeKeyGenerationParameters = new SNTRUPrimeKeyGenerationParameters(secureRandom, (SNTRUPrimeParameters) parameters.get(nameFromParams));
        this.f23831param = sNTRUPrimeKeyGenerationParameters;
        this.f23830engine.mo14944init(sNTRUPrimeKeyGenerationParameters);
        this.initialised = true;
    }
}
