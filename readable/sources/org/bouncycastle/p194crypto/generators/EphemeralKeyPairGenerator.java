package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.EphemeralKeyPair;
import org.bouncycastle.p194crypto.KeyEncoder;

/* loaded from: classes2.dex */
public class EphemeralKeyPairGenerator {

    /* renamed from: gen */
    private AsymmetricCipherKeyPairGenerator f20244gen;
    private KeyEncoder keyEncoder;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator, KeyEncoder keyEncoder) {
        this.f20244gen = asymmetricCipherKeyPairGenerator;
        this.keyEncoder = keyEncoder;
    }

    public EphemeralKeyPair generate() {
        return new EphemeralKeyPair(this.f20244gen.generateKeyPair(), this.keyEncoder);
    }
}
