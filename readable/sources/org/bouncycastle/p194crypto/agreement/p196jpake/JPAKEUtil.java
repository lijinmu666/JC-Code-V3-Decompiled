package org.bouncycastle.p194crypto.agreement.p196jpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class JPAKEUtil {

    /* renamed from: ZERO */
    static final BigInteger f19208ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    static final BigInteger f19207ONE = BigInteger.valueOf(1);

    public static BigInteger calculateA(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return bigInteger3.modPow(bigInteger4, bigInteger);
    }

    public static BigInteger calculateGA(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return bigInteger2.multiply(bigInteger3).multiply(bigInteger4).mod(bigInteger);
    }

    public static BigInteger calculateGx(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }

    private static BigInteger calculateHashForZeroKnowledgeProof(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, String str, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14968reset();
        updateDigestIncludingSize(interfaceC5277Digest, bigInteger);
        updateDigestIncludingSize(interfaceC5277Digest, bigInteger2);
        updateDigestIncludingSize(interfaceC5277Digest, bigInteger3);
        updateDigestIncludingSize(interfaceC5277Digest, str);
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return new BigInteger(bArr);
    }

    public static BigInteger calculateKeyingMaterial(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6) {
        return bigInteger3.modPow(bigInteger4.multiply(bigInteger5).negate().mod(bigInteger2), bigInteger).multiply(bigInteger6).modPow(bigInteger4, bigInteger);
    }

    private static byte[] calculateMacKey(BigInteger bigInteger, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14968reset();
        updateDigest(interfaceC5277Digest, bigInteger);
        updateDigest(interfaceC5277Digest, "JPAKE_KC");
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    public static BigInteger calculateMacTag(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, InterfaceC5277Digest interfaceC5277Digest) {
        byte[] bArrCalculateMacKey = calculateMacKey(bigInteger5, interfaceC5277Digest);
        C5360HMac c5360HMac = new C5360HMac(interfaceC5277Digest);
        byte[] bArr = new byte[c5360HMac.getMacSize()];
        c5360HMac.mo14976init(new KeyParameter(bArrCalculateMacKey));
        updateMac(c5360HMac, "KC_1_U");
        updateMac(c5360HMac, str);
        updateMac(c5360HMac, str2);
        updateMac(c5360HMac, bigInteger);
        updateMac(c5360HMac, bigInteger2);
        updateMac(c5360HMac, bigInteger3);
        updateMac(c5360HMac, bigInteger4);
        c5360HMac.mo14975doFinal(bArr, 0);
        C6238Arrays.m18249fill(bArrCalculateMacKey, (byte) 0);
        return new BigInteger(bArr);
    }

    public static BigInteger calculateS(BigInteger bigInteger, byte[] bArr) throws CryptoException {
        BigInteger bigIntegerMod = new BigInteger(1, bArr).mod(bigInteger);
        if (bigIntegerMod.signum() != 0) {
            return bigIntegerMod;
        }
        throw new CryptoException("MUST ensure s is not equal to 0 modulo q");
    }

    public static BigInteger calculateX2s(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.multiply(bigInteger3).mod(bigInteger);
    }

    public static BigInteger[] calculateZeroKnowledgeProof(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, String str, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(f19208ZERO, bigInteger2.subtract(f19207ONE), secureRandom);
        BigInteger bigIntegerModPow = bigInteger3.modPow(bigIntegerCreateRandomInRange, bigInteger);
        return new BigInteger[]{bigIntegerModPow, bigIntegerCreateRandomInRange.subtract(bigInteger5.multiply(calculateHashForZeroKnowledgeProof(bigInteger3, bigIntegerModPow, bigInteger4, str, interfaceC5277Digest))).mod(bigInteger2)};
    }

    public static BigInteger generateX1(BigInteger bigInteger, SecureRandom secureRandom) {
        return BigIntegers.createRandomInRange(f19208ZERO, bigInteger.subtract(f19207ONE), secureRandom);
    }

    public static BigInteger generateX2(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f19207ONE;
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

    public static void validateGa(BigInteger bigInteger) throws CryptoException {
        if (bigInteger.equals(f19207ONE)) {
            throw new CryptoException("ga is equal to 1.  It should not be.  The chances of this happening are on the order of 2^160 for a 160-bit q.  Try again.");
        }
    }

    public static void validateGx4(BigInteger bigInteger) throws CryptoException {
        if (bigInteger.equals(f19207ONE)) {
            throw new CryptoException("g^x validation failed.  g^x should not be 1.");
        }
    }

    public static void validateMacTag(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger6) throws CryptoException {
        if (!calculateMacTag(str2, str, bigInteger3, bigInteger4, bigInteger, bigInteger2, bigInteger5, interfaceC5277Digest).equals(bigInteger6)) {
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

    public static void validateZeroKnowledgeProof(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger[] bigIntegerArr, String str, InterfaceC5277Digest interfaceC5277Digest) throws CryptoException {
        BigInteger bigInteger5 = bigIntegerArr[0];
        BigInteger bigInteger6 = bigIntegerArr[1];
        BigInteger bigIntegerCalculateHashForZeroKnowledgeProof = calculateHashForZeroKnowledgeProof(bigInteger3, bigInteger5, bigInteger4, str, interfaceC5277Digest);
        if (bigInteger4.signum() <= 0 || bigInteger4.compareTo(bigInteger) >= 0 || !bigInteger4.modPow(bigInteger2, bigInteger).equals(f19207ONE) || !bigInteger3.modPow(bigInteger6, bigInteger).multiply(bigInteger4.modPow(bigIntegerCalculateHashForZeroKnowledgeProof, bigInteger)).mod(bigInteger).equals(bigInteger5)) {
            throw new CryptoException("Zero-knowledge proof validation failed");
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

    private static void updateDigestIncludingSize(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        interfaceC5277Digest.mo14970update(intToByteArray(bArrAsUnsignedByteArray.length), 0, 4);
        interfaceC5277Digest.mo14970update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
    }

    private static void updateMac(InterfaceC5278Mac interfaceC5278Mac, BigInteger bigInteger) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        interfaceC5278Mac.mo14979update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
    }

    public static BigInteger calculateS(char[] cArr) {
        return new BigInteger(1, C6250Strings.toUTF8ByteArray(cArr));
    }
}
