package p131o;

import p131o.AbstractC4893xbjHT;

/* renamed from: o.giT */
/* loaded from: classes.dex */
public final class C3774giT extends AbstractC4893xbjHT {

    /* renamed from: AZxh */
    public final AbstractC3051Vnb f13757AZxh;

    /* renamed from: mjFkc */
    public final AbstractC4893xbjHT.AZxh f13758mjFkc;

    /* renamed from: o.giT$AZxh */
    public static final class AZxh extends AbstractC4893xbjHT.mjFkc {

        /* renamed from: AZxh */
        public AbstractC3051Vnb f13759AZxh;

        /* renamed from: mjFkc */
        public AbstractC4893xbjHT.AZxh f13760mjFkc;

        @Override // p131o.AbstractC4893xbjHT.mjFkc
        /* renamed from: AZxh */
        public AbstractC4893xbjHT.mjFkc mo12020AZxh(AbstractC3051Vnb abstractC3051Vnb) {
            this.f13759AZxh = abstractC3051Vnb;
            return this;
        }

        @Override // p131o.AbstractC4893xbjHT.mjFkc
        /* renamed from: mjFkc */
        public AbstractC4893xbjHT mo12021mjFkc() {
            return new C3774giT(this.f13760mjFkc, this.f13759AZxh);
        }

        @Override // p131o.AbstractC4893xbjHT.mjFkc
        /* renamed from: wA */
        public AbstractC4893xbjHT.mjFkc mo12022wA(AbstractC4893xbjHT.AZxh aZxh) {
            this.f13760mjFkc = aZxh;
            return this;
        }
    }

    @Override // p131o.AbstractC4893xbjHT
    /* renamed from: AZxh */
    public AbstractC3051Vnb mo12017AZxh() {
        return this.f13757AZxh;
    }

    /* renamed from: equals */
    public boolean m12018equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4893xbjHT)) {
            return false;
        }
        AbstractC4893xbjHT abstractC4893xbjHT = (AbstractC4893xbjHT) obj;
        AbstractC4893xbjHT.AZxh aZxh = this.f13758mjFkc;
        if (aZxh != null ? aZxh.equals(abstractC4893xbjHT.mo12019wA()) : abstractC4893xbjHT.mo12019wA() == null) {
            AbstractC3051Vnb abstractC3051Vnb = this.f13757AZxh;
            if (abstractC3051Vnb == null) {
                if (abstractC4893xbjHT.mo12017AZxh() == null) {
                    return true;
                }
            } else if (abstractC3051Vnb.equals(abstractC4893xbjHT.mo12017AZxh())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC4893xbjHT.AZxh aZxh = this.f13758mjFkc;
        int iHashCode = ((aZxh == null ? 0 : aZxh.hashCode()) ^ 1000003) * 1000003;
        AbstractC3051Vnb abstractC3051Vnb = this.f13757AZxh;
        return iHashCode ^ (abstractC3051Vnb != null ? abstractC3051Vnb.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f13758mjFkc + ", androidClientInfo=" + this.f13757AZxh + "}";
    }

    @Override // p131o.AbstractC4893xbjHT
    /* renamed from: wA */
    public AbstractC4893xbjHT.AZxh mo12019wA() {
        return this.f13758mjFkc;
    }

    public C3774giT(AbstractC4893xbjHT.AZxh aZxh, AbstractC3051Vnb abstractC3051Vnb) {
        this.f13758mjFkc = aZxh;
        this.f13757AZxh = abstractC3051Vnb;
    }
}
