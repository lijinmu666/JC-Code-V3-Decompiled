package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class HQCKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final HQCParameters f23196params;

    public HQCKeyGenerationParameters(SecureRandom secureRandom, HQCParameters hQCParameters) {
        super(secureRandom, 256);
        this.f23196params = hQCParameters;
    }

    public HQCParameters getParameters() {
        return this.f23196params;
    }
}
