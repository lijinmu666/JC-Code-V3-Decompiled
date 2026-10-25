package org.bouncycastle.p284math.p285ec.p290endo;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.PreCompInfo;

/* loaded from: classes2.dex */
public class EndoPreCompInfo implements PreCompInfo {
    protected ECEndomorphism endomorphism;
    protected AbstractC5820ECPoint mappedPoint;

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public AbstractC5820ECPoint getMappedPoint() {
        return this.mappedPoint;
    }

    public void setEndomorphism(ECEndomorphism eCEndomorphism) {
        this.endomorphism = eCEndomorphism;
    }

    public void setMappedPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        this.mappedPoint = abstractC5820ECPoint;
    }
}
