package p094kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0082\u0004¨\u0006\u0004"}, m4988d2 = {"iterator", BuildConfig.f24315FLAVOR, "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__IteratorsJVMKt extends CollectionsKt__IterablesKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\n\u0010\u0002\u001a\u00020\u0003H\u0096\u0082\u0004J\u000f\u0010\u0004\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", BuildConfig.f24315FLAVOR, "hasNext", BuildConfig.f24315FLAVOR, "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.collections.CollectionsKt__IteratorsJVMKt$iterator$1 */
    public static final class C11491<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ Enumeration<T> $this_iterator;

        public C11491(Enumeration<T> enumeration) {
            this.$this_iterator = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.$this_iterator.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.$this_iterator.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static <T> Iterator<T> iterator(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new C11491(enumeration);
    }
}
