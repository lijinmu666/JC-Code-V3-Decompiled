package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class DSAKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private DSAParameters f20708params;

    public DSAKeyGenerationParameters(SecureRandom secureRandom, DSAParameters dSAParameters) {
        super(secureRandom, dSAParameters.m15705getP().bitLength() - 1);
        this.f20708params = dSAParameters;
    }

    public DSAParameters getParameters() {
        return this.f20708params;
    }
}
