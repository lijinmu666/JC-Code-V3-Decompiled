package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XofUtils {
    /* renamed from: encode */
    public static byte[] m15211encode(byte b) {
        return C6238Arrays.concatenate(leftEncode(8L), new byte[]{b});
    }

    public static byte[] leftEncode(long j) {
        long j2 = j;
        byte b = 1;
        while (true) {
            j2 >>= 8;
            if (j2 == 0) {
                break;
            }
            b = (byte) (b + 1);
        }
        byte[] bArr = new byte[b + 1];
        bArr[0] = b;
        for (int i = 1; i <= b; i++) {
            bArr[i] = (byte) (j >> ((b - i) * 8));
        }
        return bArr;
    }

    public static byte[] rightEncode(long j) {
        long j2 = j;
        byte b = 1;
        while (true) {
            j2 >>= 8;
            if (j2 == 0) {
                break;
            }
            b = (byte) (b + 1);
        }
        byte[] bArr = new byte[b + 1];
        bArr[b] = b;
        for (int i = 0; i < b; i++) {
            bArr[i] = (byte) (j >> (((b - i) - 1) * 8));
        }
        return bArr;
    }

    /* renamed from: encode */
    public static byte[] m15212encode(byte[] bArr, int i, int i2) {
        return bArr.length == i2 ? C6238Arrays.concatenate(leftEncode(i2 * 8), bArr) : C6238Arrays.concatenate(leftEncode(i2 * 8), C6238Arrays.copyOfRange(bArr, i, i2 + i));
    }
}
