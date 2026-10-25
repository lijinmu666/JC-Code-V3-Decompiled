package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.C0306Config;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class HybridEncryptConfig {
    private HybridEncryptConfig() {
    }

    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        C0306Config.register(HybridConfig.TINK_1_0_0);
    }
}
