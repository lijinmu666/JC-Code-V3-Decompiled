package p131o;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: o.fx */
/* loaded from: classes.dex */
public abstract class AbstractC3723fx extends AbstractList implements InterfaceC4118ly {

    /* renamed from: mjFkc */
    public boolean f13663mjFkc;

    public AbstractC3723fx(boolean z) {
        this.f13663mjFkc = z;
    }

    @Override // p131o.InterfaceC4118ly
    /* renamed from: AZxh */
    public final boolean mo11968AZxh() {
        return this.f13663mjFkc;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        m11969mjFkc();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        m11969mjFkc();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    /* renamed from: mjFkc */
    public final void m11969mjFkc() {
        if (!this.f13663mjFkc) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract Object remove(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m11969mjFkc();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        m11969mjFkc();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        m11969mjFkc();
        return super.retainAll(collection);
    }

    @Override // p131o.InterfaceC4118ly
    /* renamed from: wA */
    public final void mo11970wA() {
        if (this.f13663mjFkc) {
            this.f13663mjFkc = false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        m11969mjFkc();
        return super.addAll(collection);
    }
}
