package org.bouncycastle.p284math.p295raw;

import java.math.BigInteger;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Integers;

/* renamed from: org.bouncycastle.math.raw.Nat */
/* loaded from: classes2.dex */
public abstract class AbstractC5869Nat {

    /* renamed from: M */
    private static final long f22485M = 4294967295L;

    /* renamed from: add */
    public static int m16884add(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (iArr[i2] & 4294967295L) + (4294967295L & iArr2[i2]);
            iArr3[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    /* renamed from: add33At */
    public static int m16885add33At(int i, int i2, int[] iArr, int i3) {
        long j = (iArr[i3] & 4294967295L) + (i2 & 4294967295L);
        iArr[i3] = (int) j;
        long j2 = (j >>> 32) + (4294967295L & iArr[r4]) + 1;
        iArr[i3 + 1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, i3 + 2);
    }

    /* renamed from: add33To */
    public static int m16887add33To(int i, int i2, int[] iArr) {
        long j = (iArr[0] & 4294967295L) + (i2 & 4294967295L);
        iArr[0] = (int) j;
        long j2 = (j >>> 32) + (4294967295L & iArr[1]) + 1;
        iArr[1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, 2);
    }

    public static int addBothTo(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = 0;
        for (int i5 = 0; i5 < i; i5++) {
            long j2 = j + (iArr[i2 + i5] & 4294967295L) + (iArr2[i3 + i5] & 4294967295L) + (4294967295L & iArr3[r8]);
            iArr3[i4 + i5] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int addDWordAt(int i, long j, int[] iArr, int i2) {
        long j2 = (iArr[i2] & 4294967295L) + (j & 4294967295L);
        iArr[i2] = (int) j2;
        long j3 = (j2 >>> 32) + (4294967295L & iArr[r5]) + (j >>> 32);
        iArr[i2 + 1] = (int) j3;
        if ((j3 >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, i2 + 2);
    }

    public static int addDWordTo(int i, long j, int[] iArr) {
        long j2 = (iArr[0] & 4294967295L) + (j & 4294967295L);
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + (4294967295L & iArr[1]) + (j >>> 32);
        iArr[1] = (int) j3;
        if ((j3 >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, 2);
    }

    /* renamed from: addTo */
    public static int m16889addTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            long j2 = j + (iArr[i2 + i4] & 4294967295L) + (4294967295L & iArr2[r7]);
            iArr2[i3 + i4] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int addToEachOther(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            long j2 = j + (iArr[r3] & 4294967295L) + (4294967295L & iArr2[r8]);
            int i5 = (int) j2;
            iArr[i2 + i4] = i5;
            iArr2[i3 + i4] = i5;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int addWordAt(int i, int i2, int[] iArr, int i3) {
        long j = (i2 & 4294967295L) + (4294967295L & iArr[i3]);
        iArr[i3] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, i3 + 1);
    }

    public static int addWordTo(int i, int i2, int[] iArr) {
        long j = (i2 & 4294967295L) + (4294967295L & iArr[0]);
        iArr[0] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, 1);
    }

    /* renamed from: cadd */
    public static int m16893cadd(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (-(i2 & 1)) & 4294967295L;
        long j2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j3 = j2 + (iArr[i3] & 4294967295L) + (iArr2[i3] & j);
            iArr3[i3] = (int) j3;
            j2 = j3 >>> 32;
        }
        return (int) j2;
    }

    /* renamed from: caddTo */
    public static int m16894caddTo(int i, int i2, int[] iArr, int[] iArr2) {
        long j = (-(i2 & 1)) & 4294967295L;
        long j2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j3 = j2 + (iArr2[i3] & 4294967295L) + (iArr[i3] & j);
            iArr2[i3] = (int) j3;
            j2 = j3 >>> 32;
        }
        return (int) j2;
    }

    /* renamed from: cmov */
    public static void m16895cmov(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        int i5 = -(i2 & 1);
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = i4 + i6;
            int i8 = iArr2[i7];
            iArr2[i7] = i8 ^ ((iArr[i3 + i6] ^ i8) & i5);
        }
    }

    /* renamed from: compare */
    public static int m16896compare(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = i - 1; i4 >= 0; i4--) {
            int i5 = iArr[i2 + i4] - Integer.MIN_VALUE;
            int i6 = iArr2[i3 + i4] - Integer.MIN_VALUE;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: copy */
    public static void m16898copy(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        System.arraycopy(iArr, i2, iArr2, i3, i);
    }

    /* renamed from: copy64 */
    public static void m16901copy64(int i, long[] jArr, int i2, long[] jArr2, int i3) {
        System.arraycopy(jArr, i2, jArr2, i3, i);
    }

    /* renamed from: create */
    public static int[] m16904create(int i) {
        return new int[i];
    }

    public static long[] create64(int i) {
        return new long[i];
    }

    /* renamed from: csub */
    public static int m16905csub(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5) {
        long j = (-(i2 & 1)) & 4294967295L;
        long j2 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            long j3 = j2 + ((iArr[i3 + i6] & 4294967295L) - (iArr2[i4 + i6] & j));
            iArr3[i5 + i6] = (int) j3;
            j2 = j3 >> 32;
        }
        return (int) j2;
    }

    /* renamed from: czero */
    public static int m16907czero(int i) {
        return ((~i) & (i - 1)) >> 31;
    }

    /* renamed from: czero64 */
    public static long m16908czero64(long j) {
        return ((~j) & (j - 1)) >> 63;
    }

    /* renamed from: dec */
    public static int m16909dec(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2] - 1;
            iArr[i2] = i3;
            if (i3 != -1) {
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: decAt */
    public static int m16911decAt(int i, int[] iArr, int i2) {
        while (i2 < i) {
            int i3 = iArr[i2] - 1;
            iArr[i2] = i3;
            if (i3 != -1) {
                return 0;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: diff */
    public static boolean m16913diff(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        boolean zM16920gte = m16920gte(i, iArr, i2, iArr2, i3);
        if (zM16920gte) {
            m16935sub(i, iArr, i2, iArr2, i3, iArr3, i4);
        } else {
            m16935sub(i, iArr2, i3, iArr, i2, iArr3, i4);
        }
        return zM16920gte;
    }

    /* renamed from: eq */
    public static boolean m16914eq(int i, int[] iArr, int[] iArr2) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: equalTo */
    public static int m16915equalTo(int i, int[] iArr, int i2) {
        int i3 = i2 ^ iArr[0];
        for (int i4 = 1; i4 < i; i4++) {
            i3 |= iArr[i4];
        }
        return m16907czero(i3);
    }

    public static long equalTo64(int i, long[] jArr, int i2, long j) {
        long j2 = j ^ jArr[i2];
        for (int i3 = 1; i3 < i; i3++) {
            j2 |= jArr[i2 + i3];
        }
        return m16908czero64(j2);
    }

    public static int equalToZero(int i, int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 |= iArr[i3];
        }
        return m16907czero(i2);
    }

    public static long equalToZero64(int i, long[] jArr) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j |= jArr[i2];
        }
        return m16908czero64(j);
    }

    public static int[] fromBigInteger(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i2 = (i + 31) >> 5;
        int[] iArrM16904create = m16904create(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            iArrM16904create[i3] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrM16904create;
    }

    public static long[] fromBigInteger64(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i2 = (i + 63) >> 6;
        long[] jArrCreate64 = create64(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            jArrCreate64[i3] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrCreate64;
    }

    /* renamed from: getBit */
    public static int m16919getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= iArr.length) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static int getBitLength(int i, int[] iArr) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                return (i2 * 32) + Integers.bitLength(i3);
            }
        }
        return 0;
    }

    /* renamed from: gte */
    public static boolean m16920gte(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = i - 1; i4 >= 0; i4--) {
            int i5 = iArr[i2 + i4] - Integer.MIN_VALUE;
            int i6 = iArr2[i3 + i4] - Integer.MIN_VALUE;
            if (i5 < i6) {
                return false;
            }
            if (i5 > i6) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: inc */
    public static int m16922inc(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: incAt */
    public static int m16924incAt(int i, int[] iArr, int i2) {
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
            i2++;
        }
        return 1;
    }

    /* renamed from: isOne */
    public static boolean m16926isOne(int i, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isZero */
    public static boolean m16927isZero(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int lessThan(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            j = (j + ((iArr[i2 + i4] & 4294967295L) - (4294967295L & iArr2[i3 + i4]))) >> 32;
        }
        return (int) j;
    }

    /* renamed from: mul */
    public static void m16928mul(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        iArr3[i4 + i] = m16931mulWord(i, iArr[i2], iArr2, i3, iArr3, i4);
        for (int i5 = 1; i5 < i; i5++) {
            int i6 = i4 + i5;
            iArr3[i6 + i] = mulWordAddTo(i, iArr[i2 + i5], iArr2, i3, iArr3, i6);
        }
    }

    public static int mul31BothAdd(int i, int i2, int[] iArr, int i3, int[] iArr2, int[] iArr3, int i4) {
        long j = i2 & 4294967295L;
        long j2 = i3 & 4294967295L;
        long j3 = 0;
        int i5 = 0;
        do {
            long j4 = j3 + ((iArr[i5] & 4294967295L) * j) + ((iArr2[i5] & 4294967295L) * j2) + (iArr3[r11] & 4294967295L);
            iArr3[i4 + i5] = (int) j4;
            j3 = j4 >>> 32;
            i5++;
        } while (i5 < i);
        return (int) j3;
    }

    public static int mulAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = 0;
        for (int i5 = 0; i5 < i; i5++) {
            long jMulWordAddTo = j + (mulWordAddTo(i, iArr[i2 + i5], iArr2, i3, iArr3, i4) & 4294967295L) + (iArr3[r3] & 4294967295L);
            iArr3[i4 + i] = (int) jMulWordAddTo;
            j = jMulWordAddTo >>> 32;
            i4++;
        }
        return (int) j;
    }

    /* renamed from: mulWord */
    public static int m16931mulWord(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        long j = i2 & 4294967295L;
        long j2 = 0;
        int i5 = 0;
        do {
            long j3 = j2 + ((iArr[i3 + i5] & 4294967295L) * j);
            iArr2[i4 + i5] = (int) j3;
            j2 = j3 >>> 32;
            i5++;
        } while (i5 < i);
        return (int) j2;
    }

    public static int mulWordAddTo(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        long j = i2 & 4294967295L;
        long j2 = 0;
        int i5 = 0;
        do {
            long j3 = j2 + ((iArr[i3 + i5] & 4294967295L) * j) + (iArr2[r9] & 4294967295L);
            iArr2[i4 + i5] = (int) j3;
            j2 = j3 >>> 32;
            i5++;
        } while (i5 < i);
        return (int) j2;
    }

    public static int mulWordDwordAddAt(int i, int i2, long j, int[] iArr, int i3) {
        long j2 = i2 & 4294967295L;
        long j3 = ((j & 4294967295L) * j2) + (iArr[i3] & 4294967295L);
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        long j5 = (j3 >>> 32) + j4 + (iArr[r10] & 4294967295L);
        iArr[i3 + 1] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[r0] & 4294967295L);
        iArr[i3 + 2] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return m16924incAt(i, iArr, i3 + 3);
    }

    public static int shiftDownBit(int i, int[] iArr, int i2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2 << 31;
            }
            int i3 = iArr[i];
            iArr[i] = (i2 << 31) | (i3 >>> 1);
            i2 = i3;
        }
    }

    public static int shiftDownBits(int i, int[] iArr, int i2, int i3) {
        while (true) {
            i--;
            if (i < 0) {
                return i3 << (-i2);
            }
            int i4 = iArr[i];
            iArr[i] = (i3 << (-i2)) | (i4 >>> i2);
            i3 = i4;
        }
    }

    public static int shiftDownWord(int i, int[] iArr, int i2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            int i3 = iArr[i];
            iArr[i] = i2;
            i2 = i3;
        }
    }

    public static int shiftUpBit(int i, int[] iArr, int i2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr[i3] = (i2 >>> 31) | (i4 << 1);
            i3++;
            i2 = i4;
        }
        return i2 >>> 31;
    }

    public static long shiftUpBit64(int i, long[] jArr, int i2, long j, long[] jArr2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            long j2 = jArr[i2 + i4];
            jArr2[i3 + i4] = (j >>> 63) | (j2 << 1);
            i4++;
            j = j2;
        }
        return j >>> 63;
    }

    public static int shiftUpBits(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = iArr[i4];
            iArr[i4] = (i3 >>> (-i2)) | (i5 << i2);
            i4++;
            i3 = i5;
        }
        return i3 >>> (-i2);
    }

    public static long shiftUpBits64(int i, long[] jArr, int i2, int i3, long j) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = i2 + i4;
            long j2 = jArr[i5];
            jArr[i5] = (j >>> (-i3)) | (j2 << i3);
            i4++;
            j = j2;
        }
        return j >>> (-i3);
    }

    /* renamed from: square */
    public static void m16933square(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4;
        int i5 = i << 1;
        int i6 = 0;
        int i7 = i;
        int i8 = i5;
        do {
            i7--;
            long j = iArr[i2 + i7] & 4294967295L;
            long j2 = j * j;
            iArr2[(i8 - 1) + i3] = (i6 << 31) | ((int) (j2 >>> 33));
            i8 -= 2;
            iArr2[i3 + i8] = (int) (j2 >>> 1);
            i6 = (int) j2;
        } while (i7 > 0);
        int i9 = i3 + 2;
        long j3 = 0;
        for (i4 = 1; i4 < i; i4++) {
            long jSquareWordAddTo = j3 + (squareWordAddTo(iArr, i2, i4, iArr2, i3) & 4294967295L) + (iArr2[i9] & 4294967295L);
            int i10 = i9 + 1;
            iArr2[i9] = (int) jSquareWordAddTo;
            long j4 = (jSquareWordAddTo >>> 32) + (iArr2[i10] & 4294967295L);
            i9 += 2;
            iArr2[i10] = (int) j4;
            j3 = j4 >>> 32;
        }
        shiftUpBit(i5, iArr2, i3, iArr[i2] << 31);
    }

    public static int squareWordAddTo(int[] iArr, int i, int i2, int[] iArr2, int i3) {
        long j = iArr[i + i2] & 4294967295L;
        int i4 = 0;
        long j2 = 0;
        int i5 = i3;
        do {
            long j3 = j2 + ((iArr[i + i4] & 4294967295L) * j) + (iArr2[r11] & 4294967295L);
            iArr2[i2 + i5] = (int) j3;
            j2 = j3 >>> 32;
            i5++;
            i4++;
        } while (i4 < i2);
        return (int) j2;
    }

    /* renamed from: sub */
    public static int m16935sub(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = 0;
        for (int i5 = 0; i5 < i; i5++) {
            long j2 = j + ((iArr[i2 + i5] & 4294967295L) - (4294967295L & iArr2[i3 + i5]));
            iArr3[i4 + i5] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    /* renamed from: sub33At */
    public static int m16937sub33At(int i, int i2, int[] iArr, int i3) {
        long j = (iArr[i3] & 4294967295L) - (i2 & 4294967295L);
        iArr[i3] = (int) j;
        long j2 = (j >> 32) + ((4294967295L & iArr[r4]) - 1);
        iArr[i3 + 1] = (int) j2;
        if ((j2 >> 32) == 0) {
            return 0;
        }
        return m16911decAt(i, iArr, i3 + 2);
    }

    public static int sub33From(int i, int i2, int[] iArr) {
        long j = (iArr[0] & 4294967295L) - (i2 & 4294967295L);
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((4294967295L & iArr[1]) - 1);
        iArr[1] = (int) j2;
        if ((j2 >> 32) == 0) {
            return 0;
        }
        return m16911decAt(i, iArr, 2);
    }

    public static int subBothFrom(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = 0;
        for (int i5 = 0; i5 < i; i5++) {
            long j2 = j + (((iArr3[r4] & 4294967295L) - (iArr[i2 + i5] & 4294967295L)) - (4294967295L & iArr2[i3 + i5]));
            iArr3[i4 + i5] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int subDWordAt(int i, long j, int[] iArr, int i2) {
        long j2 = (iArr[i2] & 4294967295L) - (j & 4294967295L);
        iArr[i2] = (int) j2;
        long j3 = (j2 >> 32) + ((4294967295L & iArr[r5]) - (j >>> 32));
        iArr[i2 + 1] = (int) j3;
        if ((j3 >> 32) == 0) {
            return 0;
        }
        return m16911decAt(i, iArr, i2 + 2);
    }

    public static int subDWordFrom(int i, long j, int[] iArr) {
        long j2 = (iArr[0] & 4294967295L) - (j & 4294967295L);
        iArr[0] = (int) j2;
        long j3 = (j2 >> 32) + ((4294967295L & iArr[1]) - (j >>> 32));
        iArr[1] = (int) j3;
        if ((j3 >> 32) == 0) {
            return 0;
        }
        return m16911decAt(i, iArr, 2);
    }

    /* renamed from: subFrom */
    public static int m16939subFrom(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            long j2 = j + ((iArr2[r3] & 4294967295L) - (4294967295L & iArr[i2 + i4]));
            iArr2[i3 + i4] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int subWordAt(int i, int i2, int[] iArr, int i3) {
        long j = (iArr[i3] & 4294967295L) - (4294967295L & i2);
        iArr[i3] = (int) j;
        if ((j >> 32) == 0) {
            return 0;
        }
        return m16911decAt(i, iArr, i3 + 1);
    }

    public static int subWordFrom(int i, int i2, int[] iArr) {
        long j = (iArr[0] & 4294967295L) - (4294967295L & i2);
        iArr[0] = (int) j;
        if ((j >> 32) == 0) {
            return 0;
        }
        return m16911decAt(i, iArr, 1);
    }

    public static BigInteger toBigInteger(int i, int[] iArr) {
        byte[] bArr = new byte[i << 2];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                AbstractC6245Pack.intToBigEndian(i3, bArr, ((i - 1) - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: xor */
    public static void m16941xor(int i, int[] iArr, int i2, int i3, int[] iArr2, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            iArr2[i4 + i5] = iArr[i2 + i5] ^ i3;
        }
    }

    /* renamed from: xor64 */
    public static void m16945xor64(int i, long[] jArr, int i2, long j, long[] jArr2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            jArr2[i3 + i4] = jArr[i2 + i4] ^ j;
        }
    }

    public static void xorBothTo(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + i5;
            iArr3[i6] = iArr3[i6] ^ (iArr[i2 + i5] ^ iArr2[i3 + i5]);
        }
    }

    public static void xorBothTo64(int i, long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + i5;
            jArr3[i6] = jArr3[i6] ^ (jArr[i2 + i5] ^ jArr2[i3 + i5]);
        }
    }

    /* renamed from: xorTo */
    public static void m16949xorTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            iArr2[i5] = iArr2[i5] ^ iArr[i2 + i4];
        }
    }

    /* renamed from: xorTo64 */
    public static void m16951xorTo64(int i, long[] jArr, int i2, long[] jArr2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            jArr2[i5] = jArr2[i5] ^ jArr[i2 + i4];
        }
    }

    public static void xorToEachOther(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i2 + i4;
            int i6 = i3 + i4;
            int i7 = iArr[i5] ^ iArr2[i6];
            iArr[i5] = i7;
            iArr2[i6] = i7;
        }
    }

    public static void xorToEachOther64(int i, long[] jArr, int i2, long[] jArr2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i2 + i4;
            int i6 = i3 + i4;
            long j = jArr[i5] ^ jArr2[i6];
            jArr[i5] = j;
            jArr2[i6] = j;
        }
    }

    /* renamed from: zero */
    public static void m16953zero(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 0;
        }
    }

    /* renamed from: zero64 */
    public static void m16955zero64(int i, long[] jArr) {
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = 0;
        }
    }

    /* renamed from: add33At */
    public static int m16886add33At(int i, int i2, int[] iArr, int i3, int i4) {
        int i5 = i3 + i4;
        long j = (iArr[i5] & 4294967295L) + (i2 & 4294967295L);
        iArr[i5] = (int) j;
        long j2 = (j >>> 32) + (4294967295L & iArr[r0]) + 1;
        iArr[i5 + 1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return m16925incAt(i, iArr, i3, i4 + 2);
    }

    /* renamed from: add33To */
    public static int m16888add33To(int i, int i2, int[] iArr, int i3) {
        long j = (iArr[i3] & 4294967295L) + (i2 & 4294967295L);
        iArr[i3] = (int) j;
        long j2 = (j >>> 32) + (4294967295L & iArr[r4]) + 1;
        iArr[i3 + 1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return m16925incAt(i, iArr, i3, 2);
    }

    public static int addBothTo(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (iArr[i2] & 4294967295L) + (iArr2[i2] & 4294967295L) + (4294967295L & iArr3[i2]);
            iArr3[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int addDWordAt(int i, long j, int[] iArr, int i2, int i3) {
        int i4 = i2 + i3;
        long j2 = (iArr[i4] & 4294967295L) + (j & 4294967295L);
        iArr[i4] = (int) j2;
        long j3 = (j2 >>> 32) + (4294967295L & iArr[r0]) + (j >>> 32);
        iArr[i4 + 1] = (int) j3;
        if ((j3 >>> 32) == 0) {
            return 0;
        }
        return m16925incAt(i, iArr, i2, i3 + 2);
    }

    public static int addDWordTo(int i, long j, int[] iArr, int i2) {
        long j2 = (iArr[i2] & 4294967295L) + (j & 4294967295L);
        iArr[i2] = (int) j2;
        long j3 = (j2 >>> 32) + (4294967295L & iArr[r5]) + (j >>> 32);
        iArr[i2 + 1] = (int) j3;
        if ((j3 >>> 32) == 0) {
            return 0;
        }
        return m16925incAt(i, iArr, i2, 2);
    }

    /* renamed from: addTo */
    public static int m16890addTo(int i, int[] iArr, int i2, int[] iArr2, int i3, int i4) {
        long j = i4 & 4294967295L;
        for (int i5 = 0; i5 < i; i5++) {
            long j2 = j + (iArr[i2 + i5] & 4294967295L) + (iArr2[r6] & 4294967295L);
            iArr2[i3 + i5] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int addToEachOther(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (iArr[i2] & 4294967295L) + (4294967295L & iArr2[i2]);
            int i3 = (int) j2;
            iArr[i2] = i3;
            iArr2[i2] = i3;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int addWordAt(int i, int i2, int[] iArr, int i3, int i4) {
        long j = i2 & 4294967295L;
        long j2 = j + (4294967295L & iArr[r7]);
        iArr[i3 + i4] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return m16925incAt(i, iArr, i3, i4 + 1);
    }

    public static int addWordTo(int i, int i2, int[] iArr, int i3) {
        long j = (i2 & 4294967295L) + (4294967295L & iArr[i3]);
        iArr[i3] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        return m16925incAt(i, iArr, i3, 1);
    }

    /* renamed from: compare */
    public static int m16897compare(int i, int[] iArr, int[] iArr2) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = iArr[i2] - Integer.MIN_VALUE;
            int i4 = iArr2[i2] - Integer.MIN_VALUE;
            if (i3 < i4) {
                return -1;
            }
            if (i3 > i4) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: copy */
    public static void m16899copy(int i, int[] iArr, int[] iArr2) {
        System.arraycopy(iArr, 0, iArr2, 0, i);
    }

    /* renamed from: copy64 */
    public static void m16902copy64(int i, long[] jArr, long[] jArr2) {
        System.arraycopy(jArr, 0, jArr2, 0, i);
    }

    /* renamed from: csub */
    public static int m16906csub(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (-(i2 & 1)) & 4294967295L;
        long j2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j3 = j2 + ((iArr[i3] & 4294967295L) - (iArr2[i3] & j));
            iArr3[i3] = (int) j3;
            j2 = j3 >> 32;
        }
        return (int) j2;
    }

    /* renamed from: dec */
    public static int m16910dec(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = iArr[i2] - 1;
            iArr2[i2] = i3;
            i2++;
            if (i3 != -1) {
                while (i2 < i) {
                    iArr2[i2] = iArr[i2];
                    i2++;
                }
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: decAt */
    public static int m16912decAt(int i, int[] iArr, int i2, int i3) {
        while (i3 < i) {
            int i4 = i2 + i3;
            int i5 = iArr[i4] - 1;
            iArr[i4] = i5;
            if (i5 != -1) {
                return 0;
            }
            i3++;
        }
        return -1;
    }

    /* renamed from: equalTo */
    public static int m16916equalTo(int i, int[] iArr, int i2, int i3) {
        int i4 = i3 ^ iArr[i2];
        for (int i5 = 1; i5 < i; i5++) {
            i4 |= iArr[i2 + i5];
        }
        return m16907czero(i4);
    }

    public static long equalTo64(int i, long[] jArr, int i2, long[] jArr2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i; i4++) {
            j |= jArr[i2 + i4] ^ jArr2[i3 + i4];
        }
        return m16908czero64(j);
    }

    public static int equalToZero(int i, int[] iArr, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 |= iArr[i2 + i4];
        }
        return m16907czero(i3);
    }

    public static long equalToZero64(int i, long[] jArr, int i2) {
        long j = 0;
        for (int i3 = 0; i3 < i; i3++) {
            j |= jArr[i2 + i3];
        }
        return m16908czero64(j);
    }

    public static int getBitLength(int i, int[] iArr, int i2) {
        for (int i3 = i - 1; i3 >= 0; i3--) {
            int i4 = iArr[i2 + i3];
            if (i4 != 0) {
                return (i3 * 32) + Integers.bitLength(i4);
            }
        }
        return 0;
    }

    /* renamed from: gte */
    public static boolean m16921gte(int i, int[] iArr, int[] iArr2) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = iArr[i2] - Integer.MIN_VALUE;
            int i4 = iArr2[i2] - Integer.MIN_VALUE;
            if (i3 < i4) {
                return false;
            }
            if (i3 > i4) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: inc */
    public static int m16923inc(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr2[i2] = i3;
            i2++;
            if (i3 != 0) {
                while (i2 < i) {
                    iArr2[i2] = iArr[i2];
                    i2++;
                }
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: incAt */
    public static int m16925incAt(int i, int[] iArr, int i2, int i3) {
        while (i3 < i) {
            int i4 = i2 + i3;
            int i5 = iArr[i4] + 1;
            iArr[i4] = i5;
            if (i5 != 0) {
                return 0;
            }
            i3++;
        }
        return 1;
    }

    public static int lessThan(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j + ((iArr[i2] & 4294967295L) - (4294967295L & iArr2[i2]))) >> 32;
        }
        return (int) j;
    }

    /* renamed from: mul */
    public static void m16929mul(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[i] = m16932mulWord(i, iArr[0], iArr2, iArr3);
        for (int i2 = 1; i2 < i; i2++) {
            iArr3[i2 + i] = mulWordAddTo(i, iArr[i2], iArr2, 0, iArr3, i2);
        }
    }

    public static int mulAddTo(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long jMulWordAddTo = j + (mulWordAddTo(i, iArr[i2], iArr2, 0, iArr3, i2) & 4294967295L) + (iArr3[r2] & 4294967295L);
            iArr3[i2 + i] = (int) jMulWordAddTo;
            j = jMulWordAddTo >>> 32;
        }
        return (int) j;
    }

    /* renamed from: mulWord */
    public static int m16932mulWord(int i, int i2, int[] iArr, int[] iArr2) {
        long j = i2 & 4294967295L;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((iArr[i3] & 4294967295L) * j);
            iArr2[i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < i);
        return (int) j2;
    }

    public static int shiftDownBit(int i, int[] iArr, int i2, int i3) {
        while (true) {
            i--;
            if (i < 0) {
                return i3 << 31;
            }
            int i4 = i2 + i;
            int i5 = iArr[i4];
            iArr[i4] = (i3 << 31) | (i5 >>> 1);
            i3 = i5;
        }
    }

    public static int shiftDownBits(int i, int[] iArr, int i2, int i3, int i4) {
        while (true) {
            i--;
            if (i < 0) {
                return i4 << (-i3);
            }
            int i5 = i2 + i;
            int i6 = iArr[i5];
            iArr[i5] = (i4 << (-i3)) | (i6 >>> i3);
            i4 = i6;
        }
    }

    public static int shiftUpBit(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = i2 + i4;
            int i6 = iArr[i5];
            iArr[i5] = (i3 >>> 31) | (i6 << 1);
            i4++;
            i3 = i6;
        }
        return i3 >>> 31;
    }

    public static int shiftUpBits(int i, int[] iArr, int i2, int i3, int i4) {
        int i5 = 0;
        while (i5 < i) {
            int i6 = i2 + i5;
            int i7 = iArr[i6];
            iArr[i6] = (i4 >>> (-i3)) | (i7 << i3);
            i5++;
            i4 = i7;
        }
        return i4 >>> (-i3);
    }

    public static long shiftUpBits64(int i, long[] jArr, int i2, int i3, long j, long[] jArr2, int i4) {
        int i5 = 0;
        while (i5 < i) {
            long j2 = jArr[i2 + i5];
            jArr2[i4 + i5] = (j >>> (-i3)) | (j2 << i3);
            i5++;
            j = j2;
        }
        return j >>> (-i3);
    }

    /* renamed from: square */
    public static void m16934square(int i, int[] iArr, int[] iArr2) {
        int i2;
        int i3 = i << 1;
        int i4 = i;
        int i5 = i3;
        int i6 = 0;
        while (true) {
            i4--;
            long j = iArr[i4] & 4294967295L;
            long j2 = j * j;
            iArr2[i5 - 1] = (i6 << 31) | ((int) (j2 >>> 33));
            i5 -= 2;
            iArr2[i5] = (int) (j2 >>> 1);
            int i7 = (int) j2;
            if (i4 <= 0) {
                break;
            } else {
                i6 = i7;
            }
        }
        long j3 = 0;
        int i8 = 2;
        for (i2 = 1; i2 < i; i2++) {
            long jSquareWordAddTo = j3 + (squareWordAddTo(iArr, i2, iArr2) & 4294967295L) + (iArr2[i8] & 4294967295L);
            int i9 = i8 + 1;
            iArr2[i8] = (int) jSquareWordAddTo;
            long j4 = (jSquareWordAddTo >>> 32) + (iArr2[i9] & 4294967295L);
            i8 += 2;
            iArr2[i9] = (int) j4;
            j3 = j4 >>> 32;
        }
        shiftUpBit(i3, iArr2, iArr[0] << 31);
    }

    public static int squareWordAddTo(int[] iArr, int i, int[] iArr2) {
        long j = iArr[i] & 4294967295L;
        long j2 = 0;
        int i2 = 0;
        do {
            long j3 = j2 + ((iArr[i2] & 4294967295L) * j) + (iArr2[r9] & 4294967295L);
            iArr2[i + i2] = (int) j3;
            j2 = j3 >>> 32;
            i2++;
        } while (i2 < i);
        return (int) j2;
    }

    /* renamed from: sub */
    public static int m16936sub(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + ((iArr[i2] & 4294967295L) - (4294967295L & iArr2[i2]));
            iArr3[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    /* renamed from: sub33At */
    public static int m16938sub33At(int i, int i2, int[] iArr, int i3, int i4) {
        int i5 = i3 + i4;
        long j = (iArr[i5] & 4294967295L) - (i2 & 4294967295L);
        iArr[i5] = (int) j;
        long j2 = (j >> 32) + ((4294967295L & iArr[r0]) - 1);
        iArr[i5 + 1] = (int) j2;
        if ((j2 >> 32) == 0) {
            return 0;
        }
        return m16912decAt(i, iArr, i3, i4 + 2);
    }

    public static int sub33From(int i, int i2, int[] iArr, int i3) {
        long j = (iArr[i3] & 4294967295L) - (i2 & 4294967295L);
        iArr[i3] = (int) j;
        long j2 = (j >> 32) + ((4294967295L & iArr[r4]) - 1);
        iArr[i3 + 1] = (int) j2;
        if ((j2 >> 32) == 0) {
            return 0;
        }
        return m16912decAt(i, iArr, i3, 2);
    }

    public static int subBothFrom(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (((iArr3[i2] & 4294967295L) - (iArr[i2] & 4294967295L)) - (4294967295L & iArr2[i2]));
            iArr3[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int subDWordAt(int i, long j, int[] iArr, int i2, int i3) {
        int i4 = i2 + i3;
        long j2 = (iArr[i4] & 4294967295L) - (j & 4294967295L);
        iArr[i4] = (int) j2;
        long j3 = (j2 >> 32) + ((4294967295L & iArr[r0]) - (j >>> 32));
        iArr[i4 + 1] = (int) j3;
        if ((j3 >> 32) == 0) {
            return 0;
        }
        return m16912decAt(i, iArr, i2, i3 + 2);
    }

    public static int subDWordFrom(int i, long j, int[] iArr, int i2) {
        long j2 = (iArr[i2] & 4294967295L) - (j & 4294967295L);
        iArr[i2] = (int) j2;
        long j3 = (j2 >> 32) + ((4294967295L & iArr[r5]) - (j >>> 32));
        iArr[i2 + 1] = (int) j3;
        if ((j3 >> 32) == 0) {
            return 0;
        }
        return m16912decAt(i, iArr, i2, 2);
    }

    /* renamed from: subFrom */
    public static int m16940subFrom(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + ((iArr2[i2] & 4294967295L) - (4294967295L & iArr[i2]));
            iArr2[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int subWordAt(int i, int i2, int[] iArr, int i3, int i4) {
        long j = (iArr[r0] & 4294967295L) - (4294967295L & i2);
        iArr[i3 + i4] = (int) j;
        if ((j >> 32) == 0) {
            return 0;
        }
        return m16912decAt(i, iArr, i3, i4 + 1);
    }

    public static int subWordFrom(int i, int i2, int[] iArr, int i3) {
        long j = (iArr[i3] & 4294967295L) - (4294967295L & i2);
        iArr[i3] = (int) j;
        if ((j >> 32) == 0) {
            return 0;
        }
        return m16912decAt(i, iArr, i3, 1);
    }

    /* renamed from: xor */
    public static void m16942xor(int i, int[] iArr, int i2, int[] iArr2) {
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[i3] = iArr[i3] ^ i2;
        }
    }

    /* renamed from: xor64 */
    public static void m16946xor64(int i, long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            jArr3[i4 + i5] = jArr[i2 + i5] ^ jArr2[i3 + i5];
        }
    }

    public static void xorBothTo(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = iArr3[i2] ^ (iArr[i2] ^ iArr2[i2]);
        }
    }

    public static void xorBothTo64(int i, long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            jArr3[i2] = jArr3[i2] ^ (jArr[i2] ^ jArr2[i2]);
        }
    }

    /* renamed from: xorTo */
    public static void m16950xorTo(int i, int[] iArr, int[] iArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr2[i2] = iArr2[i2] ^ iArr[i2];
        }
    }

    /* renamed from: xorTo64 */
    public static void m16952xorTo64(int i, long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            jArr2[i2] = jArr2[i2] ^ jArr[i2];
        }
    }

    public static void xorToEachOther(int i, int[] iArr, int[] iArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2] ^ iArr2[i2];
            iArr[i2] = i3;
            iArr2[i2] = i3;
        }
    }

    public static void xorToEachOther64(int i, long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2] ^ jArr2[i2];
            jArr[i2] = j;
            jArr2[i2] = j;
        }
    }

    /* renamed from: zero */
    public static void m16954zero(int i, int[] iArr, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i2 + i3] = 0;
        }
    }

    /* renamed from: zero64 */
    public static void m16956zero64(int i, long[] jArr, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            jArr[i2 + i3] = 0;
        }
    }

    /* renamed from: addTo */
    public static int m16891addTo(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (iArr[i2] & 4294967295L) + (4294967295L & iArr2[i2]);
            iArr2[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    /* renamed from: copy */
    public static int[] m16900copy(int i, int[] iArr) {
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    /* renamed from: copy64 */
    public static long[] m16903copy64(int i, long[] jArr) {
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, i);
        return jArr2;
    }

    /* renamed from: equalTo */
    public static int m16917equalTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i4 |= iArr[i2 + i5] ^ iArr2[i3 + i5];
        }
        return m16907czero(i4);
    }

    public static long equalTo64(int i, long[] jArr, long j) {
        long j2 = j ^ jArr[0];
        for (int i2 = 1; i2 < i; i2++) {
            j2 |= jArr[i2];
        }
        return m16908czero64(j2);
    }

    /* renamed from: mul */
    public static void m16930mul(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int[] iArr3, int i5) {
        iArr3[i5 + i4] = m16931mulWord(i4, iArr[i], iArr2, i3, iArr3, i5);
        for (int i6 = 1; i6 < i2; i6++) {
            int i7 = i5 + i6;
            iArr3[i7 + i4] = mulWordAddTo(i4, iArr[i + i6], iArr2, i3, iArr3, i7);
        }
    }

    public static int shiftDownBit(int i, int[] iArr, int i2, int i3, int[] iArr2, int i4) {
        while (true) {
            i--;
            if (i < 0) {
                return i3 << 31;
            }
            int i5 = iArr[i2 + i];
            iArr2[i4 + i] = (i3 << 31) | (i5 >>> 1);
            i3 = i5;
        }
    }

    public static int shiftDownBits(int i, int[] iArr, int i2, int i3, int i4, int[] iArr2, int i5) {
        while (true) {
            i--;
            if (i < 0) {
                return i4 << (-i3);
            }
            int i6 = iArr[i2 + i];
            iArr2[i5 + i] = (i4 << (-i3)) | (i6 >>> i3);
            i4 = i6;
        }
    }

    public static int shiftUpBit(int i, int[] iArr, int i2, int i3, int[] iArr2, int i4) {
        int i5 = 0;
        while (i5 < i) {
            int i6 = iArr[i2 + i5];
            iArr2[i4 + i5] = (i3 >>> 31) | (i6 << 1);
            i5++;
            i3 = i6;
        }
        return i3 >>> 31;
    }

    public static int shiftUpBits(int i, int[] iArr, int i2, int i3, int i4, int[] iArr2, int i5) {
        int i6 = 0;
        while (i6 < i) {
            int i7 = iArr[i2 + i6];
            iArr2[i5 + i6] = (i4 >>> (-i3)) | (i7 << i3);
            i6++;
            i4 = i7;
        }
        return i4 >>> (-i3);
    }

    /* renamed from: xor */
    public static void m16943xor(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            iArr3[i4 + i5] = iArr[i2 + i5] ^ iArr2[i3 + i5];
        }
    }

    /* renamed from: xor64 */
    public static void m16947xor64(int i, long[] jArr, long j, long[] jArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            jArr2[i2] = jArr[i2] ^ j;
        }
    }

    /* renamed from: addTo */
    public static int m16892addTo(int i, int[] iArr, int[] iArr2, int i2) {
        long j = i2 & 4294967295L;
        for (int i3 = 0; i3 < i; i3++) {
            long j2 = j + (iArr[i3] & 4294967295L) + (iArr2[i3] & 4294967295L);
            iArr2[i3] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    /* renamed from: equalTo */
    public static int m16918equalTo(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 |= iArr[i3] ^ iArr2[i3];
        }
        return m16907czero(i2);
    }

    public static long equalTo64(int i, long[] jArr, long[] jArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j |= jArr[i2] ^ jArr2[i2];
        }
        return m16908czero64(j);
    }

    public static int shiftDownBit(int i, int[] iArr, int i2, int[] iArr2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2 << 31;
            }
            int i3 = iArr[i];
            iArr2[i] = (i2 << 31) | (i3 >>> 1);
            i2 = i3;
        }
    }

    public static int shiftDownBits(int i, int[] iArr, int i2, int i3, int[] iArr2) {
        while (true) {
            i--;
            if (i < 0) {
                return i3 << (-i2);
            }
            int i4 = iArr[i];
            iArr2[i] = (i3 << (-i2)) | (i4 >>> i2);
            i3 = i4;
        }
    }

    public static int shiftUpBit(int i, int[] iArr, int i2, int[] iArr2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr2[i3] = (i2 >>> 31) | (i4 << 1);
            i3++;
            i2 = i4;
        }
        return i2 >>> 31;
    }

    public static int shiftUpBits(int i, int[] iArr, int i2, int i3, int[] iArr2) {
        int i4 = 0;
        while (i4 < i) {
            int i5 = iArr[i4];
            iArr2[i4] = (i3 >>> (-i2)) | (i5 << i2);
            i4++;
            i3 = i5;
        }
        return i3 >>> (-i2);
    }

    /* renamed from: xor */
    public static void m16944xor(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = iArr[i2] ^ iArr2[i2];
        }
    }

    /* renamed from: xor64 */
    public static void m16948xor64(int i, long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }
}
