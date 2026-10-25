package org.bouncycastle.p284math.p285ec.p293tools;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class DiscoverEndomorphisms {

    /* renamed from: radix */
    private static final int f22474radix = 16;

    private static boolean areRelativelyPrime(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.gcd(bigInteger2).equals(ECConstants.f22091ONE);
    }

    private static BigInteger[] calculateRange(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return m16870order(bigInteger.subtract(bigInteger2).divide(bigInteger3), bigInteger.add(bigInteger2).divide(bigInteger3));
    }

    private static BigInteger[] chooseShortest(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        return isShorter(bigIntegerArr, bigIntegerArr2) ? bigIntegerArr : bigIntegerArr2;
    }

    private static void discoverEndomorphisms(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        if (byName != null || (byName = ECNamedCurveTable.getByName(str)) != null) {
            discoverEndomorphisms(byName, str);
            return;
        }
        System.err.println("Unknown curve: " + str);
    }

    private static List enumToList(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    private static BigInteger[] extEuclidBezout(BigInteger[] bigIntegerArr) {
        boolean z = bigIntegerArr[0].compareTo(bigIntegerArr[1]) < 0;
        if (z) {
            m16871swap(bigIntegerArr);
        }
        BigInteger bigInteger = bigIntegerArr[0];
        BigInteger bigInteger2 = bigIntegerArr[1];
        BigInteger bigInteger3 = ECConstants.f22091ONE;
        BigInteger bigInteger4 = ECConstants.f22094ZERO;
        BigInteger bigInteger5 = bigInteger3;
        BigInteger bigInteger6 = bigInteger4;
        BigInteger bigInteger7 = bigInteger2;
        BigInteger bigInteger8 = bigInteger;
        while (bigInteger7.compareTo(ECConstants.f22091ONE) > 0) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger8.divideAndRemainder(bigInteger7);
            BigInteger bigInteger9 = bigIntegerArrDivideAndRemainder[0];
            BigInteger bigInteger10 = bigIntegerArrDivideAndRemainder[1];
            BigInteger bigIntegerSubtract = bigInteger3.subtract(bigInteger9.multiply(bigInteger4));
            BigInteger bigIntegerSubtract2 = bigInteger6.subtract(bigInteger9.multiply(bigInteger5));
            BigInteger bigInteger11 = bigInteger7;
            bigInteger7 = bigInteger10;
            bigInteger8 = bigInteger11;
            BigInteger bigInteger12 = bigInteger4;
            bigInteger4 = bigIntegerSubtract;
            bigInteger3 = bigInteger12;
            bigInteger6 = bigInteger5;
            bigInteger5 = bigIntegerSubtract2;
        }
        if (bigInteger7.signum() <= 0) {
            return null;
        }
        BigInteger[] bigIntegerArr2 = {bigInteger4, bigInteger5};
        if (z) {
            m16871swap(bigIntegerArr2);
        }
        return bigIntegerArr2;
    }

    private static BigInteger[] extEuclidGLV(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = bigInteger2;
        BigInteger bigInteger5 = ECConstants.f22094ZERO;
        BigInteger bigInteger6 = ECConstants.f22091ONE;
        while (true) {
            BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger3.divideAndRemainder(bigInteger4);
            BigInteger bigInteger7 = bigIntegerArrDivideAndRemainder[0];
            BigInteger bigInteger8 = bigIntegerArrDivideAndRemainder[1];
            BigInteger bigIntegerSubtract = bigInteger5.subtract(bigInteger7.multiply(bigInteger6));
            if (isLessThanSqrt(bigInteger4, bigInteger)) {
                return new BigInteger[]{bigInteger3, bigInteger5, bigInteger4, bigInteger6, bigInteger8, bigIntegerSubtract};
            }
            bigInteger3 = bigInteger4;
            bigInteger5 = bigInteger6;
            bigInteger4 = bigInteger8;
            bigInteger6 = bigIntegerSubtract;
        }
    }

    private static ECFieldElement[] findNonTrivialOrder3FieldElements(AbstractC5817ECCurve abstractC5817ECCurve) {
        BigInteger bigIntegerModPow;
        BigInteger characteristic = abstractC5817ECCurve.getField().getCharacteristic();
        BigInteger bigIntegerDivide = characteristic.divide(ECConstants.f22092THREE);
        SecureRandom secureRandom = new SecureRandom();
        do {
            BigInteger bigInteger = ECConstants.f22093TWO;
            bigIntegerModPow = BigIntegers.createRandomInRange(bigInteger, characteristic.subtract(bigInteger), secureRandom).modPow(bigIntegerDivide, characteristic);
        } while (bigIntegerModPow.equals(ECConstants.f22091ONE));
        ECFieldElement eCFieldElementFromBigInteger = abstractC5817ECCurve.fromBigInteger(bigIntegerModPow);
        return new ECFieldElement[]{eCFieldElementFromBigInteger, eCFieldElementFromBigInteger.mo16318square()};
    }

    private static ECFieldElement[] findNonTrivialOrder4FieldElements(AbstractC5817ECCurve abstractC5817ECCurve) {
        ECFieldElement eCFieldElementMo16317sqrt = abstractC5817ECCurve.fromBigInteger(ECConstants.f22091ONE).mo16316negate().mo16317sqrt();
        if (eCFieldElementMo16317sqrt != null) {
            return new ECFieldElement[]{eCFieldElementMo16317sqrt, eCFieldElementMo16317sqrt.mo16316negate()};
        }
        throw new IllegalStateException("Calculation of non-trivial order-4  field elements failed unexpectedly");
    }

    private static BigInteger firstNonResidue(BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i = 2; i < 1000; i++) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(i);
            if (!bigIntegerValueOf.modPow(bigInteger2, bigInteger).equals(ECConstants.f22091ONE)) {
                return bigIntegerValueOf;
            }
        }
        throw new IllegalStateException();
    }

    private static BigInteger[] intersect(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        BigInteger bigIntegerMax = bigIntegerArr[0].max(bigIntegerArr2[0]);
        BigInteger bigIntegerMin = bigIntegerArr[1].min(bigIntegerArr2[1]);
        if (bigIntegerMax.compareTo(bigIntegerMin) > 0) {
            return null;
        }
        return new BigInteger[]{bigIntegerMax, bigIntegerMin};
    }

    private static boolean isLessThanSqrt(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        int iBitLength = bigIntegerAbs2.bitLength();
        int iBitLength2 = bigIntegerAbs.bitLength() * 2;
        return iBitLength2 + (-1) <= iBitLength && (iBitLength2 < iBitLength || bigIntegerAbs.multiply(bigIntegerAbs).compareTo(bigIntegerAbs2) < 0);
    }

    private static boolean isShorter(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        BigInteger bigIntegerAbs = bigIntegerArr[0].abs();
        BigInteger bigIntegerAbs2 = bigIntegerArr[1].abs();
        BigInteger bigIntegerAbs3 = bigIntegerArr2[0].abs();
        BigInteger bigIntegerAbs4 = bigIntegerArr2[1].abs();
        boolean z = bigIntegerAbs.compareTo(bigIntegerAbs3) < 0;
        return z == (bigIntegerAbs2.compareTo(bigIntegerAbs4) < 0) ? z : bigIntegerAbs.multiply(bigIntegerAbs).add(bigIntegerAbs2.multiply(bigIntegerAbs2)).compareTo(bigIntegerAbs3.multiply(bigIntegerAbs3).add(bigIntegerAbs4.multiply(bigIntegerAbs4))) < 0;
    }

    private static boolean isVectorBoundedBySqrt(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        return isLessThanSqrt(bigIntegerArr[0].abs().max(bigIntegerArr[1].abs()), bigInteger);
    }

    /* renamed from: isqrt */
    private static BigInteger m16867isqrt(BigInteger bigInteger) {
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(bigInteger.bitLength() / 2);
        while (true) {
            BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight.add(bigInteger.divide(bigIntegerShiftRight)).shiftRight(1);
            if (bigIntegerShiftRight2.equals(bigIntegerShiftRight)) {
                return bigIntegerShiftRight2;
            }
            bigIntegerShiftRight = bigIntegerShiftRight2;
        }
    }

    /* renamed from: main */
    public static void m16868main(String[] strArr) {
        if (strArr.length > 0) {
            for (String str : strArr) {
                discoverEndomorphisms(str);
            }
            return;
        }
        TreeSet treeSet = new TreeSet(enumToList(ECNamedCurveTable.getNames()));
        treeSet.addAll(enumToList(CustomNamedCurves.getNames()));
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            discoverEndomorphisms((String) it.next());
        }
    }

    /* renamed from: modSqrt */
    private static BigInteger m16869modSqrt(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger2.testBit(0)) {
            throw new IllegalStateException();
        }
        BigInteger bigInteger3 = ECConstants.f22091ONE;
        BigInteger bigIntegerShiftRight = bigInteger2.subtract(bigInteger3).shiftRight(1);
        if (!bigInteger.modPow(bigIntegerShiftRight, bigInteger2).equals(bigInteger3)) {
            return null;
        }
        BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight;
        while (!bigIntegerShiftRight2.testBit(0)) {
            bigIntegerShiftRight2 = bigIntegerShiftRight2.shiftRight(1);
            if (!bigInteger.modPow(bigIntegerShiftRight2, bigInteger2).equals(ECConstants.f22091ONE)) {
                return modSqrtComplex(bigInteger, bigIntegerShiftRight2, bigInteger2, bigIntegerShiftRight);
            }
        }
        return bigInteger.modPow(bigIntegerShiftRight2.add(ECConstants.f22091ONE).shiftRight(1), bigInteger2);
    }

    private static BigInteger modSqrtComplex(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        BigInteger bigIntegerFirstNonResidue = firstNonResidue(bigInteger3, bigInteger4);
        BigInteger bigIntegerShiftRight = bigInteger4;
        while (!bigInteger2.testBit(0)) {
            bigInteger2 = bigInteger2.shiftRight(1);
            bigIntegerShiftRight = bigIntegerShiftRight.shiftRight(1);
            if (!bigInteger.modPow(bigInteger2, bigInteger3).equals(bigIntegerFirstNonResidue.modPow(bigIntegerShiftRight, bigInteger3))) {
                bigIntegerShiftRight = bigIntegerShiftRight.add(bigInteger4);
            }
        }
        return bigInteger.modInverse(bigInteger3).modPow(bigInteger2.subtract(ECConstants.f22091ONE).shiftRight(1), bigInteger3).multiply(bigIntegerFirstNonResidue.modPow(bigIntegerShiftRight.shiftRight(1), bigInteger3)).mod(bigInteger3);
    }

    /* renamed from: order */
    private static BigInteger[] m16870order(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(bigInteger2) <= 0 ? new BigInteger[]{bigInteger, bigInteger2} : new BigInteger[]{bigInteger2, bigInteger};
    }

    private static void printGLVTypeAParameters(X9ECParameters x9ECParameters) {
        BigInteger bigIntegerM14737getN = x9ECParameters.m14737getN();
        BigInteger bigInteger = ECConstants.f22091ONE;
        BigInteger[] bigIntegerArrSolveQuadraticEquation = solveQuadraticEquation(bigIntegerM14737getN, bigInteger, ECConstants.f22094ZERO, bigInteger);
        ECFieldElement[] eCFieldElementArrFindNonTrivialOrder4FieldElements = findNonTrivialOrder4FieldElements(x9ECParameters.getCurve());
        printGLVTypeAParameters(x9ECParameters, bigIntegerArrSolveQuadraticEquation[0], eCFieldElementArrFindNonTrivialOrder4FieldElements);
        System.out.println("OR");
        printGLVTypeAParameters(x9ECParameters, bigIntegerArrSolveQuadraticEquation[1], eCFieldElementArrFindNonTrivialOrder4FieldElements);
    }

    private static void printGLVTypeBParameters(X9ECParameters x9ECParameters) {
        BigInteger bigIntegerM14737getN = x9ECParameters.m14737getN();
        BigInteger bigInteger = ECConstants.f22091ONE;
        BigInteger[] bigIntegerArrSolveQuadraticEquation = solveQuadraticEquation(bigIntegerM14737getN, bigInteger, bigInteger, bigInteger);
        ECFieldElement[] eCFieldElementArrFindNonTrivialOrder3FieldElements = findNonTrivialOrder3FieldElements(x9ECParameters.getCurve());
        printGLVTypeBParameters(x9ECParameters, bigIntegerArrSolveQuadraticEquation[0], eCFieldElementArrFindNonTrivialOrder3FieldElements);
        System.out.println("OR");
        printGLVTypeBParameters(x9ECParameters, bigIntegerArrSolveQuadraticEquation[1], eCFieldElementArrFindNonTrivialOrder3FieldElements);
    }

    private static void printProperty(String str, Object obj) {
        StringBuilder sb = new StringBuilder("  ");
        sb.append(str);
        while (sb.length() < 20) {
            sb.append(' ');
        }
        sb.append(": ");
        sb.append(obj.toString());
        System.out.println(sb.toString());
    }

    private static void printScalarDecompositionParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger[] bigIntegerArrExtEuclidGLV = extEuclidGLV(bigInteger, bigInteger2);
        BigInteger[] bigIntegerArr = {bigIntegerArrExtEuclidGLV[2], bigIntegerArrExtEuclidGLV[3].negate()};
        BigInteger[] bigIntegerArrChooseShortest = chooseShortest(new BigInteger[]{bigIntegerArrExtEuclidGLV[0], bigIntegerArrExtEuclidGLV[1].negate()}, new BigInteger[]{bigIntegerArrExtEuclidGLV[4], bigIntegerArrExtEuclidGLV[5].negate()});
        if (!isVectorBoundedBySqrt(bigIntegerArrChooseShortest, bigInteger) && areRelativelyPrime(bigIntegerArr[0], bigIntegerArr[1])) {
            BigInteger bigInteger3 = bigIntegerArr[0];
            BigInteger bigInteger4 = bigIntegerArr[1];
            BigInteger bigIntegerDivide = bigInteger3.add(bigInteger4.multiply(bigInteger2)).divide(bigInteger);
            BigInteger[] bigIntegerArrExtEuclidBezout = extEuclidBezout(new BigInteger[]{bigIntegerDivide.abs(), bigInteger4.abs()});
            if (bigIntegerArrExtEuclidBezout != null) {
                BigInteger bigIntegerNegate = bigIntegerArrExtEuclidBezout[0];
                BigInteger bigIntegerNegate2 = bigIntegerArrExtEuclidBezout[1];
                if (bigIntegerDivide.signum() < 0) {
                    bigIntegerNegate = bigIntegerNegate.negate();
                }
                if (bigInteger4.signum() > 0) {
                    bigIntegerNegate2 = bigIntegerNegate2.negate();
                }
                BigInteger bigIntegerSubtract = bigIntegerDivide.multiply(bigIntegerNegate).subtract(bigInteger4.multiply(bigIntegerNegate2));
                BigInteger bigInteger5 = ECConstants.f22091ONE;
                if (!bigIntegerSubtract.equals(bigInteger5)) {
                    throw new IllegalStateException();
                }
                BigInteger bigIntegerSubtract2 = bigIntegerNegate2.multiply(bigInteger).subtract(bigIntegerNegate.multiply(bigInteger2));
                BigInteger bigIntegerNegate3 = bigIntegerNegate.negate();
                BigInteger bigIntegerNegate4 = bigIntegerSubtract2.negate();
                BigInteger bigIntegerAdd = m16867isqrt(bigInteger.subtract(bigInteger5)).add(bigInteger5);
                BigInteger[] bigIntegerArrIntersect = intersect(calculateRange(bigIntegerNegate3, bigIntegerAdd, bigInteger4), calculateRange(bigIntegerNegate4, bigIntegerAdd, bigInteger3));
                if (bigIntegerArrIntersect != null) {
                    for (BigInteger bigIntegerAdd2 = bigIntegerArrIntersect[0]; bigIntegerAdd2.compareTo(bigIntegerArrIntersect[1]) <= 0; bigIntegerAdd2 = bigIntegerAdd2.add(ECConstants.f22091ONE)) {
                        BigInteger[] bigIntegerArr2 = {bigIntegerSubtract2.add(bigIntegerAdd2.multiply(bigInteger3)), bigIntegerNegate.add(bigIntegerAdd2.multiply(bigInteger4))};
                        if (isShorter(bigIntegerArr2, bigIntegerArrChooseShortest)) {
                            bigIntegerArrChooseShortest = bigIntegerArr2;
                        }
                    }
                }
            }
        }
        BigInteger bigIntegerSubtract3 = bigIntegerArr[0].multiply(bigIntegerArrChooseShortest[1]).subtract(bigIntegerArr[1].multiply(bigIntegerArrChooseShortest[0]));
        int iBitLength = (bigInteger.bitLength() + 16) - (bigInteger.bitLength() & 7);
        BigInteger bigIntegerRoundQuotient = roundQuotient(bigIntegerArrChooseShortest[1].shiftLeft(iBitLength), bigIntegerSubtract3);
        BigInteger bigIntegerNegate5 = roundQuotient(bigIntegerArr[1].shiftLeft(iBitLength), bigIntegerSubtract3).negate();
        printProperty("v1", "{ " + bigIntegerArr[0].toString(16) + ", " + bigIntegerArr[1].toString(16) + " }");
        printProperty("v2", "{ " + bigIntegerArrChooseShortest[0].toString(16) + ", " + bigIntegerArrChooseShortest[1].toString(16) + " }");
        printProperty("d", bigIntegerSubtract3.toString(16));
        printProperty("(OPT) g1", bigIntegerRoundQuotient.toString(16));
        printProperty("(OPT) g2", bigIntegerNegate5.toString(16));
        printProperty("(OPT) bits", Integer.toString(iBitLength));
    }

    private static BigInteger roundQuotient(BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() != bigInteger2.signum();
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        BigInteger bigIntegerDivide = bigIntegerAbs.add(bigIntegerAbs2.shiftRight(1)).divide(bigIntegerAbs2);
        return z ? bigIntegerDivide.negate() : bigIntegerDivide;
    }

    private static BigInteger[] solveQuadraticEquation(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        BigInteger bigIntegerM16869modSqrt = m16869modSqrt(bigInteger3.multiply(bigInteger3).subtract(bigInteger2.multiply(bigInteger4).shiftLeft(2)).mod(bigInteger), bigInteger);
        if (bigIntegerM16869modSqrt == null) {
            throw new IllegalStateException("Solving quadratic equation failed unexpectedly");
        }
        BigInteger bigIntegerModInverse = bigInteger2.shiftLeft(1).modInverse(bigInteger);
        return new BigInteger[]{bigIntegerM16869modSqrt.subtract(bigInteger3).multiply(bigIntegerModInverse).mod(bigInteger), bigIntegerM16869modSqrt.negate().subtract(bigInteger3).multiply(bigIntegerModInverse).mod(bigInteger)};
    }

    /* renamed from: swap */
    private static void m16871swap(BigInteger[] bigIntegerArr) {
        BigInteger bigInteger = bigIntegerArr[0];
        bigIntegerArr[0] = bigIntegerArr[1];
        bigIntegerArr[1] = bigInteger;
    }

    public static void discoverEndomorphisms(X9ECParameters x9ECParameters) {
        if (x9ECParameters == null) {
            throw new NullPointerException("x9");
        }
        discoverEndomorphisms(x9ECParameters, "<UNKNOWN>");
    }

    private static void printGLVTypeAParameters(X9ECParameters x9ECParameters, BigInteger bigInteger, ECFieldElement[] eCFieldElementArr) {
        AbstractC5820ECPoint abstractC5820ECPointNormalize = x9ECParameters.m14735getG().normalize();
        AbstractC5820ECPoint abstractC5820ECPointNormalize2 = abstractC5820ECPointNormalize.multiply(bigInteger).normalize();
        if (!abstractC5820ECPointNormalize.getXCoord().mo16316negate().equals(abstractC5820ECPointNormalize2.getXCoord())) {
            throw new IllegalStateException("Derivation of GLV Type A parameters failed unexpectedly");
        }
        ECFieldElement eCFieldElement = eCFieldElementArr[0];
        if (!abstractC5820ECPointNormalize.getYCoord().multiply(eCFieldElement).equals(abstractC5820ECPointNormalize2.getYCoord())) {
            eCFieldElement = eCFieldElementArr[1];
            if (!abstractC5820ECPointNormalize.getYCoord().multiply(eCFieldElement).equals(abstractC5820ECPointNormalize2.getYCoord())) {
                throw new IllegalStateException("Derivation of GLV Type A parameters failed unexpectedly");
            }
        }
        printProperty("Point map", "lambda * (x, y) = (-x, i * y)");
        printProperty("i", eCFieldElement.toBigInteger().toString(16));
        printProperty("lambda", bigInteger.toString(16));
        printScalarDecompositionParameters(x9ECParameters.m14737getN(), bigInteger);
    }

    private static void printGLVTypeBParameters(X9ECParameters x9ECParameters, BigInteger bigInteger, ECFieldElement[] eCFieldElementArr) {
        AbstractC5820ECPoint abstractC5820ECPointNormalize = x9ECParameters.m14735getG().normalize();
        AbstractC5820ECPoint abstractC5820ECPointNormalize2 = abstractC5820ECPointNormalize.multiply(bigInteger).normalize();
        if (!abstractC5820ECPointNormalize.getYCoord().equals(abstractC5820ECPointNormalize2.getYCoord())) {
            throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
        }
        ECFieldElement eCFieldElement = eCFieldElementArr[0];
        if (!abstractC5820ECPointNormalize.getXCoord().multiply(eCFieldElement).equals(abstractC5820ECPointNormalize2.getXCoord())) {
            eCFieldElement = eCFieldElementArr[1];
            if (!abstractC5820ECPointNormalize.getXCoord().multiply(eCFieldElement).equals(abstractC5820ECPointNormalize2.getXCoord())) {
                throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
            }
        }
        printProperty("Point map", "lambda * (x, y) = (beta * x, y)");
        printProperty("beta", eCFieldElement.toBigInteger().toString(16));
        printProperty("lambda", bigInteger.toString(16));
        printScalarDecompositionParameters(x9ECParameters.m14737getN(), bigInteger);
    }

    private static void discoverEndomorphisms(X9ECParameters x9ECParameters, String str) {
        AbstractC5817ECCurve curve = x9ECParameters.getCurve();
        if (ECAlgorithms.isFpCurve(curve)) {
            BigInteger characteristic = curve.getField().getCharacteristic();
            if (curve.m16299getB().mo16315isZero() && characteristic.mod(ECConstants.f22090FOUR).equals(ECConstants.f22091ONE)) {
                System.out.println("Curve '" + str + "' has a 'GLV Type A' endomorphism with these parameters:");
                printGLVTypeAParameters(x9ECParameters);
            }
            if (curve.m16298getA().mo16315isZero() && characteristic.mod(ECConstants.f22092THREE).equals(ECConstants.f22091ONE)) {
                System.out.println("Curve '" + str + "' has a 'GLV Type B' endomorphism with these parameters:");
                printGLVTypeBParameters(x9ECParameters);
            }
        }
    }
}
