package p122kotlinx.coroutines.p125flow;

import java.util.ArrayList;
import java.util.List;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$chunked$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$chunked$2$1<T> implements FlowCollector {

    /* renamed from: $result */
    final /* synthetic */ C1235Ref.ObjectRef<ArrayList<T>> f6857$result;

    /* renamed from: $size */
    final /* synthetic */ int f6858$size;
    final /* synthetic */ FlowCollector<List<? extends T>> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$chunked$2$1(C1235Ref.ObjectRef<ArrayList<T>> objectRef, int i, FlowCollector<? super List<? extends T>> flowCollector) {
        this.f6857$result = objectRef;
        this.f6858$size = i;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__TransformKt$chunked$2$1$emit$1 flowKt__TransformKt$chunked$2$1$emit$1;
        if (continuation instanceof FlowKt__TransformKt$chunked$2$1$emit$1) {
            flowKt__TransformKt$chunked$2$1$emit$1 = (FlowKt__TransformKt$chunked$2$1$emit$1) continuation;
            int i = flowKt__TransformKt$chunked$2$1$emit$1.f6861label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$chunked$2$1$emit$1.f6861label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$chunked$2$1$emit$1 = new FlowKt__TransformKt$chunked$2$1$emit$1(this, continuation);
            }
        }
        Object obj = flowKt__TransformKt$chunked$2$1$emit$1.f6862result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__TransformKt$chunked$2$1$emit$1.f6861label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = (T) ((ArrayList) ((ArrayList<T>) this.f6857$result.f5202element));
            ArrayList arrayList2 = arrayList;
            if (arrayList == null) {
                T t2 = (T) new ArrayList(this.f6858$size);
                this.f6857$result.f5202element = t2;
                arrayList2 = t2;
            }
            arrayList2.add(t);
            if (arrayList2.size() == this.f6858$size) {
                FlowCollector<List<? extends T>> flowCollector = this.$this_flow;
                flowKt__TransformKt$chunked$2$1$emit$1.f6859L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__TransformKt$chunked$2$1$emit$1.f6860L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
                flowKt__TransformKt$chunked$2$1$emit$1.f6861label = 1;
                if (flowCollector.mo4309emit(arrayList2, flowKt__TransformKt$chunked$2$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return C1133Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.f6857$result.f5202element = null;
        return C1133Unit.INSTANCE;
    }
}
