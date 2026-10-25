package org.bouncycastle.p314pqc.p352legacy.p353bike;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class BIKEKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private BIKEParameters f23940params;

    public BIKEKeyGenerationParameters(SecureRandom secureRandom, BIKEParameters bIKEParameters) {
        super(secureRandom, 256);
        this.f23940params = bIKEParameters;
    }

    public BIKEParameters getParameters() {
        return this.f23940params;
    }
}
