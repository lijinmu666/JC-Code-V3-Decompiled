package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class DilithiumKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private DilithiumParameters dilithiumParams;

    /* renamed from: random */
    private SecureRandom f23082random;

    private AsymmetricCipherKeyPair genKeyPair() {
        byte[][] bArrGenerateKeyPair = this.dilithiumParams.getEngine(this.f23082random).generateKeyPair();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new DilithiumPublicKeyParameters(this.dilithiumParams, bArrGenerateKeyPair[0], bArrGenerateKeyPair[6]), (AsymmetricKeyParameter) new DilithiumPrivateKeyParameters(this.dilithiumParams, bArrGenerateKeyPair[0], bArrGenerateKeyPair[1], bArrGenerateKeyPair[2], bArrGenerateKeyPair[3], bArrGenerateKeyPair[4], bArrGenerateKeyPair[5], bArrGenerateKeyPair[6]));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.dilithiumParams = ((DilithiumKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f23082random = keyGenerationParameters.getRandom();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public AsymmetricCipherKeyPair internalGenerateKeyPair(byte[] bArr) {
        byte[][] bArrGenerateKeyPairInternal = this.dilithiumParams.getEngine(this.f23082random).generateKeyPairInternal(bArr);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new DilithiumPublicKeyParameters(this.dilithiumParams, bArrGenerateKeyPairInternal[0], bArrGenerateKeyPairInternal[6]), (AsymmetricKeyParameter) new DilithiumPrivateKeyParameters(this.dilithiumParams, bArrGenerateKeyPairInternal[0], bArrGenerateKeyPairInternal[1], bArrGenerateKeyPairInternal[2], bArrGenerateKeyPairInternal[3], bArrGenerateKeyPairInternal[4], bArrGenerateKeyPairInternal[5], bArrGenerateKeyPairInternal[6]));
    }
}
