package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p113reflect.KProperty;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a9\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\u008a\u0004b\u0002\b\u000b¢\u0006\u0002\u0010\n¨\u0006\f"}, m4988d2 = {"lazyOf", "Lkotlin/Lazy;", "T", "value", "(Ljava/lang/Object;)Lkotlin/Lazy;", "getValue", "thisRef", BuildConfig.f24315FLAVOR, "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/LazyKt")
/* loaded from: classes.dex */
class LazyKt__LazyKt extends LazyKt__LazyJVMKt {
    @InlineOnly
    private static final <T> T getValue(InterfaceC1119Lazy<? extends T> interfaceC1119Lazy, Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(interfaceC1119Lazy, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return interfaceC1119Lazy.getValue();
    }

    /* renamed from: lazyOf */
    public static final <T> InterfaceC1119Lazy<T> m4982lazyOf(T t) {
        return new InitializedLazyImpl(t);
    }
}
