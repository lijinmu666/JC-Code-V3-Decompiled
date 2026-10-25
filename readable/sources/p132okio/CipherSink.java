package p132okio;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m4988d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", BuildConfig.f24315FLAVOR, "closed", BuildConfig.f24315FLAVOR, "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "update", "remaining", "flush", "timeout", "Lokio/Timeout;", "close", "doFinal", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCipherSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CipherSink.kt\nokio/CipherSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,148:1\n1#2:149\n87#3:150\n*S KotlinDebug\n*F\n+ 1 CipherSink.kt\nokio/CipherSink\n*L\n47#1:150\n*E\n"})
/* loaded from: classes.dex */
public final class CipherSink implements InterfaceC5060Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink sink, Cipher cipher) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.sink = sink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    /* renamed from: doFinal */
    private final Throwable m14260doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                BufferedSink bufferedSink = this.sink;
                byte[] bArrDoFinal = this.cipher.doFinal();
                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                bufferedSink.mo14230write(bArrDoFinal);
                return null;
            } catch (Throwable th2) {
                return th2;
            }
        }
        C5052Buffer buffer = this.sink.getBuffer();
        C5059Segment c5059SegmentWritableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int iDoFinal = this.cipher.doFinal(c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit);
            c5059SegmentWritableSegment$okio.limit += iDoFinal;
            buffer.setSize$okio(buffer.m14225size() + iDoFinal);
        } catch (Throwable th3) {
            th = th3;
        }
        if (c5059SegmentWritableSegment$okio.pos == c5059SegmentWritableSegment$okio.limit) {
            buffer.head = c5059SegmentWritableSegment$okio.m14380pop();
            SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
        }
        return th;
    }

    /* renamed from: update */
    private final int m14261update(C5052Buffer source, long remaining) throws ShortBufferException {
        C5059Segment c5059Segment = source.head;
        Intrinsics.checkNotNull(c5059Segment);
        int iMin = (int) Math.min(remaining, c5059Segment.limit - c5059Segment.pos);
        C5052Buffer buffer = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(iMin);
        while (outputSize > 8192) {
            int i = this.blockSize;
            if (iMin <= i) {
                BufferedSink bufferedSink = this.sink;
                byte[] bArrUpdate = this.cipher.update(source.readByteArray(remaining));
                Intrinsics.checkNotNullExpressionValue(bArrUpdate, "update(...)");
                bufferedSink.mo14230write(bArrUpdate);
                return (int) remaining;
            }
            iMin -= i;
            outputSize = this.cipher.getOutputSize(iMin);
        }
        C5059Segment c5059SegmentWritableSegment$okio = buffer.writableSegment$okio(outputSize);
        int iUpdate = this.cipher.update(c5059Segment.data, c5059Segment.pos, iMin, c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit);
        c5059SegmentWritableSegment$okio.limit += iUpdate;
        buffer.setSize$okio(buffer.m14225size() + iUpdate);
        if (c5059SegmentWritableSegment$okio.pos == c5059SegmentWritableSegment$okio.limit) {
            buffer.head = c5059SegmentWritableSegment$okio.m14380pop();
            SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
        }
        this.sink.emitCompleteSegments();
        source.setSize$okio(source.m14225size() - iMin);
        int i2 = c5059Segment.pos + iMin;
        c5059Segment.pos = i2;
        if (i2 == c5059Segment.limit) {
            source.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        }
        return iMin;
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        this.closed = true;
        Throwable thM14260doFinal = m14260doFinal();
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (thM14260doFinal == null) {
                thM14260doFinal = th;
            }
        }
        if (thM14260doFinal != null) {
            throw thM14260doFinal;
        }
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return this.sink.getTimeout();
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, byteCount);
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (byteCount > 0) {
            byteCount -= m14261update(source, byteCount);
        }
    }
}
