package com.p038google.p061crypto.p062tink.p071mac.internal;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p071mac.AesCmacKey;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMac;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class ChunkedAesCmacImpl implements ChunkedMac {

    /* renamed from: FIPS */
    private static final TinkFipsUtil.AlgorithmFipsCompatibility f3175FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;

    /* renamed from: key */
    private final AesCmacKey f3176key;

    public ChunkedAesCmacImpl(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        if (!f3175FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        this.f3176key = aesCmacKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMac
    public ChunkedMacComputation createComputation() {
        return new ChunkedAesCmacComputation(this.f3176key);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMac
    public ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < this.f3176key.getOutputPrefix().m4292size()) {
            throw new GeneralSecurityException("Tag too short");
        }
        if (this.f3176key.getOutputPrefix().m4291equals(C0878Bytes.copyFrom(bArr, 0, this.f3176key.getOutputPrefix().m4292size()))) {
            return new ChunkedAesCmacVerification(this.f3176key, bArr);
        }
        throw new GeneralSecurityException("Wrong tag prefix");
    }
}
