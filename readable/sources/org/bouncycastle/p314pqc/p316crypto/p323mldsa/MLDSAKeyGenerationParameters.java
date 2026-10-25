package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

@Deprecated
/* loaded from: classes2.dex */
public class MLDSAKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final MLDSAParameters f23306params;

    public MLDSAKeyGenerationParameters(SecureRandom secureRandom, MLDSAParameters mLDSAParameters) {
        super(secureRandom, 256);
        this.f23306params = mLDSAParameters;
    }

    public MLDSAParameters getParameters() {
        return this.f23306params;
    }
}
