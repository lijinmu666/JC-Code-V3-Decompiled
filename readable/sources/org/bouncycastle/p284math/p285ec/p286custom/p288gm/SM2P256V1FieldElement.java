package org.bouncycastle.p284math.p285ec.p286custom.p288gm;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SM2P256V1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f22176Q = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f22177x;

    public SM2P256V1FieldElement() {
        this.f22177x = AbstractC5874Nat256.m17068create();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: add */
    public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16397add(this.f22177x, ((SM2P256V1FieldElement) eCFieldElement).f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: addOne */
    public ECFieldElement mo16311addOne() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16399addOne(this.f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: divide */
    public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16401inv(((SM2P256V1FieldElement) eCFieldElement).f22177x, iArrM17068create);
        SM2P256V1Field.multiply(iArrM17068create, this.f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    /* renamed from: equals */
    public boolean m16409equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SM2P256V1FieldElement) {
            return AbstractC5874Nat256.m17070eq(this.f22177x, ((SM2P256V1FieldElement) obj).f22177x);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public String getFieldName() {
        return "SM2P256V1Field";
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public int getFieldSize() {
        return f22176Q.bitLength();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f22177x, 0, 8) ^ f22176Q.hashCode();
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: invert */
    public ECFieldElement mo16313invert() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16401inv(this.f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return AbstractC5874Nat256.m17075isOne(this.f22177x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return AbstractC5874Nat256.m17077isZero(this.f22177x);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.multiply(this.f22177x, ((SM2P256V1FieldElement) eCFieldElement).f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: negate */
    public ECFieldElement mo16316negate() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16403negate(this.f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: sqrt */
    public ECFieldElement mo16317sqrt() {
        int[] iArr = this.f22177x;
        if (AbstractC5874Nat256.m17077isZero(iArr) || AbstractC5874Nat256.m17075isOne(iArr)) {
            return this;
        }
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16406square(iArr, iArrM17068create);
        SM2P256V1Field.multiply(iArrM17068create, iArr, iArrM17068create);
        int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16407squareN(iArrM17068create, 2, iArrM17068create2);
        SM2P256V1Field.multiply(iArrM17068create2, iArrM17068create, iArrM17068create2);
        int[] iArrM17068create3 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16407squareN(iArrM17068create2, 2, iArrM17068create3);
        SM2P256V1Field.multiply(iArrM17068create3, iArrM17068create, iArrM17068create3);
        SM2P256V1Field.m16407squareN(iArrM17068create3, 6, iArrM17068create);
        SM2P256V1Field.multiply(iArrM17068create, iArrM17068create3, iArrM17068create);
        int[] iArrM17068create4 = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16407squareN(iArrM17068create, 12, iArrM17068create4);
        SM2P256V1Field.multiply(iArrM17068create4, iArrM17068create, iArrM17068create4);
        SM2P256V1Field.m16407squareN(iArrM17068create4, 6, iArrM17068create);
        SM2P256V1Field.multiply(iArrM17068create, iArrM17068create3, iArrM17068create);
        SM2P256V1Field.m16406square(iArrM17068create, iArrM17068create3);
        SM2P256V1Field.multiply(iArrM17068create3, iArr, iArrM17068create3);
        SM2P256V1Field.m16407squareN(iArrM17068create3, 31, iArrM17068create4);
        SM2P256V1Field.multiply(iArrM17068create4, iArrM17068create3, iArrM17068create);
        SM2P256V1Field.m16407squareN(iArrM17068create4, 32, iArrM17068create4);
        SM2P256V1Field.multiply(iArrM17068create4, iArrM17068create, iArrM17068create4);
        SM2P256V1Field.m16407squareN(iArrM17068create4, 62, iArrM17068create4);
        SM2P256V1Field.multiply(iArrM17068create4, iArrM17068create, iArrM17068create4);
        SM2P256V1Field.m16407squareN(iArrM17068create4, 4, iArrM17068create4);
        SM2P256V1Field.multiply(iArrM17068create4, iArrM17068create2, iArrM17068create4);
        SM2P256V1Field.m16407squareN(iArrM17068create4, 32, iArrM17068create4);
        SM2P256V1Field.multiply(iArrM17068create4, iArr, iArrM17068create4);
        SM2P256V1Field.m16407squareN(iArrM17068create4, 62, iArrM17068create4);
        SM2P256V1Field.m16406square(iArrM17068create4, iArrM17068create2);
        if (AbstractC5874Nat256.m17070eq(iArr, iArrM17068create2)) {
            return new SM2P256V1FieldElement(iArrM17068create4);
        }
        return null;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    /* renamed from: square */
    public ECFieldElement mo16318square() {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16406square(this.f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.subtract(this.f22177x, ((SM2P256V1FieldElement) eCFieldElement).f22177x, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public boolean testBitZero() {
        return AbstractC5874Nat256.m17072getBit(this.f22177x, 0) == 1;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
    public BigInteger toBigInteger() {
        return AbstractC5874Nat256.toBigInteger(this.f22177x);
    }

    public SM2P256V1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f22176Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.f22177x = SM2P256V1Field.fromBigInteger(bigInteger);
    }

    public SM2P256V1FieldElement(int[] iArr) {
        this.f22177x = iArr;
    }
}
