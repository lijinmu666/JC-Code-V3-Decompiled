package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeysetHandle;
import com.p038google.p061crypto.p062tink.PublicKeyVerify;

@Deprecated
/* loaded from: classes.dex */
public final class PublicKeyVerifyFactory {
    private PublicKeyVerifyFactory() {
    }

    @Deprecated
    public static PublicKeyVerify getPrimitive(KeysetHandle keysetHandle) {
        PublicKeyVerifyWrapper.register();
        return (PublicKeyVerify) keysetHandle.getPrimitive(PublicKeyVerify.class);
    }
}
