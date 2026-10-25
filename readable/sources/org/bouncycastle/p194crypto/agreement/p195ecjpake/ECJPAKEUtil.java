package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class ECJPAKEUtil {

    /* renamed from: ZERO */
    static final BigInteger f19184ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    static final BigInteger f19183ONE = BigInteger.valueOf(1);

    public static AbstractC5820ECPoint calculateA(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        return abstractC5820ECPoint.multiply(bigInteger);
    }

    public static AbstractC5820ECPoint calculateGA(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, AbstractC5820ECPoint abstractC5820ECPoint3) {
        return abstractC5820ECPoint.mo16330add(abstractC5820ECPoint2).mo16330add(abstractC5820ECPoint3);
    }

    public static AbstractC5820ECPoint calculateGx(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        return abstractC5820ECPoint.multiply(bigInteger);
    }

    private static BigInteger calculateHashForZeroKnowledgeProof(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, AbstractC5820ECPoint abstractC5820ECPoint3, String str, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14968reset();
        updateDigestIncludingSize(interfaceC5277Digest, abstractC5820ECPoint);
        updateDigestIncludingSize(interfaceC5277Digest, abstractC5820ECPoint2);
        updateDigestIncludingSize(interfaceC5277Digest, abstractC5820ECPoint3);
        updateDigestIncludingSize(interfaceC5277Digest, str);
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return new BigInteger(bArr);
    }

    public static BigInteger calculateKeyingMaterial(BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger2, BigInteger bigInteger3, AbstractC5820ECPoint abstractC5820ECPoint2) {
        return abstractC5820ECPoint2.subtract(abstractC5820ECPoint.multiply(bigInteger2.multiply(bigInteger3).mod(bigInteger))).multiply(bigInteger2).normalize().getAffineXCoord().toBigInteger();
    }

    private static byte[] calculateMacKey(BigInteger bigInteger, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14968reset();
        updateDigest(interfaceC5277Digest, bigInteger);
        updateDigest(interfaceC5277Digest, "ECJPAKE_KC");
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    public static BigInteger calculateMacTag(String str, String str2, AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, AbstractC5820ECPoint abstractC5820ECPoint3, AbstractC5820ECPoint abstractC5820ECPoint4, BigInteger bigInteger, InterfaceC5277Digest interfaceC5277Digest) {
        byte[] bArrCalculateMacKey = calculateMacKey(bigInteger, interfaceC5277Digest);
        C5360HMac c5360HMac = new C5360HMac(interfaceC5277Digest);
        byte[] bArr = new byte[c5360HMac.getMacSize()];
        c5360HMac.mo14976init(new KeyParameter(bArrCalculateMacKey));
        updateMac(c5360HMac, "KC_1_U");
        updateMac(c5360HMac, str);
        updateMac(c5360HMac, str2);
        updateMac(c5360HMac, abstractC5820ECPoint);
        updateMac(c5360HMac, abstractC5820ECPoint2);
        updateMac(c5360HMac, abstractC5820ECPoint3);
        updateMac(c5360HMac, abstractC5820ECPoint4);
        c5360HMac.mo14975doFinal(bArr, 0);
        C6238Arrays.m18249fill(bArrCalculateMacKey, (byte) 0);
        return new BigInteger(bArr);
    }

    public static BigInteger calculateS(BigInteger bigInteger, byte[] bArr) throws CryptoException {
        BigInteger bigIntegerMod = new BigInteger(1, bArr).mod(bigInteger);
        if (bigIntegerMod.signum() != 0) {
            return bigIntegerMod;
        }
        throw new CryptoException("MUST ensure s is not equal to 0 modulo n");
    }

    public static BigInteger calculateX2s(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.multiply(bigInteger3).mod(bigInteger);
    }

    public static ECSchnorrZKP calculateZeroKnowledgeProof(AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2, AbstractC5820ECPoint abstractC5820ECPoint2, InterfaceC5277Digest interfaceC5277Digest, String str, SecureRandom secureRandom) {
        BigInteger bigInteger3 = BigInteger.ONE;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger3, bigInteger.subtract(bigInteger3), secureRandom);
        AbstractC5820ECPoint abstractC5820ECPointMultiply = abstractC5820ECPoint.multiply(bigIntegerCreateRandomInRange);
        return new ECSchnorrZKP(abstractC5820ECPointMultiply, bigIntegerCreateRandomInRange.subtract(bigInteger2.multiply(calculateHashForZeroKnowledgeProof(abstractC5820ECPoint, abstractC5820ECPointMultiply, abstractC5820ECPoint2, str, interfaceC5277Digest))).mod(bigInteger));
    }

    public static BigInteger generateX1(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f19183ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    private static byte[] intToByteArray(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    private static void updateDigest(InterfaceC5277Digest interfaceC5277Digest, String str) {
        byte[] uTF8ByteArray = C6250Strings.toUTF8ByteArray(str);
        interfaceC5277Digest.mo14970update(uTF8ByteArray, 0, uTF8ByteArray.length);
        C6238Arrays.m18249fill(uTF8ByteArray, (byte) 0);
    }

    private static void updateDigestIncludingSize(InterfaceC5277Digest interfaceC5277Digest, String str) {
        byte[] uTF8ByteArray = C6250Strings.toUTF8ByteArray(str);
        interfaceC5277Digest.mo14970update(intToByteArray(uTF8ByteArray.length), 0, 4);
        interfaceC5277Digest.mo14970update(uTF8ByteArray, 0, uTF8ByteArray.length);
        C6238Arrays.m18249fill(uTF8ByteArray, (byte) 0);
    }

    private static void updateMac(InterfaceC5278Mac interfaceC5278Mac, String str) {
        byte[] uTF8ByteArray = C6250Strings.toUTF8ByteArray(str);
        interfaceC5278Mac.mo14979update(uTF8ByteArray, 0, uTF8ByteArray.length);
        C6238Arrays.m18249fill(uTF8ByteArray, (byte) 0);
    }

    public static void validateMacTag(String str, String str2, AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, AbstractC5820ECPoint abstractC5820ECPoint3, AbstractC5820ECPoint abstractC5820ECPoint4, BigInteger bigInteger, InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger2) throws CryptoException {
        if (!calculateMacTag(str2, str, abstractC5820ECPoint3, abstractC5820ECPoint4, abstractC5820ECPoint, abstractC5820ECPoint2, bigInteger, interfaceC5277Digest).equals(bigInteger2)) {
            throw new CryptoException("Partner MacTag validation failed. Therefore, the password, MAC, or digest algorithm of each participant does not match.");
        }
    }

    public static void validateNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static void validateParticipantIdsDiffer(String str, String str2) throws CryptoException {
        if (str.equals(str2)) {
            throw new CryptoException("Both participants are using the same participantId (" + str + "). This is not allowed. Each participant must use a unique participantId.");
        }
    }

    public static void validateParticipantIdsEqual(String str, String str2) throws CryptoException {
        if (str.equals(str2)) {
            return;
        }
        throw new CryptoException("Received payload from incorrect partner (" + str2 + "). Expected to receive payload from " + str + ".");
    }

    public static void validateZeroKnowledgeProof(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2, ECSchnorrZKP eCSchnorrZKP, BigInteger bigInteger, BigInteger bigInteger2, AbstractC5817ECCurve abstractC5817ECCurve, BigInteger bigInteger3, String str, InterfaceC5277Digest interfaceC5277Digest) throws CryptoException {
        AbstractC5820ECPoint abstractC5820ECPointM15019getV = eCSchnorrZKP.m15019getV();
        BigInteger bigIntegerM15020getr = eCSchnorrZKP.m15020getr();
        BigInteger bigIntegerCalculateHashForZeroKnowledgeProof = calculateHashForZeroKnowledgeProof(abstractC5820ECPoint, abstractC5820ECPointM15019getV, abstractC5820ECPoint2, str, interfaceC5277Digest);
        if (abstractC5820ECPoint2.isInfinity()) {
            throw new CryptoException("Zero-knowledge proof validation failed: X cannot equal infinity");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint2.normalize();
        if (abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger().signum() < 0 || abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger().compareTo(bigInteger) >= 0 || abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger().signum() < 0 || abstractC5820ECPointNormalize.getAffineYCoord().toBigInteger().compareTo(bigInteger) >= 0) {
            throw new CryptoException("Zero-knowledge proof validation failed: x and y are not in the field");
        }
        try {
            abstractC5817ECCurve.decodePoint(abstractC5820ECPoint2.getEncoded(true));
            if (abstractC5820ECPoint2.multiply(bigInteger3).isInfinity()) {
                throw new CryptoException("Zero-knowledge proof validation failed: Nx cannot be infinity");
            }
            if (!abstractC5820ECPointM15019getV.m16333equals(abstractC5820ECPoint.multiply(bigIntegerM15020getr).mo16330add(abstractC5820ECPoint2.multiply(bigIntegerCalculateHashForZeroKnowledgeProof.mod(bigInteger2))))) {
                throw new CryptoException("Zero-knowledge proof validation failed: V must be a point on the curve");
            }
        } catch (Exception e) {
            throw new CryptoException("Zero-knowledge proof validation failed: x does not lie on the curve", e);
        }
    }

    public static BigInteger calculateS(BigInteger bigInteger, char[] cArr) {
        return calculateS(bigInteger, C6250Strings.toUTF8ByteArray(cArr));
    }

    private static void updateDigest(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        interfaceC5277Digest.mo14970update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
    }

    private static void updateDigestIncludingSize(InterfaceC5277Digest interfaceC5277Digest, AbstractC5820ECPoint abstractC5820ECPoint) {
        byte[] encoded = abstractC5820ECPoint.getEncoded(true);
        interfaceC5277Digest.mo14970update(intToByteArray(encoded.length), 0, 4);
        interfaceC5277Digest.mo14970update(encoded, 0, encoded.length);
        C6238Arrays.m18249fill(encoded, (byte) 0);
    }

    private static void updateMac(InterfaceC5278Mac interfaceC5278Mac, AbstractC5820ECPoint abstractC5820ECPoint) {
        byte[] encoded = abstractC5820ECPoint.getEncoded(true);
        interfaceC5278Mac.mo14979update(encoded, 0, encoded.length);
        C6238Arrays.m18249fill(encoded, (byte) 0);
    }

    private static void updateDigest(InterfaceC5277Digest interfaceC5277Digest, AbstractC5820ECPoint abstractC5820ECPoint) {
        byte[] encoded = abstractC5820ECPoint.getEncoded(true);
        interfaceC5277Digest.mo14970update(encoded, 0, encoded.length);
        C6238Arrays.m18249fill(encoded, (byte) 0);
    }
}
