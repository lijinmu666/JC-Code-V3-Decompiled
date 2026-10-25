package p122kotlinx.coroutines.p125flow.internal;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlowTransformLatest;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", m6124f = "Merge.kt", m6125i = {0, 0, 0}, m6126l = {26}, m6127m = "emit", m6128n = {"value", "$this$emit_u24lambda_u240", "$i$a$-apply-ChannelFlowTransformLatest$flowCollect$3$1$1"}, m6130s = {"L$0", "L$2", "I$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class ChannelFlowTransformLatest$flowCollect$3$1$emit$1 extends ContinuationImpl {

    /* renamed from: I$0 */
    int f7107I$0;

    /* renamed from: L$0 */
    Object f7108L$0;

    /* renamed from: L$1 */
    Object f7109L$1;

    /* renamed from: L$2 */
    Object f7110L$2;

    /* renamed from: label */
    int f7111label;

    /* renamed from: result */
    /* synthetic */ Object f7112result;

    /* renamed from: this$0 */
    final /* synthetic */ ChannelFlowTransformLatest.C15663.AnonymousClass1<T> f7113this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3$1$emit$1(ChannelFlowTransformLatest.C15663.AnonymousClass1<? super T> anonymousClass1, Continuation<? super ChannelFlowTransformLatest$flowCollect$3$1$emit$1> continuation) {
        super(continuation);
        this.f7113this$0 = anonymousClass1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f7112result = obj;
        this.f7111label |= Integer.MIN_VALUE;
        return this.f7113this$0.mo4309emit(null, this);
    }
}
