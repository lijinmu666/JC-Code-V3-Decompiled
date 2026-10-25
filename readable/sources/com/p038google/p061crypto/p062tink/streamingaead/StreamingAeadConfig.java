package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.p065config.TinkFips;
import com.p038google.p061crypto.p062tink.p073proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class StreamingAeadConfig {
    public static final String AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL = new AesCtrHmacStreamingKeyManager().getKeyType();
    public static final String AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL = new AesGcmHkdfStreamingKeyManager().getKeyType();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    /* renamed from: LATEST */
    public static final RegistryConfig f3877LATEST = RegistryConfig.getDefaultInstance();

    static {
        try {
            m4212init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private StreamingAeadConfig() {
    }

    @Deprecated
    /* renamed from: init */
    public static void m4212init() {
        register();
    }

    public static void register() {
        StreamingAeadWrapper.register();
        if (TinkFips.useOnlyFips()) {
            return;
        }
        AesCtrHmacStreamingKeyManager.register(true);
        AesGcmHkdfStreamingKeyManager.register(true);
    }
}
