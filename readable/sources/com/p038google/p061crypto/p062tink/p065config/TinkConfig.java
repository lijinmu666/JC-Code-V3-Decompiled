package com.p038google.p061crypto.p062tink.p065config;

import com.p038google.p061crypto.p062tink.p066daead.DeterministicAeadConfig;
import com.p038google.p061crypto.p062tink.p067hybrid.HybridConfig;
import com.p038google.p061crypto.p062tink.p072prf.PrfConfig;
import com.p038google.p061crypto.p062tink.p073proto.RegistryConfig;
import com.p038google.p061crypto.p062tink.signature.SignatureConfig;
import com.p038google.p061crypto.p062tink.streamingaead.StreamingAeadConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class TinkConfig {

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.getDefaultInstance();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    /* renamed from: LATEST */
    @Deprecated
    public static final RegistryConfig f3066LATEST = RegistryConfig.getDefaultInstance();

    static {
        try {
            m3453init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private TinkConfig() {
    }

    @Deprecated
    /* renamed from: init */
    public static void m3453init() {
        register();
    }

    public static void register() {
        DeterministicAeadConfig.register();
        HybridConfig.register();
        PrfConfig.register();
        SignatureConfig.register();
        StreamingAeadConfig.register();
    }
}
