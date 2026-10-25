package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5871Nat160;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP160R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22202Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* renamed from: x */
    protected int[] f22203x;

    public SecP160R1FieldElement() {
        this.f22203x = AbstractC5871Nat160.m16989create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16423add(this.f22203x, ((SecP160R1FieldElement) eCFieldElement).f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16425addOne(this.f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16427inv(((SecP160R1FieldElement) eCFieldElement).f22203x, iArrM16989create);
        SecP160R1Field.multiply(iArrM16989create, this.f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    /* renamed from: equals */
    public boolean m16435equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP160R1FieldElement) {
            return AbstractC5871Nat160.m16991eq(this.f22203x, ((SecP160R1FieldElement) obj).f22203x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP160R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22202Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22203x, 0, 5) ^ f22202Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16427inv(this.f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5871Nat160.m16995isOne(this.f22203x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5871Nat160.m16996isZero(this.f22203x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.multiply(this.f22203x, ((SecP160R1FieldElement) eCFieldElement).f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16429negate(this.f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22203x;
        if (AbstractC5871Nat160.m16996isZero(iArr) || AbstractC5871Nat160.m16995isOne(iArr)) {
            return this;
        }
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16432square(iArr, iArrM16989create);
        SecP160R1Field.multiply(iArrM16989create, iArr, iArrM16989create);
        int[] iArrM16989create2 = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16433squareN(iArrM16989create, 2, iArrM16989create2);
        SecP160R1Field.multiply(iArrM16989create2, iArrM16989create, iArrM16989create2);
        SecP160R1Field.m16433squareN(iArrM16989create2, 4, iArrM16989create);
        SecP160R1Field.multiply(iArrM16989create, iArrM16989create2, iArrM16989create);
        SecP160R1Field.m16433squareN(iArrM16989create, 8, iArrM16989create2);
        SecP160R1Field.multiply(iArrM16989create2, iArrM16989create, iArrM16989create2);
        SecP160R1Field.m16433squareN(iArrM16989create2, 16, iArrM16989create);
        SecP160R1Field.multiply(iArrM16989create, iArrM16989create2, iArrM16989create);
        SecP160R1Field.m16433squareN(iArrM16989create, 32, iArrM16989create2);
        SecP160R1Field.multiply(iArrM16989create2, iArrM16989create, iArrM16989create2);
        SecP160R1Field.m16433squareN(iArrM16989create2, 64, iArrM16989create);
        SecP160R1Field.multiply(iArrM16989create, iArrM16989create2, iArrM16989create);
        SecP160R1Field.m16432square(iArrM16989create, iArrM16989create2);
        SecP160R1Field.multiply(iArrM16989create2, iArr, iArrM16989create2);
        SecP160R1Field.m16433squareN(iArrM16989create2, 29, iArrM16989create2);
        SecP160R1Field.m16432square(iArrM16989create2, iArrM16989create);
        if (AbstractC5871Nat160.m16991eq(iArr, iArrM16989create)) {
            return new SecP160R1FieldElement(iArrM16989create2);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.m16432square(this.f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R1Field.subtract(this.f22203x, ((SecP160R1FieldElement) eCFieldElement).f22203x, iArrM16989create);
        return new SecP160R1FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5871Nat160.m16992getBit(this.f22203x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5871Nat160.toBigInteger(this.f22203x);
    }

    public SecP160R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22202Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.f22203x = SecP160R1Field.fromBigInteger(bigInteger);
    }

    public SecP160R1FieldElement(int[] iArr) {
        this.f22203x = iArr;
    }
}
