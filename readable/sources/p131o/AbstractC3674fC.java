package p131o;

import java.util.Set;

/* renamed from: o.fC */
/* loaded from: classes.dex */
public abstract class AbstractC3674fC extends AbstractC2014GB implements Set {

    /* renamed from: AZxh */
    public transient AbstractC2878TB f13536AZxh;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return AbstractC2015GC.m8415mjFkc(this);
    }

    /* renamed from: lgHUyS */
    public final AbstractC2878TB m11900lgHUyS() {
        AbstractC2878TB abstractC2878TB = this.f13536AZxh;
        if (abstractC2878TB != null) {
            return abstractC2878TB;
        }
        AbstractC2878TB abstractC2878TBMo11901qdMbNW = mo11901qdMbNW();
        this.f13536AZxh = abstractC2878TBMo11901qdMbNW;
        return abstractC2878TBMo11901qdMbNW;
    }

    /* renamed from: qdMbNW */
    public AbstractC2878TB mo11901qdMbNW() {
        Object[] array = toArray();
        AbstractC2491NC abstractC2491NC = AbstractC2878TB.f10671AZxh;
        return AbstractC2878TB.m10402qdMbNW(array, array.length);
    }
}
