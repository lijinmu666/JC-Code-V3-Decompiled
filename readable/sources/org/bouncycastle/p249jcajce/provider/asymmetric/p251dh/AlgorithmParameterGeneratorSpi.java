package org.bouncycastle.p249jcajce.provider.asymmetric.p251dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.DHParametersGenerator;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PrimeCertaintyCalculator;

/* loaded from: classes2.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* renamed from: random */
    protected SecureRandom f21419random;
    protected int strength = 2048;

    /* renamed from: l */
    private int f21418l = 0;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
        DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
        dHParametersGenerator.m15487init(this.strength, PrimeCertaintyCalculator.getDefaultCertainty(this.strength), CryptoServicesRegistrar.getSecureRandom(this.f21419random));
        DHParameters dHParametersGenerateParameters = dHParametersGenerator.generateParameters();
        try {
            AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("DH");
            algorithmParametersCreateParametersInstance.init(new DHParameterSpec(dHParametersGenerateParameters.m15695getP(), dHParametersGenerateParameters.m15691getG(), this.f21418l));
            return algorithmParametersCreateParametersInstance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21419random = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }
        DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
        this.strength = dHGenParameterSpec.getPrimeSize();
        this.f21418l = dHGenParameterSpec.getExponentSize();
        this.f21419random = secureRandom;
    }
}
