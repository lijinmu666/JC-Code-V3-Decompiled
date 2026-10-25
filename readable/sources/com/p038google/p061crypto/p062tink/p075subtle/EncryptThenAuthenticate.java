package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.InterfaceC0317Mac;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class EncryptThenAuthenticate implements InterfaceC0305Aead {

    /* renamed from: cipher */
    private final IndCpaCipher f3959cipher;

    /* renamed from: mac */
    private final InterfaceC0317Mac f3960mac;
    private final int macLength;

    public EncryptThenAuthenticate(IndCpaCipher indCpaCipher, InterfaceC0317Mac interfaceC0317Mac, int i) {
        this.f3959cipher = indCpaCipher;
        this.f3960mac = interfaceC0317Mac;
        this.macLength = i;
    }

    public static InterfaceC0305Aead newAesCtrHmac(byte[] bArr, int i, String str, byte[] bArr2, int i2) {
        return new EncryptThenAuthenticate(new AesCtrJceCipher(bArr, i), new C0869PrfMac(new PrfHmacJce(str, new SecretKeySpec(bArr2, "HMAC")), i2), i2);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: decrypt */
    public byte[] mo3322decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.macLength;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.macLength, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.f3960mac.verifyMac(bArrCopyOfRange2, C0853Bytes.m4229concat(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        return this.f3959cipher.mo4215decrypt(bArrCopyOfRange);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: encrypt */
    public byte[] mo3323encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArrMo4216encrypt = this.f3959cipher.mo4216encrypt(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return C0853Bytes.m4229concat(bArrMo4216encrypt, this.f3960mac.computeMac(C0853Bytes.m4229concat(bArr2, bArrMo4216encrypt, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
