package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class MLDSAKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final MLDSAParameters f20779params;

    public MLDSAKeyGenerationParameters(SecureRandom secureRandom, MLDSAParameters mLDSAParameters) {
        super(secureRandom, 256);
        this.f20779params = mLDSAParameters;
    }

    public MLDSAParameters getParameters() {
        return this.f20779params;
    }
}
