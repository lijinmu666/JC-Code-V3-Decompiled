package p132okio;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m4988d2 = {"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", BuildConfig.f24315FLAVOR, "buffer", "Lokio/Buffer;", "final", BuildConfig.f24315FLAVOR, "closed", "read", BuildConfig.f24315FLAVOR, "sink", "byteCount", "refill", BuildConfig.f24315FLAVOR, "update", "doFinal", "timeout", "Lokio/Timeout;", "close", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCipherSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CipherSource.kt\nokio/CipherSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
/* loaded from: classes.dex */
public final class CipherSource implements InterfaceC5062Source {
    private final int blockSize;
    private final C5052Buffer buffer;
    private final Cipher cipher;
    private boolean closed;
    private boolean final;
    private final BufferedSource source;

    public CipherSource(BufferedSource source, Cipher cipher) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new C5052Buffer();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    /* renamed from: doFinal */
    private final void m14262doFinal() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        C5059Segment c5059SegmentWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int iDoFinal = this.cipher.doFinal(c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.pos);
        c5059SegmentWritableSegment$okio.limit += iDoFinal;
        C5052Buffer c5052Buffer = this.buffer;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + iDoFinal);
        if (c5059SegmentWritableSegment$okio.pos == c5059SegmentWritableSegment$okio.limit) {
            this.buffer.head = c5059SegmentWritableSegment$okio.m14380pop();
            SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
        }
    }

    /* renamed from: refill */
    private final void m14263refill() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        while (this.buffer.m14225size() == 0 && !this.final) {
            if (this.source.exhausted()) {
                this.final = true;
                m14262doFinal();
                return;
            }
            m14264update();
        }
    }

    /* renamed from: update */
    private final void m14264update() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        C5059Segment c5059Segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.limit - c5059Segment.pos;
        int outputSize = this.cipher.getOutputSize(i);
        while (outputSize > 8192) {
            int i2 = this.blockSize;
            if (i <= i2) {
                this.final = true;
                C5052Buffer c5052Buffer = this.buffer;
                byte[] bArrDoFinal = this.cipher.doFinal(this.source.readByteArray());
                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                c5052Buffer.mo14230write(bArrDoFinal);
                return;
            }
            i -= i2;
            outputSize = this.cipher.getOutputSize(i);
        }
        C5059Segment c5059SegmentWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int iUpdate = this.cipher.update(c5059Segment.data, c5059Segment.pos, i, c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.pos);
        this.source.mo14226skip(i);
        c5059SegmentWritableSegment$okio.limit += iUpdate;
        C5052Buffer c5052Buffer2 = this.buffer;
        c5052Buffer2.setSize$okio(c5052Buffer2.m14225size() + iUpdate);
        if (c5059SegmentWritableSegment$okio.pos == c5059SegmentWritableSegment$okio.limit) {
            this.buffer.head = c5059SegmentWritableSegment$okio.m14380pop();
            SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
        }
    }

    @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: read */
    public long mo2305read(C5052Buffer sink, long byteCount) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (byteCount == 0) {
            return 0L;
        }
        m14263refill();
        return this.buffer.mo2305read(sink, byteCount);
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return this.source.getTimeout();
    }
}
