package p122kotlinx.coroutines.p125flow.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.ContinuationInterceptor;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.CoroutineContextKt;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H¤@¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0094@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m4988d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", BuildConfig.f24315FLAVOR, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "flowCollect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collect", "toString", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    @JvmField
    protected final InterfaceC1426Flow<S> flow;

    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "it", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", m6124f = "ChannelFlow.kt", m6125i = {0}, m6126l = {148}, m6127m = "invokeSuspend", m6128n = {"it"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2 */
    public static final class C15652 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: L$0 */
        /* synthetic */ Object f7096L$0;

        /* renamed from: label */
        int f7097label;

        /* renamed from: this$0 */
        final /* synthetic */ ChannelFlowOperator<S, T> f7098this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15652(ChannelFlowOperator<S, T> channelFlowOperator, Continuation<? super C15652> continuation) {
            super(2, continuation);
            this.f7098this$0 = channelFlowOperator;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15652 c15652 = new C15652(this.f7098this$0, continuation);
            c15652.f7096L$0 = obj;
            return c15652;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector<? super T> flowCollector = (FlowCollector) this.f7096L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7097label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelFlowOperator<S, T> channelFlowOperator = this.f7098this$0;
                this.f7096L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f7097label = 1;
                if (channelFlowOperator.flowCollect(flowCollector, this) == coroutine_suspended) {
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
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
            return ((C15652) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(InterfaceC1426Flow<? extends S> interfaceC1426Flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.flow = interfaceC1426Flow;
    }

    public static /* synthetic */ <S, T> Object collect$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        if (channelFlowOperator.capacity == -3) {
            CoroutineContext coroutineContext = continuation.get$context();
            CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineContext, channelFlowOperator.context);
            if (Intrinsics.areEqual(coroutineContextNewCoroutineContext, coroutineContext)) {
                Object objFlowCollect = channelFlowOperator.flowCollect(flowCollector, continuation);
                return objFlowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlowCollect : C1133Unit.INSTANCE;
            }
            ContinuationInterceptor.Companion companion = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.areEqual(coroutineContextNewCoroutineContext.mo6098get(companion), coroutineContext.mo6098get(companion))) {
                Object objCollectWithContextUndispatched = channelFlowOperator.collectWithContextUndispatched(flowCollector, coroutineContextNewCoroutineContext, continuation);
                return objCollectWithContextUndispatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectWithContextUndispatched : C1133Unit.INSTANCE;
            }
        }
        Object objMo4308collect = super.mo4308collect(flowCollector, continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    public static /* synthetic */ <S, T> Object collectTo$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, ProducerScope<? super T> producerScope, Continuation<? super C1133Unit> continuation) {
        Object objFlowCollect = channelFlowOperator.flowCollect(new SendingCollector(producerScope), continuation);
        return objFlowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlowCollect : C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectWithContextUndispatched(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super C1133Unit> continuation) {
        return ChannelFlowKt.withContextUndispatched$default(coroutineContext, ChannelFlowKt.withUndispatchedContextCollector(flowCollector, continuation.get$context()), null, new C15652(this, null), continuation, 4, null);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow, p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        return collect$suspendImpl((ChannelFlowOperator) this, (FlowCollector) flowCollector, continuation);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super C1133Unit> continuation) {
        return collectTo$suspendImpl(this, producerScope, continuation);
    }

    public abstract Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation);

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
