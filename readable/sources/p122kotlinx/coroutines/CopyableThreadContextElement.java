package p122kotlinx.coroutines;

import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.ThreadContextElement;

@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/CopyableThreadContextElement;", "S", "Lkotlinx/coroutines/ThreadContextElement;", "copyForChild", "mergeForChild", "Lkotlin/coroutines/CoroutineContext;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext$Element;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
/* loaded from: classes.dex */
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <S, R> R m6938fold(CopyableThreadContextElement<S> copyableThreadContextElement, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) ThreadContextElement.DefaultImpls.m7031fold(copyableThreadContextElement, r, function2);
        }

        /* renamed from: get */
        public static <S, E extends CoroutineContext.InterfaceC1197Element> E m6939get(CopyableThreadContextElement<S> copyableThreadContextElement, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) ThreadContextElement.DefaultImpls.m7032get(copyableThreadContextElement, interfaceC1198Key);
        }

        public static <S> CoroutineContext minusKey(CopyableThreadContextElement<S> copyableThreadContextElement, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return ThreadContextElement.DefaultImpls.minusKey(copyableThreadContextElement, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static <S> CoroutineContext m6940plus(CopyableThreadContextElement<S> copyableThreadContextElement, CoroutineContext coroutineContext) {
            return ThreadContextElement.DefaultImpls.m7033plus(copyableThreadContextElement, coroutineContext);
        }
    }

    CopyableThreadContextElement<S> copyForChild();

    CoroutineContext mergeForChild(CoroutineContext.InterfaceC1197Element overwritingElement);
}
