package org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc;

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
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.HQCParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class HQCKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    HQCKeyPairGenerator f23758engine;
    boolean initialised;

    /* renamed from: param */
    HQCKeyGenerationParameters f23759param;

    /* renamed from: random */
    SecureRandom f23760random;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi$HQC128 */
    public static class C6184HQC128 extends HQCKeyPairGeneratorSpi {
        public C6184HQC128() {
            super(HQCParameterSpec.f23901hqc128);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi$HQC192 */
    public static class C6185HQC192 extends HQCKeyPairGeneratorSpi {
        public C6185HQC192() {
            super(HQCParameterSpec.f23902hqc192);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyPairGeneratorSpi$HQC256 */
    public static class C6186HQC256 extends HQCKeyPairGeneratorSpi {
        public C6186HQC256() {
            super(HQCParameterSpec.f23903hqc256);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        HQCParameters hQCParameters = HQCParameters.f23200hqc128;
        map.put("hqc-128", hQCParameters);
        Map map2 = parameters;
        HQCParameters hQCParameters2 = HQCParameters.f23201hqc192;
        map2.put("hqc-192", hQCParameters2);
        Map map3 = parameters;
        HQCParameters hQCParameters3 = HQCParameters.f23202hqc256;
        map3.put("hqc-256", hQCParameters3);
        parameters.put(HQCParameterSpec.f23901hqc128.m18046getName(), hQCParameters);
        parameters.put(HQCParameterSpec.f23902hqc192.m18046getName(), hQCParameters2);
        parameters.put(HQCParameterSpec.f23903hqc256.m18046getName(), hQCParameters3);
    }

    public HQCKeyPairGeneratorSpi() {
        super("HQC");
        this.f23758engine = new HQCKeyPairGenerator();
        this.f23760random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof HQCParameterSpec ? ((HQCParameterSpec) algorithmParameterSpec).m18046getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            HQCKeyGenerationParameters hQCKeyGenerationParameters = new HQCKeyGenerationParameters(this.f23760random, HQCParameters.f23200hqc128);
            this.f23759param = hQCKeyGenerationParameters;
            this.f23758engine.mo14944init(hQCKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23758engine.generateKeyPair();
        return new KeyPair(new BCHQCPublicKey((HQCPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCHQCPrivateKey((HQCPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public HQCKeyPairGeneratorSpi(HQCParameterSpec hQCParameterSpec) {
        super(C6250Strings.toUpperCase(hQCParameterSpec.m18046getName()));
        this.f23758engine = new HQCKeyPairGenerator();
        this.f23760random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        HQCKeyGenerationParameters hQCKeyGenerationParameters = new HQCKeyGenerationParameters(secureRandom, (HQCParameters) parameters.get(nameFromParams));
        this.f23759param = hQCKeyGenerationParameters;
        this.f23758engine.mo14944init(hQCKeyGenerationParameters);
        this.initialised = true;
    }
}
