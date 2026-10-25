package org.bouncycastle.p314pqc.p334jcajce.provider.p344ntru;

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
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class NTRUKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    NTRUKeyPairGenerator f23799engine;
    boolean initialised;

    /* renamed from: param */
    NTRUKeyGenerationParameters f23800param;

    /* renamed from: random */
    SecureRandom f23801random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(NTRUParameterSpec.ntruhps2048509.m18050getName(), NTRUParameters.ntruhps2048509);
        parameters.put(NTRUParameterSpec.ntruhps2048677.m18050getName(), NTRUParameters.ntruhps2048677);
        parameters.put(NTRUParameterSpec.ntruhps4096821.m18050getName(), NTRUParameters.ntruhps4096821);
        parameters.put(NTRUParameterSpec.ntruhps40961229.m18050getName(), NTRUParameters.ntruhps40961229);
        parameters.put(NTRUParameterSpec.ntruhrss701.m18050getName(), NTRUParameters.ntruhrss701);
        parameters.put(NTRUParameterSpec.ntruhrss1373.m18050getName(), NTRUParameters.ntruhrss1373);
    }

    public NTRUKeyPairGeneratorSpi() {
        super("NTRU");
        this.f23799engine = new NTRUKeyPairGenerator();
        this.f23801random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof NTRUParameterSpec ? ((NTRUParameterSpec) algorithmParameterSpec).m18050getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            NTRUKeyGenerationParameters nTRUKeyGenerationParameters = new NTRUKeyGenerationParameters(this.f23801random, NTRUParameters.ntruhps2048509);
            this.f23800param = nTRUKeyGenerationParameters;
            this.f23799engine.mo14944init(nTRUKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23799engine.generateKeyPair();
        return new KeyPair(new BCNTRUPublicKey((NTRUPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCNTRUPrivateKey((NTRUPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
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
        NTRUKeyGenerationParameters nTRUKeyGenerationParameters = new NTRUKeyGenerationParameters(secureRandom, (NTRUParameters) parameters.get(nameFromParams));
        this.f23800param = nTRUKeyGenerationParameters;
        this.f23799engine.mo14944init(nTRUKeyGenerationParameters);
        this.initialised = true;
    }
}
