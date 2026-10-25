package p132okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0001H\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001c\u0010\u0002\u001a\u00020\u00018\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u001a"}, m4988d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "<init>", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "timeout", BuildConfig.f24315FLAVOR, "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "hasDeadline", BuildConfig.f24315FLAVOR, "deadlineNanoTime", "clearTimeout", "clearDeadline", "throwIfReached", BuildConfig.f24315FLAVOR, "cancel", "awaitSignal", "condition", "Ljava/util/concurrent/locks/Condition;", "waitUntilNotified", "monitor", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public class ForwardingTimeout extends C5065Timeout {
    private C5065Timeout delegate;

    public ForwardingTimeout(C5065Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // p132okio.C5065Timeout
    public void awaitSignal(Condition condition) throws InterruptedException, InterruptedIOException {
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.delegate.awaitSignal(condition);
    }

    @Override // p132okio.C5065Timeout
    /* renamed from: cancel */
    public void mo14185cancel() {
        this.delegate.mo14185cancel();
    }

    @Override // p132okio.C5065Timeout
    public C5065Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // p132okio.C5065Timeout
    public C5065Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // p132okio.C5065Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @InterfaceC1231JvmName(m6260name = "delegate")
    /* renamed from: delegate, reason: from getter */
    public final C5065Timeout getDelegate() {
        return this.delegate;
    }

    @Override // p132okio.C5065Timeout
    /* renamed from: hasDeadline */
    public boolean getHasDeadline() {
        return this.delegate.getHasDeadline();
    }

    /* renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m20070setDelegate(C5065Timeout c5065Timeout) {
        Intrinsics.checkNotNullParameter(c5065Timeout, "<set-?>");
        this.delegate = c5065Timeout;
    }

    @Override // p132okio.C5065Timeout
    public void throwIfReached() throws InterruptedIOException {
        this.delegate.throwIfReached();
    }

    @Override // p132okio.C5065Timeout
    /* renamed from: timeout */
    public C5065Timeout mo14292timeout(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.delegate.mo14292timeout(timeout, unit);
    }

    @Override // p132okio.C5065Timeout
    /* renamed from: timeoutNanos */
    public long getTimeoutNanos() {
        return this.delegate.getTimeoutNanos();
    }

    @Override // p132okio.C5065Timeout
    public void waitUntilNotified(Object monitor) throws InterruptedException, InterruptedIOException {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        this.delegate.waitUntilNotified(monitor);
    }

    @Override // p132okio.C5065Timeout
    public C5065Timeout deadlineNanoTime(long deadlineNanoTime) {
        return this.delegate.deadlineNanoTime(deadlineNanoTime);
    }

    public final ForwardingTimeout setDelegate(C5065Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }
}
