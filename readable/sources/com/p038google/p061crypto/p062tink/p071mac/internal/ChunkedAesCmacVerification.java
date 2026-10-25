package com.p038google.p061crypto.p062tink.p071mac.internal;

import com.p038google.p061crypto.p062tink.p071mac.AesCmacKey;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* loaded from: classes.dex */
final class ChunkedAesCmacVerification implements ChunkedMacVerification {
    private final ChunkedAesCmacComputation aesCmacComputation;

    /* renamed from: tag */
    private final C0878Bytes f3177tag;

    public ChunkedAesCmacVerification(AesCmacKey aesCmacKey, byte[] bArr) {
        this.aesCmacComputation = new ChunkedAesCmacComputation(aesCmacKey);
        this.f3177tag = C0878Bytes.copyFrom(bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification
    /* renamed from: update */
    public void mo3519update(ByteBuffer byteBuffer) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        this.aesCmacComputation.mo3518update(byteBuffer);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacVerification
    public void verifyMac() throws GeneralSecurityException {
        if (!this.f3177tag.m4291equals(C0878Bytes.copyFrom(this.aesCmacComputation.computeMac()))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
