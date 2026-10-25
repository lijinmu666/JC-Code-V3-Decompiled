package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: o.TB */
/* loaded from: classes.dex */
public abstract class AbstractC2878TB extends AbstractC2014GB implements List, RandomAccess {

    /* renamed from: AZxh */
    public static final AbstractC2491NC f10671AZxh = new C2288KB(C4264oC.f15511KLFTb, 0);

    /* renamed from: Dt */
    public static AbstractC2878TB m10400Dt(Object obj) {
        Object[] objArr = {obj};
        AbstractC4069lC.m12690mjFkc(objArr, 1);
        return m10402qdMbNW(objArr, 1);
    }

    /* renamed from: ETF */
    public static AbstractC2878TB m10401ETF(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9};
        AbstractC4069lC.m12690mjFkc(objArr, 9);
        return m10402qdMbNW(objArr, 9);
    }

    /* renamed from: qdMbNW */
    public static AbstractC2878TB m10402qdMbNW(Object[] objArr, int i) {
        return i == 0 ? C4264oC.f15511KLFTb : new C4264oC(objArr, i);
    }

    @Override // java.util.List
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public final AbstractC2491NC listIterator(int i) {
        AbstractC4284oV.m12958AZxh(i, size(), "index");
        return isEmpty() ? f10671AZxh : new C2288KB(this, i);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // p131o.AbstractC2014GB, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (AbstractC4418qU.m13264mjFkc(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !AbstractC4418qU.m13264mjFkc(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
    public AbstractC2878TB subList(int i, int i2) {
        AbstractC4284oV.m12961wA(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? C4264oC.f15511KLFTb : new C2679QB(this, i, i3);
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: mjFkc */
    public int mo8413mjFkc(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }
}
