package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public abstract class SignaturePublicKey extends AbstractC0308Key {
    public abstract C0878Bytes getOutputPrefix();

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public abstract SignatureParameters getParameters();
}
