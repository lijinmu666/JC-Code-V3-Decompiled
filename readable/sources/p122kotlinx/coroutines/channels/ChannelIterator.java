package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H¦B¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H\u0097@¢\u0006\u0004\b\u0007\u0010\u0005J\u000e\u0010\u0007\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", "E", BuildConfig.f24315FLAVOR, "hasNext", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next0", "next", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface ChannelIterator<E> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
    }

    /* renamed from: hasNext */
    Object mo7069hasNext(Continuation<? super Boolean> continuation);

    /* renamed from: next */
    E mo7070next();

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @InterfaceC1231JvmName(m6260name = "next")
    /* renamed from: next */
    /* synthetic */ default Object mo7071next(Continuation continuation) {
        return m7079next(this, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @InterfaceC1231JvmName(m6260name = "next")
    /* renamed from: next */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <E> Object m7079next(ChannelIterator<? extends E> channelIterator, Continuation<? super E> continuation) {
        ChannelIterator$next0$1 channelIterator$next0$1;
        if (continuation instanceof ChannelIterator$next0$1) {
            channelIterator$next0$1 = (ChannelIterator$next0$1) continuation;
            int i = channelIterator$next0$1.f5630label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelIterator$next0$1.f5630label = i - Integer.MIN_VALUE;
            } else {
                channelIterator$next0$1 = new ChannelIterator$next0$1(channelIterator, continuation);
            }
        }
        Object objMo7069hasNext = channelIterator$next0$1.f5631result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelIterator$next0$1.f5630label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo7069hasNext);
            channelIterator$next0$1.f5629L$0 = channelIterator;
            channelIterator$next0$1.f5630label = 1;
            objMo7069hasNext = channelIterator.mo7069hasNext(channelIterator$next0$1);
            if (objMo7069hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) channelIterator$next0$1.f5629L$0;
            ResultKt.throwOnFailure(objMo7069hasNext);
        }
        if (((Boolean) objMo7069hasNext).booleanValue()) {
            return channelIterator.mo7070next();
        }
        throw new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }
}
