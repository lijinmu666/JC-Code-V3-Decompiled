package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.BigIntegers;

/* renamed from: org.bouncycastle.math.ec.Tnaf */
/* loaded from: classes2.dex */
class C5822Tnaf {
    private static final BigInteger MINUS_ONE;
    private static final BigInteger MINUS_THREE;
    private static final BigInteger MINUS_TWO;

    /* renamed from: WIDTH */
    public static final byte f22143WIDTH = 4;

    /* renamed from: alpha0 */
    public static final ZTauElement[] f22144alpha0;
    public static final byte[][] alpha0Tnaf;

    /* renamed from: alpha1 */
    public static final ZTauElement[] f22145alpha1;
    public static final byte[][] alpha1Tnaf;

    static {
        BigInteger bigInteger = ECConstants.f22091ONE;
        BigInteger bigIntegerNegate = bigInteger.negate();
        MINUS_ONE = bigIntegerNegate;
        MINUS_TWO = ECConstants.f22093TWO.negate();
        BigInteger bigInteger2 = ECConstants.f22092THREE;
        BigInteger bigIntegerNegate2 = bigInteger2.negate();
        MINUS_THREE = bigIntegerNegate2;
        BigInteger bigInteger3 = ECConstants.f22094ZERO;
        f22144alpha0 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger3), null, new ZTauElement(bigIntegerNegate2, bigIntegerNegate), null, new ZTauElement(bigIntegerNegate, bigIntegerNegate), null, new ZTauElement(bigInteger, bigIntegerNegate), null, new ZTauElement(bigIntegerNegate, bigInteger), null, new ZTauElement(bigInteger, bigInteger), null, new ZTauElement(bigInteger2, bigInteger), null, new ZTauElement(bigIntegerNegate, bigInteger3)};
        alpha0Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        f22145alpha1 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger3), null, new ZTauElement(bigIntegerNegate2, bigInteger), null, new ZTauElement(bigIntegerNegate, bigInteger), null, new ZTauElement(bigInteger, bigInteger), null, new ZTauElement(bigIntegerNegate, bigIntegerNegate), null, new ZTauElement(bigInteger, bigIntegerNegate), null, new ZTauElement(bigInteger2, bigIntegerNegate), null, new ZTauElement(bigIntegerNegate, bigInteger3)};
        alpha1Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b, int i, int i2) {
        BigInteger bigIntegerMultiply = bigInteger2.multiply(bigInteger.shiftRight(((i - r0) - 2) + b));
        BigInteger bigIntegerAdd = bigIntegerMultiply.add(bigInteger3.multiply(bigIntegerMultiply.shiftRight(i)));
        int i3 = (((i + 5) / 2) + i2) - i2;
        BigInteger bigIntegerShiftRight = bigIntegerAdd.shiftRight(i3);
        if (bigIntegerAdd.testBit(i3 - 1)) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(ECConstants.f22091ONE);
        }
        return new SimpleBigDecimal(bigIntegerShiftRight, i2);
    }

    public static BigInteger[] getLucas(byte b, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigIntegerSubtract;
        if (b != 1 && b != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        if (z) {
            bigInteger = ECConstants.f22093TWO;
            bigIntegerSubtract = BigInteger.valueOf(b);
        } else {
            bigInteger = ECConstants.f22094ZERO;
            bigIntegerSubtract = ECConstants.f22091ONE;
        }
        int i2 = 1;
        while (i2 < i) {
            i2++;
            BigInteger bigInteger2 = bigIntegerSubtract;
            bigIntegerSubtract = (b < 0 ? bigIntegerSubtract.negate() : bigIntegerSubtract).subtract(bigInteger.shiftLeft(1));
            bigInteger = bigInteger2;
        }
        return new BigInteger[]{bigInteger, bigIntegerSubtract};
    }

    /* renamed from: getMu */
    public static byte m16371getMu(int i) {
        return (byte) (i == 0 ? -1 : 1);
    }

    public static AbstractC5820ECPoint.AbstractF2m[] getPreComp(AbstractC5820ECPoint.AbstractF2m abstractF2m, byte b) {
        AbstractC5820ECPoint.AbstractF2m abstractF2m2 = (AbstractC5820ECPoint.AbstractF2m) abstractF2m.mo16335negate();
        byte[][] bArr = b == 0 ? alpha0Tnaf : alpha1Tnaf;
        AbstractC5820ECPoint.AbstractF2m[] abstractF2mArr = new AbstractC5820ECPoint.AbstractF2m[(bArr.length + 1) >>> 1];
        abstractF2mArr[0] = abstractF2m;
        int length = bArr.length;
        for (int i = 3; i < length; i += 2) {
            abstractF2mArr[i >>> 1] = multiplyFromTnaf(abstractF2m, abstractF2m2, bArr[i]);
        }
        abstractF2m.getCurve().normalizeAll(abstractF2mArr);
        return abstractF2mArr;
    }

    public static int getShiftsForCofactor(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (bigInteger.equals(ECConstants.f22093TWO)) {
                return 1;
            }
            if (bigInteger.equals(ECConstants.f22090FOUR)) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    /* renamed from: getSi */
    public static BigInteger[] m16374getSi(int i, int i2, BigInteger bigInteger) {
        byte bM16371getMu = m16371getMu(i2);
        int shiftsForCofactor = getShiftsForCofactor(bigInteger);
        BigInteger[] lucas = getLucas(bM16371getMu, (i + 3) - i2, false);
        if (bM16371getMu == 1) {
            lucas[0] = lucas[0].negate();
            lucas[1] = lucas[1].negate();
        }
        BigInteger bigInteger2 = ECConstants.f22091ONE;
        return new BigInteger[]{bigInteger2.add(lucas[1]).shiftRight(shiftsForCofactor), bigInteger2.add(lucas[0]).shiftRight(shiftsForCofactor).negate()};
    }

    /* renamed from: getTw */
    public static BigInteger m16376getTw(byte b, int i) {
        if (i == 4) {
            return b == 1 ? BigInteger.valueOf(6L) : BigInteger.valueOf(10L);
        }
        BigInteger[] lucas = getLucas(b, i, false);
        BigInteger bit = ECConstants.f22094ZERO.setBit(i);
        return lucas[0].shiftLeft(1).multiply(lucas[1].modInverse(bit)).mod(bit);
    }

    public static AbstractC5820ECPoint.AbstractF2m multiplyFromTnaf(AbstractC5820ECPoint.AbstractF2m abstractF2m, AbstractC5820ECPoint.AbstractF2m abstractF2m2, byte[] bArr) {
        AbstractC5820ECPoint.AbstractF2m abstractF2m3 = (AbstractC5820ECPoint.AbstractF2m) abstractF2m.getCurve().getInfinity();
        int i = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i++;
            byte b = bArr[length];
            if (b != 0) {
                abstractF2m3 = (AbstractC5820ECPoint.AbstractF2m) abstractF2m3.m16340tauPow(i).mo16330add(b > 0 ? abstractF2m : abstractF2m2);
                i = 0;
            }
        }
        return i > 0 ? abstractF2m3.m16340tauPow(i) : abstractF2m3;
    }

    public static AbstractC5820ECPoint.AbstractF2m multiplyRTnaf(AbstractC5820ECPoint.AbstractF2m abstractF2m, BigInteger bigInteger) {
        AbstractC5817ECCurve.AbstractF2m abstractF2m2 = (AbstractC5817ECCurve.AbstractF2m) abstractF2m.getCurve();
        int iIntValue = abstractF2m2.m16298getA().toBigInteger().intValue();
        return multiplyTnaf(abstractF2m, partModReduction(abstractF2m2, bigInteger, (byte) iIntValue, m16371getMu(iIntValue), (byte) 10));
    }

    public static AbstractC5820ECPoint.AbstractF2m multiplyTnaf(AbstractC5820ECPoint.AbstractF2m abstractF2m, ZTauElement zTauElement) {
        return multiplyFromTnaf(abstractF2m, (AbstractC5820ECPoint.AbstractF2m) abstractF2m.mo16335negate(), tauAdicNaf(m16373getMu(((AbstractC5817ECCurve.AbstractF2m) abstractF2m.getCurve()).m16298getA()), zTauElement));
    }

    /* renamed from: norm */
    public static BigInteger m16377norm(byte b, ZTauElement zTauElement) {
        BigInteger bigIntegerSubtract;
        BigInteger bigInteger = zTauElement.f22155u;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger);
        if (b == 1) {
            bigIntegerSubtract = zTauElement.f22156v.shiftLeft(1).add(zTauElement.f22155u);
        } else {
            if (b != -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            bigIntegerSubtract = zTauElement.f22156v.shiftLeft(1).subtract(zTauElement.f22155u);
        }
        return bigIntegerSubtract.multiply(zTauElement.f22156v).add(bigIntegerMultiply);
    }

    public static ZTauElement partModReduction(AbstractC5817ECCurve.AbstractF2m abstractF2m, BigInteger bigInteger, byte b, byte b2, byte b3) {
        BigInteger bigIntegerSubtract;
        int fieldSize = abstractF2m.getFieldSize();
        BigInteger[] bigIntegerArrM16303getSi = abstractF2m.m16303getSi();
        BigInteger bigIntegerAdd = b2 == 1 ? bigIntegerArrM16303getSi[0].add(bigIntegerArrM16303getSi[1]) : bigIntegerArrM16303getSi[0].subtract(bigIntegerArrM16303getSi[1]);
        if (abstractF2m.isKoblitz()) {
            BigInteger bigInteger2 = ECConstants.f22091ONE;
            bigIntegerSubtract = bigInteger2.shiftLeft(fieldSize).add(bigInteger2).subtract(abstractF2m.getOrder().multiply(abstractF2m.getCofactor()));
        } else {
            bigIntegerSubtract = getLucas(b2, fieldSize, true)[1];
        }
        BigInteger bigInteger3 = bigIntegerSubtract;
        ZTauElement zTauElementM16379round = m16379round(approximateDivisionByN(bigInteger, bigIntegerArrM16303getSi[0], bigInteger3, b, fieldSize, b3), approximateDivisionByN(bigInteger, bigIntegerArrM16303getSi[1], bigInteger3, b, fieldSize, b3), b2);
        return new ZTauElement(bigInteger.subtract(bigIntegerAdd.multiply(zTauElementM16379round.f22155u)).subtract(bigIntegerArrM16303getSi[1].multiply(zTauElementM16379round.f22156v).shiftLeft(1)), bigIntegerArrM16303getSi[1].multiply(zTauElementM16379round.f22155u).subtract(bigIntegerArrM16303getSi[0].multiply(zTauElementM16379round.f22156v)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
    
        if (r5.compareTo(r9) >= 0) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* renamed from: round */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ZTauElement m16379round(SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2, byte b) {
        SimpleBigDecimal simpleBigDecimalM16363add;
        SimpleBigDecimal simpleBigDecimalSubtract;
        if (simpleBigDecimal2.getScale() != simpleBigDecimal.getScale()) {
            throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
        }
        int i = -1;
        int i2 = 1;
        if (b != 1 && b != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger bigIntegerM16369round = simpleBigDecimal.m16369round();
        BigInteger bigIntegerM16369round2 = simpleBigDecimal2.m16369round();
        SimpleBigDecimal simpleBigDecimalSubtract2 = simpleBigDecimal.subtract(bigIntegerM16369round);
        SimpleBigDecimal simpleBigDecimalSubtract3 = simpleBigDecimal2.subtract(bigIntegerM16369round2);
        SimpleBigDecimal simpleBigDecimalM16363add2 = simpleBigDecimalSubtract2.m16363add(simpleBigDecimalSubtract2);
        SimpleBigDecimal simpleBigDecimalM16363add3 = b == 1 ? simpleBigDecimalM16363add2.m16363add(simpleBigDecimalSubtract3) : simpleBigDecimalM16363add2.subtract(simpleBigDecimalSubtract3);
        SimpleBigDecimal simpleBigDecimalM16363add4 = simpleBigDecimalSubtract3.m16363add(simpleBigDecimalSubtract3).m16363add(simpleBigDecimalSubtract3);
        SimpleBigDecimal simpleBigDecimalM16363add5 = simpleBigDecimalM16363add4.m16363add(simpleBigDecimalSubtract3);
        if (b == 1) {
            simpleBigDecimalM16363add = simpleBigDecimalSubtract2.subtract(simpleBigDecimalM16363add4);
            simpleBigDecimalSubtract = simpleBigDecimalSubtract2.m16363add(simpleBigDecimalM16363add5);
        } else {
            simpleBigDecimalM16363add = simpleBigDecimalSubtract2.m16363add(simpleBigDecimalM16363add4);
            simpleBigDecimalSubtract = simpleBigDecimalSubtract2.subtract(simpleBigDecimalM16363add5);
        }
        BigInteger bigInteger = ECConstants.f22091ONE;
        byte b2 = 0;
        if (simpleBigDecimalM16363add3.compareTo(bigInteger) >= 0) {
            if (simpleBigDecimalM16363add.compareTo(MINUS_ONE) < 0) {
                i2 = 0;
                b2 = b;
            }
        } else if (simpleBigDecimalSubtract.compareTo(ECConstants.f22093TWO) < 0) {
            i2 = 0;
        }
        if (simpleBigDecimalM16363add3.compareTo(MINUS_ONE) >= 0) {
            if (simpleBigDecimalSubtract.compareTo(MINUS_TWO) < 0) {
            }
            i = i2;
            return new ZTauElement(bigIntegerM16369round.add(BigInteger.valueOf(i)), bigIntegerM16369round2.add(BigInteger.valueOf(b2)));
        }
        b2 = (byte) (-b);
        i = i2;
        return new ZTauElement(bigIntegerM16369round.add(BigInteger.valueOf(i)), bigIntegerM16369round2.add(BigInteger.valueOf(b2)));
    }

    /* renamed from: tau */
    public static AbstractC5820ECPoint.AbstractF2m m16380tau(AbstractC5820ECPoint.AbstractF2m abstractF2m) {
        return abstractF2m.m16339tau();
    }

    public static byte[] tauAdicNaf(byte b, ZTauElement zTauElement) {
        if (b != 1 && b != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int iBitLength = m16377norm(b, zTauElement).bitLength();
        byte[] bArr = new byte[iBitLength > 30 ? iBitLength + 4 : 34];
        BigInteger bigIntegerClearBit = zTauElement.f22155u;
        BigInteger bigInteger = zTauElement.f22156v;
        int i = 0;
        int i2 = 0;
        while (true) {
            BigInteger bigInteger2 = ECConstants.f22094ZERO;
            if (bigIntegerClearBit.equals(bigInteger2) && bigInteger.equals(bigInteger2)) {
                int i3 = i + 1;
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                return bArr2;
            }
            if (bigIntegerClearBit.testBit(0)) {
                byte bIntValue = (byte) ECConstants.f22093TWO.subtract(bigIntegerClearBit.subtract(bigInteger.shiftLeft(1)).mod(ECConstants.f22090FOUR)).intValue();
                bArr[i2] = bIntValue;
                bigIntegerClearBit = bIntValue == 1 ? bigIntegerClearBit.clearBit(0) : bigIntegerClearBit.add(ECConstants.f22091ONE);
                i = i2;
            } else {
                bArr[i2] = 0;
            }
            BigInteger bigIntegerShiftRight = bigIntegerClearBit.shiftRight(1);
            BigInteger bigIntegerAdd = b == 1 ? bigInteger.add(bigIntegerShiftRight) : bigInteger.subtract(bigIntegerShiftRight);
            BigInteger bigIntegerNegate = bigIntegerClearBit.shiftRight(1).negate();
            i2++;
            bigIntegerClearBit = bigIntegerAdd;
            bigInteger = bigIntegerNegate;
        }
    }

    public static byte[] tauAdicWNaf(byte b, ZTauElement zTauElement, int i, int i2, ZTauElement[] zTauElementArr) {
        if (b != 1 && b != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int iBitLength = m16377norm(b, zTauElement).bitLength();
        byte[] bArr = new byte[iBitLength > 30 ? iBitLength + 4 + i : i + 34];
        int i3 = (1 << i) - 1;
        int i4 = 32 - i;
        BigInteger bigIntegerSubtract = zTauElement.f22155u;
        BigInteger bigIntegerSubtract2 = zTauElement.f22156v;
        int i5 = 0;
        while (true) {
            if (bigIntegerSubtract.bitLength() <= 62 && bigIntegerSubtract2.bitLength() <= 62) {
                break;
            }
            if (bigIntegerSubtract.testBit(0)) {
                int iIntValue = bigIntegerSubtract.intValue() + (bigIntegerSubtract2.intValue() * i2);
                int i6 = iIntValue & i3;
                bArr[i5] = (byte) ((iIntValue << i4) >> i4);
                bigIntegerSubtract = bigIntegerSubtract.subtract(zTauElementArr[i6].f22155u);
                bigIntegerSubtract2 = bigIntegerSubtract2.subtract(zTauElementArr[i6].f22156v);
            }
            i5++;
            BigInteger bigIntegerShiftRight = bigIntegerSubtract.shiftRight(1);
            BigInteger bigIntegerAdd = b == 1 ? bigIntegerSubtract2.add(bigIntegerShiftRight) : bigIntegerSubtract2.subtract(bigIntegerShiftRight);
            BigInteger bigIntegerNegate = bigIntegerShiftRight.negate();
            bigIntegerSubtract = bigIntegerAdd;
            bigIntegerSubtract2 = bigIntegerNegate;
        }
        long jLongValueExact = BigIntegers.longValueExact(bigIntegerSubtract);
        long jLongValueExact2 = BigIntegers.longValueExact(bigIntegerSubtract2);
        while ((jLongValueExact | jLongValueExact2) != 0) {
            if ((1 & jLongValueExact) != 0) {
                int i7 = ((int) jLongValueExact) + (((int) jLongValueExact2) * i2);
                int i8 = i7 & i3;
                bArr[i5] = (byte) ((i7 << i4) >> i4);
                jLongValueExact -= zTauElementArr[i8].f22155u.intValue();
                jLongValueExact2 -= zTauElementArr[i8].f22156v.intValue();
            }
            i5++;
            long j = jLongValueExact >> 1;
            long j2 = b == 1 ? jLongValueExact2 + j : jLongValueExact2 - j;
            long j3 = -j;
            jLongValueExact = j2;
            jLongValueExact2 = j3;
        }
        return bArr;
    }

    /* renamed from: getMu */
    public static byte m16372getMu(AbstractC5817ECCurve.AbstractF2m abstractF2m) {
        if (abstractF2m.isKoblitz()) {
            return abstractF2m.m16298getA().mo16315isZero() ? (byte) -1 : (byte) 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    /* renamed from: getSi */
    public static BigInteger[] m16375getSi(AbstractC5817ECCurve.AbstractF2m abstractF2m) {
        if (abstractF2m.isKoblitz()) {
            return m16374getSi(abstractF2m.getFieldSize(), abstractF2m.m16298getA().toBigInteger().intValue(), abstractF2m.getCofactor());
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    /* renamed from: norm */
    public static SimpleBigDecimal m16378norm(byte b, SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2) {
        SimpleBigDecimal simpleBigDecimalSubtract;
        SimpleBigDecimal simpleBigDecimalMultiply = simpleBigDecimal.multiply(simpleBigDecimal);
        SimpleBigDecimal simpleBigDecimalMultiply2 = simpleBigDecimal.multiply(simpleBigDecimal2);
        SimpleBigDecimal simpleBigDecimalShiftLeft = simpleBigDecimal2.multiply(simpleBigDecimal2).shiftLeft(1);
        if (b == 1) {
            simpleBigDecimalSubtract = simpleBigDecimalMultiply.m16363add(simpleBigDecimalMultiply2);
        } else {
            if (b != -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            simpleBigDecimalSubtract = simpleBigDecimalMultiply.subtract(simpleBigDecimalMultiply2);
        }
        return simpleBigDecimalSubtract.m16363add(simpleBigDecimalShiftLeft);
    }

    /* renamed from: getMu */
    public static byte m16373getMu(ECFieldElement eCFieldElement) {
        return (byte) (eCFieldElement.mo16315isZero() ? -1 : 1);
    }
}
