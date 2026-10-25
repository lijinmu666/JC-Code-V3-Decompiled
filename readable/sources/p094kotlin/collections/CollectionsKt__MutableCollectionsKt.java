package p094kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.TypeIntrinsics;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000z\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\u0000\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\u0088\bb\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0006\u001a7\u0010\t\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0087\u0088\bb\u0002\b\u0007b\u0002\b\b\u001a7\u0010\f\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0087\u0088\bb\u0002\b\u0007b\u0002\b\b\u001a-\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u000f\u001a.\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u0007\u001a3\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001a.\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0007\u001a-\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u000f\u001a.\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u0007\u001a3\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001a.\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0007\u001a.\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u0080\bb\u0002\b\b\u001a.\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u0080\bb\u0002\b\b\u001a5\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0011H\u0087\u0080\bb\u0002\b\b¢\u0006\u0002\u0010\u0016\u001a \u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0080\u0080\u0004\u001a.\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u0080\bb\u0002\b\b\u001a.\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u0080\bb\u0002\b\b\u001a5\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0011H\u0087\u0080\bb\u0002\b\b¢\u0006\u0002\u0010\u0016\u001a.\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u0080\bb\u0002\b\b\u001a5\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0011H\u0087\u0080\bb\u0002\b\b¢\u0006\u0002\u0010\u0016\u001a.\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u0080\bb\u0002\b\b\u001a\u001b\u0010\u0018\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0004H\u0083\u0080\bb\u0002\b\b¢\u0006\u0002\b\u0019\u001a2\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a2\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a;\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001f\u001ac\u0010\u0000\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0006\u0010!\u001a\u00020\"H\u0087\u0088\u0004b6\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u001c\b'\u0012\u0018\b\u000bB\u0014\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0006\b+\u0012\u0002\b\f\u0012\n\b,\u0012\u0006\b\n0-8.b\u0002\b\u0007¢\u0006\u0002\u0010#\u001a1\u0010/\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a3\u00104\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a1\u00105\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a3\u00106\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a2\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a2\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a;\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001f¨\u00067"}, m4988d2 = {"remove", BuildConfig.f24315FLAVOR, "T", "Lkotlin/internal/OnlyInputTypes;", BuildConfig.f24315FLAVOR, "element", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "Lkotlin/internal/InlineOnly;", "Lkotlin/IgnorableReturnValue;", "removeAll", "elements", BuildConfig.f24315FLAVOR, "retainAll", "plusAssign", BuildConfig.f24315FLAVOR, "(Ljava/util/Collection;Ljava/lang/Object;)V", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/Sequence;", "minusAssign", "addAll", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "convertToListIfNotCollection", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", BuildConfig.f24315FLAVOR, "predicate", "Lkotlin/Function1;", "filterInPlace", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", BuildConfig.f24315FLAVOR, "index", BuildConfig.f24315FLAVOR, "(Ljava/util/List;I)Ljava/lang/Object;", "Lkotlin/Deprecated;", "message", "Use removeAt(index) instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "removeAt(index)", "imports", "level", "Lkotlin/DeprecationLevel;", "ERROR", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", "version", "1.4", "removeFirstOrNull", "removeLast", "removeLastOrNull", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    @IgnorableReturnValue
    /* renamed from: addAll */
    public static <T> boolean m5818addAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : CollectionsKt.m5899toList(iterable);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.mo2237invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        collection.remove(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        collection.add(t);
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: remove */
    private static final <T> boolean m5822remove(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return TypeIntrinsics.asMutableCollection(collection).remove(t);
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection(collection).removeAll(elements);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    public static final <T> T removeFirst(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    public static final <T> T removeFirstOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    public static <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    @SinceKotlin(m5061version = "1.4")
    @IgnorableReturnValue
    public static <T> T removeLastOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection(collection).retainAll(elements);
    }

    @IgnorableReturnValue
    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        removeAll(collection, elements);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.m5818addAll(collection, elements);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", m5048imports = {}))
    @InlineOnly
    /* renamed from: remove */
    private static final <T> T m5821remove(List<T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.remove(i);
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.removeAll(CollectionsKt.convertToListIfNotCollection(elements));
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.retainAll(CollectionsKt.convertToListIfNotCollection(elements));
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        removeAll(collection, elements);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        m5820addAll(collection, elements);
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Collection<? super T> collection, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        List list = SequencesKt.m6639toList(elements);
        return !list.isEmpty() && collection.removeAll(list);
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Collection<? super T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (!(elements.length == 0)) {
            return collection.retainAll(ArraysKt.m5136asList(elements));
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    @IgnorableReturnValue
    /* renamed from: addAll */
    public static <T> boolean m5819addAll(Collection<? super T> collection, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @InlineOnly
    private static final <T> void minusAssign(Collection<? super T> collection, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        removeAll(collection, elements);
    }

    @InlineOnly
    private static final <T> void plusAssign(Collection<? super T> collection, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.m5819addAll(collection, elements);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, z);
        }
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                T t = list.get(i2);
                if (function1.mo2237invoke(t).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, t);
                    }
                    i++;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex2 = CollectionsKt.getLastIndex(list);
        if (i > lastIndex2) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i) {
                return true;
            }
            lastIndex2--;
        }
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Collection<? super T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return !(elements.length == 0) && collection.removeAll(ArraysKt.m5136asList(elements));
    }

    @IgnorableReturnValue
    /* renamed from: addAll */
    public static final <T> boolean m5820addAll(Collection<? super T> collection, T[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.addAll(ArraysKt.m5136asList(elements));
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) predicate, true);
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Collection<? super T> collection, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        List list = SequencesKt.m6639toList(elements);
        if (!list.isEmpty()) {
            return collection.retainAll(list);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) predicate, true);
    }

    @IgnorableReturnValue
    public static <T> boolean retainAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) predicate, false);
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) predicate, false);
    }
}
