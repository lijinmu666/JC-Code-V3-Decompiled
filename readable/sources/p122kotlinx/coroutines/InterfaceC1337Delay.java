package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@InternalCoroutinesApi
@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/Delay;", BuildConfig.f24315FLAVOR, "delay", BuildConfig.f24315FLAVOR, "time", BuildConfig.f24315FLAVOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "context", "Lkotlin/coroutines/CoroutineContext;", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,159:1\n433#2,10:160\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay\n*L\n27#1:160,10\n*E\n"})
/* renamed from: kotlinx.coroutines.Delay */
/* loaded from: classes.dex */
public interface InterfaceC1337Delay {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.Delay$DefaultImpls */
    public static final class DefaultImpls {
        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated without replacement as an internal method never intended for public use")
        @Deprecated
        /* renamed from: delay */
        public static Object m6971delay(InterfaceC1337Delay interfaceC1337Delay, long j, Continuation<? super C1133Unit> continuation) {
            return InterfaceC1337Delay.super.mo6970delay(j, continuation);
        }

        @Deprecated
        public static DisposableHandle invokeOnTimeout(InterfaceC1337Delay interfaceC1337Delay, long j, Runnable runnable, CoroutineContext coroutineContext) {
            return InterfaceC1337Delay.super.invokeOnTimeout(j, runnable, coroutineContext);
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated without replacement as an internal method never intended for public use")
    static /* synthetic */ Object delay$suspendImpl(InterfaceC1337Delay interfaceC1337Delay, long j, Continuation<? super C1133Unit> continuation) {
        if (j <= 0) {
            return C1133Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        interfaceC1337Delay.mo20044scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated without replacement as an internal method never intended for public use")
    /* renamed from: delay */
    default Object mo6970delay(long j, Continuation<? super C1133Unit> continuation) {
        return delay$suspendImpl(this, j, continuation);
    }

    default DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(timeMillis, block, context);
    }

    /* renamed from: scheduleResumeAfterDelay */
    void mo20044scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super C1133Unit> continuation);
}
