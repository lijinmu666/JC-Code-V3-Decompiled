package org.bouncycastle.p194crypto.p207kems;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.SAKKEPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SAKKEPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SAKKEKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: K_bs */
    private final AbstractC5820ECPoint f20388K_bs;

    /* renamed from: P */
    private final AbstractC5820ECPoint f20389P;

    /* renamed from: Z_S */
    private final AbstractC5820ECPoint f20390Z_S;

    /* renamed from: curve */
    private final AbstractC5817ECCurve f20391curve;

    /* renamed from: digest */
    private final InterfaceC5277Digest f20392digest;
    private final BigInteger identifier;

    /* renamed from: n */
    private final int f20393n;

    /* renamed from: p */
    private final BigInteger f20394p;

    /* renamed from: q */
    private final BigInteger f20395q;

    public SAKKEKEMExtractor(SAKKEPrivateKeyParameters sAKKEPrivateKeyParameters) {
        SAKKEPublicKeyParameters publicParams = sAKKEPrivateKeyParameters.getPublicParams();
        this.f20391curve = publicParams.getCurve();
        BigInteger bigIntegerM15813getQ = publicParams.m15813getQ();
        this.f20395q = bigIntegerM15813getQ;
        AbstractC5820ECPoint point = publicParams.getPoint();
        this.f20389P = point;
        this.f20394p = publicParams.getPrime();
        this.f20390Z_S = publicParams.m15814getZ();
        BigInteger identifier = publicParams.getIdentifier();
        this.identifier = identifier;
        this.f20388K_bs = point.multiply(identifier.add(sAKKEPrivateKeyParameters.getMasterSecret()).modInverse(bigIntegerM15813getQ)).normalize();
        this.f20393n = publicParams.m15812getN();
        this.f20392digest = publicParams.getDigest();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00ed A[PHI: r2
      0x00ed: PHI (r2v10 java.math.BigInteger[]) = (r2v9 java.math.BigInteger[]), (r2v13 java.math.BigInteger[]) binds: [B:5:0x00a2, B:7:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BigInteger computePairing(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ONE;
        BigInteger[] bigIntegerArrFp2Multiply = {bigInteger3, BigInteger.ZERO};
        BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger3);
        int iBitLength = bigIntegerSubtract.bitLength();
        BigInteger bigInteger4 = abstractC5820ECPoint2.getAffineXCoord().toBigInteger();
        BigInteger bigInteger5 = abstractC5820ECPoint2.getAffineYCoord().toBigInteger();
        BigInteger bigInteger6 = abstractC5820ECPoint.getAffineXCoord().toBigInteger();
        BigInteger bigInteger7 = abstractC5820ECPoint.getAffineYCoord().toBigInteger();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(3L);
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint;
        for (int i = iBitLength - 2; i >= 0; i--) {
            BigInteger bigInteger8 = abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger();
            BigInteger bigInteger9 = abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger();
            BigInteger bigIntegerMod = bigInteger8.multiply(bigInteger8).mod(bigInteger).subtract(BigInteger.ONE).multiply(bigIntegerValueOf).multiply(BigIntegers.modOddInverse(bigInteger, bigInteger9.shiftLeft(1))).mod(bigInteger);
            BigInteger[] bigIntegerArrFp2PointSquare = fp2PointSquare(bigIntegerArrFp2Multiply[0], bigIntegerArrFp2Multiply[1], bigInteger);
            bigIntegerArrFp2Multiply = fp2Multiply(bigIntegerArrFp2PointSquare[0], bigIntegerArrFp2PointSquare[1], bigIntegerMod.multiply(bigInteger4.add(bigInteger8)).subtract(bigInteger9).mod(bigInteger), bigInteger5, bigInteger);
            abstractC5820ECPointNormalize = abstractC5820ECPointNormalize.mo16338twice().normalize();
            if (bigIntegerSubtract.testBit(i)) {
                BigInteger bigInteger10 = abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger();
                BigInteger bigInteger11 = abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger();
                bigIntegerArrFp2Multiply = fp2Multiply(bigIntegerArrFp2Multiply[0], bigIntegerArrFp2Multiply[1], bigInteger11.subtract(bigInteger7).multiply(BigIntegers.modOddInverse(bigInteger, bigInteger10.subtract(bigInteger6))).mod(bigInteger).multiply(bigInteger4.add(bigInteger10)).subtract(bigInteger11).mod(bigInteger), bigInteger5, bigInteger);
                if (i > 0) {
                    abstractC5820ECPointNormalize = abstractC5820ECPointNormalize.mo16330add(abstractC5820ECPoint).normalize();
                }
            }
        }
        BigInteger[] bigIntegerArrFp2PointSquare2 = fp2PointSquare(bigIntegerArrFp2Multiply[0], bigIntegerArrFp2Multiply[1], bigInteger);
        BigInteger[] bigIntegerArrFp2PointSquare3 = fp2PointSquare(bigIntegerArrFp2PointSquare2[0], bigIntegerArrFp2PointSquare2[1], bigInteger);
        return bigIntegerArrFp2PointSquare3[1].multiply(BigIntegers.modOddInverse(bigInteger, bigIntegerArrFp2PointSquare3[0])).mod(bigInteger);
    }

    public static BigInteger[] fp2Multiply(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        return new BigInteger[]{bigInteger.multiply(bigInteger3).subtract(bigInteger2.multiply(bigInteger4)).mod(bigInteger5), bigInteger.multiply(bigInteger4).add(bigInteger2.multiply(bigInteger3)).mod(bigInteger5)};
    }

    public static BigInteger[] fp2PointSquare(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return new BigInteger[]{bigInteger.add(bigInteger2).multiply(bigInteger.subtract(bigInteger2)).mod(bigInteger3), bigInteger.multiply(bigInteger2).shiftLeft(1).mod(bigInteger3)};
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        AbstractC5820ECPoint abstractC5820ECPointSumOfTwoMultiplies;
        AbstractC5820ECPoint abstractC5820ECPointDecodePoint = this.f20391curve.decodePoint(C6238Arrays.copyOfRange(bArr, 0, 257));
        BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 257, 16);
        BigInteger bigIntegerComputePairing = computePairing(abstractC5820ECPointDecodePoint, this.f20388K_bs, this.f20394p, this.f20395q);
        BigInteger bigIntegerMod = bigIntegerFromUnsignedByteArray.xor(SAKKEKEMSGenerator.hashToIntegerRange(bigIntegerComputePairing.toByteArray(), BigInteger.ONE.shiftLeft(this.f20393n), this.f20392digest)).mod(this.f20394p);
        BigInteger bigInteger = this.identifier;
        BigInteger bigIntegerHashToIntegerRange = SAKKEKEMSGenerator.hashToIntegerRange(C6238Arrays.concatenate(bigIntegerMod.toByteArray(), bigInteger.toByteArray()), this.f20395q, this.f20392digest);
        BigInteger order = this.f20391curve.getOrder();
        if (order == null) {
            abstractC5820ECPointSumOfTwoMultiplies = this.f20389P.multiply(bigInteger).mo16330add(this.f20390Z_S).multiply(bigIntegerHashToIntegerRange);
        } else {
            abstractC5820ECPointSumOfTwoMultiplies = ECAlgorithms.sumOfTwoMultiplies(this.f20389P, bigInteger.multiply(bigIntegerHashToIntegerRange).mod(order), this.f20390Z_S, bigIntegerHashToIntegerRange);
        }
        if (abstractC5820ECPointSumOfTwoMultiplies.subtract(abstractC5820ECPointDecodePoint).isInfinity()) {
            return BigIntegers.asUnsignedByteArray(this.f20393n / 8, bigIntegerMod);
        }
        throw new IllegalStateException("Validation of R_bS failed");
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return 273;
    }
}
