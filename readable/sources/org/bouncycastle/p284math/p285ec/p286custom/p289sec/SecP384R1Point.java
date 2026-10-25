package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5876Nat384;

/* loaded from: classes2.dex */
public class SecP384R1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP384R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.f22125x;
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.f22126y;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP384R1FieldElement secP384R1FieldElement4 = (SecP384R1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP384R1FieldElement secP384R1FieldElement5 = (SecP384R1FieldElement) this.f22127zs[0];
        SecP384R1FieldElement secP384R1FieldElement6 = (SecP384R1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrM16904create = AbstractC5869Nat.m16904create(24);
        int[] iArrM16904create2 = AbstractC5869Nat.m16904create(24);
        int[] iArrM16904create3 = AbstractC5869Nat.m16904create(24);
        int i = 12;
        int[] iArrM16904create4 = AbstractC5869Nat.m16904create(12);
        int[] iArrM16904create5 = AbstractC5869Nat.m16904create(12);
        boolean zMo16314isOne = secP384R1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP384R1FieldElement3.f22289x;
            iArr2 = secP384R1FieldElement4.f22289x;
        } else {
            SecP384R1Field.m16545square(secP384R1FieldElement5.f22289x, iArrM16904create4, iArrM16904create);
            SecP384R1Field.multiply(iArrM16904create4, secP384R1FieldElement3.f22289x, iArrM16904create3, iArrM16904create);
            SecP384R1Field.multiply(iArrM16904create4, secP384R1FieldElement5.f22289x, iArrM16904create4, iArrM16904create);
            SecP384R1Field.multiply(iArrM16904create4, secP384R1FieldElement4.f22289x, iArrM16904create4, iArrM16904create);
            iArr = iArrM16904create3;
            iArr2 = iArrM16904create4;
        }
        boolean zMo16314isOne2 = secP384R1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP384R1FieldElement.f22289x;
            iArr4 = secP384R1FieldElement2.f22289x;
        } else {
            SecP384R1Field.m16545square(secP384R1FieldElement6.f22289x, iArrM16904create5, iArrM16904create);
            SecP384R1Field.multiply(iArrM16904create5, secP384R1FieldElement.f22289x, iArrM16904create2, iArrM16904create);
            SecP384R1Field.multiply(iArrM16904create5, secP384R1FieldElement6.f22289x, iArrM16904create5, iArrM16904create);
            SecP384R1Field.multiply(iArrM16904create5, secP384R1FieldElement2.f22289x, iArrM16904create5, iArrM16904create);
            iArr3 = iArrM16904create2;
            iArr4 = iArrM16904create5;
            i = 12;
        }
        int[] iArrM16904create6 = AbstractC5869Nat.m16904create(i);
        SecP384R1Field.subtract(iArr3, iArr, iArrM16904create6);
        int[] iArrM16904create7 = AbstractC5869Nat.m16904create(i);
        SecP384R1Field.subtract(iArr4, iArr2, iArrM16904create7);
        if (AbstractC5869Nat.m16927isZero(i, iArrM16904create6)) {
            return AbstractC5869Nat.m16927isZero(i, iArrM16904create7) ? mo16338twice() : curve.getInfinity();
        }
        SecP384R1Field.m16545square(iArrM16904create6, iArrM16904create4, iArrM16904create);
        int[] iArrM16904create8 = AbstractC5869Nat.m16904create(i);
        SecP384R1Field.multiply(iArrM16904create4, iArrM16904create6, iArrM16904create8, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create4, iArr3, iArrM16904create4, iArrM16904create);
        SecP384R1Field.m16541negate(iArrM16904create8, iArrM16904create8);
        AbstractC5876Nat384.m17095mul(iArr4, iArrM16904create8, iArrM16904create2);
        SecP384R1Field.reduce32(AbstractC5869Nat.addBothTo(i, iArrM16904create4, iArrM16904create4, iArrM16904create8), iArrM16904create8);
        SecP384R1FieldElement secP384R1FieldElement7 = new SecP384R1FieldElement(iArrM16904create5);
        SecP384R1Field.m16545square(iArrM16904create7, secP384R1FieldElement7.f22289x, iArrM16904create);
        int[] iArr5 = secP384R1FieldElement7.f22289x;
        SecP384R1Field.subtract(iArr5, iArrM16904create8, iArr5);
        SecP384R1FieldElement secP384R1FieldElement8 = new SecP384R1FieldElement(iArrM16904create8);
        SecP384R1Field.subtract(iArrM16904create4, secP384R1FieldElement7.f22289x, secP384R1FieldElement8.f22289x);
        AbstractC5876Nat384.m17095mul(secP384R1FieldElement8.f22289x, iArrM16904create7, iArrM16904create3);
        SecP384R1Field.m16536addExt(iArrM16904create2, iArrM16904create3, iArrM16904create2);
        SecP384R1Field.m16543reduce(iArrM16904create2, secP384R1FieldElement8.f22289x);
        SecP384R1FieldElement secP384R1FieldElement9 = new SecP384R1FieldElement(iArrM16904create6);
        if (!zMo16314isOne) {
            int[] iArr6 = secP384R1FieldElement9.f22289x;
            SecP384R1Field.multiply(iArr6, secP384R1FieldElement5.f22289x, iArr6, iArrM16904create);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP384R1FieldElement9.f22289x;
            SecP384R1Field.multiply(iArr7, secP384R1FieldElement6.f22289x, iArr7, iArrM16904create);
        }
        return new SecP384R1Point(curve, secP384R1FieldElement7, secP384R1FieldElement8, new ECFieldElement[]{secP384R1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP384R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP384R1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.f22126y;
        if (secP384R1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.f22125x;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) this.f22127zs[0];
        int[] iArrM16904create = AbstractC5869Nat.m16904create(24);
        int[] iArrM16904create2 = AbstractC5869Nat.m16904create(12);
        int[] iArrM16904create3 = AbstractC5869Nat.m16904create(12);
        int[] iArrM16904create4 = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16545square(secP384R1FieldElement.f22289x, iArrM16904create4, iArrM16904create);
        int[] iArrM16904create5 = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16545square(iArrM16904create4, iArrM16904create5, iArrM16904create);
        boolean zMo16314isOne = secP384R1FieldElement3.mo16314isOne();
        int[] iArr = secP384R1FieldElement3.f22289x;
        if (!zMo16314isOne) {
            SecP384R1Field.m16545square(iArr, iArrM16904create3, iArrM16904create);
            iArr = iArrM16904create3;
        }
        SecP384R1Field.subtract(secP384R1FieldElement2.f22289x, iArr, iArrM16904create2);
        SecP384R1Field.m16535add(secP384R1FieldElement2.f22289x, iArr, iArrM16904create3);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create2, iArrM16904create3, iArrM16904create);
        SecP384R1Field.reduce32(AbstractC5869Nat.addBothTo(12, iArrM16904create3, iArrM16904create3, iArrM16904create3), iArrM16904create3);
        SecP384R1Field.multiply(iArrM16904create4, secP384R1FieldElement2.f22289x, iArrM16904create4, iArrM16904create);
        SecP384R1Field.reduce32(AbstractC5869Nat.shiftUpBits(12, iArrM16904create4, 2, 0), iArrM16904create4);
        SecP384R1Field.reduce32(AbstractC5869Nat.shiftUpBits(12, iArrM16904create5, 3, 0, iArrM16904create2), iArrM16904create2);
        SecP384R1FieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(iArrM16904create5);
        SecP384R1Field.m16545square(iArrM16904create3, secP384R1FieldElement4.f22289x, iArrM16904create);
        int[] iArr2 = secP384R1FieldElement4.f22289x;
        SecP384R1Field.subtract(iArr2, iArrM16904create4, iArr2);
        int[] iArr3 = secP384R1FieldElement4.f22289x;
        SecP384R1Field.subtract(iArr3, iArrM16904create4, iArr3);
        SecP384R1FieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(iArrM16904create4);
        SecP384R1Field.subtract(iArrM16904create4, secP384R1FieldElement4.f22289x, secP384R1FieldElement5.f22289x);
        int[] iArr4 = secP384R1FieldElement5.f22289x;
        SecP384R1Field.multiply(iArr4, iArrM16904create3, iArr4, iArrM16904create);
        int[] iArr5 = secP384R1FieldElement5.f22289x;
        SecP384R1Field.subtract(iArr5, iArrM16904create2, iArr5);
        SecP384R1FieldElement secP384R1FieldElement6 = new SecP384R1FieldElement(iArrM16904create3);
        SecP384R1Field.m16548twice(secP384R1FieldElement.f22289x, secP384R1FieldElement6.f22289x);
        if (!zMo16314isOne) {
            int[] iArr6 = secP384R1FieldElement6.f22289x;
            SecP384R1Field.multiply(iArr6, secP384R1FieldElement3.f22289x, iArr6, iArrM16904create);
        }
        return new SecP384R1Point(curve, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP384R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
