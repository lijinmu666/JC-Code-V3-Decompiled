package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class FalconKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: nist */
    private FalconNIST f23114nist;

    /* renamed from: params */
    private FalconKeyGenerationParameters f23115params;

    /* renamed from: pk_size */
    private int f23116pk_size;

    /* renamed from: sk_size */
    private int f23117sk_size;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[][] bArrCrypto_sign_keypair = this.f23114nist.crypto_sign_keypair(new byte[this.f23116pk_size], new byte[this.f23117sk_size]);
        FalconParameters parameters = this.f23115params.getParameters();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new FalconPublicKeyParameters(parameters, bArrCrypto_sign_keypair[0]), (AsymmetricKeyParameter) new FalconPrivateKeyParameters(parameters, bArrCrypto_sign_keypair[1], bArrCrypto_sign_keypair[2], bArrCrypto_sign_keypair[3], bArrCrypto_sign_keypair[0]));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23115params = (FalconKeyGenerationParameters) keyGenerationParameters;
        SecureRandom random = keyGenerationParameters.getRandom();
        FalconKeyGenerationParameters falconKeyGenerationParameters = (FalconKeyGenerationParameters) keyGenerationParameters;
        int iM17548getLogN = falconKeyGenerationParameters.getParameters().m17548getLogN();
        this.f23114nist = new FalconNIST(iM17548getLogN, falconKeyGenerationParameters.getParameters().getNonceLength(), random);
        int i = 1 << iM17548getLogN;
        int i2 = i == 1024 ? 5 : (i == 256 || i == 512) ? 6 : (i == 64 || i == 128) ? 7 : 8;
        this.f23116pk_size = ((i * 14) / 8) + 1;
        this.f23117sk_size = (((i2 * 2) * i) / 8) + 1 + i;
    }
}
