package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.AbstractCoroutineContextElement;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequencesKt;
import p122kotlinx.coroutines.p127selects.SelectClause0;

@Metadata(m4987d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\fH\u0017J\u000e\u0010\u0014\u001a\u00020\u0015H\u0097@¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0017¢\u0006\u0002\u0010\u001fJ1\u0010 \u001a\u00020!2'\u0010\"\u001a#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00150#j\u0002`(H\u0017JA\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2'\u0010\"\u001a#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00150#j\u0002`(H\u0017J\u001d\u0010+\u001a\u00020\u00152\u000e\u0010'\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0017¢\u0006\u0002\u0010,J\u0012\u0010+\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010$H\u0017J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000b\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\f8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u00188VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u001bR \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020.8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0004\u001a\u0004\b0\u00101¨\u00067"}, m4988d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "message", BuildConfig.f24315FLAVOR, "parent", "getParent$annotations", "getParent", "()Lkotlinx/coroutines/Job;", "isActive", BuildConfig.f24315FLAVOR, "isActive$annotations", "()Z", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "start", "join", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "children", "Lkotlin/sequences/Sequence;", "getChildren$annotations", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "toString", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class NonCancellable extends AbstractCoroutineContextElement implements InterfaceC1342Job {
    public static final NonCancellable INSTANCE = new NonCancellable();
    private static final String message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    private NonCancellable() {
        super(InterfaceC1342Job.INSTANCE);
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public static /* synthetic */ void getChildren$annotations() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public static /* synthetic */ void getOnJoin$annotations() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public static /* synthetic */ void getParent$annotations() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public static /* synthetic */ void isActive$annotations() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public static /* synthetic */ void isCancelled$annotations() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public static /* synthetic */ void isCompleted$annotations() {
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public ChildHandle attachChild(ChildJob child) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    /* renamed from: cancel */
    public void mo6998cancel(CancellationException cause) {
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public Sequence<InterfaceC1342Job> getChildren() {
        return SequencesKt.emptySequence();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public InterfaceC1342Job getParent() {
        return null;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, C1133Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isActive() {
        return true;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isCancelled() {
        return false;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isCompleted() {
        return false;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    /* renamed from: join */
    public Object mo7000join(Continuation<? super C1133Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    /* renamed from: plus */
    public /* bridge */ InterfaceC1342Job mo7001plus(InterfaceC1342Job interfaceC1342Job) {
        return super.mo7001plus(interfaceC1342Job);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    /* renamed from: start */
    public boolean mo7002start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public /* synthetic */ boolean mo6999cancel(Throwable cause) {
        return false;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = message)
    public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, C1133Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public /* bridge */ /* synthetic */ void mo6997cancel() {
        super.mo6997cancel();
    }
}
