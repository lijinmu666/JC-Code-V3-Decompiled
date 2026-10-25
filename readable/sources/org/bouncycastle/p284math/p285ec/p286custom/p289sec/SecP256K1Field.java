package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP256K1Field {

    /* renamed from: P7 */
    private static final int f22263P7 = -1;

    /* renamed from: PExt15 */
    private static final int f22265PExt15 = -1;

    /* renamed from: PInv33 */
    private static final int f22267PInv33 = 977;

    /* renamed from: P */
    static final int[] f22262P = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: PExt */
    private static final int[] f22264PExt = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* renamed from: PExtInv */
    private static final int[] f22266PExtInv = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    /* renamed from: add */
    public static void m16505add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.m17060add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && AbstractC5874Nat256.m17074gte(iArr3, f22262P))) {
            AbstractC5869Nat.m16887add33To(8, f22267PInv33, iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16506addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(16, iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && AbstractC5869Nat.m16921gte(16, iArr3, f22264PExt))) {
            int[] iArr4 = f22266PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(16, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: addOne */
    public static void m16507addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && AbstractC5874Nat256.m17074gte(iArr2, f22262P))) {
            AbstractC5869Nat.m16887add33To(8, f22267PInv33, iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5874Nat256.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[7] == -1) {
            int[] iArr = f22262P;
            if (AbstractC5874Nat256.m17074gte(iArrFromBigInteger, iArr)) {
                AbstractC5874Nat256.m17088subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16508half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(8, iArr2, AbstractC5874Nat256.m17060add(iArr, f22262P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16509inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22262P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16510isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(8, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17079mul(iArr, iArr2, iArrCreateExt);
        m16513reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && AbstractC5869Nat.m16921gte(16, iArr3, f22264PExt))) {
            int[] iArr4 = f22266PExtInv;
            if (AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16924incAt(16, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: negate */
    public static void m16511negate(int[] iArr, int[] iArr2) {
        if (m16510isZero(iArr) == 0) {
            AbstractC5874Nat256.m17085sub(f22262P, iArr, iArr2);
        } else {
            int[] iArr3 = f22262P;
            AbstractC5874Nat256.m17085sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16512random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 8);
        } while (AbstractC5869Nat.lessThan(8, iArr, f22262P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16512random(secureRandom, iArr);
        } while (m16510isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16513reduce(int[] iArr, int[] iArr2) {
        if (AbstractC5874Nat256.mul33DWordAdd(f22267PInv33, AbstractC5874Nat256.mul33Add(f22267PInv33, iArr, 8, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[7] == -1 && AbstractC5874Nat256.m17074gte(iArr2, f22262P))) {
            AbstractC5869Nat.m16887add33To(8, f22267PInv33, iArr2);
        }
    }

    public static void reduce32(int i, int[] iArr) {
        if ((i == 0 || AbstractC5874Nat256.mul33WordAdd(f22267PInv33, i, iArr, 0) == 0) && !(iArr[7] == -1 && AbstractC5874Nat256.m17074gte(iArr, f22262P))) {
            return;
        }
        AbstractC5869Nat.m16887add33To(8, f22267PInv33, iArr);
    }

    /* renamed from: square */
    public static void m16514square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArr, iArrCreateExt);
        m16513reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16516squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArr, iArrCreateExt);
        while (true) {
            m16513reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5874Nat256.m17083square(iArr2, iArrCreateExt);
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.m17085sub(iArr, iArr2, iArr3) != 0) {
            AbstractC5869Nat.sub33From(8, f22267PInv33, iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(16, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22266PExtInv;
            if (AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3) != 0) {
                AbstractC5869Nat.m16911decAt(16, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: twice */
    public static void m16518twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && AbstractC5874Nat256.m17074gte(iArr2, f22262P))) {
            AbstractC5869Nat.m16887add33To(8, f22267PInv33, iArr2);
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        AbstractC5874Nat256.m17079mul(iArr, iArr2, iArr4);
        m16513reduce(iArr4, iArr3);
    }

    /* renamed from: square */
    public static void m16515square(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.m17083square(iArr, iArr3);
        m16513reduce(iArr3, iArr2);
    }

    /* renamed from: squareN */
    public static void m16517squareN(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.m17083square(iArr, iArr3);
        while (true) {
            m16513reduce(iArr3, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5874Nat256.m17083square(iArr2, iArr3);
            }
        }
    }
}
