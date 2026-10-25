package org.bouncycastle.p194crypto.p207kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.SAKKEPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SAKKEKEMSGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: random */
    private final SecureRandom f20396random;

    public SAKKEKEMSGenerator(SecureRandom secureRandom) {
        this.f20396random = secureRandom;
    }

    public static BigInteger hashToIntegerRange(byte[] bArr, BigInteger bigInteger, InterfaceC5277Digest interfaceC5277Digest) {
        int digestSize = interfaceC5277Digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        interfaceC5277Digest.mo14967doFinal(bArr2, 0);
        int digestSize2 = interfaceC5277Digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        int iBitLength = bigInteger.bitLength() >> 8;
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        int digestSize3 = interfaceC5277Digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize3];
        for (int i = 0; i <= iBitLength; i++) {
            interfaceC5277Digest.mo14970update(bArr3, 0, digestSize2);
            interfaceC5277Digest.mo14967doFinal(bArr3, 0);
            interfaceC5277Digest.mo14970update(bArr3, 0, digestSize2);
            interfaceC5277Digest.mo14970update(bArr2, 0, digestSize);
            interfaceC5277Digest.mo14967doFinal(bArr4, 0);
            bigIntegerAdd = bigIntegerAdd.shiftLeft(digestSize3 * 8).add(new BigInteger(1, bArr4));
        }
        return bigIntegerAdd.mod(bigInteger);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        SAKKEPublicKeyParameters sAKKEPublicKeyParameters = (SAKKEPublicKeyParameters) asymmetricKeyParameter;
        AbstractC5820ECPoint abstractC5820ECPointM15814getZ = sAKKEPublicKeyParameters.m15814getZ();
        BigInteger identifier = sAKKEPublicKeyParameters.getIdentifier();
        BigInteger prime = sAKKEPublicKeyParameters.getPrime();
        BigInteger bigIntegerM15813getQ = sAKKEPublicKeyParameters.m15813getQ();
        BigInteger bigIntegerM15811getG = sAKKEPublicKeyParameters.m15811getG();
        int iM15812getN = sAKKEPublicKeyParameters.m15812getN();
        AbstractC5817ECCurve curve = sAKKEPublicKeyParameters.getCurve();
        AbstractC5820ECPoint point = sAKKEPublicKeyParameters.getPoint();
        InterfaceC5277Digest digest = sAKKEPublicKeyParameters.getDigest();
        BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iM15812getN, this.f20396random);
        BigInteger bigIntegerHashToIntegerRange = hashToIntegerRange(C6238Arrays.concatenate(bigIntegerCreateRandomBigInteger.toByteArray(), identifier.toByteArray()), bigIntegerM15813getQ, digest);
        BigInteger order = curve.getOrder();
        AbstractC5820ECPoint abstractC5820ECPointNormalize = (order == null ? point.multiply(identifier).mo16330add(abstractC5820ECPointM15814getZ).multiply(bigIntegerHashToIntegerRange) : ECAlgorithms.sumOfTwoMultiplies(point, identifier.multiply(bigIntegerHashToIntegerRange).mod(order), abstractC5820ECPointM15814getZ, bigIntegerHashToIntegerRange)).normalize();
        BigInteger bigInteger = BigInteger.ONE;
        AbstractC5820ECPoint abstractC5820ECPointCreatePoint = curve.createPoint(bigInteger, bigIntegerM15811getG);
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = bigIntegerM15811getG;
        for (int iBitLength = bigIntegerHashToIntegerRange.bitLength() - 2; iBitLength >= 0; iBitLength--) {
            BigInteger[] bigIntegerArrFp2PointSquare = SAKKEKEMExtractor.fp2PointSquare(bigInteger2, bigInteger3, prime);
            abstractC5820ECPointCreatePoint = abstractC5820ECPointCreatePoint.timesPow2(2);
            BigInteger bigInteger4 = bigIntegerArrFp2PointSquare[0];
            BigInteger bigInteger5 = bigIntegerArrFp2PointSquare[1];
            if (bigIntegerHashToIntegerRange.testBit(iBitLength)) {
                BigInteger[] bigIntegerArrFp2Multiply = SAKKEKEMExtractor.fp2Multiply(bigInteger4, bigInteger5, bigInteger, bigIntegerM15811getG, prime);
                bigInteger4 = bigIntegerArrFp2Multiply[0];
                bigInteger5 = bigIntegerArrFp2Multiply[1];
            }
            BigInteger bigInteger6 = bigInteger4;
            bigInteger3 = bigInteger5;
            bigInteger2 = bigInteger6;
        }
        return new SecretWithEncapsulationImpl(BigIntegers.asUnsignedByteArray(iM15812getN / 8, bigIntegerCreateRandomBigInteger), C6238Arrays.concatenate(abstractC5820ECPointNormalize.getEncoded(false), BigIntegers.asUnsignedByteArray(16, bigIntegerCreateRandomBigInteger.xor(hashToIntegerRange(bigInteger3.multiply(BigIntegers.modOddInverse(prime, bigInteger2)).mod(prime).toByteArray(), BigInteger.ONE.shiftLeft(iM15812getN), digest)))));
    }
}
