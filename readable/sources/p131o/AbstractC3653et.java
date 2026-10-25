package p131o;

import java.util.ListIterator;

/* renamed from: o.et */
/* loaded from: classes.dex */
public abstract class AbstractC3653et extends AbstractC3590dt implements ListIterator {
    public AbstractC3653et(ListIterator listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f13405mjFkc).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f13405mjFkc).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return mo10651AZxh(((ListIterator) this.f13405mjFkc).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f13405mjFkc).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
