package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;

/* loaded from: classes2.dex */
public class ParametersWithRandom implements CipherParameters {
    private CipherParameters parameters;

    /* renamed from: random */
    private SecureRandom f20814random;

    public ParametersWithRandom(CipherParameters cipherParameters) {
        this(cipherParameters, null);
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    public SecureRandom getRandom() {
        return this.f20814random;
    }

    public ParametersWithRandom(CipherParameters cipherParameters, SecureRandom secureRandom) {
        this.f20814random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
        this.parameters = cipherParameters;
    }
}
