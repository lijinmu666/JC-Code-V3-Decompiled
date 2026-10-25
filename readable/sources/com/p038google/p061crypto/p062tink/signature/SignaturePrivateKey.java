package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.PrivateKey;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public abstract class SignaturePrivateKey extends AbstractC0308Key implements PrivateKey {
    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return getPublicKey().getIdRequirementOrNull();
    }

    public final C0878Bytes getOutputPrefix() {
        return getPublicKey().getOutputPrefix();
    }

    @Override // com.p038google.p061crypto.p062tink.PrivateKey
    public abstract SignaturePublicKey getPublicKey();

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public SignatureParameters getParameters() {
        return getPublicKey().getParameters();
    }
}
