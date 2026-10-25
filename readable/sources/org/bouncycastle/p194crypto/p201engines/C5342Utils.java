package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CryptoServicePurpose;

/* renamed from: org.bouncycastle.crypto.engines.Utils */
/* loaded from: classes2.dex */
class C5342Utils {
    public static CryptoServicePurpose getPurpose(boolean z) {
        return z ? CryptoServicePurpose.ENCRYPTION : CryptoServicePurpose.DECRYPTION;
    }
}
