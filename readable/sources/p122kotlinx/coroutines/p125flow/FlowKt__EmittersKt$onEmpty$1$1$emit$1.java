package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1", m6124f = "Emitters.kt", m6125i = {0}, m6126l = {179}, m6127m = "emit", m6128n = {"it"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__EmittersKt$onEmpty$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6455L$0;

    /* renamed from: label */
    int f6456label;

    /* renamed from: result */
    /* synthetic */ Object f6457result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__EmittersKt$onEmpty$1$1<T> f6458this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$onEmpty$1$1$emit$1(FlowKt__EmittersKt$onEmpty$1$1<? super T> flowKt__EmittersKt$onEmpty$1$1, Continuation<? super FlowKt__EmittersKt$onEmpty$1$1$emit$1> continuation) {
        super(continuation);
        this.f6458this$0 = flowKt__EmittersKt$onEmpty$1$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6457result = obj;
        this.f6456label |= Integer.MIN_VALUE;
        return this.f6458this$0.mo4309emit(null, this);
    }
}
