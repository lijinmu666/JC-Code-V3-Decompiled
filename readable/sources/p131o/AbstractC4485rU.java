package p131o;

import java.util.Set;

/* renamed from: o.rU */
/* loaded from: classes.dex */
public abstract class AbstractC4485rU extends AbstractC2566OO implements Set {

    /* renamed from: AZxh */
    public transient AbstractC4618tS f16339AZxh;

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
        return AbstractC1676BB.m7687mjFkc(this);
    }

    /* renamed from: lgHUyS */
    public final AbstractC4618tS m13375lgHUyS() {
        AbstractC4618tS abstractC4618tS = this.f16339AZxh;
        if (abstractC4618tS != null) {
            return abstractC4618tS;
        }
        AbstractC4618tS abstractC4618tSMo10013qdMbNW = mo10013qdMbNW();
        this.f16339AZxh = abstractC4618tSMo10013qdMbNW;
        return abstractC4618tSMo10013qdMbNW;
    }

    /* renamed from: qdMbNW */
    public AbstractC4618tS mo10013qdMbNW() {
        return AbstractC4618tS.m13627qdMbNW(toArray());
    }
}
