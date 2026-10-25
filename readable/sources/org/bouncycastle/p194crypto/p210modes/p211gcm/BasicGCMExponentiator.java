package org.bouncycastle.p194crypto.p210modes.p211gcm;

/* loaded from: classes2.dex */
public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x */
    private long[] f20640x;

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        long[] jArrOneAsLongs = AbstractC5369GCMUtil.oneAsLongs();
        if (j > 0) {
            long[] jArr = new long[2];
            AbstractC5369GCMUtil.m15628copy(this.f20640x, jArr);
            do {
                if ((1 & j) != 0) {
                    AbstractC5369GCMUtil.multiply(jArrOneAsLongs, jArr);
                }
                AbstractC5369GCMUtil.m15630square(jArr, jArr);
                j >>>= 1;
            } while (j > 0);
        }
        AbstractC5369GCMUtil.m15619asBytes(jArrOneAsLongs, bArr);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMExponentiator
    /* renamed from: init */
    public void mo15616init(byte[] bArr) {
        this.f20640x = AbstractC5369GCMUtil.m15625asLongs(bArr);
    }
}
