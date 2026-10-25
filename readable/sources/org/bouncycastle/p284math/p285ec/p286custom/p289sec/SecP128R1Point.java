package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5870Nat128;

/* loaded from: classes2.dex */
public class SecP128R1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP128R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.f22125x;
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.f22126y;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP128R1FieldElement secP128R1FieldElement4 = (SecP128R1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP128R1FieldElement secP128R1FieldElement5 = (SecP128R1FieldElement) this.f22127zs[0];
        SecP128R1FieldElement secP128R1FieldElement6 = (SecP128R1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5870Nat128.createExt();
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        int[] iArrM16964create2 = AbstractC5870Nat128.m16964create();
        int[] iArrM16964create3 = AbstractC5870Nat128.m16964create();
        boolean zMo16314isOne = secP128R1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP128R1FieldElement3.f22188x;
            iArr2 = secP128R1FieldElement4.f22188x;
        } else {
            SecP128R1Field.m16419square(secP128R1FieldElement5.f22188x, iArrM16964create2);
            SecP128R1Field.multiply(iArrM16964create2, secP128R1FieldElement3.f22188x, iArrM16964create);
            SecP128R1Field.multiply(iArrM16964create2, secP128R1FieldElement5.f22188x, iArrM16964create2);
            SecP128R1Field.multiply(iArrM16964create2, secP128R1FieldElement4.f22188x, iArrM16964create2);
            iArr = iArrM16964create;
            iArr2 = iArrM16964create2;
        }
        boolean zMo16314isOne2 = secP128R1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP128R1FieldElement.f22188x;
            iArr4 = secP128R1FieldElement2.f22188x;
        } else {
            SecP128R1Field.m16419square(secP128R1FieldElement6.f22188x, iArrM16964create3);
            SecP128R1Field.multiply(iArrM16964create3, secP128R1FieldElement.f22188x, iArrCreateExt);
            SecP128R1Field.multiply(iArrM16964create3, secP128R1FieldElement6.f22188x, iArrM16964create3);
            SecP128R1Field.multiply(iArrM16964create3, secP128R1FieldElement2.f22188x, iArrM16964create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM16964create3;
        }
        int[] iArrM16964create4 = AbstractC5870Nat128.m16964create();
        SecP128R1Field.subtract(iArr3, iArr, iArrM16964create4);
        SecP128R1Field.subtract(iArr4, iArr2, iArrM16964create);
        if (AbstractC5870Nat128.m16973isZero(iArrM16964create4)) {
            return AbstractC5870Nat128.m16973isZero(iArrM16964create) ? mo16338twice() : curve.getInfinity();
        }
        SecP128R1Field.m16419square(iArrM16964create4, iArrM16964create2);
        int[] iArrM16964create5 = AbstractC5870Nat128.m16964create();
        SecP128R1Field.multiply(iArrM16964create2, iArrM16964create4, iArrM16964create5);
        SecP128R1Field.multiply(iArrM16964create2, iArr3, iArrM16964create2);
        SecP128R1Field.m16416negate(iArrM16964create5, iArrM16964create5);
        AbstractC5870Nat128.m16975mul(iArr4, iArrM16964create5, iArrCreateExt);
        SecP128R1Field.reduce32(AbstractC5870Nat128.addBothTo(iArrM16964create2, iArrM16964create2, iArrM16964create5), iArrM16964create5);
        SecP128R1FieldElement secP128R1FieldElement7 = new SecP128R1FieldElement(iArrM16964create3);
        SecP128R1Field.m16419square(iArrM16964create, secP128R1FieldElement7.f22188x);
        int[] iArr5 = secP128R1FieldElement7.f22188x;
        SecP128R1Field.subtract(iArr5, iArrM16964create5, iArr5);
        SecP128R1FieldElement secP128R1FieldElement8 = new SecP128R1FieldElement(iArrM16964create5);
        SecP128R1Field.subtract(iArrM16964create2, secP128R1FieldElement7.f22188x, secP128R1FieldElement8.f22188x);
        SecP128R1Field.multiplyAddToExt(secP128R1FieldElement8.f22188x, iArrM16964create, iArrCreateExt);
        SecP128R1Field.m16418reduce(iArrCreateExt, secP128R1FieldElement8.f22188x);
        SecP128R1FieldElement secP128R1FieldElement9 = new SecP128R1FieldElement(iArrM16964create4);
        if (!zMo16314isOne) {
            int[] iArr6 = secP128R1FieldElement9.f22188x;
            SecP128R1Field.multiply(iArr6, secP128R1FieldElement5.f22188x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP128R1FieldElement9.f22188x;
            SecP128R1Field.multiply(iArr7, secP128R1FieldElement6.f22188x, iArr7);
        }
        return new SecP128R1Point(curve, secP128R1FieldElement7, secP128R1FieldElement8, new ECFieldElement[]{secP128R1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP128R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP128R1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.f22126y;
        if (secP128R1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.f22125x;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) this.f22127zs[0];
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        int[] iArrM16964create2 = AbstractC5870Nat128.m16964create();
        int[] iArrM16964create3 = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16419square(secP128R1FieldElement.f22188x, iArrM16964create3);
        int[] iArrM16964create4 = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16419square(iArrM16964create3, iArrM16964create4);
        boolean zMo16314isOne = secP128R1FieldElement3.mo16314isOne();
        int[] iArr = secP128R1FieldElement3.f22188x;
        if (!zMo16314isOne) {
            SecP128R1Field.m16419square(iArr, iArrM16964create2);
            iArr = iArrM16964create2;
        }
        SecP128R1Field.subtract(secP128R1FieldElement2.f22188x, iArr, iArrM16964create);
        SecP128R1Field.m16410add(secP128R1FieldElement2.f22188x, iArr, iArrM16964create2);
        SecP128R1Field.multiply(iArrM16964create2, iArrM16964create, iArrM16964create2);
        SecP128R1Field.reduce32(AbstractC5870Nat128.addBothTo(iArrM16964create2, iArrM16964create2, iArrM16964create2), iArrM16964create2);
        SecP128R1Field.multiply(iArrM16964create3, secP128R1FieldElement2.f22188x, iArrM16964create3);
        SecP128R1Field.reduce32(AbstractC5869Nat.shiftUpBits(4, iArrM16964create3, 2, 0), iArrM16964create3);
        SecP128R1Field.reduce32(AbstractC5869Nat.shiftUpBits(4, iArrM16964create4, 3, 0, iArrM16964create), iArrM16964create);
        SecP128R1FieldElement secP128R1FieldElement4 = new SecP128R1FieldElement(iArrM16964create4);
        SecP128R1Field.m16419square(iArrM16964create2, secP128R1FieldElement4.f22188x);
        int[] iArr2 = secP128R1FieldElement4.f22188x;
        SecP128R1Field.subtract(iArr2, iArrM16964create3, iArr2);
        int[] iArr3 = secP128R1FieldElement4.f22188x;
        SecP128R1Field.subtract(iArr3, iArrM16964create3, iArr3);
        SecP128R1FieldElement secP128R1FieldElement5 = new SecP128R1FieldElement(iArrM16964create3);
        SecP128R1Field.subtract(iArrM16964create3, secP128R1FieldElement4.f22188x, secP128R1FieldElement5.f22188x);
        int[] iArr4 = secP128R1FieldElement5.f22188x;
        SecP128R1Field.multiply(iArr4, iArrM16964create2, iArr4);
        int[] iArr5 = secP128R1FieldElement5.f22188x;
        SecP128R1Field.subtract(iArr5, iArrM16964create, iArr5);
        SecP128R1FieldElement secP128R1FieldElement6 = new SecP128R1FieldElement(iArrM16964create2);
        SecP128R1Field.m16421twice(secP128R1FieldElement.f22188x, secP128R1FieldElement6.f22188x);
        if (!zMo16314isOne) {
            int[] iArr6 = secP128R1FieldElement6.f22188x;
            SecP128R1Field.multiply(iArr6, secP128R1FieldElement3.f22188x, iArr6);
        }
        return new SecP128R1Point(curve, secP128R1FieldElement4, secP128R1FieldElement5, new ECFieldElement[]{secP128R1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP128R1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
