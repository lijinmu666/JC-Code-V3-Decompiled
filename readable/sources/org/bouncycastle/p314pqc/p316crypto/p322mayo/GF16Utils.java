package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p361util.C6242GF16;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class GF16Utils {
    static final long MASK_LSB = 1229782938247303441L;
    static final long MASK_MSB = -8608480567731124088L;
    static final long NIBBLE_MASK_LSB = -1229782938247303442L;
    static final long NIBBLE_MASK_MSB = 8608480567731124087L;

    public static void mVecMulAdd(int i, long[] jArr, int i2, int i3, long[] jArr2, int i4) {
        long j = i3;
        long j2 = BodyPartID.bodyIdMax & j;
        long j3 = j & 1;
        long j4 = (j2 >>> 1) & 1;
        long j5 = (j2 >>> 2) & 1;
        char c = 3;
        long j6 = (j2 >>> 3) & 1;
        int i5 = i4;
        int i6 = 0;
        int i7 = i2;
        while (i6 < i) {
            long j7 = jArr[i7];
            long j8 = j4;
            long j9 = (-j3) & j7;
            long j10 = (j7 & MASK_MSB) >>> c;
            long j11 = ((j7 & NIBBLE_MASK_MSB) << 1) ^ (j10 + (j10 << 1));
            int i8 = i5;
            long j12 = j9 ^ ((-j8) & j11);
            long j13 = (j11 & MASK_MSB) >>> 3;
            long j14 = (j13 + (j13 << 1)) ^ ((j11 & NIBBLE_MASK_MSB) << 1);
            long j15 = j3;
            long j16 = ((-j5) & j14) ^ j12;
            long j17 = (j14 & MASK_MSB) >>> 3;
            jArr2[i8] = jArr2[i8] ^ (j16 ^ (((j17 + (j17 << 1)) ^ ((j14 & NIBBLE_MASK_MSB) << 1)) & (-j6)));
            i6++;
            j4 = j8;
            i5 = i8 + 1;
            i7++;
            j3 = j15;
            j5 = j5;
            c = 3;
        }
    }

    /* renamed from: matMul */
    public static void m17665matMul(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = 0;
            byte bM18291mul = 0;
            while (i7 < i2) {
                bM18291mul = (byte) (C6242GF16.m18291mul(bArr[i5], bArr2[i + i7]) ^ bM18291mul);
                i7++;
                i5++;
            }
            bArr3[i6] = bM18291mul;
            i4++;
            i6++;
        }
    }

    public static void mulAddMUpperTriangularMatXMat(int i, long[] jArr, byte[] bArr, long[] jArr2, int i2, int i3, int i4) {
        int i5 = i4 * i;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i3) {
            int i10 = i6;
            int i11 = i7;
            int i12 = i8;
            while (i11 < i3) {
                int i13 = 0;
                int i14 = 0;
                while (i13 < i4) {
                    mVecMulAdd(i, jArr, i10, bArr[i12 + i13], jArr2, i2 + i9 + i14);
                    i13++;
                    i14 += i;
                }
                i10 += i;
                i11++;
                i12 += i4;
            }
            i7++;
            i8 += i4;
            i9 += i5;
            i6 = i10;
        }
    }

    public static void mulAddMUpperTriangularMatXMatTrans(int i, long[] jArr, byte[] bArr, long[] jArr2, int i2, int i3) {
        int i4 = i * i3;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = i5;
            for (int i9 = i6; i9 < i2; i9++) {
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (i10 < i3) {
                    mVecMulAdd(i, jArr, i8, bArr[i11 + i9], jArr2, i7 + i12);
                    i10++;
                    i11 += i2;
                    i12 += i;
                }
                i8 += i;
            }
            i6++;
            i7 += i4;
            i5 = i8;
        }
    }

    public static void mulAddMatTransXMMat(int i, byte[] bArr, long[] jArr, int i2, long[] jArr2, int i3, int i4) {
        int i5 = i4 * i;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i3) {
                byte b = bArr[i9 + i6];
                int i11 = 0;
                int i12 = 0;
                while (i11 < i4) {
                    mVecMulAdd(i, jArr, i2 + i10 + i12, b, jArr2, i7 + i12);
                    i11++;
                    i12 += i;
                }
                i8++;
                i9 += i4;
                i10 += i5;
            }
            i6++;
            i7 += i5;
        }
    }

    public static void mulAddMatXMMat(int i, byte[] bArr, long[] jArr, int i2, long[] jArr2, int i3, int i4, int i5) {
        int i6 = i * i5;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i3) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < i4) {
                byte b = bArr[i9 + i10];
                int i12 = 0;
                int i13 = 0;
                while (i12 < i5) {
                    mVecMulAdd(i, jArr, i11 + i13 + i2, b, jArr2, i8 + i13);
                    i12++;
                    i13 += i;
                }
                i10++;
                i11 += i6;
            }
            i7++;
            i8 += i6;
            i9 += i4;
        }
    }

    /* renamed from: mulFx8 */
    public static long m17666mulFx8(byte b, long j) {
        int i = b & C1126UByte.MAX_VALUE;
        long j2 = ((j << 3) & (-((i >> 3) & 1))) ^ ((((-(b & 1)) & j) ^ ((-((i >> 1) & 1)) & (j << 1))) ^ ((-((i >> 2) & 1)) & (j << 2)));
        long j3 = (-1085102592571150096L) & j2;
        return ((j2 ^ (j3 >>> 4)) ^ (j3 >>> 3)) & 1085102592571150095L;
    }

    public static void mulAddMatXMMat(int i, byte[] bArr, long[] jArr, long[] jArr2, int i2, int i3) {
        int i4 = i * i2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i2) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < i3) {
                byte b = bArr[i6 + i8];
                int i10 = 0;
                int i11 = 0;
                while (i10 < i2) {
                    mVecMulAdd(i, jArr, i9 + i11, b, jArr2, i7 + i11);
                    i10++;
                    i11 += i;
                }
                i8++;
                i9 += i4;
            }
            i5++;
            i6 += i3;
            i7 += i4;
        }
    }
}
