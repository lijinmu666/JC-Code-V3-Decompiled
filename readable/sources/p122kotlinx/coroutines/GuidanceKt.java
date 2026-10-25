package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001aL\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u000e\u001aL\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0010\u001aV\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0014\u001aX\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0015\u001aX\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, m4988d2 = {"launch", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/NonCancellable;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/NonCancellable;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "async", "Lkotlinx/coroutines/Deferred;", "T", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/NonCancellable;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class GuidanceKt {
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "'async' can not be called without the corresponding coroutine scope. Consider wrapping 'async' in 'coroutineScope { }', using 'runBlocking { }', or using some other 'CoroutineScope'")
    @LowPriorityInOverloadResolution
    /* renamed from: async */
    public static final <T> Deferred<T> m6990async(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        throw new UnsupportedOperationException("Should never be called, was introduced to help with incomplete code");
    }

    public static /* synthetic */ Deferred async$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m6990async(coroutineContext, coroutineStart, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "'launch' can not be called without the corresponding coroutine scope. Consider wrapping 'launch' in 'coroutineScope { }', using 'runBlocking { }', or using some other 'CoroutineScope'")
    @LowPriorityInOverloadResolution
    /* renamed from: launch */
    public static final InterfaceC1342Job m6993launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        throw new UnsupportedOperationException("Should never be called, was introduced to help with incomplete code");
    }

    public static /* synthetic */ InterfaceC1342Job launch$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m6993launch(coroutineContext, coroutineStart, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a Job to coroutine builders breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: async */
    public static final <T> Deferred<T> m6991async(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkNotNull(interfaceC1342Job, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return BuildersKt.m6908async(coroutineScope, interfaceC1342Job, coroutineStart, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a Job to coroutine builders breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: launch */
    public static final InterfaceC1342Job m6994launch(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNull(interfaceC1342Job, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return BuildersKt.m6910launch(coroutineScope, interfaceC1342Job, coroutineStart, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a NonCancellable to `async` breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: async */
    public static final <T> Deferred<T> m6992async(CoroutineScope coroutineScope, NonCancellable nonCancellable, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkNotNull(nonCancellable, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return BuildersKt.m6908async(coroutineScope, nonCancellable, coroutineStart, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a NonCancellable to `launch` breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: launch */
    public static final InterfaceC1342Job m6995launch(CoroutineScope coroutineScope, NonCancellable nonCancellable, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNull(nonCancellable, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return BuildersKt.m6910launch(coroutineScope, nonCancellable, coroutineStart, function2);
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m6991async(coroutineScope, interfaceC1342Job, coroutineStart, function2);
    }

    public static /* synthetic */ InterfaceC1342Job launch$default(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m6994launch(coroutineScope, interfaceC1342Job, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super C1133Unit>, ? extends Object>) function2);
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, NonCancellable nonCancellable, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m6992async(coroutineScope, nonCancellable, coroutineStart, function2);
    }

    public static /* synthetic */ InterfaceC1342Job launch$default(CoroutineScope coroutineScope, NonCancellable nonCancellable, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        return m6995launch(coroutineScope, nonCancellable, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super C1133Unit>, ? extends Object>) function2);
    }
}
