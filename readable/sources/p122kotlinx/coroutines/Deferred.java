package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.SubclassOptInRequired;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.p127selects.SelectClause1;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000e\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0004J\r\u0010\t\u001a\u00028\u0000H'¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH'R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\rÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/Deferred;", "T", "Lkotlinx/coroutines/Job;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SubclassOptInRequired(markerClass = {InternalForInheritanceCoroutinesApi.class})
/* loaded from: classes.dex */
public interface Deferred<T> extends InterfaceC1342Job {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <T, R> R m6966fold(Deferred<? extends T> deferred, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) InterfaceC1342Job.DefaultImpls.m7004fold(deferred, r, function2);
        }

        /* renamed from: get */
        public static <T, E extends CoroutineContext.InterfaceC1197Element> E m6967get(Deferred<? extends T> deferred, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) InterfaceC1342Job.DefaultImpls.m7005get(deferred, interfaceC1198Key);
        }

        public static <T> CoroutineContext minusKey(Deferred<? extends T> deferred, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return InterfaceC1342Job.DefaultImpls.minusKey(deferred, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static <T> CoroutineContext m6968plus(Deferred<? extends T> deferred, CoroutineContext coroutineContext) {
            return InterfaceC1342Job.DefaultImpls.m7006plus(deferred, coroutineContext);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @Deprecated
        /* renamed from: plus */
        public static <T> InterfaceC1342Job m6969plus(Deferred<? extends T> deferred, InterfaceC1342Job interfaceC1342Job) {
            return Deferred.super.mo7001plus(interfaceC1342Job);
        }
    }

    /* renamed from: await */
    Object mo6928await(Continuation<? super T> continuation);

    @ExperimentalCoroutinesApi
    T getCompleted();

    @ExperimentalCoroutinesApi
    Throwable getCompletionExceptionOrNull();

    SelectClause1<T> getOnAwait();
}
