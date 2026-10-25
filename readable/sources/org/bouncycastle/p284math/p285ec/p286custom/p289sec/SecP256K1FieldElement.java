package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP256K1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22268Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* renamed from: x */
    protected int[] f22269x;

    public SecP256K1FieldElement() {
        this.f22269x = AbstractC5874Nat256.m17068create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16505add(this.f22269x, ((SecP256K1FieldElement) eCFieldElement).f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16507addOne(this.f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16509inv(((SecP256K1FieldElement) eCFieldElement).f22269x, iArrM17068create);
        SecP256K1Field.multiply(iArrM17068create, this.f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    /* renamed from: equals */
    public boolean m16519equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP256K1FieldElement) {
            return AbstractC5874Nat256.m17070eq(this.f22269x, ((SecP256K1FieldElement) obj).f22269x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP256K1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22268Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22269x, 0, 8) ^ f22268Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16509inv(this.f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5874Nat256.m17075isOne(this.f22269x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5874Nat256.m17077isZero(this.f22269x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.multiply(this.f22269x, ((SecP256K1FieldElement) eCFieldElement).f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16511negate(this.f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22269x;
        if (AbstractC5874Nat256.m17077isZero(iArr) || AbstractC5874Nat256.m17075isOne(iArr)) {
            return this;
        }
        int[] iArrCreateExt = AbstractC5874Nat256.createExt();
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16515square(iArr, iArrM17068create, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create, iArr, iArrM17068create, iArrCreateExt);
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16515square(iArrM17068create, iArrM17068create2, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create2, iArr, iArrM17068create2, iArrCreateExt);
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16517squareN(iArrM17068create2, 3, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create2, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create3, 3, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create2, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create3, 2, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create, iArrM17068create3, iArrCreateExt);
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16517squareN(iArrM17068create3, 11, iArrM17068create4, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create4, iArrM17068create3, iArrM17068create4, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create4, 22, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create4, iArrM17068create3, iArrCreateExt);
        int[] iArrM17068create5 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16517squareN(iArrM17068create3, 44, iArrM17068create5, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create5, iArrM17068create3, iArrM17068create5, iArrCreateExt);
        int[] iArrM17068create6 = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16517squareN(iArrM17068create5, 88, iArrM17068create6, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create6, iArrM17068create5, iArrM17068create6, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create6, 44, iArrM17068create5, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create5, iArrM17068create3, iArrM17068create5, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create5, 3, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create2, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create3, 23, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create4, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create3, 6, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.multiply(iArrM17068create3, iArrM17068create, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.m16517squareN(iArrM17068create3, 2, iArrM17068create3, iArrCreateExt);
        SecP256K1Field.m16515square(iArrM17068create3, iArrM17068create, iArrCreateExt);
        if (AbstractC5874Nat256.m17070eq(iArr, iArrM17068create)) {
            return new SecP256K1FieldElement(iArrM17068create3);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.m16514square(this.f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SecP256K1Field.subtract(this.f22269x, ((SecP256K1FieldElement) eCFieldElement).f22269x, iArrM17068create);
        return new SecP256K1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5874Nat256.m17072getBit(this.f22269x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5874Nat256.toBigInteger(this.f22269x);
    }

    public SecP256K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22268Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f22269x = SecP256K1Field.fromBigInteger(bigInteger);
    }

    public SecP256K1FieldElement(int[] iArr) {
        this.f22269x = iArr;
    }
}
