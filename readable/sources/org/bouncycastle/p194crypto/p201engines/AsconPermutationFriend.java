package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.p199digests.ISAPDigest;
import org.bouncycastle.p361util.C6243Longs;

/* loaded from: classes2.dex */
public class AsconPermutationFriend {

    public static class AsconPermutation {

        /* renamed from: x0 */
        public long f19740x0;

        /* renamed from: x1 */
        public long f19741x1;

        /* renamed from: x2 */
        public long f19742x2;

        /* renamed from: x3 */
        public long f19743x3;

        /* renamed from: x4 */
        public long f19744x4;

        /* renamed from: p */
        public void m15266p(int i) {
            if (i == 12) {
                m15267round(240L);
                m15267round(225L);
                m15267round(210L);
                m15267round(195L);
            }
            if (i >= 8) {
                m15267round(180L);
                m15267round(165L);
            }
            m15267round(150L);
            m15267round(135L);
            m15267round(120L);
            m15267round(105L);
            m15267round(90L);
            m15267round(75L);
        }

        /* renamed from: round */
        public void m15267round(long j) {
            long j2 = this.f19742x2 ^ j;
            this.f19742x2 = j2;
            long j3 = this.f19740x0;
            long j4 = this.f19744x4;
            long j5 = j3 ^ j4;
            long j6 = this.f19741x1;
            long j7 = j6 ^ j2;
            long j8 = j6 | j2;
            long j9 = this.f19743x3;
            long j10 = ((j9 ^ j8) ^ j3) ^ (j6 & j5);
            long j11 = ((j2 & j6) & j9) ^ (j5 ^ (j8 | j9));
            long j12 = ((~j9) & j4) ^ j7;
            long j13 = j7 ^ (j3 | (j9 ^ j4));
            long j14 = ((j4 | j6) ^ j9) ^ (j3 & j6);
            this.f19740x0 = C6243Longs.rotateRight(j10, 28) ^ (C6243Longs.rotateRight(j10, 19) ^ j10);
            this.f19741x1 = C6243Longs.rotateRight(j11, 61) ^ (C6243Longs.rotateRight(j11, 39) ^ j11);
            this.f19742x2 = ~((C6243Longs.rotateRight(j12, 1) ^ j12) ^ C6243Longs.rotateRight(j12, 6));
            this.f19743x3 = (C6243Longs.rotateRight(j13, 10) ^ j13) ^ C6243Longs.rotateRight(j13, 17);
            this.f19744x4 = (C6243Longs.rotateRight(j14, 7) ^ j14) ^ C6243Longs.rotateRight(j14, 41);
        }

        /* renamed from: set */
        public void m15268set(long j, long j2, long j3, long j4, long j5) {
            this.f19740x0 = j;
            this.f19741x1 = j2;
            this.f19742x2 = j3;
            this.f19743x3 = j4;
            this.f19744x4 = j5;
        }
    }

    public static AsconPermutation getAsconPermutation(ISAPDigest.C5290Friend c5290Friend) {
        if (c5290Friend != null) {
            return new AsconPermutation();
        }
        throw new NullPointerException("This method is only for use by ISAPDigest or Ascon Digest");
    }
}
