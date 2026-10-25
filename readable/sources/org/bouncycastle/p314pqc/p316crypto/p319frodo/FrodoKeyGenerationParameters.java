package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class FrodoKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private FrodoParameters f23163params;

    public FrodoKeyGenerationParameters(SecureRandom secureRandom, FrodoParameters frodoParameters) {
        super(secureRandom, 256);
        this.f23163params = frodoParameters;
    }

    public FrodoParameters getParameters() {
        return this.f23163params;
    }
}
