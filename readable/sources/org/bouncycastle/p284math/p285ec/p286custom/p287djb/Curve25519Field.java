package org.bouncycastle.p284math.p285ec.p286custom.p287djb;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p122kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes2.dex */
public class Curve25519Field {

    /* renamed from: M */
    private static final long f22162M = 4294967295L;

    /* renamed from: P7 */
    private static final int f22164P7 = Integer.MAX_VALUE;

    /* renamed from: PInv */
    private static final int f22166PInv = 19;

    /* renamed from: P */
    static final int[] f22163P = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* renamed from: PExt */
    private static final int[] f22165PExt = {361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};

    /* renamed from: add */
    public static void m16383add(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.m17060add(iArr, iArr2, iArr3);
        if (AbstractC5874Nat256.m17074gte(iArr3, f22163P)) {
            subPFrom(iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16384addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5869Nat.m16884add(16, iArr, iArr2, iArr3);
        if (AbstractC5869Nat.m16921gte(16, iArr3, f22165PExt)) {
            subPExtFrom(iArr3);
        }
    }

    /* renamed from: addOne */
    public static void m16385addOne(int[] iArr, int[] iArr2) {
        AbstractC5869Nat.m16923inc(8, iArr, iArr2);
        if (AbstractC5874Nat256.m17074gte(iArr2, f22163P)) {
            subPFrom(iArr2);
        }
    }

    private static int addPExtTo(int[] iArr) {
        int[] iArr2 = f22165PExt;
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L);
        iArr[0] = (int) j;
        long jM16924incAt = j >> 32;
        if (jM16924incAt != 0) {
            jM16924incAt = AbstractC5869Nat.m16924incAt(8, iArr, 1);
        }
        long j2 = jM16924incAt + ((iArr[8] & 4294967295L) - 19);
        iArr[8] = (int) j2;
        long jM16911decAt = j2 >> 32;
        if (jM16911decAt != 0) {
            jM16911decAt = AbstractC5869Nat.m16911decAt(15, iArr, 9);
        }
        long j3 = jM16911decAt + (iArr[15] & 4294967295L) + (4294967295L & (iArr2[15] + 1));
        iArr[15] = (int) j3;
        return (int) (j3 >> 32);
    }

    /* renamed from: addPTo */
    private static int m16386addPTo(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 19;
        iArr[0] = (int) j;
        long jM16911decAt = j >> 32;
        if (jM16911decAt != 0) {
            jM16911decAt = AbstractC5869Nat.m16911decAt(7, iArr, 1);
        }
        long j2 = jM16911decAt + (4294967295L & iArr[7]) + 2147483648L;
        iArr[7] = (int) j2;
        return (int) (j2 >> 32);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5874Nat256.fromBigInteger(bigInteger);
        while (true) {
            int[] iArr = f22163P;
            if (!AbstractC5874Nat256.m17074gte(iArrFromBigInteger, iArr)) {
                return iArrFromBigInteger;
            }
            AbstractC5874Nat256.m17088subFrom(iArr, iArrFromBigInteger);
        }
    }

    /* renamed from: half */
    public static void m16387half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            AbstractC5874Nat256.m17060add(iArr, f22163P, iArr2);
            AbstractC5869Nat.shiftDownBit(8, iArr2, 0);
        }
    }

    /* renamed from: inv */
    public static void m16388inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22163P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16389isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(8, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17079mul(iArr, iArr2, iArrCreateExt);
        m16392reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.mulAddTo(iArr, iArr2, iArr3);
        if (AbstractC5869Nat.m16921gte(16, iArr3, f22165PExt)) {
            subPExtFrom(iArr3);
        }
    }

    /* renamed from: negate */
    public static void m16390negate(int[] iArr, int[] iArr2) {
        if (m16389isZero(iArr) == 0) {
            AbstractC5874Nat256.m17085sub(f22163P, iArr, iArr2);
        } else {
            int[] iArr3 = f22163P;
            AbstractC5874Nat256.m17085sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16391random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 8);
            iArr[7] = iArr[7] & Integer.MAX_VALUE;
        } while (AbstractC5869Nat.lessThan(8, iArr, f22163P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16391random(secureRandom, iArr);
        } while (m16389isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16392reduce(int[] iArr, int[] iArr2) {
        int i = iArr[7];
        AbstractC5869Nat.shiftUpBit(8, iArr, 8, i, iArr2, 0);
        int iMulByWordAddTo = AbstractC5874Nat256.mulByWordAddTo(19, iArr, iArr2) << 1;
        int i2 = iArr2[7];
        iArr2[7] = (i2 & Integer.MAX_VALUE) + AbstractC5869Nat.addWordTo(7, (iMulByWordAddTo + ((i2 >>> 31) - (i >>> 31))) * 19, iArr2);
        if (AbstractC5874Nat256.m17074gte(iArr2, f22163P)) {
            subPFrom(iArr2);
        }
    }

    public static void reduce27(int i, int[] iArr) {
        int i2 = iArr[7];
        iArr[7] = (i2 & Integer.MAX_VALUE) + AbstractC5869Nat.addWordTo(7, ((i << 1) | (i2 >>> 31)) * 19, iArr);
        if (AbstractC5874Nat256.m17074gte(iArr, f22163P)) {
            subPFrom(iArr);
        }
    }

    /* renamed from: square */
    public static void m16393square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArr, iArrCreateExt);
        m16392reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16394squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArr, iArrCreateExt);
        while (true) {
            m16392reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5874Nat256.m17083square(iArr2, iArrCreateExt);
            }
        }
    }

    private static int subPExtFrom(int[] iArr) {
        int[] iArr2 = f22165PExt;
        long j = (iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L);
        iArr[0] = (int) j;
        long jM16911decAt = j >> 32;
        if (jM16911decAt != 0) {
            jM16911decAt = AbstractC5869Nat.m16911decAt(8, iArr, 1);
        }
        long j2 = jM16911decAt + (iArr[8] & 4294967295L) + 19;
        iArr[8] = (int) j2;
        long jM16924incAt = j2 >> 32;
        if (jM16924incAt != 0) {
            jM16924incAt = AbstractC5869Nat.m16924incAt(15, iArr, 9);
        }
        long j3 = jM16924incAt + ((iArr[15] & 4294967295L) - (4294967295L & (iArr2[15] + 1)));
        iArr[15] = (int) j3;
        return (int) (j3 >> 32);
    }

    private static int subPFrom(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 19;
        iArr[0] = (int) j;
        long jM16924incAt = j >> 32;
        if (jM16924incAt != 0) {
            jM16924incAt = AbstractC5869Nat.m16924incAt(7, iArr, 1);
        }
        long j2 = jM16924incAt + ((4294967295L & iArr[7]) - 2147483648L);
        iArr[7] = (int) j2;
        return (int) (j2 >> 32);
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.m17085sub(iArr, iArr2, iArr3) != 0) {
            m16386addPTo(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(16, iArr, iArr2, iArr3) != 0) {
            addPExtTo(iArr3);
        }
    }

    /* renamed from: twice */
    public static void m16395twice(int[] iArr, int[] iArr2) {
        AbstractC5869Nat.shiftUpBit(8, iArr, 0, iArr2);
        if (AbstractC5874Nat256.m17074gte(iArr2, f22163P)) {
            subPFrom(iArr2);
        }
    }
}
