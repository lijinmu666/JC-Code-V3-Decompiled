package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.hash2curve.CurveProcessor;
import org.bouncycastle.p194crypto.hash2curve.p203data.AffineXY;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class NistCurveProcessor implements CurveProcessor {
    @Override // org.bouncycastle.p194crypto.hash2curve.CurveProcessor
    /* renamed from: add */
    public AbstractC5820ECPoint mo15506add(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2) {
        return abstractC5820ECPoint.mo16330add(abstractC5820ECPoint2);
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.CurveProcessor
    public AbstractC5820ECPoint clearCofactor(AbstractC5820ECPoint abstractC5820ECPoint) {
        return abstractC5820ECPoint.multiply(BigInteger.ONE);
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.CurveProcessor
    public AffineXY mapToAffineXY(AbstractC5820ECPoint abstractC5820ECPoint) {
        return new AffineXY(abstractC5820ECPoint);
    }
}
