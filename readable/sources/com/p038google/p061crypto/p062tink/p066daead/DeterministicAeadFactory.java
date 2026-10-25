package com.p038google.p061crypto.p062tink.p066daead;

import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.KeysetHandle;

@Deprecated
/* loaded from: classes.dex */
public final class DeterministicAeadFactory {
    private DeterministicAeadFactory() {
    }

    @Deprecated
    public static DeterministicAead getPrimitive(KeysetHandle keysetHandle) {
        DeterministicAeadWrapper.register();
        return (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class);
    }
}
