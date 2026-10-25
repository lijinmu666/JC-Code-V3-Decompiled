package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class WNafL2RMultiplier extends AbstractECMultiplier {
    @Override // org.bouncycastle.p284math.p285ec.AbstractECMultiplier
    public AbstractC5820ECPoint multiplyPositive(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        AbstractC5820ECPoint abstractC5820ECPointMo16330add;
        WNafPreCompInfo wNafPreCompInfoPrecompute = WNafUtil.precompute(abstractC5820ECPoint, WNafUtil.getWindowSize(bigInteger.bitLength()), true);
        AbstractC5820ECPoint[] preComp = wNafPreCompInfoPrecompute.getPreComp();
        AbstractC5820ECPoint[] preCompNeg = wNafPreCompInfoPrecompute.getPreCompNeg();
        int width = wNafPreCompInfoPrecompute.getWidth();
        int[] iArrGenerateCompactWindowNaf = WNafUtil.generateCompactWindowNaf(width, bigInteger);
        AbstractC5820ECPoint infinity = abstractC5820ECPoint.getCurve().getInfinity();
        int length = iArrGenerateCompactWindowNaf.length;
        if (length > 1) {
            length--;
            int i = iArrGenerateCompactWindowNaf[length];
            int i2 = i >> 16;
            int i3 = i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            int iAbs = Math.abs(i2);
            AbstractC5820ECPoint[] abstractC5820ECPointArr = i2 < 0 ? preCompNeg : preComp;
            if ((iAbs << 2) < (1 << width)) {
                int iBitLength = Integers.bitLength(iAbs);
                int i4 = width - iBitLength;
                abstractC5820ECPointMo16330add = abstractC5820ECPointArr[((1 << (width - 1)) - 1) >>> 1].mo16330add(abstractC5820ECPointArr[(((iAbs ^ (1 << (iBitLength - 1))) << i4) + 1) >>> 1]);
                i3 -= i4;
            } else {
                abstractC5820ECPointMo16330add = abstractC5820ECPointArr[iAbs >>> 1];
            }
            infinity = abstractC5820ECPointMo16330add.timesPow2(i3);
        }
        while (length > 0) {
            length--;
            int i5 = iArrGenerateCompactWindowNaf[length];
            int i6 = i5 >> 16;
            infinity = infinity.twicePlus((i6 < 0 ? preCompNeg : preComp)[Math.abs(i6) >>> 1]).timesPow2(i5 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
        }
        return infinity;
    }
}
