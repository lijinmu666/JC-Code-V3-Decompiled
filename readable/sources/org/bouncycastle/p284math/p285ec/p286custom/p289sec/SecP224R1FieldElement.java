package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP224R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22257Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* renamed from: x */
    protected int[] f22258x;

    public SecP224R1FieldElement() {
        this.f22258x = AbstractC5873Nat224.m17041create();
    }

    /* renamed from: RM */
    private static void m16500RM(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        SecP224R1Field.multiply(iArr5, iArr3, iArr7);
        SecP224R1Field.multiply(iArr7, iArr, iArr7);
        SecP224R1Field.multiply(iArr4, iArr2, iArr6);
        SecP224R1Field.m16488add(iArr6, iArr7, iArr6);
        SecP224R1Field.multiply(iArr4, iArr3, iArr7);
        AbstractC5873Nat224.m17040copy(iArr6, iArr4);
        SecP224R1Field.multiply(iArr5, iArr2, iArr5);
        SecP224R1Field.m16488add(iArr5, iArr7, iArr5);
        SecP224R1Field.m16497square(iArr5, iArr6);
        SecP224R1Field.multiply(iArr6, iArr, iArr6);
    }

    /* renamed from: RP */
    private static void m16501RP(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        AbstractC5873Nat224.m17040copy(iArr, iArr4);
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        for (int i = 0; i < 7; i++) {
            AbstractC5873Nat224.m17040copy(iArr2, iArrM17041create);
            AbstractC5873Nat224.m17040copy(iArr3, iArrM17041create2);
            int i2 = 1 << i;
            while (true) {
                i2--;
                if (i2 >= 0) {
                    m16502RS(iArr2, iArr3, iArr4, iArr5);
                }
            }
            m16500RM(iArr, iArrM17041create, iArrM17041create2, iArr2, iArr3, iArr4, iArr5);
        }
    }

    /* renamed from: RS */
    private static void m16502RS(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        SecP224R1Field.multiply(iArr2, iArr, iArr2);
        SecP224R1Field.m16499twice(iArr2, iArr2);
        SecP224R1Field.m16497square(iArr, iArr4);
        SecP224R1Field.m16488add(iArr3, iArr4, iArr);
        SecP224R1Field.multiply(iArr3, iArr4, iArr3);
        SecP224R1Field.reduce32(AbstractC5869Nat.shiftUpBits(7, iArr3, 2, 0), iArr3);
    }

    private static boolean isSquare(int[] iArr) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        AbstractC5873Nat224.m17040copy(iArr, iArrM17041create);
        for (int i = 0; i < 7; i++) {
            AbstractC5873Nat224.m17040copy(iArrM17041create, iArrM17041create2);
            SecP224R1Field.m16498squareN(iArrM17041create, 1 << i, iArrM17041create);
            SecP224R1Field.multiply(iArrM17041create, iArrM17041create2, iArrM17041create);
        }
        SecP224R1Field.m16498squareN(iArrM17041create, 95, iArrM17041create);
        return AbstractC5873Nat224.m17047isOne(iArrM17041create);
    }

    /* renamed from: trySqrt */
    private static boolean m16503trySqrt(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        AbstractC5873Nat224.m17040copy(iArr2, iArrM17041create);
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        iArrM17041create2[0] = 1;
        int[] iArrM17041create3 = AbstractC5873Nat224.m17041create();
        m16501RP(iArr, iArrM17041create, iArrM17041create2, iArrM17041create3, iArr3);
        int[] iArrM17041create4 = AbstractC5873Nat224.m17041create();
        int[] iArrM17041create5 = AbstractC5873Nat224.m17041create();
        for (int i = 1; i < 96; i++) {
            AbstractC5873Nat224.m17040copy(iArrM17041create, iArrM17041create4);
            AbstractC5873Nat224.m17040copy(iArrM17041create2, iArrM17041create5);
            m16502RS(iArrM17041create, iArrM17041create2, iArrM17041create3, iArr3);
            if (AbstractC5873Nat224.m17048isZero(iArrM17041create)) {
                SecP224R1Field.m16492inv(iArrM17041create5, iArr3);
                SecP224R1Field.multiply(iArr3, iArrM17041create4, iArr3);
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16488add(this.f22258x, ((SecP224R1FieldElement) eCFieldElement).f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16490addOne(this.f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16492inv(((SecP224R1FieldElement) eCFieldElement).f22258x, iArrM17041create);
        SecP224R1Field.multiply(iArrM17041create, this.f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    /* renamed from: equals */
    public boolean m16504equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP224R1FieldElement) {
            return AbstractC5873Nat224.m17043eq(this.f22258x, ((SecP224R1FieldElement) obj).f22258x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SecP224R1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22257Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22258x, 0, 7) ^ f22257Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16492inv(this.f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5873Nat224.m17047isOne(this.f22258x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5873Nat224.m17048isZero(this.f22258x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.multiply(this.f22258x, ((SecP224R1FieldElement) eCFieldElement).f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16494negate(this.f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22258x;
        if (AbstractC5873Nat224.m17048isZero(iArr) || AbstractC5873Nat224.m17047isOne(iArr)) {
            return this;
        }
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16494negate(iArr, iArrM17041create);
        int[] iArrM16881random = AbstractC5867Mod.m16881random(SecP224R1Field.f22252P);
        int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
        if (!isSquare(iArr)) {
            return null;
        }
        while (!m16503trySqrt(iArrM17041create, iArrM16881random, iArrM17041create2)) {
            SecP224R1Field.m16490addOne(iArrM16881random, iArrM16881random);
        }
        SecP224R1Field.m16497square(iArrM17041create2, iArrM16881random);
        if (AbstractC5873Nat224.m17043eq(iArr, iArrM16881random)) {
            return new SecP224R1FieldElement(iArrM17041create2);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16497square(this.f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.subtract(this.f22258x, ((SecP224R1FieldElement) eCFieldElement).f22258x, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5873Nat224.m17044getBit(this.f22258x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5873Nat224.toBigInteger(this.f22258x);
    }

    public SecP224R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22257Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f22258x = SecP224R1Field.fromBigInteger(bigInteger);
    }

    public SecP224R1FieldElement(int[] iArr) {
        this.f22258x = iArr;
    }
}
