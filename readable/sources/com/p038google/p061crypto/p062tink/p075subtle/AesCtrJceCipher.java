package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private final int blockSize;

    /* renamed from: ivSize */
    private final int f3892ivSize;

    /* renamed from: keySpec */
    private final SecretKeySpec f3893keySpec;

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3891FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesCtrJceCipher.1
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.f3961CIPHER.getInstance(AesCtrJceCipher.CIPHER_ALGORITHM);
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    public AesCtrJceCipher(byte[] bArr, int i) throws GeneralSecurityException {
        if (!f3891FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateAesKeySize(bArr.length);
        this.f3893keySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
        int blockSize = localCipher.get().getBlockSize();
        this.blockSize = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f3892ivSize = i;
    }

    /* renamed from: doCtr */
    private void m4214doCtr(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = localCipher.get();
        byte[] bArr4 = new byte[this.blockSize];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f3892ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z) {
            cipher.init(1, this.f3893keySpec, ivParameterSpec);
        } else {
            cipher.init(2, this.f3893keySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) != i2) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.IndCpaCipher
    /* renamed from: decrypt */
    public byte[] mo4215decrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.f3892ivSize;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int length2 = bArr.length;
        int i2 = this.f3892ivSize;
        byte[] bArr3 = new byte[length2 - i2];
        m4214doCtr(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
        return bArr3;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.IndCpaCipher
    /* renamed from: encrypt */
    public byte[] mo4216encrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.f3892ivSize;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.f3892ivSize));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] bArrRandBytes = C0870Random.randBytes(i);
        System.arraycopy(bArrRandBytes, 0, bArr2, 0, this.f3892ivSize);
        m4214doCtr(bArr, 0, bArr.length, bArr2, this.f3892ivSize, bArrRandBytes, true);
        return bArr2;
    }
}
