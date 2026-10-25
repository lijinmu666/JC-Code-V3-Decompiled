package p131o;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* renamed from: o.Nd */
/* loaded from: classes.dex */
public final class C2517Nd extends AbstractC2718Qns {
    public C2517Nd(Context context, Looper looper, C5011zPp c5011zPp, InterfaceC3976jpz interfaceC3976jpz, InterfaceC3338a3 interfaceC3338a3) {
        super(context, looper, 308, c5011zPp, interfaceC3976jpz, interfaceC3338a3);
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: CqaNbM */
    public final boolean mo7622CqaNbM() {
        return true;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: IEE */
    public final /* synthetic */ IInterface mo7623IEE(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
        return iInterfaceQueryLocalInterface instanceof C3036Vc ? (C3036Vc) iInterfaceQueryLocalInterface : new C3036Vc(iBinder);
    }

    @Override // p131o.AbstractC2308KRckQg, p131o.C3389aqHPIZ.JHa
    /* renamed from: JHa */
    public final int mo7624JHa() {
        return 17895000;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: eyqo */
    public final C2987UokA[] mo7625eyqo() {
        return AbstractC2249Jd.f9013AZxh;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: mByQ */
    public final String mo7626mByQ() {
        return "com.google.android.gms.chimera.container.moduleinstall.ModuleInstallService.START";
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: oCFDzJ */
    public final boolean mo9227oCFDzJ() {
        return true;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: wJVbdd */
    public final String mo7628wJVbdd() {
        return "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService";
    }
}
