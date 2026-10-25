package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class SnovaKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final SnovaParameters f23553params;

    public SnovaKeyGenerationParameters(SecureRandom secureRandom, SnovaParameters snovaParameters) {
        super(secureRandom, -1);
        this.f23553params = snovaParameters;
    }

    public SnovaParameters getParameters() {
        return this.f23553params;
    }
}
