package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.p063aead.internal.InsecureNonceAesGcmJce;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class AesGcmJce implements InterfaceC0305Aead {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3907FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final InsecureNonceAesGcmJce insecureNonceAesGcmJce;

    public AesGcmJce(byte[] bArr) throws GeneralSecurityException {
        if (!f3907FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.insecureNonceAesGcmJce = new InsecureNonceAesGcmJce(bArr, true);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: decrypt */
    public byte[] mo3322decrypt(byte[] bArr, byte[] bArr2) {
        return this.insecureNonceAesGcmJce.m3440decrypt(Arrays.copyOf(bArr, 12), bArr, bArr2);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
    /* renamed from: encrypt */
    public byte[] mo3323encrypt(byte[] bArr, byte[] bArr2) {
        return this.insecureNonceAesGcmJce.m3441encrypt(C0870Random.randBytes(12), bArr, bArr2);
    }
}
