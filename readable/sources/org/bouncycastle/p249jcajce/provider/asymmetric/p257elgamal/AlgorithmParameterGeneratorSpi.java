package org.bouncycastle.p249jcajce.provider.asymmetric.p257elgamal;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.ElGamalParametersGenerator;
import org.bouncycastle.p194crypto.p213params.ElGamalParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAlgorithmParameterGeneratorSpi;

/* loaded from: classes2.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* renamed from: random */
    protected SecureRandom f21554random;
    protected int strength = 1024;

    /* renamed from: l */
    private int f21553l = 0;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
        ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
        SecureRandom secureRandom = this.f21554random;
        if (secureRandom != null) {
            elGamalParametersGenerator.m15492init(this.strength, 20, secureRandom);
        } else {
            elGamalParametersGenerator.m15492init(this.strength, 20, CryptoServicesRegistrar.getSecureRandom());
        }
        ElGamalParameters elGamalParametersGenerateParameters = elGamalParametersGenerator.generateParameters();
        try {
            AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("ElGamal");
            algorithmParametersCreateParametersInstance.init(new DHParameterSpec(elGamalParametersGenerateParameters.m15745getP(), elGamalParametersGenerateParameters.m15743getG(), this.f21553l));
            return algorithmParametersCreateParametersInstance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.f21554random = secureRandom;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }
        DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
        this.strength = dHGenParameterSpec.getPrimeSize();
        this.f21553l = dHGenParameterSpec.getExponentSize();
        this.f21554random = secureRandom;
    }
}
