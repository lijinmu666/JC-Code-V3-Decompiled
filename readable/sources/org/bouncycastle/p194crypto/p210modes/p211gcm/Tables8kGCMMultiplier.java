package org.bouncycastle.p194crypto.p210modes.p211gcm;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class Tables8kGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f20648H;

    /* renamed from: T */
    private long[][][] f20649T;

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    /* renamed from: init */
    public void mo15617init(byte[] bArr) {
        if (this.f20649T == null) {
            this.f20649T = (long[][][]) Array.newInstance((Class<?>) Long.TYPE, 2, 256, 2);
        } else if (AbstractC5369GCMUtil.areEqual(this.f20648H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f20648H = bArr2;
        AbstractC5369GCMUtil.m15626copy(bArr, bArr2);
        for (int i = 0; i < 2; i++) {
            long[][][] jArr = this.f20649T;
            long[][] jArr2 = jArr[i];
            if (i == 0) {
                AbstractC5369GCMUtil.m15624asLongs(this.f20648H, jArr2[1]);
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
        long[][][] jArr = this.f20649T;
        long[][] jArr2 = jArr[0];
        long[][] jArr3 = jArr[1];
        long[] jArr4 = jArr2[bArr[14] & C1126UByte.MAX_VALUE];
        long[] jArr5 = jArr3[bArr[15] & C1126UByte.MAX_VALUE];
        long j = jArr4[0] ^ jArr5[0];
        long j2 = jArr5[1] ^ jArr4[1];
        for (int i = 12; i >= 0; i -= 2) {
            long[] jArr6 = jArr2[bArr[i] & C1126UByte.MAX_VALUE];
            long[] jArr7 = jArr3[bArr[i + 1] & C1126UByte.MAX_VALUE];
            long j3 = j2 << 48;
            j2 = ((j2 >>> 16) | (j << 48)) ^ (jArr6[1] ^ jArr7[1]);
            j = (((((j >>> 16) ^ (jArr7[0] ^ jArr6[0])) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
        }
        AbstractC6245Pack.longToBigEndian(j, bArr, 0);
        AbstractC6245Pack.longToBigEndian(j2, bArr, 8);
    }
}
