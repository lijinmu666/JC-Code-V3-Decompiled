package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p063aead.AesEaxParameters;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class AesEaxKey extends AbstractC0326AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final C0878Bytes outputPrefix;
    private final AesEaxParameters parameters;

    /* renamed from: com.google.crypto.tink.aead.AesEaxKey$Builder */
    public static class C0333Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private AesEaxParameters parameters;

        private C0878Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == AesEaxParameters.C0338Variant.NO_PREFIX) {
                return C0878Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == AesEaxParameters.C0338Variant.f3032CRUNCHY) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == AesEaxParameters.C0338Variant.f3033TINK) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + this.parameters.getVariant());
        }

        /* renamed from: build */
        public AesEaxKey m3396build() throws GeneralSecurityException {
            AesEaxParameters aesEaxParameters = this.parameters;
            if (aesEaxParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (aesEaxParameters.getKeySizeBytes() != this.keyBytes.m4296size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new AesEaxKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
        }

        public C0333Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public C0333Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public C0333Builder setParameters(AesEaxParameters aesEaxParameters) {
            this.parameters = aesEaxParameters;
            return this;
        }

        private C0333Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }
    }

    /* renamed from: builder */
    public static C0333Builder m3395builder() {
        return new C0333Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof AesEaxKey)) {
            return false;
        }
        AesEaxKey aesEaxKey = (AesEaxKey) abstractC0308Key;
        return aesEaxKey.parameters.m3398equals(this.parameters) && aesEaxKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(aesEaxKey.idRequirement, this.idRequirement);
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

    private AesEaxKey(AesEaxParameters aesEaxParameters, SecretBytes secretBytes, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = aesEaxParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public AesEaxParameters getParameters() {
        return this.parameters;
    }
}
