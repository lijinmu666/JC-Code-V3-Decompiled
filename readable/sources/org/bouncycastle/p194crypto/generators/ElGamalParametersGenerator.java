package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p213params.ElGamalParameters;

/* loaded from: classes2.dex */
public class ElGamalParametersGenerator {
    private int certainty;

    /* renamed from: random */
    private SecureRandom f20242random;

    /* renamed from: size */
    private int f20243size;

    public ElGamalParameters generateParameters() {
        BigInteger[] bigIntegerArrGenerateSafePrimes = DHParametersHelper.generateSafePrimes(this.f20243size, this.certainty, this.f20242random);
        BigInteger bigInteger = bigIntegerArrGenerateSafePrimes[0];
        return new ElGamalParameters(bigInteger, DHParametersHelper.selectGenerator(bigInteger, bigIntegerArrGenerateSafePrimes[1], this.f20242random));
    }

    /* renamed from: init */
    public void m15492init(int i, int i2, SecureRandom secureRandom) {
        this.f20243size = i;
        this.certainty = i2;
        this.f20242random = secureRandom;
    }
}
