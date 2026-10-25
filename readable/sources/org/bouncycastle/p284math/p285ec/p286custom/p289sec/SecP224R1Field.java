package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP224R1Field {

    /* renamed from: M */
    private static final long f22251M = 4294967295L;

    /* renamed from: P6 */
    private static final int f22253P6 = -1;

    /* renamed from: PExt13 */
    private static final int f22255PExt13 = -1;

    /* renamed from: P */
    static final int[] f22252P = {1, 0, 0, -1, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22254PExt = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22256PExtInv = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    /* renamed from: add */
    public static void m16488add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5873Nat224.m17035add(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && AbstractC5873Nat224.m17046gte(iArr3, f22252P))) {
            addPInvTo(iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16489addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && AbstractC5869Nat.m16921gte(14, iArr3, f22254PExt))) {
            int[] iArr4 = f22256PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16490addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && AbstractC5873Nat224.m17046gte(iArr2, f22252P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + (4294967295L & iArr[3]) + 1;
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            AbstractC5869Nat.m16924incAt(7, iArr, 4);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5873Nat224.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[6] == -1) {
            int[] iArr = f22252P;
            if (AbstractC5873Nat224.m17046gte(iArrFromBigInteger, iArr)) {
                AbstractC5873Nat224.m17057subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16491half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(7, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(7, iArr2, AbstractC5873Nat224.m17035add(iArr, f22252P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16492inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22252P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16493isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(7, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17050mul(iArr, iArr2, iArrCreateExt);
        m16496reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5873Nat224.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && AbstractC5869Nat.m16921gte(14, iArr3, f22254PExt))) {
            int[] iArr4 = f22256PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16494negate(int[] iArr, int[] iArr2) {
        if (m16493isZero(iArr) == 0) {
            AbstractC5873Nat224.m17055sub(f22252P, iArr, iArr2);
        } else {
            int[] iArr3 = f22252P;
            AbstractC5873Nat224.m17055sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16495random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[28];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 7);
        } while (AbstractC5869Nat.lessThan(7, iArr, f22252P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16495random(secureRandom, iArr);
        } while (m16493isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16496reduce(int[] iArr, int[] iArr2) {
        long j = iArr[10] & 4294967295L;
        long j2 = iArr[11] & 4294967295L;
        long j3 = iArr[12] & 4294967295L;
        long j4 = iArr[13] & 4294967295L;
        long j5 = ((iArr[7] & 4294967295L) + j2) - 1;
        long j6 = (iArr[8] & 4294967295L) + j3;
        long j7 = (iArr[9] & 4294967295L) + j4;
        long j8 = (iArr[0] & 4294967295L) - j5;
        long j9 = j8 & 4294967295L;
        long j10 = (j8 >> 32) + ((iArr[1] & 4294967295L) - j6);
        int i = (int) j10;
        iArr2[1] = i;
        long j11 = (j10 >> 32) + ((iArr[2] & 4294967295L) - j7);
        int i2 = (int) j11;
        iArr2[2] = i2;
        long j12 = (j11 >> 32) + (((iArr[3] & 4294967295L) + j5) - j);
        long j13 = j12 & 4294967295L;
        long j14 = (j12 >> 32) + (((iArr[4] & 4294967295L) + j6) - j2);
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + (((iArr[5] & 4294967295L) + j7) - j3);
        iArr2[5] = (int) j15;
        long j16 = (j15 >> 32) + (((iArr[6] & 4294967295L) + j) - j4);
        iArr2[6] = (int) j16;
        long j17 = (j16 >> 32) + 1;
        long j18 = j13 + j17;
        long j19 = j9 - j17;
        iArr2[0] = (int) j19;
        long j20 = j19 >> 32;
        if (j20 != 0) {
            long j21 = j20 + (i & 4294967295L);
            iArr2[1] = (int) j21;
            long j22 = (j21 >> 32) + (4294967295L & i2);
            iArr2[2] = (int) j22;
            j18 += j22 >> 32;
        }
        iArr2[3] = (int) j18;
        if (((j18 >> 32) == 0 || AbstractC5869Nat.m16924incAt(7, iArr2, 4) == 0) && !(iArr2[6] == -1 && AbstractC5873Nat224.m17046gte(iArr2, f22252P))) {
            return;
        }
        addPInvTo(iArr2);
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = (iArr[0] & 4294967295L) - j2;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + (4294967295L & iArr[3]) + j2;
            iArr[3] = (int) j7;
            j = j7 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || AbstractC5869Nat.m16924incAt(7, iArr, 4) == 0) && !(iArr[6] == -1 && AbstractC5873Nat224.m17046gte(iArr, f22252P))) {
            return;
        }
        addPInvTo(iArr);
    }

    /* renamed from: square */
    public static void m16497square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17053square(iArr, iArrCreateExt);
        m16496reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16498squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17053square(iArr, iArrCreateExt);
        while (true) {
            m16496reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5873Nat224.m17053square(iArr2, iArrCreateExt);
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + ((4294967295L & iArr[3]) - 1);
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            AbstractC5869Nat.m16911decAt(7, iArr, 4);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5873Nat224.m17055sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22256PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16499twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && AbstractC5873Nat224.m17046gte(iArr2, f22252P))) {
            addPInvTo(iArr2);
        }
    }
}
