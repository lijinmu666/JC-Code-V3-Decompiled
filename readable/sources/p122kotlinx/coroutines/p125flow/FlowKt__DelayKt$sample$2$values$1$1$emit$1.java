package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.FlowKt__DelayKt$sample$2$values$1;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1", m6124f = "Delay.kt", m6125i = {0}, m6126l = {273}, m6127m = "emit", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$sample$2$values$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f6402L$0;

    /* renamed from: label */
    int f6403label;

    /* renamed from: result */
    /* synthetic */ Object f6404result;

    /* renamed from: this$0 */
    final /* synthetic */ FlowKt__DelayKt$sample$2$values$1.C14691<T> f6405this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$values$1$1$emit$1(FlowKt__DelayKt$sample$2$values$1.C14691<? super T> c14691, Continuation<? super FlowKt__DelayKt$sample$2$values$1$1$emit$1> continuation) {
        super(continuation);
        this.f6405this$0 = c14691;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6404result = obj;
        this.f6403label |= Integer.MIN_VALUE;
        return this.f6405this$0.mo4309emit(null, this);
    }
}
