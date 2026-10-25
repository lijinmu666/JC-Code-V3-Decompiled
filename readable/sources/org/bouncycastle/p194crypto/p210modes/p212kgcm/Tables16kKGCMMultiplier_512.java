package org.bouncycastle.p194crypto.p210modes.p212kgcm;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class Tables16kKGCMMultiplier_512 implements KGCMMultiplier {

    /* renamed from: T */
    private long[][] f20656T;

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    /* renamed from: init */
    public void mo15641init(long[] jArr) {
        long[][] jArr2 = this.f20656T;
        if (jArr2 == null) {
            this.f20656T = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 256, 8);
        } else if (KGCMUtil_512.m15658equal(jArr, jArr2[1])) {
            return;
        }
        KGCMUtil_512.m15657copy(jArr, this.f20656T[1]);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr3 = this.f20656T;
            KGCMUtil_512.multiplyX(jArr3[i >> 1], jArr3[i]);
            long[][] jArr4 = this.f20656T;
            KGCMUtil_512.m15656add(jArr4[i], jArr4[1], jArr4[i + 1]);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        long[] jArr2 = new long[8];
        KGCMUtil_512.m15657copy(this.f20656T[((int) (jArr[7] >>> 56)) & 255], jArr2);
        for (int i = 62; i >= 0; i--) {
            KGCMUtil_512.multiplyX8(jArr2, jArr2);
            KGCMUtil_512.m15656add(this.f20656T[((int) (jArr[i >>> 3] >>> ((i & 7) << 3))) & 255], jArr2, jArr2);
        }
        KGCMUtil_512.m15657copy(jArr2, jArr);
    }
}
