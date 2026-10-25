package p131o;

import android.content.Context;
import android.os.Looper;
import java.util.Set;
import p131o.AbstractC2308KRckQg;
import p131o.AbstractC3726g;

/* renamed from: o.aqHPIZ */
/* loaded from: classes.dex */
public final class C3389aqHPIZ {

    /* renamed from: AZxh */
    public final xJ f12818AZxh;

    /* renamed from: mjFkc */
    public final mjFkc f12819mjFkc;

    /* renamed from: wA */
    public final String f12820wA;

    /* renamed from: o.aqHPIZ$AZxh */
    public interface AZxh {
    }

    /* renamed from: o.aqHPIZ$JHa */
    public interface JHa extends AZxh {
        /* renamed from: AZxh */
        void m11413AZxh(InterfaceC1662B interfaceC1662B, Set set);

        /* renamed from: Dt */
        String m11414Dt();

        /* renamed from: ETF */
        String m11415ETF();

        /* renamed from: JHa */
        int mo7624JHa();

        /* renamed from: KLFTb */
        boolean m11416KLFTb();

        /* renamed from: MiMN */
        void m11417MiMN();

        /* renamed from: YoKzxo */
        boolean mo9216YoKzxo();

        /* renamed from: ZfxDd */
        void m11418ZfxDd(String str);

        /* renamed from: lgHUyS */
        boolean m11419lgHUyS();

        /* renamed from: mjFkc */
        boolean m11420mjFkc();

        /* renamed from: qGY */
        void m11421qGY(AbstractC2308KRckQg.wA wAVar);

        /* renamed from: qdMbNW */
        C2987UokA[] m11422qdMbNW();

        /* renamed from: wA */
        Set mo10026wA();

        /* renamed from: xJ */
        void m11423xJ(AbstractC2308KRckQg.KLFTb kLFTb);
    }

    /* renamed from: o.aqHPIZ$KLFTb */
    public static abstract class KLFTb {
    }

    /* renamed from: o.aqHPIZ$ZfxDd */
    public interface ZfxDd {

        /* renamed from: mjFkc */
        public static final mjFkc f12821mjFkc = new mjFkc(null);

        /* renamed from: o.aqHPIZ$ZfxDd$mjFkc */
        public static final class mjFkc implements ZfxDd {
            public /* synthetic */ mjFkc(AbstractC2641Pb abstractC2641Pb) {
            }
        }
    }

    /* renamed from: o.aqHPIZ$mjFkc */
    public static abstract class mjFkc extends KLFTb {
        /* renamed from: AZxh */
        public JHa mo9729AZxh(Context context, Looper looper, C5011zPp c5011zPp, Object obj, AbstractC3726g.mjFkc mjfkc, AbstractC3726g.AZxh aZxh) {
            return mo8043mjFkc(context, looper, c5011zPp, obj, mjfkc, aZxh);
        }

        /* renamed from: mjFkc */
        public JHa mo8043mjFkc(Context context, Looper looper, C5011zPp c5011zPp, Object obj, InterfaceC3976jpz interfaceC3976jpz, InterfaceC3338a3 interfaceC3338a3) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* renamed from: o.aqHPIZ$wA */
    public static class wA {
    }

    /* renamed from: o.aqHPIZ$xJ */
    public static final class xJ extends wA {
    }

    public C3389aqHPIZ(String str, mjFkc mjfkc, xJ xJVar) {
        AbstractC2138I3.m8644lgHUyS(mjfkc, "Cannot construct an Api with a null ClientBuilder");
        AbstractC2138I3.m8644lgHUyS(xJVar, "Cannot construct an Api with a null ClientKey");
        this.f12820wA = str;
        this.f12819mjFkc = mjfkc;
        this.f12818AZxh = xJVar;
    }

    /* renamed from: AZxh */
    public final String m11411AZxh() {
        return this.f12820wA;
    }

    /* renamed from: mjFkc */
    public final mjFkc m11412mjFkc() {
        return this.f12819mjFkc;
    }
}
