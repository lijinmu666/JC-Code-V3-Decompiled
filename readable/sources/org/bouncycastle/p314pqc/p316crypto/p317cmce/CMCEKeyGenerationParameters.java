package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class CMCEKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: params */
    private CMCEParameters f23071params;

    public CMCEKeyGenerationParameters(SecureRandom secureRandom, CMCEParameters cMCEParameters) {
        super(secureRandom, 256);
        this.f23071params = cMCEParameters;
    }

    public CMCEParameters getParameters() {
        return this.f23071params;
    }
}
