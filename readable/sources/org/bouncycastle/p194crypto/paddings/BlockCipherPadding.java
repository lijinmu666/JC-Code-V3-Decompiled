package org.bouncycastle.p194crypto.paddings;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public interface BlockCipherPadding {
    int addPadding(byte[] bArr, int i);

    String getPaddingName();

    /* renamed from: init */
    void mo15663init(SecureRandom secureRandom);

    int padCount(byte[] bArr);
}
