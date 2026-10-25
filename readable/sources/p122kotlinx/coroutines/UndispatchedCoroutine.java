package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.TuplesKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.ContinuationInterceptor;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.internal.ScopeCoroutine;
import p122kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m4988d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", BuildConfig.f24315FLAVOR, "threadLocalIsSet", BuildConfig.f24315FLAVOR, "saveThreadContext", BuildConfig.f24315FLAVOR, "oldValue", "clearThreadContext", "afterCompletionUndispatched", "afterResume", "state", "clearThreadLocal", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,331:1\n115#2,13:332\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n277#1:332,13\n*E\n"})
/* loaded from: classes.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<C1122Pair<CoroutineContext, Object>> threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.INSTANCE;
        super(coroutineContext.mo6098get(undispatchedMarker) == null ? coroutineContext.mo6100plus(undispatchedMarker) : coroutineContext, continuation);
        this.threadStateToRecover = new ThreadLocal<>();
        if (continuation.getContext().mo6098get(ContinuationInterceptor.INSTANCE) instanceof CoroutineDispatcher) {
            return;
        }
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
        ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
        saveThreadContext(coroutineContext, objUpdateThreadContext);
    }

    private final void clearThreadLocal() {
        if (this.threadLocalIsSet) {
            C1122Pair<CoroutineContext, Object> c1122Pair = this.threadStateToRecover.get();
            if (c1122Pair != null) {
                ThreadContextKt.restoreThreadContext(c1122Pair.component1(), c1122Pair.component2());
            }
            this.threadStateToRecover.remove();
        }
    }

    @Override // p122kotlinx.coroutines.internal.ScopeCoroutine
    public void afterCompletionUndispatched() {
        clearThreadLocal();
    }

    @Override // p122kotlinx.coroutines.internal.ScopeCoroutine, p122kotlinx.coroutines.AbstractCoroutine
    public void afterResume(Object state) {
        clearThreadLocal();
        Object objRecoverResult = CompletionStateKt.recoverResult(state, this.uCont);
        Continuation<T> continuation = this.uCont;
        CoroutineContext coroutineContext = continuation.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
        UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation, coroutineContext, objUpdateThreadContext) : null;
        try {
            this.uCont.resumeWith(objRecoverResult);
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        } finally {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            }
        }
    }

    public final boolean clearThreadContext() {
        boolean z = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z;
    }

    public final void saveThreadContext(CoroutineContext context, Object oldValue) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(TuplesKt.m5076to(context, oldValue));
    }
}
