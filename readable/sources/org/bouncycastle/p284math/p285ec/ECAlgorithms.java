package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.p290endo.ECEndomorphism;
import org.bouncycastle.p284math.p285ec.p290endo.EndoUtil;
import org.bouncycastle.p284math.p285ec.p290endo.GLVEndomorphism;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;

/* loaded from: classes2.dex */
public class ECAlgorithms {
    public static AbstractC5820ECPoint cleanPoint(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5817ECCurve.m16297equals(abstractC5820ECPoint.getCurve())) {
            return abstractC5817ECCurve.decodePoint(abstractC5820ECPoint.getEncoded(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static AbstractC5820ECPoint implCheckResult(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint.isValidPartial()) {
            return abstractC5820ECPoint;
        }
        throw new IllegalStateException("Invalid result");
    }

    private static AbstractC5820ECPoint implShamirsTrickFixedPoint(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint2, BigInteger bigInteger2) {
        AbstractC5820ECPoint abstractC5820ECPointMo16330add;
        AbstractC5820ECPoint offset;
        AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        int combSize = FixedPointUtil.getCombSize(curve);
        if (bigInteger.bitLength() > combSize || bigInteger2.bitLength() > combSize) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        FixedPointPreCompInfo fixedPointPreCompInfoPrecompute = FixedPointUtil.precompute(abstractC5820ECPoint);
        FixedPointPreCompInfo fixedPointPreCompInfoPrecompute2 = FixedPointUtil.precompute(abstractC5820ECPoint2);
        ECLookupTable lookupTable = fixedPointPreCompInfoPrecompute.getLookupTable();
        ECLookupTable lookupTable2 = fixedPointPreCompInfoPrecompute2.getLookupTable();
        int width = fixedPointPreCompInfoPrecompute.getWidth();
        if (width != fixedPointPreCompInfoPrecompute2.getWidth()) {
            FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
            abstractC5820ECPointMo16330add = fixedPointCombMultiplier.multiply(abstractC5820ECPoint, bigInteger);
            offset = fixedPointCombMultiplier.multiply(abstractC5820ECPoint2, bigInteger2);
        } else {
            int i = ((combSize + width) - 1) / width;
            AbstractC5820ECPoint infinity = curve.getInfinity();
            int i2 = width * i;
            int[] iArrFromBigInteger = AbstractC5869Nat.fromBigInteger(i2, bigInteger);
            int[] iArrFromBigInteger2 = AbstractC5869Nat.fromBigInteger(i2, bigInteger2);
            int i3 = i2 - 1;
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = 0;
                int i6 = 0;
                for (int i7 = i3 - i4; i7 >= 0; i7 -= i) {
                    int i8 = i7 >>> 5;
                    int i9 = i7 & 31;
                    int i10 = iArrFromBigInteger[i8] >>> i9;
                    i5 = ((i5 ^ (i10 >>> 1)) << 1) ^ i10;
                    int i11 = iArrFromBigInteger2[i8] >>> i9;
                    i6 = ((i6 ^ (i11 >>> 1)) << 1) ^ i11;
                }
                infinity = infinity.twicePlus(lookupTable.lookupVar(i5).mo16330add(lookupTable2.lookupVar(i6)));
            }
            abstractC5820ECPointMo16330add = infinity.mo16330add(fixedPointPreCompInfoPrecompute.getOffset());
            offset = fixedPointPreCompInfoPrecompute2.getOffset();
        }
        return abstractC5820ECPointMo16330add.mo16330add(offset);
    }

    public static AbstractC5820ECPoint implShamirsTrickJsf(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint2, BigInteger bigInteger2) {
        AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        AbstractC5820ECPoint infinity = curve.getInfinity();
        AbstractC5820ECPoint[] abstractC5820ECPointArr = {abstractC5820ECPoint2, abstractC5820ECPoint.subtract(abstractC5820ECPoint2), abstractC5820ECPoint, abstractC5820ECPoint.mo16330add(abstractC5820ECPoint2)};
        curve.normalizeAll(abstractC5820ECPointArr);
        AbstractC5820ECPoint[] abstractC5820ECPointArr2 = {abstractC5820ECPointArr[3].mo16335negate(), abstractC5820ECPointArr[2].mo16335negate(), abstractC5820ECPointArr[1].mo16335negate(), abstractC5820ECPointArr[0].mo16335negate(), infinity, abstractC5820ECPointArr[0], abstractC5820ECPointArr[1], abstractC5820ECPointArr[2], abstractC5820ECPointArr[3]};
        byte[] bArrGenerateJSF = WNafUtil.generateJSF(bigInteger, bigInteger2);
        int length = bArrGenerateJSF.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            byte b = bArrGenerateJSF[length];
            infinity = infinity.twicePlus(abstractC5820ECPointArr2[(((b << 24) >> 28) * 3) + 4 + ((b << 28) >> 28)]);
        }
    }

