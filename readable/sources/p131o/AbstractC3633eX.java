package p131o;

import java.util.NoSuchElementException;

/* renamed from: o.eX */
/* loaded from: classes.dex */
public abstract class AbstractC3633eX extends AbstractC3484cF {

    /* renamed from: AZxh */
    public int f13474AZxh;

    /* renamed from: mjFkc */
    public final int f13475mjFkc;

    public AbstractC3633eX(int i, int i2) {
        AbstractC3168XW.m10941AZxh(i2, i, "index");
        this.f13475mjFkc = i;
        this.f13474AZxh = i2;
    }

    /* renamed from: AZxh */
    public abstract Object mo8273AZxh(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f13474AZxh < this.f13475mjFkc;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13474AZxh > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f13474AZxh;
        this.f13474AZxh = i + 1;
        return mo8273AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13474AZxh;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f13474AZxh - 1;
        this.f13474AZxh = i;
        return mo8273AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13474AZxh - 1;
    }
}
