package p094kotlin.coroutines;

import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a[\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u0005\u001aH\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¨\u0006\u0012"}, m4988d2 = {"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/Deprecated;", "message", "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "2.4", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @ExperimentalStdlibApi
    @Deprecated(m4972message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final <E extends CoroutineContext.InterfaceC1197Element> E getPolymorphicElement(CoroutineContext.InterfaceC1197Element interfaceC1197Element, CoroutineContext.InterfaceC1198Key<E> key) {
        E e;
        Intrinsics.checkNotNullParameter(interfaceC1197Element, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            if (interfaceC1197Element.mo6099getKey() == key) {
                return interfaceC1197Element;
            }
            return null;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(interfaceC1197Element.mo6099getKey()) || (e = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(interfaceC1197Element)) == null) {
            return null;
        }
        return e;
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalStdlibApi
    @Deprecated(m4972message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.InterfaceC1197Element interfaceC1197Element, CoroutineContext.InterfaceC1198Key<?> key) {
        Intrinsics.checkNotNullParameter(interfaceC1197Element, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            return interfaceC1197Element.mo6099getKey() == key ? EmptyCoroutineContext.INSTANCE : interfaceC1197Element;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(interfaceC1197Element.mo6099getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(interfaceC1197Element) == null) ? interfaceC1197Element : EmptyCoroutineContext.INSTANCE;
    }
}
