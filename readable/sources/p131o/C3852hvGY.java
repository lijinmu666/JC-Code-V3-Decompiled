package p131o;

import java.util.List;
import org.conscrypt.BuildConfig;
import p131o.AbstractC3921j1;

/* renamed from: o.hvGY */
/* loaded from: classes.dex */
public final class C3852hvGY extends AbstractC3921j1 {

    /* renamed from: AZxh */
    public final long f14085AZxh;

    /* renamed from: JHa */
    public final List f14086JHa;

    /* renamed from: KLFTb */
    public final String f14087KLFTb;

    /* renamed from: ZfxDd */
    public final Integer f14088ZfxDd;

    /* renamed from: mjFkc */
    public final long f14089mjFkc;

    /* renamed from: wA */
    public final AbstractC4893xbjHT f14090wA;

    /* renamed from: xJ */
    public final EnumC3473c4 f14091xJ;

    /* renamed from: o.hvGY$AZxh */
    public static final class AZxh extends AbstractC3921j1.mjFkc {

        /* renamed from: AZxh */
        public Long f14092AZxh;

        /* renamed from: JHa */
        public List f14093JHa;

        /* renamed from: KLFTb */
        public String f14094KLFTb;

        /* renamed from: ZfxDd */
        public Integer f14095ZfxDd;

        /* renamed from: mjFkc */
        public Long f14096mjFkc;

        /* renamed from: wA */
        public AbstractC4893xbjHT f14097wA;

        /* renamed from: xJ */
        public EnumC3473c4 f14098xJ;

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: AZxh */
        public AbstractC3921j1.mjFkc mo12252AZxh(AbstractC4893xbjHT abstractC4893xbjHT) {
            this.f14097wA = abstractC4893xbjHT;
            return this;
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: JHa */
        public AbstractC3921j1.mjFkc mo12253JHa(EnumC3473c4 enumC3473c4) {
            this.f14098xJ = enumC3473c4;
            return this;
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: KLFTb */
        public AbstractC3921j1.mjFkc mo12254KLFTb(String str) {
            this.f14094KLFTb = str;
            return this;
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC3921j1.mjFkc mo12255ZfxDd(Integer num) {
            this.f14095ZfxDd = num;
            return this;
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: lgHUyS */
        public AbstractC3921j1.mjFkc mo12256lgHUyS(long j) {
            this.f14092AZxh = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: mjFkc */
        public AbstractC3921j1 mo12257mjFkc() {
            Long l = this.f14096mjFkc;
            String str = BuildConfig.f24315FLAVOR;
            if (l == null) {
                str = BuildConfig.f24315FLAVOR + " requestTimeMs";
            }
            if (this.f14092AZxh == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new C3852hvGY(this.f14096mjFkc.longValue(), this.f14092AZxh.longValue(), this.f14097wA, this.f14095ZfxDd, this.f14094KLFTb, this.f14093JHa, this.f14098xJ);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: wA */
        public AbstractC3921j1.mjFkc mo12258wA(List list) {
            this.f14093JHa = list;
            return this;
        }

        @Override // p131o.AbstractC3921j1.mjFkc
        /* renamed from: xJ */
        public AbstractC3921j1.mjFkc mo12259xJ(long j) {
            this.f14096mjFkc = Long.valueOf(j);
            return this;
        }
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: AZxh */
    public AbstractC4893xbjHT mo12244AZxh() {
        return this.f14090wA;
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: JHa */
    public EnumC3473c4 mo12245JHa() {
        return this.f14091xJ;
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: KLFTb */
    public String mo12246KLFTb() {
        return this.f14087KLFTb;
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: ZfxDd */
    public Integer mo12247ZfxDd() {
        return this.f14088ZfxDd;
    }

    /* renamed from: equals */
    public boolean m12248equals(Object obj) {
        AbstractC4893xbjHT abstractC4893xbjHT;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3921j1)) {
            return false;
        }
        AbstractC3921j1 abstractC3921j1 = (AbstractC3921j1) obj;
        if (this.f14089mjFkc == abstractC3921j1.mo12251xJ() && this.f14085AZxh == abstractC3921j1.mo12249lgHUyS() && ((abstractC4893xbjHT = this.f14090wA) != null ? abstractC4893xbjHT.equals(abstractC3921j1.mo12244AZxh()) : abstractC3921j1.mo12244AZxh() == null) && ((num = this.f14088ZfxDd) != null ? num.equals(abstractC3921j1.mo12247ZfxDd()) : abstractC3921j1.mo12247ZfxDd() == null) && ((str = this.f14087KLFTb) != null ? str.equals(abstractC3921j1.mo12246KLFTb()) : abstractC3921j1.mo12246KLFTb() == null) && ((list = this.f14086JHa) != null ? list.equals(abstractC3921j1.mo12250wA()) : abstractC3921j1.mo12250wA() == null)) {
            EnumC3473c4 enumC3473c4 = this.f14091xJ;
            if (enumC3473c4 == null) {
                if (abstractC3921j1.mo12245JHa() == null) {
                    return true;
                }
            } else if (enumC3473c4.equals(abstractC3921j1.mo12245JHa())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f14089mjFkc;
        long j2 = this.f14085AZxh;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        AbstractC4893xbjHT abstractC4893xbjHT = this.f14090wA;
        int iHashCode = (i ^ (abstractC4893xbjHT == null ? 0 : abstractC4893xbjHT.hashCode())) * 1000003;
        Integer num = this.f14088ZfxDd;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f14087KLFTb;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f14086JHa;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        EnumC3473c4 enumC3473c4 = this.f14091xJ;
        return iHashCode4 ^ (enumC3473c4 != null ? enumC3473c4.hashCode() : 0);
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: lgHUyS */
    public long mo12249lgHUyS() {
        return this.f14085AZxh;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f14089mjFkc + ", requestUptimeMs=" + this.f14085AZxh + ", clientInfo=" + this.f14090wA + ", logSource=" + this.f14088ZfxDd + ", logSourceName=" + this.f14087KLFTb + ", logEvents=" + this.f14086JHa + ", qosTier=" + this.f14091xJ + "}";
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: wA */
    public List mo12250wA() {
        return this.f14086JHa;
    }

    @Override // p131o.AbstractC3921j1
    /* renamed from: xJ */
    public long mo12251xJ() {
        return this.f14089mjFkc;
    }

    public C3852hvGY(long j, long j2, AbstractC4893xbjHT abstractC4893xbjHT, Integer num, String str, List list, EnumC3473c4 enumC3473c4) {
        this.f14089mjFkc = j;
        this.f14085AZxh = j2;
        this.f14090wA = abstractC4893xbjHT;
        this.f14088ZfxDd = num;
        this.f14087KLFTb = str;
        this.f14086JHa = list;
        this.f14091xJ = enumC3473c4;
    }
}
