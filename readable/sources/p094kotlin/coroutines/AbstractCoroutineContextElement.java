package p094kotlin.coroutines;

import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0015\bF\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\b"}, m4988d2 = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractCoroutineContextElement implements CoroutineContext.InterfaceC1197Element {
    private final CoroutineContext.InterfaceC1198Key<?> key;

    public AbstractCoroutineContextElement(CoroutineContext.InterfaceC1198Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    /* renamed from: fold */
    public /* bridge */ <R> R mo6097fold(R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
        return (R) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6111fold(this, r, function2);
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    /* renamed from: get */
    public /* bridge */ <E extends CoroutineContext.InterfaceC1197Element> E mo6098get(CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
        return (E) CoroutineContext.InterfaceC1197Element.DefaultImpls.m6112get(this, interfaceC1198Key);
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element
    /* renamed from: getKey */
    public CoroutineContext.InterfaceC1198Key<?> mo6099getKey() {
        return this.key;
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    public /* bridge */ CoroutineContext minusKey(CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
        return CoroutineContext.InterfaceC1197Element.DefaultImpls.minusKey(this, interfaceC1198Key);
    }

    @Override // p094kotlin.coroutines.CoroutineContext
    /* renamed from: plus */
    public /* bridge */ CoroutineContext mo6100plus(CoroutineContext coroutineContext) {
        return CoroutineContext.InterfaceC1197Element.DefaultImpls.m6113plus(this, coroutineContext);
    }
}
