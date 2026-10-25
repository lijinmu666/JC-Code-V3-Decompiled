package p132okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.internal._ZlibJvmKt;

@Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0013\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b \u0010\tR\u000e\u0010\u0002\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\u00060\u0007j\u0002`\b8\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006!"}, m4988d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lokio/RealBufferedSink;", "deflater", "Ljava/util/zip/Deflater;", "Lokio/Deflater;", "()Ljava/util/zip/Deflater;", "Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "closed", BuildConfig.f24315FLAVOR, "crc", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "Ljava/util/zip/CRC32;", "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "flush", "timeout", "Lokio/Timeout;", "close", "writeFooter", "updateCrc", "buffer", "-deprecated_deflater", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nGzipSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n+ 2 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,152:1\n51#2:153\n1#3:154\n87#4:155\n*S KotlinDebug\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n*L\n62#1:153\n130#1:155\n*E\n"})
/* loaded from: classes.dex */
public final class GzipSink implements InterfaceC5060Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final buffer sink;

    public GzipSink(InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        buffer bufferVar = new buffer(sink);
        this.sink = bufferVar;
        Deflater deflater = new Deflater(_ZlibJvmKt.getDEFAULT_COMPRESSION(), true);
        this.deflater = deflater;
        this.deflaterSink = new DeflaterSink((BufferedSink) bufferVar, deflater);
        this.crc = new CRC32();
        C5052Buffer c5052Buffer = bufferVar.bufferField;
        c5052Buffer.writeShort(8075);
        c5052Buffer.writeByte(8);
        c5052Buffer.writeByte(0);
        c5052Buffer.writeInt(0);
        c5052Buffer.writeByte(0);
        c5052Buffer.writeByte(0);
    }

    private final void updateCrc(C5052Buffer buffer, long byteCount) {
        C5059Segment c5059Segment = buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        while (byteCount > 0) {
            int iMin = (int) Math.min(byteCount, c5059Segment.limit - c5059Segment.pos);
            this.crc.update(c5059Segment.data, c5059Segment.pos, iMin);
            byteCount -= iMin;
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_deflater")
    /* renamed from: -deprecated_deflater, reason: not valid java name and from getter */
    public final Deflater getDeflater() {
        return this.deflater;
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            this.deflaterSink.finishDeflate$okio();
            writeFooter();
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

    @InterfaceC1231JvmName(m6260name = "deflater")
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: timeout */
    public C5065Timeout getF17772this$0() {
        return this.sink.getF17772this$0();
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return;
        }
        updateCrc(source, byteCount);
        this.deflaterSink.mo2303write(source, byteCount);
    }
}
