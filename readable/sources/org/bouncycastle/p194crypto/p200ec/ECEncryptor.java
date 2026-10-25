package org.bouncycastle.p194crypto.p200ec;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public interface ECEncryptor {
    /* renamed from: encrypt */
    C5332ECPair mo15217encrypt(AbstractC5820ECPoint abstractC5820ECPoint);

    /* renamed from: init */
    void mo15218init(CipherParameters cipherParameters);
}
