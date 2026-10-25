package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.uC */
/* loaded from: classes.dex */
public final class C4667uC extends AbstractC3674fC {

    /* renamed from: KLFTb */
    public final transient int f16809KLFTb;

    /* renamed from: ZfxDd */
    public final transient Object[] f16810ZfxDd;

    /* renamed from: wA */
    public final transient AbstractC3414bC f16811wA;

    public C4667uC(AbstractC3414bC abstractC3414bC, Object[] objArr, int i, int i2) {
        this.f16811wA = abstractC3414bC;
        this.f16810ZfxDd = objArr;
        this.f16809KLFTb = i2;
    }

    @Override // p131o.AbstractC2014GB, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f16811wA.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return m11900lgHUyS().listIterator(0);
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: mjFkc */
    public final int mo8413mjFkc(Object[] objArr, int i) {
        return m11900lgHUyS().mo8413mjFkc(objArr, 0);
    }

    @Override // p131o.AbstractC3674fC
    /* renamed from: qdMbNW */
    public final AbstractC2878TB mo11901qdMbNW() {
        return new C4466rC(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f16809KLFTb;
    }
}
