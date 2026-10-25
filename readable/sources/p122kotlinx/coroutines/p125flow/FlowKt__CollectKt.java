package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.p125flow.internal.NopCollector;

@Metadata(m4987d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00022\u0006\u0010\u0007\u001a\u00020\b\u001ah\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00022H\b\u0004\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000bH\u0086H¢\u0006\u0002\u0010\u0013\u001aQ\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000221\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\u0086@¢\u0006\u0002\u0010\u0016\u001a,\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0002H\u0086@¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000223\b\u0004\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\u0087H¢\u0006\u0002\u0010\u0016\u001aS\u0010\u0014\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u001c23\b\b\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\u0086H¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, m4988d2 = {"collect", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchIn", "Lkotlinx/coroutines/Job;", "T", "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectIndexed", "action", "Lkotlin/Function3;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "index", "value", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatest", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAll", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/SharedFlow;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__CollectKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n*L\n1#1,132:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3 */
    public static final class C14383<T> implements FlowCollector<T> {

        /* renamed from: $action */
        final /* synthetic */ Function2<T, Continuation<? super C1133Unit>, Object> f6206$action;

        /* JADX WARN: Multi-variable type inference failed */
        public C14383(Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
            this.f6206$action = function2;
        }

        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            Object objMo2167invoke = this.f6206$action.mo2167invoke(t, continuation);
            return objMo2167invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo2167invoke : C1133Unit.INSTANCE;
        }

        public Object emit$$forInline(T t, final Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1

                /* renamed from: label */
                int f6207label;

                /* renamed from: result */
                /* synthetic */ Object f6208result;

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6208result = obj;
                    this.f6207label |= Integer.MIN_VALUE;
                    return this.f6209this$0.mo4309emit(null, this);
                }
            };
            InlineMarker.m6315mark(5);
            this.f6206$action.mo2167invoke(t, continuation);
            return C1133Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m4988d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "index", BuildConfig.f24315FLAVOR, "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,132:1\n29#2,4:133\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n*L\n58#1:133,4\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2 */
    public static final class C14392<T> implements FlowCollector<T> {

        /* renamed from: $action */
        final /* synthetic */ Function3<Integer, T, Continuation<? super C1133Unit>, Object> f6210$action;
        private int index;

        /* JADX WARN: Multi-variable type inference failed */
        public C14392(Function3<? super Integer, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
            this.f6210$action = function3;
        }

        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            Function3<Integer, T, Continuation<? super C1133Unit>, Object> function3 = this.f6210$action;
            int i = this.index;
            this.index = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            Object objMo6219invoke = function3.mo6219invoke(C1207Boxing.m6121boxInt(i), t, continuation);
            return objMo6219invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo6219invoke : C1133Unit.INSTANCE;
        }

        public Object emit$$forInline(T t, final Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1

                /* renamed from: label */
                int f6212label;

                /* renamed from: result */
                /* synthetic */ Object f6213result;

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6213result = obj;
                    this.f6212label |= Integer.MIN_VALUE;
                    return this.f6214this$0.mo4309emit(null, this);
                }
            };
            InlineMarker.m6315mark(5);
            Function3<Integer, T, Continuation<? super C1133Unit>, Object> function3 = this.f6210$action;
            int i = this.index;
            this.index = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            function3.mo6219invoke(Integer.valueOf(i), t, continuation);
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectKt", m6124f = "Collect.kt", m6125i = {0, 0, 0}, m6126l = {129}, m6127m = "collectLatest", m6128n = {"$this$collectLatest", "action", "$i$f$collectLatest"}, m6130s = {"L$0", "L$1", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectLatest$2\n*L\n1#1,132:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$collectLatest$2 */
    public static final class C14402<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6215I$0;

        /* renamed from: L$0 */
        Object f6216L$0;

        /* renamed from: L$1 */
        Object f6217L$1;

        /* renamed from: label */
        int f6218label;

        /* renamed from: result */
        /* synthetic */ Object f6219result;

        public C14402(Continuation<? super C14402> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6219result = obj;
            this.f6218label |= Integer.MIN_VALUE;
            return FlowKt__CollectKt.collectLatest((SharedFlow) null, (Function2) null, (Continuation<?>) this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", m6124f = "Collect.kt", m6125i = {}, m6126l = {46}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1 */
    public static final class C14411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ InterfaceC1426Flow<T> $this_launchIn;

        /* renamed from: label */
        int f6220label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14411(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super C14411> continuation) {
            super(2, continuation);
            this.$this_launchIn = interfaceC1426Flow;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C14411(this.$this_launchIn, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6220label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1426Flow<T> interfaceC1426Flow = this.$this_launchIn;
                this.f6220label = 1;
                if (C1427FlowKt.m7200collect(interfaceC1426Flow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
            return ((C14411) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* renamed from: collect */
    public static final Object m7268collect(InterfaceC1426Flow<?> interfaceC1426Flow, Continuation<? super C1133Unit> continuation) {
        Object objMo4308collect = interfaceC1426Flow.mo4308collect(NopCollector.INSTANCE, continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Backwards compatibility with JS and K/N")
    private static final /* synthetic */ <T> Object collect$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        C14383 c14383 = new C14383(function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14383, continuation);
        InlineMarker.m6315mark(1);
        return C1133Unit.INSTANCE;
    }

    public static final <T> Object collectIndexed(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super Integer, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C1133Unit> continuation) {
        Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C14392(function3), continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    private static final <T> Object collectIndexed$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super Integer, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C1133Unit> continuation) {
        C14392 c14392 = new C14392(function3);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14392, continuation);
        InlineMarker.m6315mark(1);
        return C1133Unit.INSTANCE;
    }

    public static final <T> Object collectLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        Object objM7200collect = C1427FlowKt.m7200collect(FlowKt__ContextKt.buffer$default(C1427FlowKt.mapLatest(interfaceC1426Flow, function2), 0, null, 2, null), continuation);
        return objM7200collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7200collect : C1133Unit.INSTANCE;
    }

    private static final <T> Object collectLatest$$forInline(SharedFlow<? extends T> sharedFlow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<?> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
        InlineMarker.m6315mark(0);
        C1427FlowKt.collectLatest((InterfaceC1426Flow) sharedFlow, (Function2) function2, (Continuation<? super C1133Unit>) continuation);
        InlineMarker.m6315mark(1);
        throw new IllegalStateException("SharedFlow never completes, this call should never return.");
    }

    /* renamed from: emitAll */
    public static final <T> Object m7270emitAll(FlowCollector<? super T> flowCollector, InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super C1133Unit> continuation) {
        C1427FlowKt.ensureActive(flowCollector);
        Object objMo4308collect = interfaceC1426Flow.mo4308collect(flowCollector, continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    public static final <T> InterfaceC1342Job launchIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C14411(interfaceC1426Flow, null), 3, null);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Backwards compatibility with JS and K/N")
    /* renamed from: collect */
    public static final /* synthetic */ <T> Object m7269collect(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C14383(function2), continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collectLatest(SharedFlow<? extends T> sharedFlow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<?> continuation) {
        C14402 c14402;
        if (continuation instanceof C14402) {
            c14402 = (C14402) continuation;
            int i = c14402.f6218label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14402.f6218label = i - Integer.MIN_VALUE;
            } else {
                c14402 = new C14402(continuation);
            }
        }
        Object obj = c14402.f6219result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14402.f6218label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
            c14402.f6216L$0 = SpillingKt.nullOutSpilledVariable(sharedFlow);
            c14402.f6217L$1 = SpillingKt.nullOutSpilledVariable(function2);
            c14402.f6215I$0 = 0;
            c14402.f6218label = 1;
            if (C1427FlowKt.collectLatest((InterfaceC1426Flow) sharedFlow, (Function2) function2, (Continuation<? super C1133Unit>) c14402) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new IllegalStateException("SharedFlow never completes, this call should never return.");
    }
}
