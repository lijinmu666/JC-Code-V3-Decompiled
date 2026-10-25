package p131o;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* renamed from: o.nC */
/* loaded from: classes.dex */
public abstract class AbstractC4199nC extends AbstractC4600tC implements Serializable {

    /* renamed from: ZfxDd */
    public transient int f15363ZfxDd;

    /* renamed from: wA */
    public transient Map f15364wA;

    public AbstractC4199nC(Map map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.f15364wA = map;
    }

    /* renamed from: YoKzxo */
    public static /* bridge */ /* synthetic */ void m12859YoKzxo(AbstractC4199nC abstractC4199nC, Object obj) {
        Object objRemove;
        Map map = abstractC4199nC.f15364wA;
        map.getClass();
        try {
            objRemove = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            abstractC4199nC.f15363ZfxDd -= size;
        }
    }

    @Override // p131o.InterfaceC1813DE
    /* renamed from: AZxh */
    public final boolean mo7989AZxh(Object obj, Object obj2) {
        Collection collection = (Collection) this.f15364wA.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f15363ZfxDd++;
            return true;
        }
        Collection collectionMo12866xJ = mo12866xJ();
        if (!collectionMo12866xJ.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f15363ZfxDd++;
        this.f15364wA.put(obj, collectionMo12866xJ);
        return true;
    }

    /* renamed from: Dt */
    public final Collection m12861Dt(Object obj) {
        Collection collectionMo12866xJ = (Collection) this.f15364wA.get(obj);
        if (collectionMo12866xJ == null) {
            collectionMo12866xJ = mo12866xJ();
        }
        return mo7778lgHUyS(obj, collectionMo12866xJ);
    }

    /* renamed from: ETF */
    public final List m12862ETF(Object obj, List list, AbstractC3546dC abstractC3546dC) {
        return list instanceof RandomAccess ? new C3012VB(this, obj, list, abstractC3546dC) : new C4003kC(this, obj, list, abstractC3546dC);
    }

    @Override // p131o.AbstractC4600tC
    /* renamed from: JHa */
    public final Set mo12863JHa() {
        return new C2810SB(this, this.f15364wA);
    }

    @Override // p131o.AbstractC4600tC
    /* renamed from: KLFTb */
    public final Map mo12864KLFTb() {
        return new C2419MB(this, this.f15364wA);
    }

    /* renamed from: lgHUyS */
    public abstract Collection mo7778lgHUyS(Object obj, Collection collection);

    /* renamed from: rkYL */
    public final void m12865rkYL() {
        Iterator it = this.f15364wA.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f15364wA.clear();
        this.f15363ZfxDd = 0;
    }

    /* renamed from: xJ */
    public abstract Collection mo12866xJ();
}
