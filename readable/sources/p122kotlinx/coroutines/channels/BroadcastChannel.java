package p122kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;

@ObsoleteCoroutinesApi
@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u001f\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH&¢\u0006\u0002\u0010\nJ\u0014\u0010\u0005\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\fH'¨\u0006\rÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cancel", BuildConfig.f24315FLAVOR, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
/* loaded from: classes.dex */
public interface BroadcastChannel<E> extends SendChannel<E> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
        @Deprecated
        /* renamed from: offer */
        public static <E> boolean m7050offer(BroadcastChannel<E> broadcastChannel, E e) {
            return BroadcastChannel.super.mo7053offer(e);
        }
    }

    static /* synthetic */ void cancel$default(BroadcastChannel broadcastChannel, CancellationException cancellationException, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        broadcastChannel.mo7048cancel(cancellationException);
    }

    /* renamed from: cancel */
    void mo7048cancel(CancellationException cause);

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Binary compatibility only")
    /* renamed from: cancel */
    /* synthetic */ boolean mo7049cancel(Throwable cause);

    ReceiveChannel<E> openSubscription();

    static /* synthetic */ boolean cancel$default(BroadcastChannel broadcastChannel, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        return broadcastChannel.mo7049cancel(th);
    }
}
