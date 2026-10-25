package org.bouncycastle.p194crypto;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class KeyGenerationParameters {

    /* renamed from: random */
    private SecureRandom f19138random;
    private int strength;

    public KeyGenerationParameters(SecureRandom secureRandom, int i) {
        this.f19138random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
        this.strength = i;
    }

    public SecureRandom getRandom() {
        return this.f19138random;
    }

    public int getStrength() {
        return this.strength;
    }
}
