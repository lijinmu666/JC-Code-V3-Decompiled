package com.flyfishxu.p028kadb.forwarding;

import com.flyfishxu.p028kadb.C0187Kadb;
import com.flyfishxu.p028kadb.forwarding.TcpForwarder;
import com.flyfishxu.p028kadb.p031debug.LoggingKt;
import com.flyfishxu.p028kadb.p036stream.AdbStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.concurrent.ThreadsKt;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.BufferedSink;
import p132okio.BufferedSource;
import p132okio.C5053Okio;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\"B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J&\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m4988d2 = {"Lcom/flyfishxu/kadb/forwarding/TcpForwarder;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "kadb", "Lcom/flyfishxu/kadb/Kadb;", "hostPort", BuildConfig.f24315FLAVOR, "targetPort", "<init>", "(Lcom/flyfishxu/kadb/Kadb;II)V", "state", "Lcom/flyfishxu/kadb/forwarding/TcpForwarder$State;", "serverThread", "Ljava/lang/Thread;", "server", "Ljava/net/ServerSocket;", "clientExecutor", "Ljava/util/concurrent/ExecutorService;", "start", BuildConfig.f24315FLAVOR, "handleForwarding", "close", "forward", "source", "Lokio/Source;", "sink", "Lokio/BufferedSink;", "moveToState", "waitFor", "intervalMs", "timeoutMs", "test", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "State", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nTcpForwarder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TcpForwarder.kt\ncom/flyfishxu/kadb/forwarding/TcpForwarder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1#2:174\n*E\n"})
/* loaded from: classes.dex */
public final class TcpForwarder implements AutoCloseable {
    private ExecutorService clientExecutor;
    private final int hostPort;
    private final C0187Kadb kadb;
    private ServerSocket server;
    private Thread serverThread;
    private EnumC0192State state;
    private final int targetPort;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m4988d2 = {"Lcom/flyfishxu/kadb/forwarding/TcpForwarder$State;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "STARTING", "STARTED", "STOPPING", "STOPPED", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.forwarding.TcpForwarder$State */
    public static final class EnumC0192State {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ EnumC0192State[] f2064$VALUES;
        public static final EnumC0192State STARTING = new EnumC0192State("STARTING", 0);

        /* renamed from: STARTED */
        public static final EnumC0192State f2065STARTED = new EnumC0192State("STARTED", 1);
        public static final EnumC0192State STOPPING = new EnumC0192State("STOPPING", 2);

        /* renamed from: STOPPED */
        public static final EnumC0192State f2066STOPPED = new EnumC0192State("STOPPED", 3);

        /* renamed from: $values */
        private static final /* synthetic */ EnumC0192State[] m2225$values() {
            return new EnumC0192State[]{STARTING, f2065STARTED, STOPPING, f2066STOPPED};
        }

        static {
            EnumC0192State[] enumC0192StateArrM2225$values = m2225$values();
            f2064$VALUES = enumC0192StateArrM2225$values;
            $ENTRIES = EnumEntriesKt.enumEntries(enumC0192StateArrM2225$values);
        }

        private EnumC0192State(String str, int i) {
        }

        public static EnumEntries<EnumC0192State> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static EnumC0192State m2226valueOf(String str) {
            return (EnumC0192State) Enum.valueOf(EnumC0192State.class, str);
        }

        /* renamed from: values */
        public static EnumC0192State[] m2227values() {
            return (EnumC0192State[]) f2064$VALUES.clone();
        }
    }

    public TcpForwarder(C0187Kadb kadb, int i, int i2) {
        Intrinsics.checkNotNullParameter(kadb, "kadb");
        this.kadb = kadb;
        this.hostPort = i;
        this.targetPort = i2;
        this.state = EnumC0192State.f2066STOPPED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean close$lambda$0(TcpForwarder tcpForwarder) {
        return tcpForwarder.state == EnumC0192State.f2065STARTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean close$lambda$1(TcpForwarder tcpForwarder) {
        return tcpForwarder.state == EnumC0192State.f2066STOPPED;
    }

    /* renamed from: forward */
    private final void m2219forward(InterfaceC5062Source source, BufferedSink sink) {
        while (!Thread.interrupted() && source.mo2305read(sink.getBuffer(), 256L) >= 0) {
            try {
                sink.flush();
            } catch (InterruptedIOException | IOException | InterruptedException unused) {
                return;
            }
        }
    }

    private final void handleForwarding() throws IOException {
        ServerSocket serverSocket = new ServerSocket(this.hostPort);
        this.server = serverSocket;
        moveToState(EnumC0192State.f2065STARTED);
        while (!Thread.interrupted()) {
            final Socket socketAccept = serverSocket.accept();
            ExecutorService executorService = this.clientExecutor;
            if (executorService != null) {
                executorService.execute(new Runnable() { // from class: o.J7
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        TcpForwarder.handleForwarding$lambda$0(this.f8882mjFkc, socketAccept);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleForwarding$lambda$0(final TcpForwarder tcpForwarder, final Socket socket) throws Throwable {
        Thread thread;
        AdbStream adbStream = null;
        Thread threadThread$default = null;
        try {
            final AdbStream adbStreamM2156open = tcpForwarder.kadb.m2156open("tcp:" + tcpForwarder.targetPort);
            try {
                threadThread$default = ThreadsKt.thread$default(false, false, null, null, 0, new Function0() { // from class: o.L7
                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public final Object mo4323invoke() {
                        return TcpForwarder.handleForwarding$lambda$0$0(this.f9392mjFkc, socket, adbStreamM2156open);
                    }
                }, 31, null);
                BufferedSource source = adbStreamM2156open.getSource();
                Intrinsics.checkNotNull(socket);
                tcpForwarder.m2219forward(source, C5053Okio.m14315buffer(C5053Okio.m14321sink(socket)));
                adbStreamM2156open.close();
                socket.close();
                if (threadThread$default != null) {
                    threadThread$default.interrupt();
                }
            } catch (Throwable th) {
                th = th;
                thread = threadThread$default;
                adbStream = adbStreamM2156open;
                if (adbStream != null) {
                    adbStream.close();
                }
                socket.close();
                if (thread != null) {
                    thread.interrupt();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            thread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit handleForwarding$lambda$0$0(TcpForwarder tcpForwarder, Socket socket, AdbStream adbStream) {
        try {
            InputStream inputStream = socket.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            tcpForwarder.m2219forward(C5053Okio.m14325source(inputStream), adbStream.getSink());
            adbStream.close();
            return C1133Unit.INSTANCE;
        } catch (Throwable th) {
            adbStream.close();
            throw th;
        }
    }

    private final void moveToState(EnumC0192State state) {
        this.state = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit start$lambda$1(TcpForwarder tcpForwarder) {
        try {
            try {
                tcpForwarder.handleForwarding();
            } catch (SocketException unused) {
            } catch (IOException e) {
                LoggingKt.m2214log(new Function0() { // from class: o.K7
                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public final Object mo4323invoke() {
                        return TcpForwarder.start$lambda$1$0(e);
                    }
                });
            }
            return C1133Unit.INSTANCE;
        } finally {
            tcpForwarder.moveToState(EnumC0192State.f2066STOPPED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String start$lambda$1$0(IOException iOException) {
        return "could not start TCP port forwarding: " + iOException.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean start$lambda$2(TcpForwarder tcpForwarder) {
        return tcpForwarder.state == EnumC0192State.f2065STARTED;
    }

    /* renamed from: waitFor */
    private final void m2222waitFor(int intervalMs, int timeoutMs, Function0<Boolean> test) throws InterruptedException, TimeoutException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = jCurrentTimeMillis;
        while (!test.mo4323invoke().booleanValue()) {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            long j = jCurrentTimeMillis3 - jCurrentTimeMillis;
            long j2 = jCurrentTimeMillis3 - jCurrentTimeMillis2;
            long j3 = timeoutMs;
            if (0 <= j3 && j3 <= j) {
                throw new TimeoutException();
            }
            long j4 = intervalMs - j2;
            if (j4 > 0) {
                Thread.sleep(j4);
            }
            jCurrentTimeMillis2 = System.currentTimeMillis();
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws InterruptedException, TimeoutException, IOException {
        EnumC0192State enumC0192State;
        EnumC0192State enumC0192State2 = this.state;
        if (enumC0192State2 == EnumC0192State.f2066STOPPED || enumC0192State2 == (enumC0192State = EnumC0192State.STOPPING)) {
            return;
        }
        m2222waitFor(10, 5000, new Function0() { // from class: o.M7
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return Boolean.valueOf(TcpForwarder.close$lambda$0(this.f9554mjFkc));
            }
        });
        moveToState(enumC0192State);
        ServerSocket serverSocket = this.server;
        if (serverSocket != null) {
            serverSocket.close();
        }
        this.server = null;
        Thread thread = this.serverThread;
        if (thread != null) {
            thread.interrupt();
        }
        this.serverThread = null;
        ExecutorService executorService = this.clientExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.clientExecutor;
        if (executorService2 != null) {
            executorService2.awaitTermination(5L, TimeUnit.SECONDS);
        }
        this.clientExecutor = null;
        m2222waitFor(10, 5000, new Function0() { // from class: o.N7
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return Boolean.valueOf(TcpForwarder.close$lambda$1(this.f9658mjFkc));
            }
        });
    }

    /* renamed from: start */
    public final void m2224start() {
        if (this.state == EnumC0192State.f2066STOPPED) {
            moveToState(EnumC0192State.STARTING);
            this.clientExecutor = Executors.newCachedThreadPool();
            this.serverThread = ThreadsKt.thread$default(false, false, null, null, 0, new Function0() { // from class: o.O7
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Object mo4323invoke() {
                    return TcpForwarder.start$lambda$1(this.f9917mjFkc);
                }
            }, 31, null);
            m2222waitFor(10, 5000, new Function0() { // from class: o.P7
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Object mo4323invoke() {
                    return Boolean.valueOf(TcpForwarder.start$lambda$2(this.f10035mjFkc));
                }
            });
            return;
        }
        throw new IllegalStateException(("Forwarder is already started at port " + this.hostPort).toString());
    }
}
