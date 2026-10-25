package org.conscrypt;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class OpenSSLBIOSource {

    /* renamed from: source */
    private OpenSSLBIOInputStream f24397source;

    private OpenSSLBIOSource(OpenSSLBIOInputStream openSSLBIOInputStream) {
        this.f24397source = openSSLBIOInputStream;
    }

    /* renamed from: release */
    private synchronized void m18471release() {
        OpenSSLBIOInputStream openSSLBIOInputStream = this.f24397source;
        if (openSSLBIOInputStream != null) {
            NativeCrypto.BIO_free_all(openSSLBIOInputStream.getBioContext());
            this.f24397source = null;
        }
    }

    /* renamed from: wrap */
    public static OpenSSLBIOSource m18472wrap(ByteBuffer byteBuffer) {
        return new OpenSSLBIOSource(new OpenSSLBIOInputStream(new ByteBufferInputStream(byteBuffer), false));
    }

    public void finalize() throws Throwable {
        try {
            m18471release();
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.f24397source.getBioContext();
    }

    public static class ByteBufferInputStream extends InputStream {

        /* renamed from: source */
        private final ByteBuffer f24398source;

        public ByteBufferInputStream(ByteBuffer byteBuffer) {
            this.f24398source = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f24398source.limit() - this.f24398source.position();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f24398source.remaining() > 0) {
                return this.f24398source.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f24398source.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            long jPosition = this.f24398source.position();
            this.f24398source.position((int) (j + jPosition));
            return this.f24398source.position() - jPosition;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            int iPosition = this.f24398source.position();
            this.f24398source.get(bArr);
            return this.f24398source.position() - iPosition;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int iMin = Math.min(this.f24398source.remaining(), i2);
            int iPosition = this.f24398source.position();
            this.f24398source.get(bArr, i, iMin);
            return this.f24398source.position() - iPosition;
        }
    }
}
