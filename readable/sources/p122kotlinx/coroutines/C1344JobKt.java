package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;

@Metadata(m4987d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, m4989k = 4, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.JobKt */
/* loaded from: classes.dex */
public final class C1344JobKt {
    /* renamed from: Job */
    public static final CompletableJob m7009Job(InterfaceC1342Job interfaceC1342Job) {
        return JobKt__JobKt.m7016Job(interfaceC1342Job);
    }

    public static final Object cancelAndJoin(InterfaceC1342Job interfaceC1342Job, Continuation<? super C1133Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(interfaceC1342Job, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "This function does not do what its name implies: it will not cancel the future if just cancel() was called.", replaceWith = @ReplaceWith(expression = "this.invokeOnCancellation { future.cancel(false) }", m5048imports = {}))
    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    public static final DisposableHandle disposeOnCompletion(InterfaceC1342Job interfaceC1342Job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(interfaceC1342Job, disposableHandle);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        JobKt__JobKt.ensureActive(coroutineContext);
    }

    /* renamed from: getJob */
    public static final InterfaceC1342Job m7015getJob(CoroutineContext coroutineContext) {
        return JobKt__JobKt.m7022getJob(coroutineContext);
    }

    public static final DisposableHandle invokeOnCompletion(InterfaceC1342Job interfaceC1342Job, boolean z, AbstractC1346JobNode abstractC1346JobNode) {
        return JobKt__JobKt.invokeOnCompletion(interfaceC1342Job, z, abstractC1346JobNode);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }

    /* renamed from: cancel */
    public static final void m7012cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.m7019cancel(coroutineContext, cancellationException);
    }

    public static final void ensureActive(InterfaceC1342Job interfaceC1342Job) {
        JobKt__JobKt.ensureActive(interfaceC1342Job);
    }

    /* renamed from: cancel */
    public static final void m7013cancel(InterfaceC1342Job interfaceC1342Job, String str, Throwable th) {
        JobKt__JobKt.m7020cancel(interfaceC1342Job, str, th);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(InterfaceC1342Job interfaceC1342Job, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(interfaceC1342Job, cancellationException);
    }
}
