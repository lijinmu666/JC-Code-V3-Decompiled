package p131o;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.util.Set;
import p131o.AbstractC3726g;
import p131o.C3389aqHPIZ;

/* renamed from: o.Gc */
/* loaded from: classes.dex */
public final class BinderC2041Gc extends AbstractBinderC4825wc implements AbstractC3726g.mjFkc, AbstractC3726g.AZxh {

    /* renamed from: lgHUyS */
    public static final C3389aqHPIZ.mjFkc f8373lgHUyS = AbstractC2516Nc.f9806wA;

    /* renamed from: AZxh */
    public final Handler f8374AZxh;

    /* renamed from: JHa */
    public InterfaceC2838Sc f8375JHa;

    /* renamed from: KLFTb */
    public final C5011zPp f8376KLFTb;

    /* renamed from: ZfxDd */
    public final Set f8377ZfxDd;

    /* renamed from: mjFkc */
    public final Context f8378mjFkc;

    /* renamed from: wA */
    public final C3389aqHPIZ.mjFkc f8379wA;

    /* renamed from: xJ */
    public InterfaceC1971Fc f8380xJ;

    public BinderC2041Gc(Context context, Handler handler, C5011zPp c5011zPp) {
        C3389aqHPIZ.mjFkc mjfkc = f8373lgHUyS;
        this.f8378mjFkc = context;
        this.f8374AZxh = handler;
        this.f8376KLFTb = (C5011zPp) AbstractC2138I3.m8644lgHUyS(c5011zPp, "ClientSettings must not be null");
        this.f8377ZfxDd = c5011zPp.m14099KLFTb();
        this.f8379wA = mjfkc;
    }

    /* renamed from: Gd */
    public static /* bridge */ /* synthetic */ void m8438Gd(BinderC2041Gc binderC2041Gc, C4161md c4161md) {
        C3613eEOGOh c3613eEOGOhM12777mjFkc = c4161md.m12777mjFkc();
        if (c3613eEOGOhM12777mjFkc.m11823JHa()) {
            C2320Kd c2320Kd = (C2320Kd) AbstractC2138I3.m8648xJ(c4161md.m12776AZxh());
            C3613eEOGOh c3613eEOGOhM9271mjFkc = c2320Kd.m9271mjFkc();
            if (!c3613eEOGOhM9271mjFkc.m11823JHa()) {
                String strValueOf = String.valueOf(c3613eEOGOhM9271mjFkc);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                binderC2041Gc.f8380xJ.mo8314AZxh(c3613eEOGOhM9271mjFkc);
                binderC2041Gc.f8375JHa.m11417MiMN();
                return;
            }
            binderC2041Gc.f8380xJ.mo8315mjFkc(c2320Kd.m9269AZxh(), binderC2041Gc.f8377ZfxDd);
        } else {
            binderC2041Gc.f8380xJ.mo8314AZxh(c3613eEOGOhM12777mjFkc);
        }
        binderC2041Gc.f8375JHa.m11417MiMN();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [o.Sc, o.aqHPIZ$JHa] */
    /* renamed from: HGpJ */
    public final void m8440HGpJ(InterfaceC1971Fc interfaceC1971Fc) {
        InterfaceC2838Sc interfaceC2838Sc = this.f8375JHa;
        if (interfaceC2838Sc != null) {
            interfaceC2838Sc.m11417MiMN();
        }
        this.f8376KLFTb.m14103qdMbNW(Integer.valueOf(System.identityHashCode(this)));
        C3389aqHPIZ.mjFkc mjfkc = this.f8379wA;
        Context context = this.f8378mjFkc;
        Handler handler = this.f8374AZxh;
        C5011zPp c5011zPp = this.f8376KLFTb;
        this.f8375JHa = mjfkc.mo9729AZxh(context, handler.getLooper(), c5011zPp, c5011zPp.m14098JHa(), this, this);
        this.f8380xJ = interfaceC1971Fc;
        Set set = this.f8377ZfxDd;
        if (set == null || set.isEmpty()) {
            this.f8374AZxh.post(new RunnableC1769Cc(this));
        } else {
            this.f8375JHa.mo10158rkYL();
        }
    }

    @Override // p131o.InterfaceC3976jpz
    /* renamed from: KLFTb */
    public final void mo8441KLFTb(int i) {
        this.f8380xJ.mo8316wA(i);
    }

    @Override // p131o.InterfaceC2903Tc
    /* renamed from: MiMN */
    public final void mo8442MiMN(C4161md c4161md) {
        this.f8374AZxh.post(new RunnableC1900Ec(this, c4161md));
    }

    @Override // p131o.InterfaceC3338a3
    /* renamed from: ZfxDd */
    public final void mo8443ZfxDd(C3613eEOGOh c3613eEOGOh) {
        this.f8380xJ.mo8314AZxh(c3613eEOGOh);
    }

    /* renamed from: vI */
    public final void m8444vI() {
        InterfaceC2838Sc interfaceC2838Sc = this.f8375JHa;
        if (interfaceC2838Sc != null) {
            interfaceC2838Sc.m11417MiMN();
        }
    }

    @Override // p131o.InterfaceC3976jpz
    /* renamed from: xJ */
    public final void mo8445xJ(Bundle bundle) {
        this.f8375JHa.mo10157VA(this);
    }
}
