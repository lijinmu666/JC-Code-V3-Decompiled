package org.bouncycastle.p314pqc.p334jcajce.provider.ntruplus;

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
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUPlusParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class NTRUPlusKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    NTRUPlusKeyPairGenerator f23810engine;
    boolean initialised;
    private final NTRUPlusParameters ntruplusParameters;

    /* renamed from: param */
    NTRUPlusKeyGenerationParameters f23811param;

    /* renamed from: random */
    SecureRandom f23812random;

    public static class NTRUPlus1152 extends NTRUPlusKeyPairGeneratorSpi {
        public NTRUPlus1152() {
            super(NTRUPlusParameters.ntruplus_kem_864);
        }
    }

    public static class NTRUPlus768 extends NTRUPlusKeyPairGeneratorSpi {
        public NTRUPlus768() {
            super(NTRUPlusParameters.ntruplus_kem_768);
        }
    }

    public static class NTRUPlus864 extends NTRUPlusKeyPairGeneratorSpi {
        public NTRUPlus864() {
            super(NTRUPlusParameters.ntruplus_kem_864);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(NTRUPlusParameterSpec.ntruplus_768.m18051getName(), NTRUPlusParameters.ntruplus_kem_768);
        parameters.put(NTRUPlusParameterSpec.ntruplus_864.m18051getName(), NTRUPlusParameters.ntruplus_kem_864);
        parameters.put(NTRUPlusParameterSpec.ntruplus_1152.m18051getName(), NTRUPlusParameters.ntruplus_kem_1152);
    }

    public NTRUPlusKeyPairGeneratorSpi() {
        super("NTRUPLUS");
        this.f23810engine = new NTRUPlusKeyPairGenerator();
        this.f23812random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.ntruplusParameters = null;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof NTRUPlusParameterSpec ? ((NTRUPlusParameterSpec) algorithmParameterSpec).m18051getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            NTRUPlusParameters nTRUPlusParameters = this.ntruplusParameters;
            if (nTRUPlusParameters != null) {
                this.f23811param = new NTRUPlusKeyGenerationParameters(this.f23812random, nTRUPlusParameters);
            } else {
                this.f23811param = new NTRUPlusKeyGenerationParameters(this.f23812random, NTRUPlusParameters.ntruplus_kem_768);
            }
            this.f23810engine.mo14944init(this.f23811param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23810engine.generateKeyPair();
        return new KeyPair(new BCNTRUPlusPublicKey((NTRUPlusPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCNTRUPlusPrivateKey((NTRUPlusPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public NTRUPlusKeyPairGeneratorSpi(NTRUPlusParameters nTRUPlusParameters) {
        super(nTRUPlusParameters.m17775getName());
        this.f23810engine = new NTRUPlusKeyPairGenerator();
        this.f23812random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.ntruplusParameters = nTRUPlusParameters;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null || !parameters.containsKey(nameFromParams)) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        NTRUPlusParameters nTRUPlusParameters = (NTRUPlusParameters) parameters.get(nameFromParams);
        this.f23811param = new NTRUPlusKeyGenerationParameters(secureRandom, nTRUPlusParameters);
        if (this.ntruplusParameters == null || nTRUPlusParameters.m17775getName().equals(this.ntruplusParameters.m17775getName())) {
            this.f23810engine.mo14944init(this.f23811param);
            this.initialised = true;
        } else {
            throw new InvalidAlgorithmParameterException("key pair generator locked to " + C6250Strings.toUpperCase(this.ntruplusParameters.m17775getName()));
        }
    }
}
