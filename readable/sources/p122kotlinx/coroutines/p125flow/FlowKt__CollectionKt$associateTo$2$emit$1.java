package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.FlowKt__CollectionKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt$associateTo$2", m6124f = "Collection.kt", m6125i = {0}, m6126l = {196}, m6127m = "emit", m6128n = {"element"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__CollectionKt$associateTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6276L$0;

    /* renamed from: L$1 */
    Object f6277L$1;

    /* renamed from: label */
    int f6278label;

    /* renamed from: result */
    /* synthetic */ Object f6279result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__CollectionKt.C14502<T> f6280this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectionKt$associateTo$2$emit$1(FlowKt__CollectionKt.C14502<? super T> c14502, Continuation<? super FlowKt__CollectionKt$associateTo$2$emit$1> continuation) {
        super(continuation);
        this.f6280this$0 = c14502;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6279result = obj;
        this.f6278label |= Integer.MIN_VALUE;
        return this.f6280this$0.mo4309emit(null, this);
    }
}
