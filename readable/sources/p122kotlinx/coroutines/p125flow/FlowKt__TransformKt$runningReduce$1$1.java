package p122kotlinx.coroutines.p125flow;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {
    final /* synthetic */ C1235Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1(C1235Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$1;
        C1235Ref.ObjectRef<Object> objectRef;
        Object obj;
        C1235Ref.ObjectRef<Object> objectRef2;
        T t2;
        FlowCollector<T> flowCollector;
        T t3;
        if (continuation instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) continuation;
            int i = flowKt__TransformKt$runningReduce$1$1$emit$1.f6871label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningReduce$1$1$emit$1.f6871label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, continuation);
            }
        }
        Object obj2 = flowKt__TransformKt$runningReduce$1$1$emit$1.f6872result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__TransformKt$runningReduce$1$1$emit$1.f6871label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            objectRef = this.$accumulator;
            Object obj3 = objectRef.f5202element;
            if (obj3 == NullSurrogateKt.f7173NULL) {
                obj = t;
                objectRef.f5202element = t;
                flowCollector = this.$this_flow;
                t3 = this.$accumulator.f5202element;
                flowKt__TransformKt$runningReduce$1$1$emit$1.f6869L$0 = SpillingKt.nullOutSpilledVariable(obj);
                flowKt__TransformKt$runningReduce$1$1$emit$1.f6870L$1 = null;
                flowKt__TransformKt$runningReduce$1$1$emit$1.f6871label = 2;
                if (flowCollector.mo4309emit(t3, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return C1133Unit.INSTANCE;
            }
            Function3<T, T, Continuation<? super T>, Object> function3 = this.$operation;
            flowKt__TransformKt$runningReduce$1$1$emit$1.f6869L$0 = SpillingKt.nullOutSpilledVariable(t);
            flowKt__TransformKt$runningReduce$1$1$emit$1.f6870L$1 = objectRef;
            flowKt__TransformKt$runningReduce$1$1$emit$1.f6871label = 1;
            Object objMo6219invoke = function3.mo6219invoke(obj3, t, flowKt__TransformKt$runningReduce$1$1$emit$1);
            if (objMo6219invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = t;
            objectRef2 = objectRef;
            t2 = objMo6219invoke;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
                return C1133Unit.INSTANCE;
            }
            objectRef2 = (C1235Ref.ObjectRef) flowKt__TransformKt$runningReduce$1$1$emit$1.f6870L$1;
            obj = flowKt__TransformKt$runningReduce$1$1$emit$1.f6869L$0;
            ResultKt.throwOnFailure(obj2);
            t2 = obj2;
        }
        T t4 = t2;
        objectRef = objectRef2;
        t = t4;
        objectRef.f5202element = t;
        flowCollector = this.$this_flow;
        t3 = this.$accumulator.f5202element;
        flowKt__TransformKt$runningReduce$1$1$emit$1.f6869L$0 = SpillingKt.nullOutSpilledVariable(obj);
        flowKt__TransformKt$runningReduce$1$1$emit$1.f6870L$1 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.f6871label = 2;
        if (flowCollector.mo4309emit(t3, flowKt__TransformKt$runningReduce$1$1$emit$1) == coroutine_suspended) {
        }
        return C1133Unit.INSTANCE;
    }
}