    public static AbstractC5820ECPoint implShamirsTrickWNaf(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint2, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() < 0;
        boolean z2 = bigInteger2.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        int windowSize = WNafUtil.getWindowSize(bigIntegerAbs.bitLength(), 8);
        int windowSize2 = WNafUtil.getWindowSize(bigIntegerAbs2.bitLength(), 8);
        WNafPreCompInfo wNafPreCompInfoPrecompute = WNafUtil.precompute(abstractC5820ECPoint, windowSize, true);
        WNafPreCompInfo wNafPreCompInfoPrecompute2 = WNafUtil.precompute(abstractC5820ECPoint2, windowSize2, true);
        int combSize = FixedPointUtil.getCombSize(abstractC5820ECPoint.getCurve());
        if (!z && !z2 && bigInteger.bitLength() <= combSize && bigInteger2.bitLength() <= combSize && wNafPreCompInfoPrecompute.isPromoted() && wNafPreCompInfoPrecompute2.isPromoted()) {
            return implShamirsTrickFixedPoint(abstractC5820ECPoint, bigInteger, abstractC5820ECPoint2, bigInteger2);
        }
        int iMin = Math.min(8, wNafPreCompInfoPrecompute.getWidth());
        int iMin2 = Math.min(8, wNafPreCompInfoPrecompute2.getWidth());
        return implShamirsTrickWNaf(z ? wNafPreCompInfoPrecompute.getPreCompNeg() : wNafPreCompInfoPrecompute.getPreComp(), z ? wNafPreCompInfoPrecompute.getPreComp() : wNafPreCompInfoPrecompute.getPreCompNeg(), WNafUtil.generateWindowNaf(iMin, bigIntegerAbs), z2 ? wNafPreCompInfoPrecompute2.getPreCompNeg() : wNafPreCompInfoPrecompute2.getPreComp(), z2 ? wNafPreCompInfoPrecompute2.getPreComp() : wNafPreCompInfoPrecompute2.getPreCompNeg(), WNafUtil.generateWindowNaf(iMin2, bigIntegerAbs2));
    }

