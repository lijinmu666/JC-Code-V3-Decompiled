package p131o;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: o.cE */
/* loaded from: classes.dex */
public final class C3483cE extends AbstractSequentialList implements Serializable {

    /* renamed from: AZxh */
    public final InterfaceC3301ZV f13213AZxh;

    /* renamed from: mjFkc */
    public final List f13214mjFkc;

    public C3483cE(List list, InterfaceC3301ZV interfaceC3301ZV) {
        list.getClass();
        this.f13214mjFkc = list;
        this.f13213AZxh = interfaceC3301ZV;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f13214mjFkc.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C3351aE(this, this.f13214mjFkc.listIterator(i));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        this.f13214mjFkc.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13214mjFkc.size();
    }
}
