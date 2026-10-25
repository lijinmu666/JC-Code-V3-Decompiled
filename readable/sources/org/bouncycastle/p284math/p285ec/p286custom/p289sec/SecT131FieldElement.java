package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT131FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22307x;

    public SecT131FieldElement() {
        this.f22307x = AbstractC5872Nat192.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.m16591add(this.f22307x, ((SecT131FieldElement) eCFieldElement).f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.m16593addOne(this.f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16601equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT131FieldElement) {
            return AbstractC5872Nat192.m17017eq64(this.f22307x, ((SecT131FieldElement) obj).f22307x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT131Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 131;
    }

    /* renamed from: getK1 */
    public int m16602getK1() {
        return 2;
    }

    /* renamed from: getK2 */
    public int m16603getK2() {
        return 3;
    }

    /* renamed from: getK3 */
    public int m16604getK3() {
        return 8;
    }

    /* renamed from: getM */
    public int m16605getM() {
        return 131;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.halfTrace(this.f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22307x, 0, 3) ^ 131832;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.m16595invert(this.f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5872Nat192.m17022isOne64(this.f22307x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5872Nat192.isZero64(this.f22307x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.multiply(this.f22307x, ((SecT131FieldElement) eCFieldElement).f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22307x;
        long[] jArr2 = ((SecT131FieldElement) eCFieldElement).f22307x;
        long[] jArr3 = ((SecT131FieldElement) eCFieldElement2).f22307x;
        long[] jArr4 = ((SecT131FieldElement) eCFieldElement3).f22307x;
        long[] jArrCreate64 = AbstractC5869Nat.create64(5);
        SecT131Field.multiplyAddToExt(jArr, jArr2, jArrCreate64);
        SecT131Field.multiplyAddToExt(jArr3, jArr4, jArrCreate64);
        long[] jArrCreate642 = AbstractC5872Nat192.create64();
        SecT131Field.m16596reduce(jArrCreate64, jArrCreate642);
        return new SecT131FieldElement(jArrCreate642);
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
        SecT131Field.m16597sqrt(this.f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.m16598square(this.f22307x, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22307x;
        long[] jArr2 = ((SecT131FieldElement) eCFieldElement).f22307x;
        long[] jArr3 = ((SecT131FieldElement) eCFieldElement2).f22307x;
        long[] jArrCreate64 = AbstractC5869Nat.create64(5);
        SecT131Field.squareAddToExt(jArr, jArrCreate64);
        SecT131Field.multiplyAddToExt(jArr2, jArr3, jArrCreate64);
        long[] jArrCreate642 = AbstractC5872Nat192.create64();
        SecT131Field.m16596reduce(jArrCreate64, jArrCreate642);
        return new SecT131FieldElement(jArrCreate642);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5872Nat192.create64();
        SecT131Field.m16599squareN(this.f22307x, i, jArrCreate64);
        return new SecT131FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22307x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5872Nat192.toBigInteger64(this.f22307x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT131Field.m16600trace(this.f22307x);
    }

    public SecT131FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f22307x = SecT131Field.fromBigInteger(bigInteger);
    }

    public SecT131FieldElement(long[] jArr) {
        this.f22307x = jArr;
    }
}
