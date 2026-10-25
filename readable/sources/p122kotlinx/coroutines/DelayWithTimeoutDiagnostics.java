package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;

@InternalCoroutinesApi
@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "timeoutMessage", BuildConfig.f24315FLAVOR, "timeout", "Lkotlin/time/Duration;", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface DelayWithTimeoutDiagnostics extends InterfaceC1337Delay {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated without replacement as an internal method never intended for public use")
        @Deprecated
        /* renamed from: delay */
        public static Object m6973delay(DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, Continuation<? super C1133Unit> continuation) {
            return DelayWithTimeoutDiagnostics.super.mo6970delay(j, continuation);
        }

        @Deprecated
        public static DisposableHandle invokeOnTimeout(DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, Runnable runnable, CoroutineContext coroutineContext) {
            return DelayWithTimeoutDiagnostics.super.invokeOnTimeout(j, runnable, coroutineContext);
        }
    }

    /* renamed from: timeoutMessage-LRDsOJo, reason: not valid java name */
    String m19982timeoutMessageLRDsOJo(long timeout);
}
