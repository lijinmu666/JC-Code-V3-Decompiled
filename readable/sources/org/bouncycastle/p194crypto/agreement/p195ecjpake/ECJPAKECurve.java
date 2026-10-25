package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECJPAKECurve {

    /* renamed from: curve */
    private final AbstractC5817ECCurve.AbstractFp f19162curve;

    /* renamed from: g */
    private final AbstractC5820ECPoint f19163g;

    public ECJPAKECurve(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7) {
        ECJPAKEUtil.validateNotNull(bigInteger2, "a");
        ECJPAKEUtil.validateNotNull(bigInteger3, "b");
        ECJPAKEUtil.validateNotNull(bigInteger, "q");
        ECJPAKEUtil.validateNotNull(bigInteger4, "n");
        ECJPAKEUtil.validateNotNull(bigInteger5, "h");
        ECJPAKEUtil.validateNotNull(bigInteger6, "g_x");
        ECJPAKEUtil.validateNotNull(bigInteger7, "g_y");
        if (!bigInteger.isProbablePrime(20)) {
            throw new IllegalArgumentException("Field size q must be prime");
        }
        BigInteger bigInteger8 = BigInteger.ZERO;
        if (bigInteger2.compareTo(bigInteger8) < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            throw new IllegalArgumentException("The parameter 'a' is not in the field [0, q-1]");
        }
        if (bigInteger3.compareTo(bigInteger8) < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
            throw new IllegalArgumentException("The parameter 'b' is not in the field [0, q-1]");
        }
        if (calculateDeterminant(bigInteger, bigInteger2, bigInteger3).equals(bigInteger8)) {
            throw new IllegalArgumentException("The curve is singular, i.e the discriminant is equal to 0 mod q.");
        }
        if (!bigInteger4.isProbablePrime(20)) {
            throw new IllegalArgumentException("The order n must be prime");
        }
        AbstractC5817ECCurve.Fp fp = new AbstractC5817ECCurve.Fp(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5);
        this.f19162curve = fp;
        this.f19163g = fp.validatePoint(bigInteger6, bigInteger7);
    }

    private static BigInteger calculateDeterminant(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.multiply(bigInteger2).mod(bigInteger).multiply(bigInteger2).mod(bigInteger).shiftLeft(2).add(bigInteger3.multiply(bigInteger3).mod(bigInteger).multiply(BigInteger.valueOf(27L))).mod(bigInteger);
    }

    /* renamed from: getA */
    public BigInteger m15010getA() {
        return this.f19162curve.m16298getA().toBigInteger();
    }

    /* renamed from: getB */
    public BigInteger m15011getB() {
        return this.f19162curve.m16299getB().toBigInteger();
    }

    public AbstractC5817ECCurve.AbstractFp getCurve() {
        return this.f19162curve;
    }

    /* renamed from: getG */
    public AbstractC5820ECPoint m15012getG() {
        return this.f19163g;
    }

    /* renamed from: getH */
    public BigInteger m15013getH() {
        return this.f19162curve.getCofactor();
    }

    /* renamed from: getN */
    public BigInteger m15014getN() {
        return this.f19162curve.getOrder();
    }

    /* renamed from: getQ */
    public BigInteger m15015getQ() {
        return this.f19162curve.mo16304getQ();
    }

    public ECJPAKECurve(AbstractC5817ECCurve.AbstractFp abstractFp, AbstractC5820ECPoint abstractC5820ECPoint) {
        ECJPAKEUtil.validateNotNull(abstractFp, "curve");
        ECJPAKEUtil.validateNotNull(abstractC5820ECPoint, "g");
        ECJPAKEUtil.validateNotNull(abstractFp.getOrder(), "n");
        ECJPAKEUtil.validateNotNull(abstractFp.getCofactor(), "h");
        this.f19162curve = abstractFp;
        this.f19163g = abstractC5820ECPoint;
    }
}
