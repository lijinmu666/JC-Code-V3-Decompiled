package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final MLKEMParameters f23341params;

    public MLKEMKeyGenerationParameters(SecureRandom secureRandom, MLKEMParameters mLKEMParameters) {
        super(secureRandom, 256);
        this.f23341params = mLKEMParameters;
    }

    public MLKEMParameters getParameters() {
        return this.f23341params;
    }
}
