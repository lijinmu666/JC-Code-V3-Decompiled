package p132okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0013J\u0017\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\rH\u0014J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aJ%\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0001J\u0012\u0010#\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, m4988d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "<init>", "()V", "state", BuildConfig.f24315FLAVOR, "index", "value", BuildConfig.f24315FLAVOR, "timeoutAt", "getTimeoutAt$okio", "()J", "enter", BuildConfig.f24315FLAVOR, "exit", BuildConfig.f24315FLAVOR, "cancel", "remainingNanos", "now", "remainingNanos$okio", "setTimeoutAt", "setTimeoutAt$okio", "timedOut", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "newTimeoutException", "Watchdog", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,514:1\n1#2:515\n*E\n"})
/* loaded from: classes.dex */
public class AsyncTimeout extends C5065Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static AsyncTimeout idleSentinel;

    /* renamed from: lock */
    private static final ReentrantLock f17767lock;

    @JvmField
    public int index = -1;
    private int state;
    private long timeoutAt;
    private static final Companion Companion = new Companion(null);

    /* renamed from: queue */
    private static final PriorityQueue f17768queue = new PriorityQueue();

    @Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, m4988d2 = {"Lokio/AsyncTimeout$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "queue", "Lokio/PriorityQueue;", "getQueue", "()Lokio/PriorityQueue;", "idleSentinel", "Lokio/AsyncTimeout;", "getIdleSentinel", "()Lokio/AsyncTimeout;", "setIdleSentinel", "(Lokio/AsyncTimeout;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "TIMEOUT_WRITE_SIZE", BuildConfig.f24315FLAVOR, "IDLE_TIMEOUT_MILLIS", BuildConfig.f24315FLAVOR, "IDLE_TIMEOUT_NANOS", "STATE_IDLE", "STATE_IN_QUEUE", "STATE_TIMED_OUT", "STATE_CANCELED", "insertIntoQueue", BuildConfig.f24315FLAVOR, "node", "awaitTimeout", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void insertIntoQueue(AsyncTimeout node) {
            if (getIdleSentinel() == null) {
                setIdleSentinel(new AsyncTimeout());
                new Watchdog().start();
            }
            AsyncTimeout.setTimeoutAt$okio$default(node, 0L, 1, null);
            getQueue().m14376add(node);
            if (node.index == 1) {
                getCondition().signal();
            }
        }

        public final AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout asyncTimeoutM14377first = getQueue().m14377first();
            if (asyncTimeoutM14377first == null) {
                long jNanoTime = System.nanoTime();
                getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if (getQueue().m14377first() != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return getIdleSentinel();
            }
            long jRemainingNanos$okio = asyncTimeoutM14377first.remainingNanos$okio(System.nanoTime());
            if (jRemainingNanos$okio > 0) {
                getCondition().await(jRemainingNanos$okio, TimeUnit.NANOSECONDS);
                return null;
            }
            getQueue().m14378remove(asyncTimeoutM14377first);
            asyncTimeoutM14377first.state = 2;
            return asyncTimeoutM14377first;
        }

        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        public final AsyncTimeout getIdleSentinel() {
            return AsyncTimeout.idleSentinel;
        }

        /* renamed from: getLock */
        public final ReentrantLock m14190getLock() {
            return AsyncTimeout.f17767lock;
        }

        public final PriorityQueue getQueue() {
            return AsyncTimeout.f17768queue;
        }

        public final void setIdleSentinel(AsyncTimeout asyncTimeout) {
            AsyncTimeout.idleSentinel = asyncTimeout;
        }

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m4988d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "<init>", "()V", "run", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockM14190getLock;
            AsyncTimeout asyncTimeoutAwaitTimeout;
            while (true) {
                try {
                    reentrantLockM14190getLock = AsyncTimeout.Companion.m14190getLock();
                    reentrantLockM14190getLock.lock();
                    try {
                        asyncTimeoutAwaitTimeout = AsyncTimeout.Companion.awaitTimeout();
                    } finally {
                        reentrantLockM14190getLock.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (asyncTimeoutAwaitTimeout == AsyncTimeout.Companion.getIdleSentinel()) {
                    AsyncTimeout.Companion.setIdleSentinel(null);
                    return;
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                reentrantLockM14190getLock.unlock();
                if (asyncTimeoutAwaitTimeout != null) {
                    asyncTimeoutAwaitTimeout.timedOut();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f17767lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        condition = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static /* synthetic */ void setTimeoutAt$okio$default(AsyncTimeout asyncTimeout, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTimeoutAt");
        }
        if ((i & 1) != 0) {
            j = System.nanoTime();
        }
        asyncTimeout.setTimeoutAt$okio(j);
    }

    @PublishedApi
    public final IOException access$newTimeoutException(IOException cause) {
        return newTimeoutException(cause);
    }

    @Override // p132okio.C5065Timeout
    /* renamed from: cancel */
    public void mo14185cancel() {
        super.mo14185cancel();
        ReentrantLock reentrantLock = f17767lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                f17768queue.m14378remove(this);
                this.state = 3;
            }
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: enter */
    public final void m14186enter() {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            ReentrantLock reentrantLock = f17767lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                Companion.insertIntoQueue(this);
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* renamed from: exit */
    public final boolean m14187exit() {
        ReentrantLock reentrantLock = f17767lock;
        reentrantLock.lock();
        try {
            int i = this.state;
            this.state = 0;
            if (i != 1) {
                return i == 2;
            }
            f17768queue.m14378remove(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: getTimeoutAt$okio, reason: from getter */
    public final long getTimeoutAt() {
        return this.timeoutAt;
    }

    public IOException newTimeoutException(IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    public final long remainingNanos$okio(long now) {
        return this.timeoutAt - now;
    }

    public final void setTimeoutAt$okio(long now) {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (getTimeoutNanos() != 0 && getHasDeadline()) {
            this.timeoutAt = now + Math.min(timeoutNanos, deadlineNanoTime() - now);
        } else if (timeoutNanos != 0) {
            this.timeoutAt = now + timeoutNanos;
        } else {
            if (!hasDeadline) {
                throw new AssertionError();
            }
            this.timeoutAt = deadlineNanoTime();
        }
    }

    /* renamed from: sink */
    public final InterfaceC5060Sink m14188sink(final InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new InterfaceC5060Sink() { // from class: okio.AsyncTimeout.sink.1
            @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                InterfaceC5060Sink interfaceC5060Sink = sink;
                asyncTimeout.m14186enter();
                try {
                    interfaceC5060Sink.close();
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    if (asyncTimeout.m14187exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.m14187exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.m14187exit();
                }
            }

            @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                InterfaceC5060Sink interfaceC5060Sink = sink;
                asyncTimeout.m14186enter();
                try {
                    interfaceC5060Sink.flush();
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    if (asyncTimeout.m14187exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.m14187exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.m14187exit();
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // p132okio.InterfaceC5060Sink
            /* renamed from: write */
            public void mo2303write(C5052Buffer source, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, byteCount);
                while (true) {
                    long j = 0;
                    if (byteCount <= 0) {
                        return;
                    }
                    C5059Segment c5059Segment = source.head;
                    Intrinsics.checkNotNull(c5059Segment);
                    while (true) {
                        if (j >= 65536) {
                            break;
                        }
                        j += c5059Segment.limit - c5059Segment.pos;
                        if (j >= byteCount) {
                            j = byteCount;
                            break;
                        } else {
                            c5059Segment = c5059Segment.next;
                            Intrinsics.checkNotNull(c5059Segment);
                        }
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    InterfaceC5060Sink interfaceC5060Sink = sink;
                    asyncTimeout.m14186enter();
                    try {
                        interfaceC5060Sink.mo2303write(source, j);
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        if (asyncTimeout.m14187exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                        byteCount -= j;
                    } catch (IOException e) {
                        if (!asyncTimeout.m14187exit()) {
                            throw e;
                        }
                        throw asyncTimeout.access$newTimeoutException(e);
                    } finally {
                        asyncTimeout.m14187exit();
                    }
                }
            }

            @Override // p132okio.InterfaceC5060Sink
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getF17772this$0() {
                return AsyncTimeout.this;
            }
        };
    }

    /* renamed from: source */
    public final InterfaceC5062Source m14189source(final InterfaceC5062Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new InterfaceC5062Source() { // from class: okio.AsyncTimeout.source.1
            @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                InterfaceC5062Source interfaceC5062Source = source;
                asyncTimeout.m14186enter();
                try {
                    interfaceC5062Source.close();
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    if (asyncTimeout.m14187exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.m14187exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.m14187exit();
                }
            }

            @Override // p132okio.InterfaceC5062Source
            /* renamed from: read */
            public long mo2305read(C5052Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                InterfaceC5062Source interfaceC5062Source = source;
                asyncTimeout.m14186enter();
                try {
                    long jMo2305read = interfaceC5062Source.mo2305read(sink, byteCount);
                    if (asyncTimeout.m14187exit()) {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                    return jMo2305read;
                } catch (IOException e) {
                    if (asyncTimeout.m14187exit()) {
                        throw asyncTimeout.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    asyncTimeout.m14187exit();
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override // p132okio.InterfaceC5062Source
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getF17774this$0() {
                return AsyncTimeout.this;
            }
        };
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(block, "block");
        m14186enter();
        try {
            try {
                T tMo4323invoke = block.mo4323invoke();
                InlineMarker.finallyStart(1);
                if (m14187exit()) {
                    throw access$newTimeoutException(null);
                }
                InlineMarker.finallyEnd(1);
                return tMo4323invoke;
            } catch (IOException e) {
                if (m14187exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            m14187exit();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
