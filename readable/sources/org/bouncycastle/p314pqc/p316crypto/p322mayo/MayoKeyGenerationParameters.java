package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class MayoKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final MayoParameters f23271params;

    public MayoKeyGenerationParameters(SecureRandom secureRandom, MayoParameters mayoParameters) {
        super(secureRandom, 256);
        this.f23271params = mayoParameters;
    }

    public MayoParameters getParameters() {
        return this.f23271params;
    }
}
