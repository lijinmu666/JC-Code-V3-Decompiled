package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT239FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22338x;

    public SecT239FieldElement() {
        this.f22338x = AbstractC5874Nat256.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16687add(this.f22338x, ((SecT239FieldElement) eCFieldElement).f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16689addOne(this.f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16697equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT239FieldElement) {
            return AbstractC5874Nat256.m17071eq64(this.f22338x, ((SecT239FieldElement) obj).f22338x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT239Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 239;
    }

    /* renamed from: getK1 */
    public int m16698getK1() {
        return 158;
    }

    /* renamed from: getK2 */
    public int m16699getK2() {
        return 0;
    }

    /* renamed from: getK3 */
    public int m16700getK3() {
        return 0;
    }

    /* renamed from: getM */
    public int m16701getM() {
        return 239;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.halfTrace(this.f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22338x, 0, 4) ^ 23900158;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16691invert(this.f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5874Nat256.m17076isOne64(this.f22338x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5874Nat256.isZero64(this.f22338x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.multiply(this.f22338x, ((SecT239FieldElement) eCFieldElement).f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22338x;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement).f22338x;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement2).f22338x;
        long[] jArr4 = ((SecT239FieldElement) eCFieldElement3).f22338x;
        long[] jArrCreateExt64 = AbstractC5874Nat256.createExt64();
        SecT239Field.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        SecT239Field.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16692reduce(jArrCreateExt64, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        return this;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16693sqrt(this.f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16694square(this.f22338x, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22338x;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement).f22338x;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement2).f22338x;
        long[] jArrCreateExt64 = AbstractC5874Nat256.createExt64();
        SecT239Field.squareAddToExt(jArr, jArrCreateExt64);
        SecT239Field.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16692reduce(jArrCreateExt64, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT239Field.m16695squareN(this.f22338x, i, jArrCreate64);
        return new SecT239FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22338x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5874Nat256.toBigInteger64(this.f22338x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT239Field.m16696trace(this.f22338x);
    }

    public SecT239FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f22338x = SecT239Field.fromBigInteger(bigInteger);
    }

    public SecT239FieldElement(long[] jArr) {
        this.f22338x = jArr;
    }
}
