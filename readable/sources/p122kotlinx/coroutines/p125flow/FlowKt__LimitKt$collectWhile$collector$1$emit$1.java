package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1", m6124f = "Limit.kt", m6125i = {0}, m6126l = {128}, m6127m = "emit", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6540L$0;

    /* renamed from: label */
    int f6541label;

    /* renamed from: result */
    /* synthetic */ Object f6542result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__LimitKt$collectWhile$collector$1 f6543this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$collectWhile$collector$1$emit$1(FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1, Continuation<? super FlowKt__LimitKt$collectWhile$collector$1$emit$1> continuation) {
        super(continuation);
        this.f6543this$0 = flowKt__LimitKt$collectWhile$collector$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6542result = obj;
        this.f6541label |= Integer.MIN_VALUE;
        return this.f6543this$0.mo4309emit(null, this);
    }
}
