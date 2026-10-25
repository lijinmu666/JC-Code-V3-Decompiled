package com.p038google.p061crypto.p062tink.p070jwt;

/* loaded from: classes.dex */
public final class JwtMacConfig {
    public static final String JWT_HMAC_TYPE_URL = new JwtHmacKeyManager().getKeyType();

    private JwtMacConfig() {
    }

    public static void register() {
        JwtHmacKeyManager.register(true);
        JwtMacWrapper.register();
    }
}
