package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
class SeedDerive {

    /* renamed from: I */
    private final byte[] f23267I;

    /* renamed from: digest */
    private final InterfaceC5277Digest f23268digest;

    /* renamed from: j */
    private int f23269j;
    private final byte[] masterSeed;

    /* renamed from: q */
    private int f23270q;

    public SeedDerive(byte[] bArr, byte[] bArr2, InterfaceC5277Digest interfaceC5277Digest) {
        this.f23267I = bArr;
        this.masterSeed = bArr2;
        this.f23268digest = interfaceC5277Digest;
    }

    public void deriveSeed(byte[] bArr, boolean z) {
        deriveSeed(bArr, z, 0);
    }

    /* renamed from: getI */
    public byte[] m17660getI() {
        return this.f23267I;
    }

    /* renamed from: getJ */
    public int m17661getJ() {
        return this.f23269j;
    }

    public byte[] getMasterSeed() {
        return this.masterSeed;
    }

    /* renamed from: getQ */
    public int m17662getQ() {
        return this.f23270q;
    }

    /* renamed from: setJ */
    public void m17663setJ(int i) {
        this.f23269j = i;
    }

    /* renamed from: setQ */
    public void m17664setQ(int i) {
        this.f23270q = i;
    }

    public void deriveSeed(byte[] bArr, boolean z, int i) {
        deriveSeed(bArr, i);
        if (z) {
            this.f23269j++;
        }
    }

    public byte[] deriveSeed(byte[] bArr, int i) {
        if (bArr.length - i < this.f23268digest.getDigestSize()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        InterfaceC5277Digest interfaceC5277Digest = this.f23268digest;
        byte[] bArr2 = this.f23267I;
        interfaceC5277Digest.mo14970update(bArr2, 0, bArr2.length);
        this.f23268digest.mo14969update((byte) (this.f23270q >>> 24));
        this.f23268digest.mo14969update((byte) (this.f23270q >>> 16));
        this.f23268digest.mo14969update((byte) (this.f23270q >>> 8));
        this.f23268digest.mo14969update((byte) this.f23270q);
        this.f23268digest.mo14969update((byte) (this.f23269j >>> 8));
        this.f23268digest.mo14969update((byte) this.f23269j);
        this.f23268digest.mo14969update((byte) -1);
        InterfaceC5277Digest interfaceC5277Digest2 = this.f23268digest;
        byte[] bArr3 = this.masterSeed;
        interfaceC5277Digest2.mo14970update(bArr3, 0, bArr3.length);
        this.f23268digest.mo14967doFinal(bArr, i);
        return bArr;
    }
}
