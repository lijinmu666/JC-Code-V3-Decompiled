package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class MLKEMKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final MLKEMParameters f20794params;

    public MLKEMKeyGenerationParameters(SecureRandom secureRandom, MLKEMParameters mLKEMParameters) {
        super(secureRandom, 256);
        this.f20794params = mLKEMParameters;
    }

    public MLKEMParameters getParameters() {
        return this.f20794params;
    }
}
