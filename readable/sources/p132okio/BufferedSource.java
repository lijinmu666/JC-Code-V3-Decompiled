package p132okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;

@Metadata(m4987d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\fH&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH&J'\u0010\u001d\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020!2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\"H&¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H&J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%H&J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020%H&J \u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H&J\u0018\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010*\u001a\u00020\f2\u0006\u0010'\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\fH&J\n\u0010.\u001a\u0004\u0018\u00010-H&J\b\u0010/\u001a\u00020-H&J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\fH&J\b\u00101\u001a\u00020\u0014H&J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204H&J\u0018\u00102\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000fH&J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\fH&J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH&J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001cH&J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\fH&J \u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH&J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001cH&J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\fH&J\u0018\u0010<\u001a\u00020\b2\u0006\u0010)\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001cH&J(\u0010<\u001a\u00020\b2\u0006\u0010)\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014H&J\b\u0010>\u001a\u00020\u0000H&J\b\u0010?\u001a\u00020@H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0004Aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006BÀ\u0006\u0001"}, m4988d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "exhausted", BuildConfig.f24315FLAVOR, "require", BuildConfig.f24315FLAVOR, "byteCount", BuildConfig.f24315FLAVOR, "request", "readByte", BuildConfig.f24315FLAVOR, "readShort", BuildConfig.f24315FLAVOR, "readShortLe", "readInt", BuildConfig.f24315FLAVOR, "readIntLe", "readLong", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "readByteString", "Lokio/ByteString;", "select", "options", "Lokio/Options;", "T", BuildConfig.f24315FLAVOR, "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readByteArray", BuildConfig.f24315FLAVOR, "read", "sink", "readFully", "offset", "readAll", "Lokio/Sink;", "readUtf8", BuildConfig.f24315FLAVOR, "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readString", "charset", "Ljava/nio/charset/Charset;", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "peek", "inputStream", "Ljava/io/InputStream;", "Lokio/RealBufferedSource;", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface BufferedSource extends InterfaceC5062Source, ReadableByteChannel {
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", m5048imports = {}))
    /* renamed from: buffer */
    C5052Buffer getBufferField();

    boolean exhausted();

    C5052Buffer getBuffer();

    /* renamed from: indexOf */
    long mo14206indexOf(byte b);

    /* renamed from: indexOf */
    long mo14207indexOf(byte b, long fromIndex);

    /* renamed from: indexOf */
    long mo14208indexOf(byte b, long fromIndex, long toIndex);

    /* renamed from: indexOf */
    long mo14209indexOf(ByteString bytes);

    /* renamed from: indexOf */
    long mo14210indexOf(ByteString bytes, long fromIndex);

    /* renamed from: indexOf */
    long mo14211indexOf(ByteString bytes, long fromIndex, long toIndex);

    long indexOfElement(ByteString targetBytes);

    long indexOfElement(ByteString targetBytes, long fromIndex);

    InputStream inputStream();

    /* renamed from: peek */
    BufferedSource mo14213peek();

    boolean rangeEquals(long offset, ByteString bytes);

    boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount);

    /* renamed from: read */
    int mo14214read(byte[] sink);

    /* renamed from: read */
    int mo14215read(byte[] sink, int offset, int byteCount);

    /* renamed from: readAll */
    long mo14216readAll(InterfaceC5060Sink sink);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long byteCount);

    ByteString readByteString();

    ByteString readByteString(long byteCount);

    long readDecimalLong();

    void readFully(C5052Buffer sink, long byteCount);

    void readFully(byte[] sink);

    long readHexadecimalUnsignedLong();

    /* renamed from: readInt */
    int mo14217readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(long byteCount, Charset charset);

    String readString(Charset charset);

    String readUtf8();

    String readUtf8(long byteCount);

    int readUtf8CodePoint();

    String readUtf8Line();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long limit);

    /* renamed from: request */
    boolean mo14218request(long byteCount);

    /* renamed from: require */
    void mo14219require(long byteCount);

    /* renamed from: select */
    int mo14220select(C5054Options options);

    /* renamed from: select */
    <T> T mo14221select(TypedOptions<T> options);

    /* renamed from: skip */
    void mo14226skip(long byteCount);
}
