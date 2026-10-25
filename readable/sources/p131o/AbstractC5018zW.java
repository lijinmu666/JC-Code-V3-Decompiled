package p131o;

import java.util.NoSuchElementException;

/* renamed from: o.zW */
/* loaded from: classes.dex */
public abstract class AbstractC5018zW extends AbstractC2491NC {

    /* renamed from: AZxh */
    public int f17686AZxh;

    /* renamed from: mjFkc */
    public final int f17687mjFkc;

    public AbstractC5018zW(int i, int i2) {
        AbstractC4284oV.m12958AZxh(i2, i, "index");
        this.f17687mjFkc = i;
        this.f17686AZxh = i2;
    }

    /* renamed from: AZxh */
    public abstract Object mo9178AZxh(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f17686AZxh < this.f17687mjFkc;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17686AZxh > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f17686AZxh;
        this.f17686AZxh = i + 1;
        return mo9178AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17686AZxh;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f17686AZxh - 1;
        this.f17686AZxh = i;
        return mo9178AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17686AZxh - 1;
    }
}
