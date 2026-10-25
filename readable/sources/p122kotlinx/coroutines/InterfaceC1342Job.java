package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.SubclassOptInRequired;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.sequences.Sequence;
import p122kotlinx.coroutines.p127selects.SelectClause0;

@Metadata(m4987d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 /2\u00020\u0001:\u0001/J\u0011\u0010\f\u001a\u00060\rj\u0002`\u000eH'¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\bH&J\u001f\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH&¢\u0006\u0002\u0010\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0017J\u0014\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0015H'J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH'J\u000e\u0010\u001e\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u001fJ1\u0010$\u001a\u00020%2'\u0010&\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120'j\u0002`*H&JE\u0010$\u001a\u00020%2\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\b2'\u0010&\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120'j\u0002`*H'J\u0011\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0000H\u0097\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00008&X§\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u00060À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "parent", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "isActive", BuildConfig.f24315FLAVOR, "()Z", "isCompleted", "isCancelled", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "start", "cancel", BuildConfig.f24315FLAVOR, "cause", "(Ljava/util/concurrent/CancellationException;)V", BuildConfig.f24315FLAVOR, "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "plus", "other", "Key", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SubclassOptInRequired(markerClass = {InternalForInheritanceCoroutinesApi.class})
/* renamed from: kotlinx.coroutines.Job */
/* loaded from: classes.dex */
public interface InterfaceC1342Job extends CoroutineContext.InterfaceC1197Element {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.Job$DefaultImpls */
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <R> R m7004fold(InterfaceC1342Job interfaceC1342Job, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6111fold(interfaceC1342Job, r, function2);
        }

        /* renamed from: get */
        public static <E extends CoroutineContext.InterfaceC1197Element> E m7005get(InterfaceC1342Job interfaceC1342Job, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6112get(interfaceC1342Job, interfaceC1198Key);
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }

        public static CoroutineContext minusKey(InterfaceC1342Job interfaceC1342Job, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return CoroutineContext.InterfaceC1197Element.DefaultImpls.minusKey(interfaceC1342Job, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static CoroutineContext m7006plus(InterfaceC1342Job interfaceC1342Job, CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC1197Element.DefaultImpls.m6113plus(interfaceC1342Job, coroutineContext);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @Deprecated
        /* renamed from: plus */
        public static InterfaceC1342Job m7007plus(InterfaceC1342Job interfaceC1342Job, InterfaceC1342Job interfaceC1342Job2) {
            return InterfaceC1342Job.super.mo7001plus(interfaceC1342Job2);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m4988d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.Job$Key, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.InterfaceC1198Key<InterfaceC1342Job> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    static /* synthetic */ void cancel$default(InterfaceC1342Job interfaceC1342Job, CancellationException cancellationException, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        interfaceC1342Job.mo6998cancel(cancellationException);
    }

    static /* synthetic */ DisposableHandle invokeOnCompletion$default(InterfaceC1342Job interfaceC1342Job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return interfaceC1342Job.invokeOnCompletion(z, z2, function1);
    }

    @InternalCoroutinesApi
    ChildHandle attachChild(ChildJob child);

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    /* synthetic */ default void mo6997cancel() {
        mo6998cancel((CancellationException) null);
    }

    /* renamed from: cancel */
    void mo6998cancel(CancellationException cause);

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    /* synthetic */ boolean mo6999cancel(Throwable cause);

    @InternalCoroutinesApi
    CancellationException getCancellationException();

    Sequence<InterfaceC1342Job> getChildren();

    SelectClause0 getOnJoin();

    InterfaceC1342Job getParent();

    DisposableHandle invokeOnCompletion(Function1<? super Throwable, C1133Unit> handler);

    @InternalCoroutinesApi
    DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, C1133Unit> handler);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    /* renamed from: join */
    Object mo7000join(Continuation<? super C1133Unit> continuation);

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    /* renamed from: plus */
    default InterfaceC1342Job mo7001plus(InterfaceC1342Job other) {
        return other;
    }

    /* renamed from: start */
    boolean mo7002start();

    static /* synthetic */ boolean cancel$default(InterfaceC1342Job interfaceC1342Job, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        return interfaceC1342Job.mo6999cancel(th);
    }
}
