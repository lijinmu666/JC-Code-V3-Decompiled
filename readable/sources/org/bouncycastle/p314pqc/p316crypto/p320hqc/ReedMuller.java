package org.bouncycastle.p314pqc.p316crypto.p320hqc;

/* loaded from: classes2.dex */
class ReedMuller {

    public static class Codeword {

        /* renamed from: type32 */
        int[] f23210type32 = new int[4];

        /* renamed from: type8 */
        int[] f23211type8 = new int[16];
    }

    private static int Bit0Mask(int i) {
        return -(i & 1);
    }

    private static void copyCodeword(long[] jArr, Codeword[] codewordArr) {
        int[] iArr = new int[codewordArr.length * 4];
        int i = 0;
        for (Codeword codeword : codewordArr) {
            System.arraycopy(codeword.f23210type32, 0, iArr, i, 4);
            i += 4;
        }
        C6065Utils.fromByte32ArrayToLongArray(jArr, iArr);
    }

    /* renamed from: decode */
    public static void m17593decode(byte[] bArr, long[] jArr, int i, int i2) {
        int length = jArr.length / 2;
        Codeword[] codewordArr = new Codeword[length];
        int[] iArr = new int[jArr.length * 2];
        C6065Utils.fromLongArrayToByte32Array(iArr, jArr);
        for (int i3 = 0; i3 < length; i3++) {
            Codeword codeword = new Codeword();
            codewordArr[i3] = codeword;
            System.arraycopy(iArr, i3 * 4, codeword.f23210type32, 0, 4);
        }
        int[] iArr2 = new int[128];
        int[] iArr3 = new int[128];
        for (int i4 = 0; i4 < i; i4++) {
            expandThenSum(iArr2, codewordArr, i4 * i2, i2);
            hadamardTransform(iArr2, iArr3);
            iArr3[0] = iArr3[0] - (i2 * 64);
            bArr[i4] = (byte) findPeaks(iArr3);
        }
        copyCodeword(jArr, codewordArr);
    }

    /* renamed from: encode */
    public static void m17594encode(long[] jArr, byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        Codeword[] codewordArr = new Codeword[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            codewordArr[i4] = new Codeword();
        }
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i5 * i2;
            encodeSub(codewordArr[i6], bArr[i5]);
            for (int i7 = 1; i7 < i2; i7++) {
                codewordArr[i6 + i7] = codewordArr[i6];
            }
        }
        copyCodeword(jArr, codewordArr);
    }

    public static void encodeSub(Codeword codeword, int i) {
        int iBit0Mask = ((((Bit0Mask(i >> 7) ^ (Bit0Mask(i) & (-1431655766))) ^ (Bit0Mask(i >> 1) & (-858993460))) ^ (Bit0Mask(i >> 2) & (-252645136))) ^ (Bit0Mask(i >> 3) & (-16711936))) ^ (Bit0Mask(i >> 4) & (-65536));
        codeword.f23210type32[0] = iBit0Mask;
        int i2 = i >> 5;
        int iBit0Mask2 = iBit0Mask ^ Bit0Mask(i2);
        codeword.f23210type32[1] = iBit0Mask2;
        int iBit0Mask3 = Bit0Mask(i >> 6) ^ iBit0Mask2;
        codeword.f23210type32[3] = iBit0Mask3;
        codeword.f23210type32[2] = iBit0Mask3 ^ Bit0Mask(i2);
    }

    private static void expandThenSum(int[] iArr, Codeword[] codewordArr, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 32; i4++) {
                iArr[(i3 * 32) + i4] = (codewordArr[i].f23210type32[i3] >> i4) & 1;
            }
        }
        for (int i5 = 1; i5 < i2; i5++) {
            int[] iArr2 = codewordArr[i + i5].f23210type32;
            for (int i6 = 0; i6 < 4; i6++) {
                for (int i7 = 0; i7 < 32; i7++) {
                    int i8 = (i6 * 32) + i7;
                    iArr[i8] = iArr[i8] + ((iArr2[i6] >> i7) & 1);
                }
            }
        }
    }

    private static int findPeaks(int[] iArr) {
        int i = 0;
        int i2 = 0;
        int iMax = 0;
        for (int i3 = 0; i3 < 128; i3++) {
            int i4 = iArr[i3];
            int i5 = i4 > 0 ? -1 : 0;
            int i6 = ((~i5) & (-i4)) | (i5 & i4);
            if (i6 > iMax) {
                i = i4;
            }
            if (i6 > iMax) {
                i2 = i3;
            }
            iMax = Math.max(i6, iMax);
        }
        return i2 | ((i > 0 ? 1 : 0) * 128);
    }

    private static void hadamardTransform(int[] iArr, int[] iArr2) {
        int i = 0;
        while (i < 7) {
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = i2 * 2;
                int i4 = iArr[i3];
                int i5 = iArr[i3 + 1];
                iArr2[i2] = i4 + i5;
                iArr2[i2 + 64] = i4 - i5;
            }
            i++;
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
    }
}
