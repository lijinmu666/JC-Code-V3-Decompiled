package org.bouncycastle.p314pqc.p316crypto.p329snova;

import org.bouncycastle.p361util.C6242GF16;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class GF16Utils {
    private static final int GF16_MASK = 585;

    public static int ctGF16IsNotZero(byte b) {
        int i = b & C1126UByte.MAX_VALUE;
        return ((i >>> 3) | (i >>> 1) | i | (i >>> 2)) & 1;
    }

    public static void decodeMergeInHalf(byte[] bArr, byte[] bArr2, int i) {
        int i2 = (i + 1) >>> 1;
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = (byte) (bArr[i3] & 15);
            bArr2[i3 + i2] = (byte) ((bArr[i3] >>> 4) & 15);
        }
    }

    public static void encodeMergeInHalf(byte[] bArr, int i, byte[] bArr2) {
        int i2 = (i + 1) >>> 1;
        int i3 = 0;
        while (i3 < i / 2) {
            bArr2[i3] = (byte) (bArr[i3] | (bArr[i2] << 4));
            i3++;
            i2++;
        }
        if ((i & 1) == 1) {
            bArr2[i3] = bArr[i3];
        }
    }

    public static int gf16FromNibble(int i) {
        int i2 = i | (i << 4);
        return ((i2 << 2) & 520) | (i2 & 65);
    }

    private static int gf16Reduce(int i) {
        int i2 = 1227133513 & i;
        int i3 = i >>> 12;
        int i4 = (i3 ^ (i3 << 3)) ^ i2;
        int i5 = i4 >>> 12;
        int i6 = i4 ^ (i5 ^ (i5 << 3));
        int i7 = i6 >>> 12;
        return (i6 ^ (i7 ^ (i7 << 3))) & GF16_MASK;
    }

    public static byte gf16ToNibble(int i) {
        int iGf16Reduce = gf16Reduce(i);
        int i2 = iGf16Reduce | (iGf16Reduce >>> 4);
        return (byte) (((i2 >>> 2) & 10) | (i2 & 5));
    }

    public static void gf16mMul(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5 = 0;
            while (i5 < i) {
                bArr3[i4] = C6242GF16.innerProduct(bArr, i3, bArr2, i5, i);
                i5++;
                i4++;
            }
            i2++;
            i3 += i;
        }
    }

    public static void gf16mMulMul(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            for (int i5 = 0; i5 < i; i5++) {
                bArr4[i5] = C6242GF16.innerProduct(bArr, i3, bArr2, i5, i);
            }
            int i6 = 0;
            while (i6 < i) {
                bArr5[i4] = C6242GF16.innerProduct(bArr4, 0, bArr3, i6, i);
                i6++;
                i4++;
            }
            i2++;
            i3 += i;
        }
    }

    public static void gf16mMulMulTo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            for (int i5 = 0; i5 < i; i5++) {
                bArr4[i5] = C6242GF16.innerProduct(bArr, i3, bArr2, i5, i);
            }
            int i6 = 0;
            while (i6 < i) {
                bArr5[i4] = (byte) (bArr5[i4] ^ C6242GF16.innerProduct(bArr4, 0, bArr3, i6, i));
                i6++;
                i4++;
            }
            i2++;
            i3 += i;
        }
    }

    public static void gf16mMulTo(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = 0;
            while (i6 < i3) {
                bArr3[i2] = (byte) (bArr3[i2] ^ C6242GF16.innerProduct(bArr, i5, bArr2, i + i6, i3));
                i6++;
                i2++;
            }
            i4++;
            i5 += i3;
        }
    }

    public static void gf16mMulToTo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5 = 0;
            while (i5 < i) {
                bArr4[i4] = (byte) (bArr4[i4] ^ C6242GF16.innerProduct(bArr, i3, bArr2, i5, i));
                bArr5[i4] = (byte) (bArr5[i4] ^ C6242GF16.innerProduct(bArr2, i3, bArr3, i5, i));
                i5++;
                i4++;
            }
            i2++;
            i3 += i;
        }
    }

    public static void gf16mTranMulMul(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i + i6;
                int i8 = 0;
                byte bM18291mul = 0;
                int i9 = i3;
                while (i8 < i2) {
                    bM18291mul = (byte) (bM18291mul ^ C6242GF16.m18291mul(bArr[i7], bArr4[i9]));
                    i8++;
                    i7 += i2;
                    i9 += i2;
                }
                bArr6[i6] = bM18291mul;
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < i2) {
                byte bM18291mul2 = 0;
                for (int i12 = 0; i12 < i2; i12++) {
                    bM18291mul2 = (byte) (bM18291mul2 ^ C6242GF16.m18291mul(bArr2[i11 + i12], bArr6[i12]));
                }
                bArr7[i3 + i11] = bM18291mul2;
                i10++;
                i11 += i2;
            }
            for (int i13 = 0; i13 < i2; i13++) {
                bArr6[i13] = C6242GF16.innerProduct(bArr5, i4, bArr, i + i13, i2);
            }
            int i14 = 0;
            while (i14 < i2) {
                bArr8[i5] = C6242GF16.innerProduct(bArr6, 0, bArr3, i14, i2);
                i14++;
                i5++;
            }
            i3++;
            i4 += i2;
        }
    }

    public static void gf16mMulTo(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5 = 0;
            while (i5 < i) {
                bArr3[i4] = (byte) (bArr3[i4] ^ C6242GF16.innerProduct(bArr, i3, bArr2, i5, i));
                i5++;
                i4++;
            }
            i2++;
            i3 += i;
        }
    }

    public static void gf16mMulTo(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = 0;
            while (i5 < i2) {
                bArr3[i] = (byte) (bArr3[i] ^ C6242GF16.innerProduct(bArr, i4, bArr2, i5, i2));
                i5++;
                i++;
            }
            i3++;
            i4 += i2;
        }
    }

    public static void gf16mMulTo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = 0;
            while (i5 < i2) {
                bArr5[i] = (byte) (bArr5[i] ^ (C6242GF16.innerProduct(bArr, i4, bArr2, i5, i2) ^ C6242GF16.innerProduct(bArr3, i4, bArr4, i5, i2)));
                i5++;
                i++;
            }
            i3++;
            i4 += i2;
        }
    }
}
