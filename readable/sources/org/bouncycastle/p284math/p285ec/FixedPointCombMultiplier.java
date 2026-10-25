package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;

/* loaded from: classes2.dex */
public class FixedPointCombMultiplier extends AbstractECMultiplier {
    @Override // org.bouncycastle.p284math.p285ec.AbstractECMultiplier
    public AbstractC5820ECPoint multiplyPositive(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        if (bigInteger.bitLength() > FixedPointUtil.getCombSize(curve)) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        FixedPointPreCompInfo fixedPointPreCompInfoPrecompute = FixedPointUtil.precompute(abstractC5820ECPoint);
        ECLookupTable lookupTable = fixedPointPreCompInfoPrecompute.getLookupTable();
        int width = fixedPointPreCompInfoPrecompute.getWidth();
        int i = ((r0 + width) - 1) / width;
        AbstractC5820ECPoint infinity = curve.getInfinity();
        int i2 = width * i;
        int[] iArrFromBigInteger = AbstractC5869Nat.fromBigInteger(i2, bigInteger);
        int i3 = i2 - 1;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = 0;
            for (int i6 = i3 - i4; i6 >= 0; i6 -= i) {
                int i7 = iArrFromBigInteger[i6 >>> 5] >>> (i6 & 31);
                i5 = ((i5 ^ (i7 >>> 1)) << 1) ^ i7;
            }
            infinity = infinity.twicePlus(lookupTable.mo16301lookup(i5));
        }
        return infinity.mo16330add(fixedPointPreCompInfoPrecompute.getOffset());
    }
}
