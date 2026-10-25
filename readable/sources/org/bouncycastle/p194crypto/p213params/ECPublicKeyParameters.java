package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: q */
    private final AbstractC5820ECPoint f20741q;

    public ECPublicKeyParameters(AbstractC5820ECPoint abstractC5820ECPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f20741q = eCDomainParameters.validatePublicPoint(abstractC5820ECPoint);
    }

    /* renamed from: getQ */
    public AbstractC5820ECPoint m15728getQ() {
        return this.f20741q;
    }
}
