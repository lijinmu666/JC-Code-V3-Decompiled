package org.bouncycastle.p281jce.p282spec;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q */
    private AbstractC5820ECPoint f22064q;

    public ECPublicKeySpec(AbstractC5820ECPoint abstractC5820ECPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f22064q = abstractC5820ECPoint.getCurve() != null ? abstractC5820ECPoint.normalize() : abstractC5820ECPoint;
    }

    /* renamed from: getQ */
    public AbstractC5820ECPoint m16274getQ() {
        return this.f22064q;
    }
}
