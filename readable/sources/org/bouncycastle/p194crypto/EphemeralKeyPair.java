package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public class EphemeralKeyPair {

    /* renamed from: keyPair */
    private AsymmetricCipherKeyPair f19137keyPair;
    private KeyEncoder publicKeyEncoder;

    public EphemeralKeyPair(AsymmetricCipherKeyPair asymmetricCipherKeyPair, KeyEncoder keyEncoder) {
        this.f19137keyPair = asymmetricCipherKeyPair;
        this.publicKeyEncoder = keyEncoder;
    }

    public byte[] getEncodedPublicKey() {
        return this.publicKeyEncoder.getEncoded(this.f19137keyPair.getPublic());
    }

    public AsymmetricCipherKeyPair getKeyPair() {
        return this.f19137keyPair;
    }
}
