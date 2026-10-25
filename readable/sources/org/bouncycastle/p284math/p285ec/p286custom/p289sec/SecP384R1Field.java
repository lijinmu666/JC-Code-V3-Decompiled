package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5876Nat384;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP384R1Field {

    /* renamed from: M */
    private static final long f22282M = 4294967295L;

    /* renamed from: P11 */
    private static final int f22284P11 = -1;

    /* renamed from: PExt23 */
    private static final int f22286PExt23 = -1;

    /* renamed from: P */
    static final int[] f22283P = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22285PExt = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22287PExtInv = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    /* renamed from: add */
    public static void m16535add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr3, f22283P))) {
            addPInvTo(iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16536addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && AbstractC5869Nat.m16921gte(24, iArr3, f22285PExt))) {
            int[] iArr4 = f22287PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(24, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16537addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr2, f22283P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((iArr[1] & 4294967295L) - 1);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + (iArr[3] & 4294967295L) + 1;
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + (4294967295L & iArr[4]) + 1;
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            AbstractC5869Nat.m16924incAt(12, iArr, 5);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5869Nat.fromBigInteger(384, bigInteger);
        if (iArrFromBigInteger[11] == -1) {
            int[] iArr = f22283P;
            if (AbstractC5869Nat.m16921gte(12, iArrFromBigInteger, iArr)) {
                AbstractC5869Nat.m16940subFrom(12, iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16538half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(12, iArr2, AbstractC5869Nat.m16884add(12, iArr, f22283P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16539inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22283P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16540isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(12, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(24);
        AbstractC5876Nat384.m17095mul(iArr, iArr2, iArrM16904create);
        m16543reduce(iArrM16904create, iArr3);
    }

    /* renamed from: negate */
    public static void m16541negate(int[] iArr, int[] iArr2) {
        if (m16540isZero(iArr) == 0) {
            AbstractC5869Nat.m16936sub(12, f22283P, iArr, iArr2);
        } else {
            int[] iArr3 = f22283P;
            AbstractC5869Nat.m16936sub(12, iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16542random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[48];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 12);
        } while (AbstractC5869Nat.lessThan(12, iArr, f22283P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16542random(secureRandom, iArr);
        } while (m16540isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16543reduce(int[] iArr, int[] iArr2) {
        long j = iArr[16] & 4294967295L;
        long j2 = iArr[17] & 4294967295L;
        long j3 = iArr[18] & 4294967295L;
        long j4 = iArr[19] & 4294967295L;
        long j5 = iArr[20] & 4294967295L;
        long j6 = iArr[21] & 4294967295L;
        long j7 = iArr[22] & 4294967295L;
        long j8 = iArr[23] & 4294967295L;
        long j9 = ((iArr[12] & 4294967295L) + j5) - 1;
        long j10 = (iArr[13] & 4294967295L) + j7;
        long j11 = (iArr[14] & 4294967295L) + j7 + j8;
        long j12 = (iArr[15] & 4294967295L) + j8;
        long j13 = j2 + j6;
        long j14 = j6 - j8;
        long j15 = j7 - j8;
        long j16 = j9 + j14;
        long j17 = (iArr[0] & 4294967295L) + j16;
        iArr2[0] = (int) j17;
        long j18 = (j17 >> 32) + (((iArr[1] & 4294967295L) + j8) - j9) + j10;
        iArr2[1] = (int) j18;
        long j19 = (j18 >> 32) + (((iArr[2] & 4294967295L) - j6) - j10) + j11;
        iArr2[2] = (int) j19;
        long j20 = (j19 >> 32) + ((iArr[3] & 4294967295L) - j11) + j12 + j16;
        iArr2[3] = (int) j20;
        long j21 = (j20 >> 32) + (((((iArr[4] & 4294967295L) + j) + j6) + j10) - j12) + j16;
        iArr2[4] = (int) j21;
        long j22 = (j21 >> 32) + ((iArr[5] & 4294967295L) - j) + j10 + j11 + j13;
        iArr2[5] = (int) j22;
        long j23 = (j22 >> 32) + (((iArr[6] & 4294967295L) + j3) - j2) + j11 + j12;
        iArr2[6] = (int) j23;
        long j24 = (j23 >> 32) + ((((iArr[7] & 4294967295L) + j) + j4) - j3) + j12;
        iArr2[7] = (int) j24;
        long j25 = (j24 >> 32) + (((((iArr[8] & 4294967295L) + j) + j2) + j5) - j4);
        iArr2[8] = (int) j25;
        long j26 = (j25 >> 32) + (((iArr[9] & 4294967295L) + j3) - j5) + j13;
        iArr2[9] = (int) j26;
        long j27 = (j26 >> 32) + ((((iArr[10] & 4294967295L) + j3) + j4) - j14) + j15;
        iArr2[10] = (int) j27;
        long j28 = (j27 >> 32) + ((((iArr[11] & 4294967295L) + j4) + j5) - j15);
        iArr2[11] = (int) j28;
        reduce32((int) ((j28 >> 32) + 1), iArr2);
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = (iArr[0] & 4294967295L) + j2;
            iArr[0] = (int) j3;
            long j4 = (j3 >> 32) + ((iArr[1] & 4294967295L) - j2);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (iArr[2] & 4294967295L);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = j5 + (iArr[3] & 4294967295L) + j2;
            iArr[3] = (int) j7;
            long j8 = (j7 >> 32) + (4294967295L & iArr[4]) + j2;
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || AbstractC5869Nat.m16924incAt(12, iArr, 5) == 0) && !(iArr[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr, f22283P))) {
            return;
        }
        addPInvTo(iArr);
    }

    /* renamed from: square */
    public static void m16544square(int[] iArr, int[] iArr2) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(24);
        AbstractC5876Nat384.m17096square(iArr, iArrM16904create);
        m16543reduce(iArrM16904create, iArr2);
    }

    /* renamed from: squareN */
    public static void m16546squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(24);
        AbstractC5876Nat384.m17096square(iArr, iArrM16904create);
        while (true) {
            m16543reduce(iArrM16904create, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5876Nat384.m17096square(iArr2, iArrM16904create);
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + (iArr[1] & 4294967295L) + 1;
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + ((iArr[3] & 4294967295L) - 1);
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + ((4294967295L & iArr[4]) - 1);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            AbstractC5869Nat.m16911decAt(12, iArr, 5);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(12, iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22287PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(24, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16548twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr2, f22283P))) {
            addPInvTo(iArr2);
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        AbstractC5876Nat384.m17095mul(iArr, iArr2, iArr4);
        m16543reduce(iArr4, iArr3);
    }

    /* renamed from: square */
    public static void m16545square(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5876Nat384.m17096square(iArr, iArr3);
        m16543reduce(iArr3, iArr2);
    }

    /* renamed from: squareN */
    public static void m16547squareN(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        AbstractC5876Nat384.m17096square(iArr, iArr3);
        while (true) {
            m16543reduce(iArr3, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5876Nat384.m17096square(iArr2, iArr3);
            }
        }
    }
}
