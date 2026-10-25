package org.bouncycastle.p194crypto.p210modes.p211gcm;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class Tables64kGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f20646H;

    /* renamed from: T */
    private long[][][] f20647T;

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    /* renamed from: init */
    public void mo15617init(byte[] bArr) {
        if (this.f20647T == null) {
            this.f20647T = (long[][][]) Array.newInstance((Class<?>) Long.TYPE, 16, 256, 2);
        } else if (AbstractC5369GCMUtil.areEqual(this.f20646H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f20646H = bArr2;
        AbstractC5369GCMUtil.m15626copy(bArr, bArr2);
        for (int i = 0; i < 16; i++) {
            long[][][] jArr = this.f20647T;
            long[][] jArr2 = jArr[i];
            if (i == 0) {
                AbstractC5369GCMUtil.m15624asLongs(this.f20646H, jArr2[1]);
                long[] jArr3 = jArr2[1];
                AbstractC5369GCMUtil.multiplyP7(jArr3, jArr3);
            } else {
                AbstractC5369GCMUtil.multiplyP8(jArr[i - 1][1], jArr2[1]);
            }
            for (int i2 = 2; i2 < 256; i2 += 2) {
                AbstractC5369GCMUtil.m15629divideP(jArr2[i2 >> 1], jArr2[i2]);
                AbstractC5369GCMUtil.m15640xor(jArr2[i2], jArr2[1], jArr2[i2 + 1]);
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long[][][] jArr = this.f20647T;
        long[] jArr2 = jArr[0][bArr[0] & C1126UByte.MAX_VALUE];
        long[] jArr3 = jArr[1][bArr[1] & C1126UByte.MAX_VALUE];
        long[] jArr4 = jArr[2][bArr[2] & C1126UByte.MAX_VALUE];
        long[] jArr5 = jArr[3][bArr[3] & C1126UByte.MAX_VALUE];
        long[] jArr6 = jArr[4][bArr[4] & C1126UByte.MAX_VALUE];
        long[] jArr7 = jArr[5][bArr[5] & C1126UByte.MAX_VALUE];
        long[] jArr8 = jArr[6][bArr[6] & C1126UByte.MAX_VALUE];
        long[] jArr9 = jArr[7][bArr[7] & C1126UByte.MAX_VALUE];
        long[] jArr10 = jArr[8][bArr[8] & C1126UByte.MAX_VALUE];
        long[] jArr11 = jArr[9][bArr[9] & C1126UByte.MAX_VALUE];
        long[] jArr12 = jArr[10][bArr[10] & C1126UByte.MAX_VALUE];
        long[] jArr13 = jArr[11][bArr[11] & C1126UByte.MAX_VALUE];
        long[] jArr14 = jArr[12][bArr[12] & C1126UByte.MAX_VALUE];
        long[] jArr15 = jArr[13][bArr[13] & C1126UByte.MAX_VALUE];
        long[] jArr16 = jArr[14][bArr[14] & C1126UByte.MAX_VALUE];
        long[] jArr17 = jArr[15][bArr[15] & C1126UByte.MAX_VALUE];
        long j = ((((((((((((((jArr2[0] ^ jArr3[0]) ^ jArr4[0]) ^ jArr5[0]) ^ jArr6[0]) ^ jArr7[0]) ^ jArr8[0]) ^ jArr9[0]) ^ jArr10[0]) ^ jArr11[0]) ^ jArr12[0]) ^ jArr13[0]) ^ jArr14[0]) ^ jArr15[0]) ^ jArr16[0]) ^ jArr17[0];
        long j2 = (((jArr14[1] ^ (((((((((((jArr2[1] ^ jArr3[1]) ^ jArr4[1]) ^ jArr5[1]) ^ jArr6[1]) ^ jArr7[1]) ^ jArr8[1]) ^ jArr9[1]) ^ jArr10[1]) ^ jArr11[1]) ^ jArr12[1]) ^ jArr13[1])) ^ jArr15[1]) ^ jArr16[1]) ^ jArr17[1];
        AbstractC6245Pack.longToBigEndian(j, bArr, 0);
        AbstractC6245Pack.longToBigEndian(j2, bArr, 8);
    }
}
