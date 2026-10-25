package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p213params.CramerShoupParameters;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class CramerShoupParametersGenerator {

    /* renamed from: ONE */
    private static final BigInteger f20210ONE = BigInteger.valueOf(1);
    private int certainty;

    /* renamed from: random */
    private SecureRandom f20211random;

    /* renamed from: size */
    private int f20212size;

    public static class ParametersHelper {

        /* renamed from: TWO */
        private static final BigInteger f20213TWO = BigInteger.valueOf(2);

        private ParametersHelper() {
        }

        public static BigInteger[] generateSafePrimes(int i, int i2, SecureRandom secureRandom) {
            BigInteger bigIntegerCreateRandomPrime;
            BigInteger bigIntegerAdd;
            int i3 = i - 1;
            while (true) {
                bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i3, 2, secureRandom);
                bigIntegerAdd = bigIntegerCreateRandomPrime.shiftLeft(1).add(CramerShoupParametersGenerator.f20210ONE);
                if (bigIntegerAdd.isProbablePrime(i2) && (i2 <= 2 || bigIntegerCreateRandomPrime.isProbablePrime(i2))) {
                    break;
                }
            }
            return new BigInteger[]{bigIntegerAdd, bigIntegerCreateRandomPrime};
        }

        public static BigInteger selectGenerator(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger bigIntegerModPow;
            BigInteger bigIntegerSubtract = bigInteger.subtract(f20213TWO);
            do {
                BigInteger bigInteger2 = f20213TWO;
                bigIntegerModPow = BigIntegers.createRandomInRange(bigInteger2, bigIntegerSubtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (bigIntegerModPow.equals(CramerShoupParametersGenerator.f20210ONE));
            return bigIntegerModPow;
        }
    }

    public CramerShoupParameters generateParameters() {
        BigInteger bigIntegerSelectGenerator;
        BigInteger bigInteger = ParametersHelper.generateSafePrimes(this.f20212size, this.certainty, this.f20211random)[1];
        BigInteger bigIntegerSelectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.f20211random);
        do {
            bigIntegerSelectGenerator = ParametersHelper.selectGenerator(bigInteger, this.f20211random);
        } while (bigIntegerSelectGenerator2.equals(bigIntegerSelectGenerator));
        return new CramerShoupParameters(bigInteger, bigIntegerSelectGenerator2, bigIntegerSelectGenerator, SHA256Digest.newInstance());
    }

    /* renamed from: init */
    public void m15486init(int i, int i2, SecureRandom secureRandom) {
        this.f20212size = i;
        this.certainty = i2;
        this.f20211random = secureRandom;
    }

    public CramerShoupParameters generateParameters(DHParameters dHParameters) {
        BigInteger bigIntegerSelectGenerator;
        BigInteger bigIntegerM15695getP = dHParameters.m15695getP();
        BigInteger bigIntegerM15691getG = dHParameters.m15691getG();
        do {
            bigIntegerSelectGenerator = ParametersHelper.selectGenerator(bigIntegerM15695getP, this.f20211random);
        } while (bigIntegerM15691getG.equals(bigIntegerSelectGenerator));
        return new CramerShoupParameters(bigIntegerM15695getP, bigIntegerM15691getG, bigIntegerSelectGenerator, SHA256Digest.newInstance());
    }
}
