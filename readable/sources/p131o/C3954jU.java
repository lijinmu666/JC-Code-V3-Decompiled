package p131o;

/* renamed from: o.jU */
/* loaded from: classes.dex */
public final class C3954jU extends AbstractC1630AU {

    /* renamed from: AZxh */
    public final boolean f14316AZxh;

    /* renamed from: mjFkc */
    public final String f14317mjFkc;

    /* renamed from: wA */
    public final int f14318wA;

    public /* synthetic */ C3954jU(String str, boolean z, int i, AbstractC3826hU abstractC3826hU) {
        this.f14317mjFkc = str;
        this.f14316AZxh = z;
        this.f14318wA = i;
    }

    @Override // p131o.AbstractC1630AU
    /* renamed from: AZxh */
    public final String mo7606AZxh() {
        return this.f14317mjFkc;
    }

    /* renamed from: equals */
    public final boolean m12435equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1630AU) {
            AbstractC1630AU abstractC1630AU = (AbstractC1630AU) obj;
            if (this.f14317mjFkc.equals(abstractC1630AU.mo7606AZxh()) && this.f14316AZxh == abstractC1630AU.mo7608wA() && this.f14318wA == abstractC1630AU.mo7607mjFkc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f14317mjFkc.hashCode() ^ 1000003;
        return this.f14318wA ^ (((iHashCode * 1000003) ^ (true != this.f14316AZxh ? 1237 : 1231)) * 1000003);
    }

    @Override // p131o.AbstractC1630AU
    /* renamed from: mjFkc */
    public final int mo7607mjFkc() {
        return this.f14318wA;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f14317mjFkc + ", enableFirelog=" + this.f14316AZxh + ", firelogEventType=" + this.f14318wA + "}";
    }

    @Override // p131o.AbstractC1630AU
    /* renamed from: wA */
    public final boolean mo7608wA() {
        return this.f14316AZxh;
    }
}
