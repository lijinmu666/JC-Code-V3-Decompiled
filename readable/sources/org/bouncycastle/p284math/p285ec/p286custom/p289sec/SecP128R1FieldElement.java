package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5870Nat128;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP128R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22187Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f22188x;

    public SecP128R1FieldElement() {
        this.f22188x = AbstractC5870Nat128.m16964create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16410add(this.f22188x, ((SecP128R1FieldElement) eCFieldElement).f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16412addOne(this.f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16414inv(((SecP128R1FieldElement) eCFieldElement).f22188x, iArrM16964create);
        SecP128R1Field.multiply(iArrM16964create, this.f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    /* renamed from: equals */
    public boolean m16422equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP128R1FieldElement) {
            return AbstractC5870Nat128.m16966eq(this.f22188x, ((SecP128R1FieldElement) obj).f22188x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP128R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22187Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22188x, 0, 4) ^ f22187Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16414inv(this.f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5870Nat128.m16971isOne(this.f22188x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5870Nat128.m16973isZero(this.f22188x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.multiply(this.f22188x, ((SecP128R1FieldElement) eCFieldElement).f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16416negate(this.f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22188x;
        if (AbstractC5870Nat128.m16973isZero(iArr) || AbstractC5870Nat128.m16971isOne(iArr)) {
            return this;
        }
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16419square(iArr, iArrM16964create);
        SecP128R1Field.multiply(iArrM16964create, iArr, iArrM16964create);
        int[] iArrM16964create2 = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16420squareN(iArrM16964create, 2, iArrM16964create2);
        SecP128R1Field.multiply(iArrM16964create2, iArrM16964create, iArrM16964create2);
        int[] iArrM16964create3 = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16420squareN(iArrM16964create2, 4, iArrM16964create3);
        SecP128R1Field.multiply(iArrM16964create3, iArrM16964create2, iArrM16964create3);
        SecP128R1Field.m16420squareN(iArrM16964create3, 2, iArrM16964create2);
        SecP128R1Field.multiply(iArrM16964create2, iArrM16964create, iArrM16964create2);
        SecP128R1Field.m16420squareN(iArrM16964create2, 10, iArrM16964create);
        SecP128R1Field.multiply(iArrM16964create, iArrM16964create2, iArrM16964create);
        SecP128R1Field.m16420squareN(iArrM16964create, 10, iArrM16964create3);
        SecP128R1Field.multiply(iArrM16964create3, iArrM16964create2, iArrM16964create3);
        SecP128R1Field.m16419square(iArrM16964create3, iArrM16964create2);
        SecP128R1Field.multiply(iArrM16964create2, iArr, iArrM16964create2);
        SecP128R1Field.m16420squareN(iArrM16964create2, 95, iArrM16964create2);
        SecP128R1Field.m16419square(iArrM16964create2, iArrM16964create3);
        if (AbstractC5870Nat128.m16966eq(iArr, iArrM16964create3)) {
            return new SecP128R1FieldElement(iArrM16964create2);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.m16419square(this.f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM16964create = AbstractC5870Nat128.m16964create();
        SecP128R1Field.subtract(this.f22188x, ((SecP128R1FieldElement) eCFieldElement).f22188x, iArrM16964create);
        return new SecP128R1FieldElement(iArrM16964create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5870Nat128.m16968getBit(this.f22188x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5870Nat128.toBigInteger(this.f22188x);
    }

    public SecP128R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22187Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f22188x = SecP128R1Field.fromBigInteger(bigInteger);
    }

    public SecP128R1FieldElement(int[] iArr) {
        this.f22188x = iArr;
    }
}
