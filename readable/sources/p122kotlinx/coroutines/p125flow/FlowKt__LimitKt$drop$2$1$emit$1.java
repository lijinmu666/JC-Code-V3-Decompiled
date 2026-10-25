package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", m6124f = "Limit.kt", m6125i = {0}, m6126l = {22}, m6127m = "emit", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$drop$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6545L$0;

    /* renamed from: label */
    int f6546label;

    /* renamed from: result */
    /* synthetic */ Object f6547result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__LimitKt$drop$2$1<T> f6548this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1$emit$1(FlowKt__LimitKt$drop$2$1<? super T> flowKt__LimitKt$drop$2$1, Continuation<? super FlowKt__LimitKt$drop$2$1$emit$1> continuation) {
        super(continuation);
        this.f6548this$0 = flowKt__LimitKt$drop$2$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6547result = obj;
        this.f6546label |= Integer.MIN_VALUE;
        return this.f6548this$0.mo4309emit(null, this);
    }
}
