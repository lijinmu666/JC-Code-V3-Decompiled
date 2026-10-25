package org.bouncycastle.p314pqc.p334jcajce.provider.p343newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPublicKeyParameters;

/* loaded from: classes2.dex */
public class NHKeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    NHKeyPairGenerator f23790engine;
    boolean initialised;

    /* renamed from: random */
    SecureRandom f23791random;

    public NHKeyPairGeneratorSpi() {
        super("NH");
        this.f23790engine = new NHKeyPairGenerator();
        this.f23791random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            this.f23790engine.mo14944init(new KeyGenerationParameters(this.f23791random, 1024));
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23790engine.generateKeyPair();
        return new KeyPair(new BCNHPublicKey((NHPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCNHPrivateKey((NHPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        if (i != 1024) {
            throw new IllegalArgumentException("strength must be 1024 bits");
        }
        this.f23790engine.mo14944init(new KeyGenerationParameters(secureRandom, 1024));
        this.initialised = true;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("parameter object not recognised");
    }
}
