package org.bouncycastle.p296mime.encoding;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p361util.encoders.Base64Encoder;

/* loaded from: classes2.dex */
public class Base64OutputStream extends FilterOutputStream {

    /* renamed from: ENCODER */
    private static final Base64Encoder f22512ENCODER = new Base64Encoder();
    private static final int INBUF_SIZE = 54;
    private static final int OUTBUF_SIZE = 74;

    /* renamed from: inBuf */
    private final byte[] f22513inBuf;

    /* renamed from: inPos */
    private int f22514inPos;

    /* renamed from: outBuf */
    private final byte[] f22515outBuf;

    public Base64OutputStream(OutputStream outputStream) {
        super(outputStream);
        this.f22513inBuf = new byte[54];
        byte[] bArr = new byte[74];
        this.f22515outBuf = bArr;
        this.f22514inPos = 0;
        bArr[72] = 13;
        bArr[73] = 10;
    }

    private void encodeBlock(byte[] bArr, int i) throws IOException {
        f22512ENCODER.m18336encode(bArr, i, 54, this.f22515outBuf, 0);
        ((FilterOutputStream) this).out.write(this.f22515outBuf, 0, 74);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i = this.f22514inPos;
        if (i > 0) {
            int iM18336encode = f22512ENCODER.m18336encode(this.f22513inBuf, 0, i, this.f22515outBuf, 0);
            this.f22514inPos = 0;
            byte[] bArr = this.f22515outBuf;
            bArr[iM18336encode] = 13;
            bArr[iM18336encode + 1] = 10;
            ((FilterOutputStream) this).out.write(bArr, 0, iM18336encode + 2);
        }
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f22513inBuf;
        int i2 = this.f22514inPos;
        int i3 = i2 + 1;
        this.f22514inPos = i3;
        bArr[i2] = (byte) i;
        if (i3 == 54) {
            encodeBlock(bArr, 0);
            this.f22514inPos = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f22514inPos;
        int i4 = 54 - i3;
        if (i2 < i4) {
            System.arraycopy(bArr, i, this.f22513inBuf, i3, i2);
            this.f22514inPos += i2;
            return;
        }
        if (i3 > 0) {
            System.arraycopy(bArr, i, this.f22513inBuf, i3, i4);
            encodeBlock(this.f22513inBuf, 0);
        } else {
            i4 = 0;
        }
        while (true) {
            int i5 = i2 - i4;
            if (i5 < 54) {
                System.arraycopy(bArr, i + i4, this.f22513inBuf, 0, i5);
                this.f22514inPos = i5;
                return;
            } else {
                encodeBlock(bArr, i + i4);
                i4 += 54;
            }
        }
    }
}
