package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class PicnicKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private PicnicParameters parameters;

    /* renamed from: random */
    private SecureRandom f23972random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        PicnicEngine engine = this.parameters.getEngine();
        byte[] bArr = new byte[engine.getSecretKeySize()];
        byte[] bArr2 = new byte[engine.getPublicKeySize()];
        engine.crypto_sign_keypair(bArr2, bArr, this.f23972random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new PicnicPublicKeyParameters(this.parameters, bArr2), (AsymmetricKeyParameter) new PicnicPrivateKeyParameters(this.parameters, bArr));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23972random = keyGenerationParameters.getRandom();
        this.parameters = ((PicnicKeyGenerationParameters) keyGenerationParameters).getParameters();
    }
}
