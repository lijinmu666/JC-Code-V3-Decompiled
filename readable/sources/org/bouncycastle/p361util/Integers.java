package org.bouncycastle.p361util;

/* loaded from: classes2.dex */
public class Integers {

    /* renamed from: BYTES */
    public static final int f24200BYTES = 4;

    /* renamed from: SIZE */
    public static final int f24201SIZE = 32;

    public static int bitCount(int i) {
        return Integer.bitCount(i);
    }

    public static int bitLength(int i) {
        return 32 - numberOfLeadingZeros(i);
    }

    /* renamed from: compare */
    public static int m18294compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compareUnsigned(int i, int i2) {
        return m18294compare(i - Integer.MIN_VALUE, i2 - Integer.MIN_VALUE);
    }

    public static int highestOneBit(int i) {
        return Integer.highestOneBit(i);
    }

    public static int lowestOneBit(int i) {
        return Integer.lowestOneBit(i);
    }

    public static int numberOfLeadingZeros(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    public static int numberOfTrailingZeros(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* renamed from: reverse */
    public static int m18295reverse(int i) {
        return Integer.reverse(i);
    }

    public static int reverseBytes(int i) {
        return Integer.reverseBytes(i);
    }

    public static int rotateLeft(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    public static int rotateRight(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    /* renamed from: valueOf */
    public static Integer m18296valueOf(int i) {
        return Integer.valueOf(i);
    }
}
