package org.bouncycastle.p194crypto.hash2curve.p203data;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public final class AffineXY {

    /* renamed from: x */
    private final BigInteger f20301x;

    /* renamed from: y */
    private final BigInteger f20302y;

    public AffineXY(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f20301x = bigInteger;
        this.f20302y = bigInteger2;
    }

    /* renamed from: getX */
    public BigInteger m15526getX() {
        return this.f20301x;
    }

    /* renamed from: getY */
    public BigInteger m15527getY() {
        return this.f20302y;
    }

    /* renamed from: toPoint */
    public AbstractC5820ECPoint m15528toPoint(AbstractC5817ECCurve abstractC5817ECCurve) {
        return abstractC5817ECCurve.createPoint(m15526getX(), m15527getY()).normalize();
    }

    public AffineXY(AbstractC5820ECPoint abstractC5820ECPoint) {
        this(abstractC5820ECPoint, true);
    }

    public AffineXY(AbstractC5820ECPoint abstractC5820ECPoint, boolean z) {
        if (abstractC5820ECPoint.isInfinity()) {
            throw new IllegalArgumentException("Cannot extract affine coordinates from point at infinity");
        }
        abstractC5820ECPoint = z ? abstractC5820ECPoint.normalize() : abstractC5820ECPoint;
        this.f20301x = abstractC5820ECPoint.getAffineXCoord().toBigInteger();
        this.f20302y = abstractC5820ECPoint.getAffineYCoord().toBigInteger();
    }
}
