package org.bouncycastle.p194crypto.p206io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
public class DigestInputStream extends FilterInputStream {

    /* renamed from: digest */
    protected InterfaceC5277Digest f20359digest;

    public DigestInputStream(InputStream inputStream, InterfaceC5277Digest interfaceC5277Digest) {
        super(inputStream);
        this.f20359digest = interfaceC5277Digest;
    }

    public InterfaceC5277Digest getDigest() {
        return this.f20359digest;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        if (i >= 0) {
            this.f20359digest.mo14969update((byte) i);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (i3 > 0) {
            this.f20359digest.mo14970update(bArr, i, i3);
        }
        return i3;
    }
}
