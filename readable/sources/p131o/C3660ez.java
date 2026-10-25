package p131o;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.ez */
/* loaded from: classes.dex */
public final class C3660ez extends AbstractSet {

    /* renamed from: mjFkc */
    public final /* synthetic */ AbstractC3794gz f13512mjFkc;

    public /* synthetic */ C3660ez(AbstractC3794gz abstractC3794gz, AbstractC3596dz abstractC3596dz) {
        this.f13512mjFkc = abstractC3794gz;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f13512mjFkc.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f13512mjFkc.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f13512mjFkc.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C3532cz(this.f13512mjFkc, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f13512mjFkc.remove(entry.getKey());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f13512mjFkc.size();
    }
}
