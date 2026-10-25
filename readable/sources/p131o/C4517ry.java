package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.ry */
/* loaded from: classes.dex */
public final class C4517ry implements Iterator {

    /* renamed from: mjFkc */
    public final Iterator f16398mjFkc;

    public C4517ry(Iterator it) {
        this.f16398mjFkc = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f16398mjFkc.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f16398mjFkc.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f16398mjFkc.remove();
    }
}
