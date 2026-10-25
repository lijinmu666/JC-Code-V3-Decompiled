package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.InterfaceC0317Mac;
import com.p038google.p061crypto.p062tink.KeysetHandle;

@Deprecated
/* loaded from: classes.dex */
public final class MacFactory {
    private MacFactory() {
    }

    @Deprecated
    public static InterfaceC0317Mac getPrimitive(KeysetHandle keysetHandle) {
        MacWrapper.register();
        return (InterfaceC0317Mac) keysetHandle.getPrimitive(InterfaceC0317Mac.class);
    }
}
