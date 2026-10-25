package p122kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p122kotlinx.coroutines.CoroutineExceptionHandlerKt;
import p122kotlinx.coroutines.DebugStringsKt;
import p122kotlinx.coroutines.ExceptionsKt;
import p122kotlinx.coroutines.InterfaceC1342Job;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fH\u0014¨\u0006\u0012"}, m4988d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "onCancelling", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "handleJobException", "exception", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    public ActorCoroutine(CoroutineContext coroutineContext, InterfaceC1361Channel<E> interfaceC1361Channel, boolean z) {
        super(coroutineContext, interfaceC1361Channel, false, z);
        initParentJob((InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE));
    }

    @Override // p122kotlinx.coroutines.JobSupport
    public boolean handleJobException(Throwable exception) {
        CoroutineExceptionHandlerKt.handleCoroutineException(get$context(), exception);
        return true;
    }

    @Override // p122kotlinx.coroutines.JobSupport
    public void onCancelling(Throwable cause) {
        InterfaceC1361Channel<E> interfaceC1361Channel = get_channel();
        if (cause != null) {
            CancellationException = cause instanceof CancellationException ? (CancellationException) cause : null;
            if (CancellationException == null) {
                CancellationException = ExceptionsKt.CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled", cause);
            }
        }
        interfaceC1361Channel.mo7064cancel(CancellationException);
    }
}
