package p131o;

/* renamed from: o.dl */
/* loaded from: classes.dex */
public final class C3583dl extends AbstractC2194Iu {

    /* renamed from: AZxh */
    public final AbstractC1790Cs f13391AZxh;

    /* renamed from: mjFkc */
    public final int f13392mjFkc;

    public C3583dl(int i, AbstractC1790Cs abstractC1790Cs) {
        this.f13392mjFkc = i;
        this.f13391AZxh = abstractC1790Cs;
    }

    @Override // p131o.AbstractC2194Iu
    /* renamed from: AZxh */
    public final AbstractC1790Cs mo8803AZxh() {
        return this.f13391AZxh;
    }

    /* renamed from: equals */
    public final boolean m11744equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2194Iu) {
            AbstractC2194Iu abstractC2194Iu = (AbstractC2194Iu) obj;
            if (this.f13392mjFkc == abstractC2194Iu.mo8805mjFkc() && this.f13391AZxh.mo7938equals(abstractC2194Iu.mo8803AZxh())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f13392mjFkc;
        return this.f13391AZxh.hashCode() ^ ((i ^ 1000003) * 1000003);
    }

    @Override // p131o.AbstractC2194Iu
    /* renamed from: mjFkc */
    public final int mo8805mjFkc() {
        return this.f13392mjFkc;
    }

    public final String toString() {
        return "VkpStatus{exceptionType=" + this.f13392mjFkc + ", remoteException=" + this.f13391AZxh.toString() + "}";
    }
}
