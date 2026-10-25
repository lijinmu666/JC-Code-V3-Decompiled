package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", m6124f = "SharingStarted.kt", m6125i = {0}, m6126l = {155}, m6127m = "emit", m6128n = {"count"}, m6130s = {"I$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class StartedLazily$command$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: I$0 */
    int f7028I$0;

    /* renamed from: label */
    int f7029label;

    /* renamed from: result */
    /* synthetic */ Object f7030result;

    /* renamed from: this$0 */
    final /* synthetic */ StartedLazily$command$1$1<T> f7031this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StartedLazily$command$1$1$emit$1(StartedLazily$command$1$1<? super T> startedLazily$command$1$1, Continuation<? super StartedLazily$command$1$1$emit$1> continuation) {
        super(continuation);
        this.f7031this$0 = startedLazily$command$1$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f7030result = obj;
        this.f7029label |= Integer.MIN_VALUE;
        return this.f7031this$0.m7385emit(0, this);
    }
}
