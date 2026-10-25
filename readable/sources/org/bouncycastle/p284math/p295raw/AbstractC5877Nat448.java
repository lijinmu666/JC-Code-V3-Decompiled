package org.bouncycastle.p284math.p295raw;

import java.math.BigInteger;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.math.raw.Nat448 */
/* loaded from: classes2.dex */
public abstract class AbstractC5877Nat448 {
    /* renamed from: copy64 */
    public static void m17097copy64(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2] = jArr[i];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
        jArr2[i2 + 4] = jArr[i + 4];
        jArr2[i2 + 5] = jArr[i + 5];
        jArr2[i2 + 6] = jArr[i + 6];
    }

    public static long[] create64() {
        return new long[7];
    }

    public static long[] createExt64() {
        return new long[14];
    }

    /* renamed from: eq64 */
    public static boolean m17099eq64(long[] jArr, long[] jArr2) {
        for (int i = 6; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 448) {
            throw new IllegalArgumentException();
        }
        long[] jArrCreate64 = create64();
        for (int i = 0; i < 7; i++) {
            jArrCreate64[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrCreate64;
    }

    /* renamed from: isOne64 */
    public static boolean m17100isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i = 0; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: mul */
    public static void m17101mul(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5873Nat224.m17050mul(iArr, iArr2, iArr3);
        AbstractC5873Nat224.m17049mul(iArr, 7, iArr2, 7, iArr3, 14);
        int iAddToEachOther = AbstractC5873Nat224.addToEachOther(iArr3, 7, iArr3, 14);
        int iM17036addTo = iAddToEachOther + AbstractC5873Nat224.m17036addTo(iArr3, 21, iArr3, 14, AbstractC5873Nat224.m17036addTo(iArr3, 0, iArr3, 7, 0) + iAddToEachOther);
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        boolean z = AbstractC5873Nat224.m17042diff(iArr, 7, iArr, 0, iArrM17041create, 0) != AbstractC5873Nat224.m17042diff(iArr2, 7, iArr2, 0, iArrM17041create2, 0);
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17050mul(iArrM17041create, iArrM17041create2, iArrCreateExt);
        AbstractC5869Nat.addWordAt(28, iM17036addTo + (z ? AbstractC5869Nat.m16889addTo(14, iArrCreateExt, 0, iArr3, 7) : AbstractC5869Nat.m16939subFrom(14, iArrCreateExt, 0, iArr3, 7)), iArr3, 21);
    }

    /* renamed from: square */
    public static void m17102square(int[] iArr, int[] iArr2) {
        AbstractC5873Nat224.m17053square(iArr, iArr2);
        AbstractC5873Nat224.m17052square(iArr, 7, iArr2, 14);
        int iAddToEachOther = AbstractC5873Nat224.addToEachOther(iArr2, 7, iArr2, 14);
        int iM17036addTo = iAddToEachOther + AbstractC5873Nat224.m17036addTo(iArr2, 21, iArr2, 14, AbstractC5873Nat224.m17036addTo(iArr2, 0, iArr2, 7, 0) + iAddToEachOther);
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        AbstractC5873Nat224.m17042diff(iArr, 7, iArr, 0, iArrM17041create, 0);
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17053square(iArrM17041create, iArrCreateExt);
        AbstractC5869Nat.addWordAt(28, iM17036addTo + AbstractC5869Nat.m16939subFrom(14, iArrCreateExt, 0, iArr2, 7), iArr2, 21);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[56];
        for (int i = 0; i < 7; i++) {
            long j = jArr[i];
            if (j != 0) {
                AbstractC6245Pack.longToBigEndian(j, bArr, (6 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: copy64 */
    public static void m17098copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }
}
