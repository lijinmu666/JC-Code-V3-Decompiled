package p131o;

import java.util.NoSuchElementException;

/* renamed from: o.Ls */
/* loaded from: classes.dex */
public abstract class AbstractC2397Ls extends AbstractC3786gt {

    /* renamed from: AZxh */
    public int f9487AZxh;

    /* renamed from: mjFkc */
    public final int f9488mjFkc;

    public AbstractC2397Ls(int i, int i2) {
        AbstractC1851Ds.m8059AZxh(i2, i, "index");
        this.f9488mjFkc = i;
        this.f9487AZxh = i2;
    }

    /* renamed from: AZxh */
    public abstract Object mo9394AZxh(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f9487AZxh < this.f9488mjFkc;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9487AZxh > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f9487AZxh;
        this.f9487AZxh = i + 1;
        return mo9394AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9487AZxh;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f9487AZxh - 1;
        this.f9487AZxh = i;
        return mo9394AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9487AZxh - 1;
    }
}
