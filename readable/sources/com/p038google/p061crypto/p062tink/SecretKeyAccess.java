package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class SecretKeyAccess {
    private static final SecretKeyAccess INSTANCE = new SecretKeyAccess();

    private SecretKeyAccess() {
    }

    public static SecretKeyAccess instance() {
        return INSTANCE;
    }

    public static SecretKeyAccess requireAccess(@Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (secretKeyAccess != null) {
            return secretKeyAccess;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
