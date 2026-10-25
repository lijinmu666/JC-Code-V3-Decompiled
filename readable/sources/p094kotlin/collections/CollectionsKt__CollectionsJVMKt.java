package p094kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.builders.ListBuilder;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.CollectionToArray;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000v\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\u0007\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\bH\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010\t\u001aN\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0081\u0088\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nø\u0001\u0000\u001aV\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0016\u001a\u00020\u00172\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0081\u0088\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nø\u0001\u0000\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f\"\u0004\b\u0000\u0010\fH\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a0\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a6\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a$\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001cH\u0087\u0088\u0004b\u0002\b\n\u001a.\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0087\u0080\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u001a6\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0087\u0080\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u001a'\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010&\u001a9\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010(\u001a1\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010*\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0080\u0080\u0004¢\u0006\u0002\u0010+\u001a3\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010#0\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b2\u0006\u0010-\u001a\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010/\u001a,\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0017H\u0081\u0088\bb\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nb\u0002\b2\u001a,\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0017H\u0081\u0088\bb\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nb\u0002\b2\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, m4988d2 = {"listOf", BuildConfig.f24315FLAVOR, "T", "element", "(Ljava/lang/Object;)Ljava/util/List;", "asArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;)Ljava/util/ArrayList;", "Lkotlin/internal/InlineOnly;", "buildListInternal", "E", "builderAction", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", "version", "1.3", "capacity", BuildConfig.f24315FLAVOR, "createListBuilder", "build", "builder", "toList", "Ljava/util/Enumeration;", "shuffled", BuildConfig.f24315FLAVOR, "1.2", "random", "Ljava/util/Random;", "collectionToArray", BuildConfig.f24315FLAVOR, "collection", BuildConfig.f24315FLAVOR, "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "checkIndexOverflow", "index", "Lkotlin/IgnorableReturnValue;", "checkCountOverflow", "count", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension(m6344value = {"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsJVMKt {
    @InlineOnly
    private static final <T> ArrayList<T> asArrayList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList<>(CollectionsKt__CollectionsKt.asCollection(tArr, true));
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: build */
    public static <E> List<E> m5800build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder) builder).m6006build();
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> buildListInternal(Function1<? super List<E>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        builderAction.mo2237invoke(listCreateListBuilder);
        return CollectionsKt.m5800build(listCreateListBuilder);
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    @PublishedApi
    @IgnorableReturnValue
    private static final int checkCountOverflow(int i) {
        if (i < 0) {
            CollectionsKt.throwCountOverflow();
        }
        return i;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    @PublishedApi
    @IgnorableReturnValue
    private static final int checkIndexOverflow(int i) {
        if (i < 0) {
            CollectionsKt.throwIndexOverflow();
        }
        return i;
    }

    @InlineOnly
    private static final Object[] collectionToArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        return CollectionToArray.m6305toArray(collection);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (z && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static <E> List<E> createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    /* renamed from: listOf */
    public static <T> List<T> m5801listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    @SinceKotlin(m5061version = "1.2")
    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static <T> T[] terminateCollectionToArray(int i, T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i < array.length) {
            array[i] = null;
        }
        return array;
    }

    @InlineOnly
    /* renamed from: toList */
    private static final <T> List<T> m5802toList(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        return list;
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> buildListInternal(int i, Function1<? super List<E>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listCreateListBuilder = CollectionsKt.createListBuilder(i);
        builderAction.mo2237invoke(listCreateListBuilder);
        return CollectionsKt.m5800build(listCreateListBuilder);
    }

    @InlineOnly
    private static final <T> T[] collectionToArray(Collection<?> collection, T[] array) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.m6306toArray(collection, array);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static <E> List<E> createListBuilder(int i) {
        return new ListBuilder(i);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }
}
