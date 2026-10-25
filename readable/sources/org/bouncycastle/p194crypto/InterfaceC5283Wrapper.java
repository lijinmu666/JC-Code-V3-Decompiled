package org.bouncycastle.p194crypto;

/* renamed from: org.bouncycastle.crypto.Wrapper */
/* loaded from: classes2.dex */
public interface InterfaceC5283Wrapper {
    String getAlgorithmName();

    /* renamed from: init */
    void mo14995init(boolean z, CipherParameters cipherParameters);

    /* renamed from: unwrap */
    byte[] mo14996unwrap(byte[] bArr, int i, int i2);

    /* renamed from: wrap */
    byte[] mo14997wrap(byte[] bArr, int i, int i2);
}
