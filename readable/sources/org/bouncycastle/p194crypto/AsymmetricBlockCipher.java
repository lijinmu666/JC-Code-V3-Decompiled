package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface AsymmetricBlockCipher {
    int getInputBlockSize();

    int getOutputBlockSize();

    /* renamed from: init */
    void mo14943init(boolean z, CipherParameters cipherParameters);

    byte[] processBlock(byte[] bArr, int i, int i2);
}
