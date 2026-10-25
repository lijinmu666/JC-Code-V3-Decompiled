package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p075subtle.C0874X25519;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;

/* loaded from: classes.dex */
final class X25519HpkeKemPrivateKey implements HpkeKemPrivateKey {
    private final C0878Bytes privateKey;
    private final C0878Bytes publicKey;

    private X25519HpkeKemPrivateKey(byte[] bArr, byte[] bArr2) {
        this.privateKey = C0878Bytes.copyFrom(bArr);
        this.publicKey = C0878Bytes.copyFrom(bArr2);
    }

    public static X25519HpkeKemPrivateKey fromBytes(byte[] bArr) {
        return new X25519HpkeKemPrivateKey(bArr, C0874X25519.publicFromPrivate(bArr));
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeKemPrivateKey
    public C0878Bytes getSerializedPrivate() {
        return this.privateKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeKemPrivateKey
    public C0878Bytes getSerializedPublic() {
        return this.publicKey;
    }
}
