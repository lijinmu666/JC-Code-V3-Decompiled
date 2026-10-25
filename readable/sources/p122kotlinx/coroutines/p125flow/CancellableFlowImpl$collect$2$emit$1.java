package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.CancellableFlowImpl;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", m6124f = "Context.kt", m6125i = {0}, m6126l = {280}, m6127m = "emit", m6128n = {"it"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class CancellableFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6061L$0;

    /* renamed from: label */
    int f6062label;

    /* renamed from: result */
    /* synthetic */ Object f6063result;

    /* renamed from: this$0 */
    final /* synthetic */ CancellableFlowImpl.C14242<T> f6064this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl$collect$2$emit$1(CancellableFlowImpl.C14242<? super T> c14242, Continuation<? super CancellableFlowImpl$collect$2$emit$1> continuation) {
        super(continuation);
        this.f6064this$0 = c14242;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6063result = obj;
        this.f6062label |= Integer.MIN_VALUE;
        return this.f6064this$0.mo4309emit(null, this);
    }
}
