package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.ExtendedDigest;

/* loaded from: classes2.dex */
public class ShortenedDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;

    /* renamed from: length */
    private int f19566length;

    public ShortenedDigest(ExtendedDigest extendedDigest, int i) {
        if (extendedDigest == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        }
        if (i > extendedDigest.getDigestSize()) {
            throw new IllegalArgumentException("baseDigest output not large enough to support length");
        }
        this.baseDigest = extendedDigest;
        this.f19566length = i;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.baseDigest.getDigestSize()];
        this.baseDigest.mo14967doFinal(bArr2, 0);
        System.arraycopy(bArr2, 0, bArr, i, this.f19566length);
        return this.f19566length;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName() + "(" + (this.f19566length * 8) + ")";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.f19566length;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.baseDigest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        this.baseDigest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        this.baseDigest.mo14970update(bArr, i, i2);
    }
}
