package p132okio;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m4988d2 = {"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "<init>", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "expectedSegment", "Lokio/Segment;", "expectedPos", BuildConfig.f24315FLAVOR, "closed", BuildConfig.f24315FLAVOR, "pos", BuildConfig.f24315FLAVOR, "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "close", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nPeekSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeekSource.kt\nokio/PeekSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
/* loaded from: classes.dex */
public final class PeekSource implements InterfaceC5062Source {
    private final C5052Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private C5059Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        C5052Buffer buffer = upstream.getBuffer();
        this.buffer = buffer;
        C5059Segment c5059Segment = buffer.head;
        this.expectedSegment = c5059Segment;
        this.expectedPos = c5059Segment != null ? c5059Segment.pos : -1;
    }

    @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r4.pos) goto L15;
     */
    @Override // p132okio.InterfaceC5062Source
    /* renamed from: read */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo2305read(C5052Buffer sink, long byteCount) {
        C5059Segment c5059Segment;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        C5059Segment c5059Segment2 = this.expectedSegment;
        if (c5059Segment2 != null) {
            C5059Segment c5059Segment3 = this.buffer.head;
            if (c5059Segment2 == c5059Segment3) {
                int i = this.expectedPos;
                Intrinsics.checkNotNull(c5059Segment3);
            }
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (!this.upstream.mo14218request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && (c5059Segment = this.buffer.head) != null) {
            this.expectedSegment = c5059Segment;
            Intrinsics.checkNotNull(c5059Segment);
            this.expectedPos = c5059Segment.pos;
        }
        long jMin = Math.min(byteCount, this.buffer.m14225size() - this.pos);
        this.buffer.m14202copyTo(sink, this.pos, jMin);
        this.pos += jMin;
        return jMin;
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return this.upstream.getTimeout();
    }
}
