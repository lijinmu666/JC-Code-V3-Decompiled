package p131o;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.PB */
/* loaded from: classes.dex */
public final class C2617PB implements Iterator {

    /* renamed from: AZxh */
    public final /* synthetic */ Iterator f10052AZxh;

    /* renamed from: mjFkc */
    public Map.Entry f10053mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ C2810SB f10054wA;

    public C2617PB(C2810SB c2810sb, Iterator it) {
        this.f10052AZxh = it;
        this.f10054wA = c2810sb;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10052AZxh.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f10052AZxh.next();
        this.f10053mjFkc = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        AbstractC3168XW.m10943ZfxDd(this.f10053mjFkc != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.f10053mjFkc.getValue();
        this.f10052AZxh.remove();
        this.f10054wA.f10520AZxh.f15363ZfxDd -= collection.size();
        collection.clear();
        this.f10053mjFkc = null;
    }
}
