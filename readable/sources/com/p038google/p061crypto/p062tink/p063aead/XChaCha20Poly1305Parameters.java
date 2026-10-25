package com.p038google.p061crypto.p062tink.p063aead;

import java.util.Objects;

/* loaded from: classes.dex */
public final class XChaCha20Poly1305Parameters extends AeadParameters {

    /* renamed from: variant */
    private final C0374Variant f3056variant;

    /* renamed from: com.google.crypto.tink.aead.XChaCha20Poly1305Parameters$Variant */
    public static final class C0374Variant {

        /* renamed from: name */
        private final String f3059name;

        /* renamed from: TINK */
        public static final C0374Variant f3058TINK = new C0374Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0374Variant f3057CRUNCHY = new C0374Variant("CRUNCHY");
        public static final C0374Variant NO_PREFIX = new C0374Variant("NO_PREFIX");

        private C0374Variant(String str) {
            this.f3059name = str;
        }

        public String toString() {
            return this.f3059name;
        }
    }

    private XChaCha20Poly1305Parameters(C0374Variant c0374Variant) {
        this.f3056variant = c0374Variant;
    }

    /* renamed from: create */
    public static XChaCha20Poly1305Parameters m3433create() {
        return new XChaCha20Poly1305Parameters(C0374Variant.NO_PREFIX);
    }

    /* renamed from: equals */
    public boolean m3435equals(Object obj) {
        return (obj instanceof XChaCha20Poly1305Parameters) && ((XChaCha20Poly1305Parameters) obj).getVariant() == getVariant();
    }

    public C0374Variant getVariant() {
        return this.f3056variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3056variant != C0374Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hashCode(this.f3056variant);
    }

    public String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.f3056variant + ")";
    }

    /* renamed from: create */
    public static XChaCha20Poly1305Parameters m3434create(C0374Variant c0374Variant) {
        return new XChaCha20Poly1305Parameters(c0374Variant);
    }
}
