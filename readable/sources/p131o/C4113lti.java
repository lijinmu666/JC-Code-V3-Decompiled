package p131o;

import java.util.List;

/* renamed from: o.lti */
/* loaded from: classes.dex */
public final class C4113lti extends AbstractC2512NV {

    /* renamed from: mjFkc */
    public final List f14838mjFkc;

    public C4113lti(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f14838mjFkc = list;
    }

    /* renamed from: equals */
    public boolean m12716equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2512NV) {
            return this.f14838mjFkc.equals(((AbstractC2512NV) obj).mo9685wA());
        }
        return false;
    }

    public int hashCode() {
        return this.f14838mjFkc.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f14838mjFkc + "}";
    }

    @Override // p131o.AbstractC2512NV
    /* renamed from: wA */
    public List mo9685wA() {
        return this.f14838mjFkc;
    }
}
