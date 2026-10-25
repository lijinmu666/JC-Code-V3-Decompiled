package p131o;

/* renamed from: o.rdJr */
/* loaded from: classes.dex */
public final class C4493rdJr extends AbstractC4722v3 {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f16344AZxh;

    /* renamed from: mjFkc */
    public final long f16345mjFkc;

    /* renamed from: wA */
    public final AbstractC2097HPA f16346wA;

    public C4493rdJr(long j, AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA) {
        this.f16345mjFkc = j;
        if (abstractC3140X8 == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f16344AZxh = abstractC3140X8;
        if (abstractC2097HPA == null) {
            throw new NullPointerException("Null event");
        }
        this.f16346wA = abstractC2097HPA;
    }

    @Override // p131o.AbstractC4722v3
    /* renamed from: AZxh */
    public AbstractC2097HPA mo13382AZxh() {
        return this.f16346wA;
    }

    @Override // p131o.AbstractC4722v3
    /* renamed from: ZfxDd */
    public AbstractC3140X8 mo13383ZfxDd() {
        return this.f16344AZxh;
    }

    /* renamed from: equals */
    public boolean m13384equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4722v3)) {
            return false;
        }
        AbstractC4722v3 abstractC4722v3 = (AbstractC4722v3) obj;
        return this.f16345mjFkc == abstractC4722v3.mo13385wA() && this.f16344AZxh.equals(abstractC4722v3.mo13383ZfxDd()) && this.f16346wA.equals(abstractC4722v3.mo13382AZxh());
    }

    public int hashCode() {
        long j = this.f16345mjFkc;
        return this.f16346wA.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f16344AZxh.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f16345mjFkc + ", transportContext=" + this.f16344AZxh + ", event=" + this.f16346wA + "}";
    }

    @Override // p131o.AbstractC4722v3
    /* renamed from: wA */
    public long mo13385wA() {
        return this.f16345mjFkc;
    }
}
