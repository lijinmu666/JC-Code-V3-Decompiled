package p131o;

/* renamed from: o.hQ */
/* loaded from: classes.dex */
public final class C3822hQ extends AbstractC4348pQ {

    /* renamed from: AZxh */
    public final boolean f14020AZxh;

    /* renamed from: mjFkc */
    public final String f14021mjFkc;

    /* renamed from: wA */
    public final int f14022wA;

    public /* synthetic */ C3822hQ(String str, boolean z, int i, AbstractC3026VP abstractC3026VP) {
        this.f14021mjFkc = str;
        this.f14020AZxh = z;
        this.f14022wA = i;
    }

    @Override // p131o.AbstractC4348pQ
    /* renamed from: AZxh */
    public final String mo12218AZxh() {
        return this.f14021mjFkc;
    }

    /* renamed from: equals */
    public final boolean m12219equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4348pQ) {
            AbstractC4348pQ abstractC4348pQ = (AbstractC4348pQ) obj;
            if (this.f14021mjFkc.equals(abstractC4348pQ.mo12218AZxh()) && this.f14020AZxh == abstractC4348pQ.mo12221wA() && this.f14022wA == abstractC4348pQ.mo12220mjFkc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f14021mjFkc.hashCode() ^ 1000003;
        return this.f14022wA ^ (((iHashCode * 1000003) ^ (true != this.f14020AZxh ? 1237 : 1231)) * 1000003);
    }

    @Override // p131o.AbstractC4348pQ
    /* renamed from: mjFkc */
    public final int mo12220mjFkc() {
        return this.f14022wA;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f14021mjFkc + ", enableFirelog=" + this.f14020AZxh + ", firelogEventType=" + this.f14022wA + "}";
    }

    @Override // p131o.AbstractC4348pQ
    /* renamed from: wA */
    public final boolean mo12221wA() {
        return this.f14020AZxh;
    }
}
