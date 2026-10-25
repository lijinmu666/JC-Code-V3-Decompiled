package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class KmsEnvelopeAead implements InterfaceC0305Aead {
    private static final byte[] EMPTY_AAD = new byte[0];
    private static final int LENGTH_ENCRYPTED_DEK = 4;
    private final KeyTemplate dekTemplate;

    /* renamed from: remote */
    private final InterfaceC0305Aead f3053remote;

    public KmsEnvelopeAead(KeyTemplate keyTemplate, InterfaceC0305Aead interfaceC0305Aead) {
        this.dekTemplate = keyTemplate;
        this.f3053remote = interfaceC0305Aead;
    }

    private byte[] buildCiphertext(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: decrypt */
    public byte[] mo3322decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((InterfaceC0305Aead) Registry.getPrimitive(this.dekTemplate.getTypeUrl(), this.f3053remote.mo3322decrypt(bArr3, EMPTY_AAD), InterfaceC0305Aead.class)).mo3322decrypt(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: encrypt */
    public byte[] mo3323encrypt(byte[] bArr, byte[] bArr2) {
        byte[] byteArray = Registry.m3388newKey(this.dekTemplate).toByteArray();
        return buildCiphertext(this.f3053remote.mo3323encrypt(byteArray, EMPTY_AAD), ((InterfaceC0305Aead) Registry.getPrimitive(this.dekTemplate.getTypeUrl(), byteArray, InterfaceC0305Aead.class)).mo3323encrypt(bArr, bArr2));
    }
}
