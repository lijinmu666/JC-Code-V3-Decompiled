package com.flyfishxu.p028kadb.transport;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.RangesKt;

@Metadata(m4987d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ&\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ&\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010#\u001a\u00020!H\u0096@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020!H\u0096@¢\u0006\u0002\u0010$J\b\u0010)\u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(¨\u0006+"}, m4988d2 = {"Lcom/flyfishxu/kadb/transport/PlainBlockingChannel;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "input", "Ljava/io/InputStream;", "kotlin.jvm.PlatformType", "getInput", "()Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "getOutput", "()Ljava/io/OutputStream;", "localAddress", "Ljava/net/InetSocketAddress;", "getLocalAddress", "()Ljava/net/InetSocketAddress;", "remoteAddress", "getRemoteAddress", "read", BuildConfig.f24315FLAVOR, "dst", "Ljava/nio/ByteBuffer;", "timeout", BuildConfig.f24315FLAVOR, "unit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/nio/ByteBuffer;JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "src", "readExactly", BuildConfig.f24315FLAVOR, "writeExactly", "shutdownInput", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdownOutput", "isOpen", BuildConfig.f24315FLAVOR, "()Z", "close", "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PlainBlockingChannel implements TransportChannel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Socket socket;

    @Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m4988d2 = {"Lcom/flyfishxu/kadb/transport/PlainBlockingChannel$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "connect", "Lcom/flyfishxu/kadb/transport/PlainBlockingChannel;", "host", BuildConfig.f24315FLAVOR, "port", BuildConfig.f24315FLAVOR, "connectTimeoutMs", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: connect */
        public final PlainBlockingChannel m2352connect(String host, int port, long connectTimeoutMs) throws IOException {
            Intrinsics.checkNotNullParameter(host, "host");
            Socket socket = new Socket();
            socket.setKeepAlive(true);
            socket.setTcpNoDelay(true);
            socket.connect(new InetSocketAddress(host, port), (int) RangesKt.coerceAtMost(connectTimeoutMs, 2147483647L));
            return new PlainBlockingChannel(socket, null);
        }

        private Companion() {
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.PlainBlockingChannel", m6124f = "PlainBlockingChannel.kt", m6125i = {0, 0, 0}, m6126l = {78}, m6127m = "readExactly", m6128n = {"dst", "unit", "timeout"}, m6129nl = {79}, m6130s = {"L$0", "L$1", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.PlainBlockingChannel$readExactly$1 */
    public static final class C02021 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2174J$0;

        /* renamed from: L$0 */
        Object f2175L$0;

        /* renamed from: L$1 */
        Object f2176L$1;

        /* renamed from: label */
        int f2177label;

        /* renamed from: result */
        /* synthetic */ Object f2178result;

        public C02021(Continuation<? super C02021> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2178result = obj;
            this.f2177label |= Integer.MIN_VALUE;
            return PlainBlockingChannel.this.readExactly(null, 0L, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.PlainBlockingChannel", m6124f = "PlainBlockingChannel.kt", m6125i = {0, 0, 0}, m6126l = {85}, m6127m = "writeExactly", m6128n = {"src", "unit", "timeout"}, m6129nl = {86}, m6130s = {"L$0", "L$1", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.PlainBlockingChannel$writeExactly$1 */
    public static final class C02031 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2180J$0;

        /* renamed from: L$0 */
        Object f2181L$0;

        /* renamed from: L$1 */
        Object f2182L$1;

        /* renamed from: label */
        int f2183label;

        /* renamed from: result */
        /* synthetic */ Object f2184result;

        public C02031(Continuation<? super C02031> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2184result = obj;
            this.f2183label |= Integer.MIN_VALUE;
            return PlainBlockingChannel.this.writeExactly(null, 0L, null, this);
        }
    }

    public /* synthetic */ PlainBlockingChannel(Socket socket, DefaultConstructorMarker defaultConstructorMarker) {
        this(socket);
    }

    private final InputStream getInput() {
        return this.socket.getInputStream();
    }

    private final OutputStream getOutput() {
        return this.socket.getOutputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.socket.close();
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public InetSocketAddress getLocalAddress() {
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        Intrinsics.checkNotNull(localSocketAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        return (InetSocketAddress) localSocketAddress;
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public InetSocketAddress getRemoteAddress() {
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        Intrinsics.checkNotNull(remoteSocketAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        return (InetSocketAddress) remoteSocketAddress;
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /* renamed from: isOpen */
    public boolean mo2349isOpen() {
        return this.socket.isConnected() && !this.socket.isClosed();
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /* renamed from: read */
    public Object mo2350read(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super Integer> continuation) throws SocketException {
        Integer numM6121boxInt;
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(j > 0 ? (int) RangesKt.coerceAtMost(timeUnit.toMillis(j), 2147483647L) : 0);
            byte[] bArr = new byte[Math.min(byteBuffer.remaining(), PKIFailureInfo.notAuthorized)];
            int i = getInput().read(bArr);
            if (i <= 0) {
                numM6121boxInt = C1207Boxing.m6121boxInt(-1);
            } else {
                byteBuffer.put(bArr, 0, i);
                numM6121boxInt = C1207Boxing.m6121boxInt(i);
            }
            this.socket.setSoTimeout(soTimeout);
            return numM6121boxInt;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:21:0x0067). Please report as a decompilation issue!!! */
    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object readExactly(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super C1133Unit> continuation) throws SocketException, EOFException {
        C02021 c02021;
        ByteBuffer byteBuffer2;
        long j2;
        C02021 c020212;
        TimeUnit timeUnit2;
        if (continuation instanceof C02021) {
            c02021 = (C02021) continuation;
            int i = c02021.f2177label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02021.f2177label = i - Integer.MIN_VALUE;
            } else {
                c02021 = new C02021(continuation);
            }
        }
        Object obj = c02021.f2178result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02021.f2177label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteBuffer2 = byteBuffer;
            j2 = j;
            c020212 = c02021;
            timeUnit2 = timeUnit;
            if (byteBuffer2.hasRemaining()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c02021.f2174J$0;
            TimeUnit timeUnit3 = (TimeUnit) c02021.f2176L$1;
            ByteBuffer byteBuffer3 = (ByteBuffer) c02021.f2175L$0;
            ResultKt.throwOnFailure(obj);
            c020212 = c02021;
            j2 = j3;
            timeUnit2 = timeUnit3;
            if (((Number) obj).intValue() < 0) {
                byteBuffer2 = byteBuffer3;
                if (byteBuffer2.hasRemaining()) {
                    return C1133Unit.INSTANCE;
                }
                c020212.f2175L$0 = byteBuffer2;
                c020212.f2176L$1 = timeUnit2;
                c020212.f2174J$0 = j2;
                c020212.f2177label = 1;
                Object objMo2350read = mo2350read(byteBuffer2, j2, timeUnit2, c020212);
                if (objMo2350read == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteBuffer3 = byteBuffer2;
                obj = objMo2350read;
                if (((Number) obj).intValue() < 0) {
                    throw new EOFException("EOF while readExactly");
                }
            }
        }
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public Object shutdownInput(Continuation<? super C1133Unit> continuation) throws IOException {
        this.socket.shutdownInput();
        return C1133Unit.INSTANCE;
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public Object shutdownOutput(Continuation<? super C1133Unit> continuation) throws IOException {
        this.socket.shutdownOutput();
        return C1133Unit.INSTANCE;
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /* renamed from: write */
    public Object mo2351write(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super Integer> continuation) throws IOException {
        int iMin = Math.min(byteBuffer.remaining(), PKIFailureInfo.notAuthorized);
        byte[] bArr = new byte[iMin];
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(bArr);
        byteBuffer.limit(iLimit);
        getOutput().write(bArr);
        return C1207Boxing.m6121boxInt(iMin);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:21:0x0067). Please report as a decompilation issue!!! */
    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeExactly(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super C1133Unit> continuation) throws IOException {
        C02031 c02031;
        ByteBuffer byteBuffer2;
        long j2;
        C02031 c020312;
        TimeUnit timeUnit2;
        if (continuation instanceof C02031) {
            c02031 = (C02031) continuation;
            int i = c02031.f2183label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02031.f2183label = i - Integer.MIN_VALUE;
            } else {
                c02031 = new C02031(continuation);
            }
        }
        Object obj = c02031.f2184result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02031.f2183label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteBuffer2 = byteBuffer;
            j2 = j;
            c020312 = c02031;
            timeUnit2 = timeUnit;
            if (byteBuffer2.hasRemaining()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c02031.f2180J$0;
            TimeUnit timeUnit3 = (TimeUnit) c02031.f2182L$1;
            ByteBuffer byteBuffer3 = (ByteBuffer) c02031.f2181L$0;
            ResultKt.throwOnFailure(obj);
            c020312 = c02031;
            j2 = j3;
            timeUnit2 = timeUnit3;
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue < 0) {
                byteBuffer2 = byteBuffer3;
                if (byteBuffer2.hasRemaining()) {
                    return C1133Unit.INSTANCE;
                }
                c020312.f2181L$0 = byteBuffer2;
                c020312.f2182L$1 = timeUnit2;
                c020312.f2180J$0 = j2;
                c020312.f2183label = 1;
                Object objMo2351write = mo2351write(byteBuffer2, j2, timeUnit2, c020312);
                if (objMo2351write == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteBuffer3 = byteBuffer2;
                obj = objMo2351write;
                int iIntValue2 = ((Number) obj).intValue();
                if (iIntValue2 < 0) {
                    throw new IOException("write returned " + iIntValue2);
                }
            }
        }
    }

    private PlainBlockingChannel(Socket socket) {
        this.socket = socket;
    }
}
