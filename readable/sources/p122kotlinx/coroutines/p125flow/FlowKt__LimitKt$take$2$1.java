package p122kotlinx.coroutines.p125flow;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.C1235Ref;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {
    final /* synthetic */ C1235Ref.IntRef $consumed;

    /* renamed from: $count */
    final /* synthetic */ int f6558$count;
    final /* synthetic */ Object $ownershipMarker;
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$take$2$1(C1235Ref.IntRef intRef, int i, FlowCollector<? super T> flowCollector, Object obj) {
        this.$consumed = intRef;
        this.f6558$count = i;
        this.$this_flow = flowCollector;
        this.$ownershipMarker = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__LimitKt$take$2$1$emit$1 flowKt__LimitKt$take$2$1$emit$1;
        if (continuation instanceof FlowKt__LimitKt$take$2$1$emit$1) {
            flowKt__LimitKt$take$2$1$emit$1 = (FlowKt__LimitKt$take$2$1$emit$1) continuation;
            int i = flowKt__LimitKt$take$2$1$emit$1.f6560label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$take$2$1$emit$1.f6560label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, continuation);
            }
        }
        Object obj = flowKt__LimitKt$take$2$1$emit$1.f6561result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__LimitKt$take$2$1$emit$1.f6560label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return C1133Unit.INSTANCE;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1133Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        C1235Ref.IntRef intRef = this.$consumed;
        int i3 = intRef.f5200element + 1;
        intRef.f5200element = i3;
        if (i3 < this.f6558$count) {
            FlowCollector<T> flowCollector = this.$this_flow;
            flowKt__LimitKt$take$2$1$emit$1.f6559L$0 = SpillingKt.nullOutSpilledVariable(t);
            flowKt__LimitKt$take$2$1$emit$1.f6560label = 1;
            if (flowCollector.mo4309emit(t, flowKt__LimitKt$take$2$1$emit$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return C1133Unit.INSTANCE;
        }
        FlowCollector<T> flowCollector2 = this.$this_flow;
        Object obj2 = this.$ownershipMarker;
        flowKt__LimitKt$take$2$1$emit$1.f6559L$0 = SpillingKt.nullOutSpilledVariable(t);
        flowKt__LimitKt$take$2$1$emit$1.f6560label = 2;
        if (FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(flowCollector2, t, obj2, flowKt__LimitKt$take$2$1$emit$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }
}
