package org.bouncycastle.p194crypto.hash2curve;

import org.bouncycastle.p194crypto.hash2curve.p203data.AffineXY;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public interface CurveProcessor {
    /* renamed from: add */
    AbstractC5820ECPoint mo15506add(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2);

    AbstractC5820ECPoint clearCofactor(AbstractC5820ECPoint abstractC5820ECPoint);

    AffineXY mapToAffineXY(AbstractC5820ECPoint abstractC5820ECPoint);
}
