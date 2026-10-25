package org.conscrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
class OpenSSLBIOInputStream extends FilterInputStream {

    /* renamed from: ctx */
    private long f24394ctx;

    public OpenSSLBIOInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.f24394ctx = NativeCrypto.create_BIO_InputStream(this, z);
    }

    public long getBioContext() {
        return this.f24394ctx;
    }

    /* renamed from: gets */
    public int m18466gets(byte[] bArr) {
        int i;
        int i2 = 0;
        if (bArr != null && bArr.length != 0) {
            while (i2 < bArr.length && (i = read()) != -1) {
                if (i != 10) {
                    bArr[i2] = (byte) i;
                    i2++;
                } else if (i2 != 0) {
                    break;
                }
            }
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    /* renamed from: release */
    public void m18467release() {
        NativeCrypto.BIO_free_all(this.f24394ctx);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Invalid bounds");
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        do {
            int i4 = super.read(bArr, i + i3, (i2 - i3) - i);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        } while (i + i3 < i2);
        if (i3 == 0) {
            return -1;
        }
        return i3;
    }
}
