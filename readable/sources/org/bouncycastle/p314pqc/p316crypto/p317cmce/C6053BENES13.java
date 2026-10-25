package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import java.lang.reflect.Array;

/* renamed from: org.bouncycastle.pqc.crypto.cmce.BENES13 */
/* loaded from: classes2.dex */
class C6053BENES13 extends AbstractC6051BENES {
    public C6053BENES13(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public static void layer_ex(long[] jArr, long[] jArr2, int i) {
        int i2 = 1 << i;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4 += i2 * 2) {
            int i5 = i4;
            while (i5 < i4 + i2) {
                long j = jArr[i5];
                int i6 = i5 + i2;
                long j2 = (jArr[i6] ^ j) & jArr2[i3];
                jArr[i5] = j ^ j2;
                jArr[i6] = jArr[i6] ^ j2;
                i5++;
                i3++;
            }
        }
    }

    public static void layer_in(long[] jArr, long[] jArr2, int i) {
        int i2 = 1 << i;
        int i3 = 0;
        for (int i4 = 0; i4 < 64; i4 += i2 * 2) {
            for (int i5 = i4; i5 < i4 + i2; i5++) {
                long j = jArr[i5];
                int i6 = i5 + i2;
                int i7 = i3 + 1;
                long j2 = (jArr[i6] ^ j) & jArr2[i3];
                jArr[i5] = j ^ j2;
                jArr[i6] = jArr[i6] ^ j2;
                int i8 = i5 + 64;
                long j3 = jArr[i8];
                int i9 = i8 + i2;
                i3 += 2;
                long j4 = jArr2[i7] & (jArr[i9] ^ j3);
                jArr[i8] = j3 ^ j4;
                jArr[i9] = jArr[i9] ^ j4;
            }
        }
    }

    public void apply_benes(byte[] bArr, byte[] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        long[] jArr = new long[128];
        long[] jArr2 = new long[128];
        long[] jArr3 = new long[64];
        long[] jArr4 = new long[64];
        int i5 = this.f23060SYS_T * 2;
        if (i == 0) {
            i2 = i5 + 40;
            i3 = 0;
        } else {
            i2 = i5 + 12328;
            i3 = -1024;
        }
        for (int i6 = 0; i6 < 64; i6++) {
            int i7 = i6 * 16;
            jArr[i6] = C6057Utils.m17511load8(bArr, i7);
            jArr[i6 + 64] = C6057Utils.m17511load8(bArr, i7 + 8);
        }
        AbstractC6051BENES.transpose_64x64(jArr2, jArr, 0);
        AbstractC6051BENES.transpose_64x64(jArr2, jArr, 64);
        int i8 = 0;
        while (true) {
            if (i8 > 6) {
                break;
            }
            for (int i9 = 0; i9 < 64; i9++) {
                jArr3[i9] = C6057Utils.m17511load8(bArr2, i2);
                i2 += 8;
            }
            i2 += i3;
            AbstractC6051BENES.transpose_64x64(jArr4, jArr3);
            layer_ex(jArr2, jArr4, i8);
            i8++;
        }
        AbstractC6051BENES.transpose_64x64(jArr, jArr2, 0);
        AbstractC6051BENES.transpose_64x64(jArr, jArr2, 64);
        for (int i10 = 0; i10 <= 5; i10++) {
            for (int i11 = 0; i11 < 64; i11++) {
                jArr3[i11] = C6057Utils.m17511load8(bArr2, i2);
                i2 += 8;
            }
            i2 += i3;
            layer_in(jArr, jArr3, i10);
        }
        for (int i12 = 4; i12 >= 0; i12--) {
            for (int i13 = 0; i13 < 64; i13++) {
                jArr3[i13] = C6057Utils.m17511load8(bArr2, i2);
                i2 += 8;
            }
            i2 += i3;
            layer_in(jArr, jArr3, i12);
        }
        AbstractC6051BENES.transpose_64x64(jArr2, jArr, 0);
        AbstractC6051BENES.transpose_64x64(jArr2, jArr, 64);
        for (i4 = 6; i4 >= 0; i4--) {
            for (int i14 = 0; i14 < 64; i14++) {
                jArr3[i14] = C6057Utils.m17511load8(bArr2, i2);
                i2 += 8;
            }
            i2 += i3;
            AbstractC6051BENES.transpose_64x64(jArr4, jArr3);
            layer_ex(jArr2, jArr4, i4);
        }
        AbstractC6051BENES.transpose_64x64(jArr, jArr2, 0);
        AbstractC6051BENES.transpose_64x64(jArr, jArr2, 64);
        for (int i15 = 0; i15 < 64; i15++) {
            int i16 = i15 * 16;
            C6057Utils.m17513store8(bArr, i16, jArr[i15]);
            C6057Utils.m17513store8(bArr, i16 + 8, jArr[i15 + 64]);
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p317cmce.AbstractC6051BENES
    public void support_gen(short[] sArr, byte[] bArr) {
        int i = this.f23058GFBITS;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, (1 << i) / 8);
        for (int i2 = 0; i2 < this.f23058GFBITS; i2++) {
            for (int i3 = 0; i3 < (1 << this.f23058GFBITS) / 8; i3++) {
                bArr2[i2][i3] = 0;
            }
        }
        int i4 = 0;
        while (true) {
            int i5 = this.f23058GFBITS;
            if (i4 >= (1 << i5)) {
                break;
            }
            short sM17509bitrev = C6057Utils.m17509bitrev((short) i4, i5);
            for (int i6 = 0; i6 < this.f23058GFBITS; i6++) {
                byte[] bArr3 = bArr2[i6];
                int i7 = i4 / 8;
                bArr3[i7] = (byte) (bArr3[i7] | (((sM17509bitrev >> i6) & 1) << (i4 % 8)));
            }
            i4++;
        }
        for (int i8 = 0; i8 < this.f23058GFBITS; i8++) {
            apply_benes(bArr2[i8], bArr, 0);
        }
        for (int i9 = 0; i9 < this.f23059SYS_N; i9++) {
            sArr[i9] = 0;
            for (int i10 = this.f23058GFBITS - 1; i10 >= 0; i10--) {
                short s = (short) (sArr[i9] << 1);
                sArr[i9] = s;
                sArr[i9] = (short) (s | ((bArr2[i10][i9 / 8] >> (i9 % 8)) & 1));
            }
        }
    }
}
