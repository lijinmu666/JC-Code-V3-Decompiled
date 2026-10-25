package com.p038google.p061crypto.p062tink.p078util;

import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import java.math.BigInteger;
import java.security.MessageDigest;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class SecretBigInteger {

    /* renamed from: value */
    private final BigInteger f4025value;

    private SecretBigInteger(BigInteger bigInteger) {
        this.f4025value = bigInteger;
    }

    public static SecretBigInteger fromBigInteger(BigInteger bigInteger, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return new SecretBigInteger(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public boolean equalsSecretBigInteger(SecretBigInteger secretBigInteger) {
        return MessageDigest.isEqual(this.f4025value.toByteArray(), secretBigInteger.f4025value.toByteArray());
    }

    public BigInteger getBigInteger(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return this.f4025value;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
