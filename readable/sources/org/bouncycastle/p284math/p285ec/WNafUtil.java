package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class WNafUtil {
    private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = {13, 41, 121, 337, 897, 2305};
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final int[] EMPTY_INTS = new int[0];
    private static final AbstractC5820ECPoint[] EMPTY_POINTS = new AbstractC5820ECPoint[0];
    private static final int MAX_WIDTH = 16;
    public static final String PRECOMP_NAME = "bc_wnaf";

    public static void configureBasepoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        if (curve == null) {
            return;
        }
        BigInteger order = curve.getOrder();
        final int iMin = Math.min(16, getWindowSize(order == null ? curve.getFieldSize() + 1 : order.bitLength()) + 3);
        curve.precompute(abstractC5820ECPoint, PRECOMP_NAME, new PreCompCallback() { // from class: org.bouncycastle.math.ec.WNafUtil.1
            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                WNafPreCompInfo wNafPreCompInfo = preCompInfo instanceof WNafPreCompInfo ? (WNafPreCompInfo) preCompInfo : null;
                if (wNafPreCompInfo != null && wNafPreCompInfo.getConfWidth() == iMin) {
                    wNafPreCompInfo.setPromotionCountdown(0);
                    return wNafPreCompInfo;
                }
                WNafPreCompInfo wNafPreCompInfo2 = new WNafPreCompInfo();
                wNafPreCompInfo2.setPromotionCountdown(0);
                wNafPreCompInfo2.setConfWidth(iMin);
                if (wNafPreCompInfo != null) {
                    wNafPreCompInfo2.setPreComp(wNafPreCompInfo.getPreComp());
                    wNafPreCompInfo2.setPreCompNeg(wNafPreCompInfo.getPreCompNeg());
                    wNafPreCompInfo2.setTwice(wNafPreCompInfo.getTwice());
                    wNafPreCompInfo2.setWidth(wNafPreCompInfo.getWidth());
                }
                return wNafPreCompInfo2;
            }
        });
    }

    public static int[] generateCompactNaf(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (bigInteger.signum() == 0) {
            return EMPTY_INTS;
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength();
        int i = iBitLength >> 1;
        int[] iArr = new int[i];
        BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
        int i2 = iBitLength - 1;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i4 < i2) {
            if (bigIntegerXor.testBit(i4)) {
                iArr[i3] = i5 | ((bigInteger.testBit(i4) ? -1 : 1) << 16);
                i4++;
                i5 = 1;
                i3++;
            } else {
                i5++;
            }
            i4++;
        }
        int i6 = i3 + 1;
        iArr[i3] = 65536 | i5;
        return i > i6 ? m16382trim(iArr, i6) : iArr;
    }

    public static int[] generateCompactWindowNaf(int i, BigInteger bigInteger) {
        if (i == 2) {
            return generateCompactNaf(bigInteger);
        }
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        }
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (bigInteger.signum() == 0) {
            return EMPTY_INTS;
        }
        int iBitLength = (bigInteger.bitLength() / i) + 1;
        int[] iArr = new int[iBitLength];
        int i2 = 1 << i;
        int i3 = i2 - 1;
        int i4 = i2 >>> 1;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i5 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i5) == z) {
                i5++;
            } else {
                bigInteger = bigInteger.shiftRight(i5);
                int iIntValue = bigInteger.intValue() & i3;
                if (z) {
                    iIntValue++;
                }
                z = (iIntValue & i4) != 0;
                if (z) {
                    iIntValue -= i2;
                }
                if (i6 > 0) {
                    i5--;
                }
                iArr[i6] = i5 | (iIntValue << 16);
                i5 = i;
                i6++;
            }
        }
        return iBitLength > i6 ? m16382trim(iArr, i6) : iArr;
    }

    public static byte[] generateJSF(BigInteger bigInteger, BigInteger bigInteger2) {
        int iMax = Math.max(bigInteger.bitLength(), bigInteger2.bitLength()) + 1;
        byte[] bArr = new byte[iMax];
        BigInteger bigIntegerShiftRight = bigInteger;
        BigInteger bigIntegerShiftRight2 = bigInteger2;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if ((i | i2) == 0 && bigIntegerShiftRight.bitLength() <= i3 && bigIntegerShiftRight2.bitLength() <= i3) {
                break;
            }
            int iIntValue = (bigIntegerShiftRight.intValue() >>> i3) + i;
            int i5 = iIntValue & 7;
            int iIntValue2 = (bigIntegerShiftRight2.intValue() >>> i3) + i2;
            int i6 = iIntValue2 & 7;
            int i7 = iIntValue & 1;
            if (i7 != 0) {
                i7 -= iIntValue & 2;
                if (i5 + i7 == 4 && (iIntValue2 & 3) == 2) {
                    i7 = -i7;
                }
            }
            int i8 = iIntValue2 & 1;
            if (i8 != 0) {
                i8 -= iIntValue2 & 2;
                if (i6 + i8 == 4 && (iIntValue & 3) == 2) {
                    i8 = -i8;
                }
            }
            if ((i << 1) == i7 + 1) {
                i ^= 1;
            }
            if ((i2 << 1) == i8 + 1) {
                i2 ^= 1;
            }
            i3++;
            if (i3 == 30) {
                bigIntegerShiftRight = bigIntegerShiftRight.shiftRight(30);
                bigIntegerShiftRight2 = bigIntegerShiftRight2.shiftRight(30);
                i3 = 0;
            }
            bArr[i4] = (byte) ((i8 & 15) | (i7 << 4));
            i4++;
        }
        return iMax > i4 ? m16381trim(bArr, i4) : bArr;
    }

    public static byte[] generateNaf(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return EMPTY_BYTES;
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength();
        int i = iBitLength - 1;
        byte[] bArr = new byte[i];
        BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
        int i2 = 1;
        while (i2 < i) {
            if (bigIntegerXor.testBit(i2)) {
                bArr[i2 - 1] = (byte) (bigInteger.testBit(i2) ? -1 : 1);
                i2++;
            }
            i2++;
        }
        bArr[iBitLength - 2] = 1;
        return bArr;
    }

    public static byte[] generateWindowNaf(int i, BigInteger bigInteger) {
        if (i == 2) {
            return generateNaf(bigInteger);
        }
        if (i < 2 || i > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        }
        if (bigInteger.signum() == 0) {
            return EMPTY_BYTES;
        }
        int iBitLength = bigInteger.bitLength() + 1;
        byte[] bArr = new byte[iBitLength];
        int i2 = 1 << i;
        int i3 = i2 - 1;
        int i4 = i2 >>> 1;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i5 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i5) == z) {
                i5++;
            } else {
                bigInteger = bigInteger.shiftRight(i5);
                int iIntValue = bigInteger.intValue() & i3;
                if (z) {
                    iIntValue++;
                }
                z = (iIntValue & i4) != 0;
                if (z) {
                    iIntValue -= i2;
                }
                if (i6 > 0) {
                    i5--;
                }
                int i7 = i6 + i5;
                bArr[i7] = (byte) iIntValue;
                i6 = i7 + 1;
                i5 = i;
            }
        }
        return iBitLength > i6 ? m16381trim(bArr, i6) : bArr;
    }

    public static int getNafWeight(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static WNafPreCompInfo getWNafPreCompInfo(AbstractC5820ECPoint abstractC5820ECPoint) {
        return getWNafPreCompInfo(abstractC5820ECPoint.getCurve().getPreCompInfo(abstractC5820ECPoint, PRECOMP_NAME));
    }

    public static int getWindowSize(int i) {
        return getWindowSize(i, DEFAULT_WINDOW_SIZE_CUTOFFS, 16);
    }

    public static WNafPreCompInfo precompute(final AbstractC5820ECPoint abstractC5820ECPoint, final int i, final boolean z) {
        final AbstractC5817ECCurve curve = abstractC5820ECPoint.getCurve();
        return (WNafPreCompInfo) curve.precompute(abstractC5820ECPoint, PRECOMP_NAME, new PreCompCallback() { // from class: org.bouncycastle.math.ec.WNafUtil.2
            private boolean checkExisting(WNafPreCompInfo wNafPreCompInfo, int i2, int i3, boolean z2) {
                return wNafPreCompInfo != null && wNafPreCompInfo.getWidth() >= Math.max(wNafPreCompInfo.getConfWidth(), i2) && checkTable(wNafPreCompInfo.getPreComp(), i3) && (!z2 || checkTable(wNafPreCompInfo.getPreCompNeg(), i3));
            }

            private boolean checkTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i2) {
                return abstractC5820ECPointArr != null && abstractC5820ECPointArr.length >= i2;
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[PHI: r14
              0x00ef: PHI (r14v6 org.bouncycastle.math.ec.ECPoint) = 
              (r14v4 org.bouncycastle.math.ec.ECPoint)
              (r14v9 org.bouncycastle.math.ec.ECPoint)
              (r14v9 org.bouncycastle.math.ec.ECPoint)
              (r14v9 org.bouncycastle.math.ec.ECPoint)
              (r14v9 org.bouncycastle.math.ec.ECPoint)
             binds: [B:28:0x0091, B:30:0x009d, B:32:0x00a5, B:34:0x00af, B:40:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                AbstractC5820ECPoint abstractC5820ECPointMo16338twice;
                AbstractC5820ECPoint[] abstractC5820ECPointArrResizeTable;
                AbstractC5820ECPoint[] abstractC5820ECPointArrResizeTable2;
                int length;
                int i2;
                AbstractC5820ECPoint abstractC5820ECPointCreatePoint;
                int coordinateSystem;
                ECFieldElement zCoord = null;
                WNafPreCompInfo wNafPreCompInfo = preCompInfo instanceof WNafPreCompInfo ? (WNafPreCompInfo) preCompInfo : null;
                int iMax = Math.max(2, Math.min(16, i));
                if (checkExisting(wNafPreCompInfo, iMax, 1 << (iMax - 2), z)) {
                    wNafPreCompInfo.decrementPromotionCountdown();
                    return wNafPreCompInfo;
                }
                WNafPreCompInfo wNafPreCompInfo2 = new WNafPreCompInfo();
                if (wNafPreCompInfo != null) {
                    wNafPreCompInfo2.setPromotionCountdown(wNafPreCompInfo.decrementPromotionCountdown());
                    wNafPreCompInfo2.setConfWidth(wNafPreCompInfo.getConfWidth());
                    abstractC5820ECPointArrResizeTable = wNafPreCompInfo.getPreComp();
                    abstractC5820ECPointArrResizeTable2 = wNafPreCompInfo.getPreCompNeg();
                    abstractC5820ECPointMo16338twice = wNafPreCompInfo.getTwice();
                } else {
                    abstractC5820ECPointMo16338twice = null;
                    abstractC5820ECPointArrResizeTable = null;
                    abstractC5820ECPointArrResizeTable2 = null;
                }
                int iMin = Math.min(16, Math.max(wNafPreCompInfo2.getConfWidth(), iMax));
                int i3 = 1 << (iMin - 2);
                int length2 = 0;
                if (abstractC5820ECPointArrResizeTable == null) {
                    abstractC5820ECPointArrResizeTable = WNafUtil.EMPTY_POINTS;
                    length = 0;
                } else {
                    length = abstractC5820ECPointArrResizeTable.length;
                }
                if (length < i3) {
                    abstractC5820ECPointArrResizeTable = WNafUtil.resizeTable(abstractC5820ECPointArrResizeTable, i3);
                    if (i3 == 1) {
                        abstractC5820ECPointArrResizeTable[0] = abstractC5820ECPoint.normalize();
                    } else {
                        if (length == 0) {
                            abstractC5820ECPointArrResizeTable[0] = abstractC5820ECPoint;
                            i2 = 1;
                        } else {
                            i2 = length;
                        }
                        if (i3 == 2) {
                            abstractC5820ECPointArrResizeTable[1] = abstractC5820ECPoint.threeTimes();
                        } else {
                            AbstractC5820ECPoint abstractC5820ECPointMo16330add = abstractC5820ECPointArrResizeTable[i2 - 1];
                            if (abstractC5820ECPointMo16338twice == null) {
                                abstractC5820ECPointMo16338twice = abstractC5820ECPointArrResizeTable[0].mo16338twice();
                                if (abstractC5820ECPointMo16338twice.isInfinity() || !ECAlgorithms.isFpCurve(curve) || curve.getFieldSize() < 64 || !((coordinateSystem = curve.getCoordinateSystem()) == 2 || coordinateSystem == 3 || coordinateSystem == 4)) {
                                    abstractC5820ECPointCreatePoint = abstractC5820ECPointMo16338twice;
                                } else {
                                    zCoord = abstractC5820ECPointMo16338twice.getZCoord(0);
                                    abstractC5820ECPointCreatePoint = curve.createPoint(abstractC5820ECPointMo16338twice.getXCoord().toBigInteger(), abstractC5820ECPointMo16338twice.getYCoord().toBigInteger());
                                    ECFieldElement eCFieldElementMo16318square = zCoord.mo16318square();
                                    abstractC5820ECPointMo16330add = abstractC5820ECPointMo16330add.mo16336scaleX(eCFieldElementMo16318square).mo16337scaleY(eCFieldElementMo16318square.multiply(zCoord));
                                    if (length == 0) {
                                        abstractC5820ECPointArrResizeTable[0] = abstractC5820ECPointMo16330add;
                                    }
                                }
                                while (i2 < i3) {
                                    abstractC5820ECPointMo16330add = abstractC5820ECPointMo16330add.mo16330add(abstractC5820ECPointCreatePoint);
                                    abstractC5820ECPointArrResizeTable[i2] = abstractC5820ECPointMo16330add;
                                    i2++;
                                }
                            }
                        }
                        curve.normalizeAll(abstractC5820ECPointArrResizeTable, length, i3 - length, zCoord);
                    }
                }
                if (z) {
                    if (abstractC5820ECPointArrResizeTable2 == null) {
                        abstractC5820ECPointArrResizeTable2 = new AbstractC5820ECPoint[i3];
                    } else {
                        length2 = abstractC5820ECPointArrResizeTable2.length;
                        if (length2 < i3) {
                            abstractC5820ECPointArrResizeTable2 = WNafUtil.resizeTable(abstractC5820ECPointArrResizeTable2, i3);
                        }
                    }
                    while (length2 < i3) {
                        abstractC5820ECPointArrResizeTable2[length2] = abstractC5820ECPointArrResizeTable[length2].mo16335negate();
                        length2++;
                    }
                }
                wNafPreCompInfo2.setPreComp(abstractC5820ECPointArrResizeTable);
                wNafPreCompInfo2.setPreCompNeg(abstractC5820ECPointArrResizeTable2);
                wNafPreCompInfo2.setTwice(abstractC5820ECPointMo16338twice);
                wNafPreCompInfo2.setWidth(iMin);
                return wNafPreCompInfo2;
            }
        });
    }

    public static WNafPreCompInfo precomputeWithPointMap(AbstractC5820ECPoint abstractC5820ECPoint, final ECPointMap eCPointMap, final WNafPreCompInfo wNafPreCompInfo, final boolean z) {
        return (WNafPreCompInfo) abstractC5820ECPoint.getCurve().precompute(abstractC5820ECPoint, PRECOMP_NAME, new PreCompCallback() { // from class: org.bouncycastle.math.ec.WNafUtil.3
            private boolean checkExisting(WNafPreCompInfo wNafPreCompInfo2, int i, int i2, boolean z2) {
                return wNafPreCompInfo2 != null && wNafPreCompInfo2.getWidth() >= i && checkTable(wNafPreCompInfo2.getPreComp(), i2) && (!z2 || checkTable(wNafPreCompInfo2.getPreCompNeg(), i2));
            }

            private boolean checkTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i) {
                return abstractC5820ECPointArr != null && abstractC5820ECPointArr.length >= i;
            }

            @Override // org.bouncycastle.p284math.p285ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                WNafPreCompInfo wNafPreCompInfo2 = preCompInfo instanceof WNafPreCompInfo ? (WNafPreCompInfo) preCompInfo : null;
                int width = wNafPreCompInfo.getWidth();
                if (checkExisting(wNafPreCompInfo2, width, wNafPreCompInfo.getPreComp().length, z)) {
                    wNafPreCompInfo2.decrementPromotionCountdown();
                    return wNafPreCompInfo2;
                }
                WNafPreCompInfo wNafPreCompInfo3 = new WNafPreCompInfo();
                wNafPreCompInfo3.setPromotionCountdown(wNafPreCompInfo.getPromotionCountdown());
                AbstractC5820ECPoint twice = wNafPreCompInfo.getTwice();
                if (twice != null) {
                    wNafPreCompInfo3.setTwice(eCPointMap.mo16345map(twice));
                }
                AbstractC5820ECPoint[] preComp = wNafPreCompInfo.getPreComp();
                int length = preComp.length;
                AbstractC5820ECPoint[] abstractC5820ECPointArr = new AbstractC5820ECPoint[length];
                for (int i = 0; i < preComp.length; i++) {
                    abstractC5820ECPointArr[i] = eCPointMap.mo16345map(preComp[i]);
                }
                wNafPreCompInfo3.setPreComp(abstractC5820ECPointArr);
                wNafPreCompInfo3.setWidth(width);
                if (z) {
                    AbstractC5820ECPoint[] abstractC5820ECPointArr2 = new AbstractC5820ECPoint[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        abstractC5820ECPointArr2[i2] = abstractC5820ECPointArr[i2].mo16335negate();
                    }
                    wNafPreCompInfo3.setPreCompNeg(abstractC5820ECPointArr2);
                }
                return wNafPreCompInfo3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AbstractC5820ECPoint[] resizeTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i) {
        AbstractC5820ECPoint[] abstractC5820ECPointArr2 = new AbstractC5820ECPoint[i];
        System.arraycopy(abstractC5820ECPointArr, 0, abstractC5820ECPointArr2, 0, abstractC5820ECPointArr.length);
        return abstractC5820ECPointArr2;
    }

    /* renamed from: trim */
    private static byte[] m16381trim(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof WNafPreCompInfo) {
            return (WNafPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static int getWindowSize(int i, int i2) {
        return getWindowSize(i, DEFAULT_WINDOW_SIZE_CUTOFFS, i2);
    }

    /* renamed from: trim */
    private static int[] m16382trim(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    public static int getWindowSize(int i, int[] iArr) {
        return getWindowSize(i, iArr, 16);
    }

    public static int getWindowSize(int i, int[] iArr, int i2) {
        int i3 = 0;
        while (i3 < iArr.length && i >= iArr[i3]) {
            i3++;
        }
        return Math.max(2, Math.min(i2, i3 + 2));
    }
}
