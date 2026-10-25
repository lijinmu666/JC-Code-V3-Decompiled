package org.bouncycastle.p246its.p248jcajce;

import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.Polynomial;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.its.jcajce.ECUtil */
/* loaded from: classes2.dex */
class C5454ECUtil {
    public static EllipticCurve convertCurve(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        return new EllipticCurve(convertField(abstractC5817ECCurve.getField()), abstractC5817ECCurve.m16298getA().toBigInteger(), abstractC5817ECCurve.m16299getB().toBigInteger(), null);
    }

    public static ECField convertField(FiniteField finiteField) {
        if (ECAlgorithms.isFpField(finiteField)) {
            return new ECFieldFp(finiteField.getCharacteristic());
        }
        Polynomial minimalPolynomial = ((PolynomialExtensionField) finiteField).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), C6238Arrays.reverseInPlace(C6238Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    public static ECPoint convertPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint.normalize();
        return new ECPoint(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger(), abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger());
    }

    public static ECParameterSpec convertToSpec(X9ECParameters x9ECParameters) {
        return new ECParameterSpec(convertCurve(x9ECParameters.getCurve(), null), convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue());
    }
}
