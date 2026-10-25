package p122kotlinx.coroutines;

import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "<init>", "()V", "key", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class UndispatchedMarker implements CoroutineContext.InterfaceC1197Element, CoroutineContext.InterfaceC1198Key<UndispatchedMarker> {
    public static final UndispatchedMarker INSTANCE = new UndispatchedMarker();

    private UndispatchedMarker() {
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
        return this;
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
