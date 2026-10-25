package p122kotlinx.coroutines.p125flow.internal;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p122kotlinx.coroutines.p125flow.internal.CombineKt;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", m6124f = "Combine.kt", m6125i = {0, 1}, m6126l = {29, 30}, m6127m = "emit", m6128n = {"value", "value"}, m6130s = {"L$0", "L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f7133L$0;

    /* renamed from: label */
    int f7134label;

    /* renamed from: result */
    /* synthetic */ Object f7135result;

    /* renamed from: this$0 */
    final /* synthetic */ CombineKt.C15672.AnonymousClass1.C63541<T> f7136this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2$1$1$emit$1(CombineKt.C15672.AnonymousClass1.C63541<? super T> c63541, Continuation<? super CombineKt$combineInternal$2$1$1$emit$1> continuation) {
        super(continuation);
        this.f7136this$0 = c63541;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f7135result = obj;
        this.f7134label |= Integer.MIN_VALUE;
        return this.f7136this$0.mo4309emit(null, this);
    }
}
