package p094kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.builders.SetBuilder;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000N\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001aN\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001aV\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u0006H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a0\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a6\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a/\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0019\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001a\u001aK\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017\"\u0004\b\u0000\u0010\u00022\u001a\u0010\u001b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u001cj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u001d2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0019\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m4988d2 = {"setOf", BuildConfig.f24315FLAVOR, "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "buildSetInternal", "E", "builderAction", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/internal/InlineOnly;", "capacity", BuildConfig.f24315FLAVOR, "createSetBuilder", "build", "builder", "sortedSetOf", "Ljava/util/TreeSet;", "elements", BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/SetsKt")
/* loaded from: classes.dex */
public class SetsKt__SetsJVMKt {
    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: build */
    public static <E> Set<E> m5991build(Set<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((SetBuilder) builder).m6018build();
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> buildSetInternal(Function1<? super Set<E>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Set setCreateSetBuilder = createSetBuilder();
        builderAction.mo2237invoke(setCreateSetBuilder);
        return C1159SetsKt.m5991build(setCreateSetBuilder);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    /* renamed from: setOf */
    public static <T> Set<T> m5992setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.toCollection(elements, new TreeSet());
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> buildSetInternal(int i, Function1<? super Set<E>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Set setCreateSetBuilder = C1159SetsKt.createSetBuilder(i);
        builderAction.mo2237invoke(setCreateSetBuilder);
        return C1159SetsKt.m5991build(setCreateSetBuilder);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static <E> Set<E> createSetBuilder(int i) {
        return new SetBuilder(i);
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... elements) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.toCollection(elements, new TreeSet(comparator));
    }
}
