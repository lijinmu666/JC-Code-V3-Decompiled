package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHValidationParameters;

/* loaded from: classes2.dex */
public class DHParametersGenerator {

    /* renamed from: TWO */
    private static final BigInteger f20219TWO = BigInteger.valueOf(2);
    private int certainty;

    /* renamed from: random */
    private SecureRandom f20220random;

    /* renamed from: size */
    private int f20221size;

    public DHParameters generateParameters() {
        BigInteger[] bigIntegerArrGenerateSafePrimes = DHParametersHelper.generateSafePrimes(this.f20221size, this.certainty, this.f20220random);
        BigInteger bigInteger = bigIntegerArrGenerateSafePrimes[0];
        BigInteger bigInteger2 = bigIntegerArrGenerateSafePrimes[1];
        return new DHParameters(bigInteger, DHParametersHelper.selectGenerator(bigInteger, bigInteger2, this.f20220random), bigInteger2, f20219TWO, (DHValidationParameters) null);
    }

    /* renamed from: init */
    public void m15487init(int i, int i2, SecureRandom secureRandom) {
        this.f20221size = i;
        this.certainty = i2;
        this.f20220random = secureRandom;
    }
}
