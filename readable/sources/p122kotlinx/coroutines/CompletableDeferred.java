package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.SubclassOptInRequired;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.Deferred;

@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/CompletableDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "complete", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SubclassOptInRequired(markerClass = {InternalForInheritanceCoroutinesApi.class})
/* loaded from: classes.dex */
public interface CompletableDeferred<T> extends Deferred<T> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <T, R> R m6924fold(CompletableDeferred<T> completableDeferred, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) Deferred.DefaultImpls.m6966fold(completableDeferred, r, function2);
        }

        /* renamed from: get */
        public static <T, E extends CoroutineContext.InterfaceC1197Element> E m6925get(CompletableDeferred<T> completableDeferred, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) Deferred.DefaultImpls.m6967get(completableDeferred, interfaceC1198Key);
        }

        public static <T> CoroutineContext minusKey(CompletableDeferred<T> completableDeferred, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return Deferred.DefaultImpls.minusKey(completableDeferred, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static <T> CoroutineContext m6926plus(CompletableDeferred<T> completableDeferred, CoroutineContext coroutineContext) {
            return Deferred.DefaultImpls.m6968plus(completableDeferred, coroutineContext);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @Deprecated
        /* renamed from: plus */
        public static <T> InterfaceC1342Job m6927plus(CompletableDeferred<T> completableDeferred, InterfaceC1342Job interfaceC1342Job) {
            return CompletableDeferred.super.mo7001plus(interfaceC1342Job);
        }
    }

    boolean complete(T value);

    boolean completeExceptionally(Throwable exception);
}
