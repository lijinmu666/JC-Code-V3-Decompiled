package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", m6124f = "Transform.kt", m6125i = {0, 1}, m6126l = {127, 129}, m6127m = "emit", m6128n = {"value", "value"}, m6130s = {"L$0", "L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$runningReduce$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6869L$0;

    /* renamed from: L$1 */
    Object f6870L$1;

    /* renamed from: label */
    int f6871label;

    /* renamed from: result */
    /* synthetic */ Object f6872result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__TransformKt$runningReduce$1$1<T> f6873this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1$emit$1(FlowKt__TransformKt$runningReduce$1$1<? super T> flowKt__TransformKt$runningReduce$1$1, Continuation<? super FlowKt__TransformKt$runningReduce$1$1$emit$1> continuation) {
        super(continuation);
        this.f6873this$0 = flowKt__TransformKt$runningReduce$1$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6872result = obj;
        this.f6871label |= Integer.MIN_VALUE;
        return this.f6873this$0.mo4309emit(null, this);
    }
}
