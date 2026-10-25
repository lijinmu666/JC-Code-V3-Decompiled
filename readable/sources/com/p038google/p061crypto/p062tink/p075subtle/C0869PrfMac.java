package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.InterfaceC0317Mac;
import com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.crypto.tink.subtle.PrfMac */
/* loaded from: classes.dex */
public class C0869PrfMac implements InterfaceC0317Mac {
    static final int MIN_TAG_SIZE_IN_BYTES = 10;

    /* renamed from: tagSize */
    private final int f3988tagSize;
    private final InterfaceC0504Prf wrappedPrf;

    public C0869PrfMac(InterfaceC0504Prf interfaceC0504Prf, int i) throws InvalidAlgorithmParameterException {
        this.wrappedPrf = interfaceC0504Prf;
        this.f3988tagSize = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        interfaceC0504Prf.mo3552compute(new byte[0], i);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0317Mac
    public byte[] computeMac(byte[] bArr) {
        return this.wrappedPrf.mo3552compute(bArr, this.f3988tagSize);
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0317Mac
    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!C0853Bytes.m4230equal(computeMac(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
