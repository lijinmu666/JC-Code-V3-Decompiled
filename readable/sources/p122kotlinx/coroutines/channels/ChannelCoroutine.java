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
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.AbstractCoroutine;
import p122kotlinx.coroutines.JobCancellationException;
import p122kotlinx.coroutines.JobSupport;
import p122kotlinx.coroutines.p127selects.SelectClause1;
import p122kotlinx.coroutines.p127selects.SelectClause2;

@Metadata(m4987d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u0003H\u0017J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001b\u0010\u0011\u001a\u00020\u00032\u000e\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J.\u0010\u0019\u001a\u00020\u00032#\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u001bH\u0096\u0001J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0003J\u0016\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u0004\u0018\u00018\u0000H\u0097\u0001¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0096A¢\u0006\u0004\b)\u0010&J\u0010\u0010*\u001a\u0004\u0018\u00018\u0000H\u0097A¢\u0006\u0002\u0010&J\u0016\u0010+\u001a\u00020\u00032\u0006\u0010!\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0096\u0001¢\u0006\u0004\b.\u0010$J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030(2\u0006\u0010!\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b0\u00101R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u00102\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b4\u00103R\u0014\u00105\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b5\u00103R\u0018\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u001e\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(07X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u00109R\u001c\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000078VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b=\u00109R$\u0010>\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0?X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006C"}, m4988d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "initParentJob", BuildConfig.f24315FLAVOR, "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "cancel", "cause", BuildConfig.f24315FLAVOR, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive", "tryReceive-PtdJZtk", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,39:1\n733#2,2:40\n733#2,2:42\n733#2,2:44\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n17#1:40,2\n23#1:42,2\n30#1:44,2\n*E\n"})
/* loaded from: classes.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<C1133Unit> implements InterfaceC1361Channel<E> {
    private final InterfaceC1361Channel<E> _channel;

    public ChannelCoroutine(CoroutineContext coroutineContext, InterfaceC1361Channel<E> interfaceC1361Channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this._channel = interfaceC1361Channel;
    }

    @Override // p122kotlinx.coroutines.JobSupport, p122kotlinx.coroutines.InterfaceC1342Job
    /* renamed from: cancel */
    public final void mo6998cancel(CancellationException cause) {
        if (isCancelled()) {
            return;
        }
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    @Override // p122kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable cause) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, cause, null, 1, null);
        this._channel.mo7064cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean mo7051close(Throwable cause) {
        return this._channel.mo7051close(cause);
    }

    public final InterfaceC1361Channel<E> getChannel() {
        return this;
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    public final InterfaceC1361Channel<E> get_channel() {
        return this._channel;
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, C1133Unit> handler) {
        this._channel.invokeOnClose(handler);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: isEmpty */
    public boolean mo7066isEmpty() {
        return this._channel.mo7066isEmpty();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
    /* renamed from: offer */
    public boolean mo7053offer(E element) {
        return this._channel.mo7053offer(element);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", m5048imports = {}))
    /* renamed from: poll */
    public E mo7067poll() {
        return this._channel.mo7067poll();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receive */
    public Object mo7068receive(Continuation<? super E> continuation) {
        return this._channel.mo7068receive(continuation);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo19995receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object objMo19995receiveCatchingJP2dKIU = this._channel.mo19995receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objMo19995receiveCatchingJP2dKIU;
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return this._channel.receiveOrNull(continuation);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: send */
    public Object mo7052send(E e, Continuation<? super C1133Unit> continuation) {
        return this._channel.mo7052send(e, continuation);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo19996tryReceivePtdJZtk() {
        return this._channel.mo19996tryReceivePtdJZtk();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo19989trySendJP2dKIU(E element) {
        return this._channel.mo19989trySendJP2dKIU(element);
    }

    @Override // p122kotlinx.coroutines.JobSupport, p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public /* synthetic */ void mo6997cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // p122kotlinx.coroutines.JobSupport, p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public final /* synthetic */ boolean mo6999cancel(Throwable cause) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }
}
