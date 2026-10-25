package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class NTRUPlusKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: params */
    private NTRUPlusParameters f23404params;

    /* renamed from: random */
    private SecureRandom f23405random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[] bArr = new byte[this.f23404params.getPublicKeyBytes()];
        byte[] bArr2 = new byte[this.f23404params.getSecretKeyBytes()];
        NTRUPlusEngine nTRUPlusEngine = new NTRUPlusEngine(this.f23404params);
        byte[] bArr3 = new byte[32];
        int iM17774getN = this.f23404params.m17774getN();
        short[] sArr = new short[iM17774getN];
        short[] sArr2 = new short[iM17774getN];
        short[] sArr3 = new short[iM17774getN];
        short[] sArr4 = new short[iM17774getN];
        do {
            this.f23405random.nextBytes(bArr3);
        } while (nTRUPlusEngine.genf_derand(sArr, sArr2, bArr3) != 0);
        do {
            this.f23405random.nextBytes(bArr3);
        } while (nTRUPlusEngine.geng_derand(sArr3, sArr4, bArr3) != 0);
        nTRUPlusEngine.crypto_kem_keypair_derand(bArr, bArr2, sArr, sArr2, sArr3, sArr4);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NTRUPlusPublicKeyParameters(this.f23404params, bArr), (AsymmetricKeyParameter) new NTRUPlusPrivateKeyParameters(this.f23404params, bArr2));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23404params = ((NTRUPlusKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f23405random = keyGenerationParameters.getRandom();
    }
}
