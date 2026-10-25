package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class DHKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private DHParameters f20694params;

    public DHKeyGenerationParameters(SecureRandom secureRandom, DHParameters dHParameters) {
        super(secureRandom, getStrength(dHParameters));
        this.f20694params = dHParameters;
    }

    public static int getStrength(DHParameters dHParameters) {
        return dHParameters.m15693getL() != 0 ? dHParameters.m15693getL() : dHParameters.m15695getP().bitLength();
    }

    public DHParameters getParameters() {
        return this.f20694params;
    }
}
