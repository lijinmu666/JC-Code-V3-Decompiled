package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.KeysetHandle;

@Deprecated
/* loaded from: classes.dex */
public final class HybridDecryptFactory {
    private HybridDecryptFactory() {
    }

    @Deprecated
    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle) {
        HybridDecryptWrapper.register();
        return (HybridDecrypt) keysetHandle.getPrimitive(HybridDecrypt.class);
    }
}
