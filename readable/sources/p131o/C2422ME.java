package p131o;

import java.util.Iterator;

/* renamed from: o.ME */
/* loaded from: classes.dex */
public final class C2422ME extends AbstractC2619PD {

    /* renamed from: ZfxDd */
    public final transient AbstractC2219JD f9558ZfxDd;

    /* renamed from: wA */
    public final transient AbstractC2492ND f9559wA;

    public C2422ME(AbstractC2492ND abstractC2492ND, AbstractC2219JD abstractC2219JD) {
        this.f9559wA = abstractC2492ND;
        this.f9558ZfxDd = abstractC2219JD;
    }

    @Override // p131o.AbstractC4998zD, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f9559wA.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f9558ZfxDd.listIterator(0);
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: mjFkc */
    public final int mo8418mjFkc(Object[] objArr, int i) {
        return this.f9558ZfxDd.mo8418mjFkc(objArr, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }
}
