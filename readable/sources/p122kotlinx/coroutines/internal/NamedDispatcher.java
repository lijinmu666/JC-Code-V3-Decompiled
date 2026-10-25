package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p122kotlinx.coroutines.CancellableContinuation;
import p122kotlinx.coroutines.CoroutineDispatcher;
import p122kotlinx.coroutines.DefaultExecutorKt;
import p122kotlinx.coroutines.DisposableHandle;
import p122kotlinx.coroutines.InterfaceC1337Delay;
import p122kotlinx.coroutines.InternalCoroutinesApi;

@Metadata(m4987d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J!\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0017¢\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0097A¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00162\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001eH\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m4988d2 = {"Lkotlinx/coroutines/internal/NamedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "name", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;)V", "isDispatchNeeded", BuildConfig.f24315FLAVOR, "context", "Lkotlin/coroutines/CoroutineContext;", "dispatch", BuildConfig.f24315FLAVOR, "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "toString", "delay", "time", BuildConfig.f24315FLAVOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class NamedDispatcher extends CoroutineDispatcher implements InterfaceC1337Delay {
    private final /* synthetic */ InterfaceC1337Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public NamedDispatcher(CoroutineDispatcher coroutineDispatcher, String str) {
        InterfaceC1337Delay interfaceC1337Delay = coroutineDispatcher instanceof InterfaceC1337Delay ? (InterfaceC1337Delay) coroutineDispatcher : null;
        this.$$delegate_0 = interfaceC1337Delay == null ? DefaultExecutorKt.getDefaultDelay() : interfaceC1337Delay;
        this.dispatcher = coroutineDispatcher;
        this.name = str;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated without replacement as an internal method never intended for public use")
    /* renamed from: delay */
    public Object mo6970delay(long j, Continuation<? super C1133Unit> continuation) {
        return this.$$delegate_0.mo6970delay(j, continuation);
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo20043dispatch(CoroutineContext context, Runnable block) {
        this.dispatcher.mo20043dispatch(context, block);
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    @InternalCoroutinesApi
    public void dispatchYield(CoroutineContext context, Runnable block) {
        this.dispatcher.dispatchYield(context, block);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return this.$$delegate_0.invokeOnTimeout(timeMillis, block, context);
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        return this.dispatcher.isDispatchNeeded(context);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo20044scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super C1133Unit> continuation) {
        this.$$delegate_0.mo20044scheduleResumeAfterDelay(timeMillis, continuation);
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: toString, reason: from getter */
    public String getName() {
        return this.name;
    }
}
