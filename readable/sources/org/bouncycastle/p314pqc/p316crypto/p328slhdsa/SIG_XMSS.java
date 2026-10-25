package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

/* loaded from: classes2.dex */
class SIG_XMSS {

    /* renamed from: auth */
    final byte[][] f23489auth;

    /* renamed from: sig */
    final byte[] f23490sig;

    public SIG_XMSS(byte[] bArr, byte[][] bArr2) {
        this.f23490sig = bArr;
        this.f23489auth = bArr2;
    }

    public byte[] getWOTSSig() {
        return this.f23490sig;
    }

    public byte[][] getXMSSAUTH() {
        return this.f23489auth;
    }
}
