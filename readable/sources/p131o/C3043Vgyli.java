package p131o;

import p131o.AbstractC3197Xxz;

/* renamed from: o.Vgyli */
/* loaded from: classes.dex */
public final class C3043Vgyli extends AbstractC3197Xxz {

    /* renamed from: AZxh */
    public final long f11357AZxh;

    /* renamed from: mjFkc */
    public final AbstractC3197Xxz.mjFkc f11358mjFkc;

    public C3043Vgyli(AbstractC3197Xxz.mjFkc mjfkc, long j) {
        if (mjfkc == null) {
            throw new NullPointerException("Null status");
        }
        this.f11358mjFkc = mjfkc;
        this.f11357AZxh = j;
    }

    @Override // p131o.AbstractC3197Xxz
    /* renamed from: AZxh */
    public long mo10703AZxh() {
        return this.f11357AZxh;
    }

    /* renamed from: equals */
    public boolean m10704equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3197Xxz)) {
            return false;
        }
        AbstractC3197Xxz abstractC3197Xxz = (AbstractC3197Xxz) obj;
        return this.f11358mjFkc.equals(abstractC3197Xxz.mo10705wA()) && this.f11357AZxh == abstractC3197Xxz.mo10703AZxh();
    }

    public int hashCode() {
        int iHashCode = (this.f11358mjFkc.hashCode() ^ 1000003) * 1000003;
        long j = this.f11357AZxh;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }

    public String toString() {
        return "BackendResponse{status=" + this.f11358mjFkc + ", nextRequestWaitMillis=" + this.f11357AZxh + "}";
    }

    @Override // p131o.AbstractC3197Xxz
    /* renamed from: wA */
    public AbstractC3197Xxz.mjFkc mo10705wA() {
        return this.f11358mjFkc;
    }
}
