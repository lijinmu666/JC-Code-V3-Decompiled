package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.ExtendedDigest;

/* loaded from: classes2.dex */
public class NonMemoableDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;

    public NonMemoableDigest(ExtendedDigest extendedDigest) {
        if (extendedDigest == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        }
        this.baseDigest = extendedDigest;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        return this.baseDigest.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.baseDigest.getDigestSize();
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
