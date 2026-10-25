package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.lE */
/* loaded from: classes.dex */
public abstract class AbstractC4071lE extends AbstractC2813SE {

    /* renamed from: mjFkc */
    public final Map f14678mjFkc;

    public AbstractC4071lE(Map map) {
        map.getClass();
        this.f14678mjFkc = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f14678mjFkc.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f14678mjFkc.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract Iterator iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f14678mjFkc.size();
    }
}
