package org.bouncycastle.p194crypto.p206io;

import java.io.OutputStream;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
public class DigestOutputStream extends OutputStream {

    /* renamed from: digest */
    protected InterfaceC5277Digest f20360digest;

    public DigestOutputStream(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20360digest = interfaceC5277Digest;
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.f20360digest.getDigestSize()];
        this.f20360digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f20360digest.mo14969update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f20360digest.mo14970update(bArr, i, i2);
    }
}
