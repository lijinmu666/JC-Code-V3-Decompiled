package org.bouncycastle.p226est;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p361util.encoders.C6253Base64;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class CTEBase64InputStream extends InputStream {

    /* renamed from: data */
    protected final byte[] f21166data;
    protected final OutputStream dataOutputStream;

    /* renamed from: end */
    protected boolean f21167end;

    /* renamed from: max */
    protected final Long f21168max;

    /* renamed from: rawBuf */
    protected final byte[] f21169rawBuf;

    /* renamed from: read */
    protected long f21170read;

    /* renamed from: rp */
    protected int f21171rp;

    /* renamed from: src */
    protected final InputStream f21172src;

    /* renamed from: wp */
    protected int f21173wp;

    public CTEBase64InputStream(InputStream inputStream) {
        this(inputStream, null);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21172src.close();
    }

    public int pullFromSrc() throws IOException {
        int i;
        int i2 = 0;
        do {
            Long l = this.f21168max;
            if (l != null && this.f21170read > l.longValue()) {
                return -1;
            }
            i = this.f21172src.read();
            if (i >= 33 || i == 13 || i == 10) {
                byte[] bArr = this.f21169rawBuf;
                if (i2 >= bArr.length) {
                    throw new IOException("Content Transfer Encoding, base64 line length > 1024");
                }
                bArr[i2] = (byte) i;
                this.f21170read++;
                i2++;
            } else if (i >= 0) {
                this.f21170read++;
            }
            if (i <= -1 || i2 >= this.f21169rawBuf.length) {
                break;
            }
        } while (i != 10);
        if (i2 > 0) {
            try {
                C6253Base64.m18325decode(this.f21169rawBuf, 0, i2, this.dataOutputStream);
            } catch (Exception e) {
                throw new IOException("Decode Base64 Content-Transfer-Encoding: " + e);
            }
        } else if (i == -1) {
            return -1;
        }
        return this.f21173wp;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f21171rp == this.f21173wp) {
            this.f21171rp = 0;
            this.f21173wp = 0;
            int iPullFromSrc = pullFromSrc();
            if (iPullFromSrc == -1) {
                return iPullFromSrc;
            }
        }
        byte[] bArr = this.f21166data;
        int i = this.f21171rp;
        this.f21171rp = i + 1;
        return bArr[i] & C1126UByte.MAX_VALUE;
    }

    public CTEBase64InputStream(InputStream inputStream, Long l) {
        this.f21169rawBuf = new byte[1024];
        this.f21166data = new byte[768];
        this.f21172src = inputStream;
        this.dataOutputStream = new OutputStream() { // from class: org.bouncycastle.est.CTEBase64InputStream.1
            @Override // java.io.OutputStream
            public void write(int i) {
                CTEBase64InputStream cTEBase64InputStream = CTEBase64InputStream.this;
                byte[] bArr = cTEBase64InputStream.f21166data;
                int i2 = cTEBase64InputStream.f21173wp;
                cTEBase64InputStream.f21173wp = i2 + 1;
                bArr[i2] = (byte) i;
            }
        };
        this.f21168max = l;
    }
}
