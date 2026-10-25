package org.bouncycastle.p194crypto.p210modes.p212kgcm;

/* loaded from: classes2.dex */
public class BasicKGCMMultiplier_256 implements KGCMMultiplier {

    /* renamed from: H */
    private final long[] f20651H = new long[4];

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    /* renamed from: init */
    public void mo15641init(long[] jArr) {
        KGCMUtil_256.m15650copy(jArr, this.f20651H);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p212kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        KGCMUtil_256.multiply(jArr, this.f20651H, jArr);
    }
}
