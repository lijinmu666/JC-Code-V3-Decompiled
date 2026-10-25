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
import org.bouncycastle.p194crypto.p213params.CramerShoupKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.CramerShoupParameters;
import org.bouncycastle.p194crypto.p213params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.CramerShoupPublicKeyParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class CramerShoupKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: ONE */
    private static final BigInteger f20208ONE = BigInteger.valueOf(1);

    /* renamed from: param */
    private CramerShoupKeyGenerationParameters f20209param;

    private CramerShoupPublicKeyParameters calculatePublicKey(CramerShoupParameters cramerShoupParameters, CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters) {
        BigInteger bigIntegerM15675getG1 = cramerShoupParameters.m15675getG1();
        BigInteger bigIntegerM15676getG2 = cramerShoupParameters.m15676getG2();
        BigInteger bigIntegerM15678getP = cramerShoupParameters.m15678getP();
        return new CramerShoupPublicKeyParameters(cramerShoupParameters, bigIntegerM15675getG1.modPow(cramerShoupPrivateKeyParameters.m15680getX1(), bigIntegerM15678getP).multiply(bigIntegerM15676getG2.modPow(cramerShoupPrivateKeyParameters.m15681getX2(), bigIntegerM15678getP)), bigIntegerM15675getG1.modPow(cramerShoupPrivateKeyParameters.m15682getY1(), bigIntegerM15678getP).multiply(bigIntegerM15676getG2.modPow(cramerShoupPrivateKeyParameters.m15683getY2(), bigIntegerM15678getP)), bigIntegerM15675getG1.modPow(cramerShoupPrivateKeyParameters.m15684getZ(), bigIntegerM15678getP));
    }

    private CramerShoupPrivateKeyParameters generatePrivateKey(SecureRandom secureRandom, CramerShoupParameters cramerShoupParameters) {
        BigInteger bigIntegerM15678getP = cramerShoupParameters.m15678getP();
        return new CramerShoupPrivateKeyParameters(cramerShoupParameters, generateRandomElement(bigIntegerM15678getP, secureRandom), generateRandomElement(bigIntegerM15678getP, secureRandom), generateRandomElement(bigIntegerM15678getP, secureRandom), generateRandomElement(bigIntegerM15678getP, secureRandom), generateRandomElement(bigIntegerM15678getP, secureRandom));
    }

    private BigInteger generateRandomElement(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f20208ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        CramerShoupParameters parameters = this.f20209param.getParameters();
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParametersGeneratePrivateKey = generatePrivateKey(this.f20209param.getRandom(), parameters);
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParametersCalculatePublicKey = calculatePublicKey(parameters, cramerShoupPrivateKeyParametersGeneratePrivateKey);
        cramerShoupPrivateKeyParametersGeneratePrivateKey.m15685setPk(cramerShoupPublicKeyParametersCalculatePublicKey);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) cramerShoupPublicKeyParametersCalculatePublicKey, (AsymmetricKeyParameter) cramerShoupPrivateKeyParametersGeneratePrivateKey);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        CramerShoupKeyGenerationParameters cramerShoupKeyGenerationParameters = (CramerShoupKeyGenerationParameters) keyGenerationParameters;
        this.f20209param = cramerShoupKeyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("CramerShoupKeyGen", ConstraintUtils.bitsOfSecurityFor(cramerShoupKeyGenerationParameters.getParameters().m15678getP()), this.f20209param.getParameters(), CryptoServicePurpose.KEYGEN));
    }
}
