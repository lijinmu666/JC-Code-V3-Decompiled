package org.bouncycastle.p361util;

/* renamed from: org.bouncycastle.util.GF16 */
/* loaded from: classes2.dex */
public class C6242GF16 {

    /* renamed from: F_STAR */
    private static final byte[] f24197F_STAR = {1, 2, 4, 8, 3, 6, 12, 11, 5, 10, 7, 14, 15, 13, 9};

    /* renamed from: MT4B */
    private static final byte[] f24199MT4B = new byte[256];

    /* renamed from: INV4B */
    private static final byte[] f24198INV4B = new byte[16];

    static {
        for (int i = 0; i < 15; i++) {
            for (int i2 = 0; i2 < 15; i2++) {
                byte[] bArr = f24199MT4B;
                byte[] bArr2 = f24197F_STAR;
                bArr[(bArr2[i] << 4) ^ bArr2[i2]] = bArr2[(i + i2) % 15];
            }
        }
        byte[] bArr3 = f24197F_STAR;
        byte b = bArr3[1];
        byte b2 = bArr3[14];
        f24198INV4B[1] = 1;
        byte bM18290mt = 1;
        byte bM18290mt2 = 1;
        for (int i3 = 0; i3 < 14; i3++) {
            bM18290mt = m18290mt(bM18290mt, b);
            bM18290mt2 = m18290mt(bM18290mt2, b2);
            f24198INV4B[bM18290mt] = bM18290mt2;
        }
    }

    /* renamed from: decode */
    public static void m18285decode(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 >> 1;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = i2 + 1;
            bArr2[i2] = (byte) (bArr[i] & 15);
            i2 += 2;
            bArr2[i6] = (byte) ((bArr[i] >>> 4) & 15);
            i5++;
            i++;
        }
        if ((i3 & 1) == 1) {
            bArr2[i2] = (byte) (bArr[i] & 15);
        }
    }

    /* renamed from: encode */
    public static void m18287encode(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i >> 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i4 + 1;
            int i6 = bArr[i4] & 15;
            i4 += 2;
            bArr2[i3] = (byte) (((bArr[i5] & 15) << 4) | i6);
            i3++;
        }
        if ((i & 1) == 1) {
            bArr2[i3] = (byte) (bArr[i4] & 15);
        }
    }

    public static byte innerProduct(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        byte bM18291mul = 0;
        while (i4 < i3) {
            bM18291mul = (byte) (m18291mul(bArr[i], bArr2[i2]) ^ bM18291mul);
            i4++;
            i2 += i3;
            i++;
        }
        return bM18291mul;
    }

    /* renamed from: inv */
    public static byte m18289inv(byte b) {
        return f24198INV4B[b & 15];
    }

    /* renamed from: mt */
    public static byte m18290mt(int i, int i2) {
        return f24199MT4B[(i << 4) ^ i2];
    }

    /* renamed from: mul */
    public static byte m18291mul(byte b, byte b2) {
        return f24199MT4B[(b << 4) | b2];
    }

    /* renamed from: decode */
    public static void m18286decode(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i >> 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i4 + 1;
            bArr2[i4] = (byte) (bArr[i3] & 15);
            i4 += 2;
            bArr2[i5] = (byte) ((bArr[i3] >>> 4) & 15);
            i3++;
        }
        if ((i & 1) == 1) {
            bArr2[i4] = (byte) (bArr[i3] & 15);
        }
    }

    /* renamed from: encode */
    public static void m18288encode(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i2 >> 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1;
            int i7 = bArr[i5] & 15;
            i5 += 2;
            bArr2[i] = (byte) (((bArr[i6] & 15) << 4) | i7);
            i4++;
            i++;
        }
        if ((i2 & 1) == 1) {
            bArr2[i] = (byte) (bArr[i5] & 15);
        }
    }

    /* renamed from: mul */
    public static int m18292mul(int i, int i2) {
        return f24199MT4B[(i << 4) | i2];
    }
}
