package p122kotlinx.coroutines.channels;

import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelIterator", m6124f = "Channel.kt", m6125i = {0}, m6126l = {1136}, m6127m = "next", m6128n = {"$this"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class ChannelIterator$next0$1<E> extends ContinuationImpl {

    /* renamed from: L$0 */
    Object f5629L$0;

    /* renamed from: label */
    int f5630label;

    /* renamed from: result */
    /* synthetic */ Object f5631result;

    /* renamed from: this$0 */
    final /* synthetic */ ChannelIterator<E> f5632this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelIterator$next0$1(ChannelIterator<? extends E> channelIterator, Continuation<? super ChannelIterator$next0$1> continuation) {
        super(continuation);
        this.f5632this$0 = channelIterator;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f5631result = obj;
        this.f5630label |= Integer.MIN_VALUE;
        return ChannelIterator.m7079next(this.f5632this$0, this);
    }
}
