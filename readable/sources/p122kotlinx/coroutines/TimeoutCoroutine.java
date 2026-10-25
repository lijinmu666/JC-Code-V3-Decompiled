package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.JvmField;
import p122kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\r\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m4988d2 = {"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", BuildConfig.f24315FLAVOR, "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(JLkotlin/coroutines/Continuation;)V", "run", BuildConfig.f24315FLAVOR, "nameString", BuildConfig.f24315FLAVOR, "nameString$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {

    @JvmField
    public final long time;

    public TimeoutCoroutine(long j, Continuation<? super U> continuation) {
        super(continuation.get$context(), continuation);
        this.time = j;
    }

    @Override // p122kotlinx.coroutines.AbstractCoroutine, p122kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.time + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC1337Delay delay = C1338DelayKt.getDelay(get$context());
        CoroutineName coroutineName = (CoroutineName) get$context().mo6098get(CoroutineName.INSTANCE);
        cancelCoroutine(TimeoutKt.TimeoutCancellationException(this.time, delay, this, coroutineName != null ? coroutineName.m6954getName() : null));
    }
}
