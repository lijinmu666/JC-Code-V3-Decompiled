package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;

/* loaded from: classes2.dex */
public class FalconSigner implements MessageSigner {
    private byte[] encodedkey;

    /* renamed from: nist */
    private FalconNIST f23132nist;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        FalconNIST falconNIST = this.f23132nist;
        return falconNIST.crypto_sign(new byte[falconNIST.CRYPTO_BYTES], bArr, bArr.length, this.encodedkey);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        FalconNIST falconNIST;
        if (!z) {
            FalconPublicKeyParameters falconPublicKeyParameters = (FalconPublicKeyParameters) cipherParameters;
            this.encodedkey = falconPublicKeyParameters.m17551getH();
            falconNIST = new FalconNIST(falconPublicKeyParameters.getParameters().m17548getLogN(), falconPublicKeyParameters.getParameters().getNonceLength(), CryptoServicesRegistrar.getSecureRandom());
        } else {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                FalconPrivateKeyParameters falconPrivateKeyParameters = (FalconPrivateKeyParameters) parametersWithRandom.getParameters();
                this.encodedkey = falconPrivateKeyParameters.getEncoded();
                this.f23132nist = new FalconNIST(falconPrivateKeyParameters.getParameters().m17548getLogN(), falconPrivateKeyParameters.getParameters().getNonceLength(), parametersWithRandom.getRandom());
                return;
            }
            FalconPrivateKeyParameters falconPrivateKeyParameters2 = (FalconPrivateKeyParameters) cipherParameters;
            this.encodedkey = falconPrivateKeyParameters2.getEncoded();
            falconNIST = new FalconNIST(falconPrivateKeyParameters2.getParameters().m17548getLogN(), falconPrivateKeyParameters2.getParameters().getNonceLength(), CryptoServicesRegistrar.getSecureRandom());
        }
        this.f23132nist = falconNIST;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        byte b = bArr2[0];
        FalconNIST falconNIST = this.f23132nist;
        if (b != ((byte) (falconNIST.f23119LOGN + 48))) {
            return false;
        }
        int i = falconNIST.NONCELEN;
        byte[] bArr3 = new byte[i];
        byte[] bArr4 = new byte[(bArr2.length - i) - 1];
        System.arraycopy(bArr2, 1, bArr3, 0, i);
        int i2 = this.f23132nist.NONCELEN;
        System.arraycopy(bArr2, i2 + 1, bArr4, 0, (bArr2.length - i2) - 1);
        return this.f23132nist.crypto_sign_open(bArr4, bArr3, bArr, this.encodedkey) == 0;
    }
}
