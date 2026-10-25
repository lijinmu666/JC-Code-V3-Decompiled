package p131o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.i0 */
/* loaded from: classes.dex */
public final class C3858i0 extends AbstractC4187n0 implements Iterable {

    /* renamed from: mjFkc */
    public final List f14100mjFkc;

    public C3858i0() {
        this.f14100mjFkc = new ArrayList();
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: Dt */
    public long mo12262Dt() {
        if (this.f14100mjFkc.size() == 1) {
            return ((AbstractC4187n0) this.f14100mjFkc.get(0)).mo12262Dt();
        }
        throw new IllegalStateException();
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: ETF */
    public Number mo12263ETF() {
        if (this.f14100mjFkc.size() == 1) {
            return ((AbstractC4187n0) this.f14100mjFkc.get(0)).mo12263ETF();
        }
        throw new IllegalStateException();
    }

    /* renamed from: IEE */
    public void m12264IEE(AbstractC4187n0 abstractC4187n0) {
        if (abstractC4187n0 == null) {
            abstractC4187n0 = C4318p0.f15892mjFkc;
        }
        this.f14100mjFkc.add(abstractC4187n0);
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: JHa */
    public double mo12265JHa() {
        if (this.f14100mjFkc.size() == 1) {
            return ((AbstractC4187n0) this.f14100mjFkc.get(0)).mo12265JHa();
        }
        throw new IllegalStateException();
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: Pq, reason: merged with bridge method [inline-methods] */
    public C3858i0 mo12272mjFkc() {
        if (this.f14100mjFkc.isEmpty()) {
            return new C3858i0();
        }
        C3858i0 c3858i0 = new C3858i0(this.f14100mjFkc.size());
        Iterator it = this.f14100mjFkc.iterator();
        while (it.hasNext()) {
            c3858i0.m12264IEE(((AbstractC4187n0) it.next()).mo12272mjFkc());
        }
        return c3858i0;
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: VA */
    public String mo12267VA() {
        if (this.f14100mjFkc.size() == 1) {
            return ((AbstractC4187n0) this.f14100mjFkc.get(0)).mo12267VA();
        }
        throw new IllegalStateException();
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: ZfxDd */
    public boolean mo12268ZfxDd() {
        if (this.f14100mjFkc.size() == 1) {
            return ((AbstractC4187n0) this.f14100mjFkc.get(0)).mo12268ZfxDd();
        }
        throw new IllegalStateException();
    }

    /* renamed from: diqgf */
    public AbstractC4187n0 m12269diqgf(int i) {
        return (AbstractC4187n0) this.f14100mjFkc.get(i);
    }

    /* renamed from: equals */
    public boolean m12270equals(Object obj) {
        return obj == this || ((obj instanceof C3858i0) && ((C3858i0) obj).f14100mjFkc.equals(this.f14100mjFkc));
    }

    /* renamed from: fehf */
    public void m12271fehf(String str) {
        this.f14100mjFkc.add(str == null ? C4318p0.f15892mjFkc : new C4520s0(str));
    }

    public int hashCode() {
        return this.f14100mjFkc.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f14100mjFkc.iterator();
    }

    /* renamed from: size */
    public int m12273size() {
        return this.f14100mjFkc.size();
    }

    public C3858i0(int i) {
        this.f14100mjFkc = new ArrayList(i);
    }
}
