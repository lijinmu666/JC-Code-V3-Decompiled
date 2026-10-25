package org.bouncycastle.p194crypto.p210modes.p212kgcm;

/* loaded from: classes2.dex */
public class BasicKGCMMultiplier_512 implements KGCMMultiplier {

    /* renamed from: H */
    private final long[] f20652H = new long[8];

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    /* renamed from: init */
    public void mo15641init(long[] jArr) {
        KGCMUtil_512.m15657copy(jArr, this.f20652H);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        KGCMUtil_512.multiply(jArr, this.f20652H, jArr);
    }
}
