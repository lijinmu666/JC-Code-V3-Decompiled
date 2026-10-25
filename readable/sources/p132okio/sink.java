package p132okio;

import java.io.IOException;
import java.io.OutputStream;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m4988d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "flush", "close", "toString", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,234:1\n87#2:235\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n*L\n56#1:235\n*E\n"})
/* renamed from: okio.OutputStreamSink, reason: from toString */
/* loaded from: classes.dex */
final class sink implements InterfaceC5060Sink {
    private final OutputStream out;
    private final C5065Timeout timeout;

    public sink(OutputStream out, C5065Timeout timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: timeout, reason: from getter */
    public C5065Timeout getTimeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, byteCount);
        while (byteCount > 0) {
            this.timeout.throwIfReached();
            C5059Segment c5059Segment = source.head;
            Intrinsics.checkNotNull(c5059Segment);
            int iMin = (int) Math.min(byteCount, c5059Segment.limit - c5059Segment.pos);
            this.out.write(c5059Segment.data, c5059Segment.pos, iMin);
            c5059Segment.pos += iMin;
            long j = iMin;
            byteCount -= j;
            source.setSize$okio(source.m14225size() - j);
            if (c5059Segment.pos == c5059Segment.limit) {
                source.head = c5059Segment.m14380pop();
                SegmentPool.m14384recycle(c5059Segment);
            }
        }
    }
}
