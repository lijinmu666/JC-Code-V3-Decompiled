package p131o;

import java.util.NoSuchElementException;

/* renamed from: o.gK */
/* loaded from: classes.dex */
public abstract class AbstractC3749gK extends AbstractC2078HB {

    /* renamed from: AZxh */
    public int f13712AZxh;

    /* renamed from: mjFkc */
    public final int f13713mjFkc;

    public AbstractC3749gK(int i, int i2) {
        AbstractC2623PH.m9954AZxh(i2, i, "index");
        this.f13713mjFkc = i;
        this.f13712AZxh = i2;
    }

    /* renamed from: AZxh */
    public abstract Object mo11994AZxh(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f13712AZxh < this.f13713mjFkc;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13712AZxh > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f13712AZxh;
        this.f13712AZxh = i + 1;
        return mo11994AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13712AZxh;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f13712AZxh - 1;
        this.f13712AZxh = i;
        return mo11994AZxh(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13712AZxh - 1;
    }
}
