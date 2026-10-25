package p131o;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* renamed from: o.kC */
/* loaded from: classes.dex */
public class C4003kC extends AbstractC3546dC implements List {

    /* renamed from: JHa */
    public final /* synthetic */ AbstractC4199nC f14512JHa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4003kC(AbstractC4199nC abstractC4199nC, Object obj, List list, AbstractC3546dC abstractC3546dC) {
        super(abstractC4199nC, obj, list, abstractC3546dC);
        this.f14512JHa = abstractC4199nC;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        m11718ZfxDd();
        boolean zIsEmpty = this.f13324AZxh.isEmpty();
        ((List) this.f13324AZxh).add(i, obj);
        this.f14512JHa.f15363ZfxDd++;
        if (zIsEmpty) {
            m11719mjFkc();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f13324AZxh).addAll(i, collection);
        if (zAddAll) {
            int size2 = this.f13324AZxh.size();
            this.f14512JHa.f15363ZfxDd += size2 - size;
            if (size == 0) {
                m11719mjFkc();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final Object get(int i) {
        m11718ZfxDd();
        return ((List) this.f13324AZxh).get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        m11718ZfxDd();
        return ((List) this.f13324AZxh).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        m11718ZfxDd();
        return ((List) this.f13324AZxh).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        m11718ZfxDd();
        return new C3808hC(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        m11718ZfxDd();
        Object objRemove = ((List) this.f13324AZxh).remove(i);
        AbstractC4199nC abstractC4199nC = this.f14512JHa;
        abstractC4199nC.f15363ZfxDd--;
        m11717JHa();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        m11718ZfxDd();
        return ((List) this.f13324AZxh).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        m11718ZfxDd();
        List listSubList = ((List) this.f13324AZxh).subList(i, i2);
        AbstractC3546dC abstractC3546dC = this.f13328wA;
        if (abstractC3546dC == null) {
            abstractC3546dC = this;
        }
        return this.f14512JHa.m12862ETF(this.f13327mjFkc, listSubList, abstractC3546dC);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        m11718ZfxDd();
        return new C3808hC(this, i);
    }
}
