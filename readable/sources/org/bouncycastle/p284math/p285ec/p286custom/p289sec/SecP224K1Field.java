package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP224K1Field {

    /* renamed from: P6 */
    private static final int f22241P6 = -1;

    /* renamed from: PExt13 */
    private static final int f22243PExt13 = -1;

    /* renamed from: PInv33 */
    private static final int f22245PInv33 = 6803;

    /* renamed from: P */
    static final int[] f22240P = {-6803, -2, -1, -1, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22242PExt = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22244PExtInv = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    /* renamed from: add */
    public static void m16475add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5873Nat224.m17035add(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && AbstractC5873Nat224.m17046gte(iArr3, f22240P))) {
            AbstractC5869Nat.m16887add33To(7, f22245PInv33, iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16476addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && AbstractC5869Nat.m16921gte(14, iArr3, f22242PExt))) {
            int[] iArr4 = f22244PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16477addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && AbstractC5873Nat224.m17046gte(iArr2, f22240P))) {
            AbstractC5869Nat.m16887add33To(7, f22245PInv33, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5873Nat224.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[6] == -1 && AbstractC5873Nat224.m17046gte(iArrFromBigInteger, f22240P)) {
            AbstractC5869Nat.m16887add33To(7, f22245PInv33, iArrFromBigInteger);
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16478half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(7, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(7, iArr2, AbstractC5873Nat224.m17035add(iArr, f22240P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16479inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22240P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16480isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(7, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17050mul(iArr, iArr2, iArrCreateExt);
        m16483reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5873Nat224.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && AbstractC5869Nat.m16921gte(14, iArr3, f22242PExt))) {
            int[] iArr4 = f22244PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16481negate(int[] iArr, int[] iArr2) {
        if (m16480isZero(iArr) == 0) {
            AbstractC5873Nat224.m17055sub(f22240P, iArr, iArr2);
        } else {
            int[] iArr3 = f22240P;
            AbstractC5873Nat224.m17055sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16482random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[28];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 7);
        } while (AbstractC5869Nat.lessThan(7, iArr, f22240P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16482random(secureRandom, iArr);
        } while (m16480isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16483reduce(int[] iArr, int[] iArr2) {
        if (AbstractC5873Nat224.mul33DWordAdd(f22245PInv33, AbstractC5873Nat224.mul33Add(f22245PInv33, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && AbstractC5873Nat224.m17046gte(iArr2, f22240P))) {
            AbstractC5869Nat.m16887add33To(7, f22245PInv33, iArr2);
        }
    }

    public static void reduce32(int i, int[] iArr) {
        if ((i == 0 || AbstractC5873Nat224.mul33WordAdd(f22245PInv33, i, iArr, 0) == 0) && !(iArr[6] == -1 && AbstractC5873Nat224.m17046gte(iArr, f22240P))) {
            return;
        }
        AbstractC5869Nat.m16887add33To(7, f22245PInv33, iArr);
    }

    /* renamed from: square */
    public static void m16484square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17053square(iArr, iArrCreateExt);
        m16483reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16485squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        AbstractC5873Nat224.m17053square(iArr, iArrCreateExt);
        while (true) {
            m16483reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5873Nat224.m17053square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5873Nat224.m17055sub(iArr, iArr2, iArr3) != 0) {
            AbstractC5869Nat.sub33From(7, f22245PInv33, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22244PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16486twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && AbstractC5873Nat224.m17046gte(iArr2, f22240P))) {
            AbstractC5869Nat.m16887add33To(7, f22245PInv33, iArr2);
        }
    }
}
