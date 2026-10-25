package p131o;

import java.util.Iterator;

/* renamed from: o.WE */
/* loaded from: classes.dex */
public abstract class AbstractC3082WE implements Iterator {

    /* renamed from: mjFkc */
    public final Iterator f11446mjFkc;

    public AbstractC3082WE(Iterator it) {
        it.getClass();
        this.f11446mjFkc = it;
    }

    /* renamed from: AZxh */
    public abstract Object mo10681AZxh(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11446mjFkc.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return mo10681AZxh(this.f11446mjFkc.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f11446mjFkc.remove();
    }
}
