package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP192R1Field {

    /* renamed from: M */
    private static final long f22229M = 4294967295L;

    /* renamed from: P5 */
    private static final int f22231P5 = -1;

    /* renamed from: PExt11 */
    private static final int f22233PExt11 = -1;

    /* renamed from: P */
    static final int[] f22230P = {-1, -1, -2, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22232PExt = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22234PExtInv = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    /* renamed from: add */
    public static void m16462add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5872Nat192.m17007add(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && AbstractC5872Nat192.m17020gte(iArr3, f22230P))) {
            addPInvTo(iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16463addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr3, f22232PExt))) {
            int[] iArr4 = f22234PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16464addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && AbstractC5872Nat192.m17020gte(iArr2, f22230P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + (4294967295L & iArr[2]) + 1;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            AbstractC5869Nat.m16924incAt(6, iArr, 3);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5872Nat192.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[5] == -1) {
            int[] iArr = f22230P;
            if (AbstractC5872Nat192.m17020gte(iArrFromBigInteger, iArr)) {
                AbstractC5872Nat192.m17032subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16465half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(6, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(6, iArr2, AbstractC5872Nat192.m17007add(iArr, f22230P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16466inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22230P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16467isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(6, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17025mul(iArr, iArr2, iArrCreateExt);
        m16470reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5872Nat192.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr3, f22232PExt))) {
            int[] iArr4 = f22234PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16468negate(int[] iArr, int[] iArr2) {
        if (m16467isZero(iArr) == 0) {
            AbstractC5872Nat192.m17030sub(f22230P, iArr, iArr2);
        } else {
            int[] iArr3 = f22230P;
            AbstractC5872Nat192.m17030sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16469random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[24];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 6);
        } while (AbstractC5869Nat.lessThan(6, iArr, f22230P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16469random(secureRandom, iArr);
        } while (m16467isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16470reduce(int[] iArr, int[] iArr2) {
        long j = iArr[6] & 4294967295L;
        long j2 = iArr[7] & 4294967295L;
        long j3 = (iArr[10] & 4294967295L) + j;
        long j4 = (iArr[11] & 4294967295L) + j2;
        long j5 = (iArr[0] & 4294967295L) + j3;
        int i = (int) j5;
        long j6 = (j5 >> 32) + (iArr[1] & 4294967295L) + j4;
        int i2 = (int) j6;
        iArr2[1] = i2;
        long j7 = j3 + (iArr[8] & 4294967295L);
        long j8 = j4 + (iArr[9] & 4294967295L);
        long j9 = (j6 >> 32) + (iArr[2] & 4294967295L) + j7;
        long j10 = j9 & 4294967295L;
        long j11 = (j9 >> 32) + (iArr[3] & 4294967295L) + j8;
        iArr2[3] = (int) j11;
        long j12 = (j11 >> 32) + (iArr[4] & 4294967295L) + (j7 - j);
        iArr2[4] = (int) j12;
        long j13 = (j12 >> 32) + (iArr[5] & 4294967295L) + (j8 - j2);
        iArr2[5] = (int) j13;
        long j14 = j13 >> 32;
        long j15 = j10 + j14;
        long j16 = j14 + (i & 4294967295L);
        iArr2[0] = (int) j16;
        long j17 = j16 >> 32;
        if (j17 != 0) {
            long j18 = j17 + (4294967295L & i2);
            iArr2[1] = (int) j18;
            j15 += j18 >> 32;
        }
        iArr2[2] = (int) j15;
        if (((j15 >> 32) == 0 || AbstractC5869Nat.m16924incAt(6, iArr2, 3) == 0) && !(iArr2[5] == -1 && AbstractC5872Nat192.m17020gte(iArr2, f22230P))) {
            return;
        }
        addPInvTo(iArr2);
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = (iArr[0] & 4294967295L) + j2;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j5;
                j4 = j5 >> 32;
            }
            long j6 = j4 + (4294967295L & iArr[2]) + j2;
            iArr[2] = (int) j6;
            j = j6 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || AbstractC5869Nat.m16924incAt(6, iArr, 3) == 0) && !(iArr[5] == -1 && AbstractC5872Nat192.m17020gte(iArr, f22230P))) {
            return;
        }
        addPInvTo(iArr);
    }

    /* renamed from: square */
    public static void m16471square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17028square(iArr, iArrCreateExt);
        m16470reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16472squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17028square(iArr, iArrCreateExt);
        while (true) {
            m16470reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5872Nat192.m17028square(iArr2, iArrCreateExt);
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + ((4294967295L & iArr[2]) - 1);
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            AbstractC5869Nat.m16911decAt(6, iArr, 3);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5872Nat192.m17030sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(12, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22234PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16473twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && AbstractC5872Nat192.m17020gte(iArr2, f22230P))) {
            addPInvTo(iArr2);
        }
    }
}
