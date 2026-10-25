package p122kotlinx.coroutines.channels;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.channels.BufferedChannel", m6124f = "BufferedChannel.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {736}, m6127m = "receiveCatching-JP2dKIU$suspendImpl", m6128n = {"$this", "this_$iv", "segment$iv", "updCellResult$iv", "segm", "$i$f$receiveImpl", "r$iv", "id$iv", "i$iv", "r", "i", "$i$a$-receiveImpl-BufferedChannel$receiveCatching$5"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "J$1", "I$1", "J$2", "I$2", "I$3"}, m6131v = 1)
/* loaded from: classes.dex */
public final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {

    /* renamed from: I$0 */
    int f5604I$0;

    /* renamed from: I$1 */
    int f5605I$1;

    /* renamed from: I$2 */
    int f5606I$2;

    /* renamed from: I$3 */
    int f5607I$3;

    /* renamed from: J$0 */
    long f5608J$0;

    /* renamed from: J$1 */
    long f5609J$1;

    /* renamed from: J$2 */
    long f5610J$2;

    /* renamed from: L$0 */
    Object f5611L$0;

    /* renamed from: L$1 */
    Object f5612L$1;

    /* renamed from: L$2 */
    Object f5613L$2;

    /* renamed from: L$3 */
    Object f5614L$3;

    /* renamed from: L$4 */
    Object f5615L$4;

    /* renamed from: label */
    int f5616label;

    /* renamed from: result */
    /* synthetic */ Object f5617result;

    /* renamed from: this$0 */
    final /* synthetic */ BufferedChannel<E> f5618this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.f5618this$0 = bufferedChannel;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f5617result = obj;
        this.f5616label |= Integer.MIN_VALUE;
        Object objM19993receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m19993receiveCatchingJP2dKIU$suspendImpl(this.f5618this$0, this);
        return objM19993receiveCatchingJP2dKIU$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM19993receiveCatchingJP2dKIU$suspendImpl : ChannelResult.m20002boximpl(objM19993receiveCatchingJP2dKIU$suspendImpl);
    }
}
