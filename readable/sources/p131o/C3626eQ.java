package p131o;

import java.util.Set;
import org.conscrypt.BuildConfig;
import p131o.AbstractC4391q6;

/* renamed from: o.eQ */
/* loaded from: classes.dex */
public final class C3626eQ extends AbstractC4391q6.AZxh {

    /* renamed from: AZxh */
    public final long f13467AZxh;

    /* renamed from: mjFkc */
    public final long f13468mjFkc;

    /* renamed from: wA */
    public final Set f13469wA;

    /* renamed from: o.eQ$AZxh */
    public static final class AZxh extends AbstractC4391q6.AZxh.mjFkc {

        /* renamed from: AZxh */
        public Long f13470AZxh;

        /* renamed from: mjFkc */
        public Long f13471mjFkc;

        /* renamed from: wA */
        public Set f13472wA;

        @Override // p131o.AbstractC4391q6.AZxh.mjFkc
        /* renamed from: AZxh */
        public AbstractC4391q6.AZxh.mjFkc mo11841AZxh(long j) {
            this.f13471mjFkc = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC4391q6.AZxh.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC4391q6.AZxh.mjFkc mo11842ZfxDd(long j) {
            this.f13470AZxh = Long.valueOf(j);
            return this;
        }

        @Override // p131o.AbstractC4391q6.AZxh.mjFkc
        /* renamed from: mjFkc */
        public AbstractC4391q6.AZxh mo11843mjFkc() {
            Long l = this.f13471mjFkc;
            String str = BuildConfig.f24315FLAVOR;
            if (l == null) {
                str = BuildConfig.f24315FLAVOR + " delta";
            }
            if (this.f13470AZxh == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f13472wA == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C3626eQ(this.f13471mjFkc.longValue(), this.f13470AZxh.longValue(), this.f13472wA);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p131o.AbstractC4391q6.AZxh.mjFkc
        /* renamed from: wA */
        public AbstractC4391q6.AZxh.mjFkc mo11844wA(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f13472wA = set;
            return this;
        }
    }

    @Override // p131o.AbstractC4391q6.AZxh
    /* renamed from: AZxh */
    public long mo11837AZxh() {
        return this.f13468mjFkc;
    }

    @Override // p131o.AbstractC4391q6.AZxh
    /* renamed from: ZfxDd */
    public long mo11838ZfxDd() {
        return this.f13467AZxh;
    }

    /* renamed from: equals */
    public boolean m11839equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4391q6.AZxh)) {
            return false;
        }
        AbstractC4391q6.AZxh aZxh = (AbstractC4391q6.AZxh) obj;
        return this.f13468mjFkc == aZxh.mo11837AZxh() && this.f13467AZxh == aZxh.mo11838ZfxDd() && this.f13469wA.equals(aZxh.mo11840wA());
    }

    public int hashCode() {
        long j = this.f13468mjFkc;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f13467AZxh;
        return this.f13469wA.hashCode() ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f13468mjFkc + ", maxAllowedDelay=" + this.f13467AZxh + ", flags=" + this.f13469wA + "}";
    }

    @Override // p131o.AbstractC4391q6.AZxh
    /* renamed from: wA */
    public Set mo11840wA() {
        return this.f13469wA;
    }

    public C3626eQ(long j, long j2, Set set) {
        this.f13468mjFkc = j;
        this.f13467AZxh = j2;
        this.f13469wA = set;
    }
}
