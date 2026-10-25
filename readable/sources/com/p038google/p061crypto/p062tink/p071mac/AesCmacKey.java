package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.p071mac.AesCmacParameters;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class AesCmacKey extends AbstractC0475MacKey {
    private final SecretBytes aesKeyBytes;

    @Nullable
    private final Integer idRequirement;
    private final C0878Bytes outputPrefix;
    private final AesCmacParameters parameters;

    /* renamed from: com.google.crypto.tink.mac.AesCmacKey$Builder */
    public static class C0457Builder {

        @Nullable
        private SecretBytes aesKeyBytes;

        @Nullable
        private Integer idRequirement;

        @Nullable
        private AesCmacParameters parameters;

        private C0878Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesCmacParameters.C0462Variant.NO_PREFIX) {
                return C0878Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesCmacParameters.C0462Variant.f3149LEGACY || this.parameters.getVariant() == AesCmacParameters.C0462Variant.f3148CRUNCHY) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesCmacParameters.C0462Variant.f3150TINK) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + this.parameters.getVariant());
        }

        /* renamed from: build */
        public AesCmacKey m3510build() throws GeneralSecurityException {
            AesCmacParameters aesCmacParameters = this.parameters;
            if (aesCmacParameters == null || this.aesKeyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (aesCmacParameters.getKeySizeBytes() != this.aesKeyBytes.m4296size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new AesCmacKey(this.parameters, this.aesKeyBytes, getOutputPrefix(), this.idRequirement);
        }

        public C0457Builder setAesKeyBytes(SecretBytes secretBytes) {
            this.aesKeyBytes = secretBytes;
            return this;
        }

        public C0457Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public C0457Builder setParameters(AesCmacParameters aesCmacParameters) {
            this.parameters = aesCmacParameters;
            return this;
        }

        private C0457Builder() {
            this.parameters = null;
            this.aesKeyBytes = null;
            this.idRequirement = null;
        }
    }

    /* renamed from: builder */
    public static C0457Builder m3509builder() {
        return new C0457Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof AesCmacKey)) {
            return false;
        }
        AesCmacKey aesCmacKey = (AesCmacKey) abstractC0308Key;
        return aesCmacKey.parameters.m3512equals(this.parameters) && aesCmacKey.aesKeyBytes.equalsSecretBytes(this.aesKeyBytes) && Objects.equals(aesCmacKey.idRequirement, this.idRequirement);
    }

    public SecretBytes getAesKey() {
        return this.aesKeyBytes;
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.AbstractC0475MacKey
    public C0878Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    private AesCmacKey(AesCmacParameters aesCmacParameters, SecretBytes secretBytes, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = aesCmacParameters;
        this.aesKeyBytes = secretBytes;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.AbstractC0475MacKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public AesCmacParameters getParameters() {
        return this.parameters;
    }
}
