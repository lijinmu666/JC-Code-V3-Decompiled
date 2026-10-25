package p094kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.AbstractCollection;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.CollectionToArray;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\bD¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0082\u0004J\u0017\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\u0017\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0095\u0080\u0004¢\u0006\u0002\u0010\u0017J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001aR\u0013\u0010\u0005\u001a\u00020\u0006X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¨\u0006\u001b"}, m4988d2 = {"Lkotlin/collections/AbstractCollection;", "E", BuildConfig.f24315FLAVOR, "<init>", "()V", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "iterator", BuildConfig.f24315FLAVOR, "contains", BuildConfig.f24315FLAVOR, "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "toString", BuildConfig.f24315FLAVOR, "toArray", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAbstractCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractCollection.kt\nkotlin/collections/AbstractCollection\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n1960#2,3:51\n1939#2,3:54\n*S KotlinDebug\n*F\n+ 1 AbstractCollection.kt\nkotlin/collections/AbstractCollection\n*L\n19#1:51,3\n22#1:54,3\n*E\n"})
/* loaded from: classes.dex */
public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(AbstractCollection abstractCollection, Object obj) {
        return obj == abstractCollection ? "(this Collection)" : String.valueOf(obj);
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), element)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: getSize */
    public abstract int get_size();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return get_size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.m6305toArray(this);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this, ", ", "[", "]", 0, null, new Function1() { // from class: o.KLFTb
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return AbstractCollection.toString$lambda$0(this.f9149mjFkc, obj);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.m6306toArray(this, array);
    }
}