    public static AbstractC5820ECPoint implSumOfMultiplies(ECEndomorphism eCEndomorphism, AbstractC5820ECPoint[] abstractC5820ECPointArr, BigInteger[] bigIntegerArr) {
        AbstractC5820ECPoint[] abstractC5820ECPointArr2 = abstractC5820ECPointArr;
        int length = abstractC5820ECPointArr2.length;
        int i = length << 1;
        boolean[] zArr = new boolean[i];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[i];
        byte[][] bArr = new byte[i][];
        ECPointMap pointMap = eCEndomorphism.getPointMap();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 << 1;
            int i4 = i3 + 1;
            BigInteger bigInteger = bigIntegerArr[i3];
            zArr[i3] = bigInteger.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i4];
            zArr[i4] = bigInteger2.signum() < 0;
            BigInteger bigIntegerAbs2 = bigInteger2.abs();
            int windowSize = WNafUtil.getWindowSize(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8);
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr2[i2];
            WNafPreCompInfo wNafPreCompInfoPrecompute = WNafUtil.precompute(abstractC5820ECPoint, windowSize, true);
            WNafPreCompInfo wNafPreCompInfoPrecomputeWithPointMap = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(eCEndomorphism, abstractC5820ECPoint), pointMap, wNafPreCompInfoPrecompute, true);
            int iMin = Math.min(8, wNafPreCompInfoPrecompute.getWidth());
            int iMin2 = Math.min(8, wNafPreCompInfoPrecomputeWithPointMap.getWidth());
            wNafPreCompInfoArr[i3] = wNafPreCompInfoPrecompute;
            wNafPreCompInfoArr[i4] = wNafPreCompInfoPrecomputeWithPointMap;
            bArr[i3] = WNafUtil.generateWindowNaf(iMin, bigIntegerAbs);
            bArr[i4] = WNafUtil.generateWindowNaf(iMin2, bigIntegerAbs2);
            i2++;
            abstractC5820ECPointArr2 = abstractC5820ECPointArr;
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    public static AbstractC5820ECPoint implSumOfMultipliesGLV(AbstractC5820ECPoint[] abstractC5820ECPointArr, BigInteger[] bigIntegerArr, GLVEndomorphism gLVEndomorphism) {
        BigInteger order = abstractC5820ECPointArr[0].getCurve().getOrder();
        int length = abstractC5820ECPointArr.length;
        int i = length << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            BigInteger[] bigIntegerArrDecomposeScalar = gLVEndomorphism.decomposeScalar(bigIntegerArr[i3].mod(order));
            int i4 = i2 + 1;
            bigIntegerArr2[i2] = bigIntegerArrDecomposeScalar[0];
            i2 += 2;
            bigIntegerArr2[i4] = bigIntegerArrDecomposeScalar[1];
        }
        if (gLVEndomorphism.hasEfficientPointMap()) {
            return implSumOfMultiplies(gLVEndomorphism, abstractC5820ECPointArr, bigIntegerArr2);
        }
        AbstractC5820ECPoint[] abstractC5820ECPointArr2 = new AbstractC5820ECPoint[i];
        int i5 = 0;
        for (AbstractC5820ECPoint abstractC5820ECPoint : abstractC5820ECPointArr) {
            AbstractC5820ECPoint abstractC5820ECPointMapPoint = EndoUtil.mapPoint(gLVEndomorphism, abstractC5820ECPoint);
            int i6 = i5 + 1;
            abstractC5820ECPointArr2[i5] = abstractC5820ECPoint;
            i5 += 2;
            abstractC5820ECPointArr2[i6] = abstractC5820ECPointMapPoint;
        }
        return implSumOfMultiplies(abstractC5820ECPointArr2, bigIntegerArr2);
    }

    public static AbstractC5820ECPoint importPoint(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5817ECCurve.m16297equals(abstractC5820ECPoint.getCurve())) {
            return abstractC5817ECCurve.importPoint(abstractC5820ECPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(AbstractC5817ECCurve abstractC5817ECCurve) {
        return isF2mField(abstractC5817ECCurve.getField());
    }

    public static boolean isF2mField(FiniteField finiteField) {
        return finiteField.getDimension() > 1 && finiteField.getCharacteristic().equals(ECConstants.f22093TWO) && (finiteField instanceof PolynomialExtensionField);
    }

    public static boolean isFpCurve(AbstractC5817ECCurve abstractC5817ECCurve) {
        return isFpField(abstractC5817ECCurve.getField());
    }

    public static boolean isFpField(FiniteField finiteField) {
        return finiteField.getDimension() == 1;
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i, int i2) {
        montgomeryTrick(eCFieldElementArr, i, i2, null);
    }

    public static AbstractC5820ECPoint referenceMultiply(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        AbstractC5820ECPoint infinity = abstractC5820ECPoint.getCurve().getInfinity();
        int iBitLength = bigIntegerAbs.bitLength();
        if (iBitLength > 0) {
            if (bigIntegerAbs.testBit(0)) {
                infinity = abstractC5820ECPoint;
            }
            for (int i = 1; i < iBitLength; i++) {
                abstractC5820ECPoint = abstractC5820ECPoint.mo16338twice();
                if (bigIntegerAbs.testBit(i)) {
                    infinity = infinity.mo16330add(abstractC5820ECPoint);
                }
            }
        }
        return bigInteger.signum() < 0 ? infinity.mo16335negate() : infinity;
    }

    public static AbstractC5820ECPoint shamirsTrick(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint2, BigInteger bigInteger2) {
        return implCheckResult(implShamirsTrickJsf(abstractC5820ECPoint, bigInteger, importPoint(abstractC5820ECPoint.getCurve(), abstractC5820ECPoint2), bigInteger2));
    }

    public static AbstractC5820ECPoint sumOfMultiplies(AbstractC5820ECPoint[] abstractC5820ECPointArr, BigInteger[] bigIntegerArr) {
        if (abstractC5820ECPointArr != null && bigIntegerArr != null && abstractC5820ECPointArr.length == bigIntegerArr.length) {
            if (abstractC5820ECPointArr.length >= 1) {
                int length = abstractC5820ECPointArr.length;
                if (length == 1) {
                    return abstractC5820ECPointArr[0].multiply(bigIntegerArr[0]);
                }
                if (length == 2) {
                    return sumOfTwoMultiplies(abstractC5820ECPointArr[0], bigIntegerArr[0], abstractC5820ECPointArr[1], bigIntegerArr[1]);
                }
                AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[0];
                AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
                AbstractC5820ECPoint[] abstractC5820ECPointArr2 = new AbstractC5820ECPoint[length];
                abstractC5820ECPointArr2[0] = abstractC5820ECPoint;
                for (int i = 1; i < length; i++) {
                    abstractC5820ECPointArr2[i] = importPoint(curve, abstractC5820ECPointArr[i]);
                }
                ECEndomorphism endomorphism = curve.getEndomorphism();
                return endomorphism instanceof GLVEndomorphism ? implCheckResult(implSumOfMultipliesGLV(abstractC5820ECPointArr2, bigIntegerArr, (GLVEndomorphism) endomorphism)) : implCheckResult(implSumOfMultiplies(abstractC5820ECPointArr2, bigIntegerArr));
            }
        }
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static AbstractC5820ECPoint sumOfTwoMultiplies(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint2, BigInteger bigInteger2) {
        AbstractC5820ECPoint abstractC5820ECPointImplSumOfMultipliesGLV;
        AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        AbstractC5820ECPoint abstractC5820ECPointImportPoint = importPoint(curve, abstractC5820ECPoint2);
        if ((curve instanceof AbstractC5817ECCurve.AbstractF2m) && ((AbstractC5817ECCurve.AbstractF2m) curve).isKoblitz()) {
            abstractC5820ECPointImplSumOfMultipliesGLV = abstractC5820ECPoint.multiply(bigInteger).mo16330add(abstractC5820ECPointImportPoint.multiply(bigInteger2));
        } else {
            ECEndomorphism endomorphism = curve.getEndomorphism();
            abstractC5820ECPointImplSumOfMultipliesGLV = endomorphism instanceof GLVEndomorphism ? implSumOfMultipliesGLV(new AbstractC5820ECPoint[]{abstractC5820ECPoint, abstractC5820ECPointImportPoint}, new BigInteger[]{bigInteger, bigInteger2}, (GLVEndomorphism) endomorphism) : implShamirsTrickWNaf(abstractC5820ECPoint, bigInteger, abstractC5820ECPointImportPoint, bigInteger2);
        }
        return implCheckResult(abstractC5820ECPointImplSumOfMultipliesGLV);
    }

    public static AbstractC5820ECPoint validatePoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint.m16334isValid()) {
            return abstractC5820ECPoint;
        }
        throw new IllegalStateException("Invalid point");
    }

    public static AbstractC5820ECPoint implShamirsTrickWNaf(ECEndomorphism eCEndomorphism, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z = bigInteger.signum() < 0;
        boolean z2 = bigInteger2.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger.abs();
        BigInteger bigIntegerAbs2 = bigInteger2.abs();
        WNafPreCompInfo wNafPreCompInfoPrecompute = WNafUtil.precompute(abstractC5820ECPoint, WNafUtil.getWindowSize(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8), true);
        WNafPreCompInfo wNafPreCompInfoPrecomputeWithPointMap = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(eCEndomorphism, abstractC5820ECPoint), eCEndomorphism.getPointMap(), wNafPreCompInfoPrecompute, true);
        int iMin = Math.min(8, wNafPreCompInfoPrecompute.getWidth());
        int iMin2 = Math.min(8, wNafPreCompInfoPrecomputeWithPointMap.getWidth());
        return implShamirsTrickWNaf(z ? wNafPreCompInfoPrecompute.getPreCompNeg() : wNafPreCompInfoPrecompute.getPreComp(), z ? wNafPreCompInfoPrecompute.getPreComp() : wNafPreCompInfoPrecompute.getPreCompNeg(), WNafUtil.generateWindowNaf(iMin, bigIntegerAbs), z2 ? wNafPreCompInfoPrecomputeWithPointMap.getPreCompNeg() : wNafPreCompInfoPrecomputeWithPointMap.getPreComp(), z2 ? wNafPreCompInfoPrecomputeWithPointMap.getPreComp() : wNafPreCompInfoPrecomputeWithPointMap.getPreCompNeg(), WNafUtil.generateWindowNaf(iMin2, bigIntegerAbs2));
    }

    public static AbstractC5820ECPoint implSumOfMultiplies(AbstractC5820ECPoint[] abstractC5820ECPointArr, BigInteger[] bigIntegerArr) {
        int length = abstractC5820ECPointArr.length;
        boolean[] zArr = new boolean[length];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[length];
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < length; i++) {
            BigInteger bigInteger = bigIntegerArr[i];
            zArr[i] = bigInteger.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            WNafPreCompInfo wNafPreCompInfoPrecompute = WNafUtil.precompute(abstractC5820ECPointArr[i], WNafUtil.getWindowSize(bigIntegerAbs.bitLength(), 8), true);
            int iMin = Math.min(8, wNafPreCompInfoPrecompute.getWidth());
            wNafPreCompInfoArr[i] = wNafPreCompInfoPrecompute;
            bArr[i] = WNafUtil.generateWindowNaf(iMin, bigIntegerAbs);
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i, int i2, ECFieldElement eCFieldElement) {
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i2];
        int i3 = 0;
        eCFieldElementArr2[0] = eCFieldElementArr[i];
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                break;
            }
            eCFieldElementArr2[i4] = eCFieldElementArr2[i3].multiply(eCFieldElementArr[i + i4]);
            i3 = i4;
        }
        if (eCFieldElement != null) {
            eCFieldElementArr2[i3] = eCFieldElementArr2[i3].multiply(eCFieldElement);
        }
        ECFieldElement eCFieldElementMo16313invert = eCFieldElementArr2[i3].mo16313invert();
        while (i3 > 0) {
            int i5 = i3 - 1;
            int i6 = i3 + i;
            ECFieldElement eCFieldElement2 = eCFieldElementArr[i6];
            eCFieldElementArr[i6] = eCFieldElementArr2[i5].multiply(eCFieldElementMo16313invert);
            eCFieldElementMo16313invert = eCFieldElementMo16313invert.multiply(eCFieldElement2);
            i3 = i5;
        }
        eCFieldElementArr[i] = eCFieldElementMo16313invert;
    }

    private static AbstractC5820ECPoint implShamirsTrickWNaf(AbstractC5820ECPoint[] abstractC5820ECPointArr, AbstractC5820ECPoint[] abstractC5820ECPointArr2, byte[] bArr, AbstractC5820ECPoint[] abstractC5820ECPointArr3, AbstractC5820ECPoint[] abstractC5820ECPointArr4, byte[] bArr2) {
        AbstractC5820ECPoint abstractC5820ECPointMo16330add;
        int iMax = Math.max(bArr.length, bArr2.length);
        AbstractC5820ECPoint infinity = abstractC5820ECPointArr[0].getCurve().getInfinity();
        int i = iMax - 1;
        int i2 = 0;
        AbstractC5820ECPoint abstractC5820ECPointTwicePlus = infinity;
        while (i >= 0) {
            byte b = i < bArr.length ? bArr[i] : (byte) 0;
            byte b2 = i < bArr2.length ? bArr2[i] : (byte) 0;
            if ((b | b2) == 0) {
                i2++;
            } else {
                if (b != 0) {
                    abstractC5820ECPointMo16330add = infinity.mo16330add((b < 0 ? abstractC5820ECPointArr2 : abstractC5820ECPointArr)[Math.abs((int) b) >>> 1]);
                } else {
                    abstractC5820ECPointMo16330add = infinity;
                }
                if (b2 != 0) {
                    abstractC5820ECPointMo16330add = abstractC5820ECPointMo16330add.mo16330add((b2 < 0 ? abstractC5820ECPointArr4 : abstractC5820ECPointArr3)[Math.abs((int) b2) >>> 1]);
                }
                if (i2 > 0) {
                    abstractC5820ECPointTwicePlus = abstractC5820ECPointTwicePlus.timesPow2(i2);
                    i2 = 0;
                }
                abstractC5820ECPointTwicePlus = abstractC5820ECPointTwicePlus.twicePlus(abstractC5820ECPointMo16330add);
            }
            i--;
        }
        return i2 > 0 ? abstractC5820ECPointTwicePlus.timesPow2(i2) : abstractC5820ECPointTwicePlus;
    }

    private static AbstractC5820ECPoint implSumOfMultiplies(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        int length = bArr.length;
        int iMax = 0;
        for (byte[] bArr2 : bArr) {
            iMax = Math.max(iMax, bArr2.length);
        }
        AbstractC5820ECPoint infinity = wNafPreCompInfoArr[0].getPreComp()[0].getCurve().getInfinity();
        int i = iMax - 1;
        int i2 = 0;
        AbstractC5820ECPoint abstractC5820ECPointTwicePlus = infinity;
        while (i >= 0) {
            AbstractC5820ECPoint abstractC5820ECPointMo16330add = infinity;
            for (int i3 = 0; i3 < length; i3++) {
                byte[] bArr3 = bArr[i3];
                byte b = i < bArr3.length ? bArr3[i] : (byte) 0;
                if (b != 0) {
                    int iAbs = Math.abs((int) b);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i3];
                    abstractC5820ECPointMo16330add = abstractC5820ECPointMo16330add.mo16330add(((b < 0) == zArr[i3] ? wNafPreCompInfo.getPreComp() : wNafPreCompInfo.getPreCompNeg())[iAbs >>> 1]);
                }
            }
            if (abstractC5820ECPointMo16330add == infinity) {
                i2++;
            } else {
                if (i2 > 0) {
                    abstractC5820ECPointTwicePlus = abstractC5820ECPointTwicePlus.timesPow2(i2);
                    i2 = 0;
                }
                abstractC5820ECPointTwicePlus = abstractC5820ECPointTwicePlus.twicePlus(abstractC5820ECPointMo16330add);
            }
            i--;
        }
        return i2 > 0 ? abstractC5820ECPointTwicePlus.timesPow2(i2) : abstractC5820ECPointTwicePlus;
    }
}
