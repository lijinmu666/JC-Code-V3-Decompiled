package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class GOST3413CipherUtil {
    /* renamed from: LSB */
    public static byte[] m15606LSB(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, bArr.length - i, bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: MSB */
    public static byte[] m15607MSB(byte[] bArr, int i) {
        return C6238Arrays.m18242copyOf(bArr, i);
    }

    public static byte[] copyFromInput(byte[] bArr, int i, int i2) {
        if (bArr.length < i + i2) {
            i = bArr.length - i2;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, i2, bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: sum */
    public static byte[] m15608sum(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }
}
