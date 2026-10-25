package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p063aead.AesGcmParameters;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class AesGcmKey extends AbstractC0326AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final C0878Bytes outputPrefix;
    private final AesGcmParameters parameters;

    /* renamed from: com.google.crypto.tink.aead.AesGcmKey$Builder */
    public static class C0341Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private AesGcmParameters parameters;

        private C0878Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesGcmParameters.C0346Variant.NO_PREFIX) {
                return C0878Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesGcmParameters.C0346Variant.f3038CRUNCHY) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesGcmParameters.C0346Variant.f3039TINK) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + this.parameters.getVariant());
        }

        /* renamed from: build */
        public AesGcmKey m3405build() throws GeneralSecurityException {
            AesGcmParameters aesGcmParameters = this.parameters;
            if (aesGcmParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (aesGcmParameters.getKeySizeBytes() != this.keyBytes.m4296size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new AesGcmKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
        }

        public C0341Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public C0341Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public C0341Builder setParameters(AesGcmParameters aesGcmParameters) {
            this.parameters = aesGcmParameters;
            return this;
        }

        private C0341Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }
    }

    /* renamed from: builder */
    public static C0341Builder m3404builder() {
        return new C0341Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof AesGcmKey)) {
            return false;
        }
        AesGcmKey aesGcmKey = (AesGcmKey) abstractC0308Key;
        return aesGcmKey.parameters.m3407equals(this.parameters) && aesGcmKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(aesGcmKey.idRequirement, this.idRequirement);
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey
    public C0878Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    private AesGcmKey(AesGcmParameters aesGcmParameters, SecretBytes secretBytes, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = aesGcmParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public AesGcmParameters getParameters() {
        return this.parameters;
    }
}
