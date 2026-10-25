package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DHKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;

/* loaded from: classes2.dex */
public class DHKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: param */
    private DHKeyGenerationParameters f20218param;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
        DHParameters parameters = this.f20218param.getParameters();
        BigInteger bigIntegerCalculatePrivate = dHKeyGeneratorHelper.calculatePrivate(parameters, this.f20218param.getRandom());
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new DHPublicKeyParameters(dHKeyGeneratorHelper.calculatePublic(parameters, bigIntegerCalculatePrivate), parameters), (AsymmetricKeyParameter) new DHPrivateKeyParameters(bigIntegerCalculatePrivate, parameters));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        DHKeyGenerationParameters dHKeyGenerationParameters = (DHKeyGenerationParameters) keyGenerationParameters;
        this.f20218param = dHKeyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("DHKeyGen", ConstraintUtils.bitsOfSecurityFor(dHKeyGenerationParameters.getParameters().m15695getP()), this.f20218param.getParameters(), CryptoServicePurpose.KEYGEN));
    }
}
