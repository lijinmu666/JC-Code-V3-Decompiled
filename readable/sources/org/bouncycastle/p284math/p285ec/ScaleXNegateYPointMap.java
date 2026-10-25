package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public class ScaleXNegateYPointMap implements ECPointMap {

    /* renamed from: scale */
    protected final ECFieldElement f22136scale;

    public ScaleXNegateYPointMap(ECFieldElement eCFieldElement) {
        this.f22136scale = eCFieldElement;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECPointMap
    /* renamed from: map */
    public AbstractC5820ECPoint mo16345map(AbstractC5820ECPoint abstractC5820ECPoint) {
        return abstractC5820ECPoint.scaleXNegateY(this.f22136scale);
    }
}
