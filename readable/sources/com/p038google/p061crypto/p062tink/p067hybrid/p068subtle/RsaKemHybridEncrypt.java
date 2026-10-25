package com.p038google.p061crypto.p062tink.p067hybrid.p068subtle;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.p063aead.p064subtle.AeadFactory;
import com.p038google.p061crypto.p062tink.p075subtle.C0866Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class RsaKemHybridEncrypt implements HybridEncrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPublicKey recipientPublicKey;

    public RsaKemHybridEncrypt(RSAPublicKey rSAPublicKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        C0410RsaKem.validateRsaModulus(rSAPublicKey.getModulus());
        this.recipientPublicKey = rSAPublicKey;
        this.hkdfHmacAlgo = str;
        this.hkdfSalt = bArr;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.p038google.p061crypto.p062tink.HybridEncrypt
    /* renamed from: encrypt */
    public byte[] mo3331encrypt(byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        byte[] bArrGenerateSecret = C0410RsaKem.generateSecret(this.recipientPublicKey.getModulus());
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, this.recipientPublicKey);
        byte[] bArrDoFinal = cipher.doFinal(bArrGenerateSecret);
        byte[] bArrMo3323encrypt = this.aeadFactory.createAead(C0866Hkdf.computeHkdf(this.hkdfHmacAlgo, bArrGenerateSecret, this.hkdfSalt, bArr2, this.aeadFactory.getKeySizeInBytes())).mo3323encrypt(bArr, C0410RsaKem.EMPTY_AAD);
        return ByteBuffer.allocate(bArrDoFinal.length + bArrMo3323encrypt.length).put(bArrDoFinal).put(bArrMo3323encrypt).array();
    }
}
