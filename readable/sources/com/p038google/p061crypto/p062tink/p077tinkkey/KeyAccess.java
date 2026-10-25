package com.p038google.p061crypto.p062tink.p077tinkkey;

@Deprecated
/* loaded from: classes.dex */
public final class KeyAccess {
    private final boolean canAccessSecret;

    private KeyAccess(boolean z) {
        this.canAccessSecret = z;
    }

    public static KeyAccess publicAccess() {
        return new KeyAccess(false);
    }

    public static KeyAccess secretAccess() {
        return new KeyAccess(true);
    }

    public boolean canAccessSecret() {
        return this.canAccessSecret;
    }
}
