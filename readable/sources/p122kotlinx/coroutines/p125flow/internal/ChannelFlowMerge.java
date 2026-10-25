package p122kotlinx.coroutines.p125flow.internal;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.channels.ProduceKt;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.channels.ReceiveChannel;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;
import p122kotlinx.coroutines.p129sync.Semaphore;
import p122kotlinx.coroutines.p129sync.SemaphoreKt;

@Metadata(m4987d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BA\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0094@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m4988d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", BuildConfig.f24315FLAVOR, "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectTo", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "additionalToStringProps", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    private final int concurrency;
    private final InterfaceC1426Flow<InterfaceC1426Flow<T>> flow;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2 */
    public static final class C15642<T> implements FlowCollector {
        final /* synthetic */ SendingCollector<T> $collector;

        /* renamed from: $job */
        final /* synthetic */ InterfaceC1342Job f7087$job;

        /* renamed from: $scope */
        final /* synthetic */ ProducerScope<T> f7088$scope;
        final /* synthetic */ Semaphore $semaphore;

        @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", m6124f = "Merge.kt", m6125i = {}, m6126l = {C5125EACTags.ELEMENT_LIST}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
            final /* synthetic */ SendingCollector<T> $collector;

            /* renamed from: $inner */
            final /* synthetic */ InterfaceC1426Flow<T> f7089$inner;
            final /* synthetic */ Semaphore $semaphore;

            /* renamed from: label */
            int f7090label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(InterfaceC1426Flow<? extends T> interfaceC1426Flow, SendingCollector<T> sendingCollector, Semaphore semaphore, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.f7089$inner = interfaceC1426Flow;
                this.$collector = sendingCollector;
                this.$semaphore = semaphore;
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            /* renamed from: create */
            public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.f7089$inner, this.$collector, this.$semaphore, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, kotlin.Unit] */
            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f7090label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        InterfaceC1426Flow<T> interfaceC1426Flow = this.f7089$inner;
                        SendingCollector<T> sendingCollector = this.$collector;
                        this.f7090label = 1;
                        if (interfaceC1426Flow.mo4308collect(sendingCollector, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.$semaphore.m7502release();
                    this = C1133Unit.INSTANCE;
                    return this;
                } catch (Throwable th) {
                    this.$semaphore.m7502release();
                    throw th;
                }
            }

            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
                return ((AnonymousClass1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C15642(InterfaceC1342Job interfaceC1342Job, Semaphore semaphore, ProducerScope<? super T> producerScope, SendingCollector<T> sendingCollector) {
            this.f7087$job = interfaceC1342Job;
            this.$semaphore = semaphore;
            this.f7088$scope = producerScope;
            this.$collector = sendingCollector;
        }

        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        public /* bridge */ /* synthetic */ Object mo4309emit(Object obj, Continuation continuation) {
            return m7390emit((InterfaceC1426Flow) obj, (Continuation<? super C1133Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object m7390emit(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super C1133Unit> continuation) {
            ChannelFlowMerge$collectTo$2$emit$1 channelFlowMerge$collectTo$2$emit$1;
            if (continuation instanceof ChannelFlowMerge$collectTo$2$emit$1) {
                channelFlowMerge$collectTo$2$emit$1 = (ChannelFlowMerge$collectTo$2$emit$1) continuation;
                int i = channelFlowMerge$collectTo$2$emit$1.f7092label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    channelFlowMerge$collectTo$2$emit$1.f7092label = i - Integer.MIN_VALUE;
                } else {
                    channelFlowMerge$collectTo$2$emit$1 = new ChannelFlowMerge$collectTo$2$emit$1(this, continuation);
                }
            }
            Object obj = channelFlowMerge$collectTo$2$emit$1.f7093result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = channelFlowMerge$collectTo$2$emit$1.f7092label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1342Job interfaceC1342Job = this.f7087$job;
                if (interfaceC1342Job != null) {
                    C1344JobKt.ensureActive(interfaceC1342Job);
                }
                Semaphore semaphore = this.$semaphore;
                channelFlowMerge$collectTo$2$emit$1.f7091L$0 = interfaceC1426Flow;
                channelFlowMerge$collectTo$2$emit$1.f7092label = 1;
                if (semaphore.m7501acquire(channelFlowMerge$collectTo$2$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC1426Flow = (InterfaceC1426Flow) channelFlowMerge$collectTo$2$emit$1.f7091L$0;
                ResultKt.throwOnFailure(obj);
            }
            BuildersKt__Builders_commonKt.launch$default(this.f7088$scope, null, null, new AnonymousClass1(interfaceC1426Flow, this.$collector, this.$semaphore, null), 3, null);
            return C1133Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow, int i, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.flow = interfaceC1426Flow;
        this.concurrency = i;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    public String additionalToStringProps() {
        return "concurrency=" + this.concurrency;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super C1133Unit> continuation) {
        Object objMo4308collect = this.flow.mo4308collect(new C15642((InterfaceC1342Job) continuation.get$context().mo6098get(InterfaceC1342Job.INSTANCE), SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, null), producerScope, new SendingCollector(producerScope)), continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    /* renamed from: create */
    public ChannelFlow<T> mo7181create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return new ChannelFlowMerge(this.flow, this.concurrency, context, capacity, onBufferOverflow);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    public ReceiveChannel<T> produceImpl(CoroutineScope scope) {
        return ProduceKt.m7151produce(scope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }

    public /* synthetic */ ChannelFlowMerge(InterfaceC1426Flow interfaceC1426Flow, int i, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC1426Flow, i, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 8) != 0 ? -2 : i2, (i3 & 16) != 0 ? BufferOverflow.f5601SUSPEND : bufferOverflow);
    }
}
