package com.p038google.p061crypto.p062tink.p078util;

import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import java.security.MessageDigest;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class SecretBytes {

    /* renamed from: bytes */
    private final C0878Bytes f4026bytes;

    private SecretBytes(C0878Bytes c0878Bytes) {
        this.f4026bytes = c0878Bytes;
    }

    public static SecretBytes copyFrom(byte[] bArr, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return new SecretBytes(C0878Bytes.copyFrom(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static SecretBytes randomBytes(int i) {
        return new SecretBytes(C0878Bytes.copyFrom(C0870Random.randBytes(i)));
    }

    public boolean equalsSecretBytes(SecretBytes secretBytes) {
        return MessageDigest.isEqual(this.f4026bytes.toByteArray(), secretBytes.f4026bytes.toByteArray());
    }

    /* renamed from: size */
    public int m4296size() {
        return this.f4026bytes.m4292size();
    }

    public byte[] toByteArray(SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess != null) {
            return this.f4026bytes.toByteArray();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
