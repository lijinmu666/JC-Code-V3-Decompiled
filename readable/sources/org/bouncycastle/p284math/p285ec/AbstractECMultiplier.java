package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class AbstractECMultiplier implements ECMultiplier {
    public AbstractC5820ECPoint checkResult(AbstractC5820ECPoint abstractC5820ECPoint) {
        return ECAlgorithms.implCheckResult(abstractC5820ECPoint);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECMultiplier
    public AbstractC5820ECPoint multiply(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        int iSignum = bigInteger.signum();
        if (iSignum == 0 || abstractC5820ECPoint.isInfinity()) {
            return abstractC5820ECPoint.getCurve().getInfinity();
        }
        AbstractC5820ECPoint abstractC5820ECPointMultiplyPositive = multiplyPositive(abstractC5820ECPoint, bigInteger.abs());
        if (iSignum <= 0) {
            abstractC5820ECPointMultiplyPositive = abstractC5820ECPointMultiplyPositive.mo16335negate();
        }
        return checkResult(abstractC5820ECPointMultiplyPositive);
    }

    public abstract AbstractC5820ECPoint multiplyPositive(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger);
}
