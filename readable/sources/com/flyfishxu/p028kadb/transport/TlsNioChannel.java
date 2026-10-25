package com.flyfishxu.p028kadb.transport;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.BuildersKt__Builders_concurrentKt;

@Metadata(m4987d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J&\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J&\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u001a\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010&\u001a\u00020\fH\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010%¨\u0006,"}, m4988d2 = {"Lcom/flyfishxu/kadb/transport/TlsNioChannel;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "net", "engine", "Ljavax/net/ssl/SSLEngine;", "<init>", "(Lcom/flyfishxu/kadb/transport/TransportChannel;Ljavax/net/ssl/SSLEngine;)V", "netIn", "Ljava/nio/ByteBuffer;", "netOut", "appIn", "handshake", BuildConfig.f24315FLAVOR, "timeout", BuildConfig.f24315FLAVOR, "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", BuildConfig.f24315FLAVOR, "dst", "(Ljava/nio/ByteBuffer;JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "src", "readExactly", "writeExactly", "shutdownInput", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdownOutput", "localAddress", "Ljava/net/InetSocketAddress;", "getLocalAddress", "()Ljava/net/InetSocketAddress;", "remoteAddress", "getRemoteAddress", "isOpen", BuildConfig.f24315FLAVOR, "()Z", "close", "enlarge", "buffer", "minimum", "resizeIfNeeded", "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class TlsNioChannel implements TransportChannel {
    private static final Companion Companion = new Companion(null);

    /* renamed from: EMPTY */
    private static final ByteBuffer f2186EMPTY;
    private ByteBuffer appIn;
    private final SSLEngine engine;
    private final TransportChannel net;
    private ByteBuffer netIn;
    private ByteBuffer netOut;

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m4988d2 = {"Lcom/flyfishxu/kadb/transport/TlsNioChannel$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "EMPTY", "Ljava/nio/ByteBuffer;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            try {
                iArr[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.TlsNioChannel", m6124f = "TlsNioChannel.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, m6126l = {C5125EACTags.CARD_SEQUENCE_NUMBER, C5125EACTags.ELEMENT_LIST, 78}, m6127m = "handshake", m6128n = {"unit", "status", "result", "timeout", "unit", "status", "timeout", "unit", "status", "result", "timeout"}, m6129nl = {56, C5125EACTags.f18344ADDRESS, 79}, m6130s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.TlsNioChannel$handshake$1 */
    public static final class C02041 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2193J$0;

        /* renamed from: L$0 */
        Object f2194L$0;

        /* renamed from: L$1 */
        Object f2195L$1;

        /* renamed from: L$2 */
        Object f2196L$2;

        /* renamed from: label */
        int f2197label;

        /* renamed from: result */
        /* synthetic */ Object f2198result;

        public C02041(Continuation<? super C02041> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2198result = obj;
            this.f2197label |= Integer.MIN_VALUE;
            return TlsNioChannel.this.handshake(0L, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.TlsNioChannel", m6124f = "TlsNioChannel.kt", m6125i = {0, 0, 0, 1, 1, 1, 1}, m6126l = {130, 153}, m6127m = "read", m6128n = {"dst", "unit", "timeout", "dst", "unit", "result", "timeout"}, m6129nl = {131, 154}, m6130s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.TlsNioChannel$read$1 */
    public static final class C02051 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2200J$0;

        /* renamed from: L$0 */
        Object f2201L$0;

        /* renamed from: L$1 */
        Object f2202L$1;

        /* renamed from: L$2 */
        Object f2203L$2;

        /* renamed from: label */
        int f2204label;

        /* renamed from: result */
        /* synthetic */ Object f2205result;

        public C02051(Continuation<? super C02051> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2205result = obj;
            this.f2204label |= Integer.MIN_VALUE;
            return TlsNioChannel.this.mo2350read(null, 0L, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.TlsNioChannel", m6124f = "TlsNioChannel.kt", m6125i = {0, 0, 0}, m6126l = {184}, m6127m = "readExactly", m6128n = {"dst", "unit", "timeout"}, m6129nl = {185}, m6130s = {"L$0", "L$1", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.TlsNioChannel$readExactly$1 */
    public static final class C02061 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2207J$0;

        /* renamed from: L$0 */
        Object f2208L$0;

        /* renamed from: L$1 */
        Object f2209L$1;

        /* renamed from: label */
        int f2210label;

        /* renamed from: result */
        /* synthetic */ Object f2211result;

        public C02061(Continuation<? super C02061> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2211result = obj;
            this.f2210label |= Integer.MIN_VALUE;
            return TlsNioChannel.this.readExactly(null, 0L, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.TlsNioChannel", m6124f = "TlsNioChannel.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 1}, m6126l = {169, 175}, m6127m = "write", m6128n = {"src", "unit", "result", "timeout", "src", "unit", "result", "timeout"}, m6129nl = {171, 180}, m6130s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.TlsNioChannel$write$1 */
    public static final class C02071 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2213J$0;

        /* renamed from: L$0 */
        Object f2214L$0;

        /* renamed from: L$1 */
        Object f2215L$1;

        /* renamed from: L$2 */
        Object f2216L$2;

        /* renamed from: label */
        int f2217label;

        /* renamed from: result */
        /* synthetic */ Object f2218result;

        public C02071(Continuation<? super C02071> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2218result = obj;
            this.f2217label |= Integer.MIN_VALUE;
            return TlsNioChannel.this.mo2351write(null, 0L, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.TlsNioChannel", m6124f = "TlsNioChannel.kt", m6125i = {0, 0, 0}, m6126l = {191}, m6127m = "writeExactly", m6128n = {"src", "unit", "timeout"}, m6129nl = {192}, m6130s = {"L$0", "L$1", "J$0"}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.transport.TlsNioChannel$writeExactly$1 */
    public static final class C02081 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f2220J$0;

        /* renamed from: L$0 */
        Object f2221L$0;

        /* renamed from: L$1 */
        Object f2222L$1;

        /* renamed from: label */
        int f2223label;

        /* renamed from: result */
        /* synthetic */ Object f2224result;

        public C02081(Continuation<? super C02081> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2224result = obj;
            this.f2223label |= Integer.MIN_VALUE;
            return TlsNioChannel.this.writeExactly(null, 0L, null, this);
        }
    }

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        f2186EMPTY = byteBufferAllocate;
    }

    public TlsNioChannel(TransportChannel net, SSLEngine engine) {
        Intrinsics.checkNotNullParameter(net, "net");
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.net = net;
        this.engine = engine;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(engine.getSession().getPacketBufferSize());
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        this.netIn = byteBufferAllocate;
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(engine.getSession().getPacketBufferSize());
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate2, "allocate(...)");
        this.netOut = byteBufferAllocate2;
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(engine.getSession().getApplicationBufferSize());
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate3, "allocate(...)");
        this.appIn = byteBufferAllocate3;
    }

    /* renamed from: enlarge */
    private final ByteBuffer m2353enlarge(ByteBuffer buffer, int minimum) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(buffer.capacity() * 2, minimum));
        buffer.flip();
        byteBufferAllocate.put(buffer);
        Intrinsics.checkNotNull(byteBufferAllocate);
        return byteBufferAllocate;
    }

    private final void resizeIfNeeded() {
        int packetBufferSize = this.engine.getSession().getPacketBufferSize();
        int applicationBufferSize = this.engine.getSession().getApplicationBufferSize();
        if (this.netIn.capacity() < packetBufferSize) {
            this.netIn = m2353enlarge(this.netIn, packetBufferSize);
        }
        if (this.netOut.capacity() < packetBufferSize) {
            this.netOut = m2353enlarge(this.netOut, packetBufferSize);
        }
        if (this.appIn.capacity() < applicationBufferSize) {
            this.appIn = m2353enlarge(this.appIn, applicationBufferSize);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SSLEngineResult sSLEngineResultWrap;
        try {
            this.engine.closeOutbound();
            this.netOut.clear();
            try {
                sSLEngineResultWrap = this.engine.wrap(f2186EMPTY.duplicate(), this.netOut);
            } catch (Throwable unused) {
                sSLEngineResultWrap = null;
            }
            if (sSLEngineResultWrap != null && sSLEngineResultWrap.getStatus() == SSLEngineResult.Status.OK && this.netOut.position() > 0) {
                this.netOut.flip();
                try {
                    C1124Result.Companion companion = C1124Result.INSTANCE;
                    BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new TlsNioChannel$close$1$1(this, null), 1, null);
                    C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
                } catch (Throwable th) {
                    C1124Result.Companion companion2 = C1124Result.INSTANCE;
                    C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
                }
            }
        } catch (Throwable unused2) {
        }
        this.net.close();
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public InetSocketAddress getLocalAddress() {
        return this.net.getLocalAddress();
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public InetSocketAddress getRemoteAddress() {
        return this.net.getRemoteAddress();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d8, code lost:
    
        resizeIfNeeded();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        return p094kotlin.C1133Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fd, code lost:
    
        if (r24.netIn.hasRemaining() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ff, code lost:
    
        r24.netIn.compact();
        r10 = r24.net;
        r11 = r24.netIn;
        r15.f2194L$0 = r4;
        r15.f2195L$1 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r9);
        r15.f2196L$2 = null;
        r15.f2193J$0 = r1;
        r15.f2197label = 2;
        r9 = r10.mo2350read(r11, r1, r4, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0120, code lost:
    
        if (r9 != r3) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0122, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0123, code lost:
    
        r22 = r1;
        r1 = r9;
        r9 = r22;
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x009a, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x01aa -> B:65:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01e4 -> B:68:0x01bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01f9 -> B:68:0x01bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handshake(long j, TimeUnit timeUnit, Continuation<? super C1133Unit> continuation) throws SSLException {
        C02041 c02041;
        TimeUnit timeUnit2;
        SSLEngineResult.HandshakeStatus handshakeStatus;
        C02041 c020412;
        long j2;
        SSLEngineResult.HandshakeStatus handshakeStatus2;
        long j3;
        SSLEngineResult.HandshakeStatus handshakeStatus3;
        SSLEngineResult sSLEngineResultWrap;
        int i;
        if (continuation instanceof C02041) {
            c02041 = (C02041) continuation;
            int i2 = c02041.f2197label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c02041.f2197label = i2 - Integer.MIN_VALUE;
            } else {
                c02041 = new C02041(continuation);
            }
        }
        Object obj = c02041.f2198result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c02041.f2197label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.netIn.clear();
            this.netIn.limit(0);
            this.appIn.clear();
            this.engine.beginHandshake();
            timeUnit2 = timeUnit;
            handshakeStatus = this.engine.getHandshakeStatus();
            c020412 = c02041;
            j2 = j;
            while (true) {
                if (handshakeStatus == null) {
                }
                if (i == 1) {
                }
            }
        } else if (i3 == 1) {
            long j4 = c02041.f2193J$0;
            SSLEngineResult sSLEngineResult = (SSLEngineResult) c02041.f2196L$2;
            SSLEngineResult.HandshakeStatus handshakeStatus4 = (SSLEngineResult.HandshakeStatus) c02041.f2195L$1;
            TimeUnit timeUnit3 = (TimeUnit) c02041.f2194L$0;
            ResultKt.throwOnFailure(obj);
            c020412 = c02041;
            j2 = j4;
            handshakeStatus3 = handshakeStatus4;
            sSLEngineResultWrap = sSLEngineResult;
            timeUnit2 = timeUnit3;
            while (this.netOut.hasRemaining()) {
                TransportChannel transportChannel = this.net;
                ByteBuffer byteBuffer = this.netOut;
                c020412.f2194L$0 = timeUnit2;
                c020412.f2195L$1 = handshakeStatus3;
                c020412.f2196L$2 = SpillingKt.nullOutSpilledVariable(sSLEngineResultWrap);
                c020412.f2193J$0 = j2;
                c020412.f2197label = 1;
                if (transportChannel.writeExactly(byteBuffer, j2, timeUnit2, c020412) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            handshakeStatus = handshakeStatus3;
        } else if (i3 == 2) {
            long j5 = c02041.f2193J$0;
            timeUnit2 = (TimeUnit) c02041.f2194L$0;
            ResultKt.throwOnFailure(obj);
            if (((Number) obj).intValue() < 0) {
                throw new SSLException("Channel closed during handshake");
            }
            this.netIn.flip();
            c020412 = c02041;
            j2 = j5;
            SSLEngineResult sSLEngineResultUnwrap = this.engine.unwrap(this.netIn, this.appIn);
            SSLEngineResult.HandshakeStatus handshakeStatus5 = sSLEngineResultUnwrap.getHandshakeStatus();
            SSLEngineResult.Status status = sSLEngineResultUnwrap.getStatus();
            int i4 = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i4 == 1) {
                handshakeStatus2 = handshakeStatus5;
            } else if (i4 == 2) {
                handshakeStatus2 = handshakeStatus5;
                this.appIn = m2353enlarge(this.appIn, this.engine.getSession().getApplicationBufferSize());
            } else {
                if (i4 != 3) {
                    throw new SSLException("NEED_UNWRAP: " + sSLEngineResultUnwrap.getStatus());
                }
                if (this.netIn.limit() == this.netIn.capacity()) {
                    this.netIn = m2353enlarge(this.netIn, this.engine.getSession().getPacketBufferSize());
                }
                this.netIn.compact();
                TransportChannel transportChannel2 = this.net;
                ByteBuffer byteBuffer2 = this.netIn;
                c020412.f2194L$0 = timeUnit2;
                c020412.f2195L$1 = handshakeStatus5;
                c020412.f2196L$2 = SpillingKt.nullOutSpilledVariable(sSLEngineResultUnwrap);
                c020412.f2193J$0 = j2;
                c020412.f2197label = 3;
                handshakeStatus2 = handshakeStatus5;
                Object objMo2350read = transportChannel2.mo2350read(byteBuffer2, j2, timeUnit2, c020412);
                if (objMo2350read == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long j6 = j2;
                obj = objMo2350read;
                j3 = j6;
                if (((Number) obj).intValue() >= 0) {
                }
            }
            handshakeStatus = handshakeStatus2;
            while (true) {
                if (handshakeStatus == null) {
                }
                if (i == 1) {
                }
            }
        } else {
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = c02041.f2193J$0;
            SSLEngineResult.HandshakeStatus handshakeStatus6 = (SSLEngineResult.HandshakeStatus) c02041.f2195L$1;
            TimeUnit timeUnit4 = (TimeUnit) c02041.f2194L$0;
            ResultKt.throwOnFailure(obj);
            c020412 = c02041;
            handshakeStatus2 = handshakeStatus6;
            timeUnit2 = timeUnit4;
            if (((Number) obj).intValue() >= 0) {
                throw new SSLException("EOF during handshake");
            }
            this.netIn.flip();
            j2 = j3;
            handshakeStatus = handshakeStatus2;
            while (true) {
                i = handshakeStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$1[handshakeStatus.ordinal()];
                if (i == 1) {
                    this.netOut.clear();
                    sSLEngineResultWrap = this.engine.wrap(f2186EMPTY.duplicate(), this.netOut);
                    handshakeStatus3 = sSLEngineResultWrap.getHandshakeStatus();
                    SSLEngineResult.Status status2 = sSLEngineResultWrap.getStatus();
                    int i5 = status2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status2.ordinal()];
                    if (i5 == 1) {
                        this.netOut.flip();
                        break;
                    }
                    if (i5 != 2) {
                        throw new SSLException("NEED_WRAP: " + sSLEngineResultWrap.getStatus());
                    }
                    this.netOut = m2353enlarge(this.netOut, this.engine.getSession().getPacketBufferSize());
                    handshakeStatus = handshakeStatus3;
                } else {
                    if (i == 2) {
                        break;
                    }
                    if (i == 3) {
                        Runnable delegatedTask = this.engine.getDelegatedTask();
                        while (delegatedTask != null) {
                            delegatedTask.run();
                            delegatedTask = this.engine.getDelegatedTask();
                        }
                        handshakeStatus = this.engine.getHandshakeStatus();
                    } else {
                        if (i == 4 || i == 5) {
                            break;
                        }
                        if (!Intrinsics.areEqual(handshakeStatus.name(), "NEED_UNWRAP_AGAIN")) {
                            throw new SSLException("Unsupported handshake status: " + handshakeStatus);
                        }
                        handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
                    }
                }
            }
        }
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /* renamed from: isOpen */
    public boolean mo2349isOpen() {
        return this.net.mo2349isOpen();
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
    
        r14 = r8;
        r15 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0145 -> B:51:0x0149). Please report as a decompilation issue!!! */
    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /* renamed from: read */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2350read(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super Integer> continuation) throws SSLException {
        C02051 c02051;
        ByteBuffer byteBuffer2;
        TimeUnit timeUnit2;
        C02051 c020512;
        long j2;
        ByteBuffer byteBuffer3;
        long j3;
        TimeUnit timeUnit3;
        if (continuation instanceof C02051) {
            c02051 = (C02051) continuation;
            int i = c02051.f2204label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02051.f2204label = i - Integer.MIN_VALUE;
            } else {
                c02051 = new C02051(continuation);
            }
        }
        Object obj = c02051.f2205result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02051.f2204label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.appIn.flip();
            if (this.appIn.hasRemaining()) {
                int iMin = Math.min(byteBuffer.remaining(), this.appIn.remaining());
                int iLimit = this.appIn.limit();
                ByteBuffer byteBuffer4 = this.appIn;
                byteBuffer4.limit(byteBuffer4.position() + iMin);
                byteBuffer.put(this.appIn);
                this.appIn.limit(iLimit);
                this.appIn.compact();
                return C1207Boxing.m6121boxInt(iMin);
            }
            byteBuffer2 = byteBuffer;
            this.appIn.compact();
            timeUnit2 = timeUnit;
            c020512 = c02051;
            j2 = j;
            if (this.netIn.hasRemaining()) {
            }
        } else if (i2 == 1) {
            j3 = c02051.f2200J$0;
            timeUnit3 = (TimeUnit) c02051.f2202L$1;
            byteBuffer3 = (ByteBuffer) c02051.f2201L$0;
            ResultKt.throwOnFailure(obj);
            if (((Number) obj).intValue() >= 0) {
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j4 = c02051.f2200J$0;
            TimeUnit timeUnit4 = (TimeUnit) c02051.f2202L$1;
            ByteBuffer byteBuffer5 = (ByteBuffer) c02051.f2201L$0;
            ResultKt.throwOnFailure(obj);
            c020512 = c02051;
            timeUnit2 = timeUnit4;
            byteBuffer2 = byteBuffer5;
            if (((Number) obj).intValue() >= 0) {
                return C1207Boxing.m6121boxInt(-1);
            }
            this.netIn.flip();
            j2 = j4;
            if (this.netIn.hasRemaining()) {
                this.netIn.clear();
                TransportChannel transportChannel = this.net;
                ByteBuffer byteBuffer6 = this.netIn;
                c020512.f2201L$0 = byteBuffer2;
                c020512.f2202L$1 = timeUnit2;
                c020512.f2203L$2 = null;
                c020512.f2200J$0 = j2;
                c020512.f2204label = 1;
                Object objMo2350read = transportChannel.mo2350read(byteBuffer6, j2, timeUnit2, c020512);
                if (objMo2350read == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteBuffer3 = byteBuffer2;
                timeUnit3 = timeUnit2;
                long j5 = j2;
                obj = objMo2350read;
                j3 = j5;
                c02051 = c020512;
                if (((Number) obj).intValue() >= 0) {
                    return C1207Boxing.m6121boxInt(-1);
                }
                this.netIn.flip();
                long j6 = j3;
                C02051 c020513 = c02051;
                TimeUnit timeUnit5 = timeUnit3;
                j2 = j6;
                byteBuffer2 = byteBuffer3;
                SSLEngineResult sSLEngineResultUnwrap = this.engine.unwrap(this.netIn, this.appIn);
                SSLEngineResult.Status status = sSLEngineResultUnwrap.getStatus();
                int i3 = status != null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
                if (i3 == 1) {
                    if (this.appIn.position() > 0) {
                        this.appIn.flip();
                        int iMin2 = Math.min(byteBuffer2.remaining(), this.appIn.remaining());
                        int iLimit2 = this.appIn.limit();
                        ByteBuffer byteBuffer7 = this.appIn;
                        byteBuffer7.limit(byteBuffer7.position() + iMin2);
                        byteBuffer2.put(this.appIn);
                        this.appIn.limit(iLimit2);
                        this.appIn.compact();
                        return C1207Boxing.m6121boxInt(iMin2);
                    }
                    timeUnit2 = timeUnit5;
                    c020512 = c020513;
                } else if (i3 == 2) {
                    this.appIn = m2353enlarge(this.appIn, this.engine.getSession().getApplicationBufferSize());
                    timeUnit2 = timeUnit5;
                    c020512 = c020513;
                } else {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return C1207Boxing.m6121boxInt(-1);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    this.netIn.compact();
                    TransportChannel transportChannel2 = this.net;
                    ByteBuffer byteBuffer8 = this.netIn;
                    c020513.f2201L$0 = byteBuffer2;
                    c020513.f2202L$1 = timeUnit5;
                    c020513.f2203L$2 = SpillingKt.nullOutSpilledVariable(sSLEngineResultUnwrap);
                    c020513.f2200J$0 = j2;
                    c020513.f2204label = 2;
                    Object objMo2350read2 = transportChannel2.mo2350read(byteBuffer8, j2, timeUnit5, c020513);
                    if (objMo2350read2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    timeUnit2 = timeUnit5;
                    c020512 = c020513;
                    j4 = j2;
                    obj = objMo2350read2;
                    if (((Number) obj).intValue() >= 0) {
                    }
                }
                if (this.netIn.hasRemaining()) {
                    timeUnit5 = timeUnit2;
                    c020513 = c020512;
                    SSLEngineResult sSLEngineResultUnwrap2 = this.engine.unwrap(this.netIn, this.appIn);
                    SSLEngineResult.Status status2 = sSLEngineResultUnwrap2.getStatus();
                    if (status2 != null) {
                    }
                    if (i3 == 1) {
                    }
                    if (this.netIn.hasRemaining()) {
                    }
                }
            }
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
    public Object readExactly(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super C1133Unit> continuation) throws SSLException, EOFException {
        C02061 c02061;
        ByteBuffer byteBuffer2;
        long j2;
        C02061 c020612;
        TimeUnit timeUnit2;
        if (continuation instanceof C02061) {
            c02061 = (C02061) continuation;
            int i = c02061.f2210label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02061.f2210label = i - Integer.MIN_VALUE;
            } else {
                c02061 = new C02061(continuation);
            }
        }
        Object obj = c02061.f2211result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02061.f2210label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteBuffer2 = byteBuffer;
            j2 = j;
            c020612 = c02061;
            timeUnit2 = timeUnit;
            if (byteBuffer2.hasRemaining()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c02061.f2207J$0;
            TimeUnit timeUnit3 = (TimeUnit) c02061.f2209L$1;
            ByteBuffer byteBuffer3 = (ByteBuffer) c02061.f2208L$0;
            ResultKt.throwOnFailure(obj);
            c020612 = c02061;
            j2 = j3;
            timeUnit2 = timeUnit3;
            if (((Number) obj).intValue() < 0) {
                byteBuffer2 = byteBuffer3;
                if (byteBuffer2.hasRemaining()) {
                    return C1133Unit.INSTANCE;
                }
                c020612.f2208L$0 = byteBuffer2;
                c020612.f2209L$1 = timeUnit2;
                c020612.f2207J$0 = j2;
                c020612.f2210label = 1;
                Object objMo2350read = mo2350read(byteBuffer2, j2, timeUnit2, c020612);
                if (objMo2350read == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteBuffer3 = byteBuffer2;
                obj = objMo2350read;
                if (((Number) obj).intValue() < 0) {
                    throw new EOFException("EOF while TLS readExactly");
                }
            }
        }
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public Object shutdownInput(Continuation<? super C1133Unit> continuation) {
        return this.net.shutdownInput(continuation);
    }

    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    public Object shutdownOutput(Continuation<? super C1133Unit> continuation) {
        return this.net.shutdownOutput(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.flyfishxu.p028kadb.transport.TransportChannel
    /* renamed from: write */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2351write(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super Integer> continuation) throws SSLException {
        C02071 c02071;
        SSLEngineResult sSLEngineResultWrap;
        int iBytesConsumed;
        if (continuation instanceof C02071) {
            c02071 = (C02071) continuation;
            int i = c02071.f2217label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02071.f2217label = i - Integer.MIN_VALUE;
            } else {
                c02071 = new C02071(continuation);
            }
        }
        C02071 c020712 = c02071;
        Object objMo2351write = c020712.f2218result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c020712.f2217label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo2351write);
            this.netOut.clear();
            sSLEngineResultWrap = this.engine.wrap(byteBuffer, this.netOut);
            SSLEngineResult.Status status = sSLEngineResultWrap.getStatus();
            iBytesConsumed = -1;
            int i3 = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i3 == 1) {
                this.netOut.flip();
                while (this.netOut.hasRemaining()) {
                }
                iBytesConsumed = sSLEngineResultWrap.bytesConsumed();
            } else {
                if (i3 == 2) {
                    this.netOut = m2353enlarge(this.netOut, this.engine.getSession().getPacketBufferSize());
                    c020712.f2214L$0 = SpillingKt.nullOutSpilledVariable(byteBuffer);
                    c020712.f2215L$1 = SpillingKt.nullOutSpilledVariable(timeUnit);
                    c020712.f2216L$2 = SpillingKt.nullOutSpilledVariable(sSLEngineResultWrap);
                    c020712.f2213J$0 = j;
                    c020712.f2217label = 2;
                    objMo2351write = mo2351write(byteBuffer, j, timeUnit, c020712);
                    return objMo2351write == coroutine_suspended ? coroutine_suspended : objMo2351write;
                }
                if (i3 == 3) {
                    throw new IllegalStateException("wrap BUFFER_UNDERFLOW should not happen");
                }
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objMo2351write);
            }
            long j2 = c020712.f2213J$0;
            SSLEngineResult sSLEngineResult = (SSLEngineResult) c020712.f2216L$2;
            timeUnit = (TimeUnit) c020712.f2215L$1;
            ByteBuffer byteBuffer2 = (ByteBuffer) c020712.f2214L$0;
            ResultKt.throwOnFailure(objMo2351write);
            sSLEngineResultWrap = sSLEngineResult;
            j = j2;
            byteBuffer = byteBuffer2;
            while (this.netOut.hasRemaining()) {
                TransportChannel transportChannel = this.net;
                ByteBuffer byteBuffer3 = this.netOut;
                c020712.f2214L$0 = SpillingKt.nullOutSpilledVariable(byteBuffer);
                c020712.f2215L$1 = timeUnit;
                c020712.f2216L$2 = sSLEngineResultWrap;
                c020712.f2213J$0 = j;
                c020712.f2217label = 1;
                if (transportChannel.writeExactly(byteBuffer3, j, timeUnit, c020712) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            iBytesConsumed = sSLEngineResultWrap.bytesConsumed();
        }
        return C1207Boxing.m6121boxInt(iBytesConsumed);
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
        C02081 c02081;
        ByteBuffer byteBuffer2;
        long j2;
        C02081 c020812;
        TimeUnit timeUnit2;
        if (continuation instanceof C02081) {
            c02081 = (C02081) continuation;
            int i = c02081.f2223label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02081.f2223label = i - Integer.MIN_VALUE;
            } else {
                c02081 = new C02081(continuation);
            }
        }
        Object obj = c02081.f2224result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02081.f2223label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteBuffer2 = byteBuffer;
            j2 = j;
            c020812 = c02081;
            timeUnit2 = timeUnit;
            if (byteBuffer2.hasRemaining()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c02081.f2220J$0;
            TimeUnit timeUnit3 = (TimeUnit) c02081.f2222L$1;
            ByteBuffer byteBuffer3 = (ByteBuffer) c02081.f2221L$0;
            ResultKt.throwOnFailure(obj);
            c020812 = c02081;
            j2 = j3;
            timeUnit2 = timeUnit3;
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue < 0) {
                byteBuffer2 = byteBuffer3;
                if (byteBuffer2.hasRemaining()) {
                    return C1133Unit.INSTANCE;
                }
                c020812.f2221L$0 = byteBuffer2;
                c020812.f2222L$1 = timeUnit2;
                c020812.f2220J$0 = j2;
                c020812.f2223label = 1;
                Object objMo2351write = mo2351write(byteBuffer2, j2, timeUnit2, c020812);
                if (objMo2351write == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteBuffer3 = byteBuffer2;
                obj = objMo2351write;
                int iIntValue2 = ((Number) obj).intValue();
                if (iIntValue2 < 0) {
                    throw new IOException("TLS write returned " + iIntValue2);
                }
            }
        }
    }
}
