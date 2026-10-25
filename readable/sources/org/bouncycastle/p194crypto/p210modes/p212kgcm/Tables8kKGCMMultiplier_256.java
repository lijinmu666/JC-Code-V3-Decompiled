package org.bouncycastle.p194crypto.p210modes.p212kgcm;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class Tables8kKGCMMultiplier_256 implements KGCMMultiplier {

    /* renamed from: T */
    private long[][] f20658T;

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    /* renamed from: init */
    public void mo15641init(long[] jArr) {
        long[][] jArr2 = this.f20658T;
        if (jArr2 == null) {
            this.f20658T = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 256, 4);
        } else if (KGCMUtil_256.m15651equal(jArr, jArr2[1])) {
            return;
        }
        KGCMUtil_256.m15650copy(jArr, this.f20658T[1]);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr3 = this.f20658T;
            KGCMUtil_256.multiplyX(jArr3[i >> 1], jArr3[i]);
            long[][] jArr4 = this.f20658T;
            KGCMUtil_256.m15649add(jArr4[i], jArr4[1], jArr4[i + 1]);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        long[] jArr2 = new long[4];
        KGCMUtil_256.m15650copy(this.f20658T[((int) (jArr[3] >>> 56)) & 255], jArr2);
        for (int i = 30; i >= 0; i--) {
            KGCMUtil_256.multiplyX8(jArr2, jArr2);
            KGCMUtil_256.m15649add(this.f20658T[((int) (jArr[i >>> 3] >>> ((i & 7) << 3))) & 255], jArr2, jArr2);
        }
        KGCMUtil_256.m15650copy(jArr2, jArr);
    }
}
