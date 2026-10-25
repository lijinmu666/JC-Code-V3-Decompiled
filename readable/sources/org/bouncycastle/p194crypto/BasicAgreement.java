package org.bouncycastle.p194crypto;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters cipherParameters);

    int getFieldSize();

    /* renamed from: init */
    void mo14945init(CipherParameters cipherParameters);
}
