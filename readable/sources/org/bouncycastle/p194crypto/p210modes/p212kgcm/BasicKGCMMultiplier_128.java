package org.bouncycastle.p194crypto.p210modes.p212kgcm;

/* loaded from: classes2.dex */
public class BasicKGCMMultiplier_128 implements KGCMMultiplier {

    /* renamed from: H */
    private final long[] f20650H = new long[2];

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    /* renamed from: init */
    public void mo15641init(long[] jArr) {
        KGCMUtil_128.m15643copy(jArr, this.f20650H);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        KGCMUtil_128.multiply(jArr, this.f20650H, jArr);
    }
}
