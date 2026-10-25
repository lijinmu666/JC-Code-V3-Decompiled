package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();

    /* renamed from: ONE */
    private static final BigInteger f20216ONE = BigInteger.valueOf(1);

    /* renamed from: TWO */
    private static final BigInteger f20217TWO = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    public BigInteger calculatePrivate(DHParameters dHParameters, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomInRange;
        BigInteger bit;
        int iM15693getL = dHParameters.m15693getL();
        if (iM15693getL != 0) {
            int i = iM15693getL >>> 2;
            do {
                bit = BigIntegers.createRandomBigInteger(iM15693getL, secureRandom).setBit(iM15693getL - 1);
            } while (WNafUtil.getNafWeight(bit) < i);
            return bit;
        }
        BigInteger bigInteger = f20217TWO;
        int iM15694getM = dHParameters.m15694getM();
        BigInteger bigIntegerShiftLeft = iM15694getM != 0 ? f20216ONE.shiftLeft(iM15694getM - 1) : bigInteger;
        BigInteger bigIntegerM15696getQ = dHParameters.m15696getQ();
        if (bigIntegerM15696getQ == null) {
            bigIntegerM15696getQ = dHParameters.m15695getP();
        }
        BigInteger bigIntegerSubtract = bigIntegerM15696getQ.subtract(bigInteger);
        int iBitLength = bigIntegerSubtract.bitLength() >>> 2;
        do {
            bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigIntegerShiftLeft, bigIntegerSubtract, secureRandom);
        } while (WNafUtil.getNafWeight(bigIntegerCreateRandomInRange) < iBitLength);
        return bigIntegerCreateRandomInRange;
    }

    public BigInteger calculatePublic(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.m15691getG().modPow(bigInteger, dHParameters.m15695getP());
    }
}
