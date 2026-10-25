package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class NTRUPlusKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private final NTRUPlusParameters f23403params;

    public NTRUPlusKeyGenerationParameters(SecureRandom secureRandom, NTRUPlusParameters nTRUPlusParameters) {
        super(secureRandom, 256);
        this.f23403params = nTRUPlusParameters;
    }

    public NTRUPlusParameters getParameters() {
        return this.f23403params;
    }
}
