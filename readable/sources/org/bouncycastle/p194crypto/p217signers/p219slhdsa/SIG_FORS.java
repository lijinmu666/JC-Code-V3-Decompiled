package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

/* loaded from: classes2.dex */
class SIG_FORS {
    final byte[][] authPath;

    /* renamed from: sk */
    final byte[] f21074sk;

    public SIG_FORS(byte[] bArr, byte[][] bArr2) {
        this.authPath = bArr2;
        this.f21074sk = bArr;
    }

    public byte[][] getAuthPath() {
        return this.authPath;
    }

    /* renamed from: getSK */
    public byte[] m15886getSK() {
        return this.f21074sk;
    }
}
