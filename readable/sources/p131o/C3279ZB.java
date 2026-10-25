package p131o;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.ZB */
/* loaded from: classes.dex */
public class C3279ZB implements Iterator {

    /* renamed from: AZxh */
    public final Collection f12012AZxh;

    /* renamed from: mjFkc */
    public final Iterator f12013mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ AbstractC3546dC f12014wA;

    public C3279ZB(AbstractC3546dC abstractC3546dC, Iterator it) {
        this.f12014wA = abstractC3546dC;
        this.f12012AZxh = abstractC3546dC.f13324AZxh;
        this.f12013mjFkc = it;
    }

    /* renamed from: AZxh */
    public final void m11193AZxh() {
        this.f12014wA.m11718ZfxDd();
        if (this.f12014wA.f13324AZxh != this.f12012AZxh) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        m11193AZxh();
        return this.f12013mjFkc.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        m11193AZxh();
        return this.f12013mjFkc.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12013mjFkc.remove();
        AbstractC4199nC abstractC4199nC = this.f12014wA.f13325KLFTb;
        abstractC4199nC.f15363ZfxDd--;
        this.f12014wA.m11717JHa();
    }

    public C3279ZB(AbstractC3546dC abstractC3546dC) {
        this.f12014wA = abstractC3546dC;
        Collection collection = abstractC3546dC.f13324AZxh;
        this.f12012AZxh = collection;
        this.f12013mjFkc = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }
}
