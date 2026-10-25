package org.bouncycastle.p284math.p285ec.p286custom.p287djb;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Curve25519FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: x */
    protected int[] f22168x;

    /* renamed from: Q */
    public static final BigInteger f22167Q = AbstractC5874Nat256.toBigInteger(Curve25519Field.f22163P);
    private static final int[] PRECOMP_POW2 = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};

    public Curve25519FieldElement() {
        this.f22168x = AbstractC5874Nat256.m17068create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16383add(this.f22168x, ((Curve25519FieldElement) eCFieldElement).f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16385addOne(this.f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16388inv(((Curve25519FieldElement) eCFieldElement).f22168x, iArrM17068create);
        Curve25519Field.multiply(iArrM17068create, this.f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    /* renamed from: equals */
    public boolean m16396equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Curve25519FieldElement) {
            return AbstractC5874Nat256.m17070eq(this.f22168x, ((Curve25519FieldElement) obj).f22168x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "Curve25519Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22167Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22168x, 0, 8) ^ f22167Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16388inv(this.f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5874Nat256.m17075isOne(this.f22168x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5874Nat256.m17077isZero(this.f22168x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.multiply(this.f22168x, ((Curve25519FieldElement) eCFieldElement).f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16390negate(this.f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22168x;
        if (AbstractC5874Nat256.m17077isZero(iArr) || AbstractC5874Nat256.m17075isOne(iArr)) {
            return this;
        }
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16393square(iArr, iArrM17068create);
        Curve25519Field.multiply(iArrM17068create, iArr, iArrM17068create);
        Curve25519Field.m16393square(iArrM17068create, iArrM17068create);
        Curve25519Field.multiply(iArrM17068create, iArr, iArrM17068create);
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16393square(iArrM17068create, iArrM17068create2);
        Curve25519Field.multiply(iArrM17068create2, iArr, iArrM17068create2);
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16394squareN(iArrM17068create2, 3, iArrM17068create3);
        Curve25519Field.multiply(iArrM17068create3, iArrM17068create, iArrM17068create3);
        Curve25519Field.m16394squareN(iArrM17068create3, 4, iArrM17068create);
        Curve25519Field.multiply(iArrM17068create, iArrM17068create2, iArrM17068create);
        Curve25519Field.m16394squareN(iArrM17068create, 4, iArrM17068create3);
        Curve25519Field.multiply(iArrM17068create3, iArrM17068create2, iArrM17068create3);
        Curve25519Field.m16394squareN(iArrM17068create3, 15, iArrM17068create2);
        Curve25519Field.multiply(iArrM17068create2, iArrM17068create3, iArrM17068create2);
        Curve25519Field.m16394squareN(iArrM17068create2, 30, iArrM17068create3);
        Curve25519Field.multiply(iArrM17068create3, iArrM17068create2, iArrM17068create3);
        Curve25519Field.m16394squareN(iArrM17068create3, 60, iArrM17068create2);
        Curve25519Field.multiply(iArrM17068create2, iArrM17068create3, iArrM17068create2);
        Curve25519Field.m16394squareN(iArrM17068create2, 11, iArrM17068create3);
        Curve25519Field.multiply(iArrM17068create3, iArrM17068create, iArrM17068create3);
        Curve25519Field.m16394squareN(iArrM17068create3, 120, iArrM17068create);
        Curve25519Field.multiply(iArrM17068create, iArrM17068create2, iArrM17068create);
        Curve25519Field.m16393square(iArrM17068create, iArrM17068create);
        Curve25519Field.m16393square(iArrM17068create, iArrM17068create2);
        if (AbstractC5874Nat256.m17070eq(iArr, iArrM17068create2)) {
            return new Curve25519FieldElement(iArrM17068create);
        }
        Curve25519Field.multiply(iArrM17068create, PRECOMP_POW2, iArrM17068create);
        Curve25519Field.m16393square(iArrM17068create, iArrM17068create2);
        if (AbstractC5874Nat256.m17070eq(iArr, iArrM17068create2)) {
            return new Curve25519FieldElement(iArrM17068create);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.m16393square(this.f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        Curve25519Field.subtract(this.f22168x, ((Curve25519FieldElement) eCFieldElement).f22168x, iArrM17068create);
        return new Curve25519FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5874Nat256.m17072getBit(this.f22168x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5874Nat256.toBigInteger(this.f22168x);
    }

    public Curve25519FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22167Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.f22168x = Curve25519Field.fromBigInteger(bigInteger);
    }

    public Curve25519FieldElement(int[] iArr) {
        this.f22168x = iArr;
    }
}
