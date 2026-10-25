package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
final class HkdfHpkeKdf implements InterfaceC0401HpkeKdf {
    private final String macAlgorithm;

    public HkdfHpkeKdf(String str) {
        this.macAlgorithm = str;
    }

    /* renamed from: expand */
    private byte[] m3461expand(byte[] bArr, byte[] bArr2, int i) throws IllegalStateException, GeneralSecurityException {
        Mac engineFactory = EngineFactory.f3962MAC.getInstance(this.macAlgorithm);
        if (i > engineFactory.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i];
        engineFactory.init(new SecretKeySpec(bArr, this.macAlgorithm));
        byte[] bArrDoFinal = new byte[0];
        int i2 = 1;
        int length = 0;
        while (true) {
            engineFactory.update(bArrDoFinal);
            engineFactory.update(bArr2);
            engineFactory.update((byte) i2);
            bArrDoFinal = engineFactory.doFinal();
            if (bArrDoFinal.length + length >= i) {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, i - length);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i2++;
        }
    }

    /* renamed from: extract */
    private byte[] m3462extract(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        Mac engineFactory = EngineFactory.f3962MAC.getInstance(this.macAlgorithm);
        if (bArr2 == null || bArr2.length == 0) {
            engineFactory.init(new SecretKeySpec(new byte[engineFactory.getMacLength()], this.macAlgorithm));
        } else {
            engineFactory.init(new SecretKeySpec(bArr2, this.macAlgorithm));
        }
        return engineFactory.doFinal(bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0401HpkeKdf
    public byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) {
        return m3461expand(m3462extract(HpkeUtil.labelIkm(str, bArr2, bArr4), bArr), HpkeUtil.labelInfo(str2, bArr3, bArr4, i), i);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0401HpkeKdf
    public byte[] getKdfId() throws GeneralSecurityException {
        String str = this.macAlgorithm;
        str.hashCode();
        switch (str) {
            case "HmacSha256":
                return HpkeUtil.HKDF_SHA256_KDF_ID;
            case "HmacSha384":
                return HpkeUtil.HKDF_SHA384_KDF_ID;
            case "HmacSha512":
                return HpkeUtil.HKDF_SHA512_KDF_ID;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    public int getMacLength() {
        return Mac.getInstance(this.macAlgorithm).getMacLength();
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0401HpkeKdf
    public byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) {
        return m3461expand(bArr, HpkeUtil.labelInfo(str, bArr2, bArr3, i), i);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0401HpkeKdf
    public byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return m3462extract(HpkeUtil.labelIkm(str, bArr2, bArr3), bArr);
    }
}
