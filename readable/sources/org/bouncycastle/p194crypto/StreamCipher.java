package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface StreamCipher {
    String getAlgorithmName();

    /* renamed from: init */
    void mo14993init(boolean z, CipherParameters cipherParameters);

    int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: reset */
    void mo14994reset();

    byte returnByte(byte b);
}
