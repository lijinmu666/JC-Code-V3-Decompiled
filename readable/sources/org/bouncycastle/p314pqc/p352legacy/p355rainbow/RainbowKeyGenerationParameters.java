package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class RainbowKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private RainbowParameters f24033params;

    public RainbowKeyGenerationParameters(SecureRandom secureRandom, RainbowParameters rainbowParameters) {
        super(secureRandom, 256);
        this.f24033params = rainbowParameters;
    }

    public RainbowParameters getParameters() {
        return this.f24033params;
    }
}
