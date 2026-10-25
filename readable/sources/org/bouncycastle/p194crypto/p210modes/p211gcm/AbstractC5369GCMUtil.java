package org.bouncycastle.p194crypto.p210modes.p211gcm;

import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.Interleave;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6243Longs;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: org.bouncycastle.crypto.modes.gcm.GCMUtil */
/* loaded from: classes2.dex */
public abstract class AbstractC5369GCMUtil {

    /* renamed from: E1 */
    private static final int f20642E1 = -520093696;

    /* renamed from: E1L */
    private static final long f20643E1L = -2233785415175766016L;
    public static final int SIZE_BYTES = 16;
    public static final int SIZE_INTS = 4;
    public static final int SIZE_LONGS = 2;

    public static byte areEqual(byte[] bArr, byte[] bArr2) {
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return (byte) AbstractC5869Nat.m16907czero(i);
    }

    /* renamed from: asBytes */
    public static void m15618asBytes(int[] iArr, byte[] bArr) {
        AbstractC6245Pack.intToBigEndian(iArr, 0, 4, bArr, 0);
    }

    /* renamed from: asInts */
    public static void m15622asInts(byte[] bArr, int[] iArr) {
        AbstractC6245Pack.bigEndianToInt(bArr, 0, iArr, 0, 4);
    }

    /* renamed from: asLongs */
    public static void m15624asLongs(byte[] bArr, long[] jArr) {
        AbstractC6245Pack.bigEndianToLong(bArr, 0, jArr, 0, 2);
    }

