package org.bouncycastle.p194crypto.p221util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
class SSHBuilder {

    /* renamed from: bos */
    private final ByteArrayOutputStream f21137bos = new ByteArrayOutputStream();

    public byte[] getBytes() {
        return this.f21137bos.toByteArray();
    }

    public byte[] getPaddedBytes() {
        return getPaddedBytes(8);
    }

    /* renamed from: u32 */
    public void m15932u32(int i) {
        this.f21137bos.write((i >>> 24) & 255);
        this.f21137bos.write((i >>> 16) & 255);
        this.f21137bos.write((i >>> 8) & 255);
        this.f21137bos.write(i & 255);
    }

    public void writeBigNum(BigInteger bigInteger) throws IOException {
        writeBlock(bigInteger.toByteArray());
    }

    public void writeBlock(byte[] bArr) throws IOException {
        m15932u32(bArr.length);
        try {
            this.f21137bos.write(bArr);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void writeBytes(byte[] bArr) throws IOException {
        try {
            this.f21137bos.write(bArr);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void writeString(String str) throws IOException {
        writeBlock(C6250Strings.toByteArray(str));
    }

    public byte[] getPaddedBytes(int i) {
        int size = this.f21137bos.size() % i;
        if (size != 0) {
            int i2 = i - size;
            for (int i3 = 1; i3 <= i2; i3++) {
                this.f21137bos.write(i3);
            }
        }
        return this.f21137bos.toByteArray();
    }
}
