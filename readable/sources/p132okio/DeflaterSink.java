package p132okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.internal._ZlibJvmKt;

@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0016J\r\u0010\u0014\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m4988d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "deflater", "Ljava/util/zip/Deflater;", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "closed", BuildConfig.f24315FLAVOR, "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "deflate", "syncFlush", "flush", "finishDeflate", "finishDeflate$okio", "close", "timeout", "Lokio/Timeout;", "toString", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDeflaterSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeflaterSink.kt\nokio/DeflaterSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,144:1\n87#2:145\n*S KotlinDebug\n*F\n+ 1 DeflaterSink.kt\nokio/DeflaterSink\n*L\n39#1:145\n*E\n"})
/* loaded from: classes.dex */
public final class DeflaterSink implements InterfaceC5060Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* renamed from: deflate */
    private final void m14265deflate(boolean syncFlush) throws IOException {
        C5059Segment c5059SegmentWritableSegment$okio;
        int iDeflate;
        C5052Buffer buffer = this.sink.getBuffer();
        while (true) {
            c5059SegmentWritableSegment$okio = buffer.writableSegment$okio(1);
            String strDeflate = "Deflater already closed";
            if (syncFlush) {
                try {
                    Deflater deflater = this.deflater;
                    byte[] bArr = c5059SegmentWritableSegment$okio.data;
                    int i = c5059SegmentWritableSegment$okio.limit;
                    strDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                    iDeflate = strDeflate;
                } catch (IllegalStateException e) {
                    throw new IOException(strDeflate, e);
                } catch (NullPointerException e2) {
                    throw new IOException(strDeflate, e2);
                }
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = c5059SegmentWritableSegment$okio.data;
                int i2 = c5059SegmentWritableSegment$okio.limit;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                c5059SegmentWritableSegment$okio.limit += iDeflate;
                buffer.setSize$okio(buffer.m14225size() + iDeflate);
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (c5059SegmentWritableSegment$okio.pos == c5059SegmentWritableSegment$okio.limit) {
            buffer.head = c5059SegmentWritableSegment$okio.m14380pop();
            SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
        }
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            finishDeflate$okio();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() throws IOException {
        this.deflater.finish();
        m14265deflate(false);
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
    public void flush() throws IOException {
        m14265deflate(true);
        this.sink.flush();
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: timeout */
    public C5065Timeout getF17772this$0() {
        return this.sink.getF17772this$0();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, byteCount);
        while (byteCount > 0) {
            C5059Segment c5059Segment = source.head;
            Intrinsics.checkNotNull(c5059Segment);
            int iMin = (int) Math.min(byteCount, c5059Segment.limit - c5059Segment.pos);
            this.deflater.setInput(c5059Segment.data, c5059Segment.pos, iMin);
            m14265deflate(false);
            long j = iMin;
            source.setSize$okio(source.m14225size() - j);
            int i = c5059Segment.pos + iMin;
            c5059Segment.pos = i;
            if (i == c5059Segment.limit) {
                source.head = c5059Segment.m14380pop();
                SegmentPool.m14384recycle(c5059Segment);
            }
            byteCount -= j;
        }
        this.deflater.setInput(_ZlibJvmKt.getEMPTY_BYTE_ARRAY(), 0, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(InterfaceC5060Sink sink, Deflater deflater) {
        this(C5053Okio.m14315buffer(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }
}
