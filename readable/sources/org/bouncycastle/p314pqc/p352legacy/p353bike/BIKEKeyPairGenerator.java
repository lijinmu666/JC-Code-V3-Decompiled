package org.bouncycastle.p314pqc.p352legacy.p353bike;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class BIKEKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: L_BYTE */
    private int f23941L_BYTE;

    /* renamed from: R_BYTE */
    private int f23942R_BYTE;
    private BIKEKeyGenerationParameters bikeKeyGenerationParameters;

    /* renamed from: l */
    private int f23943l;

    /* renamed from: r */
    private int f23944r;

    /* renamed from: random */
    private SecureRandom f23945random;

    private AsymmetricCipherKeyPair genKeyPair() {
        BIKEEngine engine = this.bikeKeyGenerationParameters.getParameters().getEngine();
        int i = this.f23942R_BYTE;
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[i];
        byte[] bArr3 = new byte[i];
        byte[] bArr4 = new byte[this.f23941L_BYTE];
        engine.genKeyPair(bArr, bArr2, bArr4, bArr3, this.f23945random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new BIKEPublicKeyParameters(this.bikeKeyGenerationParameters.getParameters(), bArr3), (AsymmetricKeyParameter) new BIKEPrivateKeyParameters(this.bikeKeyGenerationParameters.getParameters(), bArr, bArr2, bArr4));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.bikeKeyGenerationParameters = (BIKEKeyGenerationParameters) keyGenerationParameters;
        this.f23945random = keyGenerationParameters.getRandom();
        this.f23944r = this.bikeKeyGenerationParameters.getParameters().m18065getR();
        int iM18063getL = this.bikeKeyGenerationParameters.getParameters().m18063getL();
        this.f23943l = iM18063getL;
        this.f23941L_BYTE = iM18063getL / 8;
        this.f23942R_BYTE = (this.f23944r + 7) / 8;
    }
}
