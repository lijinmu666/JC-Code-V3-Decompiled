package org.bouncycastle.p314pqc.p316crypto.p327saber;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class SABERKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private SABERParameters f23459params;

    public SABERKeyGenerationParameters(SecureRandom secureRandom, SABERParameters sABERParameters) {
        super(secureRandom, 256);
        this.f23459params = sABERParameters;
    }

    public SABERParameters getParameters() {
        return this.f23459params;
    }
}
