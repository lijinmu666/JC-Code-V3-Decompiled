package org.bouncycastle.p194crypto;

import java.math.BigInteger;

/* renamed from: org.bouncycastle.crypto.DSA */
/* loaded from: classes2.dex */
public interface InterfaceC5275DSA {
    BigInteger[] generateSignature(byte[] bArr);

    /* renamed from: init */
    void mo14965init(boolean z, CipherParameters cipherParameters);

    boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2);
}
