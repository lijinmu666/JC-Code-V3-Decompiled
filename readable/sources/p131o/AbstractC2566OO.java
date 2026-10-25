package p131o;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: o.OO */
/* loaded from: classes.dex */
public abstract class AbstractC2566OO extends AbstractCollection implements Serializable {

    /* renamed from: mjFkc */
    public static final Object[] f9961mjFkc = new Object[0];

    /* renamed from: JHa */
    public int mo9509JHa() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: ZfxDd */
    public int mo9510ZfxDd() {
        throw new UnsupportedOperationException();
    }

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

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    /* renamed from: mjFkc */
    public abstract int mo9899mjFkc(Object[] objArr, int i);

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

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f9961mjFkc);
    }

    /* renamed from: xJ */
    public Object[] mo9512xJ() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] objArrMo9512xJ = mo9512xJ();
            if (objArrMo9512xJ != null) {
                return Arrays.copyOfRange(objArrMo9512xJ, mo9509JHa(), mo9510ZfxDd(), objArr.getClass());
            }
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        } else if (length > size) {
            objArr[size] = null;
        }
        mo9899mjFkc(objArr, 0);
        return objArr;
    }
}
