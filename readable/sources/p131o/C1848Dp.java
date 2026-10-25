package p131o;

import org.conscrypt.BuildConfig;
import p131o.AbstractC3264YxdwU;

/* renamed from: o.Dp */
/* loaded from: classes.dex */
public final class C1848Dp extends AbstractC3264YxdwU {

    /* renamed from: AZxh */
    public final long f7903AZxh;

    /* renamed from: JHa */
    public final int f7904JHa;

    /* renamed from: KLFTb */
    public final long f7905KLFTb;

    /* renamed from: ZfxDd */
    public final int f7906ZfxDd;

    /* renamed from: wA */
    public final int f7907wA;

    /* renamed from: o.Dp$AZxh */
    public static final class AZxh extends AbstractC3264YxdwU.mjFkc {

        /* renamed from: AZxh */
        public Integer f7908AZxh;

        /* renamed from: KLFTb */
        public Integer f7909KLFTb;

        /* renamed from: ZfxDd */
        public Long f7910ZfxDd;

        /* renamed from: mjFkc */
        public Long f7911mjFkc;

        /* renamed from: wA */
        public Integer f7912wA;

        @Override // p131o.AbstractC3264YxdwU.mjFkc
        /* renamed from: AZxh */
        public AbstractC3264YxdwU.mjFkc mo8053AZxh(int i) {
            this.f7912wA = Integer.valueOf(i);
            return this;
        }

        @Override // p131o.AbstractC3264YxdwU.mjFkc
        /* renamed from: JHa */
        public AbstractC3264YxdwU.mjFkc mo8054JHa(long j) {
            this.f7911mjFkc = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC3264YxdwU.mjFkc
        /* renamed from: KLFTb */
        public AbstractC3264YxdwU.mjFkc mo8055KLFTb(int i) {
            this.f7909KLFTb = Integer.valueOf(i);
            return this;
        }

        @Override // p131o.AbstractC3264YxdwU.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC3264YxdwU.mjFkc mo8056ZfxDd(int i) {
            this.f7908AZxh = Integer.valueOf(i);
            return this;
        }

        @Override // p131o.AbstractC3264YxdwU.mjFkc
        /* renamed from: mjFkc */
        public AbstractC3264YxdwU mo8057mjFkc() {
            Long l = this.f7911mjFkc;
            String str = BuildConfig.f24315FLAVOR;
            if (l == null) {
                str = BuildConfig.f24315FLAVOR + " maxStorageSizeInBytes";
            }
            if (this.f7908AZxh == null) {
                str = str + " loadBatchSize";
            }
            if (this.f7912wA == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f7910ZfxDd == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f7909KLFTb == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C1848Dp(this.f7911mjFkc.longValue(), this.f7908AZxh.intValue(), this.f7912wA.intValue(), this.f7910ZfxDd.longValue(), this.f7909KLFTb.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p131o.AbstractC3264YxdwU.mjFkc
        /* renamed from: wA */
        public AbstractC3264YxdwU.mjFkc mo8058wA(long j) {
            this.f7910ZfxDd = Long.valueOf(j);
            return this;
        }
    }

    @Override // p131o.AbstractC3264YxdwU
    /* renamed from: AZxh */
    public int mo8047AZxh() {
        return this.f7906ZfxDd;
    }

    @Override // p131o.AbstractC3264YxdwU
    /* renamed from: JHa */
    public long mo8048JHa() {
        return this.f7903AZxh;
    }

    @Override // p131o.AbstractC3264YxdwU
    /* renamed from: KLFTb */
    public int mo8049KLFTb() {
        return this.f7904JHa;
    }

    @Override // p131o.AbstractC3264YxdwU
    /* renamed from: ZfxDd */
    public int mo8050ZfxDd() {
        return this.f7907wA;
    }

    /* renamed from: equals */
    public boolean m8051equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3264YxdwU)) {
            return false;
        }
        AbstractC3264YxdwU abstractC3264YxdwU = (AbstractC3264YxdwU) obj;
        return this.f7903AZxh == abstractC3264YxdwU.mo8048JHa() && this.f7907wA == abstractC3264YxdwU.mo8050ZfxDd() && this.f7906ZfxDd == abstractC3264YxdwU.mo8047AZxh() && this.f7905KLFTb == abstractC3264YxdwU.mo8052wA() && this.f7904JHa == abstractC3264YxdwU.mo8049KLFTb();
    }

    public int hashCode() {
        long j = this.f7903AZxh;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f7907wA) * 1000003) ^ this.f7906ZfxDd) * 1000003;
        long j2 = this.f7905KLFTb;
        return this.f7904JHa ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f7903AZxh + ", loadBatchSize=" + this.f7907wA + ", criticalSectionEnterTimeoutMs=" + this.f7906ZfxDd + ", eventCleanUpAge=" + this.f7905KLFTb + ", maxBlobByteSizePerRow=" + this.f7904JHa + "}";
    }

    @Override // p131o.AbstractC3264YxdwU
    /* renamed from: wA */
    public long mo8052wA() {
        return this.f7905KLFTb;
    }

    public C1848Dp(long j, int i, int i2, long j2, int i3) {
        this.f7903AZxh = j;
        this.f7907wA = i;
        this.f7906ZfxDd = i2;
        this.f7905KLFTb = j2;
        this.f7904JHa = i3;
    }
}
