package p131o;

import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;

/* renamed from: o.Jx */
/* loaded from: classes.dex */
public final class C2273Jx {

    /* renamed from: AZxh */
    public final int f9068AZxh;

    /* renamed from: mjFkc */
    public final Object f9069mjFkc;

    public C2273Jx(Object obj, int i) {
        this.f9069mjFkc = obj;
        this.f9068AZxh = i;
    }

    /* renamed from: equals */
    public final boolean m9069equals(Object obj) {
        if (!(obj instanceof C2273Jx)) {
            return false;
        }
        C2273Jx c2273Jx = (C2273Jx) obj;
        return this.f9069mjFkc == c2273Jx.f9069mjFkc && this.f9068AZxh == c2273Jx.f9068AZxh;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f9069mjFkc) * Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) + this.f9068AZxh;
    }
}
