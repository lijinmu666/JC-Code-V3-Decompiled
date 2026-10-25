package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;

/* renamed from: com.google.crypto.tink.aead.AeadKey */
/* loaded from: classes.dex */
public abstract class AbstractC0326AeadKey extends AbstractC0308Key {
    public abstract C0878Bytes getOutputPrefix();

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public abstract AeadParameters getParameters();
}
