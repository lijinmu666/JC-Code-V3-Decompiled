package org.bouncycastle.p194crypto.generators;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLDSAKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.p218mldsa.MLDSAEngine;

/* loaded from: classes2.dex */
public class MLDSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private MLDSAParameters parameters;

    /* renamed from: random */
    private SecureRandom f20268random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[][] bArrGenerateKeyPair = MLDSAEngine.getInstance(this.parameters, this.f20268random).generateKeyPair();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new MLDSAPublicKeyParameters(this.parameters, bArrGenerateKeyPair[0], bArrGenerateKeyPair[6]), (AsymmetricKeyParameter) new MLDSAPrivateKeyParameters(this.parameters, bArrGenerateKeyPair[0], bArrGenerateKeyPair[1], bArrGenerateKeyPair[2], bArrGenerateKeyPair[3], bArrGenerateKeyPair[4], bArrGenerateKeyPair[5], bArrGenerateKeyPair[6], bArrGenerateKeyPair[7]));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.parameters = ((MLDSAKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f20268random = keyGenerationParameters.getRandom();
    }
}
