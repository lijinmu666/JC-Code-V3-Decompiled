package p131o;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: o.z1 */
/* loaded from: classes.dex */
public abstract class AbstractC4986z1 {

    /* renamed from: AZxh */
    public wA f17611AZxh;

    /* renamed from: mjFkc */
    public AZxh f17612mjFkc;

    /* renamed from: wA */
    public KLFTb f17613wA;

    /* renamed from: o.z1$AZxh */
    public final class AZxh implements Set {
        public AZxh() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int iMo12007ZfxDd = AbstractC4986z1.this.mo12007ZfxDd();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                AbstractC4986z1.this.mo12012xJ(entry.getKey(), entry.getValue());
            }
            return iMo12007ZfxDd != AbstractC4986z1.this.mo12007ZfxDd();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC4986z1.this.mo12009mjFkc();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iMo12006KLFTb = AbstractC4986z1.this.mo12006KLFTb(entry.getKey());
            if (iMo12006KLFTb < 0) {
                return false;
            }
            return AbstractC2458MlqoT.m9535wA(AbstractC4986z1.this.mo12004AZxh(iMo12006KLFTb, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC4986z1.m14075ETF(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo12007ZfxDd = AbstractC4986z1.this.mo12007ZfxDd() - 1; iMo12007ZfxDd >= 0; iMo12007ZfxDd--) {
                Object objMo12004AZxh = AbstractC4986z1.this.mo12004AZxh(iMo12007ZfxDd, 0);
                Object objMo12004AZxh2 = AbstractC4986z1.this.mo12004AZxh(iMo12007ZfxDd, 1);
                iHashCode += (objMo12004AZxh == null ? 0 : objMo12004AZxh.hashCode()) ^ (objMo12004AZxh2 == null ? 0 : objMo12004AZxh2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC4986z1.this.mo12007ZfxDd() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC4986z1.this.new ZfxDd();
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC4986z1.this.mo12007ZfxDd();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: o.z1$KLFTb */
    public final class KLFTb implements Collection {
        public KLFTb() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC4986z1.this.mo12009mjFkc();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC4986z1.this.mo12005JHa(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC4986z1.this.mo12007ZfxDd() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC4986z1.this.new mjFkc(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iMo12005JHa = AbstractC4986z1.this.mo12005JHa(obj);
            if (iMo12005JHa < 0) {
                return false;
            }
            AbstractC4986z1.this.mo12008lgHUyS(iMo12005JHa);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int iMo12007ZfxDd = AbstractC4986z1.this.mo12007ZfxDd();
            int i = 0;
            boolean z = false;
            while (i < iMo12007ZfxDd) {
                if (collection.contains(AbstractC4986z1.this.mo12004AZxh(i, 1))) {
                    AbstractC4986z1.this.mo12008lgHUyS(i);
                    i--;
                    iMo12007ZfxDd--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int iMo12007ZfxDd = AbstractC4986z1.this.mo12007ZfxDd();
            int i = 0;
            boolean z = false;
            while (i < iMo12007ZfxDd) {
                if (!collection.contains(AbstractC4986z1.this.mo12004AZxh(i, 1))) {
                    AbstractC4986z1.this.mo12008lgHUyS(i);
                    i--;
                    iMo12007ZfxDd--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC4986z1.this.mo12007ZfxDd();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC4986z1.this.m14082fehf(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC4986z1.this.m14078IEE(objArr, 1);
        }
    }

    /* renamed from: o.z1$ZfxDd */
    public final class ZfxDd implements Iterator, Map.Entry {

        /* renamed from: mjFkc */
        public int f17618mjFkc;

        /* renamed from: wA */
        public boolean f17619wA = false;

        /* renamed from: AZxh */
        public int f17616AZxh = -1;

        public ZfxDd() {
            this.f17618mjFkc = AbstractC4986z1.this.mo12007ZfxDd() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f17616AZxh++;
            this.f17619wA = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f17619wA) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC2458MlqoT.m9535wA(entry.getKey(), AbstractC4986z1.this.mo12004AZxh(this.f17616AZxh, 0)) && AbstractC2458MlqoT.m9535wA(entry.getValue(), AbstractC4986z1.this.mo12004AZxh(this.f17616AZxh, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f17619wA) {
                return AbstractC4986z1.this.mo12004AZxh(this.f17616AZxh, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f17619wA) {
                return AbstractC4986z1.this.mo12004AZxh(this.f17616AZxh, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17616AZxh < this.f17618mjFkc;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f17619wA) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objMo12004AZxh = AbstractC4986z1.this.mo12004AZxh(this.f17616AZxh, 0);
            Object objMo12004AZxh2 = AbstractC4986z1.this.mo12004AZxh(this.f17616AZxh, 1);
            return (objMo12004AZxh == null ? 0 : objMo12004AZxh.hashCode()) ^ (objMo12004AZxh2 != null ? objMo12004AZxh2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f17619wA) {
                throw new IllegalStateException();
            }
            AbstractC4986z1.this.mo12008lgHUyS(this.f17616AZxh);
            this.f17616AZxh--;
            this.f17618mjFkc--;
            this.f17619wA = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f17619wA) {
                return AbstractC4986z1.this.mo12010qdMbNW(this.f17616AZxh, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: o.z1$mjFkc */
    public final class mjFkc implements Iterator {

        /* renamed from: AZxh */
        public int f17620AZxh;

        /* renamed from: ZfxDd */
        public boolean f17622ZfxDd = false;

        /* renamed from: mjFkc */
        public final int f17623mjFkc;

        /* renamed from: wA */
        public int f17624wA;

        public mjFkc(int i) {
            this.f17623mjFkc = i;
            this.f17620AZxh = AbstractC4986z1.this.mo12007ZfxDd();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17624wA < this.f17620AZxh;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objMo12004AZxh = AbstractC4986z1.this.mo12004AZxh(this.f17624wA, this.f17623mjFkc);
            this.f17624wA++;
            this.f17622ZfxDd = true;
            return objMo12004AZxh;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f17622ZfxDd) {
                throw new IllegalStateException();
            }
            int i = this.f17624wA - 1;
            this.f17624wA = i;
            this.f17620AZxh--;
            this.f17622ZfxDd = false;
            AbstractC4986z1.this.mo12008lgHUyS(i);
        }
    }

    /* renamed from: o.z1$wA */
    public final class wA implements Set {
        public wA() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC4986z1.this.mo12009mjFkc();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC4986z1.this.mo12006KLFTb(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return AbstractC4986z1.m14074Dt(AbstractC4986z1.this.mo12011wA(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC4986z1.m14075ETF(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo12007ZfxDd = AbstractC4986z1.this.mo12007ZfxDd() - 1; iMo12007ZfxDd >= 0; iMo12007ZfxDd--) {
                Object objMo12004AZxh = AbstractC4986z1.this.mo12004AZxh(iMo12007ZfxDd, 0);
                iHashCode += objMo12004AZxh == null ? 0 : objMo12004AZxh.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC4986z1.this.mo12007ZfxDd() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC4986z1.this.new mjFkc(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iMo12006KLFTb = AbstractC4986z1.this.mo12006KLFTb(obj);
            if (iMo12006KLFTb < 0) {
                return false;
            }
            AbstractC4986z1.this.mo12008lgHUyS(iMo12006KLFTb);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return AbstractC4986z1.m14077rkYL(AbstractC4986z1.this.mo12011wA(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return AbstractC4986z1.m14076qGY(AbstractC4986z1.this.mo12011wA(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC4986z1.this.mo12007ZfxDd();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC4986z1.this.m14082fehf(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC4986z1.this.m14078IEE(objArr, 0);
        }
    }

    /* renamed from: Dt */
    public static boolean m14074Dt(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ETF */
    public static boolean m14075ETF(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: qGY */
    public static boolean m14076qGY(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: rkYL */
    public static boolean m14077rkYL(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: AZxh */
    public abstract Object mo12004AZxh(int i, int i2);

    /* renamed from: IEE */
    public Object[] m14078IEE(Object[] objArr, int i) {
        int iMo12007ZfxDd = mo12007ZfxDd();
        if (objArr.length < iMo12007ZfxDd) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iMo12007ZfxDd);
        }
        for (int i2 = 0; i2 < iMo12007ZfxDd; i2++) {
            objArr[i2] = mo12004AZxh(i2, i);
        }
        if (objArr.length > iMo12007ZfxDd) {
            objArr[iMo12007ZfxDd] = null;
        }
        return objArr;
    }

    /* renamed from: JHa */
    public abstract int mo12005JHa(Object obj);

    /* renamed from: KLFTb */
    public abstract int mo12006KLFTb(Object obj);

    /* renamed from: MiMN */
    public Set m14079MiMN() {
        if (this.f17611AZxh == null) {
            this.f17611AZxh = new wA();
        }
        return this.f17611AZxh;
    }

    /* renamed from: VA */
    public Set m14080VA() {
        if (this.f17612mjFkc == null) {
            this.f17612mjFkc = new AZxh();
        }
        return this.f17612mjFkc;
    }

    /* renamed from: YoKzxo */
    public Collection m14081YoKzxo() {
        if (this.f17613wA == null) {
            this.f17613wA = new KLFTb();
        }
        return this.f17613wA;
    }

    /* renamed from: ZfxDd */
    public abstract int mo12007ZfxDd();

    /* renamed from: fehf */
    public Object[] m14082fehf(int i) {
        int iMo12007ZfxDd = mo12007ZfxDd();
        Object[] objArr = new Object[iMo12007ZfxDd];
        for (int i2 = 0; i2 < iMo12007ZfxDd; i2++) {
            objArr[i2] = mo12004AZxh(i2, i);
        }
        return objArr;
    }

    /* renamed from: lgHUyS */
    public abstract void mo12008lgHUyS(int i);

    /* renamed from: mjFkc */
    public abstract void mo12009mjFkc();

    /* renamed from: qdMbNW */
    public abstract Object mo12010qdMbNW(int i, Object obj);

    /* renamed from: wA */
    public abstract Map mo12011wA();

    /* renamed from: xJ */
    public abstract void mo12012xJ(Object obj, Object obj2);
}
