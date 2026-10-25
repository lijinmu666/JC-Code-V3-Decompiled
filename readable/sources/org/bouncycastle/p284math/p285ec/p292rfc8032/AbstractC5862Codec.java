package org.bouncycastle.p284math.p285ec.p292rfc8032;

import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.math.ec.rfc8032.Codec */
/* loaded from: classes2.dex */
abstract class AbstractC5862Codec {
    public static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | (bArr[i] & C1126UByte.MAX_VALUE);
    }

    public static int decode24(byte[] bArr, int i) {
        return ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16) | (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8);
    }

    public static int decode32(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16);
    }

    public static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
    }

    public static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    public static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    public static void encode32(int[] iArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            encode32(iArr[i + i4], bArr, (i4 * 4) + i3);
        }
    }
}
