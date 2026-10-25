package p132okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;

@Metadata(m4987d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u0007\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0011H&J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bH&J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH&J(\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000bH&J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000bH&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000bH&J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000bH&J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000bH&J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0010H&J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0010H&J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0010H&J\u0010\u0010(\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0010H&J\b\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020\u0000H&J\b\u0010,\u001a\u00020\u0000H&J\b\u0010-\u001a\u00020.H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0004/ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, m4988d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "write", "byteString", "Lokio/ByteString;", "offset", BuildConfig.f24315FLAVOR, "byteCount", "source", BuildConfig.f24315FLAVOR, "writeAll", BuildConfig.f24315FLAVOR, "Lokio/Source;", "writeUtf8", "string", BuildConfig.f24315FLAVOR, "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "charset", "Ljava/nio/charset/Charset;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "flush", BuildConfig.f24315FLAVOR, "emit", "emitCompleteSegments", "outputStream", "Ljava/io/OutputStream;", "Lokio/RealBufferedSink;", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface BufferedSink extends InterfaceC5060Sink, WritableByteChannel {
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", m5048imports = {}))
    /* renamed from: buffer */
    C5052Buffer getBufferField();

    /* renamed from: emit */
    BufferedSink mo14203emit();

    BufferedSink emitCompleteSegments();

    @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
    void flush();

    C5052Buffer getBuffer();

    OutputStream outputStream();

    /* renamed from: write */
    BufferedSink mo14227write(ByteString byteString);

    /* renamed from: write */
    BufferedSink mo14228write(ByteString byteString, int offset, int byteCount);

    /* renamed from: write */
    BufferedSink mo14229write(InterfaceC5062Source source, long byteCount);

    /* renamed from: write */
    BufferedSink mo14230write(byte[] source);

    /* renamed from: write */
    BufferedSink mo14231write(byte[] source, int offset, int byteCount);

    long writeAll(InterfaceC5062Source source);

    BufferedSink writeByte(int b);

    BufferedSink writeDecimalLong(long v);

    BufferedSink writeHexadecimalUnsignedLong(long v);

    BufferedSink writeInt(int i);

    BufferedSink writeIntLe(int i);

    BufferedSink writeLong(long v);

    BufferedSink writeLongLe(long v);

    BufferedSink writeShort(int s);

    BufferedSink writeShortLe(int s);

    BufferedSink writeString(String string, int beginIndex, int endIndex, Charset charset);

    BufferedSink writeString(String string, Charset charset);

    BufferedSink writeUtf8(String string);

    BufferedSink writeUtf8(String string, int beginIndex, int endIndex);

    BufferedSink writeUtf8CodePoint(int codePoint);
}
