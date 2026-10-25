package org.bouncycastle.p249jcajce.provider.asymmetric.p257elgamal;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.ElGamalKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.ElGamalParametersGenerator;
import org.bouncycastle.p194crypto.p213params.ElGamalKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPublicKeyParameters;
import org.bouncycastle.p281jce.p282spec.ElGamalParameterSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    int certainty;

    /* renamed from: engine */
    ElGamalKeyPairGenerator f21561engine;
    boolean initialised;

    /* renamed from: param */
    ElGamalKeyGenerationParameters f21562param;

    /* renamed from: random */
    SecureRandom f21563random;
    int strength;

    public KeyPairGeneratorSpi() {
        super("ElGamal");
        this.f21561engine = new ElGamalKeyPairGenerator();
        this.strength = 1024;
        this.certainty = 20;
        this.f21563random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        ElGamalKeyGenerationParameters elGamalKeyGenerationParameters;
        if (!this.initialised) {
            DHParameterSpec dHDefaultParameters = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
            if (dHDefaultParameters != null) {
                elGamalKeyGenerationParameters = new ElGamalKeyGenerationParameters(this.f21563random, new ElGamalParameters(dHDefaultParameters.getP(), dHDefaultParameters.getG(), dHDefaultParameters.getL()));
            } else {
                ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
                elGamalParametersGenerator.m15492init(this.strength, this.certainty, this.f21563random);
                elGamalKeyGenerationParameters = new ElGamalKeyGenerationParameters(this.f21563random, elGamalParametersGenerator.generateParameters());
            }
            this.f21562param = elGamalKeyGenerationParameters;
            this.f21561engine.mo14944init(this.f21562param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21561engine.generateKeyPair();
        return new KeyPair(new BCElGamalPublicKey((ElGamalPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCElGamalPrivateKey((ElGamalPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21563random = secureRandom;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        ElGamalKeyGenerationParameters elGamalKeyGenerationParameters;
        boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
        if (!z && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
        }
        if (z) {
            ElGamalParameterSpec elGamalParameterSpec = (ElGamalParameterSpec) algorithmParameterSpec;
            elGamalKeyGenerationParameters = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(elGamalParameterSpec.m16276getP(), elGamalParameterSpec.m16275getG()));
        } else {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            elGamalKeyGenerationParameters = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
        }
        this.f21562param = elGamalKeyGenerationParameters;
        this.f21561engine.mo14944init(this.f21562param);
        this.initialised = true;
    }
}
