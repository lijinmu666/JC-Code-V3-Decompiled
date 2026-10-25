package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class SecP256R1Field {

    /* renamed from: M */
    private static final long f22273M = 4294967295L;

    /* renamed from: P7 */
    private static final int f22275P7 = -1;
    private static final int PExt15s1 = Integer.MAX_VALUE;

    /* renamed from: P */
    static final int[] f22274P = {-1, -1, -1, 0, 0, 0, 1, -1};

    /* renamed from: PExt */
    private static final int[] f22276PExt = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    /* renamed from: add */
    public static void m16520add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.m17060add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && AbstractC5874Nat256.m17074gte(iArr3, f22274P))) {
            addPInvTo(iArr3);
        }
    }

    /* renamed from: addExt */
    public static void m16521addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16884add(16, iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && AbstractC5869Nat.m16921gte(16, iArr3, f22276PExt))) {
            AbstractC5869Nat.m16940subFrom(16, f22276PExt, iArr3);
        }
    }

    /* renamed from: addOne */
    public static void m16522addOne(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.m16923inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && AbstractC5874Nat256.m17074gte(iArr2, f22274P))) {
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
        long j5 = j2 + ((iArr[3] & 4294967295L) - 1);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + ((iArr[6] & 4294967295L) - 1);
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + (4294967295L & iArr[7]) + 1);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] iArrFromBigInteger = AbstractC5874Nat256.fromBigInteger(bigInteger);
        if (iArrFromBigInteger[7] == -1) {
            int[] iArr = f22274P;
            if (AbstractC5874Nat256.m17074gte(iArrFromBigInteger, iArr)) {
                AbstractC5874Nat256.m17088subFrom(iArr, iArrFromBigInteger);
            }
        }
        return iArrFromBigInteger;
    }

    /* renamed from: half */
    public static void m16523half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            AbstractC5869Nat.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            AbstractC5869Nat.shiftDownBit(8, iArr2, AbstractC5874Nat256.m17060add(iArr, f22274P, iArr2));
        }
    }

    /* renamed from: inv */
    public static void m16524inv(int[] iArr, int[] iArr2) {
        AbstractC5867Mod.checkedModOddInverse(f22274P, iArr, iArr2);
    }

    /* renamed from: isZero */
    public static int m16525isZero(int[] iArr) {
        return AbstractC5869Nat.equalToZero(8, iArr);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17079mul(iArr, iArr2, iArrCreateExt);
        m16528reduce(iArrCreateExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && AbstractC5869Nat.m16921gte(16, iArr3, f22276PExt))) {
            AbstractC5869Nat.m16940subFrom(16, f22276PExt, iArr3);
        }
    }

    /* renamed from: negate */
    public static void m16526negate(int[] iArr, int[] iArr2) {
        if (m16525isZero(iArr) == 0) {
            AbstractC5874Nat256.m17085sub(f22274P, iArr, iArr2);
        } else {
            int[] iArr3 = f22274P;
            AbstractC5874Nat256.m17085sub(iArr3, iArr3, iArr2);
        }
    }

    /* renamed from: random */
    public static void m16527random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, 8);
        } while (AbstractC5869Nat.lessThan(8, iArr, f22274P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            m16527random(secureRandom, iArr);
        } while (m16525isZero(iArr) != 0);
    }

    /* renamed from: reduce */
    public static void m16528reduce(int[] iArr, int[] iArr2) {
        long j = iArr[9] & 4294967295L;
        long j2 = iArr[10] & 4294967295L;
        long j3 = iArr[11] & 4294967295L;
        long j4 = iArr[12] & 4294967295L;
        long j5 = iArr[13] & 4294967295L;
        long j6 = iArr[14] & 4294967295L;
        long j7 = iArr[15] & 4294967295L;
        long j8 = (iArr[8] & 4294967295L) - 6;
        long j9 = j8 + j;
        long j10 = j + j2;
        long j11 = (j2 + j3) - j7;
        long j12 = j3 + j4;
        long j13 = j4 + j5;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j14 - j9;
        long j17 = ((iArr[0] & 4294967295L) - j12) - j16;
        iArr2[0] = (int) j17;
        long j18 = (j17 >> 32) + ((((iArr[1] & 4294967295L) + j10) - j13) - j15);
        iArr2[1] = (int) j18;
        long j19 = (j18 >> 32) + (((iArr[2] & 4294967295L) + j11) - j14);
        iArr2[2] = (int) j19;
        long j20 = (j19 >> 32) + ((((iArr[3] & 4294967295L) + (j12 << 1)) + j16) - j15);
        iArr2[3] = (int) j20;
        long j21 = (j20 >> 32) + ((((iArr[4] & 4294967295L) + (j13 << 1)) + j6) - j10);
        iArr2[4] = (int) j21;
        long j22 = (j21 >> 32) + (((iArr[5] & 4294967295L) + (j14 << 1)) - j11);
        iArr2[5] = (int) j22;
        long j23 = (j22 >> 32) + (iArr[6] & 4294967295L) + (j15 << 1) + j16;
        iArr2[6] = (int) j23;
        long j24 = (j23 >> 32) + (((((iArr[7] & 4294967295L) + (j7 << 1)) + j8) - j11) - j13);
        iArr2[7] = (int) j24;
        reduce32((int) ((j24 >> 32) + 6), iArr2);
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
                long j6 = (j5 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + ((iArr[3] & 4294967295L) - j2);
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr[4] & 4294967295L);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (iArr[5] & 4294967295L);
                iArr[5] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = j8 + ((iArr[6] & 4294967295L) - j2);
            iArr[6] = (int) j11;
            long j12 = (j11 >> 32) + (4294967295L & iArr[7]) + j2;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && AbstractC5874Nat256.m17074gte(iArr, f22274P))) {
            addPInvTo(iArr);
        }
    }

    /* renamed from: square */
    public static void m16529square(int[] iArr, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArr, iArrCreateExt);
        m16528reduce(iArrCreateExt, iArr2);
    }

    /* renamed from: squareN */
    public static void m16531squareN(int[] iArr, int i, int[] iArr2) {
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        AbstractC5874Nat256.m17083square(iArr, iArrCreateExt);
        while (true) {
            m16528reduce(iArrCreateExt, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5874Nat256.m17083square(iArr2, iArrCreateExt);
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
        long j5 = j2 + (iArr[3] & 4294967295L) + 1;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + (iArr[6] & 4294967295L) + 1;
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + ((4294967295L & iArr[7]) - 1));
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5874Nat256.m17085sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (AbstractC5869Nat.m16936sub(16, iArr, iArr2, iArr3) != 0) {
            AbstractC5869Nat.m16891addTo(16, f22276PExt, iArr3);
        }
    }

    /* renamed from: twice */
    public static void m16533twice(int[] iArr, int[] iArr2) {
        if (AbstractC5869Nat.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && AbstractC5874Nat256.m17074gte(iArr2, f22274P))) {
            addPInvTo(iArr2);
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        AbstractC5874Nat256.m17079mul(iArr, iArr2, iArr4);
        m16528reduce(iArr4, iArr3);
    }

    /* renamed from: square */
    public static void m16530square(int[] iArr, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.m17083square(iArr, iArr3);
        m16528reduce(iArr3, iArr2);
    }

    /* renamed from: squareN */
    public static void m16532squareN(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        AbstractC5874Nat256.m17083square(iArr, iArr3);
        while (true) {
            m16528reduce(iArr3, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                AbstractC5874Nat256.m17083square(iArr2, iArr3);
            }
        }
    }
}
