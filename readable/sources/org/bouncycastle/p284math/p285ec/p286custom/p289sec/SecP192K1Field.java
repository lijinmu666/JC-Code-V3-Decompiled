package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP192K1Field {

    /* renamed from: P5 */
    private static final int f22219P5 = -1;

    /* renamed from: PExt11 */
    private static final int f22221PExt11 = -1;

    /* renamed from: PInv33 */
    private static final int f22223PInv33 = 4553;

    /* renamed from: P */
    static final int[] f22218P = {-4553, -2, -1, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22220PExt = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22222PExtInv = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    /* renamed from: add */
    public static void m16449add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5872Nat192.m17007add(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && AbstractC5872Nat192.m17020gte(iArr3, f22218P))) {
            AbstractC5869Nat.m16887add33To(6, f22223PInv33, iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16450addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr3, f22220PExt))) {
            int[] iArr4 = f22222PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16451addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && AbstractC5872Nat192.m17020gte(iArr2, f22218P))) {
            AbstractC5869Nat.m16887add33To(6, f22223PInv33, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5872Nat192.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[5] == -1) {
            int[] iArr = f22218P;
            if (AbstractC5872Nat192.m17020gte(iArrFromBigInteger, iArr)) {
                AbstractC5872Nat192.m17032subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16452half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(6, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(6, iArr2, AbstractC5872Nat192.m17007add(iArr, f22218P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16453inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22218P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16454isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(6, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17025mul(iArr, iArr2, iArrCreateExt);
        m16457reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5872Nat192.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && AbstractC5869Nat.m16921gte(12, iArr3, f22220PExt))) {
            int[] iArr4 = f22222PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16455negate(int[] iArr, int[] iArr2) {
        if (m16454isZero(iArr) == 0) {
            AbstractC5872Nat192.m17030sub(f22218P, iArr, iArr2);
        } else {
            int[] iArr3 = f22218P;
            AbstractC5872Nat192.m17030sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16456random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[24];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 6);
        } while (AbstractC5869Nat.lessThan(6, iArr, f22218P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16456random(secureRandom, iArr);
        } while (m16454isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16457reduce(int[] iArr, int[] iArr2) {
        if (AbstractC5872Nat192.mul33DWordAdd(f22223PInv33, AbstractC5872Nat192.mul33Add(f22223PInv33, iArr, 6, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[5] == -1 && AbstractC5872Nat192.m17020gte(iArr2, f22218P))) {
            AbstractC5869Nat.m16887add33To(6, f22223PInv33, iArr2);
        }
    }

    public static void reduce32(int i, int[] iArr) {
        if ((i == 0 || AbstractC5872Nat192.mul33WordAdd(f22223PInv33, i, iArr, 0) == 0) && !(iArr[5] == -1 && AbstractC5872Nat192.m17020gte(iArr, f22218P))) {
            return;
        }
        AbstractC5869Nat.m16887add33To(6, f22223PInv33, iArr);
    }

    /* renamed from: square */
    public static void m16458square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17028square(iArr, iArrCreateExt);
        m16457reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16459squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        AbstractC5872Nat192.m17028square(iArr, iArrCreateExt);
        while (true) {
            m16457reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5872Nat192.m17028square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5872Nat192.m17030sub(iArr, iArr2, iArr3) != 0) {
            AbstractC5869Nat.sub33From(6, f22223PInv33, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(12, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22222PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16460twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && AbstractC5872Nat192.m17020gte(iArr2, f22218P))) {
            AbstractC5869Nat.m16887add33To(6, f22223PInv33, iArr2);
        }
    }
}
