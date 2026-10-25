package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class ElGamalKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private ElGamalParameters f20744params;

    public ElGamalKeyGenerationParameters(SecureRandom secureRandom, ElGamalParameters elGamalParameters) {
        super(secureRandom, getStrength(elGamalParameters));
        this.f20744params = elGamalParameters;
    }

    public static int getStrength(ElGamalParameters elGamalParameters) {
        return elGamalParameters.m15744getL() != 0 ? elGamalParameters.m15744getL() : elGamalParameters.m15745getP().bitLength();
    }

    public ElGamalParameters getParameters() {
        return this.f20744params;
    }
}
