package p122kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.DelicateCoroutinesApi;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.internal.StackTraceRecoveryKt;
import p122kotlinx.coroutines.p127selects.SelectClause1;

@Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000e\u0010\n\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H¦@¢\u0006\u0004\b\u0012\u0010\u000bJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H¦\u0002J\u001f\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH&¢\u0006\u0002\u0010\u001fJ\b\u0010\u001a\u001a\u00020\u001bH\u0017J\u0014\u0010\u001a\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010 H'J\u000f\u0010!\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0097@¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\"\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\r8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010\u000f¨\u0006&À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", BuildConfig.f24315FLAVOR, "isClosedForReceive", BuildConfig.f24315FLAVOR, "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "receiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "onReceiveCatching", "getOnReceiveCatching", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "cancel", BuildConfig.f24315FLAVOR, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", BuildConfig.f24315FLAVOR, "poll", "receiveOrNull", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface ReceiveChannel<E> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <E> SelectClause1<E> getOnReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
            return ReceiveChannel.super.getOnReceiveOrNull();
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @ReplaceWith(expression = "onReceiveCatching", m5048imports = {}))
        public static /* synthetic */ void getOnReceiveOrNull$annotations() {
        }

        @DelicateCoroutinesApi
        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isEmpty$annotations() {
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", m5048imports = {}))
        @Deprecated
        /* renamed from: poll */
        public static <E> E m7156poll(ReceiveChannel<? extends E> receiveChannel) {
            return (E) ReceiveChannel.super.mo7067poll();
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
        @LowPriorityInOverloadResolution
        @Deprecated
        public static <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
            return ReceiveChannel.super.receiveOrNull(continuation);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ReceiveChannel", m6124f = "Channel.kt", m6125i = {0}, m6126l = {770}, m6127m = "receiveOrNull$suspendImpl", m6128n = {"$this"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 */
    public static final class C14071<E> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f5986L$0;

        /* renamed from: label */
        int f5987label;

        /* renamed from: result */
        /* synthetic */ Object f5988result;

        /* renamed from: this$0 */
        final /* synthetic */ ReceiveChannel<E> f5989this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14071(ReceiveChannel<? extends E> receiveChannel, Continuation<? super C14071> continuation) {
            super(continuation);
            this.f5989this$0 = receiveChannel;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5988result = obj;
            this.f5987label |= Integer.MIN_VALUE;
            return ReceiveChannel.receiveOrNull$suspendImpl(this.f5989this$0, this);
        }
    }

    static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        receiveChannel.mo7064cancel(cancellationException);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
    @LowPriorityInOverloadResolution
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <E> Object receiveOrNull$suspendImpl(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        C14071 c14071;
        Object objMo19995receiveCatchingJP2dKIU;
        if (continuation instanceof C14071) {
            c14071 = (C14071) continuation;
            int i = c14071.f5987label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14071.f5987label = i - Integer.MIN_VALUE;
            } else {
                c14071 = new C14071(receiveChannel, continuation);
            }
        }
        Object obj = c14071.f5988result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14071.f5987label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c14071.f5986L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
            c14071.f5987label = 1;
            objMo19995receiveCatchingJP2dKIU = receiveChannel.mo19995receiveCatchingJP2dKIU(c14071);
            if (objMo19995receiveCatchingJP2dKIU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objMo19995receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
        }
        return ChannelResult.m20007getOrNullimpl(objMo19995receiveCatchingJP2dKIU);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    /* synthetic */ default void mo7063cancel() {
        mo7064cancel((CancellationException) null);
    }

    /* renamed from: cancel */
    void mo7064cancel(CancellationException cause);

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    /* synthetic */ boolean mo7065cancel(Throwable cause);

    SelectClause1<E> getOnReceive();

    SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    default SelectClause1<E> getOnReceiveOrNull() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
        return ((BufferedChannel) this).getOnReceiveOrNull();
    }

    boolean isClosedForReceive();

    /* renamed from: isEmpty */
    boolean mo7066isEmpty();

    ChannelIterator<E> iterator();

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", m5048imports = {}))
    /* renamed from: poll */
    default E mo7067poll() throws Throwable {
        Object objMo19996tryReceivePtdJZtk = mo19996tryReceivePtdJZtk();
        if (ChannelResult.m20012isSuccessimpl(objMo19996tryReceivePtdJZtk)) {
            return (E) ChannelResult.m20008getOrThrowimpl(objMo19996tryReceivePtdJZtk);
        }
        Throwable thM20006exceptionOrNullimpl = ChannelResult.m20006exceptionOrNullimpl(objMo19996tryReceivePtdJZtk);
        if (thM20006exceptionOrNullimpl == null) {
            return null;
        }
        throw StackTraceRecoveryKt.recoverStackTrace(thM20006exceptionOrNullimpl);
    }

    /* renamed from: receive */
    Object mo7068receive(Continuation<? super E> continuation);

    /* renamed from: receiveCatching-JP2dKIU */
    Object mo19995receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation);

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
    @LowPriorityInOverloadResolution
    default Object receiveOrNull(Continuation<? super E> continuation) {
        return receiveOrNull$suspendImpl(this, continuation);
    }

    /* renamed from: tryReceive-PtdJZtk */
    Object mo19996tryReceivePtdJZtk();

    static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        return receiveChannel.mo7065cancel(th);
    }
}
