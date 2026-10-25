package p131o;

import java.util.Iterator;

/* renamed from: o.dt */
/* loaded from: classes.dex */
public abstract class AbstractC3590dt implements Iterator {

    /* renamed from: mjFkc */
    public final Iterator f13405mjFkc;

    public AbstractC3590dt(Iterator it) {
        it.getClass();
        this.f13405mjFkc = it;
    }

    /* renamed from: AZxh */
    public abstract Object mo10651AZxh(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13405mjFkc.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return mo10651AZxh(this.f13405mjFkc.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f13405mjFkc.remove();
    }
}
