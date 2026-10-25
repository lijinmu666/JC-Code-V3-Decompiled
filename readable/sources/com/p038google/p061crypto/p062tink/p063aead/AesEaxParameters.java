package com.p038google.p061crypto.p062tink.p063aead;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class AesEaxParameters extends AeadParameters {
    private final int ivSizeBytes;
    private final int keySizeBytes;
    private final int tagSizeBytes;

    /* renamed from: variant */
    private final C0338Variant f3030variant;

    /* renamed from: com.google.crypto.tink.aead.AesEaxParameters$Builder */
    public static final class C0337Builder {

        @Nullable
        private Integer ivSizeBytes;

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Integer tagSizeBytes;

        /* renamed from: variant */
        private C0338Variant f3031variant;

        /* renamed from: build */
        public AesEaxParameters m3399build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.ivSizeBytes == null) {
                throw new GeneralSecurityException("IV size is not set");
            }
            if (this.f3031variant == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            if (this.tagSizeBytes != null) {
                return new AesEaxParameters(num.intValue(), this.ivSizeBytes.intValue(), this.tagSizeBytes.intValue(), this.f3031variant);
            }
            throw new GeneralSecurityException("Tag size is not set");
        }

        public C0337Builder setIvSizeBytes(int i) throws GeneralSecurityException {
            if (i != 12 && i != 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i)));
            }
            this.ivSizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0337Builder setKeySizeBytes(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0337Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i < 0 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; value must be at most 16 bytes", Integer.valueOf(i)));
            }
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0337Builder setVariant(C0338Variant c0338Variant) {
            this.f3031variant = c0338Variant;
            return this;
        }

        private C0337Builder() {
            this.keySizeBytes = null;
            this.ivSizeBytes = null;
            this.tagSizeBytes = null;
            this.f3031variant = C0338Variant.NO_PREFIX;
        }
    }

    /* renamed from: com.google.crypto.tink.aead.AesEaxParameters$Variant */
    public static final class C0338Variant {

        /* renamed from: name */
        private final String f3034name;

        /* renamed from: TINK */
        public static final C0338Variant f3033TINK = new C0338Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0338Variant f3032CRUNCHY = new C0338Variant("CRUNCHY");
        public static final C0338Variant NO_PREFIX = new C0338Variant("NO_PREFIX");

        private C0338Variant(String str) {
            this.f3034name = str;
        }

        public String toString() {
            return this.f3034name;
        }
    }

    /* renamed from: builder */
    public static C0337Builder m3397builder() {
        return new C0337Builder();
    }

    /* renamed from: equals */
    public boolean m3398equals(Object obj) {
        if (!(obj instanceof AesEaxParameters)) {
            return false;
        }
        AesEaxParameters aesEaxParameters = (AesEaxParameters) obj;
        return aesEaxParameters.getKeySizeBytes() == getKeySizeBytes() && aesEaxParameters.getIvSizeBytes() == getIvSizeBytes() && aesEaxParameters.getTagSizeBytes() == getTagSizeBytes() && aesEaxParameters.getVariant() == getVariant();
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

    public C0338Variant getVariant() {
        return this.f3030variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3030variant != C0338Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.ivSizeBytes), Integer.valueOf(this.tagSizeBytes), this.f3030variant);
    }

    public String toString() {
        return "AesEax Parameters (variant: " + this.f3030variant + ", " + this.ivSizeBytes + "-byte IV, " + this.tagSizeBytes + "-byte tag, and " + this.keySizeBytes + "-byte key)";
    }

    private AesEaxParameters(int i, int i2, int i3, C0338Variant c0338Variant) {
        this.keySizeBytes = i;
        this.ivSizeBytes = i2;
        this.tagSizeBytes = i3;
        this.f3030variant = c0338Variant;
    }
}
