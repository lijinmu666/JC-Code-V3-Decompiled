package com.p038google.p061crypto.p062tink.p066daead;

import com.p038google.p061crypto.p062tink.p065config.TinkFips;
import com.p038google.p061crypto.p062tink.p073proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class DeterministicAeadConfig {
    public static final String AES_SIV_TYPE_URL = new AesSivKeyManager().getKeyType();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    /* renamed from: LATEST */
    @Deprecated
    public static final RegistryConfig f3070LATEST = RegistryConfig.getDefaultInstance();

    static {
        try {
            register();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private DeterministicAeadConfig() {
    }

    @Deprecated
    /* renamed from: init */
    public static void m3456init() {
        register();
    }

    public static void register() {
        DeterministicAeadWrapper.register();
        if (TinkFips.useOnlyFips()) {
            return;
        }
        AesSivKeyManager.register(true);
    }
}
