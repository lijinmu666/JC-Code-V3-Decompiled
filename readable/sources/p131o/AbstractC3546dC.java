package p131o;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* renamed from: o.dC */
/* loaded from: classes.dex */
public abstract class AbstractC3546dC extends AbstractCollection {

    /* renamed from: AZxh */
    public Collection f13324AZxh;

    /* renamed from: KLFTb */
    public final /* synthetic */ AbstractC4199nC f13325KLFTb;

    /* renamed from: ZfxDd */
    public final Collection f13326ZfxDd;

    /* renamed from: mjFkc */
    public final Object f13327mjFkc;

    /* renamed from: wA */
    public final AbstractC3546dC f13328wA;

    public AbstractC3546dC(AbstractC4199nC abstractC4199nC, Object obj, Collection collection, AbstractC3546dC abstractC3546dC) {
        this.f13325KLFTb = abstractC4199nC;
        this.f13327mjFkc = obj;
        this.f13324AZxh = collection;
        this.f13328wA = abstractC3546dC;
        this.f13326ZfxDd = abstractC3546dC == null ? null : abstractC3546dC.f13324AZxh;
    }

    /* renamed from: JHa */
    public final void m11717JHa() {
        AbstractC3546dC abstractC3546dC = this.f13328wA;
        if (abstractC3546dC != null) {
            abstractC3546dC.m11717JHa();
        } else if (this.f13324AZxh.isEmpty()) {
            AbstractC4199nC abstractC4199nC = this.f13325KLFTb;
            abstractC4199nC.f15364wA.remove(this.f13327mjFkc);
        }
    }

    /* renamed from: ZfxDd */
    public final void m11718ZfxDd() {
        AbstractC3546dC abstractC3546dC = this.f13328wA;
        if (abstractC3546dC != null) {
            abstractC3546dC.m11718ZfxDd();
            AbstractC3546dC abstractC3546dC2 = this.f13328wA;
            if (abstractC3546dC2.f13324AZxh != this.f13326ZfxDd) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.f13324AZxh.isEmpty()) {
            AbstractC4199nC abstractC4199nC = this.f13325KLFTb;
            Collection collection = (Collection) abstractC4199nC.f15364wA.get(this.f13327mjFkc);
            if (collection != null) {
                this.f13324AZxh = collection;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        m11718ZfxDd();
        boolean zIsEmpty = this.f13324AZxh.isEmpty();
        boolean zAdd = this.f13324AZxh.add(obj);
        if (zAdd) {
            this.f13325KLFTb.f15363ZfxDd++;
            if (zIsEmpty) {
                m11719mjFkc();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f13324AZxh.addAll(collection);
        if (zAddAll) {
            int size2 = this.f13324AZxh.size();
            this.f13325KLFTb.f15363ZfxDd += size2 - size;
            if (size == 0) {
                m11719mjFkc();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f13324AZxh.clear();
        this.f13325KLFTb.f15363ZfxDd -= size;
        m11717JHa();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        m11718ZfxDd();
        return this.f13324AZxh.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        m11718ZfxDd();
        return this.f13324AZxh.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        m11718ZfxDd();
        return this.f13324AZxh.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        m11718ZfxDd();
        return this.f13324AZxh.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        m11718ZfxDd();
        return new C3279ZB(this);
    }

    /* renamed from: mjFkc */
    public final void m11719mjFkc() {
        AbstractC3546dC abstractC3546dC = this.f13328wA;
        if (abstractC3546dC != null) {
            abstractC3546dC.m11719mjFkc();
            return;
        }
        AbstractC4199nC abstractC4199nC = this.f13325KLFTb;
        abstractC4199nC.f15364wA.put(this.f13327mjFkc, this.f13324AZxh);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        m11718ZfxDd();
        boolean zRemove = this.f13324AZxh.remove(obj);
        if (zRemove) {
            AbstractC4199nC abstractC4199nC = this.f13325KLFTb;
            abstractC4199nC.f15363ZfxDd--;
            m11717JHa();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f13324AZxh.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.f13324AZxh.size();
            this.f13325KLFTb.f15363ZfxDd += size2 - size;
            m11717JHa();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f13324AZxh.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.f13324AZxh.size();
            this.f13325KLFTb.f15363ZfxDd += size2 - size;
            m11717JHa();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        m11718ZfxDd();
        return this.f13324AZxh.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        m11718ZfxDd();
        return this.f13324AZxh.toString();
    }
}