    /* renamed from: copy */
    public static void m15626copy(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 16; i++) {
            bArr2[i] = bArr[i];
        }
    }

    /* renamed from: divideP */
    public static void m15629divideP(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j >> 63;
        jArr2[0] = ((j ^ (f20643E1L & j3)) << 1) | (j2 >>> 63);
        jArr2[1] = (j2 << 1) | (-j3);
    }

    private static long implMul64(long j, long j2) {
        long j3 = j & 1229782938247303441L;
        long j4 = j & 2459565876494606882L;
        long j5 = j & 4919131752989213764L;
        long j6 = j & (-8608480567731124088L);
        long j7 = j2 & 1229782938247303441L;
        long j8 = j2 & 2459565876494606882L;
        long j9 = j2 & 4919131752989213764L;
        long j10 = j2 & (-8608480567731124088L);
        long j11 = (((j3 * j7) ^ (j4 * j10)) ^ (j5 * j9)) ^ (j6 * j8);
        long j12 = (((j3 * j8) ^ (j4 * j7)) ^ (j5 * j10)) ^ (j6 * j9);
        long j13 = (((j3 * j9) ^ (j4 * j8)) ^ (j5 * j7)) ^ (j6 * j10);
        return (j11 & 1229782938247303441L) | (j12 & 2459565876494606882L) | (j13 & 4919131752989213764L) | (((((j3 * j10) ^ (j4 * j9)) ^ (j5 * j8)) ^ (j6 * j7)) & (-8608480567731124088L));
    }

    public static void multiply(byte[] bArr, byte[] bArr2) {
        long[] jArrM15625asLongs = m15625asLongs(bArr);
        multiply(jArrM15625asLongs, m15625asLongs(bArr2));
        m15619asBytes(jArrM15625asLongs, bArr);
    }

    public static void multiplyP(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        iArr[0] = (((i4 << 31) >> 31) & f20642E1) ^ (i >>> 1);
        iArr[1] = (i2 >>> 1) | (i << 31);
        iArr[2] = (i3 >>> 1) | (i2 << 31);
        iArr[3] = (i4 >>> 1) | (i3 << 31);
    }

    public static void multiplyP16(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j2 << 48;
        jArr[0] = (j3 >>> 7) ^ ((((j >>> 16) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
        jArr[1] = (j << 48) | (j2 >>> 16);
    }

    public static void multiplyP3(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j2 << 61;
        jArr2[0] = (j3 >>> 7) ^ ((((j >>> 3) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
        jArr2[1] = (j << 61) | (j2 >>> 3);
    }

    public static void multiplyP4(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j2 << 60;
        jArr2[0] = (j3 >>> 7) ^ ((((j >>> 4) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
        jArr2[1] = (j << 60) | (j2 >>> 4);
    }

    public static void multiplyP7(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j2 << 57;
        jArr2[0] = (j3 >>> 7) ^ ((((j >>> 7) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
        jArr2[1] = (j << 57) | (j2 >>> 7);
    }

    public static void multiplyP8(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i4 << 24;
        iArr[0] = (i5 >>> 7) ^ ((((i >>> 8) ^ i5) ^ (i5 >>> 1)) ^ (i5 >>> 2));
        iArr[1] = (i2 >>> 8) | (i << 24);
        iArr[2] = (i3 >>> 8) | (i2 << 24);
        iArr[3] = (i4 >>> 8) | (i3 << 24);
    }

    public static byte[] oneAsBytes() {
        byte[] bArr = new byte[16];
        bArr[0] = ByteCompanionObject.MIN_VALUE;
        return bArr;
    }

    public static int[] oneAsInts() {
        int[] iArr = new int[4];
        iArr[0] = Integer.MIN_VALUE;
        return iArr;
    }

    public static long[] oneAsLongs() {
        return new long[]{Long.MIN_VALUE, 0};
    }

    public static long[] pAsLongs() {
        return new long[]{4611686018427387904L, 0};
    }

    /* renamed from: square */
    public static void m15630square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        Interleave.expand64To128Rev(jArr[0], jArr3, 0);
        Interleave.expand64To128Rev(jArr[1], jArr3, 2);
        long j = jArr3[0];
        long j2 = jArr3[1];
        long j3 = jArr3[2];
        long j4 = jArr3[3];
        long j5 = j3 ^ ((j4 << 57) ^ ((j4 << 63) ^ (j4 << 62)));
        jArr2[0] = j ^ ((((j5 >>> 1) ^ j5) ^ (j5 >>> 2)) ^ (j5 >>> 7));
        jArr2[1] = (j2 ^ ((((j4 >>> 1) ^ j4) ^ (j4 >>> 2)) ^ (j4 >>> 7))) ^ ((j5 << 57) ^ ((j5 << 63) ^ (j5 << 62)));
    }

    /* renamed from: xor */
    public static void m15631xor(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            int i4 = i + i3;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i2 + i3]);
        }
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        return AbstractC5869Nat.m16907czero((iArr[3] ^ iArr2[3]) | (iArr2[0] ^ iArr[0]) | (iArr2[1] ^ iArr[1]) | (iArr2[2] ^ iArr[2]));
    }

    /* renamed from: asBytes */
    public static void m15619asBytes(long[] jArr, byte[] bArr) {
        AbstractC6245Pack.longToBigEndian(jArr, 0, 2, bArr, 0);
    }

    /* renamed from: asInts */
    public static int[] m15623asInts(byte[] bArr) {
        int[] iArr = new int[4];
        AbstractC6245Pack.bigEndianToInt(bArr, 0, iArr, 0, 4);
        return iArr;
    }

    /* renamed from: asLongs */
    public static long[] m15625asLongs(byte[] bArr) {
        long[] jArr = new long[2];
        AbstractC6245Pack.bigEndianToLong(bArr, 0, jArr, 0, 2);
        return jArr;
    }

    /* renamed from: copy */
    public static void m15627copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void multiply(byte[] bArr, long[] jArr) {
        long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr, 0);
        long jBigEndianToLong2 = AbstractC6245Pack.bigEndianToLong(bArr, 8);
        long j = jArr[0];
        long j2 = jArr[1];
        long jM18298reverse = C6243Longs.m18298reverse(jBigEndianToLong);
        long jM18298reverse2 = C6243Longs.m18298reverse(jBigEndianToLong2);
        long jM18298reverse3 = C6243Longs.m18298reverse(j);
        long jM18298reverse4 = C6243Longs.m18298reverse(j2);
        long jM18298reverse5 = C6243Longs.m18298reverse(implMul64(jM18298reverse, jM18298reverse3));
        long jImplMul64 = implMul64(jBigEndianToLong, j) << 1;
        long jM18298reverse6 = C6243Longs.m18298reverse(implMul64(jM18298reverse2, jM18298reverse4));
        long jImplMul642 = implMul64(jBigEndianToLong2, j2);
        long j3 = jImplMul642 << 1;
        long jM18298reverse7 = C6243Longs.m18298reverse(implMul64(jM18298reverse ^ jM18298reverse2, jM18298reverse3 ^ jM18298reverse4));
        long jImplMul643 = ((implMul64(jBigEndianToLong ^ jBigEndianToLong2, j ^ j2) << 1) ^ ((jM18298reverse6 ^ jImplMul64) ^ j3)) ^ ((jImplMul642 << 63) ^ (jImplMul642 << 58));
        AbstractC6245Pack.longToBigEndian(jM18298reverse5 ^ (((jImplMul643 >>> 2) ^ ((jImplMul643 >>> 1) ^ jImplMul643)) ^ (jImplMul643 >>> 7)), bArr, 0);
        AbstractC6245Pack.longToBigEndian(((jM18298reverse7 ^ ((jImplMul64 ^ jM18298reverse5) ^ jM18298reverse6)) ^ (((j3 ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7))) ^ ((jImplMul643 << 57) ^ ((jImplMul643 << 63) ^ (jImplMul643 << 62))), bArr, 8);
    }

    public static void multiplyP(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        iArr2[0] = (((i4 << 31) >> 31) & f20642E1) ^ (i >>> 1);
        iArr2[1] = (i2 >>> 1) | (i << 31);
        iArr2[2] = (i3 >>> 1) | (i2 << 31);
        iArr2[3] = (i4 >>> 1) | (i3 << 31);
    }

    public static void multiplyP8(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i4 << 24;
        iArr2[0] = (i5 >>> 7) ^ ((((i >>> 8) ^ i5) ^ (i5 >>> 1)) ^ (i5 >>> 2));
        iArr2[1] = (i2 >>> 8) | (i << 24);
        iArr2[2] = (i3 >>> 8) | (i2 << 24);
        iArr2[3] = (i4 >>> 8) | (i3 << 24);
    }

    /* renamed from: xor */
    public static void m15632xor(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4 = 0;
        do {
            bArr3[i3 + i4] = (byte) (bArr[i + i4] ^ bArr2[i2 + i4]);
            int i5 = i4 + 1;
            bArr3[i3 + i5] = (byte) (bArr2[i5 + i2] ^ bArr[i + i5]);
            int i6 = i4 + 2;
            bArr3[i3 + i6] = (byte) (bArr2[i6 + i2] ^ bArr[i + i6]);
            int i7 = i4 + 3;
            bArr3[i3 + i7] = (byte) (bArr2[i7 + i2] ^ bArr[i + i7]);
            i4 += 4;
        } while (i4 < 16);
    }

    public static long areEqual(long[] jArr, long[] jArr2) {
        return AbstractC5869Nat.m16908czero64((jArr2[1] ^ jArr[1]) | (jArr[0] ^ jArr2[0]));
    }

    /* renamed from: asBytes */
    public static byte[] m15620asBytes(int[] iArr) {
        byte[] bArr = new byte[16];
        AbstractC6245Pack.intToBigEndian(iArr, 0, 4, bArr, 0);
        return bArr;
    }

    /* renamed from: copy */
    public static void m15628copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static void multiply(int[] iArr, int[] iArr2) {
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i3 = iArr2[2];
        int i4 = iArr2[3];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = iArr[i9];
            for (int i11 = 0; i11 < 32; i11++) {
                int i12 = i10 >> 31;
                i10 <<= 1;
                i5 ^= i & i12;
                i6 ^= i2 & i12;
                i7 ^= i3 & i12;
                i8 ^= i12 & i4;
                int i13 = (i4 << 31) >> 8;
                i4 = (i4 >>> 1) | (i3 << 31);
                i3 = (i3 >>> 1) | (i2 << 31);
                i2 = (i2 >>> 1) | (i << 31);
                i = (i >>> 1) ^ (i13 & f20642E1);
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i8;
    }

    public static void multiplyP(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        jArr[0] = (((j2 << 63) >> 63) & f20643E1L) ^ (j >>> 1);
        jArr[1] = (j << 63) | (j2 >>> 1);
    }

    public static void multiplyP8(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j2 << 56;
        jArr[0] = (j3 >>> 7) ^ ((((j >>> 8) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
        jArr[1] = (j << 56) | (j2 >>> 8);
    }

    /* renamed from: xor */
    public static void m15633xor(byte[] bArr, byte[] bArr2) {
        int i = 0;
        do {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            int i2 = i + 1;
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            int i3 = i + 2;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            int i4 = i + 3;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
            i += 4;
        } while (i < 16);
    }

    /* renamed from: asBytes */
    public static byte[] m15621asBytes(long[] jArr) {
        byte[] bArr = new byte[16];
        AbstractC6245Pack.longToBigEndian(jArr, 0, 2, bArr, 0);
        return bArr;
    }

    public static void multiply(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr2[0];
        long j4 = jArr2[1];
        long jM18298reverse = C6243Longs.m18298reverse(j);
        long jM18298reverse2 = C6243Longs.m18298reverse(j2);
        long jM18298reverse3 = C6243Longs.m18298reverse(j3);
        long jM18298reverse4 = C6243Longs.m18298reverse(j4);
        long jM18298reverse5 = C6243Longs.m18298reverse(implMul64(jM18298reverse, jM18298reverse3));
        long jImplMul64 = implMul64(j, j3) << 1;
        long jM18298reverse6 = C6243Longs.m18298reverse(implMul64(jM18298reverse2, jM18298reverse4));
        long jImplMul642 = implMul64(j2, j4);
        long j5 = jImplMul642 << 1;
        long jM18298reverse7 = C6243Longs.m18298reverse(implMul64(jM18298reverse ^ jM18298reverse2, jM18298reverse3 ^ jM18298reverse4));
        long jImplMul643 = ((implMul64(j ^ j2, j3 ^ j4) << 1) ^ ((jM18298reverse6 ^ jImplMul64) ^ j5)) ^ ((jImplMul642 << 63) ^ (jImplMul642 << 58));
        jArr[0] = jM18298reverse5 ^ (((jImplMul643 >>> 2) ^ ((jImplMul643 >>> 1) ^ jImplMul643)) ^ (jImplMul643 >>> 7));
        jArr[1] = ((jImplMul643 << 57) ^ ((jImplMul643 << 63) ^ (jImplMul643 << 62))) ^ ((jM18298reverse7 ^ ((jImplMul64 ^ jM18298reverse5) ^ jM18298reverse6)) ^ (((j5 ^ (j5 >>> 1)) ^ (j5 >>> 2)) ^ (j5 >>> 7)));
    }

    public static void multiplyP(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        jArr2[0] = (((j2 << 63) >> 63) & f20643E1L) ^ (j >>> 1);
        jArr2[1] = (j << 63) | (j2 >>> 1);
    }

    public static void multiplyP8(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = j2 << 56;
        jArr2[0] = (j3 >>> 7) ^ ((((j >>> 8) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2));
        jArr2[1] = (j << 56) | (j2 >>> 8);
    }

    /* renamed from: xor */
    public static void m15634xor(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        do {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
            int i3 = i2 + 1;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i + i3]);
            int i4 = i2 + 2;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i + i4]);
            int i5 = i2 + 3;
            bArr[i5] = (byte) (bArr[i5] ^ bArr2[i + i5]);
            i2 += 4;
        } while (i2 < 16);
    }

    /* renamed from: xor */
    public static void m15635xor(byte[] bArr, byte[] bArr2, int i, int i2) {
        while (true) {
            i2--;
            if (i2 < 0) {
                return;
            } else {
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
            }
        }
    }

    /* renamed from: xor */
    public static void m15636xor(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = 0;
        do {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            int i2 = i + 1;
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            int i3 = i + 2;
            bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            int i4 = i + 3;
            bArr3[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
            i += 4;
        } while (i < 16);
    }

    /* renamed from: xor */
    public static void m15637xor(int[] iArr, int[] iArr2) {
        iArr[0] = iArr[0] ^ iArr2[0];
        iArr[1] = iArr[1] ^ iArr2[1];
        iArr[2] = iArr[2] ^ iArr2[2];
        iArr[3] = iArr2[3] ^ iArr[3];
    }

    /* renamed from: xor */
    public static void m15638xor(int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[0] = iArr[0] ^ iArr2[0];
        iArr3[1] = iArr[1] ^ iArr2[1];
        iArr3[2] = iArr[2] ^ iArr2[2];
        iArr3[3] = iArr[3] ^ iArr2[3];
    }

    /* renamed from: xor */
    public static void m15639xor(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] ^ jArr2[0];
        jArr[1] = jArr[1] ^ jArr2[1];
    }

    /* renamed from: xor */
    public static void m15640xor(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }
}
