package org.bouncycastle.p194crypto.generators;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine;

/* loaded from: classes2.dex */
public class SLHDSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SLHDSAParameters parameters;

    /* renamed from: random */
    private SecureRandom f20284random;

    private byte[] sec_rand(int i) {
        byte[] bArr = new byte[i];
        this.f20284random.nextBytes(bArr);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return SLHDSAEngine.implGenerateKeyPair(this.parameters, sec_rand(this.parameters.m15815getN()), sec_rand(this.parameters.m15815getN()), sec_rand(this.parameters.m15815getN()));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f20284random = keyGenerationParameters.getRandom();
        this.parameters = ((SLHDSAKeyGenerationParameters) keyGenerationParameters).getParameters();
    }

    public AsymmetricCipherKeyPair internalGenerateKeyPair(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return SLHDSAEngine.implGenerateKeyPair(this.parameters, bArr, bArr2, bArr3);
    }
}
