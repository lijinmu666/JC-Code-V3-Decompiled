package p122kotlinx.coroutines.p125flow;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    final /* synthetic */ C1235Ref.BooleanRef $matched;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(C1235Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$matched = booleanRef;
        this.$this_flow = flowCollector;
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1;
        if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
            flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
            int i = flowKt__LimitKt$dropWhile$1$1$emit$1.f6550label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$dropWhile$1$1$emit$1.f6550label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
            }
        }
        Object objMo2167invoke = flowKt__LimitKt$dropWhile$1$1$emit$1.f6551result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__LimitKt$dropWhile$1$1$emit$1.f6550label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo2167invoke);
            if (this.$matched.f5195element) {
                FlowCollector<T> flowCollector = this.$this_flow;
                flowKt__LimitKt$dropWhile$1$1$emit$1.f6549L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__LimitKt$dropWhile$1$1$emit$1.f6550label = 1;
                if (flowCollector.mo4309emit(t, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return C1133Unit.INSTANCE;
            }
            Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
            flowKt__LimitKt$dropWhile$1$1$emit$1.f6549L$0 = t;
            flowKt__LimitKt$dropWhile$1$1$emit$1.f6550label = 2;
            objMo2167invoke = function2.mo2167invoke(t, flowKt__LimitKt$dropWhile$1$1$emit$1);
            if (objMo2167invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!((Boolean) objMo2167invoke).booleanValue()) {
            }
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objMo2167invoke);
                return C1133Unit.INSTANCE;
            }
            if (i2 == 2) {
                t = (T) flowKt__LimitKt$dropWhile$1$1$emit$1.f6549L$0;
                ResultKt.throwOnFailure(objMo2167invoke);
                if (!((Boolean) objMo2167invoke).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                this.$matched.f5195element = true;
                FlowCollector<T> flowCollector2 = this.$this_flow;
                flowKt__LimitKt$dropWhile$1$1$emit$1.f6549L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__LimitKt$dropWhile$1$1$emit$1.f6550label = 3;
                if (flowCollector2.mo4309emit(t, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objMo2167invoke);
            }
        }
        return C1133Unit.INSTANCE;
    }
}
