package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceChaCha20Poly1305;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes.dex */
final class ChaCha20Poly1305HpkeAead implements HpkeAead {
    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    public byte[] getAeadId() {
        return HpkeUtil.CHACHA20_POLY1305_AEAD_ID;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    public int getKeyLength() {
        return 32;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    /* renamed from: open */
    public byte[] mo3459open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws InvalidAlgorithmParameterException {
        if (bArr.length == getKeyLength()) {
            return new InsecureNonceChaCha20Poly1305(bArr).mo3448decrypt(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    /* renamed from: seal */
    public byte[] mo3460seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws InvalidAlgorithmParameterException {
        if (bArr.length == getKeyLength()) {
            return new InsecureNonceChaCha20Poly1305(bArr).mo3450encrypt(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
    }
}
