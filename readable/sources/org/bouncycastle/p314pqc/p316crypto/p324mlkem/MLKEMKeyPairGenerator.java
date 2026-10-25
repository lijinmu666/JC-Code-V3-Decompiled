package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private MLKEMParameters mlkemParams;

    /* renamed from: random */
    private SecureRandom f23342random;

    private AsymmetricCipherKeyPair genKeyPair() {
        byte[][] bArrGenerateKemKeyPair = this.mlkemParams.getEngine().generateKemKeyPair(this.f23342random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new MLKEMPublicKeyParameters(this.mlkemParams, bArrGenerateKemKeyPair[0], bArrGenerateKemKeyPair[1]), (AsymmetricKeyParameter) new MLKEMPrivateKeyParameters(this.mlkemParams, bArrGenerateKemKeyPair[2], bArrGenerateKemKeyPair[3], bArrGenerateKemKeyPair[4], bArrGenerateKemKeyPair[0], bArrGenerateKemKeyPair[1], bArrGenerateKemKeyPair[5]));
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.mlkemParams = ((MLKEMKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f23342random = keyGenerationParameters.getRandom();
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
