package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.pqc.legacy.picnic.Utils */
/* loaded from: classes2.dex */
class C6219Utils {
    public static int ceil_log2(int i) {
        if (i == 0) {
            return 0;
        }
        return 32 - m18107nlz(i - 1);
    }

    /* renamed from: getBit */
    public static byte m18104getBit(byte[] bArr, int i) {
        return (byte) ((bArr[i >>> 3] >>> ((i & 7) ^ 7)) & 1);
    }

    public static int getBitFromWordArray(int[] iArr, int i) {
        return m18106getBit(iArr, i);
    }

    public static byte getCrumbAligned(byte[] bArr, int i) {
        int i2 = bArr[i >>> 2] >>> (((i << 1) & 6) ^ 6);
        return (byte) (((i2 & 2) >> 1) | ((i2 & 1) << 1));
    }

    public static int getTrailingBitsMask(int i) {
        int i2 = i & (-8);
        int i3 = ~((-1) << i2);
        int i4 = i & 7;
        return i4 != 0 ? i3 ^ (((65280 >>> i4) & 255) << i2) : i3;
    }

    /* renamed from: nlz */
    private static int m18107nlz(int i) {
        int i2;
        if (i == 0) {
            return 32;
        }
        if ((i >>> 16) == 0) {
            i <<= 16;
            i2 = 17;
        } else {
            i2 = 1;
        }
        if ((i >>> 24) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if ((i >>> 28) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if ((i >>> 30) == 0) {
            i2 += 2;
            i <<= 2;
        }
        return i2 - (i >>> 31);
    }

    public static int numBytes(int i) {
        if (i == 0) {
            return 0;
        }
        return ((i - 1) / 8) + 1;
    }

    /* renamed from: parity */
    public static int m18108parity(byte[] bArr, int i) {
        byte b = bArr[0];
        for (int i2 = 1; i2 < i; i2++) {
            b = (byte) (b ^ bArr[i2]);
        }
        return Integers.bitCount(b & C1126UByte.MAX_VALUE) & 1;
    }

    public static int parity16(int i) {
        return Integers.bitCount(i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) & 1;
    }

    public static int parity32(int i) {
        return Integers.bitCount(i) & 1;
    }

    /* renamed from: setBit */
    public static int m18109setBit(int i, int i2, int i3) {
        int i4 = i2 ^ 7;
        return (i & (~(1 << i4))) | (i3 << i4);
    }

    public static void setBitInWordArray(int[] iArr, int i, int i2) {
        m18111setBit(iArr, i, i2);
    }

    public static void zeroTrailingBits(int[] iArr, int i) {
        if ((i & 31) != 0) {
            int i2 = i >>> 5;
            iArr[i2] = getTrailingBitsMask(i) & iArr[i2];
        }
    }

    /* renamed from: getBit */
    public static int m18105getBit(int i, int i2) {
        return (i >>> (i2 ^ 7)) & 1;
    }

    /* renamed from: setBit */
    public static void m18110setBit(byte[] bArr, int i, byte b) {
        int i2 = i >>> 3;
        int i3 = (i & 7) ^ 7;
        bArr[i2] = (byte) ((b << i3) | (bArr[i2] & (~(1 << i3))));
    }

    /* renamed from: getBit */
    public static int m18106getBit(int[] iArr, int i) {
        return (iArr[i >>> 5] >>> ((i & 31) ^ 7)) & 1;
    }

    /* renamed from: setBit */
    public static void m18111setBit(int[] iArr, int i, int i2) {
        int i3 = i >>> 5;
        int i4 = (i & 31) ^ 7;
        iArr[i3] = (i2 << i4) | (iArr[i3] & (~(1 << i4)));
    }
}
