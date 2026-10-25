package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class FixedPointUtil {
    public static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(AbstractC5817ECCurve abstractC5817ECCurve) {
        BigInteger order = abstractC5817ECCurve.getOrder();
        return order == null ? abstractC5817ECCurve.getFieldSize() + 1 : order.bitLength();
    }

    public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof FixedPointPreCompInfo) {
            return (FixedPointPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static FixedPointPreCompInfo precompute(final AbstractC5820ECPoint abstractC5820ECPoint) {
        final AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        return (FixedPointPreCompInfo) curve.precompute(abstractC5820ECPoint, PRECOMP_NAME, new PreCompCallback() { // from class: org.bouncycastle.math.ec.FixedPointUtil.1
            private boolean checkExisting(FixedPointPreCompInfo fixedPointPreCompInfo, int i) {
                return fixedPointPreCompInfo != null && checkTable(fixedPointPreCompInfo.getLookupTable(), i);
            }

            private boolean checkTable(ECLookupTable eCLookupTable, int i) {
                return eCLookupTable != null && eCLookupTable.mo16300getSize() >= i;
            }

            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                FixedPointPreCompInfo fixedPointPreCompInfo = preCompInfo instanceof FixedPointPreCompInfo ? (FixedPointPreCompInfo) preCompInfo : null;
                int combSize = FixedPointUtil.getCombSize(curve);
                int i = combSize > 250 ? 6 : 5;
                int i2 = 1 << i;
                if (checkExisting(fixedPointPreCompInfo, i2)) {
                    return fixedPointPreCompInfo;
                }
                int i3 = ((combSize + i) - 1) / i;
                AbstractC5820ECPoint[] abstractC5820ECPointArr = new AbstractC5820ECPoint[i + 1];
                abstractC5820ECPointArr[0] = abstractC5820ECPoint;
                for (int i4 = 1; i4 < i; i4++) {
                    abstractC5820ECPointArr[i4] = abstractC5820ECPointArr[i4 - 1].timesPow2(i3);
                }
                abstractC5820ECPointArr[i] = abstractC5820ECPointArr[0].subtract(abstractC5820ECPointArr[1]);
                curve.normalizeAll(abstractC5820ECPointArr);
                AbstractC5820ECPoint[] abstractC5820ECPointArr2 = new AbstractC5820ECPoint[i2];
                abstractC5820ECPointArr2[0] = abstractC5820ECPointArr[0];
                for (int i5 = i - 1; i5 >= 0; i5--) {
                    AbstractC5820ECPoint abstractC5820ECPoint2 = abstractC5820ECPointArr[i5];
                    int i6 = 1 << i5;
                    for (int i7 = i6; i7 < i2; i7 += i6 << 1) {
                        abstractC5820ECPointArr2[i7] = abstractC5820ECPointArr2[i7 - i6].mo16330add(abstractC5820ECPoint2);
                    }
                }
                curve.normalizeAll(abstractC5820ECPointArr2);
                FixedPointPreCompInfo fixedPointPreCompInfo2 = new FixedPointPreCompInfo();
                fixedPointPreCompInfo2.setLookupTable(curve.createCacheSafeLookupTable(abstractC5820ECPointArr2, 0, i2));
                fixedPointPreCompInfo2.setOffset(abstractC5820ECPointArr[i]);
                fixedPointPreCompInfo2.setWidth(i);
                return fixedPointPreCompInfo2;
            }
        });
    }
}
