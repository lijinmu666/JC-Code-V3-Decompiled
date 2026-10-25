package p132okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\u0019J&\u0010,\u001a\u00020+*\u00020\u00192\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b/H\u0082\bJ\r\u0010&\u001a\u00020\u0019H\u0007¢\u0006\u0002\b0J\r\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u00020\u00198\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010'\u001a\u00020(8\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010)¨\u00063"}, m4988d2 = {"Lokio/Pipe;", BuildConfig.f24315FLAVOR, "maxBufferSize", BuildConfig.f24315FLAVOR, "<init>", "(J)V", "getMaxBufferSize$okio", "()J", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", BuildConfig.f24315FLAVOR, "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "sink", "source", "Lokio/Source;", "()Lokio/Source;", "fold", BuildConfig.f24315FLAVOR, "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "-deprecated_sink", "-deprecated_source", "cancel", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Timeout.kt\nokio/Timeout\n*L\n1#1,262:1\n1#2:263\n302#3,26:264\n*S KotlinDebug\n*F\n+ 1 Pipe.kt\nokio/Pipe\n*L\n222#1:264,26\n*E\n"})
/* renamed from: okio.Pipe */
/* loaded from: classes.dex */
public final class C5056Pipe {
    private final C5052Buffer buffer = new C5052Buffer();
    private boolean canceled;
    private final Condition condition;
    private InterfaceC5060Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final InterfaceC5060Sink sink;
    private boolean sinkClosed;
    private final InterfaceC5062Source source;
    private boolean sourceClosed;

