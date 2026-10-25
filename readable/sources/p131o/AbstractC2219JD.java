package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: o.JD */
/* loaded from: classes.dex */
public abstract class AbstractC2219JD extends AbstractC4998zD implements List, RandomAccess {

    /* renamed from: AZxh */
    public static final AbstractC3484cF f8891AZxh = new C1944FD(C2017GE.f8339KLFTb, 0);

    /* renamed from: Dt */
    public static AbstractC2219JD m8919Dt() {
        return C2017GE.f8339KLFTb;
    }

    /* renamed from: ETF */
    public static AbstractC2219JD m8920ETF(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        for (int i = 0; i < 2; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException("at index " + i);
            }
        }
        return m8921qdMbNW(objArr, 2);
    }

    /* renamed from: qdMbNW */
    public static AbstractC2219JD m8921qdMbNW(Object[] objArr, int i) {
        return i == 0 ? C2017GE.f8339KLFTb : new C2017GE(objArr, i);
    }

    @Override // java.util.List
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public final AbstractC3484cF listIterator(int i) {
        AbstractC3168XW.m10941AZxh(i, size(), "index");
        return isEmpty() ? f8891AZxh : new C1944FD(this, i);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // p131o.AbstractC4998zD, java.util.AbstractCollection, java.util.Collection, java.util.List
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
                        if (AbstractC2833SW.m10153mjFkc(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !AbstractC2833SW.m10153mjFkc(it.next(), it2.next())) {
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
    public AbstractC2219JD subList(int i, int i2) {
        AbstractC3168XW.m10945wA(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? C2017GE.f8339KLFTb : new C2081HD(this, i, i3);
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: mjFkc */
    public int mo8418mjFkc(Object[] objArr, int i) {
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
