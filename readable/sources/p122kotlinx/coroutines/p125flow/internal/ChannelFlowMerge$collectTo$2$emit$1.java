package p122kotlinx.coroutines.p125flow.internal;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlowMerge;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", m6124f = "Merge.kt", m6125i = {0}, m6126l = {62}, m6127m = "emit", m6128n = {"inner"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class ChannelFlowMerge$collectTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f7091L$0;

    /* renamed from: label */
    int f7092label;

    /* renamed from: result */
    /* synthetic */ Object f7093result;

    /* renamed from: this$0 */
    final /* synthetic */ ChannelFlowMerge.C15642<T> f7094this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2$emit$1(ChannelFlowMerge.C15642<? super T> c15642, Continuation<? super ChannelFlowMerge$collectTo$2$emit$1> continuation) {
        super(continuation);
        this.f7094this$0 = c15642;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f7093result = obj;
        this.f7092label |= Integer.MIN_VALUE;
        return this.f7094this$0.m7390emit((InterfaceC1426Flow) null, (Continuation<? super C1133Unit>) this);
    }
}
