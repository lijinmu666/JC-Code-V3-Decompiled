package org.bouncycastle.p191cms.p193jcajce;

import java.io.OutputStream;
import javax.crypto.Cipher;

/* loaded from: classes2.dex */
class JceAADStream extends OutputStream {
    private final byte[] SINGLE_BYTE = new byte[1];

    /* renamed from: cipher */
    private Cipher f19068cipher;

    public JceAADStream(Cipher cipher) {
        this.f19068cipher = cipher;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.SINGLE_BYTE;
        bArr[0] = (byte) i;
        this.f19068cipher.updateAAD(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f19068cipher.updateAAD(bArr, i, i2);
    }
}
