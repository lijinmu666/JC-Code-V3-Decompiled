package org.bouncycastle.p249jcajce.provider.asymmetric.p258gost;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.GOST3410KeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.GOST3410KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PublicKeyParameters;
import org.bouncycastle.p281jce.p282spec.GOST3410ParameterSpec;
import org.bouncycastle.p281jce.p282spec.GOST3410PublicKeyParameterSetSpec;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    GOST3410KeyPairGenerator f21567engine;
    GOST3410ParameterSpec gost3410Params;
    boolean initialised;

    /* renamed from: param */
    GOST3410KeyGenerationParameters f21568param;

    /* renamed from: random */
    SecureRandom f21569random;
    int strength;

    public KeyPairGeneratorSpi() {
        super("GOST3410");
        this.f21567engine = new GOST3410KeyPairGenerator();
        this.strength = 1024;
        this.f21569random = null;
        this.initialised = false;
    }

    /* renamed from: init */
    private void m16118init(GOST3410ParameterSpec gOST3410ParameterSpec, SecureRandom secureRandom) {
        GOST3410PublicKeyParameterSetSpec publicKeyParameters = gOST3410ParameterSpec.getPublicKeyParameters();
        GOST3410KeyGenerationParameters gOST3410KeyGenerationParameters = new GOST3410KeyGenerationParameters(secureRandom, new GOST3410Parameters(publicKeyParameters.m16286getP(), publicKeyParameters.m16287getQ(), publicKeyParameters.m16285getA()));
        this.f21568param = gOST3410KeyGenerationParameters;
        this.f21567engine.mo14944init(gOST3410KeyGenerationParameters);
        this.initialised = true;
        this.gost3410Params = gOST3410ParameterSpec;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            m16118init(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.gostR3410_94_CryptoPro_A.m14433getId()), CryptoServicesRegistrar.getSecureRandom());
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f21567engine.generateKeyPair();
        return new KeyPair(new BCGOST3410PublicKey((GOST3410PublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic(), this.gost3410Params), new BCGOST3410PrivateKey((GOST3410PrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate(), this.gost3410Params));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21569random = secureRandom;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof GOST3410ParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
        }
        m16118init((GOST3410ParameterSpec) algorithmParameterSpec, secureRandom);
    }
}
