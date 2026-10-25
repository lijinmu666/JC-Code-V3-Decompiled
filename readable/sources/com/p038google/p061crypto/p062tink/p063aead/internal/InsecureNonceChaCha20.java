package com.p038google.p061crypto.p062tink.p063aead.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class InsecureNonceChaCha20 extends InsecureNonceChaCha20Base {
    public InsecureNonceChaCha20(byte[] bArr, int i) {
        super(bArr, i);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Base
    public int[] createInitialState(int[] iArr, int i) {
        if (iArr.length != nonceSizeInBytes() / 4) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr2 = new int[16];
        ChaCha20Util.setSigmaAndKey(iArr2, this.f3063key);
        iArr2[12] = i;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Base
    /* renamed from: decrypt */
    public /* bridge */ /* synthetic */ byte[] mo3442decrypt(byte[] bArr, ByteBuffer byteBuffer) {
        return super.mo3442decrypt(bArr, byteBuffer);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Base
    /* renamed from: encrypt */
    public /* bridge */ /* synthetic */ void mo3444encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        super.mo3444encrypt(byteBuffer, bArr, bArr2);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Base
    public int nonceSizeInBytes() {
        return 12;
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Base
    /* renamed from: decrypt */
    public /* bridge */ /* synthetic */ byte[] mo3443decrypt(byte[] bArr, byte[] bArr2) {
        return super.mo3443decrypt(bArr, bArr2);
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Base
    /* renamed from: encrypt */
    public /* bridge */ /* synthetic */ byte[] mo3445encrypt(byte[] bArr, byte[] bArr2) {
        return super.mo3445encrypt(bArr, bArr2);
    }
}
