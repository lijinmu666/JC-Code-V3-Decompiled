package org.bouncycastle.p194crypto.p210modes.p211gcm;

/* loaded from: classes2.dex */
public class BasicGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private long[] f20641H;

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    /* renamed from: init */
    public void mo15617init(byte[] bArr) {
        this.f20641H = AbstractC5369GCMUtil.m15625asLongs(bArr);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        AbstractC5369GCMUtil.multiply(bArr, this.f20641H);
    }
}
