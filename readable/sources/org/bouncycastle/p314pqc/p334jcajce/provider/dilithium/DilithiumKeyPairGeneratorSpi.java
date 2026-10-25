package org.bouncycastle.p314pqc.p334jcajce.provider.dilithium;

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
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.DilithiumParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class DilithiumKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;
    private final DilithiumParameters dilithiumParameters;

    /* renamed from: engine */
    DilithiumKeyPairGenerator f23725engine;
    boolean initialised;

    /* renamed from: param */
    DilithiumKeyGenerationParameters f23726param;

    /* renamed from: random */
    SecureRandom f23727random;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi$Base2 */
    public static class C6165Base2 extends DilithiumKeyPairGeneratorSpi {
        public C6165Base2() {
            super(DilithiumParameters.dilithium2);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi$Base3 */
    public static class C6166Base3 extends DilithiumKeyPairGeneratorSpi {
        public C6166Base3() {
            super(DilithiumParameters.dilithium3);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.DilithiumKeyPairGeneratorSpi$Base5 */
    public static class C6167Base5 extends DilithiumKeyPairGeneratorSpi {
        public C6167Base5() {
            super(DilithiumParameters.dilithium5);
        }
    }

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(DilithiumParameterSpec.dilithium2.m18043getName(), DilithiumParameters.dilithium2);
        parameters.put(DilithiumParameterSpec.dilithium3.m18043getName(), DilithiumParameters.dilithium3);
        parameters.put(DilithiumParameterSpec.dilithium5.m18043getName(), DilithiumParameters.dilithium5);
    }

    public DilithiumKeyPairGeneratorSpi() {
        super("DILITHIUM");
        this.f23725engine = new DilithiumKeyPairGenerator();
        this.f23727random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.dilithiumParameters = null;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof DilithiumParameterSpec ? ((DilithiumParameterSpec) algorithmParameterSpec).m18043getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            DilithiumParameters dilithiumParameters = this.dilithiumParameters;
            if (dilithiumParameters != null) {
                this.f23726param = new DilithiumKeyGenerationParameters(this.f23727random, dilithiumParameters);
            } else {
                this.f23726param = new DilithiumKeyGenerationParameters(this.f23727random, DilithiumParameters.dilithium3);
            }
            this.f23725engine.mo14944init(this.f23726param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23725engine.generateKeyPair();
        return new KeyPair(new BCDilithiumPublicKey((DilithiumPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCDilithiumPrivateKey((DilithiumPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public DilithiumKeyPairGeneratorSpi(DilithiumParameters dilithiumParameters) {
        super(C6250Strings.toUpperCase(dilithiumParameters.m17515getName()));
        this.f23725engine = new DilithiumKeyPairGenerator();
        this.f23727random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
        this.dilithiumParameters = dilithiumParameters;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null || !parameters.containsKey(nameFromParams)) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        DilithiumParameters dilithiumParameters = (DilithiumParameters) parameters.get(nameFromParams);
        this.f23726param = new DilithiumKeyGenerationParameters(secureRandom, dilithiumParameters);
        if (this.dilithiumParameters == null || dilithiumParameters.m17515getName().equals(this.dilithiumParameters.m17515getName())) {
            this.f23725engine.mo14944init(this.f23726param);
            this.initialised = true;
        } else {
            throw new InvalidAlgorithmParameterException("key pair generator locked to " + C6250Strings.toUpperCase(this.dilithiumParameters.m17515getName()));
        }
    }
}
