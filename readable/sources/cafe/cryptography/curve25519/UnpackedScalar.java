package cafe.cryptography.curve25519;

/* loaded from: classes.dex */
class UnpackedScalar {
    static final int MASK_24_BITS = 16777215;
    static final int MASK_29_BITS = 536870911;

    /* renamed from: ZERO */
    static final UnpackedScalar f1994ZERO = new UnpackedScalar(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: s */
    final int[] f1995s;

    public UnpackedScalar(int[] iArr) {
        if (iArr.length != 9) {
            throw new IllegalArgumentException("Invalid radix-2^29 representation");
        }
        this.f1995s = iArr;
    }

    public static UnpackedScalar fromByteArray(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Input must by 32 bytes");
        }
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                iArr[i] = iArr[i] | ((bArr[(i * 4) + i2] & 255) << (i2 * 8));
            }
        }
        int i3 = iArr[0];
        int i4 = i3 & MASK_29_BITS;
        int i5 = iArr[1];
        int i6 = ((i3 >>> 29) | (i5 << 3)) & MASK_29_BITS;
        int i7 = i5 >>> 26;
        int i8 = iArr[2];
        int i9 = (i7 | (i8 << 6)) & MASK_29_BITS;
        int i10 = i8 >>> 23;
        int i11 = iArr[3];
        int i12 = (i10 | (i11 << 9)) & MASK_29_BITS;
        int i13 = i11 >>> 20;
        int i14 = iArr[4];
        int i15 = (i13 | (i14 << 12)) & MASK_29_BITS;
        int i16 = i14 >>> 17;
        int i17 = iArr[5];
        int i18 = (i16 | (i17 << 15)) & MASK_29_BITS;
        int i19 = i17 >>> 14;
        int i20 = iArr[6];
        int i21 = (i19 | (i20 << 18)) & MASK_29_BITS;
        int i22 = iArr[7];
        return new UnpackedScalar(new int[]{i4, i6, i9, i12, i15, i18, i21, ((i20 >>> 11) | (i22 << 21)) & MASK_29_BITS, (i22 >>> 8) & MASK_24_BITS});
    }

    /* renamed from: m */
    public static long m2135m(int i, int i2) {
        return i * i2;
    }

    public static UnpackedScalar montgomeryReduce(long[] jArr) {
        UnpackedScalar unpackedScalar = Constants.f1966L;
        int[] iArr = unpackedScalar.f1995s;
        long j = jArr[0];
        int i = (int) ((j * 307527195) & 536870911);
        long jM2135m = ((j + m2135m(i, iArr[0])) >>> 29) + jArr[1] + m2135m(i, iArr[1]);
        int i2 = (int) ((jM2135m * 307527195) & 536870911);
        long jM2135m2 = ((jM2135m + m2135m(i2, iArr[0])) >>> 29) + jArr[2] + m2135m(i, iArr[2]) + m2135m(i2, iArr[1]);
        int i3 = (int) ((jM2135m2 * 307527195) & 536870911);
        long jM2135m3 = ((jM2135m2 + m2135m(i3, iArr[0])) >>> 29) + jArr[3] + m2135m(i, iArr[3]) + m2135m(i2, iArr[2]) + m2135m(i3, iArr[1]);
        int i4 = (int) ((jM2135m3 * 307527195) & 536870911);
        long jM2135m4 = ((jM2135m3 + m2135m(i4, iArr[0])) >>> 29) + jArr[4] + m2135m(i, iArr[4]) + m2135m(i2, iArr[3]) + m2135m(i3, iArr[2]) + m2135m(i4, iArr[1]);
        int i5 = (int) ((jM2135m4 * 307527195) & 536870911);
        long jM2135m5 = ((jM2135m4 + m2135m(i5, iArr[0])) >>> 29) + jArr[5] + m2135m(i2, iArr[4]) + m2135m(i3, iArr[3]) + m2135m(i4, iArr[2]) + m2135m(i5, iArr[1]);
        int i6 = (int) ((jM2135m5 * 307527195) & 536870911);
        long jM2135m6 = ((jM2135m5 + m2135m(i6, iArr[0])) >>> 29) + jArr[6] + m2135m(i3, iArr[4]) + m2135m(i4, iArr[3]) + m2135m(i5, iArr[2]) + m2135m(i6, iArr[1]);
        int i7 = (int) ((jM2135m6 * 307527195) & 536870911);
        long jM2135m7 = ((jM2135m6 + m2135m(i7, iArr[0])) >>> 29) + jArr[7] + m2135m(i4, iArr[4]) + m2135m(i5, iArr[3]) + m2135m(i6, iArr[2]) + m2135m(i7, iArr[1]);
        int i8 = (int) ((jM2135m7 * 307527195) & 536870911);
        long jM2135m8 = ((jM2135m7 + m2135m(i8, iArr[0])) >>> 29) + jArr[8] + m2135m(i, iArr[8]) + m2135m(i5, iArr[4]) + m2135m(i6, iArr[3]) + m2135m(i7, iArr[2]) + m2135m(i8, iArr[1]);
        int i9 = (int) ((307527195 * jM2135m8) & 536870911);
        long jM2135m9 = ((jM2135m8 + m2135m(i9, iArr[0])) >>> 29) + jArr[9] + m2135m(i2, iArr[8]) + m2135m(i6, iArr[4]) + m2135m(i7, iArr[3]) + m2135m(i8, iArr[2]) + m2135m(i9, iArr[1]);
        int i10 = (int) (jM2135m9 & 536870911);
        long jM2135m10 = (jM2135m9 >>> 29) + jArr[10] + m2135m(i3, iArr[8]) + m2135m(i7, iArr[4]) + m2135m(i8, iArr[3]) + m2135m(i9, iArr[2]);
        int i11 = (int) (jM2135m10 & 536870911);
        long jM2135m11 = (jM2135m10 >>> 29) + jArr[11] + m2135m(i4, iArr[8]) + m2135m(i8, iArr[4]) + m2135m(i9, iArr[3]);
        int i12 = (int) (jM2135m11 & 536870911);
        long jM2135m12 = (jM2135m11 >>> 29) + jArr[12] + m2135m(i5, iArr[8]) + m2135m(i9, iArr[4]);
        int i13 = (int) (jM2135m12 & 536870911);
        long jM2135m13 = (jM2135m12 >>> 29) + jArr[13] + m2135m(i6, iArr[8]);
        int i14 = (int) (jM2135m13 & 536870911);
        long jM2135m14 = (jM2135m13 >>> 29) + jArr[14] + m2135m(i7, iArr[8]);
        int i15 = (int) (jM2135m14 & 536870911);
        long jM2135m15 = (jM2135m14 >>> 29) + jArr[15] + m2135m(i8, iArr[8]);
        int i16 = (int) (jM2135m15 & 536870911);
        long jM2135m16 = (jM2135m15 >>> 29) + jArr[16] + m2135m(i9, iArr[8]);
        return new UnpackedScalar(new int[]{i10, i11, i12, i13, i14, i15, i16, (int) (jM2135m16 & 536870911), (int) (jM2135m16 >>> 29)}).subtract(unpackedScalar);
    }

    /* renamed from: add */
    public UnpackedScalar m2136add(UnpackedScalar unpackedScalar) {
        int[] iArr = new int[9];
        int i = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            i = (i >> 29) + this.f1995s[i2] + unpackedScalar.f1995s[i2];
            iArr[i2] = MASK_29_BITS & i;
        }
        return new UnpackedScalar(iArr).subtract(Constants.f1966L);
    }

    public long[] mulInternal(UnpackedScalar unpackedScalar) {
        int[] iArr = this.f1995s;
        int[] iArr2 = unpackedScalar.f1995s;
        long[] jArr = new long[17];
        jArr[0] = m2135m(iArr[0], iArr2[0]);
        jArr[1] = m2135m(iArr[0], iArr2[1]) + m2135m(iArr[1], iArr2[0]);
        jArr[2] = m2135m(iArr[0], iArr2[2]) + m2135m(iArr[1], iArr2[1]) + m2135m(iArr[2], iArr2[0]);
        jArr[3] = m2135m(iArr[0], iArr2[3]) + m2135m(iArr[1], iArr2[2]) + m2135m(iArr[2], iArr2[1]) + m2135m(iArr[3], iArr2[0]);
        jArr[4] = m2135m(iArr[0], iArr2[4]) + m2135m(iArr[1], iArr2[3]) + m2135m(iArr[2], iArr2[2]) + m2135m(iArr[3], iArr2[1]) + m2135m(iArr[4], iArr2[0]);
        jArr[5] = m2135m(iArr[1], iArr2[4]) + m2135m(iArr[2], iArr2[3]) + m2135m(iArr[3], iArr2[2]) + m2135m(iArr[4], iArr2[1]);
        jArr[6] = m2135m(iArr[2], iArr2[4]) + m2135m(iArr[3], iArr2[3]) + m2135m(iArr[4], iArr2[2]);
        jArr[7] = m2135m(iArr[3], iArr2[4]) + m2135m(iArr[4], iArr2[3]);
        jArr[8] = m2135m(iArr[4], iArr2[4]) - jArr[3];
        jArr[10] = jArr[5] - m2135m(iArr[5], iArr2[5]);
        jArr[11] = jArr[6] - (m2135m(iArr[5], iArr2[6]) + m2135m(iArr[6], iArr2[5]));
        jArr[12] = jArr[7] - ((m2135m(iArr[5], iArr2[7]) + m2135m(iArr[6], iArr2[6])) + m2135m(iArr[7], iArr2[5]));
        jArr[13] = m2135m(iArr[5], iArr2[8]) + m2135m(iArr[6], iArr2[7]) + m2135m(iArr[7], iArr2[6]) + m2135m(iArr[8], iArr2[5]);
        jArr[14] = m2135m(iArr[6], iArr2[8]) + m2135m(iArr[7], iArr2[7]) + m2135m(iArr[8], iArr2[6]);
        jArr[15] = m2135m(iArr[7], iArr2[8]) + m2135m(iArr[8], iArr2[7]);
        long jM2135m = m2135m(iArr[8], iArr2[8]);
        jArr[16] = jM2135m;
        long j = jArr[10];
        jArr[5] = j - jArr[0];
        long j2 = jArr[11];
        jArr[6] = j2 - jArr[1];
        jArr[7] = jArr[12] - jArr[2];
        jArr[8] = jArr[8] - jArr[13];
        jArr[9] = jArr[14] + jArr[4];
        jArr[10] = jArr[15] + j;
        jArr[11] = jM2135m + j2;
        int i = iArr[0] + iArr[5];
        int i2 = iArr[1] + iArr[6];
        int i3 = iArr[2] + iArr[7];
        int i4 = iArr[3] + iArr[8];
        int i5 = iArr2[0] + iArr2[5];
        int i6 = iArr2[1] + iArr2[6];
        int i7 = iArr2[2] + iArr2[7];
        int i8 = iArr2[3] + iArr2[8];
        jArr[5] = m2135m(i, i5) + jArr[5];
        jArr[6] = m2135m(i, i6) + m2135m(i2, i5) + jArr[6];
        jArr[7] = m2135m(i, i7) + m2135m(i2, i6) + m2135m(i3, i5) + jArr[7];
        jArr[8] = m2135m(i, i8) + m2135m(i2, i7) + m2135m(i3, i6) + m2135m(i4, i5) + jArr[8];
        jArr[9] = ((((m2135m(i, iArr2[4]) + m2135m(i2, i8)) + m2135m(i3, i7)) + m2135m(i4, i6)) + m2135m(iArr[4], i5)) - jArr[9];
        jArr[10] = (((m2135m(i2, iArr2[4]) + m2135m(i3, i8)) + m2135m(i4, i7)) + m2135m(iArr[4], i6)) - jArr[10];
        jArr[11] = ((m2135m(i3, iArr2[4]) + m2135m(i4, i8)) + m2135m(iArr[4], i7)) - jArr[11];
        jArr[12] = (m2135m(i4, iArr2[4]) + m2135m(iArr[4], i8)) - jArr[12];
        return jArr;
    }

    public UnpackedScalar multiply(UnpackedScalar unpackedScalar) {
        return montgomeryReduce(montgomeryReduce(mulInternal(unpackedScalar)).mulInternal(Constants.f1969RR));
    }

    public UnpackedScalar subtract(UnpackedScalar unpackedScalar) {
        int[] iArr = new int[9];
        int i = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            i = this.f1995s[i2] - (unpackedScalar.f1995s[i2] + (i >>> 31));
            iArr[i2] = MASK_29_BITS & i;
        }
        int i3 = ((i >>> 31) ^ 1) - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < 9; i5++) {
            i4 = (i4 >>> 29) + iArr[i5] + (Constants.f1966L.f1995s[i5] & i3);
            iArr[i5] = i4 & MASK_29_BITS;
        }
        return new UnpackedScalar(iArr);
    }

    public byte[] toByteArray() {
        int[] iArr = this.f1995s;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        return new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) ((i >>> 24) | (i2 << 5)), (byte) (i2 >>> 3), (byte) (i2 >>> 11), (byte) (i2 >>> 19), (byte) ((i2 >>> 27) | (i3 << 2)), (byte) (i3 >>> 6), (byte) (i3 >>> 14), (byte) ((i3 >>> 22) | (i4 << 7)), (byte) (i4 >>> 1), (byte) (i4 >>> 9), (byte) (i4 >>> 17), (byte) ((i4 >>> 25) | (i5 << 4)), (byte) (i5 >>> 4), (byte) (i5 >>> 12), (byte) (i5 >>> 20), (byte) ((i5 >>> 28) | (i6 << 1)), (byte) (i6 >>> 7), (byte) (i6 >>> 15), (byte) ((i6 >>> 23) | (i7 << 6)), (byte) (i7 >>> 2), (byte) (i7 >>> 10), (byte) (i7 >>> 18), (byte) ((i7 >>> 26) | (i8 << 3)), (byte) (i8 >>> 5), (byte) (i8 >>> 13), (byte) (i8 >>> 21), (byte) i9, (byte) (i9 >>> 8), (byte) (i9 >>> 16)};
    }
}
