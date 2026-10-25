package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT163FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22315x;

    public SecT163FieldElement() {
        this.f22315x = AbstractC5872Nat192.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16614add(this.f22315x, ((SecT163FieldElement) eCFieldElement).f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16616addOne(this.f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16624equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT163FieldElement) {
            return AbstractC5872Nat192.m17017eq64(this.f22315x, ((SecT163FieldElement) obj).f22315x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT163Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 163;
    }

    /* renamed from: getK1 */
    public int m16625getK1() {
        return 3;
    }

    /* renamed from: getK2 */
    public int m16626getK2() {
        return 6;
    }

    /* renamed from: getK3 */
    public int m16627getK3() {
        return 7;
    }

    /* renamed from: getM */
    public int m16628getM() {
        return 163;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.halfTrace(this.f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22315x, 0, 3) ^ 163763;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16618invert(this.f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5872Nat192.m17022isOne64(this.f22315x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5872Nat192.isZero64(this.f22315x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.multiply(this.f22315x, ((SecT163FieldElement) eCFieldElement).f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22315x;
        long[] jArr2 = ((SecT163FieldElement) eCFieldElement).f22315x;
        long[] jArr3 = ((SecT163FieldElement) eCFieldElement2).f22315x;
        long[] jArr4 = ((SecT163FieldElement) eCFieldElement3).f22315x;
        long[] jArrCreateExt64 = AbstractC5872Nat192.createExt64();
        SecT163Field.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        SecT163Field.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16619reduce(jArrCreateExt64, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        return this;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16620sqrt(this.f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16621square(this.f22315x, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22315x;
        long[] jArr2 = ((SecT163FieldElement) eCFieldElement).f22315x;
        long[] jArr3 = ((SecT163FieldElement) eCFieldElement2).f22315x;
        long[] jArrCreateExt64 = AbstractC5872Nat192.createExt64();
        SecT163Field.squareAddToExt(jArr, jArrCreateExt64);
        SecT163Field.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16619reduce(jArrCreateExt64, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT163Field.m16622squareN(this.f22315x, i, jArrCreate64);
        return new SecT163FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22315x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5872Nat192.toBigInteger64(this.f22315x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT163Field.m16623trace(this.f22315x);
    }

    public SecT163FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f22315x = SecT163Field.fromBigInteger(bigInteger);
    }

    public SecT163FieldElement(long[] jArr) {
        this.f22315x = jArr;
    }
}
