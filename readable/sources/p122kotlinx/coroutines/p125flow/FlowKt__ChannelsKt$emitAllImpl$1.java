package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", m6124f = "Channels.kt", m6125i = {0, 0, 0, 1, 1, 1, 1}, m6126l = {32, 33}, m6127m = "emitAllImpl$FlowKt__ChannelsKt", m6128n = {"$this$emitAllImpl", "channel", "consume", "$this$emitAllImpl", "channel", "element", "consume"}, m6130s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$3", "Z$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6199L$0;

    /* renamed from: L$1 */
    Object f6200L$1;

    /* renamed from: L$2 */
    Object f6201L$2;

    /* renamed from: L$3 */
    Object f6202L$3;

    /* renamed from: Z$0 */
    boolean f6203Z$0;

    /* renamed from: label */
    int f6204label;

    /* renamed from: result */
    /* synthetic */ Object f6205result;

    public FlowKt__ChannelsKt$emitAllImpl$1(Continuation<? super FlowKt__ChannelsKt$emitAllImpl$1> continuation) {
        super(continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6205result = obj;
        this.f6204label |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
    }
}
