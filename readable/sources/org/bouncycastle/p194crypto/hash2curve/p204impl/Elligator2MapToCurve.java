package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.hash2curve.H2cUtils;
import org.bouncycastle.p194crypto.hash2curve.MapToCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class Elligator2MapToCurve implements MapToCurve {

    /* renamed from: K */
    private final BigInteger f20303K;

    /* renamed from: c1 */
    private final BigInteger f20304c1;

    /* renamed from: c2 */
    private final BigInteger f20305c2;

    /* renamed from: curve */
    private final AbstractC5817ECCurve f20306curve;

    /* renamed from: p */
    private final BigInteger f20307p;

    /* renamed from: z */
    private final BigInteger f20308z;

    public Elligator2MapToCurve(AbstractC5817ECCurve abstractC5817ECCurve, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f20306curve = abstractC5817ECCurve;
        this.f20308z = bigInteger;
        this.f20303K = bigInteger3;
        BigInteger characteristic = abstractC5817ECCurve.getField().getCharacteristic();
        this.f20307p = characteristic;
        BigInteger bigIntegerModInverse = bigInteger3.modInverse(characteristic);
        this.f20304c1 = bigInteger2.multiply(bigIntegerModInverse).mod(characteristic);
        this.f20305c2 = bigIntegerModInverse.multiply(bigIntegerModInverse).mod(characteristic);
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.MapToCurve
    /* renamed from: process */
    public AbstractC5820ECPoint mo15524process(BigInteger bigInteger) {
        BigInteger bigIntegerMod = this.f20308z.multiply(bigInteger.multiply(bigInteger).mod(this.f20307p)).mod(this.f20307p);
        BigInteger bigInteger2 = this.f20307p;
        BigInteger bigInteger3 = BigInteger.ONE;
        BigInteger bigIntegerM15507cmov = H2cUtils.m15507cmov(bigIntegerMod, BigInteger.ZERO, bigIntegerMod.equals(bigInteger2.subtract(bigInteger3)));
        BigInteger bigIntegerMod2 = H2cUtils.m15509inv0(bigIntegerM15507cmov.add(bigInteger3).mod(this.f20307p), this.f20307p).multiply(this.f20304c1).negate().mod(this.f20307p);
        BigInteger bigIntegerMod3 = bigIntegerMod2.add(this.f20304c1).mod(this.f20307p).multiply(bigIntegerMod2).mod(this.f20307p).add(this.f20305c2).mod(this.f20307p).multiply(bigIntegerMod2).mod(this.f20307p);
        BigInteger bigIntegerMod4 = bigIntegerMod2.negate().subtract(this.f20304c1).mod(this.f20307p);
        BigInteger bigIntegerMod5 = bigIntegerM15507cmov.multiply(bigIntegerMod3).mod(this.f20307p);
        boolean zIsSquare = H2cUtils.isSquare(bigIntegerMod3, this.f20307p);
        BigInteger bigIntegerM15507cmov2 = H2cUtils.m15507cmov(bigIntegerMod4, bigIntegerMod2, zIsSquare);
        BigInteger bigIntegerM15512sqrt = H2cUtils.m15512sqrt(H2cUtils.m15507cmov(bigIntegerMod5, bigIntegerMod3, zIsSquare), this.f20307p);
        return this.f20306curve.createPoint(bigIntegerM15507cmov2.multiply(this.f20303K).mod(this.f20307p), H2cUtils.m15507cmov(bigIntegerM15512sqrt, bigIntegerM15512sqrt.negate().mod(this.f20307p), zIsSquare ^ (H2cUtils.m15511sgn0(bigIntegerM15512sqrt, this.f20306curve) == 1)).multiply(this.f20303K).mod(this.f20307p));
    }
}
