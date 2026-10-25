package com.p038google.p061crypto.p062tink.p067hybrid.p068subtle;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.p063aead.p064subtle.AeadFactory;
import com.p038google.p061crypto.p062tink.p075subtle.C0866Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateKey;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class RsaKemHybridDecrypt implements HybridDecrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPrivateKey recipientPrivateKey;

    public RsaKemHybridDecrypt(RSAPrivateKey rSAPrivateKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        C0410RsaKem.validateRsaModulus(rSAPrivateKey.getModulus());
        this.recipientPrivateKey = rSAPrivateKey;
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.p038google.p061crypto.p062tink.HybridDecrypt
    /* renamed from: decrypt */
    public byte[] mo3330decrypt(byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        int iBigIntSizeInBytes = C0410RsaKem.bigIntSizeInBytes(this.recipientPrivateKey.getModulus());
        if (bArr.length < iBigIntSizeInBytes) {
            throw new GeneralSecurityException(String.format("Ciphertext must be of at least size %d bytes, but got %d", Integer.valueOf(iBigIntSizeInBytes), Integer.valueOf(bArr.length)));
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte[] bArr3 = new byte[iBigIntSizeInBytes];
        byteBufferWrap.get(bArr3);
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(2, this.recipientPrivateKey);
        InterfaceC0305Aead interfaceC0305AeadCreateAead = this.aeadFactory.createAead(C0866Hkdf.computeHkdf(this.hkdfHmacAlgo, cipher.doFinal(bArr3), this.hkdfSalt, bArr2, this.aeadFactory.getKeySizeInBytes()));
        byte[] bArr4 = new byte[byteBufferWrap.remaining()];
        byteBufferWrap.get(bArr4);
        return interfaceC0305AeadCreateAead.mo3322decrypt(bArr4, C0410RsaKem.EMPTY_AAD);
    }
}
