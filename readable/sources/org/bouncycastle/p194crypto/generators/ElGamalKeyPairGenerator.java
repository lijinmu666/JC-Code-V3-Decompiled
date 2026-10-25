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
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPublicKeyParameters;

/* loaded from: classes2.dex */
public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: param */
    private ElGamalKeyGenerationParameters f20241param;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
        ElGamalParameters parameters = this.f20241param.getParameters();
        DHParameters dHParameters = new DHParameters(parameters.m15745getP(), parameters.m15743getG(), null, parameters.m15744getL());
        BigInteger bigIntegerCalculatePrivate = dHKeyGeneratorHelper.calculatePrivate(dHParameters, this.f20241param.getRandom());
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ElGamalPublicKeyParameters(dHKeyGeneratorHelper.calculatePublic(dHParameters, bigIntegerCalculatePrivate), parameters), (AsymmetricKeyParameter) new ElGamalPrivateKeyParameters(bigIntegerCalculatePrivate, parameters));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        ElGamalKeyGenerationParameters elGamalKeyGenerationParameters = (ElGamalKeyGenerationParameters) keyGenerationParameters;
        this.f20241param = elGamalKeyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ElGamalKeyGen", ConstraintUtils.bitsOfSecurityFor(elGamalKeyGenerationParameters.getParameters().m15745getP()), this.f20241param.getParameters(), CryptoServicePurpose.KEYGEN));
    }
}
