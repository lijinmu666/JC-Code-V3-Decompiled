package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import org.bouncycastle.p194crypto.p201engines.ChaChaEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
class ChaCha20 {
    /* renamed from: process */
    public static void m17731process(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        ChaChaEngine chaChaEngine = new ChaChaEngine(20);
        chaChaEngine.mo14993init(true, new ParametersWithIV(new KeyParameter(bArr), bArr2));
        chaChaEngine.processBytes(bArr3, i, i2, bArr3, i);
    }
}
