package p122kotlinx.coroutines.p125flow.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0094@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m4988d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperatorImpl;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", BuildConfig.f24315FLAVOR, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "dropChannelOperators", "flowCollect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ChannelFlowOperatorImpl<T> extends ChannelFlowOperator<T, T> {
    public ChannelFlowOperatorImpl(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(interfaceC1426Flow, coroutineContext, i, bufferOverflow);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    /* renamed from: create */
    public ChannelFlow<T> mo7181create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return new ChannelFlowOperatorImpl(this.flow, context, capacity, onBufferOverflow);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    public InterfaceC1426Flow<T> dropChannelOperators() {
        return (InterfaceC1426Flow<T>) this.flow;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.ChannelFlowOperator
    public Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        Object objMo4308collect = this.flow.mo4308collect(flowCollector, continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    public /* synthetic */ ChannelFlowOperatorImpl(InterfaceC1426Flow interfaceC1426Flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC1426Flow, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? BufferOverflow.f5601SUSPEND : bufferOverflow);
    }
}
