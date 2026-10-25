package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5871Nat160;

/* loaded from: classes2.dex */
public class SecP160K1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP160K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: add */
    public AbstractC5820ECPoint mo16330add(AbstractC5820ECPoint abstractC5820ECPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return abstractC5820ECPoint;
        }
        if (abstractC5820ECPoint.isInfinity()) {
            return this;
        }
        if (this == abstractC5820ECPoint) {
            return mo16338twice();
        }
        AbstractC5817ECCurve curve = getCurve();
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.f22125x;
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.f22126y;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) abstractC5820ECPoint.getXCoord();
        SecP160R2FieldElement secP160R2FieldElement4 = (SecP160R2FieldElement) abstractC5820ECPoint.getYCoord();
        SecP160R2FieldElement secP160R2FieldElement5 = (SecP160R2FieldElement) this.f22127zs[0];
        SecP160R2FieldElement secP160R2FieldElement6 = (SecP160R2FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5871Nat160.createExt();
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        int[] iArrM16989create2 = AbstractC5871Nat160.m16989create();
        int[] iArrM16989create3 = AbstractC5871Nat160.m16989create();
        boolean zMo16314isOne = secP160R2FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP160R2FieldElement3.f22214x;
            iArr2 = secP160R2FieldElement4.f22214x;
        } else {
            SecP160R2Field.m16445square(secP160R2FieldElement5.f22214x, iArrM16989create2);
            SecP160R2Field.multiply(iArrM16989create2, secP160R2FieldElement3.f22214x, iArrM16989create);
            SecP160R2Field.multiply(iArrM16989create2, secP160R2FieldElement5.f22214x, iArrM16989create2);
            SecP160R2Field.multiply(iArrM16989create2, secP160R2FieldElement4.f22214x, iArrM16989create2);
            iArr = iArrM16989create;
            iArr2 = iArrM16989create2;
        }
        boolean zMo16314isOne2 = secP160R2FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP160R2FieldElement.f22214x;
            iArr4 = secP160R2FieldElement2.f22214x;
        } else {
            SecP160R2Field.m16445square(secP160R2FieldElement6.f22214x, iArrM16989create3);
            SecP160R2Field.multiply(iArrM16989create3, secP160R2FieldElement.f22214x, iArrCreateExt);
            SecP160R2Field.multiply(iArrM16989create3, secP160R2FieldElement6.f22214x, iArrM16989create3);
            SecP160R2Field.multiply(iArrM16989create3, secP160R2FieldElement2.f22214x, iArrM16989create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM16989create3;
        }
        int[] iArrM16989create4 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.subtract(iArr3, iArr, iArrM16989create4);
        SecP160R2Field.subtract(iArr4, iArr2, iArrM16989create);
        if (AbstractC5871Nat160.m16996isZero(iArrM16989create4)) {
            return AbstractC5871Nat160.m16996isZero(iArrM16989create) ? mo16338twice() : curve.getInfinity();
        }
        SecP160R2Field.m16445square(iArrM16989create4, iArrM16989create2);
        int[] iArrM16989create5 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.multiply(iArrM16989create2, iArrM16989create4, iArrM16989create5);
        SecP160R2Field.multiply(iArrM16989create2, iArr3, iArrM16989create2);
        SecP160R2Field.m16442negate(iArrM16989create5, iArrM16989create5);
        AbstractC5871Nat160.m16998mul(iArr4, iArrM16989create5, iArrCreateExt);
        SecP160R2Field.reduce32(AbstractC5871Nat160.addBothTo(iArrM16989create2, iArrM16989create2, iArrM16989create5), iArrM16989create5);
        SecP160R2FieldElement secP160R2FieldElement7 = new SecP160R2FieldElement(iArrM16989create3);
        SecP160R2Field.m16445square(iArrM16989create, secP160R2FieldElement7.f22214x);
        int[] iArr5 = secP160R2FieldElement7.f22214x;
        SecP160R2Field.subtract(iArr5, iArrM16989create5, iArr5);
        SecP160R2FieldElement secP160R2FieldElement8 = new SecP160R2FieldElement(iArrM16989create5);
        SecP160R2Field.subtract(iArrM16989create2, secP160R2FieldElement7.f22214x, secP160R2FieldElement8.f22214x);
        SecP160R2Field.multiplyAddToExt(secP160R2FieldElement8.f22214x, iArrM16989create, iArrCreateExt);
        SecP160R2Field.m16444reduce(iArrCreateExt, secP160R2FieldElement8.f22214x);
        SecP160R2FieldElement secP160R2FieldElement9 = new SecP160R2FieldElement(iArrM16989create4);
        if (!zMo16314isOne) {
            int[] iArr6 = secP160R2FieldElement9.f22214x;
            SecP160R2Field.multiply(iArr6, secP160R2FieldElement5.f22214x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP160R2FieldElement9.f22214x;
            SecP160R2Field.multiply(iArr7, secP160R2FieldElement6.f22214x, iArr7);
        }
        return new SecP160K1Point(curve, secP160R2FieldElement7, secP160R2FieldElement8, new ECFieldElement[]{secP160R2FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP160K1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP160K1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint threeTimes() {
        return (isInfinity() || this.f22126y.mo16315isZero()) ? this : mo16338twice().mo16330add(this);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: twice */
    public AbstractC5820ECPoint mo16338twice() {
        if (isInfinity()) {
            return this;
        }
        AbstractC5817ECCurve curve = getCurve();
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.f22126y;
        if (secP160R2FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.f22125x;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) this.f22127zs[0];
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(secP160R2FieldElement.f22214x, iArrM16989create);
        int[] iArrM16989create2 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(iArrM16989create, iArrM16989create2);
        int[] iArrM16989create3 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(secP160R2FieldElement2.f22214x, iArrM16989create3);
        SecP160R2Field.reduce32(AbstractC5871Nat160.addBothTo(iArrM16989create3, iArrM16989create3, iArrM16989create3), iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create, secP160R2FieldElement2.f22214x, iArrM16989create);
        SecP160R2Field.reduce32(AbstractC5869Nat.shiftUpBits(5, iArrM16989create, 2, 0), iArrM16989create);
        int[] iArrM16989create4 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.reduce32(AbstractC5869Nat.shiftUpBits(5, iArrM16989create2, 3, 0, iArrM16989create4), iArrM16989create4);
        SecP160R2FieldElement secP160R2FieldElement4 = new SecP160R2FieldElement(iArrM16989create2);
        SecP160R2Field.m16445square(iArrM16989create3, secP160R2FieldElement4.f22214x);
        int[] iArr = secP160R2FieldElement4.f22214x;
        SecP160R2Field.subtract(iArr, iArrM16989create, iArr);
        int[] iArr2 = secP160R2FieldElement4.f22214x;
        SecP160R2Field.subtract(iArr2, iArrM16989create, iArr2);
        SecP160R2FieldElement secP160R2FieldElement5 = new SecP160R2FieldElement(iArrM16989create);
        SecP160R2Field.subtract(iArrM16989create, secP160R2FieldElement4.f22214x, secP160R2FieldElement5.f22214x);
        int[] iArr3 = secP160R2FieldElement5.f22214x;
        SecP160R2Field.multiply(iArr3, iArrM16989create3, iArr3);
        int[] iArr4 = secP160R2FieldElement5.f22214x;
        SecP160R2Field.subtract(iArr4, iArrM16989create4, iArr4);
        SecP160R2FieldElement secP160R2FieldElement6 = new SecP160R2FieldElement(iArrM16989create3);
        SecP160R2Field.m16447twice(secP160R2FieldElement.f22214x, secP160R2FieldElement6.f22214x);
        if (!secP160R2FieldElement3.mo16314isOne()) {
            int[] iArr5 = secP160R2FieldElement6.f22214x;
            SecP160R2Field.multiply(iArr5, secP160R2FieldElement3.f22214x, iArr5);
        }
        return new SecP160K1Point(curve, secP160R2FieldElement4, secP160R2FieldElement5, new ECFieldElement[]{secP160R2FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP160K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
