package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5879Nat576;

/* loaded from: classes2.dex */
public class SecT571K1Point extends AbstractC5820ECPoint.AbstractF2m {
    public SecT571K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: add */
    public AbstractC5820ECPoint mo16330add(AbstractC5820ECPoint abstractC5820ECPoint) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        SecT571FieldElement secT571FieldElement;
        SecT571FieldElement secT571FieldElement2;
        SecT571FieldElement secT571FieldElement3;
        if (isInfinity()) {
            return abstractC5820ECPoint;
        }
        if (abstractC5820ECPoint.isInfinity()) {
            return this;
        }
        AbstractC5817ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f22125x;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) abstractC5820ECPoint.getRawXCoord();
        if (secT571FieldElement4.mo16315isZero()) {
            return secT571FieldElement5.mo16315isZero() ? curve.getInfinity() : abstractC5820ECPoint.mo16330add(this);
        }
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) this.f22126y;
        SecT571FieldElement secT571FieldElement7 = (SecT571FieldElement) this.f22127zs[0];
        SecT571FieldElement secT571FieldElement8 = (SecT571FieldElement) abstractC5820ECPoint.getRawYCoord();
        SecT571FieldElement secT571FieldElement9 = (SecT571FieldElement) abstractC5820ECPoint.getZCoord(0);
        long[] jArrCreate64 = AbstractC5879Nat576.create64();
        long[] jArrCreate642 = AbstractC5879Nat576.create64();
        long[] jArrCreate643 = AbstractC5879Nat576.create64();
        long[] jArrCreate644 = AbstractC5879Nat576.create64();
        long[] jArrPrecompMultiplicand = secT571FieldElement7.mo16314isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement7.f22358x);
        if (jArrPrecompMultiplicand == null) {
            jArr = secT571FieldElement5.f22358x;
            jArr2 = secT571FieldElement8.f22358x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement5.f22358x, jArrPrecompMultiplicand, jArrCreate642);
            SecT571Field.multiplyPrecomp(secT571FieldElement8.f22358x, jArrPrecompMultiplicand, jArrCreate644);
            jArr = jArrCreate642;
            jArr2 = jArrCreate644;
        }
        long[] jArrPrecompMultiplicand2 = secT571FieldElement9.mo16314isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement9.f22358x);
        if (jArrPrecompMultiplicand2 == null) {
            jArr3 = secT571FieldElement4.f22358x;
            jArr4 = secT571FieldElement6.f22358x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement4.f22358x, jArrPrecompMultiplicand2, jArrCreate64);
            SecT571Field.multiplyPrecomp(secT571FieldElement6.f22358x, jArrPrecompMultiplicand2, jArrCreate643);
            jArr3 = jArrCreate64;
            jArr4 = jArrCreate643;
        }
        SecT571Field.m16753add(jArr4, jArr2, jArrCreate643);
        SecT571Field.m16753add(jArr3, jArr, jArrCreate644);
        if (AbstractC5879Nat576.isZero64(jArrCreate644)) {
            return AbstractC5879Nat576.isZero64(jArrCreate643) ? mo16338twice() : curve.getInfinity();
        }
        if (secT571FieldElement5.mo16315isZero()) {
            AbstractC5820ECPoint abstractC5820ECPointNormalize = normalize();
            SecT571FieldElement secT571FieldElement10 = (SecT571FieldElement) abstractC5820ECPointNormalize.getXCoord();
            ECFieldElement yCoord = abstractC5820ECPointNormalize.getYCoord();
            ECFieldElement eCFieldElementMo16312divide = yCoord.mo16310add(secT571FieldElement8).mo16312divide(secT571FieldElement10);
            secT571FieldElement = (SecT571FieldElement) eCFieldElementMo16312divide.mo16318square().mo16310add(eCFieldElementMo16312divide).mo16310add(secT571FieldElement10);
            if (secT571FieldElement.mo16315isZero()) {
                return new SecT571K1Point(curve, secT571FieldElement, curve.m16299getB());
            }
            secT571FieldElement2 = (SecT571FieldElement) eCFieldElementMo16312divide.multiply(secT571FieldElement10.mo16310add(secT571FieldElement)).mo16310add(secT571FieldElement).mo16310add(yCoord).mo16312divide(secT571FieldElement).mo16310add(secT571FieldElement);
            secT571FieldElement3 = (SecT571FieldElement) curve.fromBigInteger(ECConstants.f22091ONE);
        } else {
            SecT571Field.m16761square(jArrCreate644, jArrCreate644);
            long[] jArrPrecompMultiplicand3 = SecT571Field.precompMultiplicand(jArrCreate643);
            SecT571Field.multiplyPrecomp(jArr3, jArrPrecompMultiplicand3, jArrCreate64);
            SecT571Field.multiplyPrecomp(jArr, jArrPrecompMultiplicand3, jArrCreate642);
            secT571FieldElement = new SecT571FieldElement(jArrCreate64);
            SecT571Field.multiply(jArrCreate64, jArrCreate642, secT571FieldElement.f22358x);
            if (secT571FieldElement.mo16315isZero()) {
                return new SecT571K1Point(curve, secT571FieldElement, curve.m16299getB());
            }
            SecT571FieldElement secT571FieldElement11 = new SecT571FieldElement(jArrCreate643);
            SecT571Field.multiplyPrecomp(jArrCreate644, jArrPrecompMultiplicand3, secT571FieldElement11.f22358x);
            if (jArrPrecompMultiplicand2 != null) {
                long[] jArr5 = secT571FieldElement11.f22358x;
                SecT571Field.multiplyPrecomp(jArr5, jArrPrecompMultiplicand2, jArr5);
            }
            long[] jArrCreateExt64 = AbstractC5879Nat576.createExt64();
            SecT571Field.m16753add(jArrCreate642, jArrCreate644, jArrCreate644);
            SecT571Field.squareAddToExt(jArrCreate644, jArrCreateExt64);
            SecT571Field.m16753add(secT571FieldElement6.f22358x, secT571FieldElement7.f22358x, jArrCreate644);
            SecT571Field.multiplyAddToExt(jArrCreate644, secT571FieldElement11.f22358x, jArrCreateExt64);
            SecT571FieldElement secT571FieldElement12 = new SecT571FieldElement(jArrCreate644);
            SecT571Field.m16758reduce(jArrCreateExt64, secT571FieldElement12.f22358x);
            if (jArrPrecompMultiplicand != null) {
                long[] jArr6 = secT571FieldElement11.f22358x;
                SecT571Field.multiplyPrecomp(jArr6, jArrPrecompMultiplicand, jArr6);
            }
            secT571FieldElement2 = secT571FieldElement12;
            secT571FieldElement3 = secT571FieldElement11;
        }
        return new SecT571K1Point(curve, secT571FieldElement, secT571FieldElement2, new ECFieldElement[]{secT571FieldElement3});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecT571K1Point(null, getAffineXCoord(), getAffineYCoord());
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
        return new SecT571K1Point(this.f22124curve, eCFieldElement, eCFieldElement2.mo16310add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: twice */
    public AbstractC5820ECPoint mo16338twice() {
        if (isInfinity()) {
            return this;
        }
        AbstractC5817ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.f22125x;
        if (eCFieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        ECFieldElement eCFieldElement2 = this.f22126y;
        ECFieldElement eCFieldElementMo16318square = this.f22127zs[0];
        boolean zMo16314isOne = eCFieldElementMo16318square.mo16314isOne();
        ECFieldElement eCFieldElementMo16318square2 = zMo16314isOne ? eCFieldElementMo16318square : eCFieldElementMo16318square.mo16318square();
        ECFieldElement eCFieldElementMo16310add = zMo16314isOne ? eCFieldElement2.mo16318square().mo16310add(eCFieldElement2) : eCFieldElement2.mo16310add(eCFieldElementMo16318square).multiply(eCFieldElement2);
        if (eCFieldElementMo16310add.mo16315isZero()) {
            return new SecT571K1Point(curve, eCFieldElementMo16310add, curve.m16299getB());
        }
        ECFieldElement eCFieldElementMo16318square3 = eCFieldElementMo16310add.mo16318square();
        ECFieldElement eCFieldElementMultiply = zMo16314isOne ? eCFieldElementMo16310add : eCFieldElementMo16310add.multiply(eCFieldElementMo16318square2);
        ECFieldElement eCFieldElementMo16318square4 = eCFieldElement2.mo16310add(eCFieldElement).mo16318square();
        if (!zMo16314isOne) {
            eCFieldElementMo16318square = eCFieldElementMo16318square2.mo16318square();
        }
        return new SecT571K1Point(curve, eCFieldElementMo16318square3, eCFieldElementMo16318square4.mo16310add(eCFieldElementMo16310add).mo16310add(eCFieldElementMo16318square2).multiply(eCFieldElementMo16318square4).mo16310add(eCFieldElementMo16318square).mo16310add(eCFieldElementMo16318square3).mo16310add(eCFieldElementMultiply), new ECFieldElement[]{eCFieldElementMultiply});
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
        ECFieldElement eCFieldElementMo16310add = eCFieldElementMo16318square2.mo16310add(eCFieldElement2.multiply(eCFieldElement3));
        ECFieldElement eCFieldElementMo16311addOne = rawYCoord.mo16311addOne();
        ECFieldElement eCFieldElementMultiplyPlusProduct = eCFieldElementMo16311addOne.multiply(eCFieldElementMo16318square3).mo16310add(eCFieldElementMo16318square2).multiplyPlusProduct(eCFieldElementMo16310add, eCFieldElementMo16318square, eCFieldElementMo16318square3);
        ECFieldElement eCFieldElementMultiply = rawXCoord.multiply(eCFieldElementMo16318square3);
        ECFieldElement eCFieldElementMo16318square4 = eCFieldElementMultiply.mo16310add(eCFieldElementMo16310add).mo16318square();
        if (eCFieldElementMo16318square4.mo16315isZero()) {
            return eCFieldElementMultiplyPlusProduct.mo16315isZero() ? abstractC5820ECPoint.mo16338twice() : curve.getInfinity();
        }
        if (eCFieldElementMultiplyPlusProduct.mo16315isZero()) {
            return new SecT571K1Point(curve, eCFieldElementMultiplyPlusProduct, curve.m16299getB());
        }
        ECFieldElement eCFieldElementMultiply2 = eCFieldElementMultiplyPlusProduct.mo16318square().multiply(eCFieldElementMultiply);
        ECFieldElement eCFieldElementMultiply3 = eCFieldElementMultiplyPlusProduct.multiply(eCFieldElementMo16318square4).multiply(eCFieldElementMo16318square3);
        return new SecT571K1Point(curve, eCFieldElementMultiply2, eCFieldElementMultiplyPlusProduct.mo16310add(eCFieldElementMo16318square4).mo16318square().multiplyPlusProduct(eCFieldElementMo16310add, eCFieldElementMo16311addOne, eCFieldElementMultiply3), new ECFieldElement[]{eCFieldElementMultiply3});
    }

    public SecT571K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
