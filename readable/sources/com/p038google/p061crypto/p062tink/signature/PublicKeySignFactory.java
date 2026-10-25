package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeysetHandle;
import com.p038google.p061crypto.p062tink.PublicKeySign;

@Deprecated
/* loaded from: classes.dex */
public final class PublicKeySignFactory {
    private PublicKeySignFactory() {
    }

    @Deprecated
    public static PublicKeySign getPrimitive(KeysetHandle keysetHandle) {
        PublicKeySignWrapper.register();
        return (PublicKeySign) keysetHandle.getPrimitive(PublicKeySign.class);
    }
}
