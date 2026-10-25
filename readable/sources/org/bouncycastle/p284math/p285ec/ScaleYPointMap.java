package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public class ScaleYPointMap implements ECPointMap {

    /* renamed from: scale */
    protected final ECFieldElement f22139scale;

    public ScaleYPointMap(ECFieldElement eCFieldElement) {
        this.f22139scale = eCFieldElement;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECPointMap
    /* renamed from: map */
    public AbstractC5820ECPoint mo16345map(AbstractC5820ECPoint abstractC5820ECPoint) {
        return abstractC5820ECPoint.mo16337scaleY(this.f22139scale);
    }
}
