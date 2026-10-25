package org.bouncycastle.p194crypto.p206io;

import java.io.OutputStream;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;

/* loaded from: classes2.dex */
public class SignerOutputStream extends OutputStream {

    /* renamed from: signer */
    protected InterfaceC5282Signer f20364signer;

    public SignerOutputStream(InterfaceC5282Signer interfaceC5282Signer) {
        this.f20364signer = interfaceC5282Signer;
    }

    public InterfaceC5282Signer getSigner() {
        return this.f20364signer;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f20364signer.mo14989update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f20364signer.mo14990update(bArr, i, i2);
    }
}
