package p131o;

import java.util.ListIterator;

/* renamed from: o.YE */
/* loaded from: classes.dex */
public abstract class AbstractC3217YE extends AbstractC3082WE implements ListIterator {
    public AbstractC3217YE(ListIterator listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f11446mjFkc).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f11446mjFkc).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return mo10681AZxh(((ListIterator) this.f11446mjFkc).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f11446mjFkc).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
