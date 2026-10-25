package com.p038google.p061crypto.p062tink.p063aead.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class InsecureNonceXChaCha20Poly1305 extends InsecureNonceChaCha20Poly1305Base {
    public InsecureNonceXChaCha20Poly1305(byte[] bArr) {
        super(bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Poly1305Base
    /* renamed from: decrypt */
    public /* bridge */ /* synthetic */ byte[] mo3447decrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        return super.mo3447decrypt(byteBuffer, bArr, bArr2);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Poly1305Base
    /* renamed from: encrypt */
    public /* bridge */ /* synthetic */ void mo3449encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        super.mo3449encrypt(byteBuffer, bArr, bArr2, bArr3);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Poly1305Base
    public InsecureNonceChaCha20Base newChaCha20Instance(byte[] bArr, int i) {
        return new InsecureNonceXChaCha20(bArr, i);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Poly1305Base
    /* renamed from: decrypt */
    public /* bridge */ /* synthetic */ byte[] mo3448decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return super.mo3448decrypt(bArr, bArr2, bArr3);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Poly1305Base
    /* renamed from: encrypt */
    public /* bridge */ /* synthetic */ byte[] mo3450encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return super.mo3450encrypt(bArr, bArr2, bArr3);
    }
}
