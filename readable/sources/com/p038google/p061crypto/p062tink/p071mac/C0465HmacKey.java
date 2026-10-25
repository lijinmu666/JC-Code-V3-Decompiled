package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p071mac.HmacParameters;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* renamed from: com.google.crypto.tink.mac.HmacKey */
/* loaded from: classes.dex */
public final class C0465HmacKey extends AbstractC0475MacKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final C0878Bytes outputPrefix;
    private final HmacParameters parameters;

    /* renamed from: com.google.crypto.tink.mac.HmacKey$Builder */
    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private HmacParameters parameters;

        private C0878Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == HmacParameters.C0471Variant.NO_PREFIX) {
                return C0878Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == HmacParameters.C0471Variant.f3163LEGACY || this.parameters.getVariant() == HmacParameters.C0471Variant.f3162CRUNCHY) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == HmacParameters.C0471Variant.f3164TINK) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown HmacParameters.Variant: " + this.parameters.getVariant());
        }

        /* renamed from: build */
        public C0465HmacKey m3521build() throws GeneralSecurityException {
            HmacParameters hmacParameters = this.parameters;
            if (hmacParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (hmacParameters.getKeySizeBytes() != this.keyBytes.m4296size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new C0465HmacKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
        }

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setParameters(HmacParameters hmacParameters) {
            this.parameters = hmacParameters;
            return this;
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }
    }

    /* renamed from: builder */
    public static Builder m3520builder() {
        return new Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof C0465HmacKey)) {
            return false;
        }
        C0465HmacKey c0465HmacKey = (C0465HmacKey) abstractC0308Key;
        return c0465HmacKey.parameters.m3523equals(this.parameters) && c0465HmacKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(c0465HmacKey.idRequirement, this.idRequirement);
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.AbstractC0475MacKey
    public C0878Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    private C0465HmacKey(HmacParameters hmacParameters, SecretBytes secretBytes, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = hmacParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.AbstractC0475MacKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public HmacParameters getParameters() {
        return this.parameters;
    }
}
