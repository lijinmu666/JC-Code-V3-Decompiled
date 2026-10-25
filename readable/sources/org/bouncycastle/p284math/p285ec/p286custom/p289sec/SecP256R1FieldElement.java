package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP256R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22277Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f22278x;

    public SecP256R1FieldElement() {
        this.f22278x = AbstractC5874Nat256.m17068create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16520add(this.f22278x, ((SecP256R1FieldElement) eCFieldElement).f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16522addOne(this.f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16524inv(((SecP256R1FieldElement) eCFieldElement).f22278x, iArrM17068create);
        SecP256R1Field.multiply(iArrM17068create, this.f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    /* renamed from: equals */
    public boolean m16534equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP256R1FieldElement) {
            return AbstractC5874Nat256.m17070eq(this.f22278x, ((SecP256R1FieldElement) obj).f22278x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP256R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22277Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22278x, 0, 8) ^ f22277Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16524inv(this.f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5874Nat256.m17075isOne(this.f22278x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5874Nat256.m17077isZero(this.f22278x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.multiply(this.f22278x, ((SecP256R1FieldElement) eCFieldElement).f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16526negate(this.f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22278x;
        if (AbstractC5874Nat256.m17077isZero(iArr) || AbstractC5874Nat256.m17075isOne(iArr)) {
            return this;
        }
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16530square(iArr, iArrM17068create, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create, iArr, iArrM17068create, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create, 2, iArrM17068create2, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create2, iArrM17068create, iArrM17068create2, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create2, 4, iArrM17068create, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create, iArrM17068create2, iArrM17068create, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create, 8, iArrM17068create2, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create2, iArrM17068create, iArrM17068create2, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create2, 16, iArrM17068create, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create, iArrM17068create2, iArrM17068create, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create, 32, iArrM17068create, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create, iArr, iArrM17068create, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create, 96, iArrM17068create, iArrCreateExt);
        SecP256R1Field.multiply(iArrM17068create, iArr, iArrM17068create, iArrCreateExt);
        SecP256R1Field.m16532squareN(iArrM17068create, 94, iArrM17068create, iArrCreateExt);
        SecP256R1Field.m16530square(iArrM17068create, iArrM17068create2, iArrCreateExt);
        if (AbstractC5874Nat256.m17070eq(iArr, iArrM17068create2)) {
            return new SecP256R1FieldElement(iArrM17068create);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.m16529square(this.f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256R1Field.subtract(this.f22278x, ((SecP256R1FieldElement) eCFieldElement).f22278x, iArrM17068create);
        return new SecP256R1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5874Nat256.m17072getBit(this.f22278x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5874Nat256.toBigInteger(this.f22278x);
    }

    public SecP256R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22277Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f22278x = SecP256R1Field.fromBigInteger(bigInteger);
    }

    public SecP256R1FieldElement(int[] iArr) {
        this.f22278x = iArr;
    }
}
