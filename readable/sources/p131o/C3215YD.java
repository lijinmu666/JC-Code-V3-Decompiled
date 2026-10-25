package p131o;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: o.YD */
/* loaded from: classes.dex */
public final class C3215YD extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: AZxh */
    public final InterfaceC3301ZV f11835AZxh;

    /* renamed from: mjFkc */
    public final List f11836mjFkc;

    public C3215YD(List list, InterfaceC3301ZV interfaceC3301ZV) {
        list.getClass();
        this.f11836mjFkc = list;
        this.f11835AZxh = interfaceC3301ZV;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f11835AZxh.mo7828mjFkc(this.f11836mjFkc.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f11836mjFkc.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C3014VD(this, this.f11836mjFkc.listIterator(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.f11835AZxh.mo7828mjFkc(this.f11836mjFkc.remove(i));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        this.f11836mjFkc.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11836mjFkc.size();
    }
}
