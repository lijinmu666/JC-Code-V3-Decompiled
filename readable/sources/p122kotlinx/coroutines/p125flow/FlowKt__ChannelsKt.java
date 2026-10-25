package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.channels.ChannelIterator;
import p122kotlinx.coroutines.channels.ChannelsKt;
import p122kotlinx.coroutines.channels.ReceiveChannel;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlowKt;

@Metadata(m4987d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a6\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a$\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, m4988d2 = {"emitAll", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", BuildConfig.f24315FLAVOR, "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumeAsFlow", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> InterfaceC1426Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    /* renamed from: emitAll */
    public static final <T> Object m7267emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super C1133Unit> continuation) {
        Object objEmitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return objEmitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAllImpl$FlowKt__ChannelsKt : C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:13:0x0037, B:24:0x0063, B:28:0x007a, B:30:0x0082, B:20:0x0055, B:23:0x005f), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009a -> B:14:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z, Continuation<? super C1133Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        ChannelIterator<? extends T> it;
        ChannelIterator<? extends T> channelIterator;
        ?? r2;
        Object objMo7069hasNext;
        if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
            flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
            int i = flowKt__ChannelsKt$emitAllImpl$1.f6204label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ChannelsKt$emitAllImpl$1.f6204label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
            }
        }
        Object obj = flowKt__ChannelsKt$emitAllImpl$1.f6205result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__ChannelsKt$emitAllImpl$1.f6204label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                C1427FlowKt.ensureActive(flowCollector);
                it = receiveChannel.iterator();
                flowKt__ChannelsKt$emitAllImpl$1.f6199L$0 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.f6200L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.f6201L$2 = it;
                flowKt__ChannelsKt$emitAllImpl$1.f6202L$3 = null;
                flowKt__ChannelsKt$emitAllImpl$1.f6203Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.f6204label = 1;
                objMo7069hasNext = it.mo7069hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                if (objMo7069hasNext == coroutine_suspended) {
                }
            } else if (i2 == 1) {
                z = flowKt__ChannelsKt$emitAllImpl$1.f6203Z$0;
                channelIterator = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$1.f6201L$2;
                receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.f6200L$1;
                FlowCollector flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.f6199L$0;
                ResultKt.throwOnFailure(obj);
                r2 = flowCollector2;
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = flowKt__ChannelsKt$emitAllImpl$1.f6203Z$0;
                channelIterator = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$1.f6201L$2;
                receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.f6200L$1;
                FlowCollector<? super T> flowCollector3 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.f6199L$0;
                ResultKt.throwOnFailure(obj);
                FlowCollector<? super T> flowCollector4 = flowCollector3;
                it = channelIterator;
                flowCollector = flowCollector4;
                flowKt__ChannelsKt$emitAllImpl$1.f6199L$0 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.f6200L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.f6201L$2 = it;
                flowKt__ChannelsKt$emitAllImpl$1.f6202L$3 = null;
                flowKt__ChannelsKt$emitAllImpl$1.f6203Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.f6204label = 1;
                objMo7069hasNext = it.mo7069hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r2 = flowCollector;
                channelIterator = it;
                obj = objMo7069hasNext;
                if (((Boolean) obj).booleanValue()) {
                    if (z) {
                        ChannelsKt.cancelConsumed(receiveChannel, null);
                    }
                    return C1133Unit.INSTANCE;
                }
                T tMo7070next = channelIterator.mo7070next();
                flowKt__ChannelsKt$emitAllImpl$1.f6199L$0 = r2;
                flowKt__ChannelsKt$emitAllImpl$1.f6200L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.f6201L$2 = channelIterator;
                flowKt__ChannelsKt$emitAllImpl$1.f6202L$3 = SpillingKt.nullOutSpilledVariable(tMo7070next);
                flowKt__ChannelsKt$emitAllImpl$1.f6203Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.f6204label = 2;
                Object objMo4309emit = r2.mo4309emit(tMo7070next, flowKt__ChannelsKt$emitAllImpl$1);
                flowCollector4 = r2;
                if (objMo4309emit == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = channelIterator;
                flowCollector = flowCollector4;
                flowKt__ChannelsKt$emitAllImpl$1.f6199L$0 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.f6200L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.f6201L$2 = it;
                flowKt__ChannelsKt$emitAllImpl$1.f6202L$3 = null;
                flowKt__ChannelsKt$emitAllImpl$1.f6203Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.f6204label = 1;
                objMo7069hasNext = it.mo7069hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                if (objMo7069hasNext == coroutine_suspended) {
                }
            }
        } finally {
        }
    }

    public static final <T> ReceiveChannel<T> produceIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(interfaceC1426Flow).produceImpl(coroutineScope);
    }

    public static final <T> InterfaceC1426Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }
}
