package p131o;

import android.os.SystemClock;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;

/* renamed from: o.yc */
/* loaded from: classes.dex */
public final class C4959yc implements InterfaceC3270Z2 {

    /* renamed from: AZxh */
    public final int f17536AZxh;

    /* renamed from: KLFTb */
    public final long f17537KLFTb;

    /* renamed from: ZfxDd */
    public final long f17538ZfxDd;

    /* renamed from: mjFkc */
    public final C3795h f17539mjFkc;

    /* renamed from: wA */
    public final C2245JYn f17540wA;

    public C4959yc(C3795h c3795h, int i, C2245JYn c2245JYn, long j, long j2, String str, String str2) {
        this.f17539mjFkc = c3795h;
        this.f17536AZxh = i;
        this.f17540wA = c2245JYn;
        this.f17538ZfxDd = j;
        this.f17537KLFTb = j2;
    }

    /* renamed from: AZxh */
    public static C4959yc m14039AZxh(C3795h c3795h, int i, C2245JYn c2245JYn) {
        boolean zM8104ZfxDd;
        if (!c3795h.m12153ZfxDd()) {
            return null;
        }
        C1866E5 c1866e5M7971mjFkc = C1804D5.m7970AZxh().m7971mjFkc();
        if (c1866e5M7971mjFkc == null) {
            zM8104ZfxDd = true;
        } else {
            if (!c1866e5M7971mjFkc.m8106wA()) {
                return null;
            }
            zM8104ZfxDd = c1866e5M7971mjFkc.m8104ZfxDd();
            C4027kc c4027kcM12151Pq = c3795h.m12151Pq(c2245JYn);
            if (c4027kcM12151Pq != null) {
                if (!(c4027kcM12151Pq.m12570Ucbh() instanceof AbstractC2308KRckQg)) {
                    return null;
                }
                AbstractC2308KRckQg abstractC2308KRckQg = (AbstractC2308KRckQg) c4027kcM12151Pq.m12570Ucbh();
                if (abstractC2308KRckQg.m9234xrEuO() && !abstractC2308KRckQg.m9225lgHUyS()) {
                    C1674BABY c1674babyM14040wA = m14040wA(c4027kcM12151Pq, abstractC2308KRckQg, i);
                    if (c1674babyM14040wA == null) {
                        return null;
                    }
                    c4027kcM12151Pq.m12567Ne();
                    zM8104ZfxDd = c1674babyM14040wA.m7681JHa();
                }
            }
        }
        return new C4959yc(c3795h, i, c2245JYn, zM8104ZfxDd ? System.currentTimeMillis() : 0L, zM8104ZfxDd ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    /* renamed from: wA */
    public static C1674BABY m14040wA(C4027kc c4027kc, AbstractC2308KRckQg abstractC2308KRckQg, int i) {
        int[] iArrM7680AZxh;
        int[] iArrM7684wA;
        C1674BABY c1674babyM9210Ne = abstractC2308KRckQg.m9210Ne();
        if (c1674babyM9210Ne == null || !c1674babyM9210Ne.m7682ZfxDd() || ((iArrM7680AZxh = c1674babyM9210Ne.m7680AZxh()) != null ? !AbstractC2371LREOK.m9365mjFkc(iArrM7680AZxh, i) : !((iArrM7684wA = c1674babyM9210Ne.m7684wA()) == null || !AbstractC2371LREOK.m9365mjFkc(iArrM7684wA, i))) || c4027kc.m12574diqgf() >= c1674babyM9210Ne.m7683mjFkc()) {
            return null;
        }
        return c1674babyM9210Ne;
    }

    @Override // p131o.InterfaceC3270Z2
    /* renamed from: mjFkc */
    public final void mo10155mjFkc(AbstractC1670B7 abstractC1670B7) {
        C4027kc c4027kcM12151Pq;
        int iM8103JHa;
        int i;
        int i2;
        int iM11826mjFkc;
        long j;
        long j2;
        int iElapsedRealtime;
        if (this.f17539mjFkc.m12153ZfxDd()) {
            C1866E5 c1866e5M7971mjFkc = C1804D5.m7970AZxh().m7971mjFkc();
            if ((c1866e5M7971mjFkc == null || c1866e5M7971mjFkc.m8106wA()) && (c4027kcM12151Pq = this.f17539mjFkc.m12151Pq(this.f17540wA)) != null && (c4027kcM12151Pq.m12570Ucbh() instanceof AbstractC2308KRckQg)) {
                AbstractC2308KRckQg abstractC2308KRckQg = (AbstractC2308KRckQg) c4027kcM12151Pq.m12570Ucbh();
                int i3 = 0;
                boolean zM8104ZfxDd = this.f17538ZfxDd > 0;
                int iM9205HGpJ = abstractC2308KRckQg.m9205HGpJ();
                int iM2374AZxh = 100;
                if (c1866e5M7971mjFkc != null) {
                    zM8104ZfxDd &= c1866e5M7971mjFkc.m8104ZfxDd();
                    int iM8105mjFkc = c1866e5M7971mjFkc.m8105mjFkc();
                    int iM8102AZxh = c1866e5M7971mjFkc.m8102AZxh();
                    iM8103JHa = c1866e5M7971mjFkc.m8103JHa();
                    if (abstractC2308KRckQg.m9234xrEuO() && !abstractC2308KRckQg.m9225lgHUyS()) {
                        C1674BABY c1674babyM14040wA = m14040wA(c4027kcM12151Pq, abstractC2308KRckQg, this.f17536AZxh);
                        if (c1674babyM14040wA == null) {
                            return;
                        }
                        boolean z = c1674babyM14040wA.m7681JHa() && this.f17538ZfxDd > 0;
                        iM8102AZxh = c1674babyM14040wA.m7683mjFkc();
                        zM8104ZfxDd = z;
                    }
                    i2 = iM8105mjFkc;
                    i = iM8102AZxh;
                } else {
                    iM8103JHa = 0;
                    i = 100;
                    i2 = 5000;
                }
                C3795h c3795h = this.f17539mjFkc;
                if (abstractC1670B7.mo7669qdMbNW()) {
                    iM11826mjFkc = 0;
                } else if (abstractC1670B7.mo7671xJ()) {
                    i3 = iM2374AZxh;
                    iM11826mjFkc = -1;
                } else {
                    Exception excMo7665KLFTb = abstractC1670B7.mo7665KLFTb();
                    if (excMo7665KLFTb instanceof C3121WrLQs) {
                        C0210Status c0210StatusM10844mjFkc = ((C3121WrLQs) excMo7665KLFTb).m10844mjFkc();
                        iM2374AZxh = c0210StatusM10844mjFkc.m2374AZxh();
                        C3613eEOGOh c3613eEOGOhM2378mjFkc = c0210StatusM10844mjFkc.m2378mjFkc();
                        if (c3613eEOGOhM2378mjFkc != null) {
                            iM11826mjFkc = c3613eEOGOhM2378mjFkc.m11826mjFkc();
                            i3 = iM2374AZxh;
                        }
                        i3 = iM2374AZxh;
                        iM11826mjFkc = -1;
                    } else {
                        i3 = 101;
                        iM11826mjFkc = -1;
                    }
                }
                if (zM8104ZfxDd) {
                    long j3 = this.f17538ZfxDd;
                    long j4 = this.f17537KLFTb;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j4);
                    j2 = jCurrentTimeMillis;
                    j = j3;
                } else {
                    j = 0;
                    j2 = 0;
                    iElapsedRealtime = -1;
                }
                c3795h.m12152VocHEe(new C3729g2(this.f17536AZxh, i3, iM11826mjFkc, j, j2, null, null, iM9205HGpJ, iElapsedRealtime), iM8103JHa, i2, i);
            }
        }
    }
}
