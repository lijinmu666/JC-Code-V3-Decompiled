package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP192K1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22224Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: x */
    protected int[] f22225x;

    public SecP192K1FieldElement() {
        this.f22225x = AbstractC5872Nat192.m17014create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16449add(this.f22225x, ((SecP192K1FieldElement) eCFieldElement).f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16451addOne(this.f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16453inv(((SecP192K1FieldElement) eCFieldElement).f22225x, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, this.f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    /* renamed from: equals */
    public boolean m16461equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP192K1FieldElement) {
            return AbstractC5872Nat192.m17016eq(this.f22225x, ((SecP192K1FieldElement) obj).f22225x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP192K1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22224Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22225x, 0, 6) ^ f22224Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16453inv(this.f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5872Nat192.m17021isOne(this.f22225x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5872Nat192.m17023isZero(this.f22225x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.multiply(this.f22225x, ((SecP192K1FieldElement) eCFieldElement).f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16455negate(this.f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22225x;
        if (AbstractC5872Nat192.m17023isZero(iArr) || AbstractC5872Nat192.m17021isOne(iArr)) {
            return this;
        }
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16458square(iArr, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArr, iArrM17014create);
        int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16458square(iArrM17014create, iArrM17014create2);
        SecP192K1Field.multiply(iArrM17014create2, iArr, iArrM17014create2);
        int[] iArrM17014create3 = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16459squareN(iArrM17014create2, 3, iArrM17014create3);
        SecP192K1Field.multiply(iArrM17014create3, iArrM17014create2, iArrM17014create3);
        SecP192K1Field.m16459squareN(iArrM17014create3, 2, iArrM17014create3);
        SecP192K1Field.multiply(iArrM17014create3, iArrM17014create, iArrM17014create3);
        SecP192K1Field.m16459squareN(iArrM17014create3, 8, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArrM17014create3, iArrM17014create);
        SecP192K1Field.m16459squareN(iArrM17014create, 3, iArrM17014create3);
        SecP192K1Field.multiply(iArrM17014create3, iArrM17014create2, iArrM17014create3);
        int[] iArrM17014create4 = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16459squareN(iArrM17014create3, 16, iArrM17014create4);
        SecP192K1Field.multiply(iArrM17014create4, iArrM17014create, iArrM17014create4);
        SecP192K1Field.m16459squareN(iArrM17014create4, 35, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArrM17014create4, iArrM17014create);
        SecP192K1Field.m16459squareN(iArrM17014create, 70, iArrM17014create4);
        SecP192K1Field.multiply(iArrM17014create4, iArrM17014create, iArrM17014create4);
        SecP192K1Field.m16459squareN(iArrM17014create4, 19, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArrM17014create3, iArrM17014create);
        SecP192K1Field.m16459squareN(iArrM17014create, 20, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArrM17014create3, iArrM17014create);
        SecP192K1Field.m16459squareN(iArrM17014create, 4, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArrM17014create2, iArrM17014create);
        SecP192K1Field.m16459squareN(iArrM17014create, 6, iArrM17014create);
        SecP192K1Field.multiply(iArrM17014create, iArrM17014create2, iArrM17014create);
        SecP192K1Field.m16458square(iArrM17014create, iArrM17014create);
        SecP192K1Field.m16458square(iArrM17014create, iArrM17014create2);
        if (AbstractC5872Nat192.m17016eq(iArr, iArrM17014create2)) {
            return new SecP192K1FieldElement(iArrM17014create);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16458square(this.f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.subtract(this.f22225x, ((SecP192K1FieldElement) eCFieldElement).f22225x, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5872Nat192.m17018getBit(this.f22225x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5872Nat192.toBigInteger(this.f22225x);
    }

    public SecP192K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22224Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f22225x = SecP192K1Field.fromBigInteger(bigInteger);
    }

    public SecP192K1FieldElement(int[] iArr) {
        this.f22225x = iArr;
    }
}
