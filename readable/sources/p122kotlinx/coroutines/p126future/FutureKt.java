package p122kotlinx.coroutines.p126future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CancellableContinuationImpl;
import p122kotlinx.coroutines.CompletableDeferred;
import p122kotlinx.coroutines.CompletableDeferredKt;
import p122kotlinx.coroutines.CoroutineContextKt;
import p122kotlinx.coroutines.CoroutineExceptionHandlerKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineStart;
import p122kotlinx.coroutines.Deferred;
import p122kotlinx.coroutines.ExceptionsKt;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.JobKt__JobKt;
import p122kotlinx.coroutines.p126future.FutureKt;

@Metadata(m4987d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\r\u001aX\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011\u001a\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u000e\u001a\u0018\u0010\u0013\u001a\u00020\u0012*\u00020\u000e2\n\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0015\u001a\u001e\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, m4988d2 = {"future", "Ljava/util/concurrent/CompletableFuture;", "T", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "asCompletableFuture", "Lkotlinx/coroutines/Deferred;", BuildConfig.f24315FLAVOR, "setupCancellation", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,248:1\n1#2:249\n433#3,10:250\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n208#1:250,10\n*E\n"})
/* loaded from: classes.dex */
public final class FutureKt {
    public static final <T> CompletableFuture<T> asCompletableFuture(final Deferred<? extends T> deferred) {
        final CompletableFuture<T> completableFuture = new CompletableFuture<>();
        setupCancellation(deferred, completableFuture);
        deferred.invokeOnCompletion(new Function1() { // from class: o.NBLVO
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return FutureKt.asCompletableFuture$lambda$0(completableFuture, deferred, (Throwable) obj);
            }
        });
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit asCompletableFuture$lambda$0(CompletableFuture completableFuture, Deferred deferred, Throwable th) {
        try {
            completableFuture.complete(deferred.getCompleted());
        } catch (Throwable th2) {
            completableFuture.completeExceptionally(th2);
        }
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit asCompletableFuture$lambda$1(CompletableFuture completableFuture, Throwable th) {
        if (th == null) {
            completableFuture.complete(C1133Unit.INSTANCE);
        } else {
            completableFuture.completeExceptionally(th);
        }
        return C1133Unit.INSTANCE;
    }

    public static final <T> Deferred<T> asDeferred(CompletionStage<T> completionStage) {
        Throwable cause;
        CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (!completableFuture.isDone()) {
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            final Function2 function2 = new Function2() { // from class: o.SZKiB
                @Override // p094kotlin.p105jvm.functions.Function2
                /* renamed from: invoke */
                public final Object mo2167invoke(Object obj, Object obj2) {
                    return FutureKt.asDeferred$lambda$1(completableDeferredCompletableDeferred$default, obj, (Throwable) obj2);
                }
            };
            completionStage.handle(new BiFunction() { // from class: o.FPcN
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return function2.mo2167invoke(obj, (Throwable) obj2);
                }
            });
            JobKt__JobKt.invokeOnCompletion$default(completableDeferredCompletableDeferred$default, false, new CancelFutureOnCompletion(completableFuture), 1, null);
            return completableDeferredCompletableDeferred$default;
        }
        try {
            return CompletableDeferredKt.CompletableDeferred(completableFuture.get());
        } catch (Throwable th) {
            th = th;
            ExecutionException executionException = th instanceof ExecutionException ? (ExecutionException) th : null;
            if (executionException != null && (cause = executionException.getCause()) != null) {
                th = cause;
            }
            CompletableDeferred completableDeferredCompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            completableDeferredCompletableDeferred$default2.completeExceptionally(th);
            return completableDeferredCompletableDeferred$default2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object asDeferred$lambda$1(CompletableDeferred completableDeferred, Object obj, Throwable th) {
        boolean zCompleteExceptionally;
        Throwable cause;
        try {
            if (th == null) {
                zCompleteExceptionally = completableDeferred.complete(obj);
            } else {
                CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
                if (completionException != null && (cause = completionException.getCause()) != null) {
                    th = cause;
                }
                zCompleteExceptionally = completableDeferred.completeExceptionally(th);
            }
            return Boolean.valueOf(zCompleteExceptionally);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th2);
            return C1133Unit.INSTANCE;
        }
    }

    /* renamed from: await */
    public static final <T> Object m7400await(CompletionStage<T> completionStage, Continuation<? super T> continuation) throws Throwable {
        final CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (completableFuture.isDone()) {
            try {
                return completableFuture.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final ContinuationHandler continuationHandler = new ContinuationHandler(cancellableContinuationImpl);
        completionStage.handle(continuationHandler);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, C1133Unit>() { // from class: kotlinx.coroutines.future.FutureKt$await$2$1
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ C1133Unit mo2237invoke(Throwable th) {
                invoke2(th);
                return C1133Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                completableFuture.cancel(false);
                continuationHandler.cont = null;
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* renamed from: future */
    public static final <T> CompletableFuture<T> m7401future(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (coroutineStart.m6962isLazy()) {
            throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
        }
        CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        CompletableFutureCoroutine completableFutureCoroutine = new CompletableFutureCoroutine(coroutineContextNewCoroutineContext, completableFuture);
        completableFuture.handle((BiFunction) completableFutureCoroutine);
        completableFutureCoroutine.m6900start(coroutineStart, completableFutureCoroutine, function2);
        return completableFuture;
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m7401future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    private static final void setupCancellation(final InterfaceC1342Job interfaceC1342Job, CompletableFuture<?> completableFuture) {
        final Function2 function2 = new Function2() { // from class: o.Abw
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return FutureKt.setupCancellation$lambda$0(interfaceC1342Job, obj, (Throwable) obj2);
            }
        };
        completableFuture.handle(new BiFunction() { // from class: o.fg
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return FutureKt.setupCancellation$lambda$1(function2, obj, (Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit setupCancellation$lambda$0(InterfaceC1342Job interfaceC1342Job, Object obj, Throwable th) {
        if (th != null) {
            CancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            if (CancellationException == null) {
                CancellationException = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", th);
            }
        }
        interfaceC1342Job.mo6998cancel(CancellationException);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit setupCancellation$lambda$1(Function2 function2, Object obj, Throwable th) {
        return (C1133Unit) function2.mo2167invoke(obj, th);
    }

    public static final CompletableFuture<C1133Unit> asCompletableFuture(InterfaceC1342Job interfaceC1342Job) {
        final CompletableFuture<C1133Unit> completableFuture = new CompletableFuture<>();
        setupCancellation(interfaceC1342Job, completableFuture);
        interfaceC1342Job.invokeOnCompletion(new Function1() { // from class: o.wfW
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return FutureKt.asCompletableFuture$lambda$1(completableFuture, (Throwable) obj);
            }
        });
        return completableFuture;
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m7402future(coroutineScope, interfaceC1342Job, coroutineStart, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a Job to coroutine builders breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: future */
    public static final <T> CompletableFuture<T> m7402future(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkNotNull(interfaceC1342Job, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return m7401future(coroutineScope, (CoroutineContext) interfaceC1342Job, coroutineStart, (Function2) function2);
    }
}
