package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP384R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22288Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: x */
    protected int[] f22289x;

    public SecP384R1FieldElement() {
        this.f22289x = AbstractC5869Nat.m16904create(12);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16535add(this.f22289x, ((SecP384R1FieldElement) eCFieldElement).f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16537addOne(this.f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16539inv(((SecP384R1FieldElement) eCFieldElement).f22289x, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create, this.f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    /* renamed from: equals */
    public boolean m16549equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP384R1FieldElement) {
            return AbstractC5869Nat.m16914eq(12, this.f22289x, ((SecP384R1FieldElement) obj).f22289x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP384R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22288Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22289x, 0, 12) ^ f22288Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16539inv(this.f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5869Nat.m16926isOne(12, this.f22289x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5869Nat.m16927isZero(12, this.f22289x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.multiply(this.f22289x, ((SecP384R1FieldElement) eCFieldElement).f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16541negate(this.f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22289x;
        if (AbstractC5869Nat.m16927isZero(12, iArr) || AbstractC5869Nat.m16926isOne(12, iArr)) {
            return this;
        }
        int[] iArrM16904create = AbstractC5869Nat.m16904create(24);
        int[] iArrM16904create2 = AbstractC5869Nat.m16904create(12);
        int[] iArrM16904create3 = AbstractC5869Nat.m16904create(12);
        int[] iArrM16904create4 = AbstractC5869Nat.m16904create(12);
        int[] iArrM16904create5 = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16545square(iArr, iArrM16904create2, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create2, iArr, iArrM16904create2, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create2, 2, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create2, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16545square(iArrM16904create3, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArr, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 5, iArrM16904create4, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create4, iArrM16904create3, iArrM16904create4, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create4, 5, iArrM16904create5, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create5, iArrM16904create3, iArrM16904create5, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create5, 15, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create5, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 2, iArrM16904create4, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create2, iArrM16904create4, iArrM16904create2, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create4, 28, iArrM16904create4, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create4, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 60, iArrM16904create4, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create4, iArrM16904create3, iArrM16904create4, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create4, 120, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create4, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 15, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create5, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 33, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArrM16904create2, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 64, iArrM16904create3, iArrM16904create);
        SecP384R1Field.multiply(iArrM16904create3, iArr, iArrM16904create3, iArrM16904create);
        SecP384R1Field.m16547squareN(iArrM16904create3, 30, iArrM16904create2, iArrM16904create);
        SecP384R1Field.m16545square(iArrM16904create2, iArrM16904create3, iArrM16904create);
        if (AbstractC5869Nat.m16914eq(12, iArr, iArrM16904create3)) {
            return new SecP384R1FieldElement(iArrM16904create2);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.m16544square(this.f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(12);
        SecP384R1Field.subtract(this.f22289x, ((SecP384R1FieldElement) eCFieldElement).f22289x, iArrM16904create);
        return new SecP384R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5869Nat.m16919getBit(this.f22289x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5869Nat.toBigInteger(12, this.f22289x);
    }

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22288Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f22289x = SecP384R1Field.fromBigInteger(bigInteger);
    }

    public SecP384R1FieldElement(int[] iArr) {
        this.f22289x = iArr;
    }
}
