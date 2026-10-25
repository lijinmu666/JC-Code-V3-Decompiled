package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.TypeIntrinsics;
import p122kotlinx.coroutines.intrinsics.CancellableKt;
import p122kotlinx.coroutines.p127selects.SelectClause2;
import p122kotlinx.coroutines.p127selects.SelectClause2Impl;
import p122kotlinx.coroutines.p127selects.SelectInstance;

@Metadata(m4987d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BL\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u000bH\u0014J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001e\u0010&\u001a\u00020\u000b2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0 8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, m4988d2 = {"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "offer", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;)Z", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "close", "cause", BuildConfig.f24315FLAVOR, "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSendRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class LazyActorCoroutine<E> extends ActorCoroutine<E> {
    private Continuation<? super C1133Unit> continuation;

    public LazyActorCoroutine(CoroutineContext coroutineContext, InterfaceC1361Channel<E> interfaceC1361Channel, Function2<? super ActorScope<E>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        super(coroutineContext, interfaceC1361Channel, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(function2, this, this);
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSendRegFunction(SelectInstance<?> select, Object element) throws Throwable {
        mo7025onStart();
        super.getOnSend().getRegFunc().mo6219invoke(this, select, element);
    }

    @Override // p122kotlinx.coroutines.channels.ChannelCoroutine, p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean mo7051close(Throwable cause) {
        boolean zMo7051close = super.mo7051close(cause);
        mo7002start();
        return zMo7051close;
    }

    @Override // p122kotlinx.coroutines.channels.ChannelCoroutine, p122kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        LazyActorCoroutine$onSend$1 lazyActorCoroutine$onSend$1 = LazyActorCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(lazyActorCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause2Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(lazyActorCoroutine$onSend$1, 3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    @Override // p122kotlinx.coroutines.channels.ChannelCoroutine, p122kotlinx.coroutines.channels.SendChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
    /* renamed from: offer */
    public boolean mo7053offer(E element) {
        mo7002start();
        return super.mo7053offer(element);
    }

    @Override // p122kotlinx.coroutines.JobSupport
    /* renamed from: onStart */
    public void mo7025onStart() throws Throwable {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }

    @Override // p122kotlinx.coroutines.channels.ChannelCoroutine, p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: send */
    public Object mo7052send(E e, Continuation<? super C1133Unit> continuation) {
        mo7002start();
        Object objMo7052send = super.mo7052send(e, continuation);
        return objMo7052send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo7052send : C1133Unit.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.channels.ChannelCoroutine, p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo19989trySendJP2dKIU(E element) {
        mo7002start();
        return super.mo19989trySendJP2dKIU(element);
    }
}
