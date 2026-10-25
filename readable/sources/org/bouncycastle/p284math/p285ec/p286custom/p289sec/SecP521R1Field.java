package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5878Nat512;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP521R1Field {

    /* renamed from: P16 */
    private static final int f22294P16 = 511;

    /* renamed from: P */
    static final int[] f22293P = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, f22294P16};

    /* renamed from: add */
    public static void m16550add(int[] iArr, int[] iArr2, int[] iArr3) {
        int iM16884add = AbstractC5869Nat.m16884add(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (iM16884add > f22294P16 || (iM16884add == f22294P16 && AbstractC5869Nat.m16914eq(16, iArr3, f22293P))) {
            iM16884add = (iM16884add + AbstractC5869Nat.m16922inc(16, iArr3)) & f22294P16;
        }
        iArr3[16] = iM16884add;
    }

    /* renamed from: addOne */
    public static void m16551addOne(int[] iArr, int[] iArr2) {
        int iM16923inc = AbstractC5869Nat.m16923inc(16, iArr, iArr2) + iArr[16];
        if (iM16923inc > f22294P16 || (iM16923inc == f22294P16 && AbstractC5869Nat.m16914eq(16, iArr2, f22293P))) {
            iM16923inc = (iM16923inc + AbstractC5869Nat.m16922inc(16, iArr2)) & f22294P16;
        }
        iArr2[16] = iM16923inc;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5869Nat.fromBigInteger(521, bigInteger);
        if (AbstractC5869Nat.m16914eq(17, iArrFromBigInteger, f22293P)) {
            AbstractC5869Nat.m16953zero(17, iArrFromBigInteger);
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16552half(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (AbstractC5869Nat.shiftDownBit(16, iArr, i, iArr2) >>> 23) | (i >>> 1);
    }

    public static void implMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5878Nat512.m17103mul(iArr, iArr2, iArr3);
        int i = iArr[16];
        int i2 = iArr2[16];
        iArr3[32] = AbstractC5869Nat.mul31BothAdd(16, i, iArr2, i2, iArr, iArr3, 16) + (i * i2);
    }

    public static void implSquare(int[] iArr, int[] iArr2) {
        AbstractC5878Nat512.m17104square(iArr, iArr2);
        int i = iArr[16];
        iArr2[32] = AbstractC5869Nat.mulWordAddTo(16, i << 1, iArr, 0, iArr2, 16) + (i * i);
    }

    /* renamed from: inv */
    public static void m16553inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22293P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16554isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(17, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(33);
        implMultiply(iArr, iArr2, iArrM16904create);
        m16557reduce(iArrM16904create, iArr3);
    }

    /* renamed from: negate */
    public static void m16555negate(int[] iArr, int[] iArr2) {
        if (m16554isZero(iArr) == 0) {
            AbstractC5869Nat.m16936sub(17, f22293P, iArr, iArr2);
        } else {
            int[] iArr3 = f22293P;
            AbstractC5869Nat.m16936sub(17, iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16556random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[68];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 17);
            iArr[16] = iArr[16] & f22294P16;
        } while (AbstractC5869Nat.lessThan(17, iArr, f22293P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16556random(secureRandom, iArr);
        } while (m16554isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16557reduce(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int iShiftDownBits = (AbstractC5869Nat.shiftDownBits(16, iArr, 16, 9, i, iArr2, 0) >>> 23) + (i >>> 9) + AbstractC5869Nat.m16891addTo(16, iArr, iArr2);
        if (iShiftDownBits > f22294P16 || (iShiftDownBits == f22294P16 && AbstractC5869Nat.m16914eq(16, iArr2, f22293P))) {
            iShiftDownBits = (iShiftDownBits + AbstractC5869Nat.m16922inc(16, iArr2)) & f22294P16;
        }
        iArr2[16] = iShiftDownBits;
    }

    public static void reduce23(int[] iArr) {
        int i = iArr[16];
        int iAddWordTo = AbstractC5869Nat.addWordTo(16, i >>> 9, iArr) + (i & f22294P16);
        if (iAddWordTo > f22294P16 || (iAddWordTo == f22294P16 && AbstractC5869Nat.m16914eq(16, iArr, f22293P))) {
            iAddWordTo = (iAddWordTo + AbstractC5869Nat.m16922inc(16, iArr)) & f22294P16;
        }
        iArr[16] = iAddWordTo;
    }

    /* renamed from: square */
    public static void m16558square(int[] iArr, int[] iArr2) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(33);
        implSquare(iArr, iArrM16904create);
        m16557reduce(iArrM16904create, iArr2);
    }

    /* renamed from: squareN */
    public static void m16560squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(33);
        implSquare(iArr, iArrM16904create);
        while (true) {
            m16557reduce(iArrM16904create, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                implSquare(iArr2, iArrM16904create);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        int iM16936sub = (AbstractC5869Nat.m16936sub(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (iM16936sub < 0) {
            iM16936sub = (iM16936sub + AbstractC5869Nat.m16909dec(16, iArr3)) & f22294P16;
        }
        iArr3[16] = iM16936sub;
    }

    /* renamed from: twice */
    public static void m16562twice(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (AbstractC5869Nat.shiftUpBit(16, iArr, i << 23, iArr2) | (i << 1)) & f22294P16;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        implMultiply(iArr, iArr2, iArr4);
        m16557reduce(iArr4, iArr3);
    }

    /* renamed from: square */
    public static void m16559square(int[] iArr, int[] iArr2, int[] iArr3) {
        implSquare(iArr, iArr3);
        m16557reduce(iArr3, iArr2);
    }

    /* renamed from: squareN */
    public static void m16561squareN(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        implSquare(iArr, iArr3);
        while (true) {
            m16557reduce(iArr3, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                implSquare(iArr2, iArr3);
            }
        }
    }
}
