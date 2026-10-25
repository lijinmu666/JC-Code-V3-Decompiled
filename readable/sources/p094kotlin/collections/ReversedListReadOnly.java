package p094kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0000\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\bF\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0096\u0082\u0004¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0082\u0004J\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096\u0080\u0004J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\f\u001a\u00020\bH\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m4988d2 = {"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/util/List;)V", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "iterator", BuildConfig.f24315FLAVOR, "listIterator", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
class ReversedListReadOnly<T> extends AbstractList<T> {
    private final List<T> delegate;

    @Metadata(m4987d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\n\u0010\u0005\u001a\u00020\u0006H\u0096\u0082\u0004J\n\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004J\u000f\u0010\b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u000f\u0010\f\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\tJ\n\u0010\r\u001a\u00020\u000bH\u0096\u0080\u0004R\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, m4988d2 = {"kotlin/collections/ReversedListReadOnly$listIterator$1", BuildConfig.f24315FLAVOR, "delegateIterator", "getDelegateIterator", "()Ljava/util/ListIterator;", "hasNext", BuildConfig.f24315FLAVOR, "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", BuildConfig.f24315FLAVOR, "previous", "previousIndex", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.collections.ReversedListReadOnly$listIterator$1 */
    public static final class C11571 implements ListIterator<T>, KMappedMarker {
        private final ListIterator<T> delegateIterator;

        /* renamed from: this$0 */
        final /* synthetic */ ReversedListReadOnly<T> f4962this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C11571(ReversedListReadOnly<? extends T> reversedListReadOnly, int i) {
            this.f4962this$0 = reversedListReadOnly;
            this.delegateIterator = ((ReversedListReadOnly) reversedListReadOnly).delegate.listIterator(CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(reversedListReadOnly, i));
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final ListIterator<T> getDelegateIterator() {
            return this.delegateIterator;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.delegateIterator.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.delegateIterator.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.delegateIterator.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.f4962this$0, this.delegateIterator.previousIndex());
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.delegateIterator.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.f4962this$0, this.delegateIterator.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReversedListReadOnly(List<? extends T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        return this.delegate.get(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index));
    }

    @Override // p094kotlin.collections.AbstractList, p094kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.delegate.size();
    }

    @Override // p094kotlin.collections.AbstractList, p094kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // p094kotlin.collections.AbstractList, java.util.List
    public ListIterator<T> listIterator(int index) {
        return new C11571(this, index);
    }
}
