package org.bouncycastle.p249jcajce.provider.asymmetric.p252dsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.DSAKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.DSAParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p213params.DSAKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DSAParameterGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DSAPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PrimeCertaintyCalculator;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    DSAKeyPairGenerator f21459engine;
    boolean initialised;

    /* renamed from: param */
    DSAKeyGenerationParameters f21460param;

    /* renamed from: random */
    SecureRandom f21461random;
    int strength;

    /* renamed from: params */
    private static Hashtable f21458params = new Hashtable();

    /* renamed from: lock */
    private static Object f21457lock = new Object();

    public KeyPairGeneratorSpi() {
        super("DSA");
        this.f21459engine = new DSAKeyPairGenerator();
        this.strength = 2048;
        this.f21461random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        DSAParametersGenerator dSAParametersGenerator;
        int i;
        SecureRandom secureRandom;
        if (!this.initialised) {
            Integer numM18296valueOf = Integers.m18296valueOf(this.strength);
            if (f21458params.containsKey(numM18296valueOf)) {
                this.f21460param = (DSAKeyGenerationParameters) f21458params.get(numM18296valueOf);
            } else {
                synchronized (f21457lock) {
                    try {
                        if (f21458params.containsKey(numM18296valueOf)) {
                            this.f21460param = (DSAKeyGenerationParameters) f21458params.get(numM18296valueOf);
                        } else {
                            int defaultCertainty = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
                            int i2 = this.strength;
                            if (i2 == 1024) {
                                dSAParametersGenerator = new DSAParametersGenerator();
                                if (Properties.isOverrideSet("org.bouncycastle.dsa.FIPS186-2for1024bits")) {
                                    i = this.strength;
                                    secureRandom = this.f21461random;
                                    dSAParametersGenerator.m15490init(i, defaultCertainty, secureRandom);
                                    DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(this.f21461random, dSAParametersGenerator.generateParameters());
                                    this.f21460param = dSAKeyGenerationParameters;
                                    f21458params.put(numM18296valueOf, dSAKeyGenerationParameters);
                                } else {
                                    dSAParametersGenerator.m15491init(new DSAParameterGenerationParameters(1024, 160, defaultCertainty, this.f21461random));
                                    DSAKeyGenerationParameters dSAKeyGenerationParameters2 = new DSAKeyGenerationParameters(this.f21461random, dSAParametersGenerator.generateParameters());
                                    this.f21460param = dSAKeyGenerationParameters2;
                                    f21458params.put(numM18296valueOf, dSAKeyGenerationParameters2);
                                }
                            } else if (i2 > 1024) {
                                DSAParameterGenerationParameters dSAParameterGenerationParameters = new DSAParameterGenerationParameters(i2, 256, defaultCertainty, this.f21461random);
                                dSAParametersGenerator = new DSAParametersGenerator(SHA256Digest.newInstance());
                                dSAParametersGenerator.m15491init(dSAParameterGenerationParameters);
                                DSAKeyGenerationParameters dSAKeyGenerationParameters22 = new DSAKeyGenerationParameters(this.f21461random, dSAParametersGenerator.generateParameters());
                                this.f21460param = dSAKeyGenerationParameters22;
                                f21458params.put(numM18296valueOf, dSAKeyGenerationParameters22);
                            } else {
                                dSAParametersGenerator = new DSAParametersGenerator();
                                i = this.strength;
                                secureRandom = this.f21461random;
                                dSAParametersGenerator.m15490init(i, defaultCertainty, secureRandom);
                                DSAKeyGenerationParameters dSAKeyGenerationParameters222 = new DSAKeyGenerationParameters(this.f21461random, dSAParametersGenerator.generateParameters());
                                this.f21460param = dSAKeyGenerationParameters222;
                                f21458params.put(numM18296valueOf, dSAKeyGenerationParameters222);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f21459engine.mo14944init(this.f21460param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21459engine.generateKeyPair();
        return new KeyPair(new BCDSAPublicKey((DSAPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCDSAPrivateKey((DSAPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        boolean z;
        if (i < 512 || i > 4096 || ((i < 1024 && i % 64 != 0) || (i >= 1024 && i % 1024 != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        DSAParameterSpec dSADefaultParameters = BouncyCastleProvider.CONFIGURATION.getDSADefaultParameters(i);
        if (dSADefaultParameters != null) {
            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSADefaultParameters.getP(), dSADefaultParameters.getQ(), dSADefaultParameters.getG()));
            this.f21460param = dSAKeyGenerationParameters;
            this.f21459engine.mo14944init(dSAKeyGenerationParameters);
            z = true;
        } else {
            this.strength = i;
            this.f21461random = secureRandom;
            z = false;
        }
        this.initialised = z;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
        }
        DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
        DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
        this.f21460param = dSAKeyGenerationParameters;
        this.f21459engine.mo14944init(dSAKeyGenerationParameters);
        this.initialised = true;
    }
}
