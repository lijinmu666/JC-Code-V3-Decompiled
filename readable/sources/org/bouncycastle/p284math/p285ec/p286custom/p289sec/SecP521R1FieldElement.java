package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP521R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22295Q = new BigInteger(1, C6255Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f22296x;

    public SecP521R1FieldElement() {
        this.f22296x = AbstractC5869Nat.m16904create(17);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16550add(this.f22296x, ((SecP521R1FieldElement) eCFieldElement).f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16551addOne(this.f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16553inv(((SecP521R1FieldElement) eCFieldElement).f22296x, iArrM16904create);
        SecP521R1Field.multiply(iArrM16904create, this.f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    /* renamed from: equals */
    public boolean m16563equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP521R1FieldElement) {
            return AbstractC5869Nat.m16914eq(17, this.f22296x, ((SecP521R1FieldElement) obj).f22296x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP521R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22295Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22296x, 0, 17) ^ f22295Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16553inv(this.f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5869Nat.m16926isOne(17, this.f22296x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5869Nat.m16927isZero(17, this.f22296x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.multiply(this.f22296x, ((SecP521R1FieldElement) eCFieldElement).f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16555negate(this.f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22296x;
        if (AbstractC5869Nat.m16927isZero(17, iArr) || AbstractC5869Nat.m16926isOne(17, iArr)) {
            return this;
        }
        int[] iArrM16904create = AbstractC5869Nat.m16904create(33);
        int[] iArrM16904create2 = AbstractC5869Nat.m16904create(17);
        int[] iArrM16904create3 = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16561squareN(iArr, 519, iArrM16904create2, iArrM16904create);
        SecP521R1Field.m16559square(iArrM16904create2, iArrM16904create3, iArrM16904create);
        if (AbstractC5869Nat.m16914eq(17, iArr, iArrM16904create3)) {
            return new SecP521R1FieldElement(iArrM16904create2);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16558square(this.f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.subtract(this.f22296x, ((SecP521R1FieldElement) eCFieldElement).f22296x, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5869Nat.m16919getBit(this.f22296x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5869Nat.toBigInteger(17, this.f22296x);
    }

    public SecP521R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22295Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f22296x = SecP521R1Field.fromBigInteger(bigInteger);
    }

    public SecP521R1FieldElement(int[] iArr) {
        this.f22296x = iArr;
    }
}
