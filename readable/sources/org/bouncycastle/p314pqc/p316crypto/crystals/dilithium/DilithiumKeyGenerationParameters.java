package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class DilithiumKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final DilithiumParameters f23081params;

    public DilithiumKeyGenerationParameters(SecureRandom secureRandom, DilithiumParameters dilithiumParameters) {
        super(secureRandom, 256);
        this.f23081params = dilithiumParameters;
    }

    public DilithiumParameters getParameters() {
        return this.f23081params;
    }
}
