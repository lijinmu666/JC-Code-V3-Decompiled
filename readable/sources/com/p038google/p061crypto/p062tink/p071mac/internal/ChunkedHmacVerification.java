package com.p038google.p061crypto.p062tink.p071mac.internal;

import com.p038google.p061crypto.p062tink.p071mac.C0465HmacKey;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ChunkedHmacVerification implements ChunkedMacVerification {
    private final ChunkedHmacComputation hmacComputation;

    /* renamed from: tag */
    private final C0878Bytes f3182tag;

    public ChunkedHmacVerification(C0465HmacKey c0465HmacKey, byte[] bArr) {
        this.hmacComputation = new ChunkedHmacComputation(c0465HmacKey);
        this.f3182tag = C0878Bytes.copyFrom(bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification
    /* renamed from: update */
    public void mo3519update(ByteBuffer byteBuffer) {
        this.hmacComputation.mo3518update(byteBuffer);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification
    public void verifyMac() throws GeneralSecurityException {
        if (!this.f3182tag.m4291equals(C0878Bytes.copyFrom(this.hmacComputation.computeMac()))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
