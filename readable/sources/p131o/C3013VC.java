package p131o;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.VC */
/* loaded from: classes.dex */
public final class C3013VC extends AbstractSet {

    /* renamed from: mjFkc */
    public final /* synthetic */ C4333pD f11307mjFkc;

    public C3013VC(C4333pD c4333pD) {
        this.f11307mjFkc = c4333pD;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f11307mjFkc.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f11307mjFkc.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        C4333pD c4333pD = this.f11307mjFkc;
        Map mapM13121rkYL = c4333pD.m13121rkYL();
        return mapM13121rkYL != null ? mapM13121rkYL.keySet().iterator() : new C1943FC(c4333pD);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapM13121rkYL = this.f11307mjFkc.m13121rkYL();
        return mapM13121rkYL != null ? mapM13121rkYL.keySet().remove(obj) : this.f11307mjFkc.m13110BAnRFn(obj) != C4333pD.f15918Dt;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f11307mjFkc.size();
    }
}
