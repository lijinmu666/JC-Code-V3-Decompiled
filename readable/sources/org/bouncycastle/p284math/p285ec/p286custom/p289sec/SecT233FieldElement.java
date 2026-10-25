package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT233FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22331x;

    public SecT233FieldElement() {
        this.f22331x = AbstractC5874Nat256.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16664add(this.f22331x, ((SecT233FieldElement) eCFieldElement).f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16666addOne(this.f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16674equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT233FieldElement) {
            return AbstractC5874Nat256.m17071eq64(this.f22331x, ((SecT233FieldElement) obj).f22331x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT233Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 233;
    }

    /* renamed from: getK1 */
    public int m16675getK1() {
        return 74;
    }

    /* renamed from: getK2 */
    public int m16676getK2() {
        return 0;
    }

    /* renamed from: getK3 */
    public int m16677getK3() {
        return 0;
    }

    /* renamed from: getM */
    public int m16678getM() {
        return 233;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.halfTrace(this.f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22331x, 0, 4) ^ 2330074;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16668invert(this.f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5874Nat256.m17076isOne64(this.f22331x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5874Nat256.isZero64(this.f22331x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.multiply(this.f22331x, ((SecT233FieldElement) eCFieldElement).f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22331x;
        long[] jArr2 = ((SecT233FieldElement) eCFieldElement).f22331x;
        long[] jArr3 = ((SecT233FieldElement) eCFieldElement2).f22331x;
        long[] jArr4 = ((SecT233FieldElement) eCFieldElement3).f22331x;
        long[] jArrCreateExt64 = AbstractC5874Nat256.createExt64();
        SecT233Field.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        SecT233Field.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16669reduce(jArrCreateExt64, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
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
        SecT233Field.m16670sqrt(this.f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16671square(this.f22331x, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22331x;
        long[] jArr2 = ((SecT233FieldElement) eCFieldElement).f22331x;
        long[] jArr3 = ((SecT233FieldElement) eCFieldElement2).f22331x;
        long[] jArrCreateExt64 = AbstractC5874Nat256.createExt64();
        SecT233Field.squareAddToExt(jArr, jArrCreateExt64);
        SecT233Field.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16669reduce(jArrCreateExt64, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5874Nat256.create64();
        SecT233Field.m16672squareN(this.f22331x, i, jArrCreate64);
        return new SecT233FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22331x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5874Nat256.toBigInteger64(this.f22331x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT233Field.m16673trace(this.f22331x);
    }

    public SecT233FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f22331x = SecT233Field.fromBigInteger(bigInteger);
    }

    public SecT233FieldElement(long[] jArr) {
        this.f22331x = jArr;
    }
}
