package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public class ScaleYNegateXPointMap implements ECPointMap {

    /* renamed from: scale */
    protected final ECFieldElement f22138scale;

    public ScaleYNegateXPointMap(ECFieldElement eCFieldElement) {
        this.f22138scale = eCFieldElement;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECPointMap
    /* renamed from: map */
    public AbstractC5820ECPoint mo16345map(AbstractC5820ECPoint abstractC5820ECPoint) {
        return abstractC5820ECPoint.scaleYNegateX(this.f22138scale);
    }
}
