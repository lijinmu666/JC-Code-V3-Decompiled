package p122kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.AbstractCoroutine;
import p122kotlinx.coroutines.CoroutineExceptionHandlerKt;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.JobCancellationException;
import p122kotlinx.coroutines.JobSupport;
import p122kotlinx.coroutines.p127selects.SelectClause2;

@Metadata(m4987d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001b\u0010\u0015\u001a\u00020\u00032\u000e\u0010\u0016\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0015\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\nH\u0014J\u0012\u0010!\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J.\u0010\"\u001a\u00020\u00032#\u0010#\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030$H\u0096\u0001J\u0016\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010)J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0096\u0001J\u0016\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030/2\u0006\u0010(\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b0\u00101R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u00102\u001a\u00020\n8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b2\u0010\u0010R$\u00103\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001204X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00067"}, m4988d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "isActive", "()Z", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "cancel", "cause", BuildConfig.f24315FLAVOR, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "onCompleted", "value", "(Lkotlin/Unit;)V", "onCancelled", "handled", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosedForSend", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,124:1\n733#2,2:125\n733#2,2:127\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n73#1:125,2\n79#1:127,2\n*E\n"})
/* loaded from: classes.dex */
class BroadcastCoroutine<E> extends AbstractCoroutine<C1133Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    private final BroadcastChannel<E> _channel;

    public BroadcastCoroutine(CoroutineContext coroutineContext, BroadcastChannel<E> broadcastChannel, boolean z) {
        super(coroutineContext, false, z);
        this._channel = broadcastChannel;
        initParentJob((InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE));
    }

    @Override // p122kotlinx.coroutines.JobSupport, p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public final /* synthetic */ boolean mo6999cancel(Throwable cause) {
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
        return true;
    }

    @Override // p122kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable cause) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, cause, null, 1, null);
        this._channel.mo7048cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean mo7051close(Throwable cause) {
        boolean zMo7051close = this._channel.mo7051close(cause);
        mo7002start();
        return zMo7051close;
    }

    @Override // p122kotlinx.coroutines.channels.ProducerScope
    public SendChannel<E> getChannel() {
        return this;
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    public final BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, C1133Unit> handler) {
        this._channel.invokeOnClose(handler);
    }

    @Override // p122kotlinx.coroutines.AbstractCoroutine, p122kotlinx.coroutines.JobSupport, p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
    /* renamed from: offer */
    public boolean mo7053offer(E element) {
        return this._channel.mo7053offer(element);
    }

    @Override // p122kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(Throwable cause, boolean handled) {
        if (this._channel.mo7051close(cause) || handled) {
            return;
        }
        CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), cause);
    }

    @Override // p122kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: send */
    public Object mo7052send(E e, Continuation<? super C1133Unit> continuation) {
        return this._channel.mo7052send(e, continuation);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo19989trySendJP2dKIU(E element) {
        return this._channel.mo19989trySendJP2dKIU(element);
    }

    @Override // p122kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(C1133Unit value) {
        SendChannel.close$default(this._channel, null, 1, null);
    }

    @Override // p122kotlinx.coroutines.JobSupport, p122kotlinx.coroutines.InterfaceC1342Job
    /* renamed from: cancel */
    public final void mo6998cancel(CancellationException cause) {
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }
}
