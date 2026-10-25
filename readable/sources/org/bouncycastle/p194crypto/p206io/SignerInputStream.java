package org.bouncycastle.p194crypto.p206io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;

/* loaded from: classes2.dex */
public class SignerInputStream extends FilterInputStream {

    /* renamed from: signer */
    protected InterfaceC5282Signer f20363signer;

    public SignerInputStream(InputStream inputStream, InterfaceC5282Signer interfaceC5282Signer) {
        super(inputStream);
        this.f20363signer = interfaceC5282Signer;
    }

    public InterfaceC5282Signer getSigner() {
        return this.f20363signer;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        if (i >= 0) {
            this.f20363signer.mo14989update((byte) i);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (i3 > 0) {
            this.f20363signer.mo14990update(bArr, i, i3);
        }
        return i3;
    }
}
