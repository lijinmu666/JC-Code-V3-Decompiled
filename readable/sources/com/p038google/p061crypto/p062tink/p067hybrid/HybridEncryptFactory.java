package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.KeysetHandle;

@Deprecated
/* loaded from: classes.dex */
public final class HybridEncryptFactory {
    private HybridEncryptFactory() {
    }

    @Deprecated
    public static HybridEncrypt getPrimitive(KeysetHandle keysetHandle) {
        HybridEncryptWrapper.register();
        return (HybridEncrypt) keysetHandle.getPrimitive(HybridEncrypt.class);
    }
}
