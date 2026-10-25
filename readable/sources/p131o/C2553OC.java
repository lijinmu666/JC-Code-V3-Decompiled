package p131o;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.OC */
/* loaded from: classes.dex */
public final class C2553OC extends AbstractSet {

    /* renamed from: mjFkc */
    public final /* synthetic */ C4333pD f9924mjFkc;

    public C2553OC(C4333pD c4333pD) {
        this.f9924mjFkc = c4333pD;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f9924mjFkc.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map mapM13121rkYL = this.f9924mjFkc.m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iM13122vI = this.f9924mjFkc.m13122vI(entry.getKey());
            if (iM13122vI != -1 && AbstractC2833SW.m10153mjFkc(C4333pD.m13100MiMN(this.f9924mjFkc, iM13122vI), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        C4333pD c4333pD = this.f9924mjFkc;
        Map mapM13121rkYL = c4333pD.m13121rkYL();
        return mapM13121rkYL != null ? mapM13121rkYL.entrySet().iterator() : new C2147IC(c4333pD);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapM13121rkYL = this.f9924mjFkc.m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        C4333pD c4333pD = this.f9924mjFkc;
        if (c4333pD.m13116eyqo()) {
            return false;
        }
        int iM13111HGpJ = c4333pD.m13111HGpJ();
        Object key = entry.getKey();
        Object value = entry.getValue();
        C4333pD c4333pD2 = this.f9924mjFkc;
        int iM13357AZxh = AbstractC4467rD.m13357AZxh(key, value, iM13111HGpJ, C4333pD.m13102VA(c4333pD2), c4333pD2.m13119mjFkc(), c4333pD2.m13109AZxh(), c4333pD2.m13123wA());
        if (iM13357AZxh == -1) {
            return false;
        }
        this.f9924mjFkc.m13115diqgf(iM13357AZxh, iM13111HGpJ);
        C4333pD c4333pD3 = this.f9924mjFkc;
        c4333pD3.f15920JHa--;
        this.f9924mjFkc.m13112IEE();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9924mjFkc.size();
    }
}
