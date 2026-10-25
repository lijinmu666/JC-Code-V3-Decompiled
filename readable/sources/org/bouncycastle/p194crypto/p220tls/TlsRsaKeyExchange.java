package org.bouncycastle.p194crypto.p220tls;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public abstract class TlsRsaKeyExchange {

    /* renamed from: ONE */
    private static final BigInteger f21110ONE = BigInteger.valueOf(1);
    public static final int PRE_MASTER_SECRET_LENGTH = 48;

    private TlsRsaKeyExchange() {
    }

    /* renamed from: caddTo */
    private static int m15915caddTo(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = i2 & 255;
        int i4 = 0;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            int i6 = i4 + (bArr2[i5] & C1126UByte.MAX_VALUE) + (bArr[i5] & i3);
            bArr2[i5] = (byte) i6;
            i4 = i6 >>> 8;
        }
        return i4;
    }

    private static int checkPkcs1Encoding2(byte[] bArr, int i, int i2) {
        int i3 = (i - i2) - 10;
        int length = bArr.length - i;
        int length2 = (bArr.length - 1) - i2;
        for (int i4 = 0; i4 < length; i4++) {
            i3 |= -(bArr[i4] & 255);
        }
        int i5 = -((bArr[length] & 255) ^ 2);
        while (true) {
            i5 |= i3;
            length++;
            if (length >= length2) {
                return ((-(bArr[length2] & 255)) | i5) >> 31;
            }
            i3 = (bArr[length] & 255) - 1;
        }
    }

    private static BigInteger convertInput(BigInteger bigInteger, byte[] bArr, int i, int i2) {
        BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, i, i2);
        if (bigIntegerFromUnsignedByteArray.compareTo(bigInteger) < 0) {
            return bigIntegerFromUnsignedByteArray;
        }
        throw new DataLengthException("input too large for RSA cipher.");
    }

    public static byte[] decryptPreMasterSecret(byte[] bArr, int i, int i2, RSAKeyParameters rSAKeyParameters, int i3, SecureRandom secureRandom) {
        if (bArr == null || i2 < 1 || i2 > getInputLimit(rSAKeyParameters) || i < 0 || i > bArr.length - i2) {
            throw new IllegalArgumentException("input not a valid EncryptedPreMasterSecret");
        }
        if (!rSAKeyParameters.isPrivate()) {
            throw new IllegalArgumentException("'privateKey' must be an RSA private key");
        }
        BigInteger modulus = rSAKeyParameters.getModulus();
        int iBitLength = modulus.bitLength();
        if (iBitLength < 512) {
            throw new IllegalArgumentException("'privateKey' must be at least 512 bits");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSA", ConstraintUtils.bitsOfSecurityFor(modulus), rSAKeyParameters, CryptoServicePurpose.DECRYPTION));
        if ((i3 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) != i3) {
            throw new IllegalArgumentException("'protocolVersion' must be a 16 bit value");
        }
        SecureRandom secureRandom2 = CryptoServicesRegistrar.getSecureRandom(secureRandom);
        byte[] bArr2 = new byte[48];
        secureRandom2.nextBytes(bArr2);
        try {
            byte[] bArrRsaBlinded = rsaBlinded(rSAKeyParameters, convertInput(modulus, bArr, i, i2), secureRandom2);
            int length = bArrRsaBlinded.length - 48;
            int iCheckPkcs1Encoding2 = checkPkcs1Encoding2(bArrRsaBlinded, (iBitLength - 1) / 8, 48) | ((-((AbstractC6245Pack.bigEndianToShort(bArrRsaBlinded, length) ^ i3) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH)) >> 31);
            for (int i4 = 0; i4 < 48; i4++) {
                bArr2[i4] = (byte) ((bArr2[i4] & iCheckPkcs1Encoding2) | (bArrRsaBlinded[length + i4] & (~iCheckPkcs1Encoding2)));
            }
            C6238Arrays.m18249fill(bArrRsaBlinded, (byte) 0);
        } catch (Exception unused) {
        }
        return bArr2;
    }

    public static int getInputLimit(RSAKeyParameters rSAKeyParameters) {
        return (rSAKeyParameters.getModulus().bitLength() + 7) / 8;
    }

    /* renamed from: rsa */
    private static BigInteger m15916rsa(RSAKeyParameters rSAKeyParameters, BigInteger bigInteger) {
        return bigInteger.modPow(rSAKeyParameters.getExponent(), rSAKeyParameters.getModulus());
    }

    private static byte[] rsaBlinded(RSAKeyParameters rSAKeyParameters, BigInteger bigInteger, SecureRandom secureRandom) {
        RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters;
        BigInteger publicExponent;
        BigInteger modulus = rSAKeyParameters.getModulus();
        int iBitLength = (modulus.bitLength() / 8) + 1;
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) || (publicExponent = (rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters).getPublicExponent()) == null) {
            return m15919toBytes(m15916rsa(rSAKeyParameters, bigInteger), iBitLength);
        }
        BigInteger bigInteger2 = f21110ONE;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger2, modulus.subtract(bigInteger2), secureRandom);
        BigInteger bigIntegerModPow = bigIntegerCreateRandomInRange.modPow(publicExponent, modulus);
        BigInteger bigIntegerModOddInverse = BigIntegers.modOddInverse(modulus, bigIntegerCreateRandomInRange);
        BigInteger bigIntegerM15917rsaCrt = m15917rsaCrt(rSAPrivateCrtKeyParameters, bigIntegerModPow.multiply(bigInteger).mod(modulus));
        BigInteger bigIntegerMod = bigIntegerModOddInverse.add(bigInteger2).multiply(bigIntegerM15917rsaCrt).mod(modulus);
        byte[] bArrM15919toBytes = m15919toBytes(bigIntegerM15917rsaCrt, iBitLength);
        byte[] bArrM15919toBytes2 = m15919toBytes(modulus, iBitLength);
        byte[] bArrM15919toBytes3 = m15919toBytes(bigIntegerMod, iBitLength);
        m15915caddTo(iBitLength, m15918subFrom(iBitLength, bArrM15919toBytes, bArrM15919toBytes3), bArrM15919toBytes2, bArrM15919toBytes3);
        return bArrM15919toBytes3;
    }

    /* renamed from: rsaCrt */
    private static BigInteger m15917rsaCrt(RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters, BigInteger bigInteger) {
        BigInteger publicExponent = rSAPrivateCrtKeyParameters.getPublicExponent();
        BigInteger bigIntegerM15808getP = rSAPrivateCrtKeyParameters.m15808getP();
        BigInteger bigIntegerM15809getQ = rSAPrivateCrtKeyParameters.m15809getQ();
        BigInteger bigIntegerM15806getDP = rSAPrivateCrtKeyParameters.m15806getDP();
        BigInteger bigIntegerM15807getDQ = rSAPrivateCrtKeyParameters.m15807getDQ();
        BigInteger bigIntegerM15810getQInv = rSAPrivateCrtKeyParameters.m15810getQInv();
        BigInteger bigIntegerModPow = bigInteger.remainder(bigIntegerM15808getP).modPow(bigIntegerM15806getDP, bigIntegerM15808getP);
        BigInteger bigIntegerModPow2 = bigInteger.remainder(bigIntegerM15809getQ).modPow(bigIntegerM15807getDQ, bigIntegerM15809getQ);
        BigInteger bigIntegerAdd = bigIntegerModPow.subtract(bigIntegerModPow2).multiply(bigIntegerM15810getQInv).mod(bigIntegerM15808getP).multiply(bigIntegerM15809getQ).add(bigIntegerModPow2);
        if (bigIntegerAdd.modPow(publicExponent, rSAPrivateCrtKeyParameters.getModulus()).equals(bigInteger)) {
            return bigIntegerAdd;
        }
        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
    }

    /* renamed from: subFrom */
    private static int m15918subFrom(int i, byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            int i4 = i2 + ((bArr2[i3] & C1126UByte.MAX_VALUE) - (bArr[i3] & C1126UByte.MAX_VALUE));
            bArr2[i3] = (byte) i4;
            i2 = i4 >> 8;
        }
        return i2;
    }

    /* renamed from: toBytes */
    private static byte[] m15919toBytes(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i];
        System.arraycopy(byteArray, 0, bArr, i - byteArray.length, byteArray.length);
        return bArr;
    }
}
