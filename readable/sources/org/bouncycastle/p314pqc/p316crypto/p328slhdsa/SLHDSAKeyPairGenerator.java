package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

@Deprecated
/* loaded from: classes2.dex */
public class SLHDSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SLHDSAParameters parameters;

    /* renamed from: random */
    private SecureRandom f23505random;

    private byte[] sec_rand(int i) {
        byte[] bArr = new byte[i];
        this.f23505random.nextBytes(bArr);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return SLHDSAEngine.implGenerateKeyPair(this.parameters, sec_rand(this.parameters.m17836getN()), sec_rand(this.parameters.m17836getN()), sec_rand(this.parameters.m17836getN()));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23505random = keyGenerationParameters.getRandom();
        this.parameters = ((SLHDSAKeyGenerationParameters) keyGenerationParameters).getParameters();
    }

    public AsymmetricCipherKeyPair internalGenerateKeyPair(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return SLHDSAEngine.implGenerateKeyPair(this.parameters, bArr, bArr2, bArr3);
    }
}
