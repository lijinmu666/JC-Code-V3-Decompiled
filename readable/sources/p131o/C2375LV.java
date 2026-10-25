package p131o;

/* renamed from: o.LV */
/* loaded from: classes.dex */
public final class C2375LV extends AbstractC2700QV {

    /* renamed from: AZxh */
    public final boolean f9448AZxh;

    /* renamed from: mjFkc */
    public final String f9449mjFkc;

    /* renamed from: wA */
    public final int f9450wA;

    public /* synthetic */ C2375LV(String str, boolean z, int i, AbstractC2313KV abstractC2313KV) {
        this.f9449mjFkc = str;
        this.f9448AZxh = z;
        this.f9450wA = i;
    }

    @Override // p131o.AbstractC2700QV
    /* renamed from: AZxh */
    public final String mo9366AZxh() {
        return this.f9449mjFkc;
    }

    /* renamed from: equals */
    public final boolean m9367equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2700QV) {
            AbstractC2700QV abstractC2700QV = (AbstractC2700QV) obj;
            if (this.f9449mjFkc.equals(abstractC2700QV.mo9366AZxh()) && this.f9448AZxh == abstractC2700QV.mo9369wA() && this.f9450wA == abstractC2700QV.mo9368mjFkc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f9449mjFkc.hashCode() ^ 1000003;
        return this.f9450wA ^ (((iHashCode * 1000003) ^ (true != this.f9448AZxh ? 1237 : 1231)) * 1000003);
    }

    @Override // p131o.AbstractC2700QV
    /* renamed from: mjFkc */
    public final int mo9368mjFkc() {
        return this.f9450wA;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f9449mjFkc + ", enableFirelog=" + this.f9448AZxh + ", firelogEventType=" + this.f9450wA + "}";
    }

    @Override // p131o.AbstractC2700QV
    /* renamed from: wA */
    public final boolean mo9369wA() {
        return this.f9448AZxh;
    }
}
