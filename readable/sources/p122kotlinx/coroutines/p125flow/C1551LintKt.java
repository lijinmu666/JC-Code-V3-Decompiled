package p122kotlinx.coroutines.p125flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001a'\u0010\u0010\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\f2\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001aj\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\b\u0010\u001b\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001c¢\u0006\u0002\b\"H\u0087\b¢\u0006\u0002\u0010#\u001ac\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&23\b\n\u0010'\u001a-\b\u0001\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0 \u0012\u0006\u0012\u0004\u0018\u00010!0(H\u0087\b¢\u0006\u0002\u0010)\u001a\u007f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032Y\b\b\u0010'\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110&¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0 \u0012\u0006\u0012\u0004\u0018\u00010!0+¢\u0006\u0002\b\"H\u0087\b¢\u0006\u0002\u0010-\u001a$\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020/\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\u001a,\u0010.\u001a\u000201\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000203H\u0087H¢\u0006\u0002\u00104\u001a$\u00105\u001a\b\u0012\u0004\u0012\u0002H\u000206\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\u001a,\u00105\u001a\u000201\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000207H\u0087H¢\u0006\u0002\u00108\u001a\u001e\u00109\u001a\u00020:\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\u001a\u001e\u0010;\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\"\"\u0010\n\u001a\u00020\u000b*\u0006\u0012\u0002\b\u00030\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000f\"\"\u0010\u0016\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019¨\u0006<"}, m4988d2 = {"cancellable", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "flowOn", "context", "Lkotlin/coroutines/CoroutineContext;", "conflate", "Lkotlinx/coroutines/flow/StateFlow;", "distinctUntilChanged", "isActive", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "isActive$annotations", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "(Lkotlinx/coroutines/flow/FlowCollector;)Z", "cancel", BuildConfig.f24315FLAVOR, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/util/concurrent/CancellationException;)V", "coroutineContext", "getCoroutineContext$annotations", "getCoroutineContext", "(Lkotlinx/coroutines/flow/FlowCollector;)Lkotlin/coroutines/CoroutineContext;", "catch", "action", "Lkotlin/Function3;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "retry", "retries", BuildConfig.f24315FLAVOR, "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/SharedFlow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "toList", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.f24315FLAVOR, "destination", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", BuildConfig.f24315FLAVOR, "last", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.flow.LintKt */
/* loaded from: classes.dex */
public final class C1551LintKt {

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.LintKt$retry$1", m6124f = "Lint.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nLint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Lint.kt\nkotlinx/coroutines/flow/LintKt$retry$1\n*L\n1#1,198:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.LintKt$retry$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {

        /* renamed from: label */
        int f6994label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6994label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1207Boxing.boxBoolean(true);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(Throwable th, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) mo2166create(th, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error. Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().cancel(cause)", m5048imports = {}))
    /* renamed from: cancel */
    public static final void m7368cancel(FlowCollector<?> flowCollector, CancellationException cancellationException) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void cancel$default(FlowCollector flowCollector, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        m7368cancel(flowCollector, cancellationException);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> cancellable(SharedFlow<? extends T> sharedFlow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    @InlineOnly
    /* renamed from: catch */
    private static final <T> InterfaceC1426Flow<T> m7369catch(SharedFlow<? extends T> sharedFlow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return C1427FlowKt.m7198catch(sharedFlow, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> conflate(StateFlow<? extends T> stateFlow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    /* renamed from: count */
    private static final <T> Object m7370count(SharedFlow<? extends T> sharedFlow, Continuation<? super Integer> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        InlineMarker.m6315mark(0);
        Object objM7209count = C1427FlowKt.m7209count(sharedFlow, continuation);
        InlineMarker.m6315mark(1);
        return objM7209count;
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> distinctUntilChanged(StateFlow<? extends T> stateFlow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    /* renamed from: flowOn */
    public static final <T> InterfaceC1426Flow<T> m7371flowOn(SharedFlow<? extends T> sharedFlow, CoroutineContext coroutineContext) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    public static final CoroutineContext getCoroutineContext(FlowCollector<?> flowCollector) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error. Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext()", m5048imports = {}))
    public static /* synthetic */ void getCoroutineContext$annotations(FlowCollector flowCollector) {
    }

    public static final boolean isActive(FlowCollector<?> flowCollector) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error. Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().isActive", m5048imports = {}))
    public static /* synthetic */ void isActive$annotations(FlowCollector flowCollector) {
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this terminal operation never completes. If you are using last() to imitate a subscriber, use collect() instead.")
    @InlineOnly
    /* renamed from: last */
    private static final <T> Object m7372last(SharedFlow<? extends T> sharedFlow, Continuation<? super T> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.last>");
        InlineMarker.m6315mark(0);
        Object objM7227last = C1427FlowKt.m7227last(sharedFlow, continuation);
        InlineMarker.m6315mark(1);
        return objM7227last;
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    @InlineOnly
    /* renamed from: retry */
    private static final <T> InterfaceC1426Flow<T> m7373retry(SharedFlow<? extends T> sharedFlow, long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return C1427FlowKt.m7242retry(sharedFlow, j, function2);
    }

    public static /* synthetic */ InterfaceC1426Flow retry$default(SharedFlow sharedFlow, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            function2 = new AnonymousClass1(null);
        }
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return C1427FlowKt.m7242retry(sharedFlow, j, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(expression = "this", m5048imports = {}))
    @InlineOnly
    private static final <T> InterfaceC1426Flow<T> retryWhen(SharedFlow<? extends T> sharedFlow, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return C1427FlowKt.retryWhen(sharedFlow, function4);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    /* renamed from: toList */
    private static final <T> Object m7375toList(SharedFlow<? extends T> sharedFlow, Continuation<? super List<? extends T>> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        InlineMarker.m6315mark(0);
        Object list$default = FlowKt__CollectionKt.toList$default(sharedFlow, null, continuation, 1, null);
        InlineMarker.m6315mark(1);
        return list$default;
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    /* renamed from: toSet */
    private static final <T> Object m7377toSet(SharedFlow<? extends T> sharedFlow, Continuation<? super Set<? extends T>> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        InlineMarker.m6315mark(0);
        Object set$default = FlowKt__CollectionKt.toSet$default(sharedFlow, null, continuation, 1, null);
        InlineMarker.m6315mark(1);
        return set$default;
    }

    @InlineOnly
    /* renamed from: toList */
    private static final <T> Object m7374toList(SharedFlow<? extends T> sharedFlow, List<T> list, Continuation<?> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        InlineMarker.m6315mark(0);
        C1427FlowKt.m7251toList(sharedFlow, list, continuation);
        InlineMarker.m6315mark(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @InlineOnly
    /* renamed from: toSet */
    private static final <T> Object m7376toSet(SharedFlow<? extends T> sharedFlow, Set<T> set, Continuation<?> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        InlineMarker.m6315mark(0);
        C1427FlowKt.m7252toSet(sharedFlow, set, continuation);
        InlineMarker.m6315mark(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }
}
