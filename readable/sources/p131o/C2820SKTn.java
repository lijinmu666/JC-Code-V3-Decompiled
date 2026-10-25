package p131o;

import p131o.AbstractC2069H2;

/* renamed from: o.SKTn */
/* loaded from: classes.dex */
public final class C2820SKTn extends AbstractC2069H2 {

    /* renamed from: AZxh */
    public final AbstractC2069H2.AZxh f10535AZxh;

    /* renamed from: mjFkc */
    public final AbstractC2069H2.wA f10536mjFkc;

    /* renamed from: o.SKTn$AZxh */
    public static final class AZxh extends AbstractC2069H2.mjFkc {

        /* renamed from: AZxh */
        public AbstractC2069H2.AZxh f10537AZxh;

        /* renamed from: mjFkc */
        public AbstractC2069H2.wA f10538mjFkc;

        @Override // p131o.AbstractC2069H2.mjFkc
        /* renamed from: AZxh */
        public AbstractC2069H2.mjFkc mo8501AZxh(AbstractC2069H2.AZxh aZxh) {
            this.f10537AZxh = aZxh;
            return this;
        }

        @Override // p131o.AbstractC2069H2.mjFkc
        /* renamed from: mjFkc */
        public AbstractC2069H2 mo8502mjFkc() {
            return new C2820SKTn(this.f10538mjFkc, this.f10537AZxh);
        }

        @Override // p131o.AbstractC2069H2.mjFkc
        /* renamed from: wA */
        public AbstractC2069H2.mjFkc mo8503wA(AbstractC2069H2.wA wAVar) {
            this.f10538mjFkc = wAVar;
            return this;
        }
    }

    @Override // p131o.AbstractC2069H2
    /* renamed from: AZxh */
    public AbstractC2069H2.AZxh mo8495AZxh() {
        return this.f10535AZxh;
    }

    /* renamed from: equals */
    public boolean m10140equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2069H2)) {
            return false;
        }
        AbstractC2069H2 abstractC2069H2 = (AbstractC2069H2) obj;
        AbstractC2069H2.wA wAVar = this.f10536mjFkc;
        if (wAVar != null ? wAVar.equals(abstractC2069H2.mo8496wA()) : abstractC2069H2.mo8496wA() == null) {
            AbstractC2069H2.AZxh aZxh = this.f10535AZxh;
            if (aZxh == null) {
                if (abstractC2069H2.mo8495AZxh() == null) {
                    return true;
                }
            } else if (aZxh.equals(abstractC2069H2.mo8495AZxh())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC2069H2.wA wAVar = this.f10536mjFkc;
        int iHashCode = ((wAVar == null ? 0 : wAVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC2069H2.AZxh aZxh = this.f10535AZxh;
        return iHashCode ^ (aZxh != null ? aZxh.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f10536mjFkc + ", mobileSubtype=" + this.f10535AZxh + "}";
    }

    @Override // p131o.AbstractC2069H2
    /* renamed from: wA */
    public AbstractC2069H2.wA mo8496wA() {
        return this.f10536mjFkc;
    }

    public C2820SKTn(AbstractC2069H2.wA wAVar, AbstractC2069H2.AZxh aZxh) {
        this.f10536mjFkc = wAVar;
        this.f10535AZxh = aZxh;
    }
}
