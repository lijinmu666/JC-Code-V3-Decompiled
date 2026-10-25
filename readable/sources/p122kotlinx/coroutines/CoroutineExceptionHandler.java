package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", BuildConfig.f24315FLAVOR, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", BuildConfig.f24315FLAVOR, "Key", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.InterfaceC1197Element {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <R> R m6946fold(CoroutineExceptionHandler coroutineExceptionHandler, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6111fold(coroutineExceptionHandler, r, function2);
        }

        /* renamed from: get */
        public static <E extends CoroutineContext.InterfaceC1197Element> E m6947get(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6112get(coroutineExceptionHandler, interfaceC1198Key);
        }

        public static CoroutineContext minusKey(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return CoroutineContext.InterfaceC1197Element.DefaultImpls.minusKey(coroutineExceptionHandler, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static CoroutineContext m6948plus(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC1197Element.DefaultImpls.m6113plus(coroutineExceptionHandler, coroutineContext);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m4988d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$Key, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.InterfaceC1198Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    void handleException(CoroutineContext context, Throwable exception);
}
