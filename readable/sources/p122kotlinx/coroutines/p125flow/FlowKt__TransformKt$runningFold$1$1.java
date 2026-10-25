package p122kotlinx.coroutines.p125flow;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {
    final /* synthetic */ C1235Ref.ObjectRef<R> $accumulator;
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
    final /* synthetic */ FlowCollector<R> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningFold$1$1(C1235Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__TransformKt$runningFold$1$1$emit$1 flowKt__TransformKt$runningFold$1$1$emit$1;
        Object obj;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__TransformKt$runningFold$1$1$emit$1) {
            flowKt__TransformKt$runningFold$1$1$emit$1 = (FlowKt__TransformKt$runningFold$1$1$emit$1) continuation;
            int i = flowKt__TransformKt$runningFold$1$1$emit$1.f6866label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningFold$1$1$emit$1.f6866label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, continuation);
            }
        }
        T t2 = (T) flowKt__TransformKt$runningFold$1$1$emit$1.f6867result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__TransformKt$runningFold$1$1$emit$1.f6866label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(t2);
            C1235Ref.ObjectRef objectRef2 = this.$accumulator;
            Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
            T t3 = objectRef2.f5202element;
            flowKt__TransformKt$runningFold$1$1$emit$1.f6864L$0 = SpillingKt.nullOutSpilledVariable(t);
            flowKt__TransformKt$runningFold$1$1$emit$1.f6865L$1 = objectRef2;
            flowKt__TransformKt$runningFold$1$1$emit$1.f6866label = 1;
            Object objMo6219invoke = function3.mo6219invoke(t3, t, flowKt__TransformKt$runningFold$1$1$emit$1);
            if (objMo6219invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = t;
            objectRef = objectRef2;
            t2 = (T) objMo6219invoke;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(t2);
                return C1133Unit.INSTANCE;
            }
            objectRef = (C1235Ref.ObjectRef) flowKt__TransformKt$runningFold$1$1$emit$1.f6865L$1;
            obj = flowKt__TransformKt$runningFold$1$1$emit$1.f6864L$0;
            ResultKt.throwOnFailure(t2);
        }
        objectRef.f5202element = t2;
        FlowCollector<R> flowCollector = this.$this_flow;
        T t4 = this.$accumulator.f5202element;
        flowKt__TransformKt$runningFold$1$1$emit$1.f6864L$0 = SpillingKt.nullOutSpilledVariable(obj);
        flowKt__TransformKt$runningFold$1$1$emit$1.f6865L$1 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.f6866label = 2;
        if (flowCollector.mo4309emit(t4, flowKt__TransformKt$runningFold$1$1$emit$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }
}
