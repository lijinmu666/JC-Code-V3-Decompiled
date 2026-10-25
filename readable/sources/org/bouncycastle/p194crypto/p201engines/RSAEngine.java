package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class RSAEngine implements AsymmetricBlockCipher {

    /* renamed from: core */
    private RSACoreEngine f20022core;

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.f20022core.getInputBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.f20022core.getOutputBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        if (this.f20022core == null) {
            this.f20022core = new RSACoreEngine();
        }
        this.f20022core.m15376init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        RSACoreEngine rSACoreEngine = this.f20022core;
        if (rSACoreEngine != null) {
            return rSACoreEngine.convertOutput(rSACoreEngine.processBlock(rSACoreEngine.convertInput(bArr, i, i2)));
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
