package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* renamed from: o.fW */
/* loaded from: classes.dex */
public final class C3697fW {

    /* renamed from: ETF */
    public static AbstractC2219JD f13600ETF;

    /* renamed from: VA */
    public static final AbstractC2492ND f13601VA = AbstractC2492ND.m9649wA("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: AZxh */
    public final String f13602AZxh;

    /* renamed from: JHa */
    public final AbstractC1670B7 f13604JHa;

    /* renamed from: KLFTb */
    public final AbstractC1670B7 f13605KLFTb;

    /* renamed from: ZfxDd */
    public final C2483N6 f13606ZfxDd;

    /* renamed from: lgHUyS */
    public final int f13607lgHUyS;

    /* renamed from: mjFkc */
    public final String f13608mjFkc;

    /* renamed from: wA */
    public final InterfaceC2574OV f13610wA;

    /* renamed from: xJ */
    public final String f13611xJ;

    /* renamed from: qdMbNW */
    public final Map f13609qdMbNW = new HashMap();

    /* renamed from: Dt */
    public final Map f13603Dt = new HashMap();

    public C3697fW(Context context, final C2483N6 c2483n6, InterfaceC2574OV interfaceC2574OV, String str) {
        this.f13608mjFkc = context.getPackageName();
        this.f13602AZxh = AbstractC3199XyP.m11004mjFkc(context);
        this.f13606ZfxDd = c2483n6;
        this.f13610wA = interfaceC2574OV;
        C4487rW.m13376mjFkc();
        this.f13611xJ = str;
        this.f13605KLFTb = C4521s1.m13442mjFkc().m13443AZxh(new Callable() { // from class: o.VV
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f11347mjFkc.m11949AZxh();
            }
        });
        C4521s1 c4521s1M13442mjFkc = C4521s1.m13442mjFkc();
        Objects.requireNonNull(c2483n6);
        this.f13604JHa = c4521s1M13442mjFkc.m13443AZxh(new Callable() { // from class: o.WV
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c2483n6.m9587mjFkc();
            }
        });
        AbstractC2492ND abstractC2492ND = f13601VA;
        this.f13607lgHUyS = abstractC2492ND.containsKey(str) ? DynamiteModule.m2393AZxh(context, (String) abstractC2492ND.get(str)) : -1;
    }

    /* renamed from: mjFkc */
    public static long m11947mjFkc(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    /* renamed from: qdMbNW */
    public static synchronized AbstractC2219JD m11948qdMbNW() {
        try {
            AbstractC2219JD abstractC2219JD = f13600ETF;
            if (abstractC2219JD != null) {
                return abstractC2219JD;
            }
            C3663f1 c3663f1M8224mjFkc = AbstractC1921Es.m8224mjFkc(Resources.getSystem().getConfiguration());
            C1812DD c1812dd = new C1812DD();
            for (int i = 0; i < c3663f1M8224mjFkc.m11882wA(); i++) {
                c1812dd.m7988mjFkc(AbstractC3199XyP.m11003AZxh(c3663f1M8224mjFkc.m11879AZxh(i)));
            }
            AbstractC2219JD abstractC2219JDM7987AZxh = c1812dd.m7987AZxh();
            f13600ETF = abstractC2219JDM7987AZxh;
            return abstractC2219JDM7987AZxh;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: AZxh */
    public final /* synthetic */ String m11949AZxh() {
        return C2733R0.m10035mjFkc().m10036AZxh(this.f13611xJ);
    }

    /* renamed from: Dt */
    public final String m11950Dt() {
        if (this.f13605KLFTb.mo7669qdMbNW()) {
            return (String) this.f13605KLFTb.mo7664JHa();
        }
        return C2733R0.m10035mjFkc().m10036AZxh(this.f13611xJ);
    }

    /* renamed from: ETF */
    public final boolean m11951ETF(EnumC4151mS enumC4151mS, long j, long j2) {
        return this.f13609qdMbNW.get(enumC4151mS) == null || j - ((Long) this.f13609qdMbNW.get(enumC4151mS)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    /* renamed from: JHa */
    public final void m11952JHa(InterfaceC3632eW interfaceC3632eW, EnumC4151mS enumC4151mS) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (m11951ETF(enumC4151mS, jElapsedRealtime, 30L)) {
            this.f13609qdMbNW.put(enumC4151mS, Long.valueOf(jElapsedRealtime));
            m11953KLFTb(interfaceC3632eW.mo10141zza(), enumC4151mS, m11950Dt());
        }
    }

    /* renamed from: KLFTb */
    public final void m11953KLFTb(final InterfaceC2443MV interfaceC2443MV, final EnumC4151mS enumC4151mS, final String str) {
        C4521s1.m13441ZfxDd().execute(new Runnable() { // from class: o.TV
            @Override // java.lang.Runnable
            public final void run() {
                this.f10702mjFkc.m11956wA(interfaceC2443MV, enumC4151mS, str);
            }
        });
    }

    /* renamed from: ZfxDd */
    public final void m11954ZfxDd(InterfaceC2443MV interfaceC2443MV, EnumC4151mS enumC4151mS) {
        m11953KLFTb(interfaceC2443MV, enumC4151mS, m11950Dt());
    }

    /* renamed from: lgHUyS */
    public final /* synthetic */ void m11955lgHUyS(final EnumC4151mS enumC4151mS, Object obj, long j, final C2168IT c2168it) {
        if (!this.f13603Dt.containsKey(enumC4151mS)) {
            this.f13603Dt.put(enumC4151mS, C4798wC.m13828qGY());
        }
        ((InterfaceC2880TD) this.f13603Dt.get(enumC4151mS)).mo7989AZxh(obj, Long.valueOf(j));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (m11951ETF(enumC4151mS, jElapsedRealtime, 30L)) {
            this.f13609qdMbNW.put(enumC4151mS, Long.valueOf(jElapsedRealtime));
            C4521s1.m13441ZfxDd().execute(new Runnable() { // from class: o.UV
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10849mjFkc.m11957xJ(enumC4151mS, c2168it);
                }
            });
        }
    }

    /* renamed from: wA */
    public final /* synthetic */ void m11956wA(InterfaceC2443MV interfaceC2443MV, EnumC4151mS enumC4151mS, String str) {
        interfaceC2443MV.mo9514ZfxDd(enumC4151mS);
        String strMo9516wA = interfaceC2443MV.mo9516wA();
        C3434bV c3434bV = new C3434bV();
        c3434bV.m11492AZxh(this.f13608mjFkc);
        c3434bV.m11502wA(this.f13602AZxh);
        c3434bV.m11500lgHUyS(m11948qdMbNW());
        c3434bV.m11503xJ(Boolean.TRUE);
        c3434bV.m11498VA(strMo9516wA);
        c3434bV.m11493Dt(str);
        c3434bV.m11501qdMbNW(this.f13604JHa.mo7669qdMbNW() ? (String) this.f13604JHa.mo7664JHa() : this.f13606ZfxDd.m9587mjFkc());
        c3434bV.m11499ZfxDd(10);
        c3434bV.m11494ETF(Integer.valueOf(this.f13607lgHUyS));
        interfaceC2443MV.mo9513AZxh(c3434bV);
        this.f13610wA.mo9900mjFkc(interfaceC2443MV);
    }

    /* renamed from: xJ */
    public final /* synthetic */ void m11957xJ(EnumC4151mS enumC4151mS, C2168IT c2168it) {
        InterfaceC2880TD interfaceC2880TD = (InterfaceC2880TD) this.f13603Dt.get(enumC4151mS);
        if (interfaceC2880TD != null) {
            for (Object obj : interfaceC2880TD.mo7990ZfxDd()) {
                ArrayList arrayList = new ArrayList(interfaceC2880TD.mo7779wA(obj));
                Collections.sort(arrayList);
                C1961FR c1961fr = new C1961FR();
                Iterator it = arrayList.iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += ((Long) it.next()).longValue();
                }
                c1961fr.m8291mjFkc(Long.valueOf(jLongValue / arrayList.size()));
                c1961fr.m8292wA(Long.valueOf(m11947mjFkc(arrayList, 100.0d)));
                c1961fr.m8288JHa(Long.valueOf(m11947mjFkc(arrayList, 75.0d)));
                c1961fr.m8290ZfxDd(Long.valueOf(m11947mjFkc(arrayList, 50.0d)));
                c1961fr.m8287AZxh(Long.valueOf(m11947mjFkc(arrayList, 25.0d)));
                c1961fr.m8289KLFTb(Long.valueOf(m11947mjFkc(arrayList, 0.0d)));
                m11953KLFTb(c2168it.m8747mjFkc(obj, arrayList.size(), c1961fr.m8293xJ()), enumC4151mS, m11950Dt());
            }
            this.f13603Dt.remove(enumC4151mS);
        }
    }
}
