package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECCSIPublicKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: pvt */
    private final AbstractC5820ECPoint f20732pvt;

    public ECCSIPublicKeyParameters(AbstractC5820ECPoint abstractC5820ECPoint) {
        super(false);
        this.f20732pvt = abstractC5820ECPoint;
    }

    /* renamed from: getPVT */
    public final AbstractC5820ECPoint m15718getPVT() {
        return this.f20732pvt;
    }
}
