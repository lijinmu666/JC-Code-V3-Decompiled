package org.bouncycastle.p361util.p362io;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class TeeOutputStream extends OutputStream {

    /* renamed from: output1 */
    private OutputStream f24247output1;

    /* renamed from: output2 */
    private OutputStream f24248output2;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this.f24247output1 = outputStream;
        this.f24248output2 = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24247output1.close();
        this.f24248output2.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f24247output1.flush();
        this.f24248output2.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f24247output1.write(i);
        this.f24248output2.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f24247output1.write(bArr);
        this.f24248output2.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f24247output1.write(bArr, i, i2);
        this.f24248output2.write(bArr, i, i2);
    }
}
