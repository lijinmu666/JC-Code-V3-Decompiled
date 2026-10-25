package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

/* loaded from: classes2.dex */
class SIG_FORS {
    final byte[][] authPath;

    /* renamed from: sk */
    final byte[] f23488sk;

    public SIG_FORS(byte[] bArr, byte[][] bArr2) {
        this.authPath = bArr2;
        this.f23488sk = bArr;
    }

    public byte[][] getAuthPath() {
        return this.authPath;
    }

    /* renamed from: getSK */
    public byte[] m17824getSK() {
        return this.f23488sk;
    }
}
