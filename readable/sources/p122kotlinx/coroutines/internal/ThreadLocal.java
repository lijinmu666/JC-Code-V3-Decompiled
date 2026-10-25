package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.ThreadContextElement;

@Metadata(m4987d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u000f2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J(\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0001\u0010\u0017*\u00020\u00182\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00170\nH\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, m4988d2 = {"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "value", "threadLocal", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "Ljava/lang/Object;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "restoreThreadContext", BuildConfig.f24315FLAVOR, "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "minusKey", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "toString", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@PublishedApi
/* renamed from: kotlinx.coroutines.internal.ThreadLocalElement, reason: from toString */
/* loaded from: classes.dex */
public final class ThreadLocal<T> implements ThreadContextElement<T> {
    private final CoroutineContext.InterfaceC1198Key<?> key;
    private final java.lang.ThreadLocal<T> threadLocal;
    private final T value;

    public ThreadLocal(T t, java.lang.ThreadLocal<T> threadLocal) {
        this.value = t;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(threadLocal);
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    /* renamed from: fold */
    public /* bridge */ <R> R mo6097fold(R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
        return (R) ThreadContextElement.DefaultImpls.m7031fold(this, r, function2);
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    /* renamed from: get */
    public <E extends CoroutineContext.InterfaceC1197Element> E mo6098get(CoroutineContext.InterfaceC1198Key<E> key) {
        if (!Intrinsics.areEqual(mo6099getKey(), key)) {
            return null;
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element
    /* renamed from: getKey */
    public CoroutineContext.InterfaceC1198Key<?> mo6099getKey() {
        return this.key;
    }

    @Override // p094kotlin.coroutines.CoroutineContext.InterfaceC1197Element, p094kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC1198Key<?> key) {
        return Intrinsics.areEqual(mo6099getKey(), key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // p094kotlin.coroutines.CoroutineContext
    /* renamed from: plus */
    public /* bridge */ CoroutineContext mo6100plus(CoroutineContext coroutineContext) {
        return ThreadContextElement.DefaultImpls.m7033plus(this, coroutineContext);
    }

    @Override // p122kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(CoroutineContext context, T oldState) {
        this.threadLocal.set(oldState);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    @Override // p122kotlinx.coroutines.ThreadContextElement
    public T updateThreadContext(CoroutineContext context) {
        T t = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return t;
    }
}
