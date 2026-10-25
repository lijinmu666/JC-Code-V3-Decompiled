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
import org.bouncycastle.p194crypto.p213params.GOST3410KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PublicKeyParameters;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class GOST3410KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: param */
    private GOST3410KeyGenerationParameters f20245param;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        GOST3410Parameters parameters = this.f20245param.getParameters();
        SecureRandom random = this.f20245param.getRandom();
        BigInteger bigIntegerM15752getQ = parameters.m15752getQ();
        BigInteger bigIntegerM15751getP = parameters.m15751getP();
        BigInteger bigIntegerM15750getA = parameters.m15750getA();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(256, random);
            if (bigIntegerCreateRandomBigInteger.signum() >= 1 && bigIntegerCreateRandomBigInteger.compareTo(bigIntegerM15752getQ) < 0 && WNafUtil.getNafWeight(bigIntegerCreateRandomBigInteger) >= 64) {
                return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new GOST3410PublicKeyParameters(bigIntegerM15750getA.modPow(bigIntegerCreateRandomBigInteger, bigIntegerM15751getP), parameters), (AsymmetricKeyParameter) new GOST3410PrivateKeyParameters(bigIntegerCreateRandomBigInteger, parameters));
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        GOST3410KeyGenerationParameters gOST3410KeyGenerationParameters = (GOST3410KeyGenerationParameters) keyGenerationParameters;
        this.f20245param = gOST3410KeyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("GOST3410KeyGen", ConstraintUtils.bitsOfSecurityFor(gOST3410KeyGenerationParameters.getParameters().m15751getP()), this.f20245param.getParameters(), CryptoServicePurpose.KEYGEN));
    }
}
