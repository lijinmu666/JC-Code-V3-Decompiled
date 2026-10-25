package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.hash2curve.H2cUtils;
import org.bouncycastle.p194crypto.hash2curve.SqrtRatioCalculator;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class GenericSqrtRatioCalculator implements SqrtRatioCalculator {

    /* renamed from: c1 */
    private final int f20309c1;

    /* renamed from: c2 */
    private final BigInteger f20310c2;

    /* renamed from: c3 */
    private final BigInteger f20311c3;

    /* renamed from: c4 */
    private final BigInteger f20312c4;

    /* renamed from: c5 */
    private final BigInteger f20313c5;

    /* renamed from: c6 */
    private final BigInteger f20314c6;

    /* renamed from: c7 */
    private final BigInteger f20315c7;

    /* renamed from: q */
    private final BigInteger f20316q;

    public GenericSqrtRatioCalculator(AbstractC5817ECCurve abstractC5817ECCurve, BigInteger bigInteger) {
        BigInteger characteristic = abstractC5817ECCurve.getField().getCharacteristic();
        this.f20316q = characteristic;
        int iCalculateC1 = calculateC1();
        this.f20309c1 = iCalculateC1;
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerDivide = characteristic.subtract(bigInteger2).divide(BigInteger.valueOf(2L).pow(iCalculateC1));
        this.f20310c2 = bigIntegerDivide;
        this.f20311c3 = bigIntegerDivide.subtract(bigInteger2).divide(BigInteger.valueOf(2L));
        this.f20312c4 = BigInteger.valueOf(2L).pow(iCalculateC1).subtract(bigInteger2);
        this.f20313c5 = BigInteger.valueOf(2L).pow(iCalculateC1 - 1);
        this.f20314c6 = bigInteger.modPow(bigIntegerDivide, characteristic);
        this.f20315c7 = bigInteger.modPow(bigIntegerDivide.add(bigInteger2).divide(BigInteger.valueOf(2L)), characteristic);
    }

    private int calculateC1() {
        BigInteger bigIntegerSubtract = this.f20316q.subtract(BigInteger.ONE);
        int i = 0;
        while (bigIntegerSubtract.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO)) {
            bigIntegerSubtract = bigIntegerSubtract.divide(BigInteger.valueOf(2L));
            i++;
        }
        return i;
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.SqrtRatioCalculator
    public SqrtRatio sqrtRatio(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerMod = this.f20314c6;
        BigInteger bigIntegerModPow = bigInteger2.modPow(this.f20312c4, this.f20316q);
        BigInteger bigIntegerMod2 = bigInteger.multiply(bigIntegerModPow.modPow(BigInteger.valueOf(2L), this.f20316q).multiply(bigInteger2).mod(this.f20316q)).mod(this.f20316q).modPow(this.f20311c3, this.f20316q).multiply(bigIntegerModPow).mod(this.f20316q);
        BigInteger bigIntegerMod3 = bigIntegerMod2.multiply(bigInteger2).mod(this.f20316q);
        BigInteger bigIntegerMod4 = bigIntegerMod2.multiply(bigInteger).mod(this.f20316q);
        BigInteger bigIntegerMod5 = bigIntegerMod4.multiply(bigIntegerMod3).mod(this.f20316q);
        boolean zEquals = bigIntegerMod5.modPow(this.f20313c5, this.f20316q).equals(BigInteger.ONE);
        BigInteger bigIntegerMod6 = bigIntegerMod4.multiply(this.f20315c7).mod(this.f20316q);
        BigInteger bigIntegerMod7 = bigIntegerMod5.multiply(bigIntegerMod).mod(this.f20316q);
        BigInteger bigIntegerM15507cmov = H2cUtils.m15507cmov(bigIntegerMod6, bigIntegerMod4, zEquals);
        BigInteger bigIntegerM15507cmov2 = H2cUtils.m15507cmov(bigIntegerMod7, bigIntegerMod5, zEquals);
        for (int i = this.f20309c1; i >= 2; i--) {
            boolean zEquals2 = bigIntegerM15507cmov2.modPow(BigInteger.valueOf(2L).pow(BigInteger.valueOf(i - 2).intValue()), this.f20316q).equals(BigInteger.ONE);
            BigInteger bigIntegerMod8 = bigIntegerM15507cmov.multiply(bigIntegerMod).mod(this.f20316q);
            bigIntegerMod = bigIntegerMod.multiply(bigIntegerMod).mod(this.f20316q);
            BigInteger bigIntegerMod9 = bigIntegerM15507cmov2.multiply(bigIntegerMod).mod(this.f20316q);
            bigIntegerM15507cmov = H2cUtils.m15507cmov(bigIntegerMod8, bigIntegerM15507cmov, zEquals2);
            bigIntegerM15507cmov2 = H2cUtils.m15507cmov(bigIntegerMod9, bigIntegerM15507cmov2, zEquals2);
        }
        return new SqrtRatio(zEquals, bigIntegerM15507cmov);
    }
}
