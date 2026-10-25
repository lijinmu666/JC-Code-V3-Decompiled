package org.bouncycastle.p133asn1.p170ua;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;

/* loaded from: classes2.dex */
public abstract class DSTU4145PointEncoder {
    public static AbstractC5820ECPoint decodePoint(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        ECFieldElement eCFieldElementMultiply;
        ECFieldElement eCFieldElementFromBigInteger = abstractC5817ECCurve.fromBigInteger(BigInteger.valueOf(bArr[bArr.length - 1] & 1));
        ECFieldElement eCFieldElementFromBigInteger2 = abstractC5817ECCurve.fromBigInteger(new BigInteger(1, bArr));
        if (!m14662trace(eCFieldElementFromBigInteger2).equals(abstractC5817ECCurve.m16298getA())) {
            eCFieldElementFromBigInteger2 = eCFieldElementFromBigInteger2.mo16311addOne();
        }
        if (eCFieldElementFromBigInteger2.mo16315isZero()) {
            eCFieldElementMultiply = abstractC5817ECCurve.m16299getB().mo16317sqrt();
        } else {
            ECFieldElement eCFieldElementSolveQuadraticEquation = solveQuadraticEquation(abstractC5817ECCurve, eCFieldElementFromBigInteger2.mo16318square().mo16313invert().multiply(abstractC5817ECCurve.m16299getB()).mo16310add(abstractC5817ECCurve.m16298getA()).mo16310add(eCFieldElementFromBigInteger2));
            if (eCFieldElementSolveQuadraticEquation != null) {
                if (!m14662trace(eCFieldElementSolveQuadraticEquation).equals(eCFieldElementFromBigInteger)) {
                    eCFieldElementSolveQuadraticEquation = eCFieldElementSolveQuadraticEquation.mo16311addOne();
                }
                eCFieldElementMultiply = eCFieldElementFromBigInteger2.multiply(eCFieldElementSolveQuadraticEquation);
            } else {
                eCFieldElementMultiply = null;
            }
        }
        if (eCFieldElementMultiply != null) {
            return abstractC5817ECCurve.validatePoint(eCFieldElementFromBigInteger2.toBigInteger(), eCFieldElementMultiply.toBigInteger());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    public static byte[] encodePoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint.normalize();
        ECFieldElement affineXCoord = abstractC5820ECPointNormalize.getAffineXCoord();
        byte[] encoded = affineXCoord.getEncoded();
        if (!affineXCoord.mo16315isZero()) {
            if (m14662trace(abstractC5820ECPointNormalize.getAffineYCoord().mo16312divide(affineXCoord)).mo16314isOne()) {
                int length = encoded.length - 1;
                encoded[length] = (byte) (encoded[length] | 1);
            } else {
                int length2 = encoded.length - 1;
                encoded[length2] = (byte) (encoded[length2] & 254);
            }
        }
        return encoded;
    }

    private static ECFieldElement solveQuadraticEquation(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement) {
        ECFieldElement eCFieldElementMo16310add;
        if (eCFieldElement.mo16315isZero()) {
            return eCFieldElement;
        }
        ECFieldElement eCFieldElementFromBigInteger = abstractC5817ECCurve.fromBigInteger(ECConstants.f22094ZERO);
        Random random = new Random();
        int fieldSize = eCFieldElement.getFieldSize();
        do {
            ECFieldElement eCFieldElementFromBigInteger2 = abstractC5817ECCurve.fromBigInteger(new BigInteger(fieldSize, random));
            ECFieldElement eCFieldElementMo16310add2 = eCFieldElement;
            eCFieldElementMo16310add = eCFieldElementFromBigInteger;
            for (int i = 1; i <= fieldSize - 1; i++) {
                ECFieldElement eCFieldElementMo16318square = eCFieldElementMo16310add2.mo16318square();
                eCFieldElementMo16310add = eCFieldElementMo16310add.mo16318square().mo16310add(eCFieldElementMo16318square.multiply(eCFieldElementFromBigInteger2));
                eCFieldElementMo16310add2 = eCFieldElementMo16318square.mo16310add(eCFieldElement);
            }
            if (!eCFieldElementMo16310add2.mo16315isZero()) {
                return null;
            }
        } while (eCFieldElementMo16310add.mo16318square().mo16310add(eCFieldElementMo16310add).mo16315isZero());
        return eCFieldElementMo16310add;
    }

    /* renamed from: trace */
    private static ECFieldElement m14662trace(ECFieldElement eCFieldElement) {
        ECFieldElement eCFieldElementMo16310add = eCFieldElement;
        for (int i = 1; i < eCFieldElement.getFieldSize(); i++) {
            eCFieldElementMo16310add = eCFieldElementMo16310add.mo16318square().mo16310add(eCFieldElement);
        }
        return eCFieldElementMo16310add;
    }
}
