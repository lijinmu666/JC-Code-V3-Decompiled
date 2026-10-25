package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.Polynomial;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECNamedCurveSpec extends ECParameterSpec {

    /* renamed from: name */
    private String f22057name;

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(ellipticCurve, eCPoint, bigInteger, 1);
        this.f22057name = str;
    }

    private static EllipticCurve convertCurve(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        return new EllipticCurve(convertField(abstractC5817ECCurve.getField()), abstractC5817ECCurve.m16298getA().toBigInteger(), abstractC5817ECCurve.m16299getB().toBigInteger(), bArr);
    }

    private static ECField convertField(FiniteField finiteField) {
        if (ECAlgorithms.isFpField(finiteField)) {
            return new ECFieldFp(finiteField.getCharacteristic());
        }
        Polynomial minimalPolynomial = ((PolynomialExtensionField) finiteField).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), C6238Arrays.reverseInPlace(C6238Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    /* renamed from: getName */
    public String m16267getName() {
        return this.f22057name;
    }

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.f22057name = str;
    }

    public ECNamedCurveSpec(String str, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        super(convertCurve(abstractC5817ECCurve, null), C5617EC5Util.convertPoint(abstractC5820ECPoint), bigInteger, 1);
        this.f22057name = str;
    }

    public ECNamedCurveSpec(String str, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(convertCurve(abstractC5817ECCurve, null), C5617EC5Util.convertPoint(abstractC5820ECPoint), bigInteger, bigInteger2.intValue());
        this.f22057name = str;
    }

    public ECNamedCurveSpec(String str, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(convertCurve(abstractC5817ECCurve, bArr), C5617EC5Util.convertPoint(abstractC5820ECPoint), bigInteger, bigInteger2.intValue());
        this.f22057name = str;
    }
}
