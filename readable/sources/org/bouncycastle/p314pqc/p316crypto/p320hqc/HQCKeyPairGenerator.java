package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class HQCKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private HQCParameters parameters;

    /* renamed from: random */
    private SecureRandom f23197random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[] bArr = new byte[this.parameters.getPublicKeyBytes()];
        byte[] bArr2 = new byte[this.parameters.getSecretKeyBytes()];
        this.parameters.getEngine().genKeyPair(bArr, bArr2, this.f23197random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new HQCPublicKeyParameters(this.parameters, bArr), (AsymmetricKeyParameter) new HQCPrivateKeyParameters(this.parameters, bArr2));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23197random = keyGenerationParameters.getRandom();
        this.parameters = ((HQCKeyGenerationParameters) keyGenerationParameters).getParameters();
    }
}
