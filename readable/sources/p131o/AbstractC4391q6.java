package p131o;

import android.app.job.JobInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p094kotlin.p119time.DurationKt;
import p131o.C3626eQ;

/* renamed from: o.q6 */
/* loaded from: classes.dex */
public abstract class AbstractC4391q6 {

    /* renamed from: o.q6$AZxh */
    public static abstract class AZxh {

        /* renamed from: o.q6$AZxh$mjFkc */
        public static abstract class mjFkc {
            /* renamed from: AZxh */
            public abstract mjFkc mo11841AZxh(long j);

            /* renamed from: ZfxDd */
            public abstract mjFkc mo11842ZfxDd(long j);

            /* renamed from: mjFkc */
            public abstract AZxh mo11843mjFkc();

            /* renamed from: wA */
            public abstract mjFkc mo11844wA(Set set);
        }

        /* renamed from: mjFkc */
        public static mjFkc m13176mjFkc() {
            return new C3626eQ.AZxh().mo11844wA(Collections.emptySet());
        }

        /* renamed from: AZxh */
        public abstract long mo11837AZxh();

        /* renamed from: ZfxDd */
        public abstract long mo11838ZfxDd();

        /* renamed from: wA */
        public abstract Set mo11840wA();
    }

    /* renamed from: o.q6$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public Map f16016AZxh = new HashMap();

        /* renamed from: mjFkc */
        public InterfaceC3350aDq f16017mjFkc;

        /* renamed from: AZxh */
        public AbstractC4391q6 m13177AZxh() {
            if (this.f16017mjFkc == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f16016AZxh.keySet().size() < EnumC2347L3.m9354values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f16016AZxh;
            this.f16016AZxh = new HashMap();
            return AbstractC4391q6.m13170ZfxDd(this.f16017mjFkc, map);
        }

        /* renamed from: mjFkc */
        public mjFkc m13178mjFkc(EnumC2347L3 enumC2347L3, AZxh aZxh) {
            this.f16016AZxh.put(enumC2347L3, aZxh);
            return this;
        }

        /* renamed from: wA */
        public mjFkc m13179wA(InterfaceC3350aDq interfaceC3350aDq) {
            this.f16017mjFkc = interfaceC3350aDq;
            return this;
        }
    }

    /* renamed from: o.q6$wA */
    public enum wA {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* renamed from: AZxh */
    public static mjFkc m13168AZxh() {
        return new mjFkc();
    }

    /* renamed from: JHa */
    public static AbstractC4391q6 m13169JHa(InterfaceC3350aDq interfaceC3350aDq) {
        return m13168AZxh().m13178mjFkc(EnumC2347L3.DEFAULT, AZxh.m13176mjFkc().mo11841AZxh(30000L).mo11842ZfxDd(DurationKt.MILLIS_IN_DAY).mo11843mjFkc()).m13178mjFkc(EnumC2347L3.HIGHEST, AZxh.m13176mjFkc().mo11841AZxh(1000L).mo11842ZfxDd(DurationKt.MILLIS_IN_DAY).mo11843mjFkc()).m13178mjFkc(EnumC2347L3.VERY_LOW, AZxh.m13176mjFkc().mo11841AZxh(DurationKt.MILLIS_IN_DAY).mo11842ZfxDd(DurationKt.MILLIS_IN_DAY).mo11844wA(m13171qdMbNW(wA.NETWORK_UNMETERED, wA.DEVICE_IDLE)).mo11843mjFkc()).m13179wA(interfaceC3350aDq).m13177AZxh();
    }

    /* renamed from: ZfxDd */
    public static AbstractC4391q6 m13170ZfxDd(InterfaceC3350aDq interfaceC3350aDq, Map map) {
        return new C3147XDdeP(interfaceC3350aDq, map);
    }

    /* renamed from: qdMbNW */
    public static Set m13171qdMbNW(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    /* renamed from: Dt */
    public final void m13172Dt(JobInfo.Builder builder, Set set) {
        if (set.contains(wA.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(wA.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(wA.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    /* renamed from: KLFTb */
    public abstract InterfaceC3350aDq mo10922KLFTb();

    /* renamed from: lgHUyS */
    public abstract Map mo10924lgHUyS();

    /* renamed from: mjFkc */
    public final long m13173mjFkc(int i, long j) {
        return (long) (Math.pow(3.0d, i - 1) * j * Math.max(1.0d, Math.log(10000.0d) / Math.log((j > 1 ? j : 2L) * r7)));
    }

    /* renamed from: wA */
    public JobInfo.Builder m13174wA(JobInfo.Builder builder, EnumC2347L3 enumC2347L3, long j, int i) {
        builder.setMinimumLatency(m13175xJ(enumC2347L3, j, i));
        m13172Dt(builder, ((AZxh) mo10924lgHUyS().get(enumC2347L3)).mo11840wA());
        return builder;
    }

    /* renamed from: xJ */
    public long m13175xJ(EnumC2347L3 enumC2347L3, long j, int i) {
        long jMo7979mjFkc = j - mo10922KLFTb().mo7979mjFkc();
        AZxh aZxh = (AZxh) mo10924lgHUyS().get(enumC2347L3);
        return Math.min(Math.max(m13173mjFkc(i, aZxh.mo11837AZxh()), jMo7979mjFkc), aZxh.mo11838ZfxDd());
    }
}
