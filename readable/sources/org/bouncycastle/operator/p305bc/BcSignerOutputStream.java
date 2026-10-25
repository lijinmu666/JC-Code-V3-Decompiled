package org.bouncycastle.operator.p305bc;

import java.io.OutputStream;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;

/* loaded from: classes2.dex */
public class BcSignerOutputStream extends OutputStream {

    /* renamed from: sig */
    private InterfaceC5282Signer f22881sig;

    public BcSignerOutputStream(InterfaceC5282Signer interfaceC5282Signer) {
        this.f22881sig = interfaceC5282Signer;
    }

    public byte[] getSignature() {
        return this.f22881sig.generateSignature();
    }

    /* renamed from: verify */
    public boolean m17391verify(byte[] bArr) {
        return this.f22881sig.verifySignature(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f22881sig.mo14989update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f22881sig.mo14990update(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f22881sig.mo14990update(bArr, i, i2);
    }
}
