package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class HSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: param */
    HSSKeyGenerationParameters f23216param;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        HSSPrivateKeyParameters hSSPrivateKeyParametersGenerateHSSKeyPair = C6066HSS.generateHSSKeyPair(this.f23216param);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) hSSPrivateKeyParametersGenerateHSSKeyPair.getPublicKey(), (AsymmetricKeyParameter) hSSPrivateKeyParametersGenerateHSSKeyPair);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23216param = (HSSKeyGenerationParameters) keyGenerationParameters;
    }
}
