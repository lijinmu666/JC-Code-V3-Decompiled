package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p075subtle.C0855Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* loaded from: classes.dex */
final class Ed25519Constants {

    /* renamed from: B2 */
    static final C0855Ed25519.CachedXYT[] f3941B2;

    /* renamed from: B_TABLE */
    static final C0855Ed25519.CachedXYT[][] f3942B_TABLE;

    /* renamed from: D */
    static final long[] f3943D;

    /* renamed from: D2 */
    static final long[] f3944D2;

    /* renamed from: D2_BI */
    private static final BigInteger f3945D2_BI;

    /* renamed from: D_BI */
    private static final BigInteger f3946D_BI;

    /* renamed from: P_BI */
    private static final BigInteger f3947P_BI;

    /* renamed from: SQRTM1 */
    static final long[] f3948SQRTM1;
    private static final BigInteger SQRTM1_BI;

    /* renamed from: com.google.crypto.tink.subtle.Ed25519Constants$Point */
    public static class C0857Point {

        /* renamed from: x */
        private BigInteger f3949x;

        /* renamed from: y */
        private BigInteger f3950y;

        private C0857Point() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f3947P_BI = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f3946D_BI = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f3945D2_BI = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        SQRTM1_BI = bigIntegerModPow;
        C0857Point c0857Point = new C0857Point();
        c0857Point.f3950y = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        c0857Point.f3949x = recoverX(c0857Point.f3950y);
        f3943D = Field25519.m4263expand(toLittleEndian(bigIntegerMod));
        f3944D2 = Field25519.m4263expand(toLittleEndian(bigIntegerMod2));
        f3948SQRTM1 = Field25519.m4263expand(toLittleEndian(bigIntegerModPow));
        f3942B_TABLE = (C0855Ed25519.CachedXYT[][]) Array.newInstance((Class<?>) C0855Ed25519.CachedXYT.class, 32, 8);
        C0857Point c0857PointM4251edwards = c0857Point;
        for (int i = 0; i < 32; i++) {
            C0857Point c0857PointM4251edwards2 = c0857PointM4251edwards;
            for (int i2 = 0; i2 < 8; i2++) {
                f3942B_TABLE[i][i2] = getCachedXYT(c0857PointM4251edwards2);
                c0857PointM4251edwards2 = m4251edwards(c0857PointM4251edwards2, c0857PointM4251edwards);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                c0857PointM4251edwards = m4251edwards(c0857PointM4251edwards, c0857PointM4251edwards);
            }
        }
        C0857Point c0857PointM4251edwards3 = m4251edwards(c0857Point, c0857Point);
        f3941B2 = new C0855Ed25519.CachedXYT[8];
        for (int i4 = 0; i4 < 8; i4++) {
            f3941B2[i4] = getCachedXYT(c0857Point);
            c0857Point = m4251edwards(c0857Point, c0857PointM4251edwards3);
        }
    }

    private Ed25519Constants() {
    }

    /* renamed from: edwards */
    private static C0857Point m4251edwards(C0857Point c0857Point, C0857Point c0857Point2) {
        C0857Point c0857Point3 = new C0857Point();
        BigInteger bigIntegerMultiply = f3946D_BI.multiply(c0857Point.f3949x.multiply(c0857Point2.f3949x).multiply(c0857Point.f3950y).multiply(c0857Point2.f3950y));
        BigInteger bigInteger = f3947P_BI;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = c0857Point.f3949x.multiply(c0857Point2.f3950y).add(c0857Point2.f3949x.multiply(c0857Point.f3950y));
        BigInteger bigInteger2 = BigInteger.ONE;
        c0857Point3.f3949x = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        c0857Point3.f3950y = c0857Point.f3950y.multiply(c0857Point2.f3950y).add(c0857Point.f3949x.multiply(c0857Point2.f3949x)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return c0857Point3;
    }

    private static C0855Ed25519.CachedXYT getCachedXYT(C0857Point c0857Point) {
        BigInteger bigIntegerAdd = c0857Point.f3950y.add(c0857Point.f3949x);
        BigInteger bigInteger = f3947P_BI;
        return new C0855Ed25519.CachedXYT(Field25519.m4263expand(toLittleEndian(bigIntegerAdd.mod(bigInteger))), Field25519.m4263expand(toLittleEndian(c0857Point.f3950y.subtract(c0857Point.f3949x).mod(bigInteger))), Field25519.m4263expand(toLittleEndian(f3945D2_BI.multiply(c0857Point.f3949x).multiply(c0857Point.f3950y).mod(bigInteger))));
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = f3946D_BI.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = f3947P_BI;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(SQRTM1_BI).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = 31 - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }
}
