package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.IB */
/* loaded from: classes.dex */
public final class C2146IB implements Iterator {

    /* renamed from: AZxh */
    public Collection f8712AZxh;

    /* renamed from: mjFkc */
    public final Iterator f8713mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ C2419MB f8714wA;

    public C2146IB(C2419MB c2419mb) {
        this.f8714wA = c2419mb;
        this.f8713mjFkc = c2419mb.f9557wA.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8713mjFkc.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f8713mjFkc.next();
        this.f8712AZxh = (Collection) entry.getValue();
        Object key = entry.getKey();
        return new C1678BD(key, this.f8714wA.f9556ZfxDd.mo7778lgHUyS(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        AbstractC3168XW.m10943ZfxDd(this.f8712AZxh != null, "no calls to next() since the last call to remove()");
        this.f8713mjFkc.remove();
        this.f8714wA.f9556ZfxDd.f15363ZfxDd -= this.f8712AZxh.size();
        this.f8712AZxh.clear();
        this.f8712AZxh = null;
    }
}
