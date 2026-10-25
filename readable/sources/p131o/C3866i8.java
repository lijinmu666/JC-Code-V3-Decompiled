package p131o;

import android.os.SystemClock;
import java.util.concurrent.Executor;

/* renamed from: o.i8 */
/* loaded from: classes.dex */
public class C3866i8 extends AbstractC4455r1 {

    /* renamed from: Dt */
    public static final C2134I f14124Dt = C2134I.m8634AZxh();

    /* renamed from: lgHUyS */
    public static final C2010G7 f14125lgHUyS = new C2010G7();

    /* renamed from: qdMbNW */
    public static boolean f14126qdMbNW = true;

    /* renamed from: JHa */
    public final C3828hW f14127JHa;

    /* renamed from: KLFTb */
    public final C3697fW f14128KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC3561dQ f14129ZfxDd;

    /* renamed from: xJ */
    public final InterfaceC3735g8 f14130xJ;

    public C3866i8(C3697fW c3697fW, InterfaceC3561dQ interfaceC3561dQ, InterfaceC3735g8 interfaceC3735g8) {
        super((interfaceC3735g8.mo11891lgHUyS() == 8 || interfaceC3735g8.mo11891lgHUyS() == 7) ? new C2010G7() : f14125lgHUyS);
        this.f14128KLFTb = c3697fW;
        this.f14129ZfxDd = interfaceC3561dQ;
        this.f14127JHa = C3828hW.m12223mjFkc(C3922j2.m12339wA().m12340AZxh());
        this.f14130xJ = interfaceC3735g8;
    }

    @Override // p131o.AbstractC4189n2
    /* renamed from: AZxh */
    public final synchronized void mo12280AZxh() {
        this.f14129ZfxDd.mo8424zzb();
    }

    /* renamed from: Dt */
    public final /* synthetic */ InterfaceC2443MV m12281Dt(long j, EnumC4087lS enumC4087lS, C2605P c2605p) {
        C4153mU c4153mU = new C4153mU();
        C3230YR c3230yr = new C3230YR();
        c3230yr.m11119wA(Long.valueOf(j));
        c3230yr.m11117ZfxDd(enumC4087lS);
        c3230yr.m11116KLFTb(Boolean.valueOf(f14126qdMbNW));
        Boolean bool = Boolean.TRUE;
        c3230yr.m11118mjFkc(bool);
        c3230yr.m11114AZxh(bool);
        c4153mU.m12770ZfxDd(c3230yr.m11115JHa());
        C2134I c2134i = f14124Dt;
        int iM8638wA = c2134i.m8638wA(c2605p);
        int iM8636ZfxDd = c2134i.m8636ZfxDd(c2605p);
        C2760RR c2760rr = new C2760RR();
        c2760rr.m10066mjFkc(iM8638wA != -1 ? iM8638wA != 35 ? iM8638wA != 842094169 ? iM8638wA != 16 ? iM8638wA != 17 ? EnumC2828SR.UNKNOWN_FORMAT : EnumC2828SR.NV21 : EnumC2828SR.NV16 : EnumC2828SR.YV12 : EnumC2828SR.YUV_420_888 : EnumC2828SR.BITMAP);
        c2760rr.m10064AZxh(Integer.valueOf(iM8636ZfxDd));
        c4153mU.m12771wA(c2760rr.m10065ZfxDd());
        C4887xU c4887xU = new C4887xU();
        c4887xU.m13944mjFkc(AbstractC4188n1.m12838mjFkc(this.f14130xJ.mo11891lgHUyS()));
        c4153mU.m12769KLFTb(c4887xU.m13945wA());
        C4283oU c4283oUM12768JHa = c4153mU.m12768JHa();
        C4215nS c4215nS = new C4215nS();
        c4215nS.m12876KLFTb(this.f14130xJ.mo11887JHa() ? EnumC4020kS.TYPE_THICK : EnumC4020kS.TYPE_THIN);
        c4215nS.m12878lgHUyS(c4283oUM12768JHa);
        return C3892iW.m12299KLFTb(c4215nS);
    }

