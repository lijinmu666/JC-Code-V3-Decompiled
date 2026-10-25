package p131o;

import java.util.Map;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2097HPA;

/* renamed from: o.gtr */
/* loaded from: classes.dex */
public final class C3788gtr extends AbstractC2097HPA {

    /* renamed from: AZxh */
    public final Integer f13855AZxh;

    /* renamed from: JHa */
    public final Map f13856JHa;

    /* renamed from: KLFTb */
    public final long f13857KLFTb;

    /* renamed from: ZfxDd */
    public final long f13858ZfxDd;

    /* renamed from: mjFkc */
    public final String f13859mjFkc;

    /* renamed from: wA */
    public final C3331ZxmHEb f13860wA;

    /* renamed from: o.gtr$AZxh */
    public static final class AZxh extends AbstractC2097HPA.mjFkc {

        /* renamed from: AZxh */
        public Integer f13861AZxh;

        /* renamed from: JHa */
        public Map f13862JHa;

        /* renamed from: KLFTb */
        public Long f13863KLFTb;

        /* renamed from: ZfxDd */
        public Long f13864ZfxDd;

        /* renamed from: mjFkc */
        public String f13865mjFkc;

        /* renamed from: wA */
        public C3331ZxmHEb f13866wA;

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: Dt */
        public AbstractC2097HPA.mjFkc mo8558Dt(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f13865mjFkc = str;
            return this;
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: ETF */
        public AbstractC2097HPA.mjFkc mo8559ETF(long j) {
            this.f13863KLFTb = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: JHa */
        public AbstractC2097HPA.mjFkc mo8560JHa(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f13862JHa = map;
            return this;
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: KLFTb */
        public Map mo8561KLFTb() {
            Map map = this.f13862JHa;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC2097HPA mo8562ZfxDd() {
            String str = this.f13865mjFkc;
            String str2 = BuildConfig.f24315FLAVOR;
            if (str == null) {
                str2 = BuildConfig.f24315FLAVOR + " transportName";
            }
            if (this.f13866wA == null) {
                str2 = str2 + " encodedPayload";
            }
            if (this.f13864ZfxDd == null) {
                str2 = str2 + " eventMillis";
            }
            if (this.f13863KLFTb == null) {
                str2 = str2 + " uptimeMillis";
            }
            if (this.f13862JHa == null) {
                str2 = str2 + " autoMetadata";
            }
            if (str2.isEmpty()) {
                return new C3788gtr(this.f13865mjFkc, this.f13861AZxh, this.f13866wA, this.f13864ZfxDd.longValue(), this.f13863KLFTb.longValue(), this.f13862JHa);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: lgHUyS */
        public AbstractC2097HPA.mjFkc mo8563lgHUyS(C3331ZxmHEb c3331ZxmHEb) {
            if (c3331ZxmHEb == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f13866wA = c3331ZxmHEb;
            return this;
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: qdMbNW */
        public AbstractC2097HPA.mjFkc mo8565qdMbNW(long j) {
            this.f13864ZfxDd = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC2097HPA.mjFkc
        /* renamed from: xJ */
        public AbstractC2097HPA.mjFkc mo8567xJ(Integer num) {
            this.f13861AZxh = num;
            return this;
        }
    }

    @Override // p131o.AbstractC2097HPA
    /* renamed from: Dt */
    public String mo8547Dt() {
        return this.f13859mjFkc;
    }

    @Override // p131o.AbstractC2097HPA
    /* renamed from: ETF */
    public long mo8548ETF() {
        return this.f13857KLFTb;
    }

    @Override // p131o.AbstractC2097HPA
    /* renamed from: JHa */
    public long mo8549JHa() {
        return this.f13858ZfxDd;
    }

    @Override // p131o.AbstractC2097HPA
    /* renamed from: KLFTb */
    public C3331ZxmHEb mo8550KLFTb() {
        return this.f13860wA;
    }

    @Override // p131o.AbstractC2097HPA
    /* renamed from: ZfxDd */
    public Integer mo8552ZfxDd() {
        return this.f13855AZxh;
    }

    /* renamed from: equals */
    public boolean m12113equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2097HPA)) {
            return false;
        }
        AbstractC2097HPA abstractC2097HPA = (AbstractC2097HPA) obj;
        return this.f13859mjFkc.equals(abstractC2097HPA.mo8547Dt()) && ((num = this.f13855AZxh) != null ? num.equals(abstractC2097HPA.mo8552ZfxDd()) : abstractC2097HPA.mo8552ZfxDd() == null) && this.f13860wA.m11234equals(abstractC2097HPA.mo8550KLFTb()) && this.f13858ZfxDd == abstractC2097HPA.mo8549JHa() && this.f13857KLFTb == abstractC2097HPA.mo8548ETF() && this.f13856JHa.equals(abstractC2097HPA.mo8555wA());
    }

    public int hashCode() {
        int iHashCode = (this.f13859mjFkc.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f13855AZxh;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f13860wA.hashCode()) * 1000003;
        long j = this.f13858ZfxDd;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f13857KLFTb;
        return this.f13856JHa.hashCode() ^ ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f13859mjFkc + ", code=" + this.f13855AZxh + ", encodedPayload=" + this.f13860wA + ", eventMillis=" + this.f13858ZfxDd + ", uptimeMillis=" + this.f13857KLFTb + ", autoMetadata=" + this.f13856JHa + "}";
    }

    @Override // p131o.AbstractC2097HPA
    /* renamed from: wA */
    public Map mo8555wA() {
        return this.f13856JHa;
    }

    public C3788gtr(String str, Integer num, C3331ZxmHEb c3331ZxmHEb, long j, long j2, Map map) {
        this.f13859mjFkc = str;
        this.f13855AZxh = num;
        this.f13860wA = c3331ZxmHEb;
        this.f13858ZfxDd = j;
        this.f13857KLFTb = j2;
        this.f13856JHa = map;
    }
}
