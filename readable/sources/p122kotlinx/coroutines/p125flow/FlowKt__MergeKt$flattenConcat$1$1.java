package p122kotlinx.coroutines.p125flow;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class FlowKt__MergeKt$flattenConcat$1$1<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flattenConcat$1$1(FlowCollector<? super T> flowCollector) {
        this.$this_flow = flowCollector;
    }

    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public /* bridge */ /* synthetic */ Object mo4309emit(Object obj, Continuation continuation) {
        return m7303emit((InterfaceC1426Flow) obj, (Continuation<? super C1133Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m7303emit(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super C1133Unit> continuation) {
        FlowKt__MergeKt$flattenConcat$1$1$emit$1 flowKt__MergeKt$flattenConcat$1$1$emit$1;
        if (continuation instanceof FlowKt__MergeKt$flattenConcat$1$1$emit$1) {
            flowKt__MergeKt$flattenConcat$1$1$emit$1 = (FlowKt__MergeKt$flattenConcat$1$1$emit$1) continuation;
            int i = flowKt__MergeKt$flattenConcat$1$1$emit$1.f6625label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__MergeKt$flattenConcat$1$1$emit$1.f6625label = i - Integer.MIN_VALUE;
            } else {
                flowKt__MergeKt$flattenConcat$1$1$emit$1 = new FlowKt__MergeKt$flattenConcat$1$1$emit$1(this, continuation);
            }
        }
        Object obj = flowKt__MergeKt$flattenConcat$1$1$emit$1.f6626result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__MergeKt$flattenConcat$1$1$emit$1.f6625label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.$this_flow;
            flowKt__MergeKt$flattenConcat$1$1$emit$1.f6624L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            flowKt__MergeKt$flattenConcat$1$1$emit$1.f6625label = 1;
            if (C1427FlowKt.m7213emitAll(flowCollector, interfaceC1426Flow, flowKt__MergeKt$flattenConcat$1$1$emit$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C1133Unit.INSTANCE;
    }
}
