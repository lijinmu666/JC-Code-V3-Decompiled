package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.FlowKt__CollectionKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$4", m6124f = "Collection.kt", m6125i = {0, 1, 1, 1}, m6126l = {358, 360}, m6127m = "emit", m6128n = {"element", "element", "key", "list"}, m6130s = {"L$0", "L$0", "L$1", "L$2"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__CollectionKt$groupByTo$4$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6335L$0;

    /* renamed from: L$1 */
    Object f6336L$1;

    /* renamed from: L$2 */
    Object f6337L$2;

    /* renamed from: L$3 */
    Object f6338L$3;

    /* renamed from: label */
    int f6339label;

    /* renamed from: result */
    /* synthetic */ Object f6340result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__CollectionKt.C14594<T> f6341this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectionKt$groupByTo$4$emit$1(FlowKt__CollectionKt.C14594<? super T> c14594, Continuation<? super FlowKt__CollectionKt$groupByTo$4$emit$1> continuation) {
        super(continuation);
        this.f6341this$0 = c14594;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6340result = obj;
        this.f6339label |= Integer.MIN_VALUE;
        return this.f6341this$0.mo4309emit(null, this);
    }
}
