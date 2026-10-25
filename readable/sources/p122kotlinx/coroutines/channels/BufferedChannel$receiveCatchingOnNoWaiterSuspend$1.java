package p122kotlinx.coroutines.channels;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.channels.BufferedChannel", m6124f = "BufferedChannel.kt", m6125i = {0, 0, 0, 0}, m6126l = {3093}, m6127m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m6128n = {"segment", "index", "r", "$i$f$suspendCancellableCoroutineReusable"}, m6130s = {"L$0", "I$0", "J$0", "I$1"}, m6131v = 1)
/* loaded from: classes.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {

    /* renamed from: I$0 */
    int f5619I$0;

    /* renamed from: I$1 */
    int f5620I$1;

    /* renamed from: J$0 */
    long f5621J$0;

    /* renamed from: L$0 */
    Object f5622L$0;

    /* renamed from: label */
    int f5623label;

    /* renamed from: result */
    /* synthetic */ Object f5624result;

    /* renamed from: this$0 */
    final /* synthetic */ BufferedChannel<E> f5625this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.f5625this$0 = bufferedChannel;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f5624result = obj;
        this.f5623label |= Integer.MIN_VALUE;
        Object objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk = this.f5625this$0.m19994receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m20002boximpl(objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
