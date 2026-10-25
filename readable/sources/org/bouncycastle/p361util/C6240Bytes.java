package org.bouncycastle.p361util;

import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;

/* renamed from: org.bouncycastle.util.Bytes */
/* loaded from: classes2.dex */
public class C6240Bytes {

    /* renamed from: BYTES */
    public static final int f24194BYTES = 1;

    /* renamed from: SIZE */
    public static final int f24195SIZE = 8;

    /* renamed from: cmov */
    public static void m18272cmov(int i, int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        int iM16907czero = AbstractC5869Nat.m16907czero(i2);
        int i5 = ~iM16907czero;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = i4 + i6;
            bArr2[i7] = (byte) ((bArr[i3 + i6] & i5) | (bArr2[i7] & iM16907czero));
        }
    }

    /* renamed from: xor */
    public static void m18274xor(int i, byte[] bArr, int i2, byte[] bArr2, int i3, byte[] bArr3, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            bArr3[i4 + i5] = (byte) (bArr[i2 + i5] ^ bArr2[i3 + i5]);
        }
    }

    /* renamed from: xorTo */
    public static void m18279xorTo(int i, byte[] bArr, int i2, byte[] bArr2) {
        int i3 = 0;
        while (i3 < i) {
            bArr2[i3] = (byte) (bArr[i2] ^ bArr2[i3]);
            i3++;
            i2++;
        }
    }

    /* renamed from: cmov */
    public static void m18273cmov(int i, int i2, byte[] bArr, byte[] bArr2) {
        int iM16907czero = AbstractC5869Nat.m16907czero(i2);
        int i3 = ~iM16907czero;
        for (int i4 = 0; i4 < i; i4++) {
            bArr2[i4] = (byte) ((bArr[i4] & i3) | (bArr2[i4] & iM16907czero));
        }
    }

    /* renamed from: xor */
    public static void m18275xor(int i, byte[] bArr, int i2, byte[] bArr2, byte[] bArr3, int i3) {
        int i4 = 0;
        while (i4 < i) {
            bArr3[i3] = (byte) (bArr[i2] ^ bArr2[i4]);
            i4++;
            i3++;
            i2++;
        }
    }

    /* renamed from: xorTo */
    public static void m18280xorTo(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            bArr2[i5] = (byte) (bArr2[i5] ^ bArr[i2 + i4]);
        }
    }

    /* renamed from: xor */
    public static void m18276xor(int i, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4 = 0;
        while (i4 < i) {
            bArr3[i3] = (byte) (bArr2[i2] ^ bArr[i4]);
            i4++;
            i3++;
            i2++;
        }
    }

    /* renamed from: xorTo */
    public static void m18281xorTo(int i, byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i2]);
        }
    }

    /* renamed from: xor */
    public static void m18277xor(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    /* renamed from: xor */
    public static void m18278xor(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        int i3 = 0;
        while (i3 < i) {
            bArr3[i2] = (byte) (bArr[i3] ^ bArr2[i3]);
            i3++;
            i2++;
        }
    }
}
