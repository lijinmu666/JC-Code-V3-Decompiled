package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5871Nat160;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP160R1Field {

    /* renamed from: M */
    private static final long f22195M = 4294967295L;

    /* renamed from: P4 */
    private static final int f22197P4 = -1;

    /* renamed from: PExt9 */
    private static final int f22199PExt9 = -1;

    /* renamed from: PInv */
    private static final int f22201PInv = -2147483647;

    /* renamed from: P */
    static final int[] f22196P = {Integer.MAX_VALUE, -1, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22198PExt = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22200PExtInv = {-1, -1073741826, -1, -1, -1, 1, 1};

    /* renamed from: add */
    public static void m16423add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5871Nat160.m16984add(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && AbstractC5871Nat160.m16994gte(iArr3, f22196P))) {
            AbstractC5869Nat.addWordTo(5, f22201PInv, iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16424addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(10, iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && AbstractC5869Nat.m16921gte(10, iArr3, f22198PExt))) {
            int[] iArr4 = f22200PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16425addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && AbstractC5871Nat160.m16994gte(iArr2, f22196P))) {
            AbstractC5869Nat.addWordTo(5, f22201PInv, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5871Nat160.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[4] == -1) {
            int[] iArr = f22196P;
            if (AbstractC5871Nat160.m16994gte(iArrFromBigInteger, iArr)) {
                AbstractC5871Nat160.m17005subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16426half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(5, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(5, iArr2, AbstractC5871Nat160.m16984add(iArr, f22196P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16427inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22196P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16428isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(5, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        AbstractC5871Nat160.m16998mul(iArr, iArr2, iArrCreateExt);
        m16431reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5871Nat160.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && AbstractC5869Nat.m16921gte(10, iArr3, f22198PExt))) {
            int[] iArr4 = f22200PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16429negate(int[] iArr, int[] iArr2) {
        if (m16428isZero(iArr) == 0) {
            AbstractC5871Nat160.m17003sub(f22196P, iArr, iArr2);
        } else {
            int[] iArr3 = f22196P;
            AbstractC5871Nat160.m17003sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16430random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[20];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 5);
        } while (AbstractC5869Nat.lessThan(5, iArr, f22196P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16430random(secureRandom, iArr);
        } while (m16428isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16431reduce(int[] iArr, int[] iArr2) {
        long j = iArr[5] & 4294967295L;
        long j2 = iArr[6] & 4294967295L;
        long j3 = iArr[7] & 4294967295L;
        long j4 = iArr[8] & 4294967295L;
        long j5 = iArr[9] & 4294967295L;
        long j6 = (iArr[0] & 4294967295L) + j + (j << 31);
        iArr2[0] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[1] & 4294967295L) + j2 + (j2 << 31);
        iArr2[1] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[2] & 4294967295L) + j3 + (j3 << 31);
        iArr2[2] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[3] & 4294967295L) + j4 + (j4 << 31);
        iArr2[3] = (int) j9;
        long j10 = (j9 >>> 32) + (4294967295L & iArr[4]) + j5 + (j5 << 31);
        iArr2[4] = (int) j10;
        reduce32((int) (j10 >>> 32), iArr2);
    }

    public static void reduce32(int i, int[] iArr) {
        if ((i == 0 || AbstractC5871Nat160.mulWordsAdd(f22201PInv, i, iArr, 0) == 0) && !(iArr[4] == -1 && AbstractC5871Nat160.m16994gte(iArr, f22196P))) {
            return;
        }
        AbstractC5869Nat.addWordTo(5, f22201PInv, iArr);
    }

    /* renamed from: square */
    public static void m16432square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        AbstractC5871Nat160.m17001square(iArr, iArrCreateExt);
        m16431reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16433squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        AbstractC5871Nat160.m17001square(iArr, iArrCreateExt);
        while (true) {
            m16431reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5871Nat160.m17001square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5871Nat160.m17003sub(iArr, iArr2, iArr3) != 0) {
            AbstractC5869Nat.subWordFrom(5, f22201PInv, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22200PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16434twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && AbstractC5871Nat160.m16994gte(iArr2, f22196P))) {
            AbstractC5869Nat.addWordTo(5, f22201PInv, iArr2);
        }
    }
}
