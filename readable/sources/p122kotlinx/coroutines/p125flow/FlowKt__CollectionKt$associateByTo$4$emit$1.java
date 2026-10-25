package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.FlowKt__CollectionKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$4", m6124f = "Collection.kt", m6125i = {0, 1}, m6126l = {163, 163}, m6127m = "emit", m6128n = {"element", "element"}, m6130s = {"L$0", "L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__CollectionKt$associateByTo$4$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6264L$0;

    /* renamed from: L$1 */
    Object f6265L$1;

    /* renamed from: L$2 */
    Object f6266L$2;

    /* renamed from: label */
    int f6267label;

    /* renamed from: result */
    /* synthetic */ Object f6268result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__CollectionKt.C14484<T> f6269this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectionKt$associateByTo$4$emit$1(FlowKt__CollectionKt.C14484<? super T> c14484, Continuation<? super FlowKt__CollectionKt$associateByTo$4$emit$1> continuation) {
        super(continuation);
        this.f6269this$0 = c14484;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6268result = obj;
        this.f6267label |= Integer.MIN_VALUE;
        return this.f6269this$0.mo4309emit(null, this);
    }
}
