package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5870Nat128;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP128R1Field {

    /* renamed from: M */
    private static final long f22181M = 4294967295L;

    /* renamed from: P3s1 */
    private static final int f22183P3s1 = 2147483646;

    /* renamed from: PExt7s1 */
    private static final int f22185PExt7s1 = 2147483646;

    /* renamed from: P */
    static final int[] f22182P = {-1, -1, -1, -3};

    /* renamed from: PExt */
    private static final int[] f22184PExt = {1, 0, 0, 4, -2, -1, 3, -4};

    /* renamed from: PExtInv */
    private static final int[] f22186PExtInv = {-1, -1, -1, -5, 1, 0, -4, 3};

    /* renamed from: add */
    public static void m16410add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5870Nat128.m16957add(iArr, iArr2, iArr3) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && AbstractC5870Nat128.m16970gte(iArr3, f22182P))) {
            addPInvTo(iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16411addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.m17060add(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && AbstractC5874Nat256.m17074gte(iArr3, f22184PExt))) {
            int[] iArr4 = f22186PExtInv;
            AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3);
        }
    }

    /* renamed from: addOne */
    public static void m16412addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && AbstractC5870Nat128.m16970gte(iArr2, f22182P))) {
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
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + (4294967295L & iArr[3]) + 2);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5870Nat128.fromBigInteger(bigInteger);
        if ((iArrFromBigInteger[3] >>> 1) >= 2147483646) {
            int[] iArr = f22182P;
            if (AbstractC5870Nat128.m16970gte(iArrFromBigInteger, iArr)) {
                AbstractC5870Nat128.m16982subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16413half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(4, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(4, iArr2, AbstractC5870Nat128.m16957add(iArr, f22182P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16414inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22182P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16415isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(4, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5870Nat128.createExt();
        AbstractC5870Nat128.m16975mul(iArr, iArr2, iArrCreateExt);
        m16418reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5870Nat128.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && AbstractC5874Nat256.m17074gte(iArr3, f22184PExt))) {
            int[] iArr4 = f22186PExtInv;
            AbstractC5869Nat.m16891addTo(iArr4.length, iArr4, iArr3);
        }
    }

    /* renamed from: negate */
    public static void m16416negate(int[] iArr, int[] iArr2) {
        if (m16415isZero(iArr) == 0) {
            AbstractC5870Nat128.m16980sub(f22182P, iArr, iArr2);
        } else {
            int[] iArr3 = f22182P;
            AbstractC5870Nat128.m16980sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16417random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[16];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 4);
        } while (AbstractC5869Nat.lessThan(4, iArr, f22182P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16417random(secureRandom, iArr);
        } while (m16415isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16418reduce(int[] iArr, int[] iArr2) {
        long j = iArr[7] & 4294967295L;
        long j2 = (iArr[3] & 4294967295L) + j;
        long j3 = (iArr[6] & 4294967295L) + (j << 1);
        long j4 = (iArr[2] & 4294967295L) + j3;
        long j5 = (iArr[5] & 4294967295L) + (j3 << 1);
        long j6 = (iArr[1] & 4294967295L) + j5;
        long j7 = (iArr[4] & 4294967295L) + (j5 << 1);
        long j8 = (iArr[0] & 4294967295L) + j7;
        iArr2[0] = (int) j8;
        long j9 = j6 + (j8 >>> 32);
        iArr2[1] = (int) j9;
        long j10 = j4 + (j9 >>> 32);
        iArr2[2] = (int) j10;
        long j11 = j2 + (j7 << 1) + (j10 >>> 32);
        iArr2[3] = (int) j11;
        reduce32((int) (j11 >>> 32), iArr2);
    }

    public static void reduce32(int i, int[] iArr) {
        while (i != 0) {
            long j = i & 4294967295L;
            long j2 = (iArr[0] & 4294967295L) + j;
            iArr[0] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j4;
                long j5 = (j4 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j5;
                j3 = j5 >> 32;
            }
            long j6 = j3 + (4294967295L & iArr[3]) + (j << 1);
            iArr[3] = (int) j6;
            i = (int) (j6 >> 32);
        }
        if ((iArr[3] >>> 1) < 2147483646 || !AbstractC5870Nat128.m16970gte(iArr, f22182P)) {
            return;
        }
        addPInvTo(iArr);
    }

    /* renamed from: square */
    public static void m16419square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5870Nat128.createExt();
        AbstractC5870Nat128.m16978square(iArr, iArrCreateExt);
        m16418reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16420squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5870Nat128.createExt();
        AbstractC5870Nat128.m16978square(iArr, iArrCreateExt);
        while (true) {
            m16418reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5870Nat128.m16978square(iArr2, iArrCreateExt);
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
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + ((4294967295L & iArr[3]) - 2));
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5870Nat128.m16980sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f22186PExtInv;
            AbstractC5869Nat.m16940subFrom(iArr4.length, iArr4, iArr3);
        }
    }

    /* renamed from: twice */
    public static void m16421twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && AbstractC5870Nat128.m16970gte(iArr2, f22182P))) {
            addPInvTo(iArr2);
        }
    }
}
