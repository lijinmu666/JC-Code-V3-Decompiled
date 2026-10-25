package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class ErrorCorrection {
    public static short LDDecode(int i, int i2, int i3, int i4) {
        return (short) (((((m17734g(i) + m17734g(i2)) + m17734g(i3)) + m17734g(i4)) - 98312) >>> 31);
    }

    /* renamed from: abs */
    public static int m17732abs(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    /* renamed from: f */
    public static int m17733f(int[] iArr, int i, int i2, int i3) {
        int i4 = (i3 * 2730) >> 25;
        int i5 = i4 - ((12288 - (i3 - (i4 * 12289))) >> 31);
        iArr[i] = (i5 >> 1) + (i5 & 1);
        int i6 = i5 - 1;
        iArr[i2] = (i6 >> 1) + (i6 & 1);
        return m17732abs(i3 - (iArr[i] * 24578));
    }

    /* renamed from: g */
    public static int m17734g(int i) {
        int i2 = (i * 2730) >> 27;
        int i3 = i2 - ((49155 - (i - (49156 * i2))) >> 31);
        return m17732abs((((i3 >> 1) + (i3 & 1)) * 98312) - i);
    }

    /* renamed from: helpRec */
    public static void m17735helpRec(short[] sArr, short[] sArr2, byte[] bArr, byte b) {
        short s = 8;
        byte[] bArr2 = new byte[8];
        bArr2[0] = b;
        byte[] bArr3 = new byte[32];
        ChaCha20.m17731process(bArr, bArr2, bArr3, 0, 32);
        int[] iArr = new int[8];
        int i = 0;
        while (i < 256) {
            int i2 = ((bArr3[i >>> 3] >>> (i & 7)) & 1) * 4;
            int i3 = i + 256;
            int i4 = i + 512;
            int i5 = i + 768;
            int iM17733f = (24577 - (((m17733f(iArr, 0, 4, (sArr2[i] * s) + i2) + m17733f(iArr, 1, 5, (sArr2[i3] * s) + i2)) + m17733f(iArr, 2, 6, (sArr2[i4] * s) + i2)) + m17733f(iArr, 3, 7, (sArr2[i5] * s) + i2))) >> 31;
            int i6 = ~iM17733f;
            int[] iArr2 = {(i6 & iArr[0]) ^ (iArr[4] & iM17733f), (i6 & iArr[1]) ^ (iArr[5] & iM17733f), (i6 & iArr[2]) ^ (iArr[6] & iM17733f), (iArr[7] & iM17733f) ^ (i6 & iArr[3])};
            int i7 = iArr2[0];
            int i8 = iArr2[3];
            sArr[i] = (short) ((i7 - i8) & 3);
            sArr[i3] = (short) ((iArr2[1] - i8) & 3);
            sArr[i4] = (short) ((iArr2[2] - i8) & 3);
            sArr[i5] = (short) (((-iM17733f) + (i8 * 2)) & 3);
            i++;
            s = 8;
        }
    }

    /* renamed from: rec */
    public static void m17736rec(byte[] bArr, short[] sArr, short[] sArr2) {
        C6238Arrays.m18249fill(bArr, (byte) 0);
        for (int i = 0; i < 256; i++) {
            int i2 = (sArr[i] * 8) + 196624;
            int i3 = sArr2[i] * 2;
            int i4 = i + 768;
            short s = sArr2[i4];
            int i5 = i2 - ((i3 + s) * 12289);
            int i6 = i + 256;
            int i7 = ((sArr[i6] * 8) + 196624) - (((sArr2[i6] * 2) + s) * 12289);
            int i8 = i + 512;
            int[] iArr = {i5, i7, ((sArr[i8] * 8) + 196624) - (((sArr2[i8] * 2) + s) * 12289), ((sArr[i4] * 8) + 196624) - (s * 12289)};
            int i9 = i >>> 3;
            bArr[i9] = (byte) ((LDDecode(iArr[0], iArr[1], iArr[2], iArr[3]) << (i & 7)) | bArr[i9]);
        }
    }
}
