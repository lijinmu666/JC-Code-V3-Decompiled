package com.p038google.p061crypto.p062tink.p063aead;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class AesGcmSivParameters extends AeadParameters {
    private final int keySizeBytes;

    /* renamed from: variant */
    private final C0354Variant f3042variant;

    /* renamed from: com.google.crypto.tink.aead.AesGcmSivParameters$Builder */
    public static final class C0353Builder {

        @Nullable
        private Integer keySizeBytes;

        /* renamed from: variant */
        private C0354Variant f3043variant;

        /* renamed from: build */
        public AesGcmSivParameters m3417build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.f3043variant != null) {
                return new AesGcmSivParameters(num.intValue(), this.f3043variant);
            }
            throw new GeneralSecurityException("Variant is not set");
        }

        public C0353Builder setKeySizeBytes(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0353Builder setVariant(C0354Variant c0354Variant) {
            this.f3043variant = c0354Variant;
            return this;
        }

        private C0353Builder() {
            this.keySizeBytes = null;
            this.f3043variant = C0354Variant.NO_PREFIX;
        }
    }

    /* renamed from: com.google.crypto.tink.aead.AesGcmSivParameters$Variant */
    public static final class C0354Variant {

        /* renamed from: name */
        private final String f3046name;

        /* renamed from: TINK */
        public static final C0354Variant f3045TINK = new C0354Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0354Variant f3044CRUNCHY = new C0354Variant("CRUNCHY");
        public static final C0354Variant NO_PREFIX = new C0354Variant("NO_PREFIX");

        private C0354Variant(String str) {
            this.f3046name = str;
        }

        public String toString() {
            return this.f3046name;
        }
    }

    /* renamed from: builder */
    public static C0353Builder m3415builder() {
        return new C0353Builder();
    }

    /* renamed from: equals */
    public boolean m3416equals(Object obj) {
        if (!(obj instanceof AesGcmSivParameters)) {
            return false;
        }
        AesGcmSivParameters aesGcmSivParameters = (AesGcmSivParameters) obj;
        return aesGcmSivParameters.getKeySizeBytes() == getKeySizeBytes() && aesGcmSivParameters.getVariant() == getVariant();
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public C0354Variant getVariant() {
        return this.f3042variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3042variant != C0354Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), this.f3042variant);
    }

    public String toString() {
        return "AesGcmSiv Parameters (variant: " + this.f3042variant + ", " + this.keySizeBytes + "-byte key)";
    }

    private AesGcmSivParameters(int i, C0354Variant c0354Variant) {
        this.keySizeBytes = i;
        this.f3042variant = c0354Variant;
    }
}
