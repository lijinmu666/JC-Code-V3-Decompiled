package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class FrodoKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: B */
    private int f23164B;

    /* renamed from: D */
    private int f23165D;
    private FrodoKeyGenerationParameters frodoParams;

    /* renamed from: n */
    private int f23166n;

    /* renamed from: random */
    private SecureRandom f23167random;

    private AsymmetricCipherKeyPair genKeyPair() {
        FrodoEngine engine = this.frodoParams.getParameters().getEngine();
        byte[] bArr = new byte[engine.getPrivateKeySize()];
        byte[] bArr2 = new byte[engine.getPublicKeySize()];
        engine.kem_keypair(bArr2, bArr, this.f23167random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new FrodoPublicKeyParameters(this.frodoParams.getParameters(), bArr2), (AsymmetricKeyParameter) new FrodoPrivateKeyParameters(this.frodoParams.getParameters(), bArr));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.frodoParams = (FrodoKeyGenerationParameters) keyGenerationParameters;
        this.f23167random = keyGenerationParameters.getRandom();
        this.f23166n = this.frodoParams.getParameters().m17568getN();
        this.f23165D = this.frodoParams.getParameters().m17567getD();
        this.f23164B = this.frodoParams.getParameters().m17566getB();
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
}
