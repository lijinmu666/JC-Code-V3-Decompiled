package org.bouncycastle.p361util;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.util.Pack */
/* loaded from: classes2.dex */
public abstract class AbstractC6245Pack {
    public static int bigEndianToInt(byte[] bArr, int i) {
        return (bArr[i + 3] & C1126UByte.MAX_VALUE) | (bArr[i] << 24) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 8);
    }

    public static int bigEndianToInt_High(byte[] bArr, int i, int i2) {
        return bigEndianToInt_Low(bArr, i, i2) << ((4 - i2) << 3);
    }

    public static int bigEndianToInt_Low(byte[] bArr, int i, int i2) {
        int i3 = bArr[i] & C1126UByte.MAX_VALUE;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 = (i3 << 8) | (bArr[i + i4] & C1126UByte.MAX_VALUE);
        }
        return i3;
    }

    public static long bigEndianToLong(byte[] bArr, int i) {
        int iBigEndianToInt = bigEndianToInt(bArr, i);
        return (bigEndianToInt(bArr, i + 4) & BodyPartID.bodyIdMax) | ((iBigEndianToInt & BodyPartID.bodyIdMax) << 32);
    }

    public static long bigEndianToLong_High(byte[] bArr, int i, int i2) {
        return bigEndianToLong_Low(bArr, i, i2) << ((8 - i2) << 3);
    }

    public static long bigEndianToLong_Low(byte[] bArr, int i, int i2) {
        long j = bArr[i] & 255;
        for (int i3 = 1; i3 < i2; i3++) {
            j = (j << 8) | (bArr[i + i3] & 255);
        }
        return j;
    }

    public static short bigEndianToShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & C1126UByte.MAX_VALUE) | ((bArr[i] & C1126UByte.MAX_VALUE) << 8));
    }

    public static void intToBigEndian(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    public static void intToBigEndian_High(int i, byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i >>> 24);
        int i4 = 24;
        for (int i5 = 1; i5 < i3; i5++) {
            i4 -= 8;
            bArr[i2 + i5] = (byte) (i >>> i4);
        }
    }

    public static void intToBigEndian_Low(int i, byte[] bArr, int i2, int i3) {
        intToBigEndian_High(i << ((4 - i3) << 3), bArr, i2, i3);
    }

    public static void intToLittleEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public static void intToLittleEndian_High(int i, byte[] bArr, int i2, int i3) {
        intToLittleEndian_Low(i >> ((4 - i3) << 3), bArr, i2, i3);
    }

    public static void intToLittleEndian_Low(int i, byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) i;
        for (int i4 = 1; i4 < i3; i4++) {
            i >>>= 8;
            bArr[i2 + i4] = (byte) i;
        }
    }

    public static int littleEndianToInt(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16);
    }

    public static int littleEndianToInt24(byte[] bArr, int i) {
        return ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16) | (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8);
    }

    public static int littleEndianToInt_High(byte[] bArr, int i, int i2) {
        return littleEndianToInt_Low(bArr, i, i2) << ((4 - i2) << 3);
    }

    public static int littleEndianToInt_Low(byte[] bArr, int i, int i2) {
        int i3 = bArr[i] & C1126UByte.MAX_VALUE;
        int i4 = 0;
        for (int i5 = 1; i5 < i2; i5++) {
            i4 += 8;
            i3 |= (bArr[i + i5] & C1126UByte.MAX_VALUE) << i4;
        }
        return i3;
    }

    public static long littleEndianToLong(byte[] bArr, int i) {
        return ((littleEndianToInt(bArr, i + 4) & BodyPartID.bodyIdMax) << 32) | (littleEndianToInt(bArr, i) & BodyPartID.bodyIdMax);
    }

    public static long littleEndianToLong_High(byte[] bArr, int i, int i2) {
        return littleEndianToLong_Low(bArr, i, i2) << ((8 - i2) << 3);
    }

    public static long littleEndianToLong_Low(byte[] bArr, int i, int i2) {
        long j = bArr[i] & 255;
        int i3 = 0;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 += 8;
            j |= (bArr[i + i4] & 255) << i3;
        }
        return j;
    }

    public static short littleEndianToShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | (bArr[i] & C1126UByte.MAX_VALUE));
    }

    public static void longToBigEndian(long j, byte[] bArr, int i) {
        intToBigEndian((int) (j >>> 32), bArr, i);
        intToBigEndian((int) (j & BodyPartID.bodyIdMax), bArr, i + 4);
    }

    public static void longToBigEndian_High(long j, byte[] bArr, int i, int i2) {
        int i3 = 56;
        bArr[i] = (byte) (j >>> 56);
        for (int i4 = 1; i4 < i2; i4++) {
            i3 -= 8;
            bArr[i + i4] = (byte) (j >>> i3);
        }
    }

    public static void longToBigEndian_Low(long j, byte[] bArr, int i, int i2) {
        longToBigEndian_High(j << ((8 - i2) << 3), bArr, i, i2);
    }

    public static void longToLittleEndian(long j, byte[] bArr, int i) {
        intToLittleEndian((int) (BodyPartID.bodyIdMax & j), bArr, i);
        intToLittleEndian((int) (j >>> 32), bArr, i + 4);
    }

    public static void longToLittleEndian_High(long j, byte[] bArr, int i, int i2) {
        longToLittleEndian_Low(j >>> ((8 - i2) << 3), bArr, i, i2);
    }

    public static void longToLittleEndian_Low(long j, byte[] bArr, int i, int i2) {
        bArr[i] = (byte) j;
        for (int i3 = 1; i3 < i2; i3++) {
            j >>>= 8;
            bArr[i + i3] = (byte) j;
        }
    }

    public static void shortToBigEndian(short s, byte[] bArr, int i) {
        bArr[i] = (byte) (s >>> 8);
        bArr[i + 1] = (byte) s;
    }

    public static void shortToLittleEndian(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
        bArr[i + 1] = (byte) (s >>> 8);
    }

    public static void bigEndianToInt(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = bigEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static void bigEndianToLong(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = bigEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static void intToBigEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static void intToLittleEndian(int[] iArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            intToLittleEndian(iArr[i + i4], bArr, i3);
            i3 += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = littleEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static void littleEndianToLong(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = littleEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static void littleEndianToShort(byte[] bArr, int i, short[] sArr) {
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = littleEndianToShort(bArr, i);
            i += 2;
        }
    }

    public static void longToBigEndian(long[] jArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            longToBigEndian(jArr[i + i4], bArr, i3);
            i3 += 8;
        }
    }

    public static void longToLittleEndian(long[] jArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            longToLittleEndian(jArr[i + i4], bArr, i3);
            i3 += 8;
        }
    }

    public static byte[] shortToBigEndian(short s) {
        byte[] bArr = new byte[2];
        shortToBigEndian(s, bArr, 0);
        return bArr;
    }

    public static void shortToLittleEndian(short[] sArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            shortToLittleEndian(sArr[i + i4], bArr, i3);
            i3 += 2;
        }
    }

    public static void bigEndianToInt(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = bigEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static void bigEndianToLong(byte[] bArr, int i, long[] jArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i2 + i4] = bigEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static void intToBigEndian(int[] iArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            intToBigEndian(iArr[i + i4], bArr, i3);
            i3 += 4;
        }
    }

    public static void intToLittleEndian(int[] iArr, byte[] bArr, int i) {
        for (int i2 : iArr) {
            intToLittleEndian(i2, bArr, i);
            i += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = littleEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static void littleEndianToLong(byte[] bArr, int i, long[] jArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i2 + i4] = littleEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static void littleEndianToShort(byte[] bArr, int i, short[] sArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            sArr[i2 + i4] = littleEndianToShort(bArr, i);
            i += 2;
        }
    }

    public static void longToBigEndian(long[] jArr, byte[] bArr, int i) {
        for (long j : jArr) {
            longToBigEndian(j, bArr, i);
            i += 8;
        }
    }

    public static void longToLittleEndian(long[] jArr, byte[] bArr, int i) {
        for (long j : jArr) {
            longToLittleEndian(j, bArr, i);
            i += 8;
        }
    }

    public static void shortToLittleEndian(short[] sArr, byte[] bArr, int i) {
        for (short s : sArr) {
            shortToLittleEndian(s, bArr, i);
            i += 2;
        }
    }

    public static void intToBigEndian(int[] iArr, byte[] bArr, int i) {
        for (int i2 : iArr) {
            intToBigEndian(i2, bArr, i);
            i += 4;
        }
    }

    public static byte[] intToLittleEndian(int i) {
        byte[] bArr = new byte[4];
        intToLittleEndian(i, bArr, 0);
        return bArr;
    }

    public static int[] littleEndianToInt(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i2];
        littleEndianToInt(bArr, i, iArr);
        return iArr;
    }

    public static long[] littleEndianToLong(byte[] bArr, int i, int i2) {
        long[] jArr = new long[i2];
        littleEndianToLong(bArr, i, jArr);
        return jArr;
    }

    public static short[] littleEndianToShort(byte[] bArr, int i, int i2) {
        short[] sArr = new short[i2];
        littleEndianToShort(bArr, i, sArr, 0, i2);
        return sArr;
    }

    public static byte[] longToBigEndian(long j) {
        byte[] bArr = new byte[8];
        longToBigEndian(j, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long j) {
        byte[] bArr = new byte[8];
        longToLittleEndian(j, bArr, 0);
        return bArr;
    }

    public static byte[] shortToLittleEndian(short s) {
        byte[] bArr = new byte[2];
        shortToLittleEndian(s, bArr, 0);
        return bArr;
    }

    public static byte[] intToBigEndian(int i) {
        byte[] bArr = new byte[4];
        intToBigEndian(i, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        intToLittleEndian(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] longToBigEndian(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        longToBigEndian(jArr, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        longToLittleEndian(jArr, bArr, 0);
        return bArr;
    }

    public static byte[] intToBigEndian(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        intToBigEndian(iArr, bArr, 0);
        return bArr;
    }
}
