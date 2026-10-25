package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

@Deprecated
/* loaded from: classes2.dex */
public class MLDSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private MLDSAParameters parameters;

    /* renamed from: random */
    private SecureRandom f23307random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[][] bArrGenerateKeyPair = this.parameters.getEngine(this.f23307random).generateKeyPair();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new MLDSAPublicKeyParameters(this.parameters, bArrGenerateKeyPair[0], bArrGenerateKeyPair[6]), (AsymmetricKeyParameter) new MLDSAPrivateKeyParameters(this.parameters, bArrGenerateKeyPair[0], bArrGenerateKeyPair[1], bArrGenerateKeyPair[2], bArrGenerateKeyPair[3], bArrGenerateKeyPair[4], bArrGenerateKeyPair[5], bArrGenerateKeyPair[6], bArrGenerateKeyPair[7]));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.parameters = ((MLDSAKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f23307random = keyGenerationParameters.getRandom();
    }
}
