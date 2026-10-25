package com.p038google.p061crypto.p062tink.p071mac.internal;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p071mac.C0465HmacKey;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMac;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class ChunkedHmacImpl implements ChunkedMac {

    /* renamed from: FIPS */
    private static final TinkFipsUtil.AlgorithmFipsCompatibility f3180FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    /* renamed from: key */
    private final C0465HmacKey f3181key;

    public ChunkedHmacImpl(C0465HmacKey c0465HmacKey) throws GeneralSecurityException {
        if (!f3180FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.f3181key = c0465HmacKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMac
    public ChunkedMacComputation createComputation() {
        return new ChunkedHmacComputation(this.f3181key);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMac
    public ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < this.f3181key.getOutputPrefix().m4292size()) {
            throw new GeneralSecurityException("Tag too short");
        }
        if (this.f3181key.getOutputPrefix().m4291equals(C0878Bytes.copyFrom(bArr, 0, this.f3181key.getOutputPrefix().m4292size()))) {
            return new ChunkedHmacVerification(this.f3181key, bArr);
        }
        throw new GeneralSecurityException("Wrong tag prefix");
    }
}
