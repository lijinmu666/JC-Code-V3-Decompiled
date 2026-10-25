package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;

/* loaded from: classes2.dex */
public class SecP224K1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP224K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.f22125x;
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.f22126y;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP224K1FieldElement secP224K1FieldElement4 = (SecP224K1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP224K1FieldElement secP224K1FieldElement5 = (SecP224K1FieldElement) this.f22127zs[0];
        SecP224K1FieldElement secP224K1FieldElement6 = (SecP224K1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create3 = AbstractC5873Nat224.m17041create();
        boolean zMo16314isOne = secP224K1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP224K1FieldElement3.f22247x;
            iArr2 = secP224K1FieldElement4.f22247x;
        } else {
            SecP224K1Field.m16484square(secP224K1FieldElement5.f22247x, iArrM17041create2);
            SecP224K1Field.multiply(iArrM17041create2, secP224K1FieldElement3.f22247x, iArrM17041create);
            SecP224K1Field.multiply(iArrM17041create2, secP224K1FieldElement5.f22247x, iArrM17041create2);
            SecP224K1Field.multiply(iArrM17041create2, secP224K1FieldElement4.f22247x, iArrM17041create2);
            iArr = iArrM17041create;
            iArr2 = iArrM17041create2;
        }
        boolean zMo16314isOne2 = secP224K1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP224K1FieldElement.f22247x;
            iArr4 = secP224K1FieldElement2.f22247x;
        } else {
            SecP224K1Field.m16484square(secP224K1FieldElement6.f22247x, iArrM17041create3);
            SecP224K1Field.multiply(iArrM17041create3, secP224K1FieldElement.f22247x, iArrCreateExt);
            SecP224K1Field.multiply(iArrM17041create3, secP224K1FieldElement6.f22247x, iArrM17041create3);
            SecP224K1Field.multiply(iArrM17041create3, secP224K1FieldElement2.f22247x, iArrM17041create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM17041create3;
        }
        int[] iArrM17041create4 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.subtract(iArr3, iArr, iArrM17041create4);
        SecP224K1Field.subtract(iArr4, iArr2, iArrM17041create);
        if (AbstractC5873Nat224.m17048isZero(iArrM17041create4)) {
            return AbstractC5873Nat224.m17048isZero(iArrM17041create) ? mo16338twice() : curve.getInfinity();
        }
        SecP224K1Field.m16484square(iArrM17041create4, iArrM17041create2);
        int[] iArrM17041create5 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.multiply(iArrM17041create2, iArrM17041create4, iArrM17041create5);
        SecP224K1Field.multiply(iArrM17041create2, iArr3, iArrM17041create2);
        SecP224K1Field.m16481negate(iArrM17041create5, iArrM17041create5);
        AbstractC5873Nat224.m17050mul(iArr4, iArrM17041create5, iArrCreateExt);
        SecP224K1Field.reduce32(AbstractC5873Nat224.addBothTo(iArrM17041create2, iArrM17041create2, iArrM17041create5), iArrM17041create5);
        SecP224K1FieldElement secP224K1FieldElement7 = new SecP224K1FieldElement(iArrM17041create3);
        SecP224K1Field.m16484square(iArrM17041create, secP224K1FieldElement7.f22247x);
        int[] iArr5 = secP224K1FieldElement7.f22247x;
        SecP224K1Field.subtract(iArr5, iArrM17041create5, iArr5);
        SecP224K1FieldElement secP224K1FieldElement8 = new SecP224K1FieldElement(iArrM17041create5);
        SecP224K1Field.subtract(iArrM17041create2, secP224K1FieldElement7.f22247x, secP224K1FieldElement8.f22247x);
        SecP224K1Field.multiplyAddToExt(secP224K1FieldElement8.f22247x, iArrM17041create, iArrCreateExt);
        SecP224K1Field.m16483reduce(iArrCreateExt, secP224K1FieldElement8.f22247x);
        SecP224K1FieldElement secP224K1FieldElement9 = new SecP224K1FieldElement(iArrM17041create4);
        if (!zMo16314isOne) {
            int[] iArr6 = secP224K1FieldElement9.f22247x;
            SecP224K1Field.multiply(iArr6, secP224K1FieldElement5.f22247x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP224K1FieldElement9.f22247x;
            SecP224K1Field.multiply(iArr7, secP224K1FieldElement6.f22247x, iArr7);
        }
        return new SecP224K1Point(curve, secP224K1FieldElement7, secP224K1FieldElement8, new ECFieldElement[]{secP224K1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP224K1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP224K1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.f22126y;
        if (secP224K1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.f22125x;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) this.f22127zs[0];
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16484square(secP224K1FieldElement.f22247x, iArrM17041create);
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16484square(iArrM17041create, iArrM17041create2);
        int[] iArrM17041create3 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16484square(secP224K1FieldElement2.f22247x, iArrM17041create3);
        SecP224K1Field.reduce32(AbstractC5873Nat224.addBothTo(iArrM17041create3, iArrM17041create3, iArrM17041create3), iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create, secP224K1FieldElement2.f22247x, iArrM17041create);
        SecP224K1Field.reduce32(AbstractC5869Nat.shiftUpBits(7, iArrM17041create, 2, 0), iArrM17041create);
        int[] iArrM17041create4 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.reduce32(AbstractC5869Nat.shiftUpBits(7, iArrM17041create2, 3, 0, iArrM17041create4), iArrM17041create4);
        SecP224K1FieldElement secP224K1FieldElement4 = new SecP224K1FieldElement(iArrM17041create2);
        SecP224K1Field.m16484square(iArrM17041create3, secP224K1FieldElement4.f22247x);
        int[] iArr = secP224K1FieldElement4.f22247x;
        SecP224K1Field.subtract(iArr, iArrM17041create, iArr);
        int[] iArr2 = secP224K1FieldElement4.f22247x;
        SecP224K1Field.subtract(iArr2, iArrM17041create, iArr2);
        SecP224K1FieldElement secP224K1FieldElement5 = new SecP224K1FieldElement(iArrM17041create);
        SecP224K1Field.subtract(iArrM17041create, secP224K1FieldElement4.f22247x, secP224K1FieldElement5.f22247x);
        int[] iArr3 = secP224K1FieldElement5.f22247x;
        SecP224K1Field.multiply(iArr3, iArrM17041create3, iArr3);
        int[] iArr4 = secP224K1FieldElement5.f22247x;
        SecP224K1Field.subtract(iArr4, iArrM17041create4, iArr4);
        SecP224K1FieldElement secP224K1FieldElement6 = new SecP224K1FieldElement(iArrM17041create3);
        SecP224K1Field.m16486twice(secP224K1FieldElement.f22247x, secP224K1FieldElement6.f22247x);
        if (!secP224K1FieldElement3.mo16314isOne()) {
            int[] iArr5 = secP224K1FieldElement6.f22247x;
            SecP224K1Field.multiply(iArr5, secP224K1FieldElement3.f22247x, iArr5);
        }
        return new SecP224K1Point(curve, secP224K1FieldElement4, secP224K1FieldElement5, new ECFieldElement[]{secP224K1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP224K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
