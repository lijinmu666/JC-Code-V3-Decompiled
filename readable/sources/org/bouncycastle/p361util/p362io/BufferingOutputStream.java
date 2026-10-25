package org.bouncycastle.p361util.p362io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BufferingOutputStream extends OutputStream {

    /* renamed from: buf */
    private final byte[] f24240buf;

    /* renamed from: bufOff */
    private int f24241bufOff;

    /* renamed from: other */
    private final OutputStream f24242other;

    public BufferingOutputStream(OutputStream outputStream) {
        this.f24242other = outputStream;
        this.f24240buf = new byte[4096];
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.f24242other.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f24242other.write(this.f24240buf, 0, this.f24241bufOff);
        this.f24241bufOff = 0;
        C6238Arrays.m18249fill(this.f24240buf, (byte) 0);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f24240buf;
        int i2 = this.f24241bufOff;
        int i3 = i2 + 1;
        this.f24241bufOff = i3;
        bArr[i2] = (byte) i;
        if (i3 == bArr.length) {
            flush();
        }
    }

    public BufferingOutputStream(OutputStream outputStream, int i) {
        this.f24242other = outputStream;
        this.f24240buf = new byte[i];
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        byte[] bArr3 = this.f24240buf;
        int length = bArr3.length;
        int i3 = this.f24241bufOff;
        if (i2 < length - i3) {
            System.arraycopy(bArr, i, bArr3, i3, i2);
        } else {
            int length2 = bArr3.length - i3;
            System.arraycopy(bArr, i, bArr3, i3, length2);
            this.f24241bufOff += length2;
            flush();
            int length3 = i + length2;
            i2 -= length2;
            while (true) {
                bArr2 = this.f24240buf;
                if (i2 < bArr2.length) {
                    break;
                }
                this.f24242other.write(bArr, length3, bArr2.length);
                byte[] bArr4 = this.f24240buf;
                length3 += bArr4.length;
                i2 -= bArr4.length;
            }
            if (i2 <= 0) {
                return;
            } else {
                System.arraycopy(bArr, length3, bArr2, this.f24241bufOff, i2);
            }
        }
        this.f24241bufOff += i2;
    }
}
