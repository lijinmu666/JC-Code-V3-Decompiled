package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", m6124f = "Emitters.kt", m6125i = {0, 0, 0}, m6126l = {210}, m6127m = "invokeSafely$FlowKt__EmittersKt", m6128n = {"$this$invokeSafely", "action", "cause"}, m6130s = {"L$0", "L$1", "L$2"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__EmittersKt$invokeSafely$1<T> extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6450L$0;

    /* renamed from: L$1 */
    Object f6451L$1;

    /* renamed from: L$2 */
    Object f6452L$2;

    /* renamed from: label */
    int f6453label;

    /* renamed from: result */
    /* synthetic */ Object f6454result;

    public FlowKt__EmittersKt$invokeSafely$1(Continuation<? super FlowKt__EmittersKt$invokeSafely$1> continuation) {
        super(continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6454result = obj;
        this.f6453label |= Integer.MIN_VALUE;
        return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(null, null, null, this);
    }
}
