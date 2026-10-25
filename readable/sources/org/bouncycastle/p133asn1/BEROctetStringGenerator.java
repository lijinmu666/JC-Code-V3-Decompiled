package org.bouncycastle.p133asn1;

import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BEROctetStringGenerator extends BERGenerator {

    public class BufferedBEROctetStream extends OutputStream {
        private ASN1OutputStream _asn1Out;

        /* renamed from: _buf */
        private byte[] f17965_buf;

        /* renamed from: _off */
        private int f17966_off = 0;

        public BufferedBEROctetStream(byte[] bArr) {
            this.f17965_buf = bArr;
            this._asn1Out = ASN1OutputStream.m14438create(BEROctetStringGenerator.this.f17911_out);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i = this.f17966_off;
            if (i != 0) {
                DEROctetString.m14471encode(this._asn1Out, true, this.f17965_buf, 0, i);
            }
            this._asn1Out.flushInternal();
            BEROctetStringGenerator.this.writeBEREnd();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            byte[] bArr = this.f17965_buf;
            int i2 = this.f17966_off;
            int i3 = i2 + 1;
            this.f17966_off = i3;
            bArr[i2] = (byte) i;
            if (i3 == bArr.length) {
                DEROctetString.m14471encode(this._asn1Out, true, bArr, 0, bArr.length);
                this.f17966_off = 0;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            byte[] bArr2 = this.f17965_buf;
            int length = bArr2.length;
            int i3 = this.f17966_off;
            int i4 = length - i3;
            if (i2 < i4) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.f17966_off += i2;
                return;
            }
            if (i3 > 0) {
                System.arraycopy(bArr, i, bArr2, i3, i4);
                DEROctetString.m14471encode(this._asn1Out, true, this.f17965_buf, 0, length);
            } else {
                i4 = 0;
            }
            while (true) {
                int i5 = i2 - i4;
                if (i5 < length) {
                    System.arraycopy(bArr, i + i4, this.f17965_buf, 0, i5);
                    this.f17966_off = i5;
                    return;
                } else {
                    DEROctetString.m14471encode(this._asn1Out, true, bArr, i + i4, length);
                    i4 += length;
                }
            }
        }
    }

    public BEROctetStringGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE]);
    }

    public BEROctetStringGenerator(OutputStream outputStream, int i, boolean z) throws IOException {
        super(outputStream, i, z);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream(byte[] bArr) {
        return new BufferedBEROctetStream(bArr);
    }
}
