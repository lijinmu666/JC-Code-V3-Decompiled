package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.functions.Function1;
import p122kotlinx.coroutines.DelicateCoroutinesApi;
import p122kotlinx.coroutines.internal.StackTraceRecoveryKt;
import p122kotlinx.coroutines.p127selects.SelectClause2;

@Metadata(m4987d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J-\u0010\u0017\u001a\u00020\t2#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\t0\u0019H&J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R$\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001eÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/channels/SendChannel;", "E", BuildConfig.f24315FLAVOR, "isClosedForSend", BuildConfig.f24315FLAVOR, "isClosedForSend$annotations", "()V", "()Z", "send", BuildConfig.f24315FLAVOR, "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "close", "cause", BuildConfig.f24315FLAVOR, "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface SendChannel<E> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @DelicateCoroutinesApi
        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
        @Deprecated
        /* renamed from: offer */
        public static <E> boolean m7157offer(SendChannel<? super E> sendChannel, E e) {
            return SendChannel.super.mo7053offer(e);
        }
    }

    static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        return sendChannel.mo7051close(th);
    }

    /* renamed from: close */
    boolean mo7051close(Throwable cause);

    SelectClause2<E, SendChannel<E>> getOnSend();

    void invokeOnClose(Function1<? super Throwable, C1133Unit> handler);

    boolean isClosedForSend();

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
    /* renamed from: offer */
    default boolean mo7053offer(E element) throws Throwable {
        Object objMo19989trySendJP2dKIU = mo19989trySendJP2dKIU(element);
        if (ChannelResult.m20012isSuccessimpl(objMo19989trySendJP2dKIU)) {
            return true;
        }
        Throwable thM20006exceptionOrNullimpl = ChannelResult.m20006exceptionOrNullimpl(objMo19989trySendJP2dKIU);
        if (thM20006exceptionOrNullimpl == null) {
            return false;
        }
        throw StackTraceRecoveryKt.recoverStackTrace(thM20006exceptionOrNullimpl);
    }

    /* renamed from: send */
    Object mo7052send(E e, Continuation<? super C1133Unit> continuation);

    /* renamed from: trySend-JP2dKIU */
    Object mo19989trySendJP2dKIU(E element);
}
