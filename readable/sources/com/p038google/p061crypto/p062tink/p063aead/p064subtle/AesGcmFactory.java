package com.p038google.p061crypto.p062tink.p063aead.p064subtle;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.p075subtle.AesGcmJce;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes.dex */
public final class AesGcmFactory implements AeadFactory {
    private final int keySizeInBytes;

    public AesGcmFactory(int i) {
        this.keySizeInBytes = validateAesKeySize(i);
    }

    private static int validateAesKeySize(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            return i;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid AES key size, expected 16 or 32, but got %d", Integer.valueOf(i)));
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.p064subtle.AeadFactory
    public InterfaceC0305Aead createAead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == getKeySizeInBytes()) {
            return new AesGcmJce(bArr);
        }
        throw new GeneralSecurityException(String.format("Symmetric key has incorrect length; expected %s, but got %s", Integer.valueOf(getKeySizeInBytes()), Integer.valueOf(bArr.length)));
    }

    @Override // com.p038google.p061crypto.p062tink.p063aead.p064subtle.AeadFactory
    public int getKeySizeInBytes() {
        return this.keySizeInBytes;
    }
}
