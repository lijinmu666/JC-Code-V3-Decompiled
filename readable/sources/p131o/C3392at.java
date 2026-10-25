package p131o;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: o.at */
/* loaded from: classes.dex */
public final class C3392at extends AbstractSequentialList implements Serializable {

    /* renamed from: AZxh */
    public final InterfaceC5040zs f12826AZxh;

    /* renamed from: mjFkc */
    public final List f12827mjFkc;

    public C3392at(List list, InterfaceC5040zs interfaceC5040zs) {
        list.getClass();
        this.f12827mjFkc = list;
        this.f12826AZxh = interfaceC5040zs;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f12827mjFkc.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C3325Zs(this, this.f12827mjFkc.listIterator(i));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        this.f12827mjFkc.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12827mjFkc.size();
    }
}
