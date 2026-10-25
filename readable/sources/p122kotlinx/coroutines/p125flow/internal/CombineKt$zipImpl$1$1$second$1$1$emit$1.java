package p122kotlinx.coroutines.p125flow.internal;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.internal.CombineKt$zipImpl$1$1$second$1;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", m6124f = "Combine.kt", m6125i = {0}, m6126l = {87}, m6127m = "emit", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class CombineKt$zipImpl$1$1$second$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f7163L$0;

    /* renamed from: label */
    int f7164label;

    /* renamed from: result */
    /* synthetic */ Object f7165result;

    /* renamed from: this$0 */
    final /* synthetic */ CombineKt$zipImpl$1$1$second$1.C15701<T> f7166this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1$1$emit$1(CombineKt$zipImpl$1$1$second$1.C15701<? super T> c15701, Continuation<? super CombineKt$zipImpl$1$1$second$1$1$emit$1> continuation) {
        super(continuation);
        this.f7166this$0 = c15701;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f7165result = obj;
        this.f7164label |= Integer.MIN_VALUE;
        return this.f7166this$0.mo4309emit(null, this);
    }
}
