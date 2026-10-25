package org.bouncycastle.p284math.p285ec.p286custom.p287djb;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;

/* loaded from: classes2.dex */
public class Curve25519Point extends AbstractC5820ECPoint.AbstractFp {
    public Curve25519Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.f22125x;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.f22126y;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.f22127zs[0];
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement) abstractC5820ECPoint.getXCoord();
        Curve25519FieldElement curve25519FieldElement5 = (Curve25519FieldElement) abstractC5820ECPoint.getYCoord();
        Curve25519FieldElement curve25519FieldElement6 = (Curve25519FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        boolean zMo16314isOne = curve25519FieldElement3.mo16314isOne();
        if (zMo16314isOne) {
            iArr = curve25519FieldElement4.f22168x;
            iArr2 = curve25519FieldElement5.f22168x;
        } else {
            Curve25519Field.m16393square(curve25519FieldElement3.f22168x, iArrM17068create2);
            Curve25519Field.multiply(iArrM17068create2, curve25519FieldElement4.f22168x, iArrM17068create);
            Curve25519Field.multiply(iArrM17068create2, curve25519FieldElement3.f22168x, iArrM17068create2);
            Curve25519Field.multiply(iArrM17068create2, curve25519FieldElement5.f22168x, iArrM17068create2);
            iArr = iArrM17068create;
            iArr2 = iArrM17068create2;
        }
        boolean zMo16314isOne2 = curve25519FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = curve25519FieldElement.f22168x;
            iArr4 = curve25519FieldElement2.f22168x;
        } else {
            Curve25519Field.m16393square(curve25519FieldElement6.f22168x, iArrM17068create3);
            Curve25519Field.multiply(iArrM17068create3, curve25519FieldElement.f22168x, iArrCreateExt);
            Curve25519Field.multiply(iArrM17068create3, curve25519FieldElement6.f22168x, iArrM17068create3);
            Curve25519Field.multiply(iArrM17068create3, curve25519FieldElement2.f22168x, iArrM17068create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM17068create3;
        }
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        Curve25519Field.subtract(iArr3, iArr, iArrM17068create4);
        Curve25519Field.subtract(iArr4, iArr2, iArrM17068create);
        if (AbstractC5874Nat256.m17077isZero(iArrM17068create4)) {
            return AbstractC5874Nat256.m17077isZero(iArrM17068create) ? mo16338twice() : curve.getInfinity();
        }
        int[] iArrM17068create5 = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16393square(iArrM17068create4, iArrM17068create5);
        int[] iArrM17068create6 = AbstractC5874Nat256.m17068create();
        Curve25519Field.multiply(iArrM17068create5, iArrM17068create4, iArrM17068create6);
        Curve25519Field.multiply(iArrM17068create5, iArr3, iArrM17068create2);
        Curve25519Field.m16390negate(iArrM17068create6, iArrM17068create6);
        AbstractC5874Nat256.m17079mul(iArr4, iArrM17068create6, iArrCreateExt);
        Curve25519Field.reduce27(AbstractC5874Nat256.addBothTo(iArrM17068create2, iArrM17068create2, iArrM17068create6), iArrM17068create6);
        Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(iArrM17068create3);
        Curve25519Field.m16393square(iArrM17068create, curve25519FieldElement7.f22168x);
        int[] iArr5 = curve25519FieldElement7.f22168x;
        Curve25519Field.subtract(iArr5, iArrM17068create6, iArr5);
        Curve25519FieldElement curve25519FieldElement8 = new Curve25519FieldElement(iArrM17068create6);
        Curve25519Field.subtract(iArrM17068create2, curve25519FieldElement7.f22168x, curve25519FieldElement8.f22168x);
        Curve25519Field.multiplyAddToExt(curve25519FieldElement8.f22168x, iArrM17068create, iArrCreateExt);
        Curve25519Field.m16392reduce(iArrCreateExt, curve25519FieldElement8.f22168x);
        Curve25519FieldElement curve25519FieldElement9 = new Curve25519FieldElement(iArrM17068create4);
        if (!zMo16314isOne) {
            int[] iArr6 = curve25519FieldElement9.f22168x;
            Curve25519Field.multiply(iArr6, curve25519FieldElement3.f22168x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = curve25519FieldElement9.f22168x;
            Curve25519Field.multiply(iArr7, curve25519FieldElement6.f22168x, iArr7);
        }
        if (!zMo16314isOne || !zMo16314isOne2) {
            iArrM17068create5 = null;
        }
        return new Curve25519Point(curve, curve25519FieldElement7, curve25519FieldElement8, new ECFieldElement[]{curve25519FieldElement9, calculateJacobianModifiedW(curve25519FieldElement9, iArrM17068create5)});
    }

    public Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement curve25519FieldElement, int[] iArr) {
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) getCurve().m16298getA();
        if (curve25519FieldElement.mo16314isOne()) {
            return curve25519FieldElement2;
        }
        Curve25519FieldElement curve25519FieldElement3 = new Curve25519FieldElement();
        if (iArr == null) {
            iArr = curve25519FieldElement3.f22168x;
            Curve25519Field.m16393square(curve25519FieldElement.f22168x, iArr);
        }
        Curve25519Field.m16393square(iArr, curve25519FieldElement3.f22168x);
        int[] iArr2 = curve25519FieldElement3.f22168x;
        Curve25519Field.multiply(iArr2, curve25519FieldElement2.f22168x, iArr2);
        return curve25519FieldElement3;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new Curve25519Point(null, getAffineXCoord(), getAffineYCoord());
    }

    public Curve25519FieldElement getJacobianModifiedW() {
        ECFieldElement[] eCFieldElementArr = this.f22127zs;
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) eCFieldElementArr[1];
        if (curve25519FieldElement != null) {
            return curve25519FieldElement;
        }
        Curve25519FieldElement curve25519FieldElementCalculateJacobianModifiedW = calculateJacobianModifiedW((Curve25519FieldElement) eCFieldElementArr[0], null);
        eCFieldElementArr[1] = curve25519FieldElementCalculateJacobianModifiedW;
        return curve25519FieldElementCalculateJacobianModifiedW;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public ECFieldElement getZCoord(int i) {
        return i == 1 ? getJacobianModifiedW() : super.getZCoord(i);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new Curve25519Point(getCurve(), this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint threeTimes() {
        return (isInfinity() || this.f22126y.mo16315isZero()) ? this : twiceJacobianModified(false).mo16330add(this);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: twice */
    public AbstractC5820ECPoint mo16338twice() {
        if (isInfinity()) {
            return this;
        }
        return this.f22126y.mo16315isZero() ? getCurve().getInfinity() : twiceJacobianModified(true);
    }

    public Curve25519Point twiceJacobianModified(boolean z) {
        Curve25519FieldElement curve25519FieldElement;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.f22125x;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.f22126y;
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement) this.f22127zs[0];
        Curve25519FieldElement jacobianModifiedW = getJacobianModifiedW();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16393square(curve25519FieldElement2.f22168x, iArrM17068create);
        Curve25519Field.reduce27(AbstractC5874Nat256.addBothTo(iArrM17068create, iArrM17068create, iArrM17068create) + AbstractC5874Nat256.m17062addTo(jacobianModifiedW.f22168x, iArrM17068create), iArrM17068create);
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16395twice(curve25519FieldElement3.f22168x, iArrM17068create2);
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        Curve25519Field.multiply(iArrM17068create2, curve25519FieldElement3.f22168x, iArrM17068create3);
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        Curve25519Field.multiply(iArrM17068create3, curve25519FieldElement2.f22168x, iArrM17068create4);
        Curve25519Field.m16395twice(iArrM17068create4, iArrM17068create4);
        int[] iArrM17068create5 = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16393square(iArrM17068create3, iArrM17068create5);
        Curve25519Field.m16395twice(iArrM17068create5, iArrM17068create5);
        Curve25519FieldElement curve25519FieldElement5 = new Curve25519FieldElement(iArrM17068create3);
        Curve25519Field.m16393square(iArrM17068create, curve25519FieldElement5.f22168x);
        int[] iArr = curve25519FieldElement5.f22168x;
        Curve25519Field.subtract(iArr, iArrM17068create4, iArr);
        int[] iArr2 = curve25519FieldElement5.f22168x;
        Curve25519Field.subtract(iArr2, iArrM17068create4, iArr2);
        Curve25519FieldElement curve25519FieldElement6 = new Curve25519FieldElement(iArrM17068create4);
        Curve25519Field.subtract(iArrM17068create4, curve25519FieldElement5.f22168x, curve25519FieldElement6.f22168x);
        int[] iArr3 = curve25519FieldElement6.f22168x;
        Curve25519Field.multiply(iArr3, iArrM17068create, iArr3);
        int[] iArr4 = curve25519FieldElement6.f22168x;
        Curve25519Field.subtract(iArr4, iArrM17068create5, iArr4);
        Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(iArrM17068create2);
        if (!AbstractC5874Nat256.m17075isOne(curve25519FieldElement4.f22168x)) {
            int[] iArr5 = curve25519FieldElement7.f22168x;
            Curve25519Field.multiply(iArr5, curve25519FieldElement4.f22168x, iArr5);
        }
        if (z) {
            curve25519FieldElement = new Curve25519FieldElement(iArrM17068create5);
            int[] iArr6 = curve25519FieldElement.f22168x;
            Curve25519Field.multiply(iArr6, jacobianModifiedW.f22168x, iArr6);
            int[] iArr7 = curve25519FieldElement.f22168x;
            Curve25519Field.m16395twice(iArr7, iArr7);
        } else {
            curve25519FieldElement = null;
        }
        return new Curve25519Point(getCurve(), curve25519FieldElement5, curve25519FieldElement6, new ECFieldElement[]{curve25519FieldElement7, curve25519FieldElement});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : twiceJacobianModified(false).mo16330add(abstractC5820ECPoint);
    }

    public Curve25519Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
