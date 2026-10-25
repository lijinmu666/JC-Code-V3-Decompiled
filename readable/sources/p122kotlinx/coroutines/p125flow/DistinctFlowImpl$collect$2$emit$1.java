package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.DistinctFlowImpl;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", m6124f = "Distinct.kt", m6125i = {0, 0}, m6126l = {73}, m6127m = "emit", m6128n = {"value", "key"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
/* loaded from: classes.dex */
public final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6069L$0;

    /* renamed from: L$1 */
    Object f6070L$1;

    /* renamed from: label */
    int f6071label;

    /* renamed from: result */
    /* synthetic */ Object f6072result;

    /* renamed from: this$0 */
    final /* synthetic */ DistinctFlowImpl.C14252<T> f6073this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2$emit$1(DistinctFlowImpl.C14252<? super T> c14252, Continuation<? super DistinctFlowImpl$collect$2$emit$1> continuation) {
        super(continuation);
        this.f6073this$0 = c14252;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6072result = obj;
        this.f6071label |= Integer.MIN_VALUE;
        return this.f6073this$0.mo4309emit(null, this);
    }
}
