package org.bouncycastle.p194crypto.p200ec;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public interface ECDecryptor {
    /* renamed from: decrypt */
    AbstractC5820ECPoint mo15215decrypt(C5332ECPair c5332ECPair);

    /* renamed from: init */
    void mo15216init(CipherParameters cipherParameters);
}
