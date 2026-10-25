package org.bouncycastle.p194crypto.p210modes.p211gcm;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class Tables4kGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f20644H;

    /* renamed from: T */
    private long[][] f20645T;

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    /* renamed from: init */
    public void mo15617init(byte[] bArr) {
        if (this.f20645T == null) {
            this.f20645T = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 256, 2);
        } else if (AbstractC5369GCMUtil.areEqual(this.f20644H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f20644H = bArr2;
        AbstractC5369GCMUtil.m15626copy(bArr, bArr2);
        AbstractC5369GCMUtil.m15624asLongs(this.f20644H, this.f20645T[1]);
        long[] jArr = this.f20645T[1];
        AbstractC5369GCMUtil.multiplyP7(jArr, jArr);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr2 = this.f20645T;
            AbstractC5369GCMUtil.m15629divideP(jArr2[i >> 1], jArr2[i]);
            long[][] jArr3 = this.f20645T;
            AbstractC5369GCMUtil.m15640xor(jArr3[i], jArr3[1], jArr3[i + 1]);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long[] jArr = this.f20645T[bArr[15] & C1126UByte.MAX_VALUE];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = this.f20645T[bArr[i] & C1126UByte.MAX_VALUE];
            long j3 = j2 << 56;
            j2 = ((j2 >>> 8) | (j << 56)) ^ jArr2[1];
            j = (((((j >>> 8) ^ jArr2[0]) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
        }
        AbstractC6245Pack.longToBigEndian(j, bArr, 0);
        AbstractC6245Pack.longToBigEndian(j2, bArr, 8);
    }
}
