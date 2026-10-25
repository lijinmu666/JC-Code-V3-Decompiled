package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

/* loaded from: classes2.dex */
class SIG_XMSS {

    /* renamed from: auth */
    final byte[][] f21075auth;

    /* renamed from: sig */
    final byte[] f21076sig;

    public SIG_XMSS(byte[] bArr, byte[][] bArr2) {
        this.f21076sig = bArr;
        this.f21075auth = bArr2;
    }

    public byte[] getWOTSSig() {
        return this.f21076sig;
    }

    public byte[][] getXMSSAUTH() {
        return this.f21075auth;
    }
}
