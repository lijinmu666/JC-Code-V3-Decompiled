package org.bouncycastle.p194crypto;

/* renamed from: org.bouncycastle.crypto.Signer */
/* loaded from: classes2.dex */
public interface InterfaceC5282Signer {
    byte[] generateSignature();

    /* renamed from: init */
    void mo14987init(boolean z, CipherParameters cipherParameters);

    /* renamed from: reset */
    void mo14988reset();

    /* renamed from: update */
    void mo14989update(byte b);

    /* renamed from: update */
    void mo14990update(byte[] bArr, int i, int i2);

    boolean verifySignature(byte[] bArr);
}
