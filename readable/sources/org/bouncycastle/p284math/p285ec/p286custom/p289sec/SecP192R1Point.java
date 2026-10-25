package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;

/* loaded from: classes2.dex */
public class SecP192R1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP192R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement) this.f22125x;
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement) this.f22126y;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP192R1FieldElement secP192R1FieldElement4 = (SecP192R1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP192R1FieldElement secP192R1FieldElement5 = (SecP192R1FieldElement) this.f22127zs[0];
        SecP192R1FieldElement secP192R1FieldElement6 = (SecP192R1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5872Nat192.createExt();
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
        int[] iArrM17014create3 = AbstractC5872Nat192.m17014create();
        boolean zMo16314isOne = secP192R1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP192R1FieldElement3.f22236x;
            iArr2 = secP192R1FieldElement4.f22236x;
        } else {
            SecP192R1Field.m16471square(secP192R1FieldElement5.f22236x, iArrM17014create2);
            SecP192R1Field.multiply(iArrM17014create2, secP192R1FieldElement3.f22236x, iArrM17014create);
            SecP192R1Field.multiply(iArrM17014create2, secP192R1FieldElement5.f22236x, iArrM17014create2);
            SecP192R1Field.multiply(iArrM17014create2, secP192R1FieldElement4.f22236x, iArrM17014create2);
            iArr = iArrM17014create;
            iArr2 = iArrM17014create2;
        }
        boolean zMo16314isOne2 = secP192R1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP192R1FieldElement.f22236x;
            iArr4 = secP192R1FieldElement2.f22236x;
        } else {
            SecP192R1Field.m16471square(secP192R1FieldElement6.f22236x, iArrM17014create3);
            SecP192R1Field.multiply(iArrM17014create3, secP192R1FieldElement.f22236x, iArrCreateExt);
            SecP192R1Field.multiply(iArrM17014create3, secP192R1FieldElement6.f22236x, iArrM17014create3);
            SecP192R1Field.multiply(iArrM17014create3, secP192R1FieldElement2.f22236x, iArrM17014create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM17014create3;
        }
        int[] iArrM17014create4 = AbstractC5872Nat192.m17014create();
        SecP192R1Field.subtract(iArr3, iArr, iArrM17014create4);
        SecP192R1Field.subtract(iArr4, iArr2, iArrM17014create);
        if (AbstractC5872Nat192.m17023isZero(iArrM17014create4)) {
            return AbstractC5872Nat192.m17023isZero(iArrM17014create) ? mo16338twice() : curve.getInfinity();
        }
        SecP192R1Field.m16471square(iArrM17014create4, iArrM17014create2);
        int[] iArrM17014create5 = AbstractC5872Nat192.m17014create();
        SecP192R1Field.multiply(iArrM17014create2, iArrM17014create4, iArrM17014create5);
        SecP192R1Field.multiply(iArrM17014create2, iArr3, iArrM17014create2);
        SecP192R1Field.m16468negate(iArrM17014create5, iArrM17014create5);
        AbstractC5872Nat192.m17025mul(iArr4, iArrM17014create5, iArrCreateExt);
        SecP192R1Field.reduce32(AbstractC5872Nat192.addBothTo(iArrM17014create2, iArrM17014create2, iArrM17014create5), iArrM17014create5);
        SecP192R1FieldElement secP192R1FieldElement7 = new SecP192R1FieldElement(iArrM17014create3);
        SecP192R1Field.m16471square(iArrM17014create, secP192R1FieldElement7.f22236x);
        int[] iArr5 = secP192R1FieldElement7.f22236x;
        SecP192R1Field.subtract(iArr5, iArrM17014create5, iArr5);
        SecP192R1FieldElement secP192R1FieldElement8 = new SecP192R1FieldElement(iArrM17014create5);
        SecP192R1Field.subtract(iArrM17014create2, secP192R1FieldElement7.f22236x, secP192R1FieldElement8.f22236x);
        SecP192R1Field.multiplyAddToExt(secP192R1FieldElement8.f22236x, iArrM17014create, iArrCreateExt);
        SecP192R1Field.m16470reduce(iArrCreateExt, secP192R1FieldElement8.f22236x);
        SecP192R1FieldElement secP192R1FieldElement9 = new SecP192R1FieldElement(iArrM17014create4);
        if (!zMo16314isOne) {
            int[] iArr6 = secP192R1FieldElement9.f22236x;
            SecP192R1Field.multiply(iArr6, secP192R1FieldElement5.f22236x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP192R1FieldElement9.f22236x;
            SecP192R1Field.multiply(iArr7, secP192R1FieldElement6.f22236x, iArr7);
        }
        return new SecP192R1Point(curve, secP192R1FieldElement7, secP192R1FieldElement8, new ECFieldElement[]{secP192R1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP192R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP192R1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement) this.f22126y;
        if (secP192R1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement) this.f22125x;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement) this.f22127zs[0];
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
        int[] iArrM17014create3 = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16471square(secP192R1FieldElement.f22236x, iArrM17014create3);
        int[] iArrM17014create4 = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16471square(iArrM17014create3, iArrM17014create4);
        boolean zMo16314isOne = secP192R1FieldElement3.mo16314isOne();
        int[] iArr = secP192R1FieldElement3.f22236x;
        if (!zMo16314isOne) {
            SecP192R1Field.m16471square(iArr, iArrM17014create2);
            iArr = iArrM17014create2;
        }
        SecP192R1Field.subtract(secP192R1FieldElement2.f22236x, iArr, iArrM17014create);
        SecP192R1Field.m16462add(secP192R1FieldElement2.f22236x, iArr, iArrM17014create2);
        SecP192R1Field.multiply(iArrM17014create2, iArrM17014create, iArrM17014create2);
        SecP192R1Field.reduce32(AbstractC5872Nat192.addBothTo(iArrM17014create2, iArrM17014create2, iArrM17014create2), iArrM17014create2);
        SecP192R1Field.multiply(iArrM17014create3, secP192R1FieldElement2.f22236x, iArrM17014create3);
        SecP192R1Field.reduce32(AbstractC5869Nat.shiftUpBits(6, iArrM17014create3, 2, 0), iArrM17014create3);
        SecP192R1Field.reduce32(AbstractC5869Nat.shiftUpBits(6, iArrM17014create4, 3, 0, iArrM17014create), iArrM17014create);
        SecP192R1FieldElement secP192R1FieldElement4 = new SecP192R1FieldElement(iArrM17014create4);
        SecP192R1Field.m16471square(iArrM17014create2, secP192R1FieldElement4.f22236x);
        int[] iArr2 = secP192R1FieldElement4.f22236x;
        SecP192R1Field.subtract(iArr2, iArrM17014create3, iArr2);
        int[] iArr3 = secP192R1FieldElement4.f22236x;
        SecP192R1Field.subtract(iArr3, iArrM17014create3, iArr3);
        SecP192R1FieldElement secP192R1FieldElement5 = new SecP192R1FieldElement(iArrM17014create3);
        SecP192R1Field.subtract(iArrM17014create3, secP192R1FieldElement4.f22236x, secP192R1FieldElement5.f22236x);
        int[] iArr4 = secP192R1FieldElement5.f22236x;
        SecP192R1Field.multiply(iArr4, iArrM17014create2, iArr4);
        int[] iArr5 = secP192R1FieldElement5.f22236x;
        SecP192R1Field.subtract(iArr5, iArrM17014create, iArr5);
        SecP192R1FieldElement secP192R1FieldElement6 = new SecP192R1FieldElement(iArrM17014create2);
        SecP192R1Field.m16473twice(secP192R1FieldElement.f22236x, secP192R1FieldElement6.f22236x);
        if (!zMo16314isOne) {
            int[] iArr6 = secP192R1FieldElement6.f22236x;
            SecP192R1Field.multiply(iArr6, secP192R1FieldElement3.f22236x, iArr6);
        }
        return new SecP192R1Point(curve, secP192R1FieldElement4, secP192R1FieldElement5, new ECFieldElement[]{secP192R1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP192R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
