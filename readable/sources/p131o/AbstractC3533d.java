package p131o;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.p038google.p039android.p042gms.p046common.p047api.GoogleApiActivity;
import java.util.Collections;
import p131o.C3389aqHPIZ;
import p131o.C5011zPp;

/* renamed from: o.d */
/* loaded from: classes.dex */
public abstract class AbstractC3533d {

    /* renamed from: AZxh */
    public final String f13278AZxh;

    /* renamed from: Dt */
    public final C3795h f13279Dt;

    /* renamed from: JHa */
    public final Looper f13280JHa;

    /* renamed from: KLFTb */
    public final C2245JYn f13281KLFTb;

    /* renamed from: ZfxDd */
    public final C3389aqHPIZ.ZfxDd f13282ZfxDd;

    /* renamed from: lgHUyS */
    public final AbstractC3726g f13283lgHUyS;

    /* renamed from: mjFkc */
    public final Context f13284mjFkc;

    /* renamed from: qdMbNW */
    public final InterfaceC4064l7 f13285qdMbNW;

    /* renamed from: wA */
    public final C3389aqHPIZ f13286wA;

    /* renamed from: xJ */
    public final int f13287xJ;

    /* renamed from: o.d$mjFkc */
    public static class mjFkc {

        /* renamed from: wA */
        public static final mjFkc f13288wA = new C6363mjFkc().m11638mjFkc();

        /* renamed from: AZxh */
        public final Looper f13289AZxh;

        /* renamed from: mjFkc */
        public final InterfaceC4064l7 f13290mjFkc;

        /* renamed from: o.d$mjFkc$mjFkc, reason: collision with other inner class name */
        public static class C6363mjFkc {

            /* renamed from: AZxh */
            public Looper f13291AZxh;

            /* renamed from: mjFkc */
            public InterfaceC4064l7 f13292mjFkc;

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: mjFkc */
            public mjFkc m11638mjFkc() {
                if (this.f13292mjFkc == null) {
                    this.f13292mjFkc = new C2307KRTLGT();
                }
                if (this.f13291AZxh == null) {
                    this.f13291AZxh = Looper.getMainLooper();
                }
                return new mjFkc(this.f13292mjFkc, this.f13291AZxh);
            }
        }

        public mjFkc(InterfaceC4064l7 interfaceC4064l7, Account account, Looper looper) {
            this.f13290mjFkc = interfaceC4064l7;
            this.f13289AZxh = looper;
        }
    }

    public AbstractC3533d(Context context, Activity activity, C3389aqHPIZ c3389aqHPIZ, C3389aqHPIZ.ZfxDd zfxDd, mjFkc mjfkc) {
        AbstractC2138I3.m8644lgHUyS(context, "Null context is not permitted.");
        AbstractC2138I3.m8644lgHUyS(c3389aqHPIZ, "Api must not be null.");
        AbstractC2138I3.m8644lgHUyS(mjfkc, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) AbstractC2138I3.m8644lgHUyS(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f13284mjFkc = context2;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : m11630JHa(context);
        this.f13278AZxh = attributionTag;
        this.f13286wA = c3389aqHPIZ;
        this.f13282ZfxDd = zfxDd;
        this.f13280JHa = mjfkc.f13289AZxh;
        C2245JYn c2245JYnM8985mjFkc = C2245JYn.m8985mjFkc(c3389aqHPIZ, zfxDd, attributionTag);
        this.f13281KLFTb = c2245JYnM8985mjFkc;
        this.f13283lgHUyS = new C4358pc(this);
        C3795h c3795hM12139diqgf = C3795h.m12139diqgf(context2);
        this.f13279Dt = c3795hM12139diqgf;
        this.f13287xJ = c3795hM12139diqgf.m12149ETF();
        this.f13285qdMbNW = mjfkc.f13290mjFkc;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            C3035Vb.m10694eyqo(activity, c3795hM12139diqgf, c2245JYnM8985mjFkc);
        }
        c3795hM12139diqgf.m12159wJVbdd(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Dt */
    public final C3389aqHPIZ.JHa m11628Dt(Looper looper, C4027kc c4027kc) {
        C5011zPp c5011zPpM14109mjFkc = m11636wA().m14109mjFkc();
        C3389aqHPIZ.JHa jHaMo9729AZxh = ((C3389aqHPIZ.mjFkc) AbstractC2138I3.m8648xJ(this.f13286wA.m11412mjFkc())).mo9729AZxh(this.f13284mjFkc, looper, c5011zPpM14109mjFkc, this.f13282ZfxDd, c4027kc, c4027kc);
        String strM11634lgHUyS = m11634lgHUyS();
        if (strM11634lgHUyS != null && (jHaMo9729AZxh instanceof AbstractC2308KRckQg)) {
            ((AbstractC2308KRckQg) jHaMo9729AZxh).m9209NPj(strM11634lgHUyS);
        }
        if (strM11634lgHUyS == null || !(jHaMo9729AZxh instanceof AbstractServiceConnectionC2206J2)) {
            return jHaMo9729AZxh;
        }
        AbstractC4793w7.m13819mjFkc(jHaMo9729AZxh);
        throw null;
    }

    /* renamed from: ETF */
    public final BinderC2041Gc m11629ETF(Context context, Handler handler) {
        return new BinderC2041Gc(context, handler, m11636wA().m14109mjFkc());
    }

    /* renamed from: JHa */
    public String m11630JHa(Context context) {
        return null;
    }

    /* renamed from: KLFTb */
    public AbstractC1670B7 m11631KLFTb(AbstractC1737C7 abstractC1737C7) {
        return m11632VA(0, abstractC1737C7);
    }

    /* renamed from: VA */
    public final AbstractC1670B7 m11632VA(int i, AbstractC1737C7 abstractC1737C7) {
        C1806D7 c1806d7 = new C1806D7();
        this.f13279Dt.m12158vI(this, i, abstractC1737C7, c1806d7, this.f13285qdMbNW);
        return c1806d7.m7977mjFkc();
    }

    /* renamed from: ZfxDd */
    public AbstractC1670B7 m11633ZfxDd(AbstractC1737C7 abstractC1737C7) {
        return m11632VA(2, abstractC1737C7);
    }

    /* renamed from: lgHUyS */
    public String m11634lgHUyS() {
        return this.f13278AZxh;
    }

    /* renamed from: qdMbNW */
    public final int m11635qdMbNW() {
        return this.f13287xJ;
    }

    /* renamed from: wA */
    public C5011zPp.mjFkc m11636wA() {
        C5011zPp.mjFkc mjfkc = new C5011zPp.mjFkc();
        mjfkc.m14108ZfxDd(null);
        mjfkc.m14110wA(Collections.emptySet());
        mjfkc.m14107KLFTb(this.f13284mjFkc.getClass().getName());
        mjfkc.m14106AZxh(this.f13284mjFkc.getPackageName());
        return mjfkc;
    }

    /* renamed from: xJ */
    public final C2245JYn m11637xJ() {
        return this.f13281KLFTb;
    }

    public AbstractC3533d(Context context, C3389aqHPIZ c3389aqHPIZ, C3389aqHPIZ.ZfxDd zfxDd, mjFkc mjfkc) {
        this(context, null, c3389aqHPIZ, zfxDd, mjfkc);
    }
}
