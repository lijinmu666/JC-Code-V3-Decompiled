package p131o;

/* renamed from: o.XD */
/* loaded from: classes.dex */
public final class C3145XD extends AbstractC4697uhQ {

    /* renamed from: AZxh */
    public final Object f11560AZxh;

    /* renamed from: mjFkc */
    public final Integer f11561mjFkc;

    /* renamed from: wA */
    public final EnumC2347L3 f11562wA;

    public C3145XD(Integer num, Object obj, EnumC2347L3 enumC2347L3) {
        this.f11561mjFkc = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f11560AZxh = obj;
        if (enumC2347L3 == null) {
            throw new NullPointerException("Null priority");
        }
        this.f11562wA = enumC2347L3;
    }

    @Override // p131o.AbstractC4697uhQ
    /* renamed from: AZxh */
    public Object mo10914AZxh() {
        return this.f11560AZxh;
    }

    /* renamed from: equals */
    public boolean m10915equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4697uhQ)) {
            return false;
        }
        AbstractC4697uhQ abstractC4697uhQ = (AbstractC4697uhQ) obj;
        Integer num = this.f11561mjFkc;
        if (num != null ? num.equals(abstractC4697uhQ.mo10916mjFkc()) : abstractC4697uhQ.mo10916mjFkc() == null) {
            if (this.f11560AZxh.equals(abstractC4697uhQ.mo10914AZxh()) && this.f11562wA.equals(abstractC4697uhQ.mo10917wA())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f11561mjFkc;
        return this.f11562wA.hashCode() ^ (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f11560AZxh.hashCode()) * 1000003);
    }

    @Override // p131o.AbstractC4697uhQ
    /* renamed from: mjFkc */
    public Integer mo10916mjFkc() {
        return this.f11561mjFkc;
    }

    public String toString() {
        return "Event{code=" + this.f11561mjFkc + ", payload=" + this.f11560AZxh + ", priority=" + this.f11562wA + "}";
    }

    @Override // p131o.AbstractC4697uhQ
    /* renamed from: wA */
    public EnumC2347L3 mo10917wA() {
        return this.f11562wA;
    }
}
