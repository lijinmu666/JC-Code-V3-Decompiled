package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;

/* loaded from: classes2.dex */
public class SecT131R1Point extends AbstractC5820ECPoint.AbstractF2m {
    public SecT131R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: add */
    public AbstractC5820ECPoint mo16330add(AbstractC5820ECPoint abstractC5820ECPoint) {
        ECFieldElement eCFieldElementMultiply;
        ECFieldElement eCFieldElementMultiply2;
        ECFieldElement eCFieldElementMultiply3;
        ECFieldElement eCFieldElementMultiply4;
        ECFieldElement eCFieldElementSquarePlusProduct;
        ECFieldElement eCFieldElementMo16310add;
        if (isInfinity()) {
            return abstractC5820ECPoint;
        }
        if (abstractC5820ECPoint.isInfinity()) {
            return this;
        }
        AbstractC5817ECCurve curve = getCurve();
        ECFieldElement eCFieldElementMultiply5 = this.f22125x;
        ECFieldElement rawXCoord = abstractC5820ECPoint.getRawXCoord();
        if (eCFieldElementMultiply5.mo16315isZero()) {
            return rawXCoord.mo16315isZero() ? curve.getInfinity() : abstractC5820ECPoint.mo16330add(this);
        }
        ECFieldElement eCFieldElement = this.f22126y;
        ECFieldElement eCFieldElement2 = this.f22127zs[0];
        ECFieldElement rawYCoord = abstractC5820ECPoint.getRawYCoord();
        ECFieldElement zCoord = abstractC5820ECPoint.getZCoord(0);
        boolean zMo16314isOne = eCFieldElement2.mo16314isOne();
        if (zMo16314isOne) {
            eCFieldElementMultiply = rawXCoord;
            eCFieldElementMultiply2 = rawYCoord;
        } else {
            eCFieldElementMultiply = rawXCoord.multiply(eCFieldElement2);
            eCFieldElementMultiply2 = rawYCoord.multiply(eCFieldElement2);
        }
        boolean zMo16314isOne2 = zCoord.mo16314isOne();
        if (zMo16314isOne2) {
            eCFieldElementMultiply3 = eCFieldElement;
        } else {
            eCFieldElementMultiply5 = eCFieldElementMultiply5.multiply(zCoord);
            eCFieldElementMultiply3 = eCFieldElement.multiply(zCoord);
        }
        ECFieldElement eCFieldElementMo16310add2 = eCFieldElementMultiply3.mo16310add(eCFieldElementMultiply2);
        ECFieldElement eCFieldElementMo16310add3 = eCFieldElementMultiply5.mo16310add(eCFieldElementMultiply);
        if (eCFieldElementMo16310add3.mo16315isZero()) {
            return eCFieldElementMo16310add2.mo16315isZero() ? mo16338twice() : curve.getInfinity();
        }
        if (rawXCoord.mo16315isZero()) {
            AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
            ECFieldElement xCoord = abstractC5820ECPointNormalize.getXCoord();
            ECFieldElement yCoord = abstractC5820ECPointNormalize.getYCoord();
            ECFieldElement eCFieldElementMo16312divide = yCoord.mo16310add(rawYCoord).mo16312divide(xCoord);
            eCFieldElementMo16310add = eCFieldElementMo16312divide.mo16318square().mo16310add(eCFieldElementMo16312divide).mo16310add(xCoord).mo16310add(curve.m16298getA());
            if (eCFieldElementMo16310add.mo16315isZero()) {
                return new SecT131R1Point(curve, eCFieldElementMo16310add, curve.m16299getB().mo16317sqrt());
            }
            eCFieldElementSquarePlusProduct = eCFieldElementMo16312divide.multiply(xCoord.mo16310add(eCFieldElementMo16310add)).mo16310add(eCFieldElementMo16310add).mo16310add(yCoord).mo16312divide(eCFieldElementMo16310add).mo16310add(eCFieldElementMo16310add);
            eCFieldElementMultiply4 = curve.fromBigInteger(ECConstants.f22091ONE);
        } else {
            ECFieldElement eCFieldElementMo16318square = eCFieldElementMo16310add3.mo16318square();
            ECFieldElement eCFieldElementMultiply6 = eCFieldElementMo16310add2.multiply(eCFieldElementMultiply5);
            ECFieldElement eCFieldElementMultiply7 = eCFieldElementMo16310add2.multiply(eCFieldElementMultiply);
            ECFieldElement eCFieldElementMultiply8 = eCFieldElementMultiply6.multiply(eCFieldElementMultiply7);
            if (eCFieldElementMultiply8.mo16315isZero()) {
                return new SecT131R1Point(curve, eCFieldElementMultiply8, curve.m16299getB().mo16317sqrt());
            }
            ECFieldElement eCFieldElementMultiply9 = eCFieldElementMo16310add2.multiply(eCFieldElementMo16318square);
            eCFieldElementMultiply4 = !zMo16314isOne2 ? eCFieldElementMultiply9.multiply(zCoord) : eCFieldElementMultiply9;
            eCFieldElementSquarePlusProduct = eCFieldElementMultiply7.mo16310add(eCFieldElementMo16318square).squarePlusProduct(eCFieldElementMultiply4, eCFieldElement.mo16310add(eCFieldElement2));
            if (!zMo16314isOne) {
                eCFieldElementMultiply4 = eCFieldElementMultiply4.multiply(eCFieldElement2);
            }
            eCFieldElementMo16310add = eCFieldElementMultiply8;
        }
        return new SecT131R1Point(curve, eCFieldElementMo16310add, eCFieldElementSquarePlusProduct, new ECFieldElement[]{eCFieldElementMultiply4});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecT131R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public boolean getCompressionYTilde() {
        ECFieldElement rawXCoord = getRawXCoord();
        return (rawXCoord.mo16315isZero() || getRawYCoord().testBitZero() == rawXCoord.testBitZero()) ? false : true;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.f22125x;
        ECFieldElement eCFieldElement2 = this.f22126y;
        if (isInfinity() || eCFieldElement.mo16315isZero()) {
            return eCFieldElement2;
        }
        ECFieldElement eCFieldElementMultiply = eCFieldElement2.mo16310add(eCFieldElement).multiply(eCFieldElement);
        ECFieldElement eCFieldElement3 = this.f22127zs[0];
        return !eCFieldElement3.mo16314isOne() ? eCFieldElementMultiply.mo16312divide(eCFieldElement3) : eCFieldElementMultiply;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        if (isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.f22125x;
        if (eCFieldElement.mo16315isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.f22126y;
        ECFieldElement eCFieldElement3 = this.f22127zs[0];
        return new SecT131R1Point(this.f22124curve, eCFieldElement, eCFieldElement2.mo16310add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: twice */
    public AbstractC5820ECPoint mo16338twice() {
        if (isInfinity()) {
            return this;
        }
        AbstractC5817ECCurve curve = getCurve();
        ECFieldElement eCFieldElementMultiply = this.f22125x;
        if (eCFieldElementMultiply.mo16315isZero()) {
            return curve.getInfinity();
        }
        ECFieldElement eCFieldElement = this.f22126y;
        ECFieldElement eCFieldElement2 = this.f22127zs[0];
        boolean zMo16314isOne = eCFieldElement2.mo16314isOne();
        ECFieldElement eCFieldElementMultiply2 = zMo16314isOne ? eCFieldElement : eCFieldElement.multiply(eCFieldElement2);
        ECFieldElement eCFieldElementMo16318square = zMo16314isOne ? eCFieldElement2 : eCFieldElement2.mo16318square();
        ECFieldElement eCFieldElementM16298getA = curve.m16298getA();
        if (!zMo16314isOne) {
            eCFieldElementM16298getA = eCFieldElementM16298getA.multiply(eCFieldElementMo16318square);
        }
        ECFieldElement eCFieldElementMo16310add = eCFieldElement.mo16318square().mo16310add(eCFieldElementMultiply2).mo16310add(eCFieldElementM16298getA);
        if (eCFieldElementMo16310add.mo16315isZero()) {
            return new SecT131R1Point(curve, eCFieldElementMo16310add, curve.m16299getB().mo16317sqrt());
        }
        ECFieldElement eCFieldElementMo16318square2 = eCFieldElementMo16310add.mo16318square();
        ECFieldElement eCFieldElementMultiply3 = zMo16314isOne ? eCFieldElementMo16310add : eCFieldElementMo16310add.multiply(eCFieldElementMo16318square);
        if (!zMo16314isOne) {
            eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElement2);
        }
        return new SecT131R1Point(curve, eCFieldElementMo16318square2, eCFieldElementMultiply.squarePlusProduct(eCFieldElementMo16310add, eCFieldElementMultiply2).mo16310add(eCFieldElementMo16318square2).mo16310add(eCFieldElementMultiply3), new ECFieldElement[]{eCFieldElementMultiply3});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (isInfinity()) {
            return abstractC5820ECPoint;
        }
        if (abstractC5820ECPoint.isInfinity()) {
            return mo16338twice();
        }
        AbstractC5817ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.f22125x;
        if (eCFieldElement.mo16315isZero()) {
            return abstractC5820ECPoint;
        }
        ECFieldElement rawXCoord = abstractC5820ECPoint.getRawXCoord();
        ECFieldElement zCoord = abstractC5820ECPoint.getZCoord(0);
        if (rawXCoord.mo16315isZero() || !zCoord.mo16314isOne()) {
            return mo16338twice().mo16330add(abstractC5820ECPoint);
        }
        ECFieldElement eCFieldElement2 = this.f22126y;
        ECFieldElement eCFieldElement3 = this.f22127zs[0];
        ECFieldElement rawYCoord = abstractC5820ECPoint.getRawYCoord();
        ECFieldElement eCFieldElementMo16318square = eCFieldElement.mo16318square();
        ECFieldElement eCFieldElementMo16318square2 = eCFieldElement2.mo16318square();
        ECFieldElement eCFieldElementMo16318square3 = eCFieldElement3.mo16318square();
        ECFieldElement eCFieldElementMo16310add = curve.m16298getA().multiply(eCFieldElementMo16318square3).mo16310add(eCFieldElementMo16318square2).mo16310add(eCFieldElement2.multiply(eCFieldElement3));
        ECFieldElement eCFieldElementMo16311addOne = rawYCoord.mo16311addOne();
        ECFieldElement eCFieldElementMultiplyPlusProduct = curve.m16298getA().mo16310add(eCFieldElementMo16311addOne).multiply(eCFieldElementMo16318square3).mo16310add(eCFieldElementMo16318square2).multiplyPlusProduct(eCFieldElementMo16310add, eCFieldElementMo16318square, eCFieldElementMo16318square3);
        ECFieldElement eCFieldElementMultiply = rawXCoord.multiply(eCFieldElementMo16318square3);
        ECFieldElement eCFieldElementMo16318square4 = eCFieldElementMultiply.mo16310add(eCFieldElementMo16310add).mo16318square();
        if (eCFieldElementMo16318square4.mo16315isZero()) {
            return eCFieldElementMultiplyPlusProduct.mo16315isZero() ? abstractC5820ECPoint.mo16338twice() : curve.getInfinity();
        }
        if (eCFieldElementMultiplyPlusProduct.mo16315isZero()) {
            return new SecT131R1Point(curve, eCFieldElementMultiplyPlusProduct, curve.m16299getB().mo16317sqrt());
        }
        ECFieldElement eCFieldElementMultiply2 = eCFieldElementMultiplyPlusProduct.mo16318square().multiply(eCFieldElementMultiply);
        ECFieldElement eCFieldElementMultiply3 = eCFieldElementMultiplyPlusProduct.multiply(eCFieldElementMo16318square4).multiply(eCFieldElementMo16318square3);
        return new SecT131R1Point(curve, eCFieldElementMultiply2, eCFieldElementMultiplyPlusProduct.mo16310add(eCFieldElementMo16318square4).mo16318square().multiplyPlusProduct(eCFieldElementMo16310add, eCFieldElementMo16311addOne, eCFieldElementMultiply3), new ECFieldElement[]{eCFieldElementMultiply3});
    }

    public SecT131R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