    public C5056Pipe(long j) {
        this.maxBufferSize = j;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        this.condition = conditionNewCondition;
        if (j >= 1) {
            this.sink = new InterfaceC5060Sink() { // from class: okio.Pipe.sink.1
                private final C5065Timeout timeout = new C5065Timeout();

                @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    ReentrantLock lock = C5056Pipe.this.getLock();
                    C5056Pipe c5056Pipe = C5056Pipe.this;
                    lock.lock();
                    try {
                        if (c5056Pipe.getSinkClosed()) {
                            lock.unlock();
                            return;
                        }
                        InterfaceC5060Sink foldedSink = c5056Pipe.getFoldedSink();
                        if (foldedSink == null) {
                            if (c5056Pipe.getSourceClosed() && c5056Pipe.getBuffer().m14225size() > 0) {
                                throw new IOException("source is closed");
                            }
                            c5056Pipe.setSinkClosed$okio(true);
                            c5056Pipe.getCondition().signalAll();
                            foldedSink = null;
                        }
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        lock.unlock();
                        if (foldedSink != null) {
                            C5056Pipe c5056Pipe2 = C5056Pipe.this;
                            C5065Timeout timeout = foldedSink.getTimeout();
                            C5065Timeout timeout2 = c5056Pipe2.m14374sink().getTimeout();
                            long timeoutNanos = timeout.getTimeoutNanos();
                            long jMinTimeout = C5065Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.mo14292timeout(jMinTimeout, timeUnit);
                            if (!timeout.getHasDeadline()) {
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink.close();
                                    timeout.mo14292timeout(timeoutNanos, timeUnit);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.mo14292timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long jDeadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.close();
                                timeout.mo14292timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.mo14292timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        lock.unlock();
                        throw th3;
                    }
                }

                @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
                public void flush() {
                    ReentrantLock lock = C5056Pipe.this.getLock();
                    C5056Pipe c5056Pipe = C5056Pipe.this;
                    lock.lock();
                    try {
                        if (c5056Pipe.getSinkClosed()) {
                            throw new IllegalStateException("closed");
                        }
                        if (c5056Pipe.getCanceled()) {
                            throw new IOException("canceled");
                        }
                        InterfaceC5060Sink foldedSink = c5056Pipe.getFoldedSink();
                        if (foldedSink == null) {
                            if (c5056Pipe.getSourceClosed() && c5056Pipe.getBuffer().m14225size() > 0) {
                                throw new IOException("source is closed");
                            }
                            foldedSink = null;
                        }
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        lock.unlock();
                        if (foldedSink != null) {
                            C5056Pipe c5056Pipe2 = C5056Pipe.this;
                            C5065Timeout timeout = foldedSink.getTimeout();
                            C5065Timeout timeout2 = c5056Pipe2.m14374sink().getTimeout();
                            long timeoutNanos = timeout.getTimeoutNanos();
                            long jMinTimeout = C5065Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.mo14292timeout(jMinTimeout, timeUnit);
                            if (!timeout.getHasDeadline()) {
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink.flush();
                                    timeout.mo14292timeout(timeoutNanos, timeUnit);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.mo14292timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long jDeadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.flush();
                                timeout.mo14292timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.mo14292timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(jDeadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        lock.unlock();
                        throw th3;
                    }
                }

                @Override // p132okio.InterfaceC5060Sink
                /* renamed from: timeout, reason: from getter */
                public C5065Timeout getTimeout() {
                    return this.timeout;
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
                
                    r1 = p094kotlin.C1133Unit.INSTANCE;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
                
                    r0.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
                
                    if (r2 == null) goto L57;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
                
                    r11 = r11.f17828this$0;
                    r0 = r2.getTimeout();
                    r11 = r11.m14374sink().getTimeout();
                    r3 = r0.getTimeoutNanos();
                    r5 = p132okio.C5065Timeout.INSTANCE.minTimeout(r11.getTimeoutNanos(), r0.getTimeoutNanos());
                    r1 = java.util.concurrent.TimeUnit.NANOSECONDS;
                    r0.mo14292timeout(r5, r1);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
                
                    if (r0.getHasDeadline() == false) goto L45;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
                
                    r5 = r0.deadlineNanoTime();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
                
                    if (r11.getHasDeadline() == false) goto L66;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
                
                    r0.deadlineNanoTime(java.lang.Math.min(r0.deadlineNanoTime(), r11.deadlineNanoTime()));
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
                
                    r2.mo2303write(r12, r13);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:37:0x00c6, code lost:
                
                    r0.mo14292timeout(r3, r1);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
                
                    if (r11.getHasDeadline() == false) goto L78;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
                
                    r0.deadlineNanoTime(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
                
                    r12 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
                
                    r0.mo14292timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
                
                    if (r11.getHasDeadline() != false) goto L43;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x00df, code lost:
                
                    r0.deadlineNanoTime(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:44:0x00e2, code lost:
                
                    throw r12;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
                
                    if (r11.getHasDeadline() == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
                
                    r0.deadlineNanoTime(r11.deadlineNanoTime());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x00f0, code lost:
                
                    r2.mo2303write(r12, r13);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
                
                    r0.mo14292timeout(r3, r1);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x00fa, code lost:
                
                    if (r11.getHasDeadline() == false) goto L80;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x00fc, code lost:
                
                    r0.clearDeadline();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x0100, code lost:
                
                    r12 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x0101, code lost:
                
                    r0.mo14292timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x010a, code lost:
                
                    if (r11.getHasDeadline() != false) goto L55;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:55:0x010c, code lost:
                
                    r0.clearDeadline();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:56:0x010f, code lost:
                
                    throw r12;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x0110, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
                
                    return;
                 */
                @Override // p132okio.InterfaceC5060Sink
                /* renamed from: write */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void mo2303write(C5052Buffer source, long byteCount) {
                    InterfaceC5060Sink foldedSink;
                    Intrinsics.checkNotNullParameter(source, "source");
                    ReentrantLock lock = C5056Pipe.this.getLock();
                    C5056Pipe c5056Pipe = C5056Pipe.this;
                    lock.lock();
                    try {
                        if (c5056Pipe.getSinkClosed()) {
                            throw new IllegalStateException("closed");
                        }
                        if (!c5056Pipe.getCanceled()) {
                            while (true) {
                                if (byteCount <= 0) {
                                    foldedSink = null;
                                    break;
                                }
                                foldedSink = c5056Pipe.getFoldedSink();
                                if (foldedSink != null) {
                                    break;
                                }
                                if (c5056Pipe.getSourceClosed()) {
                                    throw new IOException("source is closed");
                                }
                                long maxBufferSize = c5056Pipe.getMaxBufferSize() - c5056Pipe.getBuffer().m14225size();
                                if (maxBufferSize == 0) {
                                    this.timeout.awaitSignal(c5056Pipe.getCondition());
                                    if (c5056Pipe.getCanceled()) {
                                        throw new IOException("canceled");
                                    }
                                } else {
                                    long jMin = Math.min(maxBufferSize, byteCount);
                                    c5056Pipe.getBuffer().mo2303write(source, jMin);
                                    byteCount -= jMin;
                                    c5056Pipe.getCondition().signalAll();
                                }
                            }
                        } else {
                            throw new IOException("canceled");
                        }
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                }
            };
            this.source = new InterfaceC5062Source() { // from class: okio.Pipe.source.1
                private final C5065Timeout timeout = new C5065Timeout();

                @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    ReentrantLock lock = C5056Pipe.this.getLock();
                    C5056Pipe c5056Pipe = C5056Pipe.this;
                    lock.lock();
                    try {
                        c5056Pipe.setSourceClosed$okio(true);
                        c5056Pipe.getCondition().signalAll();
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    } finally {
                        lock.unlock();
                    }
                }

                @Override // p132okio.InterfaceC5062Source
                /* renamed from: read */
                public long mo2305read(C5052Buffer sink, long byteCount) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    ReentrantLock lock = C5056Pipe.this.getLock();
                    C5056Pipe c5056Pipe = C5056Pipe.this;
                    lock.lock();
                    try {
                        if (c5056Pipe.getSourceClosed()) {
                            throw new IllegalStateException("closed");
                        }
                        if (c5056Pipe.getCanceled()) {
                            throw new IOException("canceled");
                        }
                        while (c5056Pipe.getBuffer().m14225size() == 0) {
                            if (c5056Pipe.getSinkClosed()) {
                                lock.unlock();
                                return -1L;
                            }
                            this.timeout.awaitSignal(c5056Pipe.getCondition());
                            if (c5056Pipe.getCanceled()) {
                                throw new IOException("canceled");
                            }
                        }
                        long jMo2305read = c5056Pipe.getBuffer().mo2305read(sink, byteCount);
                        c5056Pipe.getCondition().signalAll();
                        lock.unlock();
                        return jMo2305read;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                }

                @Override // p132okio.InterfaceC5062Source
                /* renamed from: timeout, reason: from getter */
                public C5065Timeout getTimeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
        }
    }

    /* renamed from: forward */
    private final void m14370forward(InterfaceC5060Sink interfaceC5060Sink, Function1<? super InterfaceC5060Sink, C1133Unit> function1) {
        C5065Timeout timeout = interfaceC5060Sink.getTimeout();
        C5065Timeout timeout2 = m14374sink().getTimeout();
        long timeoutNanos = timeout.getTimeoutNanos();
        long jMinTimeout = C5065Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.mo14292timeout(jMinTimeout, timeUnit);
        if (!timeout.getHasDeadline()) {
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.mo2237invoke(interfaceC5060Sink);
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                timeout.mo14292timeout(timeoutNanos, timeUnit);
                if (timeout2.getHasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                return;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout.mo14292timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.getHasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        long jDeadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.getHasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            function1.mo2237invoke(interfaceC5060Sink);
            C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            timeout.mo14292timeout(timeoutNanos, timeUnit);
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            timeout.mo14292timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_sink")
    /* renamed from: -deprecated_sink, reason: not valid java name and from getter */
    public final InterfaceC5060Sink getSink() {
        return this.sink;
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "source", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_source")
    /* renamed from: -deprecated_source, reason: not valid java name and from getter */
    public final InterfaceC5062Source getSource() {
        return this.source;
    }

    /* renamed from: cancel */
    public final void m14371cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.m14194clear();
            this.condition.signalAll();
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: fold */
    public final void m14372fold(InterfaceC5060Sink sink) {
        C5052Buffer c5052Buffer;
        boolean z;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            this.lock.lock();
            try {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                boolean z2 = this.sinkClosed;
                C5052Buffer c5052Buffer2 = null;
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    c5052Buffer = null;
                    z = true;
                } else {
                    c5052Buffer = new C5052Buffer();
                    C5052Buffer c5052Buffer3 = this.buffer;
                    c5052Buffer.mo2303write(c5052Buffer3, c5052Buffer3.m14225size());
                    this.condition.signalAll();
                    z = false;
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                if (z) {
                    if (z2) {
                        sink.close();
                        return;
                    }
                    return;
                }
                if (c5052Buffer == null) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("sinkBuffer");
                    } catch (Throwable th) {
                        ReentrantLock reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            this.sourceClosed = true;
                            this.condition.signalAll();
                            C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                            throw th;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                } else {
                    c5052Buffer2 = c5052Buffer;
                }
                sink.mo2303write(c5052Buffer2, c5052Buffer.m14225size());
                sink.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: getBuffer$okio, reason: from getter */
    public final C5052Buffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getCanceled$okio, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    /* renamed from: getFoldedSink$okio, reason: from getter */
    public final InterfaceC5060Sink getFoldedSink() {
        return this.foldedSink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    /* renamed from: getMaxBufferSize$okio, reason: from getter */
    public final long getMaxBufferSize() {
        return this.maxBufferSize;
    }

    /* renamed from: getSinkClosed$okio, reason: from getter */
    public final boolean getSinkClosed() {
        return this.sinkClosed;
    }

    /* renamed from: getSourceClosed$okio, reason: from getter */
    public final boolean getSourceClosed() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(InterfaceC5060Sink interfaceC5060Sink) {
        this.foldedSink = interfaceC5060Sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @InterfaceC1231JvmName(m6260name = "sink")
    /* renamed from: sink */
    public final InterfaceC5060Sink m14374sink() {
        return this.sink;
    }

    @InterfaceC1231JvmName(m6260name = "source")
    /* renamed from: source */
    public final InterfaceC5062Source m14375source() {
        return this.source;
    }
}
