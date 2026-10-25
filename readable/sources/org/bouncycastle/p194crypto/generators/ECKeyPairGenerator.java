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
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {

    /* renamed from: name */
    private final String f20236name;

    /* renamed from: params */
    ECDomainParameters f20237params;

    /* renamed from: random */
    SecureRandom f20238random;

    public ECKeyPairGenerator() {
        this("ECKeyGen");
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigIntegerM15723getN = this.f20237params.m15723getN();
        int iBitLength = bigIntegerM15723getN.bitLength();
        int i = iBitLength >>> 2;
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.f20238random);
            if (!isOutOfRangeD(bigIntegerCreateRandomBigInteger, bigIntegerM15723getN) && WNafUtil.getNafWeight(bigIntegerCreateRandomBigInteger) >= i) {
                return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(createBasePointMultiplier().multiply(this.f20237params.m15720getG(), bigIntegerCreateRandomBigInteger), this.f20237params), (AsymmetricKeyParameter) new ECPrivateKeyParameters(bigIntegerCreateRandomBigInteger, this.f20237params));
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        this.f20238random = eCKeyGenerationParameters.getRandom();
        ECDomainParameters domainParameters = eCKeyGenerationParameters.getDomainParameters();
        this.f20237params = domainParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(this.f20236name, ConstraintUtils.bitsOfSecurityFor(domainParameters.getCurve()), eCKeyGenerationParameters.getDomainParameters(), CryptoServicePurpose.KEYGEN));
    }

    public boolean isOutOfRangeD(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(ECConstants.f22091ONE) < 0 || bigInteger.compareTo(bigInteger2) >= 0;
    }

    public ECKeyPairGenerator(String str) {
        this.f20236name = str;
    }
}
