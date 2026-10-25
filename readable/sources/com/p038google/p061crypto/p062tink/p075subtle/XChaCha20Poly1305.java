package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceXChaCha20Poly1305;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class XChaCha20Poly1305 implements InterfaceC0305Aead {

    /* renamed from: cipher */
    private final InsecureNonceXChaCha20Poly1305 f4005cipher;

    public XChaCha20Poly1305(byte[] bArr) {
        this.f4005cipher = new InsecureNonceXChaCha20Poly1305(bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: decrypt */
    public byte[] mo3322decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 24);
        return this.f4005cipher.mo3447decrypt(ByteBuffer.wrap(bArr, 24, bArr.length - 24), bArrCopyOf, bArr2);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: encrypt */
    public byte[] mo3323encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 40);
        byte[] bArrRandBytes = C0870Random.randBytes(24);
        byteBufferAllocate.put(bArrRandBytes);
        this.f4005cipher.mo3449encrypt(byteBufferAllocate, bArrRandBytes, bArr, bArr2);
        return byteBufferAllocate.array();
    }
}
