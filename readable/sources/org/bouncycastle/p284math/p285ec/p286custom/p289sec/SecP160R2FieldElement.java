package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5871Nat160;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP160R2FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22213Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* renamed from: x */
    protected int[] f22214x;

    public SecP160R2FieldElement() {
        this.f22214x = AbstractC5871Nat160.m16989create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16436add(this.f22214x, ((SecP160R2FieldElement) eCFieldElement).f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16438addOne(this.f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16440inv(((SecP160R2FieldElement) eCFieldElement).f22214x, iArrM16989create);
        SecP160R2Field.multiply(iArrM16989create, this.f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    /* renamed from: equals */
    public boolean m16448equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP160R2FieldElement) {
            return AbstractC5871Nat160.m16991eq(this.f22214x, ((SecP160R2FieldElement) obj).f22214x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP160R2Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22213Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22214x, 0, 5) ^ f22213Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16440inv(this.f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5871Nat160.m16995isOne(this.f22214x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5871Nat160.m16996isZero(this.f22214x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.multiply(this.f22214x, ((SecP160R2FieldElement) eCFieldElement).f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16442negate(this.f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22214x;
        if (AbstractC5871Nat160.m16996isZero(iArr) || AbstractC5871Nat160.m16995isOne(iArr)) {
            return this;
        }
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(iArr, iArrM16989create);
        SecP160R2Field.multiply(iArrM16989create, iArr, iArrM16989create);
        int[] iArrM16989create2 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(iArrM16989create, iArrM16989create2);
        SecP160R2Field.multiply(iArrM16989create2, iArr, iArrM16989create2);
        int[] iArrM16989create3 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(iArrM16989create2, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArr, iArrM16989create3);
        int[] iArrM16989create4 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16446squareN(iArrM16989create3, 3, iArrM16989create4);
        SecP160R2Field.multiply(iArrM16989create4, iArrM16989create2, iArrM16989create4);
        SecP160R2Field.m16446squareN(iArrM16989create4, 7, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArrM16989create4, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 3, iArrM16989create4);
        SecP160R2Field.multiply(iArrM16989create4, iArrM16989create2, iArrM16989create4);
        int[] iArrM16989create5 = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16446squareN(iArrM16989create4, 14, iArrM16989create5);
        SecP160R2Field.multiply(iArrM16989create5, iArrM16989create3, iArrM16989create5);
        SecP160R2Field.m16446squareN(iArrM16989create5, 31, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArrM16989create5, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 62, iArrM16989create5);
        SecP160R2Field.multiply(iArrM16989create5, iArrM16989create3, iArrM16989create5);
        SecP160R2Field.m16446squareN(iArrM16989create5, 3, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArrM16989create2, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 18, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArrM16989create4, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 2, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArr, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 3, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArrM16989create, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 6, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArrM16989create2, iArrM16989create3);
        SecP160R2Field.m16446squareN(iArrM16989create3, 2, iArrM16989create3);
        SecP160R2Field.multiply(iArrM16989create3, iArr, iArrM16989create3);
        SecP160R2Field.m16445square(iArrM16989create3, iArrM16989create);
        if (AbstractC5871Nat160.m16991eq(iArr, iArrM16989create)) {
            return new SecP160R2FieldElement(iArrM16989create3);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16445square(this.f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.subtract(this.f22214x, ((SecP160R2FieldElement) eCFieldElement).f22214x, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5871Nat160.m16992getBit(this.f22214x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5871Nat160.toBigInteger(this.f22214x);
    }

    public SecP160R2FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22213Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.f22214x = SecP160R2Field.fromBigInteger(bigInteger);
    }

    public SecP160R2FieldElement(int[] iArr) {
        this.f22214x = iArr;
    }
}
