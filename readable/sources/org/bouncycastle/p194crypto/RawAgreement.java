package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface RawAgreement {
    void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i);

    int getAgreementSize();

    /* renamed from: init */
    void mo14986init(CipherParameters cipherParameters);
}
