package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: o.tS */
/* loaded from: classes.dex */
public abstract class AbstractC4618tS extends AbstractC2566OO implements List, RandomAccess {

    /* renamed from: AZxh */
    public static final AbstractC2078HB f16701AZxh = new C3756gR(C3235YV.f11885KLFTb, 0);

    /* renamed from: Dt */
    public static AbstractC4618tS m13625Dt(Object[] objArr, int i) {
        return i == 0 ? C3235YV.f11885KLFTb : new C3235YV(objArr, i);
    }

    /* renamed from: ETF */
    public static AbstractC4618tS m13626ETF(Object obj) {
        Object[] objArr = {obj};
        AbstractC4353pV.m13132mjFkc(objArr, 1);
        return m13625Dt(objArr, 1);
    }

    /* renamed from: qdMbNW */
    public static AbstractC4618tS m13627qdMbNW(Object[] objArr) {
        return m13625Dt(objArr, objArr.length);
    }

    @Override // java.util.List
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public final AbstractC2078HB listIterator(int i) {
        AbstractC2623PH.m9954AZxh(i, size(), "index");
        return isEmpty() ? f16701AZxh : new C3756gR(this, i);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // p131o.AbstractC2566OO, java.util.AbstractCollection, java.util.Collection
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
                        if (AbstractC4070lD.m12691mjFkc(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !AbstractC4070lD.m12691mjFkc(it.next(), it2.next())) {
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
    public AbstractC4618tS subList(int i, int i2) {
        AbstractC2623PH.m9957wA(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? C3235YV.f11885KLFTb : new C2439MR(this, i, i3);
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: mjFkc */
    public int mo9899mjFkc(Object[] objArr, int i) {
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
