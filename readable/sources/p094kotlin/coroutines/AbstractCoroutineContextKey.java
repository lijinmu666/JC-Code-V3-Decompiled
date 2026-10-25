package p094kotlin.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B<\bF\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u0002H\u0080\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0080\u0080\u0004¢\u0006\u0002\b\u0016R,\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001aÊ\u0001\u0002\b\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001eÊ\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¨\u0006\u0017"}, m4988d2 = {"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "getTopmostKey$annotations", "()V", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "isSubKey", BuildConfig.f24315FLAVOR, "key", "isSubKey$kotlin_stdlib", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/Deprecated;", "message", "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "2.4"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@ExperimentalStdlibApi
@Deprecated(m4972message = "Polymorphic coroutine context keys are error-prone, difficult to implement correctly, and can encourage depending on implementation details. Prefer retrieving the element by its base key and casting it explicitly when needed or introducing a dedicated extension property.")
@DeprecatedSinceKotlin(warningSince = "2.4")
/* loaded from: classes.dex */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.InterfaceC1197Element, E extends B> implements CoroutineContext.InterfaceC1198Key<E> {
    private final Function1<CoroutineContext.InterfaceC1197Element, E> safeCast;
    private final CoroutineContext.InterfaceC1198Key<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(CoroutineContext.InterfaceC1198Key<B> baseKey, Function1<? super CoroutineContext.InterfaceC1197Element, ? extends E> safeCast) {
        Intrinsics.checkNotNullParameter(baseKey, "baseKey");
        Intrinsics.checkNotNullParameter(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof AbstractCoroutineContextKey ? (CoroutineContext.InterfaceC1198Key<B>) ((AbstractCoroutineContextKey) baseKey).topmostKey : baseKey;
    }

    private static /* synthetic */ void getTopmostKey$annotations() {
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.InterfaceC1198Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.InterfaceC1197Element tryCast$kotlin_stdlib(CoroutineContext.InterfaceC1197Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return (CoroutineContext.InterfaceC1197Element) this.safeCast.mo2237invoke(element);
    }
}
