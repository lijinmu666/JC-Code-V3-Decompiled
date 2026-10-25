package org.bouncycastle.p226est;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class CTEChunkedInputStream extends InputStream {
    int chunkLen = 0;

    /* renamed from: src */
    private InputStream f21175src;

    public CTEChunkedInputStream(InputStream inputStream) {
        this.f21175src = inputStream;
    }

    /* renamed from: readEOL */
    private String m15957readEOL() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = this.f21175src.read();
            if (i != -1) {
                byteArrayOutputStream.write(i & 255);
                if (i == 10) {
                    break;
                }
            } else if (byteArrayOutputStream.size() == 0) {
                return null;
            }
        }
        return byteArrayOutputStream.toString().trim();
    }

    @Override // java.io.InputStream
    public int read() throws IOException, NumberFormatException {
        String strM15957readEOL;
        int i = this.chunkLen;
        if (i == Integer.MIN_VALUE) {
            return -1;
        }
        if (i == 0) {
            do {
                strM15957readEOL = m15957readEOL();
                if (strM15957readEOL == null) {
                    break;
                }
            } while (strM15957readEOL.length() == 0);
            if (strM15957readEOL == null) {
                return -1;
            }
            int i2 = Integer.parseInt(strM15957readEOL.trim(), 16);
            this.chunkLen = i2;
            if (i2 == 0) {
                m15957readEOL();
                this.chunkLen = Integer.MIN_VALUE;
                return -1;
            }
        }
        this.chunkLen--;
        return this.f21175src.read();
    }
}
