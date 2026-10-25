package org.bouncycastle.p249jcajce.provider.asymmetric.p258gost;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.GOST3410ParametersGenerator;
import org.bouncycastle.p194crypto.p213params.GOST3410Parameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.p281jce.p282spec.GOST3410ParameterSpec;
import org.bouncycastle.p281jce.p282spec.GOST3410PublicKeyParameterSetSpec;

/* loaded from: classes2.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* renamed from: random */
    protected SecureRandom f21564random;
    protected int strength = 1024;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
        GOST3410ParametersGenerator gOST3410ParametersGenerator = new GOST3410ParametersGenerator();
        SecureRandom secureRandom = this.f21564random;
        if (secureRandom != null) {
            gOST3410ParametersGenerator.m15493init(this.strength, 2, secureRandom);
        } else {
            gOST3410ParametersGenerator.m15493init(this.strength, 2, CryptoServicesRegistrar.getSecureRandom());
        }
        GOST3410Parameters gOST3410ParametersGenerateParameters = gOST3410ParametersGenerator.generateParameters();
        try {
            AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("GOST3410");
            algorithmParametersCreateParametersInstance.init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410ParametersGenerateParameters.m15751getP(), gOST3410ParametersGenerateParameters.m15752getQ(), gOST3410ParametersGenerateParameters.m15750getA())));
            return algorithmParametersCreateParametersInstance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21564random = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
    }
}
