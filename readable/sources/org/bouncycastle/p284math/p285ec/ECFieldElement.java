package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public abstract class ECFieldElement implements ECConstants {

    public static abstract class AbstractF2m extends ECFieldElement {
        public ECFieldElement halfTrace() {
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int i = (fieldSize + 1) >>> 1;
            int iBitLength = Integers.bitLength(i) - 1;
            ECFieldElement eCFieldElementMo16310add = this;
            int i2 = 1;
            while (iBitLength > 0) {
                eCFieldElementMo16310add = eCFieldElementMo16310add.squarePow(i2 << 1).mo16310add(eCFieldElementMo16310add);
                iBitLength--;
                i2 = i >>> iBitLength;
                if ((i2 & 1) != 0) {
                    eCFieldElementMo16310add = eCFieldElementMo16310add.squarePow(2).mo16310add(this);
                }
            }
            return eCFieldElementMo16310add;
        }

        public boolean hasFastTrace() {
            return false;
        }

        /* renamed from: trace */
        public int mo16319trace() {
            int fieldSize = getFieldSize();
            int iBitLength = Integers.bitLength(fieldSize) - 1;
            ECFieldElement eCFieldElementMo16310add = this;
            int i = 1;
            while (iBitLength > 0) {
                eCFieldElementMo16310add = eCFieldElementMo16310add.squarePow(i).mo16310add(eCFieldElementMo16310add);
                iBitLength--;
                i = fieldSize >>> iBitLength;
                if ((i & 1) != 0) {
                    eCFieldElementMo16310add = eCFieldElementMo16310add.mo16318square().mo16310add(this);
                }
            }
            if (eCFieldElementMo16310add.mo16315isZero()) {
                return 0;
            }
            if (eCFieldElementMo16310add.mo16314isOne()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class AbstractFp extends ECFieldElement {
    }

    /* renamed from: org.bouncycastle.math.ec.ECFieldElement$F2m */
    public static class C5818F2m extends AbstractF2m {

        /* renamed from: GNB */
        public static final int f22115GNB = 1;

        /* renamed from: PPB */
        public static final int f22116PPB = 3;

        /* renamed from: TPB */
        public static final int f22117TPB = 2;

        /* renamed from: ks */
        private int[] f22118ks;

        /* renamed from: m */
        private int f22119m;
        private int representation;

        /* renamed from: x */
        LongArray f22120x;

        public C5818F2m(int i, int[] iArr, LongArray longArray) {
            this.f22119m = i;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.f22118ks = iArr;
            this.f22120x = longArray;
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: add */
        public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f22120x.m16354clone();
            longArray.addShiftedByWords(((C5818F2m) eCFieldElement).f22120x, 0);
            return new C5818F2m(this.f22119m, this.f22118ks, longArray);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: addOne */
        public ECFieldElement mo16311addOne() {
            return new C5818F2m(this.f22119m, this.f22118ks, this.f22120x.m16353addOne());
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public int bitLength() {
            return this.f22120x.m16356degree();
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: divide */
        public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.mo16313invert());
        }

        /* renamed from: equals */
        public boolean m16320equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C5818F2m)) {
                return false;
            }
            C5818F2m c5818F2m = (C5818F2m) obj;
            return this.f22119m == c5818F2m.f22119m && this.representation == c5818F2m.representation && C6238Arrays.areEqual(this.f22118ks, c5818F2m.f22118ks) && this.f22120x.m16357equals(c5818F2m.f22120x);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public int getFieldSize() {
            return this.f22119m;
        }

        /* renamed from: getK1 */
        public int m16321getK1() {
            return this.f22118ks[0];
        }

        /* renamed from: getK2 */
        public int m16322getK2() {
            int[] iArr = this.f22118ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        /* renamed from: getK3 */
        public int m16323getK3() {
            int[] iArr = this.f22118ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        /* renamed from: getM */
        public int m16324getM() {
            return this.f22119m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return C6238Arrays.hashCode(this.f22118ks) ^ (this.f22120x.hashCode() ^ this.f22119m);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: invert */
        public ECFieldElement mo16313invert() {
            int i = this.f22119m;
            int[] iArr = this.f22118ks;
            return new C5818F2m(i, iArr, this.f22120x.modInverse(i, iArr));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: isOne */
        public boolean mo16314isOne() {
            return this.f22120x.m16358isOne();
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: isZero */
        public boolean mo16315isZero() {
            return this.f22120x.m16359isZero();
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i = this.f22119m;
            int[] iArr = this.f22118ks;
            return new C5818F2m(i, iArr, this.f22120x.modMultiply(((C5818F2m) eCFieldElement).f22120x, i, iArr));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            LongArray longArray = this.f22120x;
            LongArray longArray2 = ((C5818F2m) eCFieldElement).f22120x;
            LongArray longArray3 = ((C5818F2m) eCFieldElement2).f22120x;
            LongArray longArray4 = ((C5818F2m) eCFieldElement3).f22120x;
            LongArray longArrayMultiply = longArray.multiply(longArray2, this.f22119m, this.f22118ks);
            LongArray longArrayMultiply2 = longArray3.multiply(longArray4, this.f22119m, this.f22118ks);
            if (longArrayMultiply == longArray || longArrayMultiply == longArray2) {
                longArrayMultiply = (LongArray) longArrayMultiply.m16354clone();
            }
            longArrayMultiply.addShiftedByWords(longArrayMultiply2, 0);
            longArrayMultiply.m16360reduce(this.f22119m, this.f22118ks);
            return new C5818F2m(this.f22119m, this.f22118ks, longArrayMultiply);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: negate */
        public ECFieldElement mo16316negate() {
            return this;
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: sqrt */
        public ECFieldElement mo16317sqrt() {
            return (this.f22120x.m16359isZero() || this.f22120x.m16358isOne()) ? this : squarePow(this.f22119m - 1);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: square */
        public ECFieldElement mo16318square() {
            int i = this.f22119m;
            int[] iArr = this.f22118ks;
            return new C5818F2m(i, iArr, this.f22120x.modSquare(i, iArr));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            LongArray longArray = this.f22120x;
            LongArray longArray2 = ((C5818F2m) eCFieldElement).f22120x;
            LongArray longArray3 = ((C5818F2m) eCFieldElement2).f22120x;
            LongArray longArrayM16361square = longArray.m16361square(this.f22119m, this.f22118ks);
            LongArray longArrayMultiply = longArray2.multiply(longArray3, this.f22119m, this.f22118ks);
            if (longArrayM16361square == longArray) {
                longArrayM16361square = (LongArray) longArrayM16361square.m16354clone();
            }
            longArrayM16361square.addShiftedByWords(longArrayMultiply, 0);
            longArrayM16361square.m16360reduce(this.f22119m, this.f22118ks);
            return new C5818F2m(this.f22119m, this.f22118ks, longArrayM16361square);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement squarePow(int i) {
            if (i < 1) {
                return this;
            }
            int i2 = this.f22119m;
            int[] iArr = this.f22118ks;
            return new C5818F2m(i2, iArr, this.f22120x.modSquareN(i, i2, iArr));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return mo16310add(eCFieldElement);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public boolean testBitZero() {
            return this.f22120x.testBitZero();
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f22120x.toBigInteger();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECFieldElement$Fp */
    public static class C5819Fp extends AbstractFp {

        /* renamed from: q */
        BigInteger f22121q;

        /* renamed from: r */
        BigInteger f22122r;

        /* renamed from: x */
        BigInteger f22123x;

        public C5819Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.f22121q = bigInteger;
            this.f22122r = bigInteger2;
            this.f22123x = bigInteger3;
        }

        public static BigInteger calculateResidue(BigInteger bigInteger) {
            int iBitLength = bigInteger.bitLength();
            if (iBitLength < 96 || bigInteger.shiftRight(iBitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.f22091ONE.shiftLeft(iBitLength).subtract(bigInteger);
        }

        private ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.mo16318square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int iBitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigIntegerM16329modMult = ECConstants.f22091ONE;
            BigInteger bigIntegerModReduce = bigInteger;
            BigInteger bigIntegerM16329modMult2 = bigIntegerM16329modMult;
            BigInteger bigIntegerModReduce2 = ECConstants.f22093TWO;
            BigInteger bigIntegerM16329modMult3 = bigIntegerM16329modMult2;
            for (int i = iBitLength - 1; i >= lowestSetBit + 1; i--) {
                bigIntegerM16329modMult = m16329modMult(bigIntegerM16329modMult, bigIntegerM16329modMult3);
                if (bigInteger3.testBit(i)) {
                    bigIntegerM16329modMult3 = m16329modMult(bigIntegerM16329modMult, bigInteger2);
                    bigIntegerM16329modMult2 = m16329modMult(bigIntegerM16329modMult2, bigIntegerModReduce);
                    bigIntegerModReduce2 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerM16329modMult)));
                    bigIntegerModReduce = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce).subtract(bigIntegerM16329modMult3.shiftLeft(1)));
                } else {
                    BigInteger bigIntegerModReduce3 = modReduce(bigIntegerM16329modMult2.multiply(bigIntegerModReduce2).subtract(bigIntegerM16329modMult));
                    BigInteger bigIntegerModReduce4 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerM16329modMult)));
                    bigIntegerModReduce2 = modReduce(bigIntegerModReduce2.multiply(bigIntegerModReduce2).subtract(bigIntegerM16329modMult.shiftLeft(1)));
                    bigIntegerModReduce = bigIntegerModReduce4;
                    bigIntegerM16329modMult2 = bigIntegerModReduce3;
                    bigIntegerM16329modMult3 = bigIntegerM16329modMult;
                }
            }
            BigInteger bigIntegerM16329modMult4 = m16329modMult(bigIntegerM16329modMult, bigIntegerM16329modMult3);
            BigInteger bigIntegerM16329modMult5 = m16329modMult(bigIntegerM16329modMult4, bigInteger2);
            BigInteger bigIntegerModReduce5 = modReduce(bigIntegerM16329modMult2.multiply(bigIntegerModReduce2).subtract(bigIntegerM16329modMult4));
            BigInteger bigIntegerModReduce6 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerM16329modMult4)));
            BigInteger bigIntegerM16329modMult6 = m16329modMult(bigIntegerM16329modMult4, bigIntegerM16329modMult5);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                bigIntegerModReduce5 = m16329modMult(bigIntegerModReduce5, bigIntegerModReduce6);
                bigIntegerModReduce6 = modReduce(bigIntegerModReduce6.multiply(bigIntegerModReduce6).subtract(bigIntegerM16329modMult6.shiftLeft(1)));
                bigIntegerM16329modMult6 = m16329modMult(bigIntegerM16329modMult6, bigIntegerM16329modMult6);
            }
            return new BigInteger[]{bigIntegerModReduce5, bigIntegerModReduce6};
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: add */
        public ECFieldElement mo16310add(ECFieldElement eCFieldElement) {
            return new C5819Fp(this.f22121q, this.f22122r, m16327modAdd(this.f22123x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: addOne */
        public ECFieldElement mo16311addOne() {
            BigInteger bigIntegerAdd = this.f22123x.add(ECConstants.f22091ONE);
            if (bigIntegerAdd.compareTo(this.f22121q) == 0) {
                bigIntegerAdd = ECConstants.f22094ZERO;
            }
            return new C5819Fp(this.f22121q, this.f22122r, bigIntegerAdd);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: divide */
        public ECFieldElement mo16312divide(ECFieldElement eCFieldElement) {
            return new C5819Fp(this.f22121q, this.f22122r, m16329modMult(this.f22123x, modInverse(eCFieldElement.toBigInteger())));
        }

        /* renamed from: equals */
        public boolean m16325equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C5819Fp)) {
                return false;
            }
            C5819Fp c5819Fp = (C5819Fp) obj;
            return this.f22121q.equals(c5819Fp.f22121q) && this.f22123x.equals(c5819Fp.f22123x);
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public int getFieldSize() {
            return this.f22121q.bitLength();
        }

        /* renamed from: getQ */
        public BigInteger m16326getQ() {
            return this.f22121q;
        }

        public int hashCode() {
            return this.f22123x.hashCode() ^ this.f22121q.hashCode();
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: invert */
        public ECFieldElement mo16313invert() {
            return new C5819Fp(this.f22121q, this.f22122r, modInverse(this.f22123x));
        }

        /* renamed from: modAdd */
        public BigInteger m16327modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
            return bigIntegerAdd.compareTo(this.f22121q) >= 0 ? bigIntegerAdd.subtract(this.f22121q) : bigIntegerAdd;
        }

        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(1);
            return bigIntegerShiftLeft.compareTo(this.f22121q) >= 0 ? bigIntegerShiftLeft.subtract(this.f22121q) : bigIntegerShiftLeft;
        }

        /* renamed from: modHalf */
        public BigInteger m16328modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f22121q.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f22121q.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger modInverse(BigInteger bigInteger) {
            return BigIntegers.modOddInverse(this.f22121q, bigInteger);
        }

        /* renamed from: modMult */
        public BigInteger m16329modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.f22122r == null) {
                return bigInteger.mod(this.f22121q);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int iBitLength = this.f22121q.bitLength();
            boolean zEquals = this.f22122r.equals(ECConstants.f22091ONE);
            while (bigInteger.bitLength() > iBitLength + 1) {
                BigInteger bigIntegerShiftRight = bigInteger.shiftRight(iBitLength);
                BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
                if (!zEquals) {
                    bigIntegerShiftRight = bigIntegerShiftRight.multiply(this.f22122r);
                }
                bigInteger = bigIntegerShiftRight.add(bigIntegerSubtract);
            }
            while (bigInteger.compareTo(this.f22121q) >= 0) {
                bigInteger = bigInteger.subtract(this.f22121q);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.f22121q.subtract(bigInteger);
        }

        public BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
            return bigIntegerSubtract.signum() < 0 ? bigIntegerSubtract.add(this.f22121q) : bigIntegerSubtract;
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new C5819Fp(this.f22121q, this.f22122r, m16329modMult(this.f22123x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f22123x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new C5819Fp(this.f22121q, this.f22122r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f22123x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new C5819Fp(this.f22121q, this.f22122r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: negate */
        public ECFieldElement mo16316negate() {
            if (this.f22123x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f22121q;
            return new C5819Fp(bigInteger, this.f22122r, bigInteger.subtract(this.f22123x));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: sqrt */
        public ECFieldElement mo16317sqrt() {
            if (mo16315isZero() || mo16314isOne()) {
                return this;
            }
            if (!this.f22121q.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.f22121q.testBit(1)) {
                BigInteger bigIntegerAdd = this.f22121q.shiftRight(2).add(ECConstants.f22091ONE);
                BigInteger bigInteger = this.f22121q;
                return checkSqrt(new C5819Fp(bigInteger, this.f22122r, this.f22123x.modPow(bigIntegerAdd, bigInteger)));
            }
            if (this.f22121q.testBit(2)) {
                BigInteger bigIntegerModPow = this.f22123x.modPow(this.f22121q.shiftRight(3), this.f22121q);
                BigInteger bigIntegerM16329modMult = m16329modMult(bigIntegerModPow, this.f22123x);
                if (m16329modMult(bigIntegerM16329modMult, bigIntegerModPow).equals(ECConstants.f22091ONE)) {
                    return checkSqrt(new C5819Fp(this.f22121q, this.f22122r, bigIntegerM16329modMult));
                }
                return checkSqrt(new C5819Fp(this.f22121q, this.f22122r, m16329modMult(bigIntegerM16329modMult, ECConstants.f22093TWO.modPow(this.f22121q.shiftRight(2), this.f22121q))));
            }
            BigInteger bigIntegerShiftRight = this.f22121q.shiftRight(1);
            BigInteger bigIntegerModPow2 = this.f22123x.modPow(bigIntegerShiftRight, this.f22121q);
            BigInteger bigInteger2 = ECConstants.f22091ONE;
            if (!bigIntegerModPow2.equals(bigInteger2)) {
                return null;
            }
            BigInteger bigInteger3 = this.f22123x;
            BigInteger bigIntegerModDouble = modDouble(modDouble(bigInteger3));
            BigInteger bigIntegerAdd2 = bigIntegerShiftRight.add(bigInteger2);
            BigInteger bigIntegerSubtract = this.f22121q.subtract(bigInteger2);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger4 = new BigInteger(this.f22121q.bitLength(), random);
                if (bigInteger4.compareTo(this.f22121q) < 0 && modReduce(bigInteger4.multiply(bigInteger4).subtract(bigIntegerModDouble)).modPow(bigIntegerShiftRight, this.f22121q).equals(bigIntegerSubtract)) {
                    BigInteger[] bigIntegerArrLucasSequence = lucasSequence(bigInteger4, bigInteger3, bigIntegerAdd2);
                    BigInteger bigInteger5 = bigIntegerArrLucasSequence[0];
                    BigInteger bigInteger6 = bigIntegerArrLucasSequence[1];
                    if (m16329modMult(bigInteger6, bigInteger6).equals(bigIntegerModDouble)) {
                        return new C5819Fp(this.f22121q, this.f22122r, modHalfAbs(bigInteger6));
                    }
                    if (!bigInteger5.equals(ECConstants.f22091ONE) && !bigInteger5.equals(bigIntegerSubtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        /* renamed from: square */
        public ECFieldElement mo16318square() {
            BigInteger bigInteger = this.f22121q;
            BigInteger bigInteger2 = this.f22122r;
            BigInteger bigInteger3 = this.f22123x;
            return new C5819Fp(bigInteger, bigInteger2, m16329modMult(bigInteger3, bigInteger3));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f22123x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new C5819Fp(this.f22121q, this.f22122r, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f22123x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new C5819Fp(this.f22121q, this.f22122r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new C5819Fp(this.f22121q, this.f22122r, modSubtract(this.f22123x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.p284math.p285ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f22123x;
        }
    }

    /* renamed from: add */
    public abstract ECFieldElement mo16310add(ECFieldElement eCFieldElement);

    /* renamed from: addOne */
    public abstract ECFieldElement mo16311addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    /* renamed from: divide */
    public abstract ECFieldElement mo16312divide(ECFieldElement eCFieldElement);

    public void encodeTo(byte[] bArr, int i) {
        BigIntegers.asUnsignedByteArray(toBigInteger(), bArr, i, getEncodedLength());
    }

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray(getEncodedLength(), toBigInteger());
    }

    public int getEncodedLength() {
        return (getFieldSize() + 7) / 8;
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    /* renamed from: invert */
    public abstract ECFieldElement mo16313invert();

    /* renamed from: isOne */
    public boolean mo16314isOne() {
        return bitLength() == 1;
    }

    /* renamed from: isZero */
    public boolean mo16315isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).mo16310add(eCFieldElement2.multiply(eCFieldElement3));
    }

    /* renamed from: negate */
    public abstract ECFieldElement mo16316negate();

    /* renamed from: sqrt */
    public abstract ECFieldElement mo16317sqrt();

    /* renamed from: square */
    public abstract ECFieldElement mo16318square();

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return mo16318square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return mo16318square().mo16310add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this = this.mo16318square();
        }
        return this;
    }

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
