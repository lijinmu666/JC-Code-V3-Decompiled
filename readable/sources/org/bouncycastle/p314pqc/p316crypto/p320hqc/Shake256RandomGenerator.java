package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;

/* loaded from: classes2.dex */
class Shake256RandomGenerator {

    /* renamed from: digest */
    private final SHAKEDigest f23212digest;

    public Shake256RandomGenerator(byte[] bArr, byte b) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        this.f23212digest = sHAKEDigest;
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        sHAKEDigest.mo14969update(b);
    }

    /* renamed from: init */
    public void m17597init(byte[] bArr, int i, int i2, byte b) {
        this.f23212digest.mo14968reset();
        this.f23212digest.mo14970update(bArr, i, i2);
        this.f23212digest.mo14969update(b);
    }

    public void nextBytes(byte[] bArr) {
        this.f23212digest.doOutput(bArr, 0, bArr.length);
    }

    public void xofGetBytes(byte[] bArr, int i) {
        int i2 = i & 7;
        int i3 = i - i2;
        this.f23212digest.doOutput(bArr, 0, i3);
        if (i2 != 0) {
            byte[] bArr2 = new byte[8];
            this.f23212digest.doOutput(bArr2, 0, 8);
            System.arraycopy(bArr2, 0, bArr, i3, i2);
        }
    }

    public Shake256RandomGenerator(byte[] bArr, int i, int i2, byte b) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        this.f23212digest = sHAKEDigest;
        sHAKEDigest.mo14970update(bArr, i, i2);
        sHAKEDigest.mo14969update(b);
    }

    public void nextBytes(byte[] bArr, int i, int i2) {
        this.f23212digest.doOutput(bArr, i, i2);
    }
}
