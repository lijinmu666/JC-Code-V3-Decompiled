package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceAesGcmJce;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes.dex */
final class AesGcmHpkeAead implements HpkeAead {
    private final int keyLength;

    public AesGcmHpkeAead(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.keyLength = i;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    public byte[] getAeadId() throws GeneralSecurityException {
        int i = this.keyLength;
        if (i == 16) {
            return HpkeUtil.AES_128_GCM_AEAD_ID;
        }
        if (i == 32) {
            return HpkeUtil.AES_256_GCM_AEAD_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    public int getKeyLength() {
        return this.keyLength;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    /* renamed from: open */
    public byte[] mo3459open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws InvalidAlgorithmParameterException {
        if (bArr.length == this.keyLength) {
            return new InsecureNonceAesGcmJce(bArr, false).m3440decrypt(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeAead
    /* renamed from: seal */
    public byte[] mo3460seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws InvalidAlgorithmParameterException {
        if (bArr.length == this.keyLength) {
            return new InsecureNonceAesGcmJce(bArr, false).m3441encrypt(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
    }
}
