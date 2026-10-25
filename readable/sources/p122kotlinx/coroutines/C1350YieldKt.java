package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p122kotlinx.coroutines.internal.DispatchedContinuation;
import p122kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m4988d2 = {"yield", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.YieldKt */
/* loaded from: classes.dex */
public final class C1350YieldKt {
    /* renamed from: yield */
    public static final Object m7037yield(Continuation<? super C1133Unit> continuation) {
        Object coroutine_suspended;
        CoroutineContext coroutineContext = continuation.getContext();
        C1344JobKt.ensureActive(coroutineContext);
        Continuation continuationIntercepted = IntrinsicsKt.intercepted(continuation);
        DispatchedContinuation dispatchedContinuation = continuationIntercepted instanceof DispatchedContinuation ? (DispatchedContinuation) continuationIntercepted : null;
        if (dispatchedContinuation == null) {
            coroutine_suspended = C1133Unit.INSTANCE;
        } else {
            if (DispatchedContinuationKt.safeIsDispatchNeeded(dispatchedContinuation.dispatcher, coroutineContext)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(coroutineContext, C1133Unit.INSTANCE);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext coroutineContextMo6100plus = coroutineContext.mo6100plus(yieldContext);
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(coroutineContextMo6100plus, c1133Unit);
                coroutine_suspended = (!yieldContext.dispatcherWasUnconfined || DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation)) ? IntrinsicsKt.getCOROUTINE_SUSPENDED() : c1133Unit;
            }
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : C1133Unit.INSTANCE;
    }
}
