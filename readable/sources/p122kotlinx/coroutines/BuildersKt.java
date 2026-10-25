package p122kotlinx.coroutines;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt", "kotlinx/coroutines/BuildersKt__Builders_concurrentKt"}, m4989k = 4, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class BuildersKt {
    /* renamed from: async */
    public static final <T> Deferred<T> m6908async(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.m6911async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /* renamed from: invoke */
    public static final <T> Object m6909invoke(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.m6912invoke(coroutineDispatcher, function2, continuation);
    }

    /* renamed from: launch */
    public static final InterfaceC1342Job m6910launch(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.m6913launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @LowPriorityInOverloadResolution
    public static final <T> T runBlocking(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return (T) BuildersKt__BuildersKt.runBlocking(coroutineContext, function2);
    }

    public static final <T> T runBlockingImpl(CoroutineContext coroutineContext, EventLoop eventLoop, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return (T) BuildersKt__BuildersKt.runBlockingImpl(coroutineContext, eventLoop, function2);
    }

    @InterfaceC1231JvmName(m6260name = "runBlockingK")
    public static final <T> T runBlockingK(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return (T) BuildersKt__Builders_concurrentKt.runBlockingK(coroutineContext, function2);
    }

    public static final <T> Object withContext(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.withContext(coroutineContext, function2, continuation);
    }
}
