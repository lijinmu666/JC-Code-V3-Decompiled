package org.bouncycastle.p191cms.p193jcajce;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.operator.InputExpander;
import org.bouncycastle.operator.InputExpanderProvider;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.p362io.StreamOverflowException;

/* loaded from: classes2.dex */
public class ZlibExpanderProvider implements InputExpanderProvider {

    /* renamed from: limit */
    private final long f19112limit;

    public static class LimitedInputStream extends FilterInputStream {
        private long remaining;

        public LimitedInputStream(InputStream inputStream, long j) {
            super(inputStream);
            this.remaining = j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            if (r4 >= 0) goto L8;
         */
        @Override // java.io.FilterInputStream, java.io.InputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int read() throws IOException {
            if (this.remaining >= 0) {
                int i = ((FilterInputStream) this).in.read();
                if (i >= 0) {
                    long j = this.remaining - 1;
                    this.remaining = j;
                }
                return i;
            }
            throw new StreamOverflowException("expanded byte limit exceeded");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (i2 < 1) {
                return super.read(bArr, i, i2);
            }
            long j = this.remaining;
            if (j < 1) {
                read();
                return -1;
            }
            if (j <= i2) {
                i2 = (int) j;
            }
            int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (i3 > 0) {
                this.remaining -= i3;
            }
            return i3;
        }
    }

    public ZlibExpanderProvider() {
        this.f19112limit = -1L;
    }

    @Override // org.bouncycastle.operator.InputExpanderProvider
    /* renamed from: get */
    public InputExpander mo14942get(final AlgorithmIdentifier algorithmIdentifier) {
        return new InputExpander(this) { // from class: org.bouncycastle.cms.jcajce.ZlibExpanderProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ ZlibExpanderProvider f19113this$0;

            {
                this.f19113this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputExpander
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier;
            }

            @Override // org.bouncycastle.operator.InputExpander
            public InputStream getInputStream(InputStream inputStream) {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
                return this.f19113this$0.f19112limit >= 0 ? new LimitedInputStream(inflaterInputStream, this.f19113this$0.f19112limit) : inflaterInputStream;
            }
        };
    }

    public ZlibExpanderProvider(long j) {
        this.f19112limit = j;
    }
}
