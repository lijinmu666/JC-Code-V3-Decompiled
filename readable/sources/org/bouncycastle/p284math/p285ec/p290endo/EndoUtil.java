package org.bouncycastle.p284math.p285ec.p290endo;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.PreCompCallback;
import org.bouncycastle.p284math.p285ec.PreCompInfo;

/* loaded from: classes2.dex */
public abstract class EndoUtil {
    public static final String PRECOMP_NAME = "bc_endo";

    private static BigInteger calculateB(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        boolean z = bigInteger2.signum() < 0;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2.abs());
        boolean zTestBit = bigIntegerMultiply.testBit(i - 1);
        BigInteger bigIntegerShiftRight = bigIntegerMultiply.shiftRight(i);
        if (zTestBit) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(ECConstants.f22091ONE);
        }
        return z ? bigIntegerShiftRight.negate() : bigIntegerShiftRight;
    }

    public static BigInteger[] decomposeScalar(ScalarSplitParameters scalarSplitParameters, BigInteger bigInteger) {
        int iM16779getBits = scalarSplitParameters.m16779getBits();
        BigInteger bigIntegerCalculateB = calculateB(bigInteger, scalarSplitParameters.m16780getG1(), iM16779getBits);
        BigInteger bigIntegerCalculateB2 = calculateB(bigInteger, scalarSplitParameters.m16781getG2(), iM16779getBits);
        return new BigInteger[]{bigInteger.subtract(bigIntegerCalculateB.multiply(scalarSplitParameters.m16782getV1A()).add(bigIntegerCalculateB2.multiply(scalarSplitParameters.m16784getV2A()))), bigIntegerCalculateB.multiply(scalarSplitParameters.m16783getV1B()).add(bigIntegerCalculateB2.multiply(scalarSplitParameters.m16785getV2B())).negate()};
    }

    public static AbstractC5820ECPoint mapPoint(final ECEndomorphism eCEndomorphism, final AbstractC5820ECPoint abstractC5820ECPoint) {
        return ((EndoPreCompInfo) abstractC5820ECPoint.getCurve().precompute(abstractC5820ECPoint, PRECOMP_NAME, new PreCompCallback() { // from class: org.bouncycastle.math.ec.endo.EndoUtil.1
            private boolean checkExisting(EndoPreCompInfo endoPreCompInfo, ECEndomorphism eCEndomorphism2) {
                return (endoPreCompInfo == null || endoPreCompInfo.getEndomorphism() != eCEndomorphism2 || endoPreCompInfo.getMappedPoint() == null) ? false : true;
            }

            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                EndoPreCompInfo endoPreCompInfo = preCompInfo instanceof EndoPreCompInfo ? (EndoPreCompInfo) preCompInfo : null;
                if (checkExisting(endoPreCompInfo, eCEndomorphism)) {
                    return endoPreCompInfo;
                }
                AbstractC5820ECPoint abstractC5820ECPointMo16345map = eCEndomorphism.getPointMap().mo16345map(abstractC5820ECPoint);
                EndoPreCompInfo endoPreCompInfo2 = new EndoPreCompInfo();
                endoPreCompInfo2.setEndomorphism(eCEndomorphism);
                endoPreCompInfo2.setMappedPoint(abstractC5820ECPointMo16345map);
                return endoPreCompInfo2;
            }
        })).getMappedPoint();
    }
}
