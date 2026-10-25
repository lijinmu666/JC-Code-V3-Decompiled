package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.sequences.Sequence;
import p122kotlinx.coroutines.p127selects.SelectClause0;
import p122kotlinx.coroutines.p127selects.SelectClause1;

@Metadata(m4987d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0097\u0001J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0097\u0001J\t\u0010\u0011\u001a\u00020\u0015H\u0097\u0001J\u001e\u0010\u0011\u001a\u00020\u00152\u000e\u0010\u0013\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0096\u0001¢\u0006\u0002\u0010\u0018J<\u0010\u0019\u001a\u0002H\u001a\"\n\b\u0001\u0010\u001a*\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u0002H\u001a2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001a0\u001eH\u0096\u0001¢\u0006\u0002\u0010 J(\u0010!\u001a\u0004\u0018\u0001H\"\"\b\b\u0001\u0010\"*\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0096\u0003¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u00060\u0016j\u0002`\u0017H\u0097\u0001¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010)J\u000b\u0010*\u001a\u0004\u0018\u00010\u0014H\u0097\u0001J2\u0010+\u001a\u00020,2'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00150.j\u0002`1H\u0096\u0001JB\u0010+\u001a\u00020,2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00150.j\u0002`1H\u0097\u0001J\u000e\u00104\u001a\u00020\u0015H\u0096A¢\u0006\u0002\u0010\u0010J\u0015\u00105\u001a\u0002062\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0096\u0001J\u0011\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0096\u0003J\u0011\u00107\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0097\u0003J\t\u0010;\u001a\u00020\u0012H\u0096\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010<\u001a\b\u0012\u0004\u0012\u0002090=X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0012\u0010@\u001a\u00020\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010AR\u0012\u0010C\u001a\u00020\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010AR\u0016\u0010#\u001a\u0006\u0012\u0002\b\u00030$X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000GX\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0012\u0010J\u001a\u00020KX\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0016\u0010N\u001a\u0004\u0018\u0001098\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006Q"}, m4988d2 = {"Lkotlinx/coroutines/ReadonlyDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "<init>", "(Lkotlinx/coroutines/CompletableDeferred;)V", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "toString", BuildConfig.f24315FLAVOR, "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "fold", "R", BuildConfig.f24315FLAVOR, "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "join", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "plus", "context", "Lkotlinx/coroutines/Job;", "other", "start", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "()Z", "isCancelled", "isCompleted", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class ReadonlyDeferred<T> implements Deferred<T> {
    private final CompletableDeferred<T> deferred;

    public ReadonlyDeferred(CompletableDeferred<T> completableDeferred) {
        this.deferred = completableDeferred;
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @InternalCoroutinesApi
    public ChildHandle attachChild(ChildJob child) {
        return this.deferred.attachChild(child);
    }

    @Override // p122kotlinx.coroutines.Deferred
    /* renamed from: await */
    public Object mo6928await(Continuation<? super T> continuation) {
        return this.deferred.mo6928await(continuation);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public /* synthetic */ void mo6997cancel() {
        this.deferred.mo6997cancel();
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    /* renamed from: fold */
    public <R> R mo6097fold(R initial, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> operation) {
        return (R) this.deferred.mo6097fold(initial, operation);
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    /* renamed from: get */
    public <E extends CoroutineContext.InterfaceC1197Element> E mo6098get(CoroutineContext.InterfaceC1198Key<E> key) {
        return (E) this.deferred.mo6098get(key);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @InternalCoroutinesApi
    public CancellationException getCancellationException() {
        return this.deferred.getCancellationException();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public Sequence<InterfaceC1342Job> getChildren() {
        return this.deferred.getChildren();
    }

    @Override // p122kotlinx.coroutines.Deferred
    @ExperimentalCoroutinesApi
    public T getCompleted() {
        return this.deferred.getCompleted();
    }

    @Override // p122kotlinx.coroutines.Deferred
    @ExperimentalCoroutinesApi
    public Throwable getCompletionExceptionOrNull() {
        return this.deferred.getCompletionExceptionOrNull();
    }

    public final CompletableDeferred<T> getDeferred() {
        return this.deferred;
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element
    /* renamed from: getKey */
    public CoroutineContext.InterfaceC1198Key<?> mo6099getKey() {
        return this.deferred.mo6099getKey();
    }

    @Override // p122kotlinx.coroutines.Deferred
    public SelectClause1<T> getOnAwait() {
        return this.deferred.getOnAwait();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public SelectClause0 getOnJoin() {
        return this.deferred.getOnJoin();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public InterfaceC1342Job getParent() {
        return this.deferred.getParent();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, C1133Unit> handler) {
        return this.deferred.invokeOnCompletion(handler);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isActive() {
        return this.deferred.isActive();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isCancelled() {
        return this.deferred.isCancelled();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    public boolean isCompleted() {
        return this.deferred.isCompleted();
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    /* renamed from: join */
    public Object mo7000join(Continuation<? super C1133Unit> continuation) {
        return this.deferred.mo7000join(continuation);
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC1198Key<?> key) {
        return this.deferred.minusKey(key);
    }

    @Override // p094kotlin.coroutines.CoroutineContext
    /* renamed from: plus */
    public CoroutineContext mo6100plus(CoroutineContext context) {
        return this.deferred.mo6100plus(context);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    /* renamed from: start */
    public boolean mo7002start() {
        return this.deferred.mo7002start();
    }

    public String toString() {
        return "ReadonlyDeferred(" + this.deferred + ')';
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    /* renamed from: cancel */
    public void mo6998cancel(CancellationException cause) {
        this.deferred.mo6998cancel(cause);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @InternalCoroutinesApi
    public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, C1133Unit> handler) {
        return this.deferred.invokeOnCompletion(onCancelling, invokeImmediately, handler);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    /* renamed from: plus */
    public InterfaceC1342Job mo7001plus(InterfaceC1342Job other) {
        return this.deferred.mo7001plus(other);
    }

    @Override // p122kotlinx.coroutines.InterfaceC1342Job
    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public /* synthetic */ boolean mo6999cancel(Throwable cause) {
        return this.deferred.mo6999cancel(cause);
    }
}
