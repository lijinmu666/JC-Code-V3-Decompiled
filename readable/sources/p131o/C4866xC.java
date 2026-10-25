package p131o;

import java.util.Iterator;

/* renamed from: o.xC */
/* loaded from: classes.dex */
public final class C4866xC extends AbstractC3674fC {

    /* renamed from: ZfxDd */
    public final transient AbstractC2878TB f17348ZfxDd;

    /* renamed from: wA */
    public final transient AbstractC3414bC f17349wA;

    public C4866xC(AbstractC3414bC abstractC3414bC, AbstractC2878TB abstractC2878TB) {
        this.f17349wA = abstractC3414bC;
        this.f17348ZfxDd = abstractC2878TB;
    }

    @Override // p131o.AbstractC2014GB, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f17349wA.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f17348ZfxDd.listIterator(0);
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: mjFkc */
    public final int mo8413mjFkc(Object[] objArr, int i) {
        return this.f17348ZfxDd.mo8413mjFkc(objArr, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f17349wA.size();
    }
}
