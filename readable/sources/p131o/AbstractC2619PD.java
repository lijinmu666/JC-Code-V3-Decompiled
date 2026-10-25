package p131o;

import java.util.Set;

/* renamed from: o.PD */
/* loaded from: classes.dex */
public abstract class AbstractC2619PD extends AbstractC4998zD implements Set {

    /* renamed from: AZxh */
    public transient AbstractC2219JD f10055AZxh;

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
        return AbstractC2944UE.m10480mjFkc(this);
    }

    /* renamed from: lgHUyS */
    public final AbstractC2219JD m9953lgHUyS() {
        AbstractC2219JD abstractC2219JD = this.f10055AZxh;
        if (abstractC2219JD != null) {
            return abstractC2219JD;
        }
        AbstractC2219JD abstractC2219JDMo9181qdMbNW = mo9181qdMbNW();
        this.f10055AZxh = abstractC2219JDMo9181qdMbNW;
        return abstractC2219JDMo9181qdMbNW;
    }

    /* renamed from: qdMbNW */
    public AbstractC2219JD mo9181qdMbNW() {
        Object[] array = toArray();
        AbstractC3484cF abstractC3484cF = AbstractC2219JD.f8891AZxh;
        return AbstractC2219JD.m8921qdMbNW(array, array.length);
    }
}
