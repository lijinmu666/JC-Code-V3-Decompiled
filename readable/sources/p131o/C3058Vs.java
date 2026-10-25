package p131o;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: o.Vs */
/* loaded from: classes.dex */
public final class C3058Vs extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: AZxh */
    public final InterfaceC5040zs f11377AZxh;

    /* renamed from: mjFkc */
    public final List f11378mjFkc;

    public C3058Vs(List list, InterfaceC5040zs interfaceC5040zs) {
        list.getClass();
        this.f11378mjFkc = list;
        this.f11377AZxh = interfaceC5040zs;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f11377AZxh.mo10957mjFkc(this.f11378mjFkc.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f11378mjFkc.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C2992Us(this, this.f11378mjFkc.listIterator(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.f11377AZxh.mo10957mjFkc(this.f11378mjFkc.remove(i));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        this.f11378mjFkc.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11378mjFkc.size();
    }
}
