package p131o;

import java.util.Iterator;

/* renamed from: o.WW */
/* loaded from: classes.dex */
public final class C3101WW extends AbstractC4485rU {

    /* renamed from: ZfxDd */
    public final transient AbstractC4618tS f11469ZfxDd;

    /* renamed from: wA */
    public final transient AbstractC1963FT f11470wA;

    public C3101WW(AbstractC1963FT abstractC1963FT, AbstractC4618tS abstractC4618tS) {
        this.f11470wA = abstractC1963FT;
        this.f11469ZfxDd = abstractC4618tS;
    }

    @Override // p131o.AbstractC2566OO, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f11470wA.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f11469ZfxDd.listIterator(0);
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: mjFkc */
    public final int mo9899mjFkc(Object[] objArr, int i) {
        return this.f11469ZfxDd.mo9899mjFkc(objArr, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f11470wA.size();
    }
}
