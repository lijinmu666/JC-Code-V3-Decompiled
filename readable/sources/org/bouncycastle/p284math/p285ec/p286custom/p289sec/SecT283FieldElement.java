package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5875Nat320;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecT283FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x */
    protected long[] f22344x;

    public SecT283FieldElement() {
        this.f22344x = AbstractC5875Nat320.create64();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.m16706add(this.f22344x, ((SecT283FieldElement) eCFieldElement).f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.m16708addOne(this.f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.mo16313invert());
    }

    /* renamed from: equals */
    public boolean m16716equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecT283FieldElement) {
            return AbstractC5875Nat320.m17093eq64(this.f22344x, ((SecT283FieldElement) obj).f22344x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecT283Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return 283;
    }

    /* renamed from: getK1 */
    public int m16717getK1() {
        return 5;
    }

    /* renamed from: getK2 */
    public int m16718getK2() {
        return 7;
    }

    /* renamed from: getK3 */
    public int m16719getK3() {
        return 12;
    }

    /* renamed from: getM */
    public int m16720getM() {
        return 283;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.halfTrace(this.f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22344x, 0, 5) ^ 2831275;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.m16710invert(this.f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5875Nat320.m17094isOne64(this.f22344x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5875Nat320.isZero64(this.f22344x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.multiply(this.f22344x, ((SecT283FieldElement) eCFieldElement).f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f22344x;
        long[] jArr2 = ((SecT283FieldElement) eCFieldElement).f22344x;
        long[] jArr3 = ((SecT283FieldElement) eCFieldElement2).f22344x;
        long[] jArr4 = ((SecT283FieldElement) eCFieldElement3).f22344x;
        long[] jArrCreate64 = AbstractC5869Nat.create64(9);
        SecT283Field.multiplyAddToExt(jArr, jArr2, jArrCreate64);
        SecT283Field.multiplyAddToExt(jArr3, jArr4, jArrCreate64);
        long[] jArrCreate642 = AbstractC5875Nat320.create64();
        SecT283Field.m16711reduce(jArrCreate64, jArrCreate642);
        return new SecT283FieldElement(jArrCreate642);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        return this;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.m16712sqrt(this.f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.m16713square(this.f22344x, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f22344x;
        long[] jArr2 = ((SecT283FieldElement) eCFieldElement).f22344x;
        long[] jArr3 = ((SecT283FieldElement) eCFieldElement2).f22344x;
        long[] jArrCreate64 = AbstractC5869Nat.create64(9);
        SecT283Field.squareAddToExt(jArr, jArrCreate64);
        SecT283Field.multiplyAddToExt(jArr2, jArr3, jArrCreate64);
        long[] jArrCreate642 = AbstractC5875Nat320.create64();
        SecT283Field.m16711reduce(jArrCreate64, jArrCreate642);
        return new SecT283FieldElement(jArrCreate642);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArrCreate64 = AbstractC5875Nat320.create64();
        SecT283Field.m16714squareN(this.f22344x, i, jArrCreate64);
        return new SecT283FieldElement(jArrCreate64);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return mo16310add(eCFieldElement);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return (this.f22344x[0] & 1) != 0;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5875Nat320.toBigInteger64(this.f22344x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    /* renamed from: trace */
    public int mo16319trace() {
        return SecT283Field.m16715trace(this.f22344x);
    }

    public SecT283FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f22344x = SecT283Field.fromBigInteger(bigInteger);
    }

    public SecT283FieldElement(long[] jArr) {
        this.f22344x = jArr;
    }
}
