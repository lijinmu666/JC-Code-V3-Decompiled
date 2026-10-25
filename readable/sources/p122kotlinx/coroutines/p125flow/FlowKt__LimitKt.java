package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;
import p122kotlinx.coroutines.p125flow.internal.FlowExceptions_commonKt;

@Metadata(m4987d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001aE\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a0\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u00022\u0006\u0010\u0011\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001aE\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\u0010\u000b\u001ak\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0018¢\u0006\u0002\b\u001b¢\u0006\u0002\u0010\u001c\u001aS\u0010\u001d\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0080H¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, m4988d2 = {"drop", "Lkotlinx/coroutines/flow/Flow;", "T", "count", BuildConfig.f24315FLAVOR, "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "take", "emitAbort", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "value", "ownershipMarker", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "collectWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n105#3:143\n105#3:144\n105#3:145\n105#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n19#1:143\n30#1:144\n49#1:145\n81#1:146\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__LimitKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt", m6124f = "Limit.kt", m6125i = {0, 0, 0, 0}, m6126l = {134}, m6127m = "collectWhile", m6128n = {"$this$collectWhile", "predicate", "collector", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$1\n*L\n1#1,141:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 */
    public static final class C14851<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6534I$0;

        /* renamed from: L$0 */
        Object f6535L$0;

        /* renamed from: L$1 */
        Object f6536L$1;

        /* renamed from: L$2 */
        Object f6537L$2;

        /* renamed from: label */
        int f6538label;

        /* renamed from: result */
        /* synthetic */ Object f6539result;

        public C14851(Continuation<? super C14851> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6539result = obj;
            this.f6538label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt.collectWhile(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", m6124f = "Limit.kt", m6125i = {0, 0, 0, 0}, m6126l = {152}, m6127m = "invokeSuspend", m6128n = {"$this$safeFlow", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n124#2,17:142\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n117#1:142,17\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1 */
    public static final class C14861<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ InterfaceC1426Flow<T> $this_transformWhile;
        final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Boolean>, Object> $transform;

        /* renamed from: I$0 */
        int f6563I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6564L$0;

        /* renamed from: L$1 */
        Object f6565L$1;

        /* renamed from: L$2 */
        Object f6566L$2;

        /* renamed from: label */
        int f6567label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14861(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super C14861> continuation) {
            super(2, continuation);
            this.$this_transformWhile = interfaceC1426Flow;
            this.$transform = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14861 c14861 = new C14861(this.$this_transformWhile, this.$transform, continuation);
            c14861.f6564L$0 = obj;
            return c14861;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C1484xdf1aa1b6 c1484xdf1aa1b6;
            FlowCollector flowCollector = (FlowCollector) this.f6564L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6567label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1426Flow<T> interfaceC1426Flow = this.$this_transformWhile;
                C1484xdf1aa1b6 c1484xdf1aa1b62 = new C1484xdf1aa1b6(this.$transform, flowCollector);
                try {
                    this.f6564L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.f6565L$1 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                    this.f6566L$2 = c1484xdf1aa1b62;
                    this.f6563I$0 = 0;
                    this.f6567label = 1;
                    if (interfaceC1426Flow.mo4308collect(c1484xdf1aa1b62, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (AbortFlowException e) {
                    e = e;
                    c1484xdf1aa1b6 = c1484xdf1aa1b62;
                    FlowExceptions_commonKt.checkOwnership(e, c1484xdf1aa1b6);
                    C1344JobKt.ensureActive(this.get$context());
                    return C1133Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c1484xdf1aa1b6 = (C1484xdf1aa1b6) this.f6566L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e2) {
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, c1484xdf1aa1b6);
                    C1344JobKt.ensureActive(this.get$context());
                    return C1133Unit.INSTANCE;
                }
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
            return ((C14861) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collectWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        C14851 c14851;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof C14851) {
            c14851 = (C14851) continuation;
            int i = c14851.f6538label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14851.f6538label = i - Integer.MIN_VALUE;
            } else {
                c14851 = new C14851(continuation);
            }
        }
        Object obj = c14851.f6539result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14851.f6538label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<? super Object> flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1<>(function2);
            try {
                c14851.f6535L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14851.f6536L$1 = SpillingKt.nullOutSpilledVariable(function2);
                c14851.f6537L$2 = flowKt__LimitKt$collectWhile$collector$1;
                c14851.f6534I$0 = 0;
                c14851.f6538label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__LimitKt$collectWhile$collector$1, c14851) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (AbortFlowException e) {
                e = e;
                flowCollector = flowKt__LimitKt$collectWhile$collector$1;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c14851.get$context());
                return C1133Unit.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__LimitKt$collectWhile$collector$1) c14851.f6537L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e2) {
                e = e2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c14851.get$context());
                return C1133Unit.INSTANCE;
            }
        }
        return C1133Unit.INSTANCE;
    }

    private static final <T> Object collectWhile$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(function2);
        try {
            InlineMarker.m6315mark(0);
            interfaceC1426Flow.mo4308collect(flowKt__LimitKt$collectWhile$collector$1, continuation);
            InlineMarker.m6315mark(1);
            return C1133Unit.INSTANCE;
        } catch (AbortFlowException e) {
            FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
            InlineMarker.m6315mark(3);
            throw null;
        }
    }

    /* renamed from: drop */
    public static final <T> InterfaceC1426Flow<T> m7294drop(final InterfaceC1426Flow<? extends T> interfaceC1426Flow, final int i) {
        if (i >= 0) {
            return new InterfaceC1426Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
                @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
                /* renamed from: collect */
                public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
                    Object objMo4308collect = interfaceC1426Flow.mo4308collect(new FlowKt__LimitKt$drop$2$1(new C1235Ref.IntRef(), i, flowCollector), continuation);
                    return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
                }
            };
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i).toString());
    }

    public static final <T> InterfaceC1426Flow<T> dropWhile(final InterfaceC1426Flow<? extends T> interfaceC1426Flow, final Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new InterfaceC1426Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new FlowKt__LimitKt$dropWhile$1$1(new C1235Ref.BooleanRef(), flowCollector, function2), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAbort$FlowKt__LimitKt(FlowCollector<? super T> flowCollector, T t, Object obj, Continuation<? super C1133Unit> continuation) {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        if (continuation instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) continuation;
            int i = flowKt__LimitKt$emitAbort$1.f6556label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.f6556label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuation);
            }
        }
        Object obj2 = flowKt__LimitKt$emitAbort$1.f6557result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__LimitKt$emitAbort$1.f6556label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            flowKt__LimitKt$emitAbort$1.f6553L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            flowKt__LimitKt$emitAbort$1.f6554L$1 = SpillingKt.nullOutSpilledVariable(t);
            flowKt__LimitKt$emitAbort$1.f6555L$2 = obj;
            flowKt__LimitKt$emitAbort$1.f6556label = 1;
            if (flowCollector.mo4309emit(t, flowKt__LimitKt$emitAbort$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = flowKt__LimitKt$emitAbort$1.f6555L$2;
            ResultKt.throwOnFailure(obj2);
        }
        throw new AbortFlowException(obj);
    }

    /* renamed from: take */
    public static final <T> InterfaceC1426Flow<T> m7295take(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        if (i > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(interfaceC1426Flow, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " should be positive").toString());
    }

    public static final <T> InterfaceC1426Flow<T> takeWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(interfaceC1426Flow, function2);
    }

    public static final <T, R> InterfaceC1426Flow<R> transformWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return C1427FlowKt.m7219flow(new C14861(interfaceC1426Flow, function3, null));
    }
}
