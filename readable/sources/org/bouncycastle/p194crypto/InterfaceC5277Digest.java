package org.bouncycastle.p194crypto;

/* renamed from: org.bouncycastle.crypto.Digest */
/* loaded from: classes2.dex */
public interface InterfaceC5277Digest {
    /* renamed from: doFinal */
    int mo14967doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    int getDigestSize();

    /* renamed from: reset */
    void mo14968reset();

    /* renamed from: update */
    void mo14969update(byte b);

    /* renamed from: update */
    void mo14970update(byte[] bArr, int i, int i2);
}
