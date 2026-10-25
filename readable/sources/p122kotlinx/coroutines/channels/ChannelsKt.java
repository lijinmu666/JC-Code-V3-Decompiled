package p122kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p094kotlin.BuilderInference;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(m4987d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, m4989k = 4, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @PublishedApi
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, th);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    /* renamed from: consume */
    public static final <E, R> R m7087consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__DeprecatedKt.m7113consume(broadcastChannel, function1);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        return ChannelsKt__DeprecatedKt.consumeEach(broadcastChannel, function1, continuation);
    }

    public static final <E, C extends Collection<E>> Object consumeTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.consumeTo(receiveChannel, c, continuation);
    }

    @PublishedApi
    public static final Function1<Throwable, C1133Unit> consumes(ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.consumes(receiveChannel);
    }

    @PublishedApi
    public static final Function1<Throwable, C1133Unit> consumesAll(ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__DeprecatedKt.consumesAll(receiveChannelArr);
    }

    @PublishedApi
    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    /* renamed from: filter */
    public static final <E> ReceiveChannel<E> m7091filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.m7116filter(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.filterNotNull(receiveChannel);
    }

    @PublishedApi
    /* renamed from: map */
    public static final <E, R> ReceiveChannel<R> m7096map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.m7121map(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__DeprecatedKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a Job to coroutine builders breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    /* renamed from: produce */
    public static final <E> ReceiveChannel<E> m7100produce(CoroutineScope coroutineScope, InterfaceC1342Job interfaceC1342Job, int i, @BuilderInference Function2<? super ProducerScope<? super E>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.m7126produce(coroutineScope, interfaceC1342Job, i, function2);
    }

    @PublishedApi
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.toChannel(receiveChannel, c, continuation);
    }

    @PublishedApi
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.toCollection(receiveChannel, c, continuation);
    }

    /* renamed from: toList */
    public static final <E> Object m7103toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.m7110toList(receiveChannel, continuation);
    }

    @PublishedApi
    /* renamed from: toMap */
    public static final <K, V, M extends Map<? super K, ? super V>> Object m7104toMap(ReceiveChannel<? extends C1122Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.m7129toMap(receiveChannel, m, continuation);
    }

    @PublishedApi
    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt__DeprecatedKt.toMutableSet(receiveChannel, continuation);
    }

    public static final <E> Object trySendBlocking(SendChannel<? super E> sendChannel, E e) {
        return ChannelsKt__ChannelsKt.trySendBlocking(sendChannel, e);
    }

    /* renamed from: consume */
    public static final <E, R> R m7088consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.m7109consume(receiveChannel, function1);
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(receiveChannel, function1, continuation);
    }

    @PublishedApi
    /* renamed from: zip */
    public static final <E, R, V> ReceiveChannel<V> m7108zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ChannelsKt__DeprecatedKt.m7134zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
