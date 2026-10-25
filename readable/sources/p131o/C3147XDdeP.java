package p131o;

import java.util.Map;

/* renamed from: o.XDdeP */
/* loaded from: classes.dex */
public final class C3147XDdeP extends AbstractC4391q6 {

    /* renamed from: AZxh */
    public final Map f11564AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC3350aDq f11565mjFkc;

    public C3147XDdeP(InterfaceC3350aDq interfaceC3350aDq, Map map) {
        if (interfaceC3350aDq == null) {
            throw new NullPointerException("Null clock");
        }
        this.f11565mjFkc = interfaceC3350aDq;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f11564AZxh = map;
    }

    @Override // p131o.AbstractC4391q6
    /* renamed from: KLFTb */
    public InterfaceC3350aDq mo10922KLFTb() {
        return this.f11565mjFkc;
    }

    /* renamed from: equals */
    public boolean m10923equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4391q6)) {
            return false;
        }
        AbstractC4391q6 abstractC4391q6 = (AbstractC4391q6) obj;
        return this.f11565mjFkc.equals(abstractC4391q6.mo10922KLFTb()) && this.f11564AZxh.equals(abstractC4391q6.mo10924lgHUyS());
    }

    public int hashCode() {
        return this.f11564AZxh.hashCode() ^ ((this.f11565mjFkc.hashCode() ^ 1000003) * 1000003);
    }

    @Override // p131o.AbstractC4391q6
    /* renamed from: lgHUyS */
    public Map mo10924lgHUyS() {
        return this.f11564AZxh;
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f11565mjFkc + ", values=" + this.f11564AZxh + "}";
    }
}
