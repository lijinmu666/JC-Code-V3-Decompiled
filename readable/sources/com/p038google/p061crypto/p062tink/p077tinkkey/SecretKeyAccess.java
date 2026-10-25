package com.p038google.p061crypto.p062tink.p077tinkkey;

@Deprecated
/* loaded from: classes.dex */
public final class SecretKeyAccess {
    private SecretKeyAccess() {
    }

    public static KeyAccess insecureSecretAccess() {
        return KeyAccess.secretAccess();
    }
}
