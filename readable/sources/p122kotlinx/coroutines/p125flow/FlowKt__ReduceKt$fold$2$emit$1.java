package p122kotlinx.coroutines.p125flow;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.FlowKt__ReduceKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", m6124f = "Reduce.kt", m6125i = {0}, m6126l = {C5125EACTags.INTERCHANGE_PROFILE}, m6127m = "emit", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__ReduceKt$fold$2$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6692L$0;

    /* renamed from: L$1 */
    Object f6693L$1;

    /* renamed from: label */
    int f6694label;

    /* renamed from: result */
    /* synthetic */ Object f6695result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__ReduceKt.C15062<T> f6696this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2$emit$1(FlowKt__ReduceKt.C15062<? super T> c15062, Continuation<? super FlowKt__ReduceKt$fold$2$emit$1> continuation) {
        super(continuation);
        this.f6696this$0 = c15062;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6695result = obj;
        this.f6694label |= Integer.MIN_VALUE;
        return this.f6696this$0.mo4309emit(null, this);
    }
}
