package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* renamed from: o.AQ */
/* loaded from: classes.dex */
public final class C1626AQ {

    /* renamed from: ETF */
    public static AbstractC4618tS f7358ETF;

    /* renamed from: VA */
    public static final AbstractC1963FT f7359VA = AbstractC1963FT.m8294wA("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: AZxh */
    public final String f7360AZxh;

    /* renamed from: JHa */
    public final AbstractC1670B7 f7362JHa;

    /* renamed from: KLFTb */
    public final AbstractC1670B7 f7363KLFTb;

    /* renamed from: ZfxDd */
    public final C2483N6 f7364ZfxDd;

    /* renamed from: lgHUyS */
    public final int f7365lgHUyS;

    /* renamed from: mjFkc */
    public final String f7366mjFkc;

    /* renamed from: wA */
    public final InterfaceC4085lQ f7368wA;

    /* renamed from: xJ */
    public final String f7369xJ;

    /* renamed from: qdMbNW */
    public final Map f7367qdMbNW = new HashMap();

    /* renamed from: Dt */
    public final Map f7361Dt = new HashMap();

    public C1626AQ(Context context, final C2483N6 c2483n6, InterfaceC4085lQ interfaceC4085lQ, String str) {
        this.f7366mjFkc = context.getPackageName();
        this.f7360AZxh = AbstractC3199XyP.m11004mjFkc(context);
        this.f7364ZfxDd = c2483n6;
        this.f7368wA = interfaceC4085lQ;
        C3364aR.m11318mjFkc();
        this.f7369xJ = str;
        this.f7363KLFTb = C4521s1.m13442mjFkc().m13443AZxh(new Callable() { // from class: o.uQ
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f16854mjFkc.m7603mjFkc();
            }
        });
        C4521s1 c4521s1M13442mjFkc = C4521s1.m13442mjFkc();
        c2483n6.getClass();
        this.f7362JHa = c4521s1M13442mjFkc.m13443AZxh(new Callable() { // from class: o.wQ
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c2483n6.m9587mjFkc();
            }
        });
        AbstractC1963FT abstractC1963FT = f7359VA;
        this.f7365lgHUyS = abstractC1963FT.containsKey(str) ? DynamiteModule.m2393AZxh(context, (String) abstractC1963FT.get(str)) : -1;
    }

    /* renamed from: ZfxDd */
    public static synchronized AbstractC4618tS m7601ZfxDd() {
        try {
            AbstractC4618tS abstractC4618tS = f7358ETF;
            if (abstractC4618tS != null) {
                return abstractC4618tS;
            }
            C3663f1 c3663f1M8224mjFkc = AbstractC1921Es.m8224mjFkc(Resources.getSystem().getConfiguration());
            C3228YP c3228yp = new C3228YP();
            for (int i = 0; i < c3663f1M8224mjFkc.m11882wA(); i++) {
                c3228yp.m11107wA(AbstractC3199XyP.m11003AZxh(c3663f1M8224mjFkc.m11879AZxh(i)));
            }
            AbstractC4618tS abstractC4618tSM11106ZfxDd = c3228yp.m11106ZfxDd();
            f7358ETF = abstractC4618tSM11106ZfxDd;
            return abstractC4618tSM11106ZfxDd;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: AZxh */
    public final /* synthetic */ void m7602AZxh(InterfaceC3949jQ interfaceC3949jQ, EnumC4275oM enumC4275oM, String str) {
        interfaceC3949jQ.mo7831ZfxDd(enumC4275oM);
        String strMo7832mjFkc = interfaceC3949jQ.mo7832mjFkc();
        C2232JO c2232jo = new C2232JO();
        c2232jo.m8938AZxh(this.f7366mjFkc);
        c2232jo.m8948wA(this.f7360AZxh);
        c2232jo.m8946lgHUyS(m7601ZfxDd());
        c2232jo.m8949xJ(Boolean.TRUE);
        c2232jo.m8944VA(strMo7832mjFkc);
        c2232jo.m8939Dt(str);
        c2232jo.m8947qdMbNW(this.f7362JHa.mo7669qdMbNW() ? (String) this.f7362JHa.mo7664JHa() : this.f7364ZfxDd.m9587mjFkc());
        c2232jo.m8945ZfxDd(10);
        c2232jo.m8940ETF(Integer.valueOf(this.f7365lgHUyS));
        interfaceC3949jQ.mo7830AZxh(c2232jo);
        this.f7368wA.mo9507mjFkc(interfaceC3949jQ);
    }

    /* renamed from: mjFkc */
    public final /* synthetic */ String m7603mjFkc() {
        return C2733R0.m10035mjFkc().m10036AZxh(this.f7369xJ);
    }

    /* renamed from: wA */
    public final void m7604wA(C2960UQ c2960uq, final EnumC4275oM enumC4275oM) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7367qdMbNW.get(enumC4275oM) != null && jElapsedRealtime - ((Long) this.f7367qdMbNW.get(enumC4275oM)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.f7367qdMbNW.put(enumC4275oM, Long.valueOf(jElapsedRealtime));
        int i = c2960uq.f10840mjFkc;
        int i2 = c2960uq.f10836AZxh;
        int i3 = c2960uq.f10841wA;
        int i4 = c2960uq.f10839ZfxDd;
        int i5 = c2960uq.f10838KLFTb;
        long j = c2960uq.f10837JHa;
        int i6 = c2960uq.f10842xJ;
        C3224YL c3224yl = new C3224YL();
        c3224yl.m11102ZfxDd(i != -1 ? i != 35 ? i != 842094169 ? i != 16 ? i != 17 ? EnumC2563OL.UNKNOWN_FORMAT : EnumC2563OL.NV21 : EnumC2563OL.NV16 : EnumC2563OL.YV12 : EnumC2563OL.YUV_420_888 : EnumC2563OL.BITMAP);
        c3224yl.m11100JHa(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? EnumC3359aM.ANDROID_MEDIA_IMAGE : EnumC3359aM.FILEPATH : EnumC3359aM.BYTEBUFFER : EnumC3359aM.BYTEARRAY : EnumC3359aM.BITMAP);
        c3224yl.m11104wA(Integer.valueOf(i3));
        c3224yl.m11101KLFTb(Integer.valueOf(i4));
        c3224yl.m11105xJ(Integer.valueOf(i5));
        c3224yl.m11098AZxh(Long.valueOf(j));
        c3224yl.m11103lgHUyS(Integer.valueOf(i6));
        C3622eM c3622eMM11099Dt = c3224yl.m11099Dt();
        C4409qM c4409qM = new C4409qM();
        c4409qM.m13207ZfxDd(c3622eMM11099Dt);
        final InterfaceC3949jQ interfaceC3949jQM7829KLFTb = C1758CQ.m7829KLFTb(c4409qM);
        final String strM10036AZxh = this.f7363KLFTb.mo7669qdMbNW() ? (String) this.f7363KLFTb.mo7664JHa() : C2733R0.m10035mjFkc().m10036AZxh(this.f7369xJ);
        C4521s1.m13441ZfxDd().execute(new Runnable() { // from class: o.yQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f17513mjFkc.m7602AZxh(interfaceC3949jQM7829KLFTb, enumC4275oM, strM10036AZxh);
            }
        });
    }
}
