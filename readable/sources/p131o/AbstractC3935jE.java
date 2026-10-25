package p131o;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* renamed from: o.jE */
/* loaded from: classes.dex */
public abstract class AbstractC3935jE extends AbstractC2813SE {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        mo8268mjFkc().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return mo8268mjFkc().isEmpty();
    }

    /* renamed from: mjFkc */
    public abstract Map mo8268mjFkc();

    @Override // p131o.AbstractC2813SE, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        try {
            if (collection != null) {
                return AbstractC2944UE.m10479AZxh(this, collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            return AbstractC2944UE.m10481wA(this, collection.iterator());
        }
    }

    @Override // p131o.AbstractC2813SE, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int iCeil;
        try {
            if (collection != null) {
                return super.retainAll(collection);
            }
            throw null;
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                AbstractC1744CC.m7824mjFkc(size, "expectedSize");
                iCeil = size + 1;
            } else {
                iCeil = size < 1073741824 ? (int) Math.ceil(size / 0.75d) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(iCeil);
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return ((C2419MB) mo8268mjFkc()).f9556ZfxDd.mo7990ZfxDd().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return mo8268mjFkc().size();
    }
}
