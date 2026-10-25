package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP224K1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: x */
    protected int[] f22247x;

    /* renamed from: Q */
    public static final BigInteger f22246Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
    private static final int[] PRECOMP_POW2 = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    public SecP224K1FieldElement() {
        this.f22247x = AbstractC5873Nat224.m17041create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16475add(this.f22247x, ((SecP224K1FieldElement) eCFieldElement).f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16477addOne(this.f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16479inv(((SecP224K1FieldElement) eCFieldElement).f22247x, iArrM17041create);
        SecP224K1Field.multiply(iArrM17041create, this.f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    /* renamed from: equals */
    public boolean m16487equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP224K1FieldElement) {
            return AbstractC5873Nat224.m17043eq(this.f22247x, ((SecP224K1FieldElement) obj).f22247x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP224K1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22246Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22247x, 0, 7) ^ f22246Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16479inv(this.f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5873Nat224.m17047isOne(this.f22247x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5873Nat224.m17048isZero(this.f22247x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.multiply(this.f22247x, ((SecP224K1FieldElement) eCFieldElement).f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16481negate(this.f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22247x;
        if (AbstractC5873Nat224.m17048isZero(iArr) || AbstractC5873Nat224.m17047isOne(iArr)) {
            return this;
        }
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16484square(iArr, iArrM17041create);
        SecP224K1Field.multiply(iArrM17041create, iArr, iArrM17041create);
        SecP224K1Field.m16484square(iArrM17041create, iArrM17041create);
        SecP224K1Field.multiply(iArrM17041create, iArr, iArrM17041create);
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16484square(iArrM17041create, iArrM17041create2);
        SecP224K1Field.multiply(iArrM17041create2, iArr, iArrM17041create2);
        int[] iArrM17041create3 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16485squareN(iArrM17041create2, 4, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArrM17041create2, iArrM17041create3);
        int[] iArrM17041create4 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16485squareN(iArrM17041create3, 3, iArrM17041create4);
        SecP224K1Field.multiply(iArrM17041create4, iArrM17041create, iArrM17041create4);
        SecP224K1Field.m16485squareN(iArrM17041create4, 8, iArrM17041create4);
        SecP224K1Field.multiply(iArrM17041create4, iArrM17041create3, iArrM17041create4);
        SecP224K1Field.m16485squareN(iArrM17041create4, 4, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArrM17041create2, iArrM17041create3);
        SecP224K1Field.m16485squareN(iArrM17041create3, 19, iArrM17041create2);
        SecP224K1Field.multiply(iArrM17041create2, iArrM17041create4, iArrM17041create2);
        int[] iArrM17041create5 = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16485squareN(iArrM17041create2, 42, iArrM17041create5);
        SecP224K1Field.multiply(iArrM17041create5, iArrM17041create2, iArrM17041create5);
        SecP224K1Field.m16485squareN(iArrM17041create5, 23, iArrM17041create2);
        SecP224K1Field.multiply(iArrM17041create2, iArrM17041create3, iArrM17041create2);
        SecP224K1Field.m16485squareN(iArrM17041create2, 84, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArrM17041create5, iArrM17041create3);
        SecP224K1Field.m16485squareN(iArrM17041create3, 20, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArrM17041create4, iArrM17041create3);
        SecP224K1Field.m16485squareN(iArrM17041create3, 3, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArr, iArrM17041create3);
        SecP224K1Field.m16485squareN(iArrM17041create3, 2, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArr, iArrM17041create3);
        SecP224K1Field.m16485squareN(iArrM17041create3, 4, iArrM17041create3);
        SecP224K1Field.multiply(iArrM17041create3, iArrM17041create, iArrM17041create3);
        SecP224K1Field.m16484square(iArrM17041create3, iArrM17041create3);
        SecP224K1Field.m16484square(iArrM17041create3, iArrM17041create5);
        if (AbstractC5873Nat224.m17043eq(iArr, iArrM17041create5)) {
            return new SecP224K1FieldElement(iArrM17041create3);
        }
        SecP224K1Field.multiply(iArrM17041create3, PRECOMP_POW2, iArrM17041create3);
        SecP224K1Field.m16484square(iArrM17041create3, iArrM17041create5);
        if (AbstractC5873Nat224.m17043eq(iArr, iArrM17041create5)) {
            return new SecP224K1FieldElement(iArrM17041create3);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.m16484square(this.f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224K1Field.subtract(this.f22247x, ((SecP224K1FieldElement) eCFieldElement).f22247x, iArrM17041create);
        return new SecP224K1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5873Nat224.m17044getBit(this.f22247x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5873Nat224.toBigInteger(this.f22247x);
    }

    public SecP224K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22246Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f22247x = SecP224K1Field.fromBigInteger(bigInteger);
    }

    public SecP224K1FieldElement(int[] iArr) {
        this.f22247x = iArr;
    }
}
