package p131o;

import java.util.Map;
import java.util.Set;

/* renamed from: o.q0 */
/* loaded from: classes.dex */
public final class C4385q0 extends AbstractC4187n0 {

    /* renamed from: mjFkc */
    public final C3268Z0 f16005mjFkc = new C3268Z0();

    /* renamed from: Gd */
    public C4385q0 m13150Gd(String str) {
        return (C4385q0) this.f16005mjFkc.get(str);
    }

    /* renamed from: HGpJ */
    public boolean m13151HGpJ(String str) {
        return this.f16005mjFkc.containsKey(str);
    }

    /* renamed from: IEE */
    public void m13152IEE(String str, Number number) {
        m13158fehf(str, number == null ? C4318p0.f15892mjFkc : new C4520s0(number));
    }

    /* renamed from: Pq */
    public void m13153Pq(String str, String str2) {
        m13158fehf(str, str2 == null ? C4318p0.f15892mjFkc : new C4520s0(str2));
    }

    /* renamed from: Ucbh */
    public AbstractC4187n0 m13154Ucbh(String str) {
        return (AbstractC4187n0) this.f16005mjFkc.get(str);
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: diqgf, reason: merged with bridge method [inline-methods] */
    public C4385q0 mo12272mjFkc() {
        C4385q0 c4385q0 = new C4385q0();
        for (Map.Entry entry : this.f16005mjFkc.entrySet()) {
            c4385q0.m13158fehf((String) entry.getKey(), ((AbstractC4187n0) entry.getValue()).mo12272mjFkc());
        }
        return c4385q0;
    }

    /* renamed from: equals */
    public boolean m13156equals(Object obj) {
        return obj == this || ((obj instanceof C4385q0) && ((C4385q0) obj).f16005mjFkc.equals(this.f16005mjFkc));
    }

    /* renamed from: eyqo */
    public Set m13157eyqo() {
        return this.f16005mjFkc.entrySet();
    }

    /* renamed from: fehf */
    public void m13158fehf(String str, AbstractC4187n0 abstractC4187n0) {
        C3268Z0 c3268z0 = this.f16005mjFkc;
        if (abstractC4187n0 == null) {
            abstractC4187n0 = C4318p0.f15892mjFkc;
        }
        c3268z0.put(str, abstractC4187n0);
    }

    public int hashCode() {
        return this.f16005mjFkc.hashCode();
    }

    /* renamed from: huTpC */
    public C3858i0 m13159huTpC(String str) {
        return (C3858i0) this.f16005mjFkc.get(str);
    }

    /* renamed from: vI */
    public Set m13160vI() {
        return this.f16005mjFkc.keySet();
    }
}
