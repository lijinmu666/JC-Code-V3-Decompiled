package p122kotlinx.coroutines.channels;

import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;
import p122kotlinx.coroutines.p127selects.SelectClause1;

@ObsoleteCoroutinesApi
@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/channels/ActorScope;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <E> SelectClause1<E> getOnReceiveOrNull(ActorScope<E> actorScope) {
            return ActorScope.super.getOnReceiveOrNull();
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", m5048imports = {}))
        @Deprecated
        /* renamed from: poll */
        public static <E> E m7047poll(ActorScope<E> actorScope) {
            return (E) ActorScope.super.mo7067poll();
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
        @LowPriorityInOverloadResolution
        @Deprecated
        public static <E> Object receiveOrNull(ActorScope<E> actorScope, Continuation<? super E> continuation) {
            return ActorScope.super.receiveOrNull(continuation);
        }
    }

    InterfaceC1361Channel<E> getChannel();
}
