package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.p065config.TinkFips;
import com.p038google.p061crypto.p062tink.p073proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class SignatureConfig {
    public static final String ECDSA_PUBLIC_KEY_TYPE_URL = new EcdsaVerifyKeyManager().getKeyType();
    public static final String ECDSA_PRIVATE_KEY_TYPE_URL = new EcdsaSignKeyManager().getKeyType();
    public static final String ED25519_PUBLIC_KEY_TYPE_URL = new Ed25519PublicKeyManager().getKeyType();
    public static final String ED25519_PRIVATE_KEY_TYPE_URL = new Ed25519PrivateKeyManager().getKeyType();
    public static final String RSA_PKCS1_PRIVATE_KEY_TYPE_URL = new RsaSsaPkcs1SignKeyManager().getKeyType();
    public static final String RSA_PKCS1_PUBLIC_KEY_TYPE_URL = new RsaSsaPkcs1VerifyKeyManager().getKeyType();
    public static final String RSA_PSS_PRIVATE_KEY_TYPE_URL = new RsaSsaPssSignKeyManager().getKeyType();
    public static final String RSA_PSS_PUBLIC_KEY_TYPE_URL = new RsaSsaPssVerifyKeyManager().getKeyType();

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.getDefaultInstance();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    /* renamed from: LATEST */
    @Deprecated
    public static final RegistryConfig f3869LATEST = RegistryConfig.getDefaultInstance();

    static {
        try {
            m4207init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private SignatureConfig() {
    }

    @Deprecated
    /* renamed from: init */
    public static void m4207init() {
        register();
    }

    public static void register() {
        PublicKeySignWrapper.register();
        PublicKeyVerifyWrapper.register();
        EcdsaSignKeyManager.registerPair(true);
        RsaSsaPkcs1SignKeyManager.registerPair(true);
        if (TinkFips.useOnlyFips()) {
            return;
        }
        RsaSsaPssSignKeyManager.registerPair(true);
        Ed25519PrivateKeyManager.registerPair(true);
    }
}
