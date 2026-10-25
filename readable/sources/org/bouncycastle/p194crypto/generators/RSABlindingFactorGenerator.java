package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class RSABlindingFactorGenerator {

    /* renamed from: TWO */
    private static BigInteger f20279TWO = BigInteger.valueOf(2);

    /* renamed from: key */
    private RSAKeyParameters f20280key;

    /* renamed from: random */
    private SecureRandom f20281random;

    public BigInteger generateBlindingFactor() {
        RSAKeyParameters rSAKeyParameters = this.f20280key;
        if (rSAKeyParameters == null) {
            throw new IllegalStateException("generator not initialised");
        }
        BigInteger modulus = rSAKeyParameters.getModulus();
        int iBitLength = modulus.bitLength() - 1;
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.f20281random);
            if (bigIntegerCreateRandomBigInteger.compareTo(f20279TWO) >= 0 && BigIntegers.modOddIsCoprime(modulus, bigIntegerCreateRandomBigInteger)) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }

    /* renamed from: init */
    public void m15500init(CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f20280key = (RSAKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            this.f20280key = (RSAKeyParameters) cipherParameters;
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.f20281random = secureRandom;
        if (this.f20280key instanceof RSAPrivateCrtKeyParameters) {
            throw new IllegalArgumentException("generator requires RSA public key");
        }
    }
}
