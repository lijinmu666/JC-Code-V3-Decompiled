package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.p065config.TinkFips;
import com.p038google.p061crypto.p062tink.p073proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class MacConfig {
    public static final String HMAC_TYPE_URL = new HmacKeyManager().getKeyType();

    /* renamed from: LATEST */
    @Deprecated
    public static final RegistryConfig f3166LATEST;

    @Deprecated
    public static final RegistryConfig TINK_1_0_0;

    @Deprecated
    public static final RegistryConfig TINK_1_1_0;

    static {
        RegistryConfig defaultInstance = RegistryConfig.getDefaultInstance();
        TINK_1_0_0 = defaultInstance;
        TINK_1_1_0 = defaultInstance;
        f3166LATEST = defaultInstance;
        try {
            m3529init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private MacConfig() {
    }

    @Deprecated
    /* renamed from: init */
    public static void m3529init() {
        register();
    }

    public static void register() {
        MacWrapper.register();
        ChunkedMacWrapper.register();
        HmacKeyManager.register(true);
        if (TinkFips.useOnlyFips()) {
            return;
        }
        AesCmacKeyManager.register(true);
    }

    @Deprecated
    public static void registerStandardKeyTypes() {
        register();
    }
}
