package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.hash2curve.H2cUtils;
import org.bouncycastle.p194crypto.hash2curve.MapToCurve;
import org.bouncycastle.p194crypto.hash2curve.SqrtRatioCalculator;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class SimplifiedShallueVanDeWoestijneMapToCurve implements MapToCurve {

    /* renamed from: curve */
    private final AbstractC5817ECCurve f20322curve;
    private final SqrtRatioCalculator sqrtRatioCalculator;

    /* renamed from: z */
    private final BigInteger f20323z;

    public SimplifiedShallueVanDeWoestijneMapToCurve(AbstractC5817ECCurve abstractC5817ECCurve, BigInteger bigInteger) {
        this.f20322curve = abstractC5817ECCurve;
        this.f20323z = bigInteger;
        this.sqrtRatioCalculator = new GenericSqrtRatioCalculator(abstractC5817ECCurve, bigInteger);
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.MapToCurve
    /* renamed from: process */
    public AbstractC5820ECPoint mo15524process(BigInteger bigInteger) {
        BigInteger bigInteger2 = this.f20322curve.m16298getA().toBigInteger();
        BigInteger bigInteger3 = this.f20322curve.m16299getB().toBigInteger();
        BigInteger characteristic = this.f20322curve.getField().getCharacteristic();
        BigInteger bigIntegerMod = this.f20323z.multiply(bigInteger.modPow(BigInteger.valueOf(2L), characteristic)).mod(characteristic);
        BigInteger bigIntegerMod2 = bigIntegerMod.modPow(BigInteger.valueOf(2L), characteristic).add(bigIntegerMod).mod(characteristic);
        BigInteger bigInteger4 = BigInteger.ONE;
        BigInteger bigIntegerMod3 = bigInteger3.multiply(bigIntegerMod2.add(bigInteger4).mod(characteristic)).mod(characteristic);
        BigInteger bigIntegerMod4 = bigInteger2.multiply(H2cUtils.m15507cmov(this.f20323z, bigIntegerMod2.negate(), !bigIntegerMod2.equals(BigInteger.ZERO))).mod(characteristic);
        BigInteger bigIntegerModPow = bigIntegerMod3.modPow(BigInteger.valueOf(2L), characteristic);
        BigInteger bigIntegerModPow2 = bigIntegerMod4.modPow(BigInteger.valueOf(2L), characteristic);
        BigInteger bigIntegerMod5 = bigIntegerModPow.add(bigInteger2.multiply(bigIntegerModPow2).mod(characteristic)).mod(characteristic).multiply(bigIntegerMod3).mod(characteristic);
        BigInteger bigIntegerMod6 = bigIntegerModPow2.multiply(bigIntegerMod4).mod(characteristic);
        BigInteger bigIntegerMod7 = bigIntegerMod5.add(bigInteger3.multiply(bigIntegerMod6).mod(characteristic)).mod(characteristic);
        BigInteger bigIntegerMod8 = bigIntegerMod.multiply(bigIntegerMod3).mod(characteristic);
        SqrtRatio sqrtRatio = this.sqrtRatioCalculator.sqrtRatio(bigIntegerMod7, bigIntegerMod6);
        boolean zM15533isQR = sqrtRatio.m15533isQR();
        BigInteger ratio = sqrtRatio.getRatio();
        BigInteger bigIntegerMod9 = bigIntegerMod.multiply(bigInteger).mod(characteristic).multiply(ratio).mod(characteristic);
        BigInteger bigIntegerM15507cmov = H2cUtils.m15507cmov(bigIntegerMod8, bigIntegerMod3, zM15533isQR);
        BigInteger bigIntegerM15507cmov2 = H2cUtils.m15507cmov(bigIntegerMod9, ratio, zM15533isQR);
        return this.f20322curve.createPoint(bigIntegerM15507cmov.multiply(bigIntegerMod4.modPow(bigInteger4.negate(), characteristic)).mod(characteristic), H2cUtils.m15507cmov(bigIntegerM15507cmov2.negate(), bigIntegerM15507cmov2, H2cUtils.m15511sgn0(bigInteger, this.f20322curve) == H2cUtils.m15511sgn0(bigIntegerM15507cmov2, this.f20322curve)).mod(characteristic));
    }
}
