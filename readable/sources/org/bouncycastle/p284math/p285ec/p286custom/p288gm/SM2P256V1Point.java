package org.bouncycastle.p284math.p285ec.p286custom.p288gm;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;

/* loaded from: classes2.dex */
public class SM2P256V1Point extends AbstractC5820ECPoint.AbstractFp {
    public SM2P256V1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        SM2P256V1FieldElement sM2P256V1FieldElement = (SM2P256V1FieldElement) this.f22125x;
        SM2P256V1FieldElement sM2P256V1FieldElement2 = (SM2P256V1FieldElement) this.f22126y;
        SM2P256V1FieldElement sM2P256V1FieldElement3 = (SM2P256V1FieldElement) abstractC5820ECPoint.getXCoord();
        SM2P256V1FieldElement sM2P256V1FieldElement4 = (SM2P256V1FieldElement) abstractC5820ECPoint.getYCoord();
        SM2P256V1FieldElement sM2P256V1FieldElement5 = (SM2P256V1FieldElement) this.f22127zs[0];
        SM2P256V1FieldElement sM2P256V1FieldElement6 = (SM2P256V1FieldElement) abstractC5820ECPoint.getZCoord(0);
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        boolean zMo16314isOne = sM2P256V1FieldElement5.mo16314isOne();
        if (zMo16314isOne) {
            iArr = sM2P256V1FieldElement3.f22177x;
            iArr2 = sM2P256V1FieldElement4.f22177x;
        } else {
            SM2P256V1Field.m16406square(sM2P256V1FieldElement5.f22177x, iArrM17068create2);
            SM2P256V1Field.multiply(iArrM17068create2, sM2P256V1FieldElement3.f22177x, iArrM17068create);
            SM2P256V1Field.multiply(iArrM17068create2, sM2P256V1FieldElement5.f22177x, iArrM17068create2);
            SM2P256V1Field.multiply(iArrM17068create2, sM2P256V1FieldElement4.f22177x, iArrM17068create2);
            iArr = iArrM17068create;
            iArr2 = iArrM17068create2;
        }
        boolean zMo16314isOne2 = sM2P256V1FieldElement6.mo16314isOne();
        if (zMo16314isOne2) {
            iArr3 = sM2P256V1FieldElement.f22177x;
            iArr4 = sM2P256V1FieldElement2.f22177x;
        } else {
            SM2P256V1Field.m16406square(sM2P256V1FieldElement6.f22177x, iArrM17068create3);
            SM2P256V1Field.multiply(iArrM17068create3, sM2P256V1FieldElement.f22177x, iArrCreateExt);
            SM2P256V1Field.multiply(iArrM17068create3, sM2P256V1FieldElement6.f22177x, iArrM17068create3);
            SM2P256V1Field.multiply(iArrM17068create3, sM2P256V1FieldElement2.f22177x, iArrM17068create3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrM17068create3;
        }
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.subtract(iArr3, iArr, iArrM17068create4);
        SM2P256V1Field.subtract(iArr4, iArr2, iArrM17068create);
        if (AbstractC5874Nat256.m17077isZero(iArrM17068create4)) {
            return AbstractC5874Nat256.m17077isZero(iArrM17068create) ? mo16338twice() : curve.getInfinity();
        }
        SM2P256V1Field.m16406square(iArrM17068create4, iArrM17068create2);
        int[] iArrM17068create5 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.multiply(iArrM17068create2, iArrM17068create4, iArrM17068create5);
        SM2P256V1Field.multiply(iArrM17068create2, iArr3, iArrM17068create2);
        SM2P256V1Field.m16403negate(iArrM17068create5, iArrM17068create5);
        AbstractC5874Nat256.m17079mul(iArr4, iArrM17068create5, iArrCreateExt);
        SM2P256V1Field.reduce32(AbstractC5874Nat256.addBothTo(iArrM17068create2, iArrM17068create2, iArrM17068create5), iArrM17068create5);
        SM2P256V1FieldElement sM2P256V1FieldElement7 = new SM2P256V1FieldElement(iArrM17068create3);
        SM2P256V1Field.m16406square(iArrM17068create, sM2P256V1FieldElement7.f22177x);
        int[] iArr5 = sM2P256V1FieldElement7.f22177x;
        SM2P256V1Field.subtract(iArr5, iArrM17068create5, iArr5);
        SM2P256V1FieldElement sM2P256V1FieldElement8 = new SM2P256V1FieldElement(iArrM17068create5);
        SM2P256V1Field.subtract(iArrM17068create2, sM2P256V1FieldElement7.f22177x, sM2P256V1FieldElement8.f22177x);
        SM2P256V1Field.multiplyAddToExt(sM2P256V1FieldElement8.f22177x, iArrM17068create, iArrCreateExt);
        SM2P256V1Field.m16405reduce(iArrCreateExt, sM2P256V1FieldElement8.f22177x);
        SM2P256V1FieldElement sM2P256V1FieldElement9 = new SM2P256V1FieldElement(iArrM17068create4);
        if (!zMo16314isOne) {
            int[] iArr6 = sM2P256V1FieldElement9.f22177x;
            SM2P256V1Field.multiply(iArr6, sM2P256V1FieldElement5.f22177x, iArr6);
        }
        if (!zMo16314isOne2) {
            int[] iArr7 = sM2P256V1FieldElement9.f22177x;
            SM2P256V1Field.multiply(iArr7, sM2P256V1FieldElement6.f22177x, iArr7);
        }
        return new SM2P256V1Point(curve, sM2P256V1FieldElement7, sM2P256V1FieldElement8, new ECFieldElement[]{sM2P256V1FieldElement9});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: detach */
    public AbstractC5820ECPoint mo16331detach() {
        return new SM2P256V1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    /* renamed from: negate */
    public AbstractC5820ECPoint mo16335negate() {
        return isInfinity() ? this : new SM2P256V1Point(this.f22124curve, this.f22125x, this.f22126y.mo16316negate(), this.f22127zs);
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
        SM2P256V1FieldElement sM2P256V1FieldElement = (SM2P256V1FieldElement) this.f22126y;
        if (sM2P256V1FieldElement.mo16315isZero()) {
            return curve.getInfinity();
        }
        SM2P256V1FieldElement sM2P256V1FieldElement2 = (SM2P256V1FieldElement) this.f22125x;
        SM2P256V1FieldElement sM2P256V1FieldElement3 = (SM2P256V1FieldElement) this.f22127zs[0];
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16406square(sM2P256V1FieldElement.f22177x, iArrM17068create3);
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16406square(iArrM17068create3, iArrM17068create4);
        boolean zMo16314isOne = sM2P256V1FieldElement3.mo16314isOne();
        int[] iArr = sM2P256V1FieldElement3.f22177x;
        if (!zMo16314isOne) {
            SM2P256V1Field.m16406square(iArr, iArrM17068create2);
            iArr = iArrM17068create2;
        }
        SM2P256V1Field.subtract(sM2P256V1FieldElement2.f22177x, iArr, iArrM17068create);
        SM2P256V1Field.m16397add(sM2P256V1FieldElement2.f22177x, iArr, iArrM17068create2);
        SM2P256V1Field.multiply(iArrM17068create2, iArrM17068create, iArrM17068create2);
        SM2P256V1Field.reduce32(AbstractC5874Nat256.addBothTo(iArrM17068create2, iArrM17068create2, iArrM17068create2), iArrM17068create2);
        SM2P256V1Field.multiply(iArrM17068create3, sM2P256V1FieldElement2.f22177x, iArrM17068create3);
        SM2P256V1Field.reduce32(AbstractC5869Nat.shiftUpBits(8, iArrM17068create3, 2, 0), iArrM17068create3);
        SM2P256V1Field.reduce32(AbstractC5869Nat.shiftUpBits(8, iArrM17068create4, 3, 0, iArrM17068create), iArrM17068create);
        SM2P256V1FieldElement sM2P256V1FieldElement4 = new SM2P256V1FieldElement(iArrM17068create4);
        SM2P256V1Field.m16406square(iArrM17068create2, sM2P256V1FieldElement4.f22177x);
        int[] iArr2 = sM2P256V1FieldElement4.f22177x;
        SM2P256V1Field.subtract(iArr2, iArrM17068create3, iArr2);
        int[] iArr3 = sM2P256V1FieldElement4.f22177x;
        SM2P256V1Field.subtract(iArr3, iArrM17068create3, iArr3);
        SM2P256V1FieldElement sM2P256V1FieldElement5 = new SM2P256V1FieldElement(iArrM17068create3);
        SM2P256V1Field.subtract(iArrM17068create3, sM2P256V1FieldElement4.f22177x, sM2P256V1FieldElement5.f22177x);
        int[] iArr4 = sM2P256V1FieldElement5.f22177x;
        SM2P256V1Field.multiply(iArr4, iArrM17068create2, iArr4);
        int[] iArr5 = sM2P256V1FieldElement5.f22177x;
        SM2P256V1Field.subtract(iArr5, iArrM17068create, iArr5);
        SM2P256V1FieldElement sM2P256V1FieldElement6 = new SM2P256V1FieldElement(iArrM17068create2);
        SM2P256V1Field.m16408twice(sM2P256V1FieldElement.f22177x, sM2P256V1FieldElement6.f22177x);
        if (!zMo16314isOne) {
            int[] iArr6 = sM2P256V1FieldElement6.f22177x;
            SM2P256V1Field.multiply(iArr6, sM2P256V1FieldElement3.f22177x, iArr6);
        }
        return new SM2P256V1Point(curve, sM2P256V1FieldElement4, sM2P256V1FieldElement5, new ECFieldElement[]{sM2P256V1FieldElement6});
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint
    public AbstractC5820ECPoint twicePlus(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this == abstractC5820ECPoint ? threeTimes() : isInfinity() ? abstractC5820ECPoint : abstractC5820ECPoint.isInfinity() ? mo16338twice() : this.f22126y.mo16315isZero() ? abstractC5820ECPoint : mo16338twice().mo16330add(abstractC5820ECPoint);
    }

    public SM2P256V1Point(AbstractC5817ECCurve abstractC5817ECCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(abstractC5817ECCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
