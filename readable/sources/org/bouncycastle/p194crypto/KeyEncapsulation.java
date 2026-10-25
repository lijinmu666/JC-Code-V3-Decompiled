package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface KeyEncapsulation {
    /* renamed from: decrypt */
    CipherParameters mo14971decrypt(byte[] bArr, int i, int i2, int i3);

    /* renamed from: encrypt */
    CipherParameters mo14972encrypt(byte[] bArr, int i, int i2);

    /* renamed from: init */
    void mo14973init(CipherParameters cipherParameters);
}
