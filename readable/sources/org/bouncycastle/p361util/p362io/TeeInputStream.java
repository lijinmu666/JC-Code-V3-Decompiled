package org.bouncycastle.p361util.p362io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class TeeInputStream extends InputStream {

    /* renamed from: input */
    private final InputStream f24245input;

    /* renamed from: output */
    private final OutputStream f24246output;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this.f24245input = inputStream;
        this.f24246output = outputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f24245input.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24245input.close();
        this.f24246output.close();
    }

    public OutputStream getOutputStream() {
        return this.f24246output;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f24245input.read();
        if (i >= 0) {
            this.f24246output.write(i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f24245input.read(bArr, i, i2);
        if (i3 > 0) {
            this.f24246output.write(bArr, i, i3);
        }
        return i3;
    }
}
