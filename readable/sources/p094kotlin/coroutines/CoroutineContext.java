package p094kotlin.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.ContinuationInterceptor;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J)\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H¦\u0082\u0004¢\u0006\u0002\u0010\u0007J7\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\t0\fH¦\u0080\u0004¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0082\u0004J\u0016\u0010\u0010\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H¦\u0080\u0004Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¨\u0006\u0013"}, m4988d2 = {"Lkotlin/coroutines/CoroutineContext;", BuildConfig.f24315FLAVOR, "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "Key", "Element", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface CoroutineContext {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: plus */
        public static CoroutineContext m6110plus(CoroutineContext coroutineContext, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.mo6097fold(coroutineContext, new Function2() { // from class: o.Fncs
                @Override // p094kotlin.p105jvm.functions.Function2
                /* renamed from: invoke */
                public final Object mo2167invoke(Object obj, Object obj2) {
                    return CoroutineContext.DefaultImpls.plus$lambda$0((CoroutineContext) obj, (CoroutineContext.InterfaceC1197Element) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineContext plus$lambda$0(CoroutineContext acc, InterfaceC1197Element element) {
            CombinedContext combinedContext;
            Intrinsics.checkNotNullParameter(acc, "acc");
            Intrinsics.checkNotNullParameter(element, "element");
            CoroutineContext coroutineContextMinusKey = acc.minusKey(element.mo6099getKey());
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            if (coroutineContextMinusKey == emptyCoroutineContext) {
                return element;
            }
            ContinuationInterceptor.Companion c1195Key = ContinuationInterceptor.INSTANCE;
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.mo6098get(c1195Key);
            if (continuationInterceptor == null) {
                combinedContext = new CombinedContext(coroutineContextMinusKey, element);
            } else {
                CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(c1195Key);
                if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                    return new CombinedContext(element, continuationInterceptor);
                }
                combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, element), continuationInterceptor);
            }
            return combinedContext;
        }
    }

    @Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0003H\u0096\u0082\u0004¢\u0006\u0002\u0010\bJ7\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0096\u0080\u0004R\u0017\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, m4988d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.coroutines.CoroutineContext$Element */
    public interface InterfaceC1197Element extends CoroutineContext {

        @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
        /* renamed from: kotlin.coroutines.CoroutineContext$Element$DefaultImpls */
        public static final class DefaultImpls {
            /* renamed from: fold */
            public static <R> R m6111fold(InterfaceC1197Element interfaceC1197Element, R r, Function2<? super R, ? super InterfaceC1197Element, ? extends R> operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                return operation.mo2167invoke(r, interfaceC1197Element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: get */
            public static <E extends InterfaceC1197Element> E m6112get(InterfaceC1197Element interfaceC1197Element, InterfaceC1198Key<E> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!Intrinsics.areEqual(interfaceC1197Element.mo6099getKey(), key)) {
                    return null;
                }
                Intrinsics.checkNotNull(interfaceC1197Element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return interfaceC1197Element;
            }

            public static CoroutineContext minusKey(InterfaceC1197Element interfaceC1197Element, InterfaceC1198Key<?> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Intrinsics.areEqual(interfaceC1197Element.mo6099getKey(), key) ? EmptyCoroutineContext.INSTANCE : interfaceC1197Element;
            }

            /* renamed from: plus */
            public static CoroutineContext m6113plus(InterfaceC1197Element interfaceC1197Element, CoroutineContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return DefaultImpls.m6110plus(interfaceC1197Element, context);
            }
        }

        @Override // p094kotlin.coroutines.CoroutineContext
        /* renamed from: fold */
        <R> R mo6097fold(R initial, Function2<? super R, ? super InterfaceC1197Element, ? extends R> operation);

        @Override // p094kotlin.coroutines.CoroutineContext
        /* renamed from: get */
        <E extends InterfaceC1197Element> E mo6098get(InterfaceC1198Key<E> key);

        /* renamed from: getKey */
        InterfaceC1198Key<?> mo6099getKey();

        @Override // p094kotlin.coroutines.CoroutineContext
        CoroutineContext minusKey(InterfaceC1198Key<?> key);
    }

    @Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, m4988d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.coroutines.CoroutineContext$Key */
    public interface InterfaceC1198Key<E extends InterfaceC1197Element> {
    }

    /* renamed from: fold */
    <R> R mo6097fold(R initial, Function2<? super R, ? super InterfaceC1197Element, ? extends R> operation);

    /* renamed from: get */
    <E extends InterfaceC1197Element> E mo6098get(InterfaceC1198Key<E> key);

    CoroutineContext minusKey(InterfaceC1198Key<?> key);

    /* renamed from: plus */
    CoroutineContext mo6100plus(CoroutineContext context);
}
