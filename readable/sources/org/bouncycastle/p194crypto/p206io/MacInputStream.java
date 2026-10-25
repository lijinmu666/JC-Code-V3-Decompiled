package org.bouncycastle.p194crypto.p206io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;

/* loaded from: classes2.dex */
public class MacInputStream extends FilterInputStream {

    /* renamed from: mac */
    protected InterfaceC5278Mac f20361mac;

    public MacInputStream(InputStream inputStream, InterfaceC5278Mac interfaceC5278Mac) {
        super(inputStream);
        this.f20361mac = interfaceC5278Mac;
    }

    /* renamed from: getMac */
    public InterfaceC5278Mac m15554getMac() {
        return this.f20361mac;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        if (i >= 0) {
            this.f20361mac.mo14978update((byte) i);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (i3 >= 0) {
            this.f20361mac.mo14979update(bArr, i, i3);
        }
        return i3;
    }
}
