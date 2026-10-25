package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.KeysetHandle;

@Deprecated
/* loaded from: classes.dex */
public final class AeadFactory {
    private AeadFactory() {
    }

    @Deprecated
    public static InterfaceC0305Aead getPrimitive(KeysetHandle keysetHandle) {
        AeadWrapper.register();
        return (InterfaceC0305Aead) keysetHandle.getPrimitive(InterfaceC0305Aead.class);
    }
}
