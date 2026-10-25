package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p063aead.ChaCha20Poly1305Parameters;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class ChaCha20Poly1305Key extends AbstractC0326AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final C0878Bytes outputPrefix;
    private final ChaCha20Poly1305Parameters parameters;

    private ChaCha20Poly1305Key(ChaCha20Poly1305Parameters chaCha20Poly1305Parameters, SecretBytes secretBytes, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = chaCha20Poly1305Parameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @AccessesPartialKey
    /* renamed from: create */
    public static ChaCha20Poly1305Key m3423create(SecretBytes secretBytes) {
        return m3422create(ChaCha20Poly1305Parameters.C0358Variant.NO_PREFIX, secretBytes, null);
    }

    private static C0878Bytes getOutputPrefix(ChaCha20Poly1305Parameters chaCha20Poly1305Parameters, @Nullable Integer num) {
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.C0358Variant.NO_PREFIX) {
            return C0878Bytes.copyFrom(new byte[0]);
        }
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.C0358Variant.f3049CRUNCHY) {
            return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        }
        if (chaCha20Poly1305Parameters.getVariant() == ChaCha20Poly1305Parameters.C0358Variant.f3050TINK) {
            return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        throw new IllegalStateException("Unknown Variant: " + chaCha20Poly1305Parameters.getVariant());
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof ChaCha20Poly1305Key)) {
            return false;
        }
        ChaCha20Poly1305Key chaCha20Poly1305Key = (ChaCha20Poly1305Key) abstractC0308Key;
        return chaCha20Poly1305Key.parameters.m3426equals(this.parameters) && chaCha20Poly1305Key.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(chaCha20Poly1305Key.idRequirement, this.idRequirement);
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
    public static ChaCha20Poly1305Key m3422create(ChaCha20Poly1305Parameters.C0358Variant c0358Variant, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        ChaCha20Poly1305Parameters.C0358Variant c0358Variant2 = ChaCha20Poly1305Parameters.C0358Variant.NO_PREFIX;
        if (c0358Variant != c0358Variant2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + c0358Variant + " the value of idRequirement must be non-null");
        }
        if (c0358Variant == c0358Variant2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (secretBytes.m4296size() == 32) {
            ChaCha20Poly1305Parameters chaCha20Poly1305ParametersM3425create = ChaCha20Poly1305Parameters.m3425create(c0358Variant);
            return new ChaCha20Poly1305Key(chaCha20Poly1305ParametersM3425create, secretBytes, getOutputPrefix(chaCha20Poly1305ParametersM3425create, num), num);
        }
        throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + secretBytes.m4296size());
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public ChaCha20Poly1305Parameters getParameters() {
        return this.parameters;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.AbstractC0326AeadKey
    public C0878Bytes getOutputPrefix() {
        return this.outputPrefix;
    }
}
