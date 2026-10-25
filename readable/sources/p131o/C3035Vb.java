package p131o;

import android.app.Activity;
import com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback;

/* renamed from: o.Vb */
/* loaded from: classes.dex */
public final class C3035Vb extends AbstractDialogInterfaceOnCancelListenerC1771Cd {

    /* renamed from: JHa */
    public final C3762gYa f11348JHa;

    /* renamed from: xJ */
    public final C3795h f11349xJ;

    public C3035Vb(InterfaceC2929U0 interfaceC2929U0, C3795h c3795h, C3597e c3597e) {
        super(interfaceC2929U0, c3597e);
        this.f11348JHa = new C3762gYa();
        this.f11349xJ = c3795h;
        this.f2259mjFkc.mo8531AZxh("ConnectionlessLifecycleHelper", this);
    }

    /* renamed from: eyqo */
    public static void m10694eyqo(Activity activity, C3795h c3795h, C2245JYn c2245JYn) {
        InterfaceC2929U0 interfaceC2929U0M2382wA = LifecycleCallback.m2382wA(activity);
        C3035Vb c3035Vb = (C3035Vb) interfaceC2929U0M2382wA.mo8533ZfxDd("ConnectionlessLifecycleHelper", C3035Vb.class);
        if (c3035Vb == null) {
            c3035Vb = new C3035Vb(interfaceC2929U0M2382wA, c3795h, C3597e.m11771MiMN());
        }
        AbstractC2138I3.m8644lgHUyS(c2245JYn, "ApiKey cannot be null");
        c3035Vb.f11348JHa.add(c2245JYn);
        c3795h.m12156mjFkc(c3035Vb);
    }

    @Override // p131o.AbstractDialogInterfaceOnCancelListenerC1771Cd, com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: Dt */
    public final void mo2384Dt() {
        super.mo2384Dt();
        m10695Ucbh();
    }

    @Override // p131o.AbstractDialogInterfaceOnCancelListenerC1771Cd, com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: ETF */
    public final void mo2385ETF() {
        super.mo2385ETF();
        this.f11349xJ.m12146AZxh(this);
    }

    @Override // p131o.AbstractDialogInterfaceOnCancelListenerC1771Cd
    /* renamed from: MiMN */
    public final void mo7850MiMN(C3613eEOGOh c3613eEOGOh, int i) {
        this.f11349xJ.m12147BAnRFn(c3613eEOGOh, i);
    }

    /* renamed from: Ucbh */
    public final void m10695Ucbh() {
        if (this.f11348JHa.isEmpty()) {
            return;
        }
        this.f11349xJ.m12156mjFkc(this);
    }

    @Override // p131o.AbstractDialogInterfaceOnCancelListenerC1771Cd
    /* renamed from: YoKzxo */
    public final void mo7853YoKzxo() {
        this.f11349xJ.m12154lB();
    }

    /* renamed from: diqgf */
    public final C3762gYa m10696diqgf() {
        return this.f11348JHa;
    }

    @Override // com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: lgHUyS */
    public final void mo2388lgHUyS() {
        super.mo2388lgHUyS();
        m10695Ucbh();
    }
}
