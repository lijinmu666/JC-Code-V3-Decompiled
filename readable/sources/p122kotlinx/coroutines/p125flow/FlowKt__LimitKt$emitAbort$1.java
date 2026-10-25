package p122kotlinx.coroutines.p125flow;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt", m6124f = "Limit.kt", m6125i = {0, 0, 0}, m6126l = {C5125EACTags.MESSAGE_REFERENCE}, m6127m = "emitAbort$FlowKt__LimitKt", m6128n = {"$this$emitAbort", "value", "ownershipMarker"}, m6130s = {"L$0", "L$1", "L$2"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$emitAbort$1<T> extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6553L$0;

    /* renamed from: L$1 */
    Object f6554L$1;

    /* renamed from: L$2 */
    Object f6555L$2;

    /* renamed from: label */
    int f6556label;

    /* renamed from: result */
    /* synthetic */ Object f6557result;

    public FlowKt__LimitKt$emitAbort$1(Continuation<? super FlowKt__LimitKt$emitAbort$1> continuation) {
        super(continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6557result = obj;
        this.f6556label |= Integer.MIN_VALUE;
        return FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(null, null, null, this);
    }
}
