package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.QW */
/* loaded from: classes.dex */
public final class C2701QW extends AbstractC4485rU {

    /* renamed from: KLFTb */
    public final transient int f10185KLFTb;

    /* renamed from: ZfxDd */
    public final transient Object[] f10186ZfxDd;

    /* renamed from: wA */
    public final transient AbstractC1963FT f10187wA;

    public C2701QW(AbstractC1963FT abstractC1963FT, Object[] objArr, int i, int i2) {
        this.f10187wA = abstractC1963FT;
        this.f10186ZfxDd = objArr;
        this.f10185KLFTb = i2;
    }

    @Override // p131o.AbstractC2566OO, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f10187wA.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return m13375lgHUyS().listIterator(0);
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: mjFkc */
    public final int mo9899mjFkc(Object[] objArr, int i) {
        return m13375lgHUyS().mo9899mjFkc(objArr, 0);
    }

    @Override // p131o.AbstractC4485rU
    /* renamed from: qdMbNW */
    public final AbstractC4618tS mo10013qdMbNW() {
        return new C1632AW(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f10185KLFTb;
    }
}
