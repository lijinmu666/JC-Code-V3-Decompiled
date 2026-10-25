package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5877Nat448;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT409FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22351x;

    public SecT409FieldElement() {
        this.f22351x = AbstractC5877Nat448.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.m16729add(this.f22351x, ((SecT409FieldElement) eCFieldElement).f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.m16731addOne(this.f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16739equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT409FieldElement) {
            return AbstractC5877Nat448.m17099eq64(this.f22351x, ((SecT409FieldElement) obj).f22351x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT409Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 409;
    }

    /* renamed from: getK1 */
    public int m16740getK1() {
        return 87;
    }

    /* renamed from: getK2 */
    public int m16741getK2() {
        return 0;
    }

    /* renamed from: getK3 */
    public int m16742getK3() {
        return 0;
    }

    /* renamed from: getM */
    public int m16743getM() {
        return 409;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.halfTrace(this.f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22351x, 0, 7) ^ 4090087;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.m16733invert(this.f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5877Nat448.m17100isOne64(this.f22351x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5877Nat448.isZero64(this.f22351x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.multiply(this.f22351x, ((SecT409FieldElement) eCFieldElement).f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22351x;
        long[] jArr2 = ((SecT409FieldElement) eCFieldElement).f22351x;
        long[] jArr3 = ((SecT409FieldElement) eCFieldElement2).f22351x;
        long[] jArr4 = ((SecT409FieldElement) eCFieldElement3).f22351x;
        long[] jArrCreate64 = AbstractC5869Nat.create64(13);
        SecT409Field.multiplyAddToExt(jArr, jArr2, jArrCreate64);
        SecT409Field.multiplyAddToExt(jArr3, jArr4, jArrCreate64);
        long[] jArrCreate642 = AbstractC5877Nat448.create64();
        SecT409Field.m16734reduce(jArrCreate64, jArrCreate642);
        return new SecT409FieldElement(jArrCreate642);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        return this;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.m16735sqrt(this.f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.m16736square(this.f22351x, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22351x;
        long[] jArr2 = ((SecT409FieldElement) eCFieldElement).f22351x;
        long[] jArr3 = ((SecT409FieldElement) eCFieldElement2).f22351x;
        long[] jArrCreate64 = AbstractC5869Nat.create64(13);
        SecT409Field.squareAddToExt(jArr, jArrCreate64);
        SecT409Field.multiplyAddToExt(jArr2, jArr3, jArrCreate64);
        long[] jArrCreate642 = AbstractC5877Nat448.create64();
        SecT409Field.m16734reduce(jArrCreate64, jArrCreate642);
        return new SecT409FieldElement(jArrCreate642);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5877Nat448.create64();
        SecT409Field.m16737squareN(this.f22351x, i, jArrCreate64);
        return new SecT409FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22351x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5877Nat448.toBigInteger64(this.f22351x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT409Field.m16738trace(this.f22351x);
    }

    public SecT409FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f22351x = SecT409Field.fromBigInteger(bigInteger);
    }

    public SecT409FieldElement(long[] jArr) {
        this.f22351x = jArr;
    }
}
