package org.bouncycastle.p361util.p362io;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public class LimitedBuffer extends OutputStream {

    /* renamed from: buf */
    private final byte[] f24243buf;

    /* renamed from: count */
    private int f24244count = 0;

    public LimitedBuffer(int i) {
        this.f24243buf = new byte[i];
    }

    /* renamed from: copyTo */
    public int m18356copyTo(byte[] bArr, int i) {
        System.arraycopy(this.f24243buf, 0, bArr, i, this.f24244count);
        return this.f24244count;
    }

    /* renamed from: limit */
    public int m18357limit() {
        return this.f24243buf.length;
    }

    /* renamed from: reset */
    public void m18358reset() {
        this.f24244count = 0;
    }

    /* renamed from: size */
    public int m18359size() {
        return this.f24244count;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f24243buf;
        int i2 = this.f24244count;
        this.f24244count = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        System.arraycopy(bArr, 0, this.f24243buf, this.f24244count, bArr.length);
        this.f24244count += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.f24243buf, this.f24244count, i2);
        this.f24244count += i2;
    }
}