    /* renamed from: ETF */
    public final /* synthetic */ InterfaceC2443MV m12282ETF(C4938yH c4938yH, int i, C2099HR c2099hr) {
        C4215nS c4215nS = new C4215nS();
        c4215nS.m12876KLFTb(this.f14130xJ.mo11887JHa() ? EnumC4020kS.TYPE_THICK : EnumC4020kS.TYPE_THIN);
        C4471rH c4471rH = new C4471rH();
        c4471rH.m13370mjFkc(Integer.valueOf(i));
        c4471rH.m13371wA(c4938yH);
        c4471rH.m13368AZxh(c2099hr);
        c4215nS.m12877ZfxDd(c4471rH.m13369KLFTb());
        return C3892iW.m12299KLFTb(c4215nS);
    }

    /* renamed from: MiMN */
    public final void m12283MiMN(final EnumC4087lS enumC4087lS, long j, final C2605P c2605p) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.f14128KLFTb.m11952JHa(new InterfaceC3632eW() { // from class: o.cT
            @Override // p131o.InterfaceC3632eW
            /* renamed from: zza */
            public final InterfaceC2443MV mo10141zza() {
                return this.f13236mjFkc.m12281Dt(jElapsedRealtime, enumC4087lS, c2605p);
            }
        }, EnumC4151mS.ON_DEVICE_TEXT_DETECT);
        C4605tH c4605tH = new C4605tH();
        c4605tH.m13619mjFkc(enumC4087lS);
        c4605tH.m13617AZxh(Boolean.valueOf(f14126qdMbNW));
        C4887xU c4887xU = new C4887xU();
        c4887xU.m13944mjFkc(AbstractC4188n1.m12838mjFkc(this.f14130xJ.mo11891lgHUyS()));
        c4605tH.m13620wA(c4887xU.m13945wA());
        final C4938yH c4938yHM13618ZfxDd = c4605tH.m13618ZfxDd();
        final C2168IT c2168it = new C2168IT(this);
        final EnumC4151mS enumC4151mS = EnumC4151mS.AGGREGATED_ON_DEVICE_TEXT_DETECTION;
        Executor executorM13441ZfxDd = C4521s1.m13441ZfxDd();
        final C3697fW c3697fW = this.f14128KLFTb;
        executorM13441ZfxDd.execute(new Runnable() { // from class: o.dW
            @Override // java.lang.Runnable
            public final void run() {
                c3697fW.m11955lgHUyS(enumC4151mS, c4938yHM13618ZfxDd, jElapsedRealtime, c2168it);
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f14127JHa.m12225wA(this.f14130xJ.mo11895xJ(), enumC4087lS.mo10152zza(), jCurrentTimeMillis - jElapsedRealtime, jCurrentTimeMillis);
    }

    @Override // p131o.AbstractC4455r1
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public final synchronized C2936U7 mo12286qdMbNW(C2605P c2605p) {
        C2936U7 c2936u7Mo8422AZxh;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            c2936u7Mo8422AZxh = this.f14129ZfxDd.mo8422AZxh(c2605p);
            m12283MiMN(EnumC4087lS.NO_ERROR, jElapsedRealtime, c2605p);
            f14126qdMbNW = false;
        } catch (C3993k2 e) {
            m12283MiMN(e.m12462mjFkc() == 14 ? EnumC4087lS.MODEL_NOT_DOWNLOADED : EnumC4087lS.UNKNOWN_ERROR, jElapsedRealtime, c2605p);
            throw e;
        }
        return c2936u7Mo8422AZxh;
    }

    @Override // p131o.AbstractC4189n2
    /* renamed from: ZfxDd */
    public final synchronized void mo12285ZfxDd() {
        f14126qdMbNW = true;
        this.f14129ZfxDd.mo8423mjFkc();
    }
}
