package org.conscrypt;

import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
final class OpenSSLBIOSink {

    /* renamed from: buffer */
    private final ByteArrayOutputStream f24395buffer;

    /* renamed from: ctx */
    private final long f24396ctx;
    private int position;

    private OpenSSLBIOSink(ByteArrayOutputStream byteArrayOutputStream) {
        this.f24396ctx = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        this.f24395buffer = byteArrayOutputStream;
    }

    /* renamed from: create */
    public static OpenSSLBIOSink m18468create() {
        return new OpenSSLBIOSink(new ByteArrayOutputStream());
    }

    public int available() {
        return this.f24395buffer.size() - this.position;
    }

    public void finalize() throws Throwable {
        try {
            NativeCrypto.BIO_free_all(this.f24396ctx);
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.f24396ctx;
    }

    public int position() {
        return this.position;
    }

    /* renamed from: reset */
    public void m18469reset() {
        this.f24395buffer.reset();
        this.position = 0;
    }

    /* renamed from: skip */
    public long m18470skip(long j) {
        int iMin = Math.min(available(), (int) j);
        int i = this.position + iMin;
        this.position = i;
        if (i == this.f24395buffer.size()) {
            m18469reset();
        }
        return iMin;
    }

    public byte[] toByteArray() {
        return this.f24395buffer.toByteArray();
    }
}
