package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class SLHDSAKeyGenerationParameters extends KeyGenerationParameters {
    private final SLHDSAParameters parameters;

    public SLHDSAKeyGenerationParameters(SecureRandom secureRandom, SLHDSAParameters sLHDSAParameters) {
        super(secureRandom, -1);
        this.parameters = sLHDSAParameters;
    }

    public SLHDSAParameters getParameters() {
        return this.parameters;
    }
}
