package org.bouncycastle.p194crypto.agreement.p198srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class SRP6Util {

    /* renamed from: ZERO */
    private static BigInteger f19254ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    private static BigInteger f19253ONE = BigInteger.valueOf(1);

    public static BigInteger calculateK(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2) {
        return hashPaddedPair(interfaceC5277Digest, bigInteger, bigInteger, bigInteger2);
    }

    public static BigInteger calculateKey(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] padded = getPadded(bigInteger2, (bigInteger.bitLength() + 7) / 8);
        interfaceC5277Digest.mo14970update(padded, 0, padded.length);
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger calculateM1(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return hashPaddedTriplet(interfaceC5277Digest, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }

    public static BigInteger calculateM2(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return hashPaddedTriplet(interfaceC5277Digest, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }

    public static BigInteger calculateU(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return hashPaddedPair(interfaceC5277Digest, bigInteger, bigInteger2, bigInteger3);
    }

    public static BigInteger calculateX(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int digestSize = interfaceC5277Digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        interfaceC5277Digest.mo14970update(bArr2, 0, bArr2.length);
        interfaceC5277Digest.mo14969update((byte) 58);
        interfaceC5277Digest.mo14970update(bArr3, 0, bArr3.length);
        interfaceC5277Digest.mo14967doFinal(bArr4, 0);
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        interfaceC5277Digest.mo14970update(bArr4, 0, digestSize);
        interfaceC5277Digest.mo14967doFinal(bArr4, 0);
        return new BigInteger(1, bArr4);
    }

    public static BigInteger generatePrivateValue(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return BigIntegers.createRandomInRange(f19253ONE.shiftLeft(Math.min(256, bigInteger.bitLength() / 2) - 1), bigInteger.subtract(f19253ONE), secureRandom);
    }

    private static byte[] getPadded(BigInteger bigInteger, int i) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        if (bArrAsUnsignedByteArray.length >= i) {
            return bArrAsUnsignedByteArray;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(bArrAsUnsignedByteArray, 0, bArr, i - bArrAsUnsignedByteArray.length, bArrAsUnsignedByteArray.length);
        return bArr;
    }

    private static BigInteger hashPaddedPair(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int iBitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] padded = getPadded(bigInteger2, iBitLength);
        byte[] padded2 = getPadded(bigInteger3, iBitLength);
        interfaceC5277Digest.mo14970update(padded, 0, padded.length);
        interfaceC5277Digest.mo14970update(padded2, 0, padded2.length);
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return new BigInteger(1, bArr);
    }

    private static BigInteger hashPaddedTriplet(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        int iBitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] padded = getPadded(bigInteger2, iBitLength);
        byte[] padded2 = getPadded(bigInteger3, iBitLength);
        byte[] padded3 = getPadded(bigInteger4, iBitLength);
        interfaceC5277Digest.mo14970update(padded, 0, padded.length);
        interfaceC5277Digest.mo14970update(padded2, 0, padded2.length);
        interfaceC5277Digest.mo14970update(padded3, 0, padded3.length);
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger validatePublicValue(BigInteger bigInteger, BigInteger bigInteger2) throws CryptoException {
        BigInteger bigIntegerMod = bigInteger2.mod(bigInteger);
        if (bigIntegerMod.equals(f19254ZERO)) {
            throw new CryptoException("Invalid public value: 0");
        }
        return bigIntegerMod;
    }
}
