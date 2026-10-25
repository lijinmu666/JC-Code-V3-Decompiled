package p122kotlinx.coroutines.p125flow.internal;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineScopeKt;
import p122kotlinx.coroutines.CoroutineStart;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003Bw\u0012B\u0010\u0004\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005¢\u0006\u0002\b\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u001c\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0094@¢\u0006\u0002\u0010\u001dRL\u0010\u0004\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005¢\u0006\u0002\b\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006\u001e"}, m4988d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "transform", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", BuildConfig.f24315FLAVOR, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function3;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flowCollect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
/* loaded from: classes.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    private final Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> transform;

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", m6124f = "Merge.kt", m6125i = {0, 0}, m6126l = {23}, m6127m = "invokeSuspend", m6128n = {"$this$coroutineScope", "previousFlow"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3 */
    public static final class C15663 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ FlowCollector<R> $collector;

        /* renamed from: L$0 */
        private /* synthetic */ Object f7099L$0;

        /* renamed from: L$1 */
        Object f7100L$1;

        /* renamed from: label */
        int f7101label;

        /* renamed from: this$0 */
        final /* synthetic */ ChannelFlowTransformLatest<T, R> f7102this$0;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ FlowCollector<R> $collector;
            final /* synthetic */ C1235Ref.ObjectRef<InterfaceC1342Job> $previousFlow;

            /* renamed from: this$0 */
            final /* synthetic */ ChannelFlowTransformLatest<T, R> f7103this$0;

            @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", m6124f = "Merge.kt", m6125i = {}, m6126l = {30}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
            /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
                final /* synthetic */ FlowCollector<R> $collector;

                /* renamed from: $value */
                final /* synthetic */ T f7104$value;

                /* renamed from: label */
                int f7105label;

                /* renamed from: this$0 */
                final /* synthetic */ ChannelFlowTransformLatest<T, R> f7106this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, T t, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.f7106this$0 = channelFlowTransformLatest;
                    this.$collector = flowCollector;
                    this.f7104$value = t;
                }

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                /* renamed from: create */
                public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.f7106this$0, this.$collector, this.f7104$value, continuation);
                }

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f7105label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function3 function3 = ((ChannelFlowTransformLatest) this.f7106this$0).transform;
                        FlowCollector<R> flowCollector = this.$collector;
                        T t = this.f7104$value;
                        this.f7105label = 1;
                        if (function3.mo6219invoke(flowCollector, t, this) == coroutine_suspended) {
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
                    return ((AnonymousClass2) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(C1235Ref.ObjectRef<InterfaceC1342Job> objectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector) {
                this.$previousFlow = objectRef;
                this.$$this$coroutineScope = coroutineScope;
                this.f7103this$0 = channelFlowTransformLatest;
                this.$collector = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // p122kotlinx.coroutines.p125flow.FlowCollector
            /* renamed from: emit */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
                ChannelFlowTransformLatest$flowCollect$3$1$emit$1 channelFlowTransformLatest$flowCollect$3$1$emit$1;
                if (continuation instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) continuation;
                    int i = channelFlowTransformLatest$flowCollect$3$1$emit$1.f7111label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.f7111label = i - Integer.MIN_VALUE;
                    } else {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
                    }
                }
                Object obj = channelFlowTransformLatest$flowCollect$3$1$emit$1.f7112result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.f7111label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    InterfaceC1342Job interfaceC1342Job = this.$previousFlow.f5202element;
                    if (interfaceC1342Job != null) {
                        interfaceC1342Job.mo6998cancel((CancellationException) new ChildCancelledException());
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.f7108L$0 = t;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.f7109L$1 = interfaceC1342Job;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.f7110L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1342Job);
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.f7107I$0 = 0;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.f7111label = 1;
                        if (interfaceC1342Job.mo7000join(channelFlowTransformLatest$flowCollect$3$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t = (T) channelFlowTransformLatest$flowCollect$3$1$emit$1.f7108L$0;
                    ResultKt.throwOnFailure(obj);
                }
                this.$previousFlow.f5202element = (T) BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.f7103this$0, this.$collector, t, null), 1, null);
                return C1133Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15663(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, Continuation<? super C15663> continuation) {
            super(2, continuation);
            this.f7102this$0 = channelFlowTransformLatest;
            this.$collector = flowCollector;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15663 c15663 = new C15663(this.f7102this$0, this.$collector, continuation);
            c15663.f7099L$0 = obj;
            return c15663;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.f7099L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7101label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C1235Ref.ObjectRef objectRef = new C1235Ref.ObjectRef();
                ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.f7102this$0;
                InterfaceC1426Flow<S> interfaceC1426Flow = channelFlowTransformLatest.flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, coroutineScope, channelFlowTransformLatest, this.$collector);
                this.f7099L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f7100L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.f7101label = 1;
                if (interfaceC1426Flow.mo4308collect(anonymousClass1, this) == coroutine_suspended) {
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
            return ((C15663) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3, InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(interfaceC1426Flow, coroutineContext, i, bufferOverflow);
        this.transform = function3;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    /* renamed from: create */
    public ChannelFlow<R> mo7181create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return new ChannelFlowTransformLatest(this.transform, this.flow, context, capacity, onBufferOverflow);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlowOperator
    public Object flowCollect(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C15663(this, flowCollector, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : C1133Unit.INSTANCE;
    }

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, InterfaceC1426Flow interfaceC1426Flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function3, interfaceC1426Flow, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? BufferOverflow.f5601SUSPEND : bufferOverflow);
    }
}
