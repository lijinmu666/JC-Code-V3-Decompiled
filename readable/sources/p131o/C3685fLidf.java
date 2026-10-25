package p131o;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p131o.AbstractC3859i1;

/* renamed from: o.fLidf */
/* loaded from: classes.dex */
public final class C3685fLidf extends AbstractC3859i1 {

    /* renamed from: AZxh */
    public final Integer f13562AZxh;

    /* renamed from: JHa */
    public final long f13563JHa;

    /* renamed from: KLFTb */
    public final String f13564KLFTb;

    /* renamed from: ZfxDd */
    public final byte[] f13565ZfxDd;

    /* renamed from: mjFkc */
    public final long f13566mjFkc;

    /* renamed from: wA */
    public final long f13567wA;

    /* renamed from: xJ */
    public final AbstractC2069H2 f13568xJ;

    /* renamed from: o.fLidf$AZxh */
    public static final class AZxh extends AbstractC3859i1.mjFkc {

        /* renamed from: AZxh */
        public Integer f13569AZxh;

        /* renamed from: JHa */
        public Long f13570JHa;

        /* renamed from: KLFTb */
        public String f13571KLFTb;

        /* renamed from: ZfxDd */
        public byte[] f13572ZfxDd;

        /* renamed from: mjFkc */
        public Long f13573mjFkc;

        /* renamed from: wA */
        public Long f13574wA;

        /* renamed from: xJ */
        public AbstractC2069H2 f13575xJ;

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: AZxh */
        public AbstractC3859i1.mjFkc mo11912AZxh(Integer num) {
            this.f13569AZxh = num;
            return this;
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: JHa */
        public AbstractC3859i1.mjFkc mo11913JHa(byte[] bArr) {
            this.f13572ZfxDd = bArr;
            return this;
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: KLFTb */
        public AbstractC3859i1.mjFkc mo11914KLFTb(AbstractC2069H2 abstractC2069H2) {
            this.f13575xJ = abstractC2069H2;
            return this;
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC3859i1.mjFkc mo11915ZfxDd(long j) {
            this.f13574wA = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: lgHUyS */
        public AbstractC3859i1.mjFkc mo11916lgHUyS(long j) {
            this.f13570JHa = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: mjFkc */
        public AbstractC3859i1 mo11917mjFkc() {
            Long l = this.f13573mjFkc;
            String str = BuildConfig.f24315FLAVOR;
            if (l == null) {
                str = BuildConfig.f24315FLAVOR + " eventTimeMs";
            }
            if (this.f13574wA == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f13570JHa == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new C3685fLidf(this.f13573mjFkc.longValue(), this.f13569AZxh, this.f13574wA.longValue(), this.f13572ZfxDd, this.f13571KLFTb, this.f13570JHa.longValue(), this.f13575xJ);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: wA */
        public AbstractC3859i1.mjFkc mo11918wA(long j) {
            this.f13573mjFkc = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC3859i1.mjFkc
        /* renamed from: xJ */
        public AbstractC3859i1.mjFkc mo11919xJ(String str) {
            this.f13571KLFTb = str;
            return this;
        }
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: AZxh */
    public Integer mo11904AZxh() {
        return this.f13562AZxh;
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: JHa */
    public byte[] mo11905JHa() {
        return this.f13565ZfxDd;
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: KLFTb */
    public AbstractC2069H2 mo11906KLFTb() {
        return this.f13568xJ;
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: ZfxDd */
    public long mo11907ZfxDd() {
        return this.f13567wA;
    }

    /* renamed from: equals */
    public boolean m11908equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3859i1)) {
            return false;
        }
        AbstractC3859i1 abstractC3859i1 = (AbstractC3859i1) obj;
        if (this.f13566mjFkc == abstractC3859i1.mo11910wA() && ((num = this.f13562AZxh) != null ? num.equals(abstractC3859i1.mo11904AZxh()) : abstractC3859i1.mo11904AZxh() == null) && this.f13567wA == abstractC3859i1.mo11907ZfxDd()) {
            if (Arrays.equals(this.f13565ZfxDd, abstractC3859i1 instanceof C3685fLidf ? ((C3685fLidf) abstractC3859i1).f13565ZfxDd : abstractC3859i1.mo11905JHa()) && ((str = this.f13564KLFTb) != null ? str.equals(abstractC3859i1.mo11911xJ()) : abstractC3859i1.mo11911xJ() == null) && this.f13563JHa == abstractC3859i1.mo11909lgHUyS()) {
                AbstractC2069H2 abstractC2069H2 = this.f13568xJ;
                if (abstractC2069H2 == null) {
                    if (abstractC3859i1.mo11906KLFTb() == null) {
                        return true;
                    }
                } else if (abstractC2069H2.equals(abstractC3859i1.mo11906KLFTb())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f13566mjFkc;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f13562AZxh;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f13567wA;
        int iHashCode2 = (((((i ^ iHashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f13565ZfxDd)) * 1000003;
        String str = this.f13564KLFTb;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f13563JHa;
        int i2 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        AbstractC2069H2 abstractC2069H2 = this.f13568xJ;
        return i2 ^ (abstractC2069H2 != null ? abstractC2069H2.hashCode() : 0);
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: lgHUyS */
    public long mo11909lgHUyS() {
        return this.f13563JHa;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f13566mjFkc + ", eventCode=" + this.f13562AZxh + ", eventUptimeMs=" + this.f13567wA + ", sourceExtension=" + Arrays.toString(this.f13565ZfxDd) + ", sourceExtensionJsonProto3=" + this.f13564KLFTb + ", timezoneOffsetSeconds=" + this.f13563JHa + ", networkConnectionInfo=" + this.f13568xJ + "}";
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: wA */
    public long mo11910wA() {
        return this.f13566mjFkc;
    }

    @Override // p131o.AbstractC3859i1
    /* renamed from: xJ */
    public String mo11911xJ() {
        return this.f13564KLFTb;
    }

    public C3685fLidf(long j, Integer num, long j2, byte[] bArr, String str, long j3, AbstractC2069H2 abstractC2069H2) {
        this.f13566mjFkc = j;
        this.f13562AZxh = num;
        this.f13567wA = j2;
        this.f13565ZfxDd = bArr;
        this.f13564KLFTb = str;
        this.f13563JHa = j3;
        this.f13568xJ = abstractC2069H2;
    }
}
