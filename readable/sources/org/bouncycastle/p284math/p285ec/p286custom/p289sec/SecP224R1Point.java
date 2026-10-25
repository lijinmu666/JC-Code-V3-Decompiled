package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;

/* loaded from: classes2.dex */
public class SecP224R1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP224R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP224R1FieldElement secP224R1FieldElement = (SecP224R1FieldElement) this.f22125x;
        SecP224R1FieldElement secP224R1FieldElement2 = (SecP224R1FieldElement) this.f22126y;
        SecP224R1FieldElement secP224R1FieldElement3 = (SecP224R1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP224R1FieldElement secP224R1FieldElement4 = (SecP224R1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP224R1FieldElement secP224R1FieldElement5 = (SecP224R1FieldElement) this.f22127zs[0];
        SecP224R1FieldElement secP224R1FieldElement6 = (SecP224R1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5873Nat224.createExt();
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create3 = AbstractC5873Nat224.m17041create();
        boolean zMo16314isOne = secP224R1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP224R1FieldElement3.f22258x;
            iArr2 = secP224R1FieldElement4.f22258x;
        } else {
            SecP224R1Field.m16497square(secP224R1FieldElement5.f22258x, iArrM17041create2);
            SecP224R1Field.multiply(iArrM17041create2, secP224R1FieldElement3.f22258x, iArrM17041create);
            SecP224R1Field.multiply(iArrM17041create2, secP224R1FieldElement5.f22258x, iArrM17041create2);
            SecP224R1Field.multiply(iArrM17041create2, secP224R1FieldElement4.f22258x, iArrM17041create2);
            iArr = iArrM17041create;
            iArr2 = iArrM17041create2;
        }
        boolean zMo16314isOne2 = secP224R1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP224R1FieldElement.f22258x;
            iArr4 = secP224R1FieldElement2.f22258x;
        } else {
            SecP224R1Field.m16497square(secP224R1FieldElement6.f22258x, iArrM17041create3);
            SecP224R1Field.multiply(iArrM17041create3, secP224R1FieldElement.f22258x, iArrCreateExt);
            SecP224R1Field.multiply(iArrM17041create3, secP224R1FieldElement6.f22258x, iArrM17041create3);
            SecP224R1Field.multiply(iArrM17041create3, secP224R1FieldElement2.f22258x, iArrM17041create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM17041create3;
        }
        int[] iArrM17041create4 = AbstractC5873Nat224.m17041create();
        SecP224R1Field.subtract(iArr3, iArr, iArrM17041create4);
        SecP224R1Field.subtract(iArr4, iArr2, iArrM17041create);
        if (AbstractC5873Nat224.m17048isZero(iArrM17041create4)) {
            return AbstractC5873Nat224.m17048isZero(iArrM17041create) ? mo16338twice() : curve.getInfinity();
        }
        SecP224R1Field.m16497square(iArrM17041create4, iArrM17041create2);
        int[] iArrM17041create5 = AbstractC5873Nat224.m17041create();
        SecP224R1Field.multiply(iArrM17041create2, iArrM17041create4, iArrM17041create5);
        SecP224R1Field.multiply(iArrM17041create2, iArr3, iArrM17041create2);
        SecP224R1Field.m16494negate(iArrM17041create5, iArrM17041create5);
        AbstractC5873Nat224.m17050mul(iArr4, iArrM17041create5, iArrCreateExt);
        SecP224R1Field.reduce32(AbstractC5873Nat224.addBothTo(iArrM17041create2, iArrM17041create2, iArrM17041create5), iArrM17041create5);
        SecP224R1FieldElement secP224R1FieldElement7 = new SecP224R1FieldElement(iArrM17041create3);
        SecP224R1Field.m16497square(iArrM17041create, secP224R1FieldElement7.f22258x);
        int[] iArr5 = secP224R1FieldElement7.f22258x;
        SecP224R1Field.subtract(iArr5, iArrM17041create5, iArr5);
        SecP224R1FieldElement secP224R1FieldElement8 = new SecP224R1FieldElement(iArrM17041create5);
        SecP224R1Field.subtract(iArrM17041create2, secP224R1FieldElement7.f22258x, secP224R1FieldElement8.f22258x);
        SecP224R1Field.multiplyAddToExt(secP224R1FieldElement8.f22258x, iArrM17041create, iArrCreateExt);
        SecP224R1Field.m16496reduce(iArrCreateExt, secP224R1FieldElement8.f22258x);
        SecP224R1FieldElement secP224R1FieldElement9 = new SecP224R1FieldElement(iArrM17041create4);
        if (!zMo16314isOne) {
            int[] iArr6 = secP224R1FieldElement9.f22258x;
            SecP224R1Field.multiply(iArr6, secP224R1FieldElement5.f22258x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP224R1FieldElement9.f22258x;
            SecP224R1Field.multiply(iArr7, secP224R1FieldElement6.f22258x, iArr7);
        }
        return new SecP224R1Point(curve, secP224R1FieldElement7, secP224R1FieldElement8, new ECFieldElement[]{secP224R1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP224R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP224R1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SecP224R1FieldElement secP224R1FieldElement = (SecP224R1FieldElement) this.f22126y;
        if (secP224R1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP224R1FieldElement secP224R1FieldElement2 = (SecP224R1FieldElement) this.f22125x;
        SecP224R1FieldElement secP224R1FieldElement3 = (SecP224R1FieldElement) this.f22127zs[0];
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create3 = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16497square(secP224R1FieldElement.f22258x, iArrM17041create3);
        int[] iArrM17041create4 = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16497square(iArrM17041create3, iArrM17041create4);
        boolean zMo16314isOne = secP224R1FieldElement3.mo16314isOne();
        int[] iArr = secP224R1FieldElement3.f22258x;
        if (!zMo16314isOne) {
            SecP224R1Field.m16497square(iArr, iArrM17041create2);
            iArr = iArrM17041create2;
        }
        SecP224R1Field.subtract(secP224R1FieldElement2.f22258x, iArr, iArrM17041create);
        SecP224R1Field.m16488add(secP224R1FieldElement2.f22258x, iArr, iArrM17041create2);
        SecP224R1Field.multiply(iArrM17041create2, iArrM17041create, iArrM17041create2);
        SecP224R1Field.reduce32(AbstractC5873Nat224.addBothTo(iArrM17041create2, iArrM17041create2, iArrM17041create2), iArrM17041create2);
        SecP224R1Field.multiply(iArrM17041create3, secP224R1FieldElement2.f22258x, iArrM17041create3);
        SecP224R1Field.reduce32(AbstractC5869Nat.shiftUpBits(7, iArrM17041create3, 2, 0), iArrM17041create3);
        SecP224R1Field.reduce32(AbstractC5869Nat.shiftUpBits(7, iArrM17041create4, 3, 0, iArrM17041create), iArrM17041create);
        SecP224R1FieldElement secP224R1FieldElement4 = new SecP224R1FieldElement(iArrM17041create4);
        SecP224R1Field.m16497square(iArrM17041create2, secP224R1FieldElement4.f22258x);
        int[] iArr2 = secP224R1FieldElement4.f22258x;
        SecP224R1Field.subtract(iArr2, iArrM17041create3, iArr2);
        int[] iArr3 = secP224R1FieldElement4.f22258x;
        SecP224R1Field.subtract(iArr3, iArrM17041create3, iArr3);
        SecP224R1FieldElement secP224R1FieldElement5 = new SecP224R1FieldElement(iArrM17041create3);
        SecP224R1Field.subtract(iArrM17041create3, secP224R1FieldElement4.f22258x, secP224R1FieldElement5.f22258x);
        int[] iArr4 = secP224R1FieldElement5.f22258x;
        SecP224R1Field.multiply(iArr4, iArrM17041create2, iArr4);
        int[] iArr5 = secP224R1FieldElement5.f22258x;
        SecP224R1Field.subtract(iArr5, iArrM17041create, iArr5);
        SecP224R1FieldElement secP224R1FieldElement6 = new SecP224R1FieldElement(iArrM17041create2);
        SecP224R1Field.m16499twice(secP224R1FieldElement.f22258x, secP224R1FieldElement6.f22258x);
        if (!zMo16314isOne) {
            int[] iArr6 = secP224R1FieldElement6.f22258x;
            SecP224R1Field.multiply(iArr6, secP224R1FieldElement3.f22258x, iArr6);
        }
        return new SecP224R1Point(curve, secP224R1FieldElement4, secP224R1FieldElement5, new ECFieldElement[]{secP224R1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP224R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
