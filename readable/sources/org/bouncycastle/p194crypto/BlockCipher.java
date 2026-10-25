package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    /* renamed from: init */
    void mo14946init(boolean z, CipherParameters cipherParameters);

    int processBlock(byte[] bArr, int i, byte[] bArr2, int i2);

    /* renamed from: reset */
    void mo14947reset();
}
