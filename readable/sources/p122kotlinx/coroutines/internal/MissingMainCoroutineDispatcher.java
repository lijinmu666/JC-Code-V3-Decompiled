package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CancellableContinuation;
import p122kotlinx.coroutines.CoroutineDispatcher;
import p122kotlinx.coroutines.DisposableHandle;
import p122kotlinx.coroutines.InterfaceC1337Delay;
import p122kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(m4987d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0016J\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, m4988d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", BuildConfig.f24315FLAVOR, "errorHint", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "isDispatchNeeded", BuildConfig.f24315FLAVOR, "context", "Lkotlin/coroutines/CoroutineContext;", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", BuildConfig.f24315FLAVOR, "name", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", BuildConfig.f24315FLAVOR, "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", BuildConfig.f24315FLAVOR, "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.f24315FLAVOR, "missing", "toString", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,130:1\n1#2:131\n*E\n"})
/* loaded from: classes.dex */
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements InterfaceC1337Delay {
    private final Throwable cause;
    private final String errorHint;

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.cause = th;
        this.errorHint = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: missing */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Void m7443missing() {
        String str;
        if (this.cause == null) {
            MainDispatchersKt.throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.errorHint;
        if (str2 != null) {
            str = ". " + str2;
            if (str == null) {
                str = BuildConfig.f24315FLAVOR;
            }
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString(), this.cause);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated without replacement as an internal method never intended for public use")
    /* renamed from: delay */
    public /* bridge */ Object mo6970delay(long j, Continuation<? super C1133Unit> continuation) {
        return super.mo6970delay(j, continuation);
    }

    @Override // p122kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        m7443missing();
        throw new KotlinNothingValueException();
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        m7443missing();
        throw new KotlinNothingValueException();
    }

    @Override // p122kotlinx.coroutines.MainCoroutineDispatcher, p122kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int parallelism, String name) {
        m7443missing();
        throw new KotlinNothingValueException();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1337Delay
    /* renamed from: scheduleResumeAfterDelay, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo20044scheduleResumeAfterDelay(long j, CancellableContinuation cancellableContinuation) {
        scheduleResumeAfterDelay(j, (CancellableContinuation<? super C1133Unit>) cancellableContinuation);
    }

    @Override // p122kotlinx.coroutines.MainCoroutineDispatcher, p122kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.cause != null) {
            str = ", cause=" + this.cause;
        } else {
            str = BuildConfig.f24315FLAVOR;
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch, reason: merged with bridge method [inline-methods] */
    public Void mo20043dispatch(CoroutineContext context, Runnable block) {
        m7443missing();
        throw new KotlinNothingValueException();
    }

    public Void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super C1133Unit> continuation) {
        m7443missing();
        throw new KotlinNothingValueException();
    }

    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? null : str);
    }
}
