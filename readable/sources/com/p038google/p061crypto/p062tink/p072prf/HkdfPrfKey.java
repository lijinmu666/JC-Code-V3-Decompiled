package com.p038google.p061crypto.p062tink.p072prf;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class HkdfPrfKey extends AbstractC0505PrfKey {
    private final SecretBytes keyBytes;
    private final HkdfPrfParameters parameters;

    /* renamed from: com.google.crypto.tink.prf.HkdfPrfKey$Builder */
    public static final class C0493Builder {

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private HkdfPrfParameters parameters;

        /* renamed from: build */
        public HkdfPrfKey m3542build() throws GeneralSecurityException {
            HkdfPrfParameters hkdfPrfParameters = this.parameters;
            if (hkdfPrfParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (hkdfPrfParameters.getKeySizeBytes() == this.keyBytes.m4296size()) {
                return new HkdfPrfKey(this.parameters, this.keyBytes);
            }
            throw new GeneralSecurityException("Key size mismatch");
        }

        public C0493Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public C0493Builder setParameters(HkdfPrfParameters hkdfPrfParameters) {
            this.parameters = hkdfPrfParameters;
            return this;
        }

        private C0493Builder() {
            this.parameters = null;
            this.keyBytes = null;
        }
    }

    /* renamed from: builder */
    public static C0493Builder m3541builder() {
        return new C0493Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof HkdfPrfKey)) {
            return false;
        }
        HkdfPrfKey hkdfPrfKey = (HkdfPrfKey) abstractC0308Key;
        return hkdfPrfKey.parameters.m3544equals(this.parameters) && hkdfPrfKey.keyBytes.equalsSecretBytes(this.keyBytes);
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return null;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    private HkdfPrfKey(HkdfPrfParameters hkdfPrfParameters, SecretBytes secretBytes) {
        this.parameters = hkdfPrfParameters;
        this.keyBytes = secretBytes;
    }

    @Override // com.p038google.p061crypto.p062tink.p072prf.AbstractC0505PrfKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public HkdfPrfParameters getParameters() {
        return this.parameters;
    }
}
