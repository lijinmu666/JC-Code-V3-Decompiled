package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
class ChaCha20 implements IndCpaCipher {
    static final int NONCE_LENGTH_IN_BYTES = 12;

    /* renamed from: cipher */
    private final InsecureNonceChaCha20 f3925cipher;

    public ChaCha20(byte[] bArr, int i) {
        this.f3925cipher = new InsecureNonceChaCha20(bArr, i);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.IndCpaCipher
    /* renamed from: decrypt */
    public byte[] mo4215decrypt(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 12) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.f3925cipher.mo3442decrypt(Arrays.copyOf(bArr, 12), ByteBuffer.wrap(bArr, 12, bArr.length - 12));
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.IndCpaCipher
    /* renamed from: encrypt */
    public byte[] mo4216encrypt(byte[] bArr) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 12);
        byte[] bArrRandBytes = C0870Random.randBytes(12);
        byteBufferAllocate.put(bArrRandBytes);
        this.f3925cipher.mo3444encrypt(byteBufferAllocate, bArrRandBytes, bArr);
        return byteBufferAllocate.array();
    }
}
