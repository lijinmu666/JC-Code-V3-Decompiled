package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;

/* renamed from: com.google.crypto.tink.mac.MacKey */
/* loaded from: classes.dex */
public abstract class AbstractC0475MacKey extends AbstractC0308Key {
    public abstract C0878Bytes getOutputPrefix();

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public abstract MacParameters getParameters();
}
