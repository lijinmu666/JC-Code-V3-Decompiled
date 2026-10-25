package p122kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.functions.Function1;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;
import p122kotlinx.coroutines.p127selects.SelectClause2;

@Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@ObsoleteCoroutinesApi
@Metadata(m4987d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0097\u0001J\u001e\u0010\u000e\u001a\u00020\u00122\u000e\u0010\u0010\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0096\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J.\u0010\u0017\u001a\u00020\u00122#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00120\u0019H\u0096\u0001J\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010\u001eJ\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0001J\u0016\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u001d\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010'\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R$\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0*X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006."}, m4988d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcast", "Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "()V", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull", "cancel", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosedForSend", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    private final BroadcastChannelImpl<E> broadcast;

    private ConflatedBroadcastChannel(BroadcastChannelImpl<E> broadcastChannelImpl) {
        this.broadcast = broadcastChannelImpl;
    }

    @Override // p122kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: cancel */
    public void mo7048cancel(CancellationException cause) {
        this.broadcast.mo7064cancel(cause);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean mo7051close(Throwable cause) {
        return this.broadcast.mo7051close(cause);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this.broadcast.getOnSend();
    }

    public final E getValue() {
        return this.broadcast.getValue();
    }

    public final E getValueOrNull() {
        return this.broadcast.getValueOrNull();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, C1133Unit> handler) {
        this.broadcast.invokeOnClose(handler);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.broadcast.isClosedForSend();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
    /* renamed from: offer */
    public boolean mo7053offer(E element) {
        return this.broadcast.mo7053offer(element);
    }

    @Override // p122kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        return this.broadcast.openSubscription();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: send */
    public Object mo7052send(E e, Continuation<? super C1133Unit> continuation) {
        return this.broadcast.mo7052send(e, continuation);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo19989trySendJP2dKIU(E element) {
        return this.broadcast.mo19989trySendJP2dKIU(element);
    }

    @Override // p122kotlinx.coroutines.channels.BroadcastChannel
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility only")
    /* renamed from: cancel */
    public /* synthetic */ boolean mo7049cancel(Throwable cause) {
        return this.broadcast.mo7065cancel(cause);
    }

    public ConflatedBroadcastChannel() {
        this(new BroadcastChannelImpl(-1));
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        mo19989trySendJP2dKIU(e);
    }
}
