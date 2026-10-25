package org.bouncycastle.p194crypto.hash2curve;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class H2cUtils {
    /* renamed from: cmov */
    public static BigInteger m15507cmov(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return z ? bigInteger2 : bigInteger;
    }

    private static BigInteger getFirstNonSquare(BigInteger bigInteger) {
        BigInteger bigInteger2 = new BigInteger("1000");
        BigInteger bigIntegerAdd = BigInteger.ONE;
        while (isSquare(bigIntegerAdd, bigInteger)) {
            bigIntegerAdd = bigIntegerAdd.add(BigInteger.ONE);
            if (bigIntegerAdd.compareTo(bigInteger2) > 0) {
                throw new RuntimeException("Illegal Field. No non square value can be found");
            }
        }
        return bigIntegerAdd;
    }

    /* renamed from: i2osp */
    public static byte[] m15508i2osp(int i, int i2) {
        byte[] bArrConcatenate = (byte[]) new BigInteger(String.valueOf(i)).toByteArray().clone();
        if (bArrConcatenate.length > 1 && bArrConcatenate[0] == 0) {
            bArrConcatenate = C6238Arrays.copyOfRange(bArrConcatenate, 1, bArrConcatenate.length);
        }
        if (bArrConcatenate.length > i2) {
            throw new IllegalArgumentException("Value require more bytes than the assigned length size");
        }
        if (bArrConcatenate.length < i2) {
            for (int length = bArrConcatenate.length; length < i2; length++) {
                bArrConcatenate = C6238Arrays.concatenate(new byte[]{0}, bArrConcatenate);
            }
        }
        return bArrConcatenate;
    }

    /* renamed from: inv0 */
    public static BigInteger m15509inv0(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.modInverse(bigInteger2);
    }

    public static boolean isSquare(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ONE;
        BigInteger bigIntegerModPow = bigInteger.modPow(bigInteger2.subtract(bigInteger3).divide(BigInteger.valueOf(2L)), bigInteger2);
        return bigIntegerModPow.equals(bigInteger3) || bigIntegerModPow.equals(BigInteger.ZERO);
    }

    /* renamed from: os2ip */
    public static BigInteger m15510os2ip(byte[] bArr) {
        return new BigInteger(C6238Arrays.concatenate(new byte[]{0}, bArr));
    }

    private static void requireNonNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    /* renamed from: sgn0 */
    public static int m15511sgn0(BigInteger bigInteger, AbstractC5817ECCurve abstractC5817ECCurve) {
        if (abstractC5817ECCurve.getField().getDimension() == 1) {
            return bigInteger.intValue() & 1;
        }
        throw new IllegalArgumentException("Extension fields must be 1 for supported elliptic curves");
    }

    /* renamed from: sqrt */
    public static BigInteger m15512sqrt(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ONE;
        int lowestSetBit = bigInteger2.subtract(bigInteger3).getLowestSetBit();
        BigInteger bigIntegerDivide = bigInteger2.subtract(bigInteger3).divide(BigInteger.valueOf(2L).pow(lowestSetBit));
        BigInteger bigIntegerDivide2 = bigIntegerDivide.subtract(bigInteger3).divide(BigInteger.valueOf(2L));
        BigInteger bigIntegerModPow = getFirstNonSquare(bigInteger2).modPow(bigIntegerDivide, bigInteger2);
        BigInteger bigIntegerModPow2 = bigInteger.modPow(bigIntegerDivide2, bigInteger2);
        BigInteger bigIntegerMod = bigIntegerModPow2.multiply(bigIntegerModPow2).multiply(bigInteger).mod(bigInteger2);
        BigInteger bigIntegerMod2 = bigIntegerModPow2.multiply(bigInteger).mod(bigInteger2);
        while (lowestSetBit >= 2) {
            BigInteger bigIntegerMod3 = bigIntegerMod;
            for (int i = 1; i <= lowestSetBit - 2; i++) {
                bigIntegerMod3 = bigIntegerMod3.multiply(bigIntegerMod3).mod(bigInteger2);
            }
            boolean zEquals = bigIntegerMod3.equals(BigInteger.ONE);
            bigIntegerMod2 = m15507cmov(bigIntegerMod2.multiply(bigIntegerModPow).mod(bigInteger2), bigIntegerMod2, zEquals);
            bigIntegerModPow = bigIntegerModPow.multiply(bigIntegerModPow).mod(bigInteger2);
            bigIntegerMod = m15507cmov(bigIntegerMod.multiply(bigIntegerModPow).mod(bigInteger2), bigIntegerMod, zEquals);
            lowestSetBit--;
        }
        return bigIntegerMod2;
    }

    /* renamed from: xor */
    public static byte[] m15513xor(byte[] bArr, byte[] bArr2) {
        requireNonNull(bArr, "XOR argument must not be null");
        requireNonNull(bArr2, "XOR argument must not be null");
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("XOR operation on parameters of different lengths");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }
}
