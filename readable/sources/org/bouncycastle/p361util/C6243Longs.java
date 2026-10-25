package org.bouncycastle.p361util;

import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;

/* renamed from: org.bouncycastle.util.Longs */
/* loaded from: classes2.dex */
public class C6243Longs {

    /* renamed from: BYTES */
    public static final int f24202BYTES = 8;

    /* renamed from: SIZE */
    public static final int f24203SIZE = 64;

    public static int bitCount(long j) {
        return Long.bitCount(j);
    }

    public static int bitLength(long j) {
        return 64 - numberOfLeadingZeros(j);
    }

    /* renamed from: compare */
    public static int m18297compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static int compareUnsigned(long j, long j2) {
        return m18297compare(j - Long.MIN_VALUE, j2 - Long.MIN_VALUE);
    }

    public static long highestOneBit(long j) {
        return Long.highestOneBit(j);
    }

    public static long lowestOneBit(long j) {
        return Long.lowestOneBit(j);
    }

    public static int numberOfLeadingZeros(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    public static int numberOfTrailingZeros(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* renamed from: reverse */
    public static long m18298reverse(long j) {
        return Long.reverse(j);
    }

    public static long reverseBytes(long j) {
        return Long.reverseBytes(j);
    }

    public static long rotateLeft(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    public static long rotateRight(long j, int i) {
        return Long.rotateRight(j, i);
    }

    /* renamed from: valueOf */
    public static Long m18299valueOf(long j) {
        return Long.valueOf(j);
    }

    /* renamed from: xorTo */
    public static void m18300xorTo(int i, long[] jArr, int i2, long[] jArr2, int i3) {
        AbstractC5869Nat.m16951xorTo64(i, jArr, i2, jArr2, i3);
    }
}
