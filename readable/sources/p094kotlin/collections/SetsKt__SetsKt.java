package p094kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.BuilderInference;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000^\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001a/\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0006\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0007\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0006\u001a7\u0010\r\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u000ej\b\u0012\u0004\u0012\u0002H\u0002`\u000f\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0007¢\u0006\u0002\u0010\u0010\u001a9\u0010\r\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u000ej\b\u0012\u0004\u0012\u0002H\u0002`\u000f\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0011\u001a7\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0013j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0007¢\u0006\u0002\u0010\u0015\u001a9\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0013j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0016\u001a7\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u0001H\u0002H\u0087\u0080\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u001a\u001aE\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00182\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0005\"\u0004\u0018\u0001H\u0002H\u0087\u0080\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u0006\u001a]\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\"\u0004\b\u0000\u0010\u001d2#\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001d0\t\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!:\u0002\b\"H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#b\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001ae\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\"\u0004\b\u0000\u0010\u001d2\u0006\u0010$\u001a\u00020%2#\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001d0\t\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!:\u0002\b\"H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#b\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a&\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004b\u0002\b\u0007\u001a \u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, m4988d2 = {"emptySet", BuildConfig.f24315FLAVOR, "T", "setOf", "elements", BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;)Ljava/util/Set;", "Lkotlin/internal/InlineOnly;", "mutableSetOf", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.1", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "()Ljava/util/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "()Ljava/util/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "setOfNotNull", BuildConfig.f24315FLAVOR, "element", "(Ljava/lang/Object;)Ljava/util/Set;", "1.4", "buildSet", "E", "builderAction", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "Lkotlin/BuilderInference;", "1.6", "capacity", BuildConfig.f24315FLAVOR, "orEmpty", "optimizeReadOnlySet", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/SetsKt")
/* loaded from: classes.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    private static final <E> Set<E> buildSet(@BuilderInference Function1<? super Set<E>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Set setCreateSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
        builderAction.mo2237invoke(setCreateSetBuilder);
        return C1159SetsKt.m5991build(setCreateSetBuilder);
    }

    public static <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : C1159SetsKt.m5992setOf(set.iterator().next()) : C1159SetsKt.emptySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: orEmpty */
    private static final <T> Set<T> m5993orEmpty(Set<? extends T> set) {
        return set == 0 ? C1159SetsKt.emptySet() : set;
    }

    /* renamed from: setOf */
    public static <T> Set<T> m5995setOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.m5732toSet(elements);
    }

    @SinceKotlin(m5061version = "1.4")
    public static final <T> Set<T> setOfNotNull(T t) {
        return t != null ? C1159SetsKt.m5992setOf(t) : C1159SetsKt.emptySet();
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    private static final <E> Set<E> buildSet(int i, @BuilderInference Function1<? super Set<E>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Set setCreateSetBuilder = C1159SetsKt.createSetBuilder(i);
        builderAction.mo2237invoke(setCreateSetBuilder);
        return C1159SetsKt.m5991build(setCreateSetBuilder);
    }

    public static final <T> HashSet<T> hashSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (HashSet) ArraysKt___ArraysKt.toCollection(elements, new HashSet(C1155MapsKt.mapCapacity(elements.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(C1155MapsKt.mapCapacity(elements.length)));
    }

    public static <T> Set<T> mutableSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.toCollection(elements, new LinkedHashSet(C1155MapsKt.mapCapacity(elements.length)));
    }

    @InlineOnly
    /* renamed from: setOf */
    private static final <T> Set<T> m5994setOf() {
        return C1159SetsKt.emptySet();
    }

    @SinceKotlin(m5061version = "1.4")
    public static final <T> Set<T> setOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(elements, new LinkedHashSet());
    }
}
