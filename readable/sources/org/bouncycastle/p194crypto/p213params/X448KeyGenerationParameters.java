package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class X448KeyGenerationParameters extends KeyGenerationParameters {
    public X448KeyGenerationParameters(SecureRandom secureRandom) {
        super(secureRandom, 448);
    }
}
