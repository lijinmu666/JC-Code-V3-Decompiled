package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.FlowKt__CountKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", m6124f = "Count.kt", m6125i = {0}, m6126l = {26}, m6127m = "emit", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__CountKt$count$4$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6357L$0;

    /* renamed from: label */
    int f6358label;

    /* renamed from: result */
    /* synthetic */ Object f6359result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__CountKt.C14654<T> f6360this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CountKt$count$4$emit$1(FlowKt__CountKt.C14654<? super T> c14654, Continuation<? super FlowKt__CountKt$count$4$emit$1> continuation) {
        super(continuation);
        this.f6360this$0 = c14654;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6359result = obj;
        this.f6358label |= Integer.MIN_VALUE;
        return this.f6360this$0.mo4309emit(null, this);
    }
}
