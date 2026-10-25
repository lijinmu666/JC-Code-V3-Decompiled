package com.p038google.p061crypto.p062tink.p071mac;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class AesCmacParameters extends MacParameters {
    private final int keySizeBytes;
    private final int tagSizeBytes;

    /* renamed from: variant */
    private final C0462Variant f3146variant;

    /* renamed from: com.google.crypto.tink.mac.AesCmacParameters$Builder */
    public static final class C0461Builder {

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Integer tagSizeBytes;

        /* renamed from: variant */
        private C0462Variant f3147variant;

        /* renamed from: build */
        public AesCmacParameters m3513build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("key size not set");
            }
            if (this.tagSizeBytes == null) {
                throw new GeneralSecurityException("tag size not set");
            }
            if (this.f3147variant != null) {
                return new AesCmacParameters(num.intValue(), this.tagSizeBytes.intValue(), this.f3147variant);
            }
            throw new GeneralSecurityException("variant not set");
        }

        public C0461Builder setKeySizeBytes(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0461Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i >= 10 && 16 >= i) {
                this.tagSizeBytes = Integer.valueOf(i);
                return this;
            }
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
        }

        public C0461Builder setVariant(C0462Variant c0462Variant) {
            this.f3147variant = c0462Variant;
            return this;
        }

        private C0461Builder() {
            this.keySizeBytes = null;
            this.tagSizeBytes = null;
            this.f3147variant = C0462Variant.NO_PREFIX;
        }
    }

    /* renamed from: com.google.crypto.tink.mac.AesCmacParameters$Variant */
    public static final class C0462Variant {

        /* renamed from: name */
        private final String f3151name;

        /* renamed from: TINK */
        public static final C0462Variant f3150TINK = new C0462Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0462Variant f3148CRUNCHY = new C0462Variant("CRUNCHY");

        /* renamed from: LEGACY */
        public static final C0462Variant f3149LEGACY = new C0462Variant("LEGACY");
        public static final C0462Variant NO_PREFIX = new C0462Variant("NO_PREFIX");

        private C0462Variant(String str) {
            this.f3151name = str;
        }

        public String toString() {
            return this.f3151name;
        }
    }

    /* renamed from: builder */
    public static C0461Builder m3511builder() {
        return new C0461Builder();
    }

    /* renamed from: equals */
    public boolean m3512equals(Object obj) {
        if (!(obj instanceof AesCmacParameters)) {
            return false;
        }
        AesCmacParameters aesCmacParameters = (AesCmacParameters) obj;
        return aesCmacParameters.getKeySizeBytes() == getKeySizeBytes() && aesCmacParameters.getTotalTagSizeBytes() == getTotalTagSizeBytes() && aesCmacParameters.getVariant() == getVariant();
    }

    public int getCryptographicTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getTotalTagSizeBytes() {
        C0462Variant c0462Variant = this.f3146variant;
        if (c0462Variant == C0462Variant.NO_PREFIX) {
            return getCryptographicTagSizeBytes();
        }
        if (c0462Variant != C0462Variant.f3150TINK && c0462Variant != C0462Variant.f3148CRUNCHY && c0462Variant != C0462Variant.f3149LEGACY) {
            throw new IllegalStateException("Unknown variant");
        }
        int cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        return cryptographicTagSizeBytes + 5;
    }

    public C0462Variant getVariant() {
        return this.f3146variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3146variant != C0462Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.tagSizeBytes), this.f3146variant);
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.f3146variant + ", " + this.tagSizeBytes + "-byte tags, and " + this.keySizeBytes + "-byte key)";
    }

    private AesCmacParameters(int i, int i2, C0462Variant c0462Variant) {
        this.keySizeBytes = i;
        this.tagSizeBytes = i2;
        this.f3146variant = c0462Variant;
    }
}
