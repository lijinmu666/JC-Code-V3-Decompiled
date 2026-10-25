package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

/* loaded from: classes2.dex */
class SIG_XMSS {

    /* renamed from: auth */
    final byte[][] f24091auth;

    /* renamed from: sig */
    final byte[] f24092sig;

    public SIG_XMSS(byte[] bArr, byte[][] bArr2) {
        this.f24092sig = bArr;
        this.f24091auth = bArr2;
    }

    public byte[] getWOTSSig() {
        return this.f24092sig;
    }

    public byte[][] getXMSSAUTH() {
        return this.f24091auth;
    }
}
