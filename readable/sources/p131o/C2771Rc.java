package p131o;

/* renamed from: o.Rc */
/* loaded from: classes.dex */
public final class C2771Rc extends AbstractC3992k1 {

    /* renamed from: mjFkc */
    public final long f10438mjFkc;

    public C2771Rc(long j) {
        this.f10438mjFkc = j;
    }

    /* renamed from: equals */
    public boolean m10084equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AbstractC3992k1) && this.f10438mjFkc == ((AbstractC3992k1) obj).mo10085wA();
    }

    public int hashCode() {
        long j = this.f10438mjFkc;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f10438mjFkc + "}";
    }

    @Override // p131o.AbstractC3992k1
    /* renamed from: wA */
    public long mo10085wA() {
        return this.f10438mjFkc;
    }
}
