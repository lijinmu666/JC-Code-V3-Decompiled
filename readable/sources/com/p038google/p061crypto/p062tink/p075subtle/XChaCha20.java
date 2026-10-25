package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceXChaCha20;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
class XChaCha20 implements IndCpaCipher {
    static final int NONCE_LENGTH_IN_BYTES = 24;

    /* renamed from: cipher */
    private final InsecureNonceXChaCha20 f4004cipher;

    public XChaCha20(byte[] bArr, int i) {
        this.f4004cipher = new InsecureNonceXChaCha20(bArr, i);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.IndCpaCipher
    /* renamed from: decrypt */
    public byte[] mo4215decrypt(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 24) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.f4004cipher.mo3442decrypt(Arrays.copyOf(bArr, 24), ByteBuffer.wrap(bArr, 24, bArr.length - 24));
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.IndCpaCipher
    /* renamed from: encrypt */
    public byte[] mo4216encrypt(byte[] bArr) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 24);
        byte[] bArrRandBytes = C0870Random.randBytes(24);
        byteBufferAllocate.put(bArrRandBytes);
        this.f4004cipher.mo3444encrypt(byteBufferAllocate, bArrRandBytes, bArr);
        return byteBufferAllocate.array();
    }
}
