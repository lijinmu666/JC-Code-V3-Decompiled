package p122kotlinx.coroutines.p123android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.p119time.DurationKt;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.CancellableContinuation;
import p122kotlinx.coroutines.Dispatchers;
import p122kotlinx.coroutines.DisposableHandle;
import p122kotlinx.coroutines.InterfaceC1337Delay;
import p122kotlinx.coroutines.NonDisposableHandle;
import p122kotlinx.coroutines.p123android.HandlerContext;

@Metadata(m4987d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, m4988d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", BuildConfig.f24315FLAVOR, "invokeImmediately", BuildConfig.f24315FLAVOR, "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "isDispatchNeeded", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatch", BuildConfig.f24315FLAVOR, "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "scheduleResumeAfterDelay", "timeMillis", BuildConfig.f24315FLAVOR, "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "cancelOnRejection", "toString", "equals", "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-android"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,212:1\n1#2:213\n*E\n"})
/* loaded from: classes.dex */
public final class HandlerContext extends HandlerDispatcher implements InterfaceC1337Delay {
    private final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this.immediate = z ? this : new HandlerContext(handler, str, true);
    }

    private final void cancelOnRejection(CoroutineContext context, Runnable block) {
        C1344JobKt.m7012cancel(context, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.m6975getIO().mo20043dispatch(context, block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeOnTimeout$lambda$0(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleResumeAfterDelay$lambda$0(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
        cancellableContinuation.resumeUndispatched(handlerContext, C1133Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit scheduleResumeAfterDelay$lambda$1(HandlerContext handlerContext, Runnable runnable, Throwable th) {
        handlerContext.handler.removeCallbacks(runnable);
        return C1133Unit.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo20043dispatch(CoroutineContext context, Runnable block) {
        if (this.handler.post(block)) {
            return;
        }
        cancelOnRejection(context, block);
    }

    /* renamed from: equals */
    public boolean m7041equals(Object other) {
        if (other instanceof HandlerContext) {
            HandlerContext handlerContext = (HandlerContext) other;
            if (handlerContext.handler == this.handler && handlerContext.invokeImmediately == this.invokeImmediately) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.invokeImmediately ? 1231 : 1237) ^ System.identityHashCode(this.handler);
    }

    @Override // p122kotlinx.coroutines.p123android.HandlerDispatcher, p122kotlinx.coroutines.InterfaceC1337Delay
    public DisposableHandle invokeOnTimeout(long timeMillis, final Runnable block, CoroutineContext context) {
        if (this.handler.postDelayed(block, RangesKt.coerceAtMost(timeMillis, DurationKt.MAX_MILLIS))) {
            return new DisposableHandle() { // from class: o.p
                @Override // p122kotlinx.coroutines.DisposableHandle
                /* renamed from: dispose */
                public final void mo6978dispose() {
                    HandlerContext.invokeOnTimeout$lambda$0(this.f15891mjFkc, block);
                }
            };
        }
        cancelOnRejection(context, block);
        return NonDisposableHandle.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        return (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo20044scheduleResumeAfterDelay(long timeMillis, final CancellableContinuation<? super C1133Unit> continuation) {
        final Runnable runnable = new Runnable() { // from class: o.q
            @Override // java.lang.Runnable
            public final void run() {
                HandlerContext.scheduleResumeAfterDelay$lambda$0(continuation, this);
            }
        };
        if (this.handler.postDelayed(runnable, RangesKt.coerceAtMost(timeMillis, DurationKt.MAX_MILLIS))) {
            continuation.invokeOnCancellation(new Function1() { // from class: o.r
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return HandlerContext.scheduleResumeAfterDelay$lambda$1(this.f16274mjFkc, runnable, (Throwable) obj);
                }
            });
        } else {
            cancelOnRejection(continuation.get$context(), runnable);
        }
    }

    @Override // p122kotlinx.coroutines.MainCoroutineDispatcher, p122kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: toString */
    public String getName() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        if (!this.invokeImmediately) {
            return string;
        }
        return string + ".immediate";
    }

    @Override // p122kotlinx.coroutines.p123android.HandlerDispatcher, p122kotlinx.coroutines.MainCoroutineDispatcher
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
