package p131o;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

/* renamed from: o.Os */
/* loaded from: classes.dex */
public abstract class AbstractC2595Os extends AbstractCollection implements Serializable {

    /* renamed from: mjFkc */
    public static final Object[] f10006mjFkc = new Object[0];

    /* renamed from: JHa */
    public abstract int mo9911JHa();

    /* renamed from: ZfxDd */
    public abstract int mo9912ZfxDd();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: mjFkc */
    public abstract int mo9913mjFkc(Object[] objArr, int i);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f10006mjFkc);
    }

    /* renamed from: xJ */
    public abstract Object[] mo9914xJ();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] objArrMo9914xJ = mo9914xJ();
            if (objArrMo9914xJ != null) {
                return Arrays.copyOfRange(objArrMo9914xJ, mo9911JHa(), mo9912ZfxDd(), objArr.getClass());
            }
            if (length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        } else if (length > size) {
            objArr[size] = null;
        }
        mo9913mjFkc(objArr, 0);
        return objArr;
    }
}
