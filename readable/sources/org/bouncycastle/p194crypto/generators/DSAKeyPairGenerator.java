package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DSAKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DSAPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: ONE */
    private static final BigInteger f20224ONE = BigInteger.valueOf(1);

    /* renamed from: param */
    private DSAKeyGenerationParameters f20225param;

    private static BigInteger calculatePublicKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }

    private static BigInteger generatePrivateKey(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomInRange;
        int iBitLength = bigInteger.bitLength() >>> 2;
        do {
            BigInteger bigInteger2 = f20224ONE;
            bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
        } while (WNafUtil.getNafWeight(bigIntegerCreateRandomInRange) < iBitLength);
        return bigIntegerCreateRandomInRange;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        DSAParameters parameters = this.f20225param.getParameters();
        BigInteger bigIntegerGeneratePrivateKey = generatePrivateKey(parameters.m15706getQ(), this.f20225param.getRandom());
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new DSAPublicKeyParameters(calculatePublicKey(parameters.m15705getP(), parameters.m15704getG(), bigIntegerGeneratePrivateKey), parameters), (AsymmetricKeyParameter) new DSAPrivateKeyParameters(bigIntegerGeneratePrivateKey, parameters));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        DSAKeyGenerationParameters dSAKeyGenerationParameters = (DSAKeyGenerationParameters) keyGenerationParameters;
        this.f20225param = dSAKeyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("DSAKeyGen", ConstraintUtils.bitsOfSecurityFor(dSAKeyGenerationParameters.getParameters().m15705getP()), this.f20225param.getParameters(), CryptoServicePurpose.KEYGEN));
    }
}
