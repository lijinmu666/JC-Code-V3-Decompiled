package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class LMSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: param */
    LMSKeyGenerationParameters f23246param;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        SecureRandom random = this.f23246param.getRandom();
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        LMSigParameters lMSigParam = this.f23246param.getParameters().getLMSigParam();
        byte[] bArr2 = new byte[lMSigParam.m17654getM()];
        random.nextBytes(bArr2);
        LMSPrivateKeyParameters lMSPrivateKeyParametersGenerateKeys = C6068LMS.generateKeys(lMSigParam, this.f23246param.getParameters().getLMOTSParam(), 0, bArr, bArr2);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) lMSPrivateKeyParametersGenerateKeys.getPublicKey(), (AsymmetricKeyParameter) lMSPrivateKeyParametersGenerateKeys);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23246param = (LMSKeyGenerationParameters) keyGenerationParameters;
    }
}
