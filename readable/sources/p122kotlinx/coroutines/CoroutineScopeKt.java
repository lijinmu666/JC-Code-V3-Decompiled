package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p122kotlinx.coroutines.internal.CoroutineScope;
import p122kotlinx.coroutines.internal.ScopeCoroutine;
import p122kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(m4987d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001aJ\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a!\u0010\u0013\u001a\u00020\u0014*\u00020\u00012\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017¢\u0006\u0002\u0010\u0018\u001a\u001e\u0010\u0013\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u001b\u001a\n\u0010\u001c\u001a\u00020\u0014*\u00020\u0001\u001a\u000e\u0010\u001d\u001a\u00020\u0003H\u0086H¢\u0006\u0002\u0010\u001e\"\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00018F¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u001f"}, m4988d2 = {"plus", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "isActive", BuildConfig.f24315FLAVOR, "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CoroutineScope", "cancel", BuildConfig.f24315FLAVOR, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;)V", "message", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "ensureActive", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CoroutineScopeKt {
    public static final CoroutineScope CoroutineScope(CoroutineContext coroutineContext) {
        if (coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE) == null) {
            coroutineContext = coroutineContext.mo6100plus(JobKt__JobKt.Job$default((InterfaceC1342Job) null, 1, (Object) null));
        }
        return new CoroutineScope(coroutineContext);
    }

    public static final CoroutineScope MainScope() {
        return new CoroutineScope(SupervisorKt.SupervisorJob$default((InterfaceC1342Job) null, 1, (Object) null).mo6100plus(Dispatchers.m6976getMain()));
    }

    /* renamed from: cancel */
    public static final void m6956cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineScope.getCoroutineContext().mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job != null) {
            interfaceC1342Job.mo6998cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        m6956cancel(coroutineScope, cancellationException);
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        if (objStartUndispatchedOrReturn == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objStartUndispatchedOrReturn;
    }

    public static final Object currentCoroutineContext(Continuation<? super CoroutineContext> continuation) {
        return continuation.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation<? super CoroutineContext> continuation) {
        InlineMarker.m6315mark(3);
        throw null;
    }

    public static final void ensureActive(CoroutineScope coroutineScope) {
        C1344JobKt.ensureActive(coroutineScope.getCoroutineContext());
    }

    public static final boolean isActive(CoroutineScope coroutineScope) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineScope.getCoroutineContext().mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job != null) {
            return interfaceC1342Job.isActive();
        }
        return true;
    }

    public static /* synthetic */ void isActive$annotations(CoroutineScope coroutineScope) {
    }

    /* renamed from: plus */
    public static final CoroutineScope m6957plus(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        return new CoroutineScope(coroutineScope.getCoroutineContext().mo6100plus(coroutineContext));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        m6955cancel(coroutineScope, str, th);
    }

    /* renamed from: cancel */
    public static final void m6955cancel(CoroutineScope coroutineScope, String str, Throwable th) {
        m6956cancel(coroutineScope, ExceptionsKt.CancellationException(str, th));
    }
}
