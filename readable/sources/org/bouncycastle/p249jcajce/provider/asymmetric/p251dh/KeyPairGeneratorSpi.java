package org.bouncycastle.p249jcajce.provider.asymmetric.p251dh;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.DHParametersGenerator;
import org.bouncycastle.p194crypto.p213params.DHKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.DHDomainParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PrimeCertaintyCalculator;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    DHBasicKeyPairGenerator f21441engine;
    boolean initialised;

    /* renamed from: param */
    DHKeyGenerationParameters f21442param;

    /* renamed from: random */
    SecureRandom f21443random;
    int strength;

    /* renamed from: params */
    private static Hashtable f21440params = new Hashtable();

    /* renamed from: lock */
    private static Object f21439lock = new Object();

    public KeyPairGeneratorSpi() {
        super("DH");
        this.f21441engine = new DHBasicKeyPairGenerator();
        this.strength = 2048;
        this.f21443random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private DHKeyGenerationParameters convertParams(SecureRandom secureRandom, DHParameterSpec dHParameterSpec) {
        return dHParameterSpec instanceof DHDomainParameterSpec ? new DHKeyGenerationParameters(secureRandom, ((DHDomainParameterSpec) dHParameterSpec).getDomainParameters()) : new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), null, dHParameterSpec.getL()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        DHKeyGenerationParameters dHKeyGenerationParametersConvertParams;
        if (!this.initialised) {
            Integer numM18296valueOf = Integers.m18296valueOf(this.strength);
            if (f21440params.containsKey(numM18296valueOf)) {
                dHKeyGenerationParametersConvertParams = (DHKeyGenerationParameters) f21440params.get(numM18296valueOf);
            } else {
                DHParameterSpec dHDefaultParameters = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
                if (dHDefaultParameters != null) {
                    dHKeyGenerationParametersConvertParams = convertParams(this.f21443random, dHDefaultParameters);
                } else {
                    synchronized (f21439lock) {
                        try {
                            if (f21440params.containsKey(numM18296valueOf)) {
                                this.f21442param = (DHKeyGenerationParameters) f21440params.get(numM18296valueOf);
                            } else {
                                DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                                int i = this.strength;
                                dHParametersGenerator.m15487init(i, PrimeCertaintyCalculator.getDefaultCertainty(i), this.f21443random);
                                DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(this.f21443random, dHParametersGenerator.generateParameters());
                                this.f21442param = dHKeyGenerationParameters;
                                f21440params.put(numM18296valueOf, dHKeyGenerationParameters);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    this.f21441engine.mo14944init(this.f21442param);
                    this.initialised = true;
                }
            }
            this.f21442param = dHKeyGenerationParametersConvertParams;
            this.f21441engine.mo14944init(this.f21442param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21441engine.generateKeyPair();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCDHPrivateKey((DHPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21443random = secureRandom;
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        }
        try {
            DHKeyGenerationParameters dHKeyGenerationParametersConvertParams = convertParams(secureRandom, (DHParameterSpec) algorithmParameterSpec);
            this.f21442param = dHKeyGenerationParametersConvertParams;
            this.f21441engine.mo14944init(dHKeyGenerationParametersConvertParams);
            this.initialised = true;
        } catch (IllegalArgumentException e) {
            throw new InvalidAlgorithmParameterException(e.getMessage(), e);
        }
    }
}
