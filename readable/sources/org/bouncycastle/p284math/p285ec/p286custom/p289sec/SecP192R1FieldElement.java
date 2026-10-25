package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP192R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22235Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f22236x;

    public SecP192R1FieldElement() {
        this.f22236x = AbstractC5872Nat192.m17014create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16462add(this.f22236x, ((SecP192R1FieldElement) eCFieldElement).f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16464addOne(this.f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16466inv(((SecP192R1FieldElement) eCFieldElement).f22236x, iArrM17014create);
        SecP192R1Field.multiply(iArrM17014create, this.f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    /* renamed from: equals */
    public boolean m16474equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP192R1FieldElement) {
            return AbstractC5872Nat192.m17016eq(this.f22236x, ((SecP192R1FieldElement) obj).f22236x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP192R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22235Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22236x, 0, 6) ^ f22235Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16466inv(this.f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5872Nat192.m17021isOne(this.f22236x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5872Nat192.m17023isZero(this.f22236x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.multiply(this.f22236x, ((SecP192R1FieldElement) eCFieldElement).f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16468negate(this.f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22236x;
        if (AbstractC5872Nat192.m17023isZero(iArr) || AbstractC5872Nat192.m17021isOne(iArr)) {
            return this;
        }
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16471square(iArr, iArrM17014create);
        SecP192R1Field.multiply(iArrM17014create, iArr, iArrM17014create);
        SecP192R1Field.m16472squareN(iArrM17014create, 2, iArrM17014create2);
        SecP192R1Field.multiply(iArrM17014create2, iArrM17014create, iArrM17014create2);
        SecP192R1Field.m16472squareN(iArrM17014create2, 4, iArrM17014create);
        SecP192R1Field.multiply(iArrM17014create, iArrM17014create2, iArrM17014create);
        SecP192R1Field.m16472squareN(iArrM17014create, 8, iArrM17014create2);
        SecP192R1Field.multiply(iArrM17014create2, iArrM17014create, iArrM17014create2);
        SecP192R1Field.m16472squareN(iArrM17014create2, 16, iArrM17014create);
        SecP192R1Field.multiply(iArrM17014create, iArrM17014create2, iArrM17014create);
        SecP192R1Field.m16472squareN(iArrM17014create, 32, iArrM17014create2);
        SecP192R1Field.multiply(iArrM17014create2, iArrM17014create, iArrM17014create2);
        SecP192R1Field.m16472squareN(iArrM17014create2, 64, iArrM17014create);
        SecP192R1Field.multiply(iArrM17014create, iArrM17014create2, iArrM17014create);
        SecP192R1Field.m16472squareN(iArrM17014create, 62, iArrM17014create);
        SecP192R1Field.m16471square(iArrM17014create, iArrM17014create2);
        if (AbstractC5872Nat192.m17016eq(iArr, iArrM17014create2)) {
            return new SecP192R1FieldElement(iArrM17014create);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.m16471square(this.f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192R1Field.subtract(this.f22236x, ((SecP192R1FieldElement) eCFieldElement).f22236x, iArrM17014create);
        return new SecP192R1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5872Nat192.m17018getBit(this.f22236x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5872Nat192.toBigInteger(this.f22236x);
    }

    public SecP192R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22235Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f22236x = SecP192R1Field.fromBigInteger(bigInteger);
    }

    public SecP192R1FieldElement(int[] iArr) {
        this.f22236x = iArr;
    }
}
