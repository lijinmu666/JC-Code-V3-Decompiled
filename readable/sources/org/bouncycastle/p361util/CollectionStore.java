package org.bouncycastle.p361util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class CollectionStore<T> implements InterfaceC6249Store<T>, Iterable<T> {

    /* renamed from: _local */
    private Collection<T> f24196_local;

    public CollectionStore(Collection<T> collection) {
        this.f24196_local = new ArrayList(collection);
    }

    @Override // org.bouncycastle.p361util.InterfaceC6249Store
    public Collection<T> getMatches(Selector<T> selector) {
        if (selector == null) {
            return new ArrayList(this.f24196_local);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : this.f24196_local) {
            if (selector.mo14742match(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<T> iterator() {
        return getMatches(null).iterator();
    }
}
