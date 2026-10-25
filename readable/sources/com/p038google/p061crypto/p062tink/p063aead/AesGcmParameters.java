package com.p038google.p061crypto.p062tink.p063aead;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class AesGcmParameters extends AeadParameters {
    private final int ivSizeBytes;
    private final int keySizeBytes;
    private final int tagSizeBytes;

    /* renamed from: variant */
    private final C0346Variant f3036variant;

    /* renamed from: com.google.crypto.tink.aead.AesGcmParameters$Builder */
    public static final class C0345Builder {

        @Nullable
        private Integer ivSizeBytes;

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Integer tagSizeBytes;

        /* renamed from: variant */
        private C0346Variant f3037variant;

        /* renamed from: build */
        public AesGcmParameters m3408build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.f3037variant == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            if (this.ivSizeBytes == null) {
                throw new GeneralSecurityException("IV size is not set");
            }
            if (this.tagSizeBytes != null) {
                return new AesGcmParameters(num.intValue(), this.ivSizeBytes.intValue(), this.tagSizeBytes.intValue(), this.f3037variant);
            }
            throw new GeneralSecurityException("Tag size is not set");
        }

        public C0345Builder setIvSizeBytes(int i) throws GeneralSecurityException {
            if (i <= 0) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be positive", Integer.valueOf(i)));
            }
            this.ivSizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0345Builder setKeySizeBytes(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0345Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i != 12 && i != 13 && i != 14 && i != 15 && i != 16) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; value must be one of the following: 12, 13, 14, 15 or 16 bytes", Integer.valueOf(i)));
            }
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0345Builder setVariant(C0346Variant c0346Variant) {
            this.f3037variant = c0346Variant;
            return this;
        }

        private C0345Builder() {
            this.keySizeBytes = null;
            this.ivSizeBytes = null;
            this.tagSizeBytes = null;
            this.f3037variant = C0346Variant.NO_PREFIX;
        }
    }

    /* renamed from: com.google.crypto.tink.aead.AesGcmParameters$Variant */
    public static final class C0346Variant {

        /* renamed from: name */
        private final String f3040name;

        /* renamed from: TINK */
        public static final C0346Variant f3039TINK = new C0346Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0346Variant f3038CRUNCHY = new C0346Variant("CRUNCHY");
        public static final C0346Variant NO_PREFIX = new C0346Variant("NO_PREFIX");

        private C0346Variant(String str) {
            this.f3040name = str;
        }

        public String toString() {
            return this.f3040name;
        }
    }

    /* renamed from: builder */
    public static C0345Builder m3406builder() {
        return new C0345Builder();
    }

    /* renamed from: equals */
    public boolean m3407equals(Object obj) {
        if (!(obj instanceof AesGcmParameters)) {
            return false;
        }
        AesGcmParameters aesGcmParameters = (AesGcmParameters) obj;
        return aesGcmParameters.getKeySizeBytes() == getKeySizeBytes() && aesGcmParameters.getIvSizeBytes() == getIvSizeBytes() && aesGcmParameters.getTagSizeBytes() == getTagSizeBytes() && aesGcmParameters.getVariant() == getVariant();
    }

    public int getIvSizeBytes() {
        return this.ivSizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public C0346Variant getVariant() {
        return this.f3036variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3036variant != C0346Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.ivSizeBytes), Integer.valueOf(this.tagSizeBytes), this.f3036variant);
    }

    public String toString() {
        return "AesGcm Parameters (variant: " + this.f3036variant + ", " + this.ivSizeBytes + "-byte IV, " + this.tagSizeBytes + "-byte tag, and " + this.keySizeBytes + "-byte key)";
    }

    private AesGcmParameters(int i, int i2, int i3, C0346Variant c0346Variant) {
        this.keySizeBytes = i;
        this.ivSizeBytes = i2;
        this.tagSizeBytes = i3;
        this.f3036variant = c0346Variant;
    }
}
