package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.KE */
/* loaded from: classes.dex */
public final class C2291KE extends AbstractC2619PD {

    /* renamed from: KLFTb */
    public final transient int f9137KLFTb = 1;

    /* renamed from: ZfxDd */
    public final transient Object[] f9138ZfxDd;

    /* renamed from: wA */
    public final transient AbstractC2492ND f9139wA;

    public C2291KE(AbstractC2492ND abstractC2492ND, Object[] objArr, int i, int i2) {
        this.f9139wA = abstractC2492ND;
        this.f9138ZfxDd = objArr;
    }

    @Override // p131o.AbstractC4998zD, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f9139wA.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return m9953lgHUyS().listIterator(0);
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: mjFkc */
    public final int mo8418mjFkc(Object[] objArr, int i) {
        return m9953lgHUyS().mo8418mjFkc(objArr, 0);
    }

    @Override // p131o.AbstractC2619PD
    /* renamed from: qdMbNW */
    public final AbstractC2219JD mo9181qdMbNW() {
        return new C2149IE(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9137KLFTb;
    }
}
