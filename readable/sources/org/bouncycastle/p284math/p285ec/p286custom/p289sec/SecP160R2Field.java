package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5871Nat160;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP160R2Field {

    /* renamed from: P4 */
    private static final int f22208P4 = -1;

    /* renamed from: PExt9 */
    private static final int f22210PExt9 = -1;

    /* renamed from: PInv33 */
    private static final int f22212PInv33 = 21389;

    /* renamed from: P */
    static final int[] f22207P = {-21389, -2, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22209PExt = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22211PExtInv = {-457489321, -42779, -2, -1, -1, 42777, 2};

    /* renamed from: add */
    public static void m16436add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5871Nat160.m16984add(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && AbstractC5871Nat160.m16994gte(iArr3, f22207P))) {
            AbstractC5869Nat.m16887add33To(5, f22212PInv33, iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16437addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(10, iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && AbstractC5869Nat.m16921gte(10, iArr3, f22209PExt))) {
            int[] iArr4 = f22211PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16438addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && AbstractC5871Nat160.m16994gte(iArr2, f22207P))) {
            AbstractC5869Nat.m16887add33To(5, f22212PInv33, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5871Nat160.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[4] == -1) {
            int[] iArr = f22207P;
            if (AbstractC5871Nat160.m16994gte(iArrFromBigInteger, iArr)) {
                AbstractC5871Nat160.m17005subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16439half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(5, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(5, iArr2, AbstractC5871Nat160.m16984add(iArr, f22207P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16440inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22207P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16441isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(5, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        AbstractC5871Nat160.m16998mul(iArr, iArr2, iArrCreateExt);
        m16444reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5871Nat160.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && AbstractC5869Nat.m16921gte(10, iArr3, f22209PExt))) {
            int[] iArr4 = f22211PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16442negate(int[] iArr, int[] iArr2) {
        if (m16441isZero(iArr) == 0) {
            AbstractC5871Nat160.m17003sub(f22207P, iArr, iArr2);
        } else {
            int[] iArr3 = f22207P;
            AbstractC5871Nat160.m17003sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16443random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[20];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 5);
        } while (AbstractC5869Nat.lessThan(5, iArr, f22207P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16443random(secureRandom, iArr);
        } while (m16441isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16444reduce(int[] iArr, int[] iArr2) {
        if (AbstractC5871Nat160.mul33DWordAdd(f22212PInv33, AbstractC5871Nat160.mul33Add(f22212PInv33, iArr, 5, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[4] == -1 && AbstractC5871Nat160.m16994gte(iArr2, f22207P))) {
            AbstractC5869Nat.m16887add33To(5, f22212PInv33, iArr2);
        }
    }

    public static void reduce32(int i, int[] iArr) {
        if ((i == 0 || AbstractC5871Nat160.mul33WordAdd(f22212PInv33, i, iArr, 0) == 0) && !(iArr[4] == -1 && AbstractC5871Nat160.m16994gte(iArr, f22207P))) {
            return;
        }
        AbstractC5869Nat.m16887add33To(5, f22212PInv33, iArr);
    }

    /* renamed from: square */
    public static void m16445square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        AbstractC5871Nat160.m17001square(iArr, iArrCreateExt);
        m16444reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16446squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        AbstractC5871Nat160.m17001square(iArr, iArrCreateExt);
        while (true) {
            m16444reduce(iArrCreateExt, iArr2);
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
            AbstractC5869Nat.sub33From(5, f22212PInv33, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22211PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16447twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && AbstractC5871Nat160.m16994gte(iArr2, f22207P))) {
            AbstractC5869Nat.m16887add33To(5, f22212PInv33, iArr2);
        }
    }
}
