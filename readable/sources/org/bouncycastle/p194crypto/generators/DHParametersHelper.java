package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
class DHParametersHelper {

    /* renamed from: ONE */
    private static final BigInteger f20222ONE = BigInteger.valueOf(1);

    /* renamed from: TWO */
    private static final BigInteger f20223TWO = BigInteger.valueOf(2);

    public static BigInteger[] generateSafePrimes(int i, int i2, SecureRandom secureRandom) {
        int i3 = i - 1;
        int i4 = i >>> 2;
        while (true) {
            BigInteger bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i3, 2, secureRandom);
            BigInteger bigIntegerAdd = bigIntegerCreateRandomPrime.shiftLeft(1).add(f20222ONE);
            if (bigIntegerAdd.isProbablePrime(i2) && (i2 <= 2 || bigIntegerCreateRandomPrime.isProbablePrime(i2 - 2))) {
                if (WNafUtil.getNafWeight(bigIntegerAdd) >= i4) {
                    return new BigInteger[]{bigIntegerAdd, bigIntegerCreateRandomPrime};
                }
            }
        }
    }

    public static BigInteger selectGenerator(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerSubtract = bigInteger.subtract(f20223TWO);
        do {
            BigInteger bigInteger3 = f20223TWO;
            bigIntegerModPow = BigIntegers.createRandomInRange(bigInteger3, bigIntegerSubtract, secureRandom).modPow(bigInteger3, bigInteger);
        } while (bigIntegerModPow.equals(f20222ONE));
        return bigIntegerModPow;
    }
}
