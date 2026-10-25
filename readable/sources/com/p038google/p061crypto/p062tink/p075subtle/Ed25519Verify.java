package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.PublicKeyVerify;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class Ed25519Verify implements PublicKeyVerify {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3952FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final C0878Bytes publicKey;

    public Ed25519Verify(byte[] bArr) {
        if (!f3952FIPS.isCompatible()) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        this.publicKey = C0878Bytes.copyFrom(bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.PublicKeyVerify
    /* renamed from: verify */
    public void mo3387verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            throw new GeneralSecurityException(String.format("The length of the signature is not %s.", 64));
        }
        if (!C0855Ed25519.m4248verify(bArr2, bArr, this.publicKey.toByteArray())) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}
