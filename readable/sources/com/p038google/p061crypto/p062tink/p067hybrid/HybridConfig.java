package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.p063aead.AeadConfig;
import com.p038google.p061crypto.p062tink.p065config.TinkFips;
import com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkePrivateKeyManager;
import com.p038google.p061crypto.p062tink.p073proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class HybridConfig {
    public static final String ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = new EciesAeadHkdfPublicKeyManager().getKeyType();
    public static final String ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = new EciesAeadHkdfPrivateKeyManager().getKeyType();

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.getDefaultInstance();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    /* renamed from: LATEST */
    @Deprecated
    public static final RegistryConfig f3074LATEST = RegistryConfig.getDefaultInstance();

    static {
        try {
            m3458init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private HybridConfig() {
    }

    @Deprecated
    /* renamed from: init */
    public static void m3458init() {
        register();
    }

    public static void register() {
        HybridDecryptWrapper.register();
        HybridEncryptWrapper.register();
        AeadConfig.register();
        if (TinkFips.useOnlyFips()) {
            return;
        }
        EciesAeadHkdfPrivateKeyManager.registerPair(true);
        HpkePrivateKeyManager.registerPair(true);
    }
}
