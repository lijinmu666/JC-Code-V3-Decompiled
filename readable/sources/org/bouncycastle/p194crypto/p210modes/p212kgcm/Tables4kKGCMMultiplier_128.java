package org.bouncycastle.p194crypto.p210modes.p212kgcm;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class Tables4kKGCMMultiplier_128 implements KGCMMultiplier {

    /* renamed from: T */
    private long[][] f20657T;

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    /* renamed from: init */
    public void mo15641init(long[] jArr) {
        long[][] jArr2 = this.f20657T;
        if (jArr2 == null) {
            this.f20657T = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 256, 2);
        } else if (KGCMUtil_128.m15644equal(jArr, jArr2[1])) {
            return;
        }
        KGCMUtil_128.m15643copy(jArr, this.f20657T[1]);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr3 = this.f20657T;
            KGCMUtil_128.multiplyX(jArr3[i >> 1], jArr3[i]);
            long[][] jArr4 = this.f20657T;
            KGCMUtil_128.m15642add(jArr4[i], jArr4[1], jArr4[i + 1]);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        long[] jArr2 = new long[2];
        KGCMUtil_128.m15643copy(this.f20657T[((int) (jArr[1] >>> 56)) & 255], jArr2);
        for (int i = 14; i >= 0; i--) {
            KGCMUtil_128.multiplyX8(jArr2, jArr2);
            KGCMUtil_128.m15642add(this.f20657T[((int) (jArr[i >>> 3] >>> ((i & 7) << 3))) & 255], jArr2, jArr2);
        }
        KGCMUtil_128.m15643copy(jArr2, jArr);
    }
}
