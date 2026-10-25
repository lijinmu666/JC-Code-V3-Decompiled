package org.bouncycastle.p194crypto;

/* renamed from: org.bouncycastle.crypto.Mac */
/* loaded from: classes2.dex */
public interface InterfaceC5278Mac {
    /* renamed from: doFinal */
    int mo14975doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    int getMacSize();

    /* renamed from: init */
    void mo14976init(CipherParameters cipherParameters);

    /* renamed from: reset */
    void mo14977reset();

    /* renamed from: update */
    void mo14978update(byte b);

    /* renamed from: update */
    void mo14979update(byte[] bArr, int i, int i2);
}
