package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/ThreadContextElement;", "S", "Lkotlin/coroutines/CoroutineContext$Element;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "restoreThreadContext", BuildConfig.f24315FLAVOR, "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface ThreadContextElement<S> extends CoroutineContext.InterfaceC1197Element {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <S, R> R m7031fold(ThreadContextElement<S> threadContextElement, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6111fold(threadContextElement, r, function2);
        }

        /* renamed from: get */
        public static <S, E extends CoroutineContext.InterfaceC1197Element> E m7032get(ThreadContextElement<S> threadContextElement, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6112get(threadContextElement, interfaceC1198Key);
        }

        public static <S> CoroutineContext minusKey(ThreadContextElement<S> threadContextElement, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return CoroutineContext.InterfaceC1197Element.DefaultImpls.minusKey(threadContextElement, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static <S> CoroutineContext m7033plus(ThreadContextElement<S> threadContextElement, CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC1197Element.DefaultImpls.m6113plus(threadContextElement, coroutineContext);
        }
    }

    void restoreThreadContext(CoroutineContext context, S oldState);

    S updateThreadContext(CoroutineContext context);
}
