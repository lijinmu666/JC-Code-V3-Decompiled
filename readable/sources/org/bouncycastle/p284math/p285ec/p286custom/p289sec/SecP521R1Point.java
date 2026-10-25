package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;

/* loaded from: classes2.dex */
public class SecP521R1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP521R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) this.f22125x;
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) this.f22126y;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP521R1FieldElement secP521R1FieldElement4 = (SecP521R1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP521R1FieldElement secP521R1FieldElement5 = (SecP521R1FieldElement) this.f22127zs[0];
        SecP521R1FieldElement secP521R1FieldElement6 = (SecP521R1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrM16904create = AbstractC5869Nat.m16904create(33);
        int i = 17;
        int[] iArrM16904create2 = AbstractC5869Nat.m16904create(17);
        int[] iArrM16904create3 = AbstractC5869Nat.m16904create(17);
        int[] iArrM16904create4 = AbstractC5869Nat.m16904create(17);
        int[] iArrM16904create5 = AbstractC5869Nat.m16904create(17);
        boolean zMo16314isOne = secP521R1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP521R1FieldElement3.f22296x;
            iArr2 = secP521R1FieldElement4.f22296x;
        } else {
            SecP521R1Field.m16559square(secP521R1FieldElement5.f22296x, iArrM16904create4, iArrM16904create);
            SecP521R1Field.multiply(iArrM16904create4, secP521R1FieldElement3.f22296x, iArrM16904create3, iArrM16904create);
            SecP521R1Field.multiply(iArrM16904create4, secP521R1FieldElement5.f22296x, iArrM16904create4, iArrM16904create);
            SecP521R1Field.multiply(iArrM16904create4, secP521R1FieldElement4.f22296x, iArrM16904create4, iArrM16904create);
            iArr = iArrM16904create3;
            iArr2 = iArrM16904create4;
        }
        boolean zMo16314isOne2 = secP521R1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP521R1FieldElement.f22296x;
            iArr4 = secP521R1FieldElement2.f22296x;
        } else {
            SecP521R1Field.m16559square(secP521R1FieldElement6.f22296x, iArrM16904create5, iArrM16904create);
            SecP521R1Field.multiply(iArrM16904create5, secP521R1FieldElement.f22296x, iArrM16904create2, iArrM16904create);
            SecP521R1Field.multiply(iArrM16904create5, secP521R1FieldElement6.f22296x, iArrM16904create5, iArrM16904create);
            SecP521R1Field.multiply(iArrM16904create5, secP521R1FieldElement2.f22296x, iArrM16904create5, iArrM16904create);
            iArr3 = iArrM16904create2;
            iArr4 = iArrM16904create5;
            i = 17;
        }
        int[] iArrM16904create6 = AbstractC5869Nat.m16904create(i);
        SecP521R1Field.subtract(iArr3, iArr, iArrM16904create6);
        SecP521R1Field.subtract(iArr4, iArr2, iArrM16904create3);
        if (AbstractC5869Nat.m16927isZero(i, iArrM16904create6)) {
            return AbstractC5869Nat.m16927isZero(i, iArrM16904create3) ? mo16338twice() : curve.getInfinity();
        }
        SecP521R1Field.m16559square(iArrM16904create6, iArrM16904create4, iArrM16904create);
        int[] iArrM16904create7 = AbstractC5869Nat.m16904create(i);
        SecP521R1Field.multiply(iArrM16904create4, iArrM16904create6, iArrM16904create7, iArrM16904create);
        SecP521R1Field.multiply(iArrM16904create4, iArr3, iArrM16904create4, iArrM16904create);
        SecP521R1Field.multiply(iArr4, iArrM16904create7, iArrM16904create2, iArrM16904create);
        SecP521R1FieldElement secP521R1FieldElement7 = new SecP521R1FieldElement(iArrM16904create5);
        SecP521R1Field.m16559square(iArrM16904create3, secP521R1FieldElement7.f22296x, iArrM16904create);
        int[] iArr5 = secP521R1FieldElement7.f22296x;
        SecP521R1Field.m16550add(iArr5, iArrM16904create7, iArr5);
        int[] iArr6 = secP521R1FieldElement7.f22296x;
        SecP521R1Field.subtract(iArr6, iArrM16904create4, iArr6);
        int[] iArr7 = secP521R1FieldElement7.f22296x;
        SecP521R1Field.subtract(iArr7, iArrM16904create4, iArr7);
        SecP521R1FieldElement secP521R1FieldElement8 = new SecP521R1FieldElement(iArrM16904create7);
        SecP521R1Field.subtract(iArrM16904create4, secP521R1FieldElement7.f22296x, secP521R1FieldElement8.f22296x);
        SecP521R1Field.multiply(secP521R1FieldElement8.f22296x, iArrM16904create3, iArrM16904create3, iArrM16904create);
        SecP521R1Field.subtract(iArrM16904create3, iArrM16904create2, secP521R1FieldElement8.f22296x);
        SecP521R1FieldElement secP521R1FieldElement9 = new SecP521R1FieldElement(iArrM16904create6);
        if (!zMo16314isOne) {
            int[] iArr8 = secP521R1FieldElement9.f22296x;
            SecP521R1Field.multiply(iArr8, secP521R1FieldElement5.f22296x, iArr8, iArrM16904create);
        }
        if (!zMo16314isOne2) {
            int[] iArr9 = secP521R1FieldElement9.f22296x;
            SecP521R1Field.multiply(iArr9, secP521R1FieldElement6.f22296x, iArr9, iArrM16904create);
        }
        return new SecP521R1Point(curve, secP521R1FieldElement7, secP521R1FieldElement8, new ECFieldElement[]{secP521R1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP521R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
        return eCFieldElement.mo16310add(eCFieldElement2).mo16318square().subtract(eCFieldElement3).subtract(eCFieldElement4);
    }

    /* renamed from: eight */
    public ECFieldElement m16564eight(ECFieldElement eCFieldElement) {
        return m16565four(m16567two(eCFieldElement));
    }

    /* renamed from: four */
    public ECFieldElement m16565four(ECFieldElement eCFieldElement) {
        return m16567two(m16567two(eCFieldElement));
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP521R1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
    }

    /* renamed from: three */
    public ECFieldElement m16566three(ECFieldElement eCFieldElement) {
        return m16567two(eCFieldElement).mo16310add(eCFieldElement);
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
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) this.f22126y;
        if (secP521R1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) this.f22125x;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) this.f22127zs[0];
        int[] iArrM16904create = AbstractC5869Nat.m16904create(33);
        int[] iArrM16904create2 = AbstractC5869Nat.m16904create(17);
        int[] iArrM16904create3 = AbstractC5869Nat.m16904create(17);
        int[] iArrM16904create4 = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16559square(secP521R1FieldElement.f22296x, iArrM16904create4, iArrM16904create);
        int[] iArrM16904create5 = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16559square(iArrM16904create4, iArrM16904create5, iArrM16904create);
        boolean zMo16314isOne = secP521R1FieldElement3.mo16314isOne();
        int[] iArr = secP521R1FieldElement3.f22296x;
        if (!zMo16314isOne) {
            SecP521R1Field.m16559square(iArr, iArrM16904create3, iArrM16904create);
            iArr = iArrM16904create3;
        }
        SecP521R1Field.subtract(secP521R1FieldElement2.f22296x, iArr, iArrM16904create2);
        SecP521R1Field.m16550add(secP521R1FieldElement2.f22296x, iArr, iArrM16904create3);
        SecP521R1Field.multiply(iArrM16904create3, iArrM16904create2, iArrM16904create3, iArrM16904create);
        AbstractC5869Nat.addBothTo(17, iArrM16904create3, iArrM16904create3, iArrM16904create3);
        SecP521R1Field.reduce23(iArrM16904create3);
        SecP521R1Field.multiply(iArrM16904create4, secP521R1FieldElement2.f22296x, iArrM16904create4, iArrM16904create);
        AbstractC5869Nat.shiftUpBits(17, iArrM16904create4, 2, 0);
        SecP521R1Field.reduce23(iArrM16904create4);
        AbstractC5869Nat.shiftUpBits(17, iArrM16904create5, 3, 0, iArrM16904create2);
        SecP521R1Field.reduce23(iArrM16904create2);
        SecP521R1FieldElement secP521R1FieldElement4 = new SecP521R1FieldElement(iArrM16904create5);
        SecP521R1Field.m16559square(iArrM16904create3, secP521R1FieldElement4.f22296x, iArrM16904create);
        int[] iArr2 = secP521R1FieldElement4.f22296x;
        SecP521R1Field.subtract(iArr2, iArrM16904create4, iArr2);
        int[] iArr3 = secP521R1FieldElement4.f22296x;
        SecP521R1Field.subtract(iArr3, iArrM16904create4, iArr3);
        SecP521R1FieldElement secP521R1FieldElement5 = new SecP521R1FieldElement(iArrM16904create4);
        SecP521R1Field.subtract(iArrM16904create4, secP521R1FieldElement4.f22296x, secP521R1FieldElement5.f22296x);
        int[] iArr4 = secP521R1FieldElement5.f22296x;
        SecP521R1Field.multiply(iArr4, iArrM16904create3, iArr4, iArrM16904create);
        int[] iArr5 = secP521R1FieldElement5.f22296x;
        SecP521R1Field.subtract(iArr5, iArrM16904create2, iArr5);
        SecP521R1FieldElement secP521R1FieldElement6 = new SecP521R1FieldElement(iArrM16904create3);
        SecP521R1Field.m16562twice(secP521R1FieldElement.f22296x, secP521R1FieldElement6.f22296x);
        if (!zMo16314isOne) {
            int[] iArr6 = secP521R1FieldElement6.f22296x;
            SecP521R1Field.multiply(iArr6, secP521R1FieldElement3.f22296x, iArr6, iArrM16904create);
        }
        return new SecP521R1Point(curve, secP521R1FieldElement4, secP521R1FieldElement5, new ECFieldElement[]{secP521R1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    /* renamed from: two */
    public ECFieldElement m16567two(ECFieldElement eCFieldElement) {
        return eCFieldElement.mo16310add(eCFieldElement);
    }

    public SecP521R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
