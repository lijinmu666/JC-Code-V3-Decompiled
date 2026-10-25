package com.p038google.p061crypto.p062tink.p063aead;

import java.util.Objects;

/* loaded from: classes.dex */
public final class ChaCha20Poly1305Parameters extends AeadParameters {

    /* renamed from: variant */
    private final C0358Variant f3048variant;

    /* renamed from: com.google.crypto.tink.aead.ChaCha20Poly1305Parameters$Variant */
    public static final class C0358Variant {

        /* renamed from: name */
        private final String f3051name;

        /* renamed from: TINK */
        public static final C0358Variant f3050TINK = new C0358Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0358Variant f3049CRUNCHY = new C0358Variant("CRUNCHY");
        public static final C0358Variant NO_PREFIX = new C0358Variant("NO_PREFIX");

        private C0358Variant(String str) {
            this.f3051name = str;
        }

        public String toString() {
            return this.f3051name;
        }
    }

    private ChaCha20Poly1305Parameters(C0358Variant c0358Variant) {
        this.f3048variant = c0358Variant;
    }

    /* renamed from: create */
    public static ChaCha20Poly1305Parameters m3424create() {
        return new ChaCha20Poly1305Parameters(C0358Variant.NO_PREFIX);
    }

    /* renamed from: equals */
    public boolean m3426equals(Object obj) {
        return (obj instanceof ChaCha20Poly1305Parameters) && ((ChaCha20Poly1305Parameters) obj).getVariant() == getVariant();
    }

    public C0358Variant getVariant() {
        return this.f3048variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3048variant != C0358Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hashCode(this.f3048variant);
    }

    public String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.f3048variant + ")";
    }

    /* renamed from: create */
    public static ChaCha20Poly1305Parameters m3425create(C0358Variant c0358Variant) {
        return new ChaCha20Poly1305Parameters(c0358Variant);
    }
}
