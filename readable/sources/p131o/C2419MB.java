package p131o;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: o.MB */
/* loaded from: classes.dex */
public final class C2419MB extends AbstractC4999zE {

    /* renamed from: ZfxDd */
    public final /* synthetic */ AbstractC4199nC f9556ZfxDd;

    /* renamed from: wA */
    public final transient Map f9557wA;

    public C2419MB(AbstractC4199nC abstractC4199nC, Map map) {
        this.f9556ZfxDd = abstractC4199nC;
        this.f9557wA = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        AbstractC4199nC abstractC4199nC = this.f9556ZfxDd;
        if (this.f9557wA == abstractC4199nC.f15364wA) {
            abstractC4199nC.m12865rkYL();
        } else {
            AbstractC2746RD.m10059mjFkc(new C2146IB(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return AbstractC1679BE.m7688AZxh(this.f9557wA, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f9557wA.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) AbstractC1679BE.m7689mjFkc(this.f9557wA, obj);
        if (collection == null) {
            return null;
        }
        return this.f9556ZfxDd.mo7778lgHUyS(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f9557wA.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f9556ZfxDd.mo7990ZfxDd();
    }

    @Override // p131o.AbstractC4999zE
    /* renamed from: mjFkc */
    public final Set mo9492mjFkc() {
        return new C1941FB(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.f9557wA.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionMo12866xJ = this.f9556ZfxDd.mo12866xJ();
        collectionMo12866xJ.addAll(collection);
        this.f9556ZfxDd.f15363ZfxDd -= collection.size();
        collection.clear();
        return collectionMo12866xJ;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9557wA.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f9557wA.toString();
    }
}
