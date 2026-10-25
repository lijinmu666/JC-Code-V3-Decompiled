package p132okio.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.C5052Buffer;
import p132okio.C5059Segment;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5061Socket;
import p132okio.InterfaceC5062Source;
import p132okio.SegmentPool;
import p132okio.SegmentedByteString;

@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, m4988d2 = {"Lokio/internal/DefaultSocket;", "Lokio/Socket;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "getSocket", "()Ljava/net/Socket;", "closeBits", "Ljava/util/concurrent/atomic/AtomicInteger;", "source", "Lokio/Source;", "getSource", "()Lokio/Source;", "sink", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "cancel", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "SocketSink", "SocketSource", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DefaultSocket implements InterfaceC5061Socket {
    private AtomicInteger closeBits;
    private final InterfaceC5060Sink sink;
    private final Socket socket;
    private final InterfaceC5062Source source;

    @Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m4988d2 = {"Lokio/internal/DefaultSocket$SocketSink;", "Lokio/Sink;", "<init>", "(Lokio/internal/DefaultSocket;)V", "outputStream", "Ljava/io/OutputStream;", "kotlin.jvm.PlatformType", "timeout", "Lokio/internal/SocketAsyncTimeout;", "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "flush", "close", "toString", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nDefaultSocket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 AsyncTimeout.kt\nokio/AsyncTimeout\n*L\n1#1,176:1\n87#2:177\n195#3,11:178\n195#3,11:189\n195#3,11:200\n*S KotlinDebug\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSink\n*L\n60#1:177\n61#1:178,11\n77#1:189,11\n83#1:200,11\n*E\n"})
    /* renamed from: okio.internal.DefaultSocket$SocketSink, reason: from toString */
    public final class sink implements InterfaceC5060Sink {
        private final OutputStream outputStream;
        private final SocketAsyncTimeout timeout;

        public sink() {
            this.outputStream = DefaultSocket.this.getSocket().getOutputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            socketAsyncTimeout.m14186enter();
            try {
                int bitsOrZero = _AtomicKt.setBitsOrZero(defaultSocket.closeBits, 1);
                if (bitsOrZero != 0) {
                    if (bitsOrZero != 3) {
                        if (!defaultSocket.getSocket().isClosed() && !defaultSocket.getSocket().isOutputShutdown()) {
                            this.outputStream.flush();
                            try {
                                defaultSocket.getSocket().shutdownOutput();
                            } catch (UnsupportedOperationException unused) {
                                this.outputStream.close();
                            }
                        }
                        return;
                    }
                    defaultSocket.getSocket().close();
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    if (socketAsyncTimeout.m14187exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                }
            } catch (IOException e) {
                if (!socketAsyncTimeout.m14187exit()) {
                    throw e;
                }
                throw socketAsyncTimeout.access$newTimeoutException(e);
            } finally {
                socketAsyncTimeout.m14187exit();
            }
        }

        @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
        public void flush() throws IOException {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            socketAsyncTimeout.m14186enter();
            try {
                this.outputStream.flush();
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                if (socketAsyncTimeout.m14187exit()) {
                    throw socketAsyncTimeout.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!socketAsyncTimeout.m14187exit()) {
                    throw e;
                }
                throw socketAsyncTimeout.access$newTimeoutException(e);
            } finally {
                socketAsyncTimeout.m14187exit();
            }
        }

        public String toString() {
            return "sink(" + DefaultSocket.this.getSocket() + ')';
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
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.m14186enter();
                try {
                    this.outputStream.write(c5059Segment.data, c5059Segment.pos, iMin);
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    if (socketAsyncTimeout.m14187exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                    c5059Segment.pos += iMin;
                    long j = iMin;
                    byteCount -= j;
                    source.setSize$okio(source.m14225size() - j);
                    if (c5059Segment.pos == c5059Segment.limit) {
                        source.head = c5059Segment.m14380pop();
                        SegmentPool.m14384recycle(c5059Segment);
                    }
                } catch (IOException e) {
                    if (!socketAsyncTimeout.m14187exit()) {
                        throw e;
                    }
                    throw socketAsyncTimeout.access$newTimeoutException(e);
                } finally {
                    socketAsyncTimeout.m14187exit();
                }
            }
        }

        @Override // p132okio.InterfaceC5060Sink
        /* renamed from: timeout, reason: from getter */
        public SocketAsyncTimeout getTimeout() {
            return this.timeout;
        }
    }

    @Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m4988d2 = {"Lokio/internal/DefaultSocket$SocketSource;", "Lokio/Source;", "<init>", "(Lokio/internal/DefaultSocket;)V", "inputStream", "Ljava/io/InputStream;", "kotlin.jvm.PlatformType", "timeout", "Lokio/internal/SocketAsyncTimeout;", "read", BuildConfig.f24315FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "close", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nDefaultSocket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 AsyncTimeout.kt\nokio/AsyncTimeout\n*L\n1#1,176:1\n1#2:177\n87#3:178\n195#4,11:179\n195#4,11:190\n*S KotlinDebug\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSource\n*L\n121#1:178\n123#1:179,11\n144#1:190,11\n*E\n"})
    /* renamed from: okio.internal.DefaultSocket$SocketSource, reason: from toString */
    public final class source implements InterfaceC5062Source {
        private final InputStream inputStream;
        private final SocketAsyncTimeout timeout;

        public source() {
            this.inputStream = DefaultSocket.this.getSocket().getInputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            socketAsyncTimeout.m14186enter();
            try {
                int bitsOrZero = _AtomicKt.setBitsOrZero(defaultSocket.closeBits, 2);
                if (bitsOrZero != 0) {
                    if (bitsOrZero == 3) {
                        defaultSocket.getSocket().close();
                    } else {
                        if (defaultSocket.getSocket().isClosed() || defaultSocket.getSocket().isInputShutdown()) {
                            return;
                        }
                        try {
                            defaultSocket.getSocket().shutdownInput();
                        } catch (UnsupportedOperationException unused) {
                            this.inputStream.close();
                        }
                    }
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    if (socketAsyncTimeout.m14187exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                }
            } catch (IOException e) {
                if (!socketAsyncTimeout.m14187exit()) {
                    throw e;
                }
                throw socketAsyncTimeout.access$newTimeoutException(e);
            } finally {
                socketAsyncTimeout.m14187exit();
            }
        }

        @Override // p132okio.InterfaceC5062Source
        /* renamed from: read */
        public long mo2305read(C5052Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount == 0) {
                return 0L;
            }
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            this.timeout.throwIfReached();
            C5059Segment c5059SegmentWritableSegment$okio = sink.writableSegment$okio(1);
            int iMin = (int) Math.min(byteCount, 8192 - c5059SegmentWritableSegment$okio.limit);
            try {
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.m14186enter();
                try {
                    int i = this.inputStream.read(c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit, iMin);
                    if (socketAsyncTimeout.m14187exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                    if (i != -1) {
                        c5059SegmentWritableSegment$okio.limit += i;
                        long j = i;
                        sink.setSize$okio(sink.m14225size() + j);
                        return j;
                    }
                    if (c5059SegmentWritableSegment$okio.pos != c5059SegmentWritableSegment$okio.limit) {
                        return -1L;
                    }
                    sink.head = c5059SegmentWritableSegment$okio.m14380pop();
                    SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
                    return -1L;
                } catch (IOException e) {
                    if (socketAsyncTimeout.m14187exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    socketAsyncTimeout.m14187exit();
                }
            } catch (AssertionError e2) {
                if (_JavaIoKt.isAndroidGetsocknameError(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }

        public String toString() {
            return "source(" + DefaultSocket.this.getSocket() + ')';
        }

        @Override // p132okio.InterfaceC5062Source
        /* renamed from: timeout, reason: from getter */
        public SocketAsyncTimeout getTimeout() {
            return this.timeout;
        }
    }

    public DefaultSocket(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
        this.closeBits = new AtomicInteger();
        this.source = new source();
        this.sink = new sink();
    }

    @Override // p132okio.InterfaceC5061Socket
    /* renamed from: cancel */
    public void mo14386cancel() throws IOException {
        this.socket.close();
    }

    @Override // p132okio.InterfaceC5061Socket
    public InterfaceC5060Sink getSink() {
        return this.sink;
    }

    public final Socket getSocket() {
        return this.socket;
    }

    @Override // p132okio.InterfaceC5061Socket
    public InterfaceC5062Source getSource() {
        return this.source;
    }

    public String toString() {
        String string = this.socket.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
