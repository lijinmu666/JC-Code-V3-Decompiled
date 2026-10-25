package org.bouncycastle.operator;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MacCaptureStream extends OutputStream {

    /* renamed from: cOut */
    private final OutputStream f22860cOut;

    /* renamed from: mac */
    private final byte[] f22861mac;
    int macIndex = 0;

    public MacCaptureStream(OutputStream outputStream, int i) {
        this.f22860cOut = outputStream;
        this.f22861mac = new byte[i];
    }

    /* renamed from: getMac */
    public byte[] m17386getMac() {
        return C6238Arrays.m18231clone(this.f22861mac);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        int i2 = this.macIndex;
        byte[] bArr = this.f22861mac;
        if (i2 != bArr.length) {
            this.macIndex = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        byte b = bArr[0];
        System.arraycopy(bArr, 1, bArr, 0, bArr.length - 1);
        byte[] bArr2 = this.f22861mac;
        bArr2[bArr2.length - 1] = (byte) i;
        this.f22860cOut.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.f22861mac;
        if (i2 < bArr2.length) {
            for (int i3 = 0; i3 != i2; i3++) {
                write(bArr[i + i3]);
            }
        } else {
            this.f22860cOut.write(bArr2, 0, this.macIndex);
            byte[] bArr3 = this.f22861mac;
            this.macIndex = bArr3.length;
            System.arraycopy(bArr, (i + i2) - bArr3.length, bArr3, 0, bArr3.length);
            this.f22860cOut.write(bArr, i, i2 - this.f22861mac.length);
        }
    }
}
