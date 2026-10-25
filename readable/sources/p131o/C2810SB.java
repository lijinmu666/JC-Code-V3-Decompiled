package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.SB */
/* loaded from: classes.dex */
public final class C2810SB extends AbstractC4071lE {

    /* renamed from: AZxh */
    public final /* synthetic */ AbstractC4199nC f10520AZxh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2810SB(AbstractC4199nC abstractC4199nC, Map map) {
        super(map);
        this.f10520AZxh = abstractC4199nC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        AbstractC2746RD.m10059mjFkc(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.f14678mjFkc.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return this == obj || this.f14678mjFkc.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f14678mjFkc.keySet().hashCode();
    }

    @Override // p131o.AbstractC4071lE, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C2617PB(this, this.f14678mjFkc.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.f14678mjFkc.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        this.f10520AZxh.f15363ZfxDd -= size;
        return size > 0;
    }
}
