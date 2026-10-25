package p132okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.C1302CharsKt;
import p094kotlin.p117text.Typography;
import p132okio.internal.C5067Buffer;
import p132okio.internal.RealBufferedSource;

@Metadata(m4987d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J'\u0010\u001b\u001a\u0004\u0018\u0001H\u001f\"\b\b\u0000\u0010\u001f*\u00020 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020$H\u0016J \u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u001cH\u0016J\u0010\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020'H\u0016J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010,\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010+H\u0016J\b\u00100\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0010H\u0016J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u00020\u001cH\u0016J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0018H\u0016J\u0018\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0010H\u0016J \u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001aH\u0016J\u0018\u0010=\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0010H\u0016J \u0010=\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u001aH\u0016J\u0018\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0010H\u0016J\u0018\u0010D\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001aH\u0016J(\u0010D\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u001cH\u0016J\b\u0010F\u001a\u00020\u0001H\u0016J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\tH\u0016J\b\u0010J\u001a\u00020\u0015H\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020+H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00078Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006N"}, m4988d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "bufferField", "Lokio/Buffer;", "closed", BuildConfig.f24315FLAVOR, "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "read", BuildConfig.f24315FLAVOR, "sink", "byteCount", "exhausted", "require", BuildConfig.f24315FLAVOR, "request", "readByte", BuildConfig.f24315FLAVOR, "readByteString", "Lokio/ByteString;", "select", BuildConfig.f24315FLAVOR, "options", "Lokio/Options;", "T", BuildConfig.f24315FLAVOR, "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readByteArray", BuildConfig.f24315FLAVOR, "readFully", "offset", "Ljava/nio/ByteBuffer;", "readAll", "Lokio/Sink;", "readUtf8", BuildConfig.f24315FLAVOR, "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readShort", BuildConfig.f24315FLAVOR, "readShortLe", "readInt", "readIntLe", "readLong", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "peek", "inputStream", "Ljava/io/InputStream;", "isOpen", "close", "timeout", "Lokio/Timeout;", "toString", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 2 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 BufferedSource.kt\nokio/internal/-BufferedSource\n+ 5 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,207:1\n63#1:213\n63#1:224\n63#1:231\n63#1:237\n63#1:239\n63#1:243\n63#1:248\n63#1:266\n63#1:270\n63#1:277\n63#1:290\n63#1:299\n63#1:300\n63#1:301\n63#1:307\n63#1:315\n63#1:328\n63#1:332\n63#1:333\n63#1:334\n63#1:335\n63#1:340\n63#1:352\n63#1:368\n63#1:378\n63#1:381\n63#1:384\n63#1:387\n63#1:390\n63#1:393\n63#1:399\n63#1:416\n63#1:436\n63#1:451\n63#1:468\n63#1:495\n39#2:208\n40#2,3:210\n43#2,7:214\n53#2:221\n54#2:223\n58#2,2:225\n62#2:227\n63#2,2:229\n65#2,3:232\n71#2,2:235\n76#2:238\n77#2:240\n81#2,2:241\n86#2:244\n88#2,2:246\n90#2,13:249\n109#2:265\n110#2:267\n114#2,2:268\n119#2,6:271\n125#2,9:278\n136#2,3:287\n139#2,6:291\n145#2:298\n149#2,5:302\n154#2,5:308\n161#2,2:313\n163#2,11:316\n177#2:327\n178#2:329\n182#2,2:330\n187#2,4:336\n191#2,6:341\n201#2:347\n202#2,3:349\n205#2,8:353\n213#2,3:362\n220#2,3:365\n223#2,7:369\n233#2,2:376\n238#2,2:379\n243#2,2:382\n248#2,2:385\n253#2,2:388\n258#2,2:391\n263#2,5:394\n268#2,11:400\n282#2,5:411\n287#2,14:417\n304#2,2:431\n306#2,2:434\n308#2,7:437\n317#2,2:444\n319#2,4:447\n323#2,11:452\n421#2,2:463\n424#2,2:466\n426#2,7:469\n442#2:476\n444#2,12:478\n459#2:490\n463#2,4:491\n467#2:496\n469#2:497\n471#2:498\n1#3:209\n1#3:222\n1#3:228\n1#3:245\n1#3:348\n1#3:433\n1#3:446\n1#3:465\n1#3:477\n27#4,3:262\n90#5:297\n90#5:361\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource\n*L\n67#1:213\n68#1:224\n70#1:231\n71#1:237\n72#1:239\n73#1:243\n74#1:248\n76#1:266\n77#1:270\n79#1:277\n81#1:290\n84#1:299\n85#1:300\n89#1:301\n93#1:307\n94#1:315\n95#1:328\n96#1:332\n99#1:333\n100#1:334\n105#1:335\n108#1:340\n110#1:352\n111#1:368\n112#1:378\n113#1:381\n114#1:384\n115#1:387\n116#1:390\n117#1:393\n118#1:399\n119#1:416\n120#1:436\n125#1:451\n135#1:468\n203#1:495\n67#1:208\n67#1:210,3\n67#1:214,7\n68#1:221\n68#1:223\n69#1:225,2\n70#1:227\n70#1:229,2\n70#1:232,3\n71#1:235,2\n72#1:238\n72#1:240\n73#1:241,2\n74#1:244\n74#1:246,2\n74#1:249,13\n76#1:265\n76#1:267\n77#1:268,2\n79#1:271,6\n79#1:278,9\n81#1:287,3\n81#1:291,6\n81#1:298\n93#1:302,5\n93#1:308,5\n94#1:313,2\n94#1:316,11\n95#1:327\n95#1:329\n96#1:330,2\n108#1:336,4\n108#1:341,6\n110#1:347\n110#1:349,3\n110#1:353,8\n110#1:362,3\n111#1:365,3\n111#1:369,7\n112#1:376,2\n113#1:379,2\n114#1:382,2\n115#1:385,2\n116#1:388,2\n117#1:391,2\n118#1:394,5\n118#1:400,11\n119#1:411,5\n119#1:417,14\n120#1:431,2\n120#1:434,2\n120#1:437,7\n125#1:444,2\n125#1:447,4\n125#1:452,11\n135#1:463,2\n135#1:466,2\n135#1:469,7\n149#1:476\n149#1:478,12\n151#1:490\n203#1:491,4\n203#1:496\n204#1:497\n205#1:498\n67#1:209\n68#1:222\n70#1:228\n74#1:245\n110#1:348\n120#1:433\n125#1:446\n135#1:465\n149#1:477\n75#1:262,3\n81#1:297\n110#1:361\n*E\n"})
/* renamed from: okio.RealBufferedSource, reason: from toString */
/* loaded from: classes.dex */
public final class buffer implements BufferedSource {

    @JvmField
    public final C5052Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    public final InterfaceC5062Source source;

    public buffer(InterfaceC5062Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new C5052Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // p132okio.BufferedSource, p132okio.BufferedSink
    /* renamed from: buffer, reason: from getter */
    public C5052Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.m14194clear();
    }

    @Override // p132okio.BufferedSource
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.exhausted() && this.source.mo2305read(this.bufferField, 8192L) == -1;
    }

    @Override // p132okio.BufferedSource, p132okio.BufferedSink
    public C5052Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14206indexOf(byte b) {
        return mo14208indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // p132okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource.inputStream.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                buffer bufferVar = buffer.this;
                if (bufferVar.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(bufferVar.bufferField.m14225size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws EOFException {
                buffer.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                buffer bufferVar = buffer.this;
                if (bufferVar.closed) {
                    throw new IOException("closed");
                }
                if (bufferVar.bufferField.m14225size() == 0) {
                    buffer bufferVar2 = buffer.this;
                    if (bufferVar2.source.mo2305read(bufferVar2.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return buffer.this.bufferField.readByte() & C1126UByte.MAX_VALUE;
            }

            public String toString() {
                return buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public long transferTo(OutputStream out) throws IOException {
                Intrinsics.checkNotNullParameter(out, "out");
                if (buffer.this.closed) {
                    throw new IOException("closed");
                }
                long jM14225size = 0;
                while (true) {
                    if (buffer.this.bufferField.m14225size() == 0) {
                        buffer bufferVar = buffer.this;
                        if (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                            return jM14225size;
                        }
                    }
                    jM14225size += buffer.this.bufferField.m14225size();
                    C5052Buffer.writeTo$default(buffer.this.bufferField, out, 0L, 2, null);
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int offset, int byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!buffer.this.closed) {
                    SegmentedByteString.checkOffsetAndCount(data.length, offset, byteCount);
                    if (buffer.this.bufferField.m14225size() == 0) {
                        buffer bufferVar = buffer.this;
                        if (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return buffer.this.bufferField.mo14215read(data, offset, byteCount);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: peek */
    public BufferedSource mo14213peek() {
        return C5053Okio.m14316buffer(new PeekSource(this));
    }

    @Override // p132okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.m14252size());
    }

    @Override // p132okio.BufferedSource
    /* renamed from: read */
    public int mo14214read(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return mo14215read(sink, 0, sink.length);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: readAll */
    public long mo14216readAll(InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = 0;
        while (this.source.mo2305read(this.bufferField, 8192L) != -1) {
            long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.mo2303write(this.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (this.bufferField.m14225size() <= 0) {
            return j;
        }
        long jM14225size = j + this.bufferField.m14225size();
        C5052Buffer c5052Buffer = this.bufferField;
        sink.mo2303write(c5052Buffer, c5052Buffer.m14225size());
        return jM14225size;
    }

    @Override // p132okio.BufferedSource
    public byte readByte() throws EOFException {
        mo14219require(1L);
        return this.bufferField.readByte();
    }

    @Override // p132okio.BufferedSource
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // p132okio.BufferedSource
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // p132okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        byte bM14205getByte;
        mo14219require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!mo14218request(j2)) {
                break;
            }
            bM14205getByte = this.bufferField.m14205getByte(j);
            if ((bM14205getByte < 48 || bM14205getByte > 57) && !(j == 0 && bM14205getByte == 45)) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a digit or '-' but was 0x");
            String string = Integer.toString(bM14205getByte, C1302CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // p132okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            mo14219require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (this.bufferField.m14225size() > 0) {
                C5052Buffer c5052Buffer = this.bufferField;
                int iMo14215read = c5052Buffer.mo14215read(sink, i, (int) c5052Buffer.m14225size());
                if (iMo14215read == -1) {
                    throw new AssertionError();
                }
                i += iMo14215read;
            }
            throw e;
        }
    }

    @Override // p132okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        byte bM14205getByte;
        mo14219require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo14218request(i2)) {
                break;
            }
            bM14205getByte = this.bufferField.m14205getByte(i);
            if ((bM14205getByte < 48 || bM14205getByte > 57) && ((bM14205getByte < 97 || bM14205getByte > 102) && (bM14205getByte < 65 || bM14205getByte > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bM14205getByte, C1302CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // p132okio.BufferedSource
    /* renamed from: readInt */
    public int mo14217readInt() throws EOFException {
        mo14219require(4L);
        return this.bufferField.mo14217readInt();
    }

    @Override // p132okio.BufferedSource
    public int readIntLe() throws EOFException {
        mo14219require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // p132okio.BufferedSource
    public long readLong() throws EOFException {
        mo14219require(8L);
        return this.bufferField.readLong();
    }

    @Override // p132okio.BufferedSource
    public long readLongLe() throws EOFException {
        mo14219require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // p132okio.BufferedSource
    public short readShort() throws EOFException {
        mo14219require(2L);
        return this.bufferField.readShort();
    }

    @Override // p132okio.BufferedSource
    public short readShortLe() throws EOFException {
        mo14219require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // p132okio.BufferedSource
    public String readString(long byteCount, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        mo14219require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    @Override // p132okio.BufferedSource
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // p132okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        mo14219require(1L);
        byte bM14205getByte = this.bufferField.m14205getByte(0L);
        if ((bM14205getByte & 224) == 192) {
            mo14219require(2L);
        } else if ((bM14205getByte & 240) == 224) {
            mo14219require(3L);
        } else if ((bM14205getByte & 248) == 240) {
            mo14219require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // p132okio.BufferedSource
    public String readUtf8Line() {
        long jMo14206indexOf = mo14206indexOf((byte) 10);
        if (jMo14206indexOf != -1) {
            return C5067Buffer.readUtf8Line(this.bufferField, jMo14206indexOf);
        }
        if (this.bufferField.m14225size() != 0) {
            return readUtf8(this.bufferField.m14225size());
        }
        return null;
    }

    @Override // p132okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: request */
    public boolean mo14218request(long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.bufferField.m14225size() < byteCount) {
            if (this.source.mo2305read(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: require */
    public void mo14219require(long byteCount) throws EOFException {
        if (!mo14218request(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // p132okio.BufferedSource
    /* renamed from: select */
    public int mo14220select(C5054Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            int iSelectPrefix = C5067Buffer.selectPrefix(this.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix != -1) {
                    this.bufferField.mo14226skip(options.getByteStrings()[iSelectPrefix].m14252size());
                    return iSelectPrefix;
                }
            } else if (this.source.mo2305read(this.bufferField, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: skip */
    public void mo14226skip(long byteCount) throws EOFException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (byteCount > 0) {
            if (this.bufferField.m14225size() == 0 && this.source.mo2305read(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(byteCount, this.bufferField.m14225size());
            this.bufferField.mo14226skip(jMin);
            byteCount -= jMin;
        }
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return this.source.getTimeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14207indexOf(byte b, long fromIndex) {
        return mo14208indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.bufferField.indexOfElement(targetBytes, fromIndex);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long jM14225size = this.bufferField.m14225size();
            if (this.source.mo2305read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, jM14225size);
        }
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: read */
    public long mo2305read(C5052Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.m14225size() == 0) {
            if (byteCount == 0) {
                return 0L;
            }
            if (this.source.mo2305read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
        }
        return this.bufferField.mo2305read(sink, Math.min(byteCount, this.bufferField.m14225size()));
    }

    @Override // p132okio.BufferedSource
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = limit == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long jMo14208indexOf = mo14208indexOf((byte) 10, 0L, j);
        if (jMo14208indexOf != -1) {
            return C5067Buffer.readUtf8Line(this.bufferField, jMo14208indexOf);
        }
        if (j < LongCompanionObject.MAX_VALUE && mo14218request(j) && this.bufferField.m14205getByte(j - 1) == 13 && mo14218request(1 + j) && this.bufferField.m14205getByte(j) == 10) {
            return C5067Buffer.readUtf8Line(this.bufferField, j);
        }
        C5052Buffer c5052Buffer = new C5052Buffer();
        C5052Buffer c5052Buffer2 = this.bufferField;
        c5052Buffer2.m14202copyTo(c5052Buffer, 0L, Math.min(32, c5052Buffer2.m14225size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.m14225size(), limit) + " content=" + c5052Buffer.readByteString().mo14243hex() + Typography.ellipsis);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14209indexOf(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return mo14210indexOf(bytes, 0L);
    }

    @Override // p132okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!this.closed) {
            if (byteCount >= 0 && offset >= 0 && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.m14252size()) {
                return byteCount == 0 || RealBufferedSource.commonIndexOf(this, bytes, bytesOffset, byteCount, offset, offset + 1) != -1;
            }
            return false;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14210indexOf(ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return mo14211indexOf(bytes, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14211indexOf(ByteString bytes, long fromIndex, long toIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return RealBufferedSource.commonIndexOf(this, bytes, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? bytes.m14252size() : 0, fromIndex, (6 & 16) != 0 ? Long.MAX_VALUE : toIndex);
    }

    @Override // p132okio.BufferedSource
    public byte[] readByteArray(long byteCount) throws EOFException {
        mo14219require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override // p132okio.BufferedSource
    public ByteString readByteString(long byteCount) throws EOFException {
        mo14219require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override // p132okio.BufferedSource
    public String readUtf8(long byteCount) throws EOFException {
        mo14219require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14208indexOf(byte b, long fromIndex, long toIndex) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        while (fromIndex < toIndex) {
            long jMo14208indexOf = this.bufferField.mo14208indexOf(b, fromIndex, toIndex);
            if (jMo14208indexOf != -1) {
                return jMo14208indexOf;
            }
            long jM14225size = this.bufferField.m14225size();
            if (jM14225size >= toIndex || this.source.mo2305read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, jM14225size);
        }
        return -1L;
    }

    @Override // p132okio.BufferedSource
    public void readFully(C5052Buffer sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            mo14219require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e) {
            sink.writeAll(this.bufferField);
            throw e;
        }
    }

    @Override // p132okio.BufferedSource
    /* renamed from: select */
    public <T> T mo14221select(TypedOptions<T> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int iMo14220select = mo14220select(options.getOptions());
        if (iMo14220select == -1) {
            return null;
        }
        return options.get(iMo14220select);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: read */
    public int mo14215read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = byteCount;
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, j);
        if (this.bufferField.m14225size() == 0) {
            if (byteCount == 0) {
                return 0;
            }
            if (this.source.mo2305read(this.bufferField, 8192L) == -1) {
                return -1;
            }
        }
        return this.bufferField.mo14215read(sink, offset, (int) Math.min(j, this.bufferField.m14225size()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.m14225size() == 0 && this.source.mo2305read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }
}
