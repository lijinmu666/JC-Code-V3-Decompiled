package p094kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.TuplesKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u00004\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0088\u0004b\u0002\b\u0006ø\u0001\u0000\u001a%\u0010\u0007\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0081\u0080\u0004b\u0002\b\n¢\u0006\u0002\u0010\t\u001a&\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\bH\u0081\u0080\u0004b\u0002\b\n\u001a&\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001H\u0086\u0080\u0004\u001aD\u0010\u000f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u000e0\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00110\u00100\u0001H\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m4988d2 = {"Iterable", BuildConfig.f24315FLAVOR, "T", "iterator", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "collectionSizeOrNull", BuildConfig.f24315FLAVOR, "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "Lkotlin/PublishedApi;", "collectionSizeOrDefault", "default", "flatten", BuildConfig.f24315FLAVOR, "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0082\u0004¨\u0006\u0004"}, m4988d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", BuildConfig.f24315FLAVOR, "iterator", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
    /* renamed from: kotlin.collections.CollectionsKt__IterablesKt$Iterable$1 */
    public static final class C11481<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Function0<Iterator<T>> $iterator;

        /* JADX WARN: Multi-variable type inference failed */
        public C11481(Function0<? extends Iterator<? extends T>> function0) {
            this.$iterator = function0;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.$iterator.mo4323invoke();
        }
    }

    @InlineOnly
    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return new C11481(iterator);
    }

    @PublishedApi
    public static <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    @PublishedApi
    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    /* renamed from: flatten */
    public static final <T> List<T> m5809flatten(Iterable<? extends Iterable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.m5818addAll(arrayList, it.next());
        }
        return arrayList;
    }

    /* renamed from: unzip */
    public static final <T, R> C1122Pair<List<T>, List<R>> m5810unzip(Iterable<? extends C1122Pair<? extends T, ? extends R>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(iterable, 10);
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        ArrayList arrayList2 = new ArrayList(iCollectionSizeOrDefault);
        for (C1122Pair<? extends T, ? extends R> c1122Pair : iterable) {
            arrayList.add(c1122Pair.getFirst());
            arrayList2.add(c1122Pair.getSecond());
        }
        return TuplesKt.m5076to(arrayList, arrayList2);
    }
}
