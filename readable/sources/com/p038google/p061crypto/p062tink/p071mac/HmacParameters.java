package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class HmacParameters extends MacParameters {
    private final HashType hashType;
    private final int keySizeBytes;
    private final int tagSizeBytes;

    /* renamed from: variant */
    private final C0471Variant f3154variant;

    /* renamed from: com.google.crypto.tink.mac.HmacParameters$Builder */
    public static final class C0470Builder {
        private HashType hashType;

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Integer tagSizeBytes;

        /* renamed from: variant */
        private C0471Variant f3155variant;

        private static void validateTagSizeBytes(int i, HashType hashType) throws GeneralSecurityException {
            if (i < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
            }
            if (hashType == HashType.f3156SHA1) {
                if (i > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(i)));
                }
                return;
            }
            if (hashType == HashType.f3157SHA224) {
                if (i > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(i)));
                }
                return;
            }
            if (hashType == HashType.f3158SHA256) {
                if (i > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(i)));
                }
            } else if (hashType == HashType.f3159SHA384) {
                if (i > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(i)));
                }
            } else {
                if (hashType != HashType.f3160SHA512) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                }
                if (i > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(i)));
                }
            }
        }

        /* renamed from: build */
        public HmacParameters m3524build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.tagSizeBytes == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.hashType == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.f3155variant == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            if (num.intValue() < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.keySizeBytes));
            }
            validateTagSizeBytes(this.tagSizeBytes.intValue(), this.hashType);
            return new HmacParameters(this.keySizeBytes.intValue(), this.tagSizeBytes.intValue(), this.f3155variant, this.hashType);
        }

        public C0470Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public C0470Builder setKeySizeBytes(int i) {
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0470Builder setTagSizeBytes(int i) {
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public C0470Builder setVariant(C0471Variant c0471Variant) {
            this.f3155variant = c0471Variant;
            return this;
        }

        private C0470Builder() {
            this.keySizeBytes = null;
            this.tagSizeBytes = null;
            this.hashType = null;
            this.f3155variant = C0471Variant.NO_PREFIX;
        }
    }

    public static final class HashType {

        /* renamed from: SHA1 */
        public static final HashType f3156SHA1 = new HashType("SHA1");

        /* renamed from: SHA224 */
        public static final HashType f3157SHA224 = new HashType("SHA224");

        /* renamed from: SHA256 */
        public static final HashType f3158SHA256 = new HashType("SHA256");

        /* renamed from: SHA384 */
        public static final HashType f3159SHA384 = new HashType("SHA384");

        /* renamed from: SHA512 */
        public static final HashType f3160SHA512 = new HashType("SHA512");

        /* renamed from: name */
        private final String f3161name;

        private HashType(String str) {
            this.f3161name = str;
        }

        public String toString() {
            return this.f3161name;
        }
    }

    /* renamed from: com.google.crypto.tink.mac.HmacParameters$Variant */
    public static final class C0471Variant {

        /* renamed from: name */
        private final String f3165name;

        /* renamed from: TINK */
        public static final C0471Variant f3164TINK = new C0471Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0471Variant f3162CRUNCHY = new C0471Variant("CRUNCHY");

        /* renamed from: LEGACY */
        public static final C0471Variant f3163LEGACY = new C0471Variant("LEGACY");
        public static final C0471Variant NO_PREFIX = new C0471Variant("NO_PREFIX");

        private C0471Variant(String str) {
            this.f3165name = str;
        }

        public String toString() {
            return this.f3165name;
        }
    }

    /* renamed from: builder */
    public static C0470Builder m3522builder() {
        return new C0470Builder();
    }

    /* renamed from: equals */
    public boolean m3523equals(Object obj) {
        if (!(obj instanceof HmacParameters)) {
            return false;
        }
        HmacParameters hmacParameters = (HmacParameters) obj;
        return hmacParameters.getKeySizeBytes() == getKeySizeBytes() && hmacParameters.getTotalTagSizeBytes() == getTotalTagSizeBytes() && hmacParameters.getVariant() == getVariant() && hmacParameters.getHashType() == getHashType();
    }

    public int getCryptographicTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getTotalTagSizeBytes() {
        C0471Variant c0471Variant = this.f3154variant;
        if (c0471Variant == C0471Variant.NO_PREFIX) {
            return getCryptographicTagSizeBytes();
        }
        if (c0471Variant != C0471Variant.f3164TINK && c0471Variant != C0471Variant.f3162CRUNCHY && c0471Variant != C0471Variant.f3163LEGACY) {
            throw new IllegalStateException("Unknown variant");
        }
        int cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        return cryptographicTagSizeBytes + 5;
    }

    public C0471Variant getVariant() {
        return this.f3154variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3154variant != C0471Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.tagSizeBytes), this.f3154variant, this.hashType);
    }

    public String toString() {
        return "HMAC Parameters (variant: " + this.f3154variant + ", hashType: " + this.hashType + ", " + this.tagSizeBytes + "-byte tags, and " + this.keySizeBytes + "-byte key)";
    }

    private HmacParameters(int i, int i2, C0471Variant c0471Variant, HashType hashType) {
        this.keySizeBytes = i;
        this.tagSizeBytes = i2;
        this.f3154variant = c0471Variant;
        this.hashType = hashType;
    }
}
