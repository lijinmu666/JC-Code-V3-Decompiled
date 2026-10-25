package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class GOST3410KeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private GOST3410Parameters f20753params;

    public GOST3410KeyGenerationParameters(SecureRandom secureRandom, GOST3410Parameters gOST3410Parameters) {
        super(secureRandom, gOST3410Parameters.m15751getP().bitLength() - 1);
        this.f20753params = gOST3410Parameters;
    }

    public GOST3410Parameters getParameters() {
        return this.f20753params;
    }
}
