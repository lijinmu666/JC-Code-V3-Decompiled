package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

/* loaded from: classes2.dex */
class SIG_FORS {
    final byte[][] authPath;

    /* renamed from: sk */
    final byte[] f24090sk;

    public SIG_FORS(byte[] bArr, byte[][] bArr2) {
        this.authPath = bArr2;
        this.f24090sk = bArr;
    }

    public byte[][] getAuthPath() {
        return this.authPath;
    }

    /* renamed from: getSK */
    public byte[] m18156getSK() {
        return this.f24090sk;
    }
}
