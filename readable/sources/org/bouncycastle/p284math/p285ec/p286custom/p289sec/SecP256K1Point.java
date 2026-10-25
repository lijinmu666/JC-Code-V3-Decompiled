package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;

/* loaded from: classes2.dex */
public class SecP256K1Point extends AbstractC5820ECPoint.AbstractFp {
    public SecP256K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f22125x;
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f22126y;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) abstractC5820ECPoint.getXCoord();
        SecP256K1FieldElement secP256K1FieldElement4 = (SecP256K1FieldElement) abstractC5820ECPoint.getYCoord();
        SecP256K1FieldElement secP256K1FieldElement5 = (SecP256K1FieldElement) this.f22127zs[0];
        SecP256K1FieldElement secP256K1FieldElement6 = (SecP256K1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        int[] iArrCreateExt2 = AbstractC5874Nat256.createExt();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        boolean zMo16314isOne = secP256K1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = secP256K1FieldElement3.f22269x;
            iArr2 = secP256K1FieldElement4.f22269x;
        } else {
            SecP256K1Field.m16515square(secP256K1FieldElement5.f22269x, iArrM17068create2, iArrCreateExt);
            SecP256K1Field.multiply(iArrM17068create2, secP256K1FieldElement3.f22269x, iArrM17068create, iArrCreateExt);
            SecP256K1Field.multiply(iArrM17068create2, secP256K1FieldElement5.f22269x, iArrM17068create2, iArrCreateExt);
            SecP256K1Field.multiply(iArrM17068create2, secP256K1FieldElement4.f22269x, iArrM17068create2, iArrCreateExt);
            iArr = iArrM17068create;
            iArr2 = iArrM17068create2;
        }
        boolean zMo16314isOne2 = secP256K1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = secP256K1FieldElement.f22269x;
            iArr4 = secP256K1FieldElement2.f22269x;
        } else {
            SecP256K1Field.m16515square(secP256K1FieldElement6.f22269x, iArrM17068create3, iArrCreateExt);
            SecP256K1Field.multiply(iArrM17068create3, secP256K1FieldElement.f22269x, iArrCreateExt2, iArrCreateExt);
            SecP256K1Field.multiply(iArrM17068create3, secP256K1FieldElement6.f22269x, iArrM17068create3, iArrCreateExt);
            SecP256K1Field.multiply(iArrM17068create3, secP256K1FieldElement2.f22269x, iArrM17068create3, iArrCreateExt);
            iArr3 = iArrCreateExt2;
            iArr4 = iArrM17068create3;
        }
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.subtract(iArr3, iArr, iArrM17068create4);
        SecP256K1Field.subtract(iArr4, iArr2, iArrM17068create);
        if (AbstractC5874Nat256.m17077isZero(iArrM17068create4)) {
            return AbstractC5874Nat256.m17077isZero(iArrM17068create) ? mo16338twice() : curve.getInfinity();
        }
        SecP256K1Field.m16515square(iArrM17068create4, iArrM17068create2, iArrCreateExt);
        int[] iArrM17068create5 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.multiply(iArrM17068create2, iArrM17068create4, iArrM17068create5, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create2, iArr3, iArrM17068create2, iArrCreateExt);
        SecP256K1Field.m16511negate(iArrM17068create5, iArrM17068create5);
        AbstractC5874Nat256.m17079mul(iArr4, iArrM17068create5, iArrCreateExt2);
        SecP256K1Field.reduce32(AbstractC5874Nat256.addBothTo(iArrM17068create2, iArrM17068create2, iArrM17068create5), iArrM17068create5);
        SecP256K1FieldElement secP256K1FieldElement7 = new SecP256K1FieldElement(iArrM17068create3);
        SecP256K1Field.m16515square(iArrM17068create, secP256K1FieldElement7.f22269x, iArrCreateExt);
        int[] iArr5 = secP256K1FieldElement7.f22269x;
        SecP256K1Field.subtract(iArr5, iArrM17068create5, iArr5);
        SecP256K1FieldElement secP256K1FieldElement8 = new SecP256K1FieldElement(iArrM17068create5);
        SecP256K1Field.subtract(iArrM17068create2, secP256K1FieldElement7.f22269x, secP256K1FieldElement8.f22269x);
        SecP256K1Field.multiplyAddToExt(secP256K1FieldElement8.f22269x, iArrM17068create, iArrCreateExt2);
        SecP256K1Field.m16513reduce(iArrCreateExt2, secP256K1FieldElement8.f22269x);
        SecP256K1FieldElement secP256K1FieldElement9 = new SecP256K1FieldElement(iArrM17068create4);
        if (!zMo16314isOne) {
            int[] iArr6 = secP256K1FieldElement9.f22269x;
            SecP256K1Field.multiply(iArr6, secP256K1FieldElement5.f22269x, iArr6, iArrCreateExt);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = secP256K1FieldElement9.f22269x;
            SecP256K1Field.multiply(iArr7, secP256K1FieldElement6.f22269x, iArr7, iArrCreateExt);
        }
        return new SecP256K1Point(curve, secP256K1FieldElement7, secP256K1FieldElement8, new ECFieldElement[]{secP256K1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SecP256K1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SecP256K1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f22126y;
        if (secP256K1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f22125x;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) this.f22127zs[0];
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16515square(secP256K1FieldElement.f22269x, iArrM17068create, iArrCreateExt);
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16515square(iArrM17068create, iArrM17068create2, iArrCreateExt);
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16515square(secP256K1FieldElement2.f22269x, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.reduce32(AbstractC5874Nat256.addBothTo(iArrM17068create3, iArrM17068create3, iArrM17068create3), iArrM17068create3);
        SecP256K1Field.multiply(iArrM17068create, secP256K1FieldElement2.f22269x, iArrM17068create, iArrCreateExt);
        SecP256K1Field.reduce32(AbstractC5869Nat.shiftUpBits(8, iArrM17068create, 2, 0), iArrM17068create);
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.reduce32(AbstractC5869Nat.shiftUpBits(8, iArrM17068create2, 3, 0, iArrM17068create4), iArrM17068create4);
        SecP256K1FieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(iArrM17068create2);
        SecP256K1Field.m16515square(iArrM17068create3, secP256K1FieldElement4.f22269x, iArrCreateExt);
        int[] iArr = secP256K1FieldElement4.f22269x;
        SecP256K1Field.subtract(iArr, iArrM17068create, iArr);
        int[] iArr2 = secP256K1FieldElement4.f22269x;
        SecP256K1Field.subtract(iArr2, iArrM17068create, iArr2);
        SecP256K1FieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(iArrM17068create);
        SecP256K1Field.subtract(iArrM17068create, secP256K1FieldElement4.f22269x, secP256K1FieldElement5.f22269x);
        int[] iArr3 = secP256K1FieldElement5.f22269x;
        SecP256K1Field.multiply(iArr3, iArrM17068create3, iArr3, iArrCreateExt);
        int[] iArr4 = secP256K1FieldElement5.f22269x;
        SecP256K1Field.subtract(iArr4, iArrM17068create4, iArr4);
        SecP256K1FieldElement secP256K1FieldElement6 = new SecP256K1FieldElement(iArrM17068create3);
        SecP256K1Field.m16518twice(secP256K1FieldElement.f22269x, secP256K1FieldElement6.f22269x);
        if (!secP256K1FieldElement3.mo16314isOne()) {
            int[] iArr5 = secP256K1FieldElement6.f22269x;
            SecP256K1Field.multiply(iArr5, secP256K1FieldElement3.f22269x, iArr5, iArrCreateExt);
        }
        return new SecP256K1Point(curve, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SecP256K1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
