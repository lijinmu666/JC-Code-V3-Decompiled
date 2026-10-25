package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p063aead.XChaCha20Poly1305Parameters;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class XChaCha20Poly1305Key extends AbstractC0326AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final C0878Bytes outputPrefix;
    private final XChaCha20Poly1305Parameters parameters;

    private XChaCha20Poly1305Key(XChaCha20Poly1305Parameters xChaCha20Poly1305Parameters, SecretBytes secretBytes, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = xChaCha20Poly1305Parameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @AccessesPartialKey
    /* renamed from: create */
    public static XChaCha20Poly1305Key m3432create(SecretBytes secretBytes) {
        return m3431create(XChaCha20Poly1305Parameters.C0374Variant.NO_PREFIX, secretBytes, null);
    }

    private static C0878Bytes getOutputPrefix(XChaCha20Poly1305Parameters xChaCha20Poly1305Parameters, @Nullable Integer num) {
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.C0374Variant.NO_PREFIX) {
            return C0878Bytes.copyFrom(new byte[0]);
        }
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.C0374Variant.f3057CRUNCHY) {
            return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (xChaCha20Poly1305Parameters.getVariant() == XChaCha20Poly1305Parameters.C0374Variant.f3058TINK) {
            return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown Variant: " + xChaCha20Poly1305Parameters.getVariant());
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof XChaCha20Poly1305Key)) {
            return false;
        }
        XChaCha20Poly1305Key xChaCha20Poly1305Key = (XChaCha20Poly1305Key) abstractC0308Key;
        return xChaCha20Poly1305Key.parameters.m3435equals(this.parameters) && xChaCha20Poly1305Key.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(xChaCha20Poly1305Key.idRequirement, this.idRequirement);
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    /* renamed from: create */
    public static XChaCha20Poly1305Key m3431create(XChaCha20Poly1305Parameters.C0374Variant c0374Variant, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        XChaCha20Poly1305Parameters.C0374Variant c0374Variant2 = XChaCha20Poly1305Parameters.C0374Variant.NO_PREFIX;
        if (c0374Variant != c0374Variant2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + c0374Variant + " the value of idRequirement must be non-null");
        }
        if (c0374Variant == c0374Variant2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (secretBytes.m4296size() == 32) {
            XChaCha20Poly1305Parameters xChaCha20Poly1305ParametersM3434create = XChaCha20Poly1305Parameters.m3434create(c0374Variant);
            return new XChaCha20Poly1305Key(xChaCha20Poly1305ParametersM3434create, secretBytes, getOutputPrefix(xChaCha20Poly1305ParametersM3434create, num), num);
        }
        throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.m4296size());
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public XChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey
    public C0878Bytes getOutputPrefix() {
        return this.outputPrefix;
    }
}
