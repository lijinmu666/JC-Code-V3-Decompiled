package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import com.p038google.p061crypto.p062tink.p075subtle.C0874X25519;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class X25519HpkeKem implements InterfaceC0402HpkeKem {

    /* renamed from: hkdf */
    private final HkdfHpkeKdf f3093hkdf;

    public X25519HpkeKem(HkdfHpkeKdf hkdfHpkeKdf) {
        this.f3093hkdf = hkdfHpkeKdf;
    }

    private byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrM4229concat = C0853Bytes.m4229concat(bArr2, bArr3);
        byte[] bArrKemSuiteId = HpkeUtil.kemSuiteId(HpkeUtil.X25519_HKDF_SHA256_KEM_ID);
        HkdfHpkeKdf hkdfHpkeKdf = this.f3093hkdf;
        return hkdfHpkeKdf.extractAndExpand(null, bArr, "eae_prk", bArrM4229concat, "shared_secret", bArrKemSuiteId, hkdfHpkeKdf.getMacLength());
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0402HpkeKem
    public byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) {
        return deriveKemSharedSecret(C0874X25519.computeSharedSecret(hpkeKemPrivateKey.getSerializedPrivate().toByteArray(), bArr), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray());
    }

    public HpkeKemEncapOutput encapsulate(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        byte[] bArrComputeSharedSecret = C0874X25519.computeSharedSecret(bArr2, bArr);
        byte[] bArrPublicFromPrivate = C0874X25519.publicFromPrivate(bArr2);
        return new HpkeKemEncapOutput(deriveKemSharedSecret(bArrComputeSharedSecret, bArrPublicFromPrivate, bArr), bArrPublicFromPrivate);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0402HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        if (Arrays.equals(this.f3093hkdf.getKdfId(), HpkeUtil.HKDF_SHA256_KDF_ID)) {
            return HpkeUtil.X25519_HKDF_SHA256_KEM_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0402HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] bArr) {
        return encapsulate(bArr, C0874X25519.generatePrivateKey());
    }
}
