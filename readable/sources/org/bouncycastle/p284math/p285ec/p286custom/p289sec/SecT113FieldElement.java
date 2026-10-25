package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5870Nat128;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT113FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22299x;

    public SecT113FieldElement() {
        this.f22299x = AbstractC5870Nat128.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16568add(this.f22299x, ((SecT113FieldElement) eCFieldElement).f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16570addOne(this.f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16578equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT113FieldElement) {
            return AbstractC5870Nat128.m16967eq64(this.f22299x, ((SecT113FieldElement) obj).f22299x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT113Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 113;
    }

    /* renamed from: getK1 */
    public int m16579getK1() {
        return 9;
    }

    /* renamed from: getK2 */
    public int m16580getK2() {
        return 0;
    }

    /* renamed from: getK3 */
    public int m16581getK3() {
        return 0;
    }

    /* renamed from: getM */
    public int m16582getM() {
        return 113;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.halfTrace(this.f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22299x, 0, 2) ^ 113009;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16572invert(this.f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5870Nat128.m16972isOne64(this.f22299x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5870Nat128.isZero64(this.f22299x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.multiply(this.f22299x, ((SecT113FieldElement) eCFieldElement).f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22299x;
        long[] jArr2 = ((SecT113FieldElement) eCFieldElement).f22299x;
        long[] jArr3 = ((SecT113FieldElement) eCFieldElement2).f22299x;
        long[] jArr4 = ((SecT113FieldElement) eCFieldElement3).f22299x;
        long[] jArrCreateExt64 = AbstractC5870Nat128.createExt64();
        SecT113Field.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        SecT113Field.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16573reduce(jArrCreateExt64, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        return this;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16574sqrt(this.f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16575square(this.f22299x, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22299x;
        long[] jArr2 = ((SecT113FieldElement) eCFieldElement).f22299x;
        long[] jArr3 = ((SecT113FieldElement) eCFieldElement2).f22299x;
        long[] jArrCreateExt64 = AbstractC5870Nat128.createExt64();
        SecT113Field.squareAddToExt(jArr, jArrCreateExt64);
        SecT113Field.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16573reduce(jArrCreateExt64, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5870Nat128.create64();
        SecT113Field.m16576squareN(this.f22299x, i, jArrCreate64);
        return new SecT113FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22299x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5870Nat128.toBigInteger64(this.f22299x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT113Field.m16577trace(this.f22299x);
    }

    public SecT113FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f22299x = SecT113Field.fromBigInteger(bigInteger);
    }

    public SecT113FieldElement(long[] jArr) {
        this.f22299x = jArr;
    }
}
