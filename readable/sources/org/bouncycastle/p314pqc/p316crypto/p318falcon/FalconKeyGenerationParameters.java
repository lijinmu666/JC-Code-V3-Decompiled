package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class FalconKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final FalconParameters f23113params;

    public FalconKeyGenerationParameters(SecureRandom secureRandom, FalconParameters falconParameters) {
        super(secureRandom, 320);
        this.f23113params = falconParameters;
    }

    public FalconParameters getParameters() {
        return this.f23113params;
    }
}
