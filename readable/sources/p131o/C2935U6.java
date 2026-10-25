package p131o;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import p131o.AbstractC2308KRckQg;
import p131o.AbstractC3726g;

/* renamed from: o.U6 */
/* loaded from: classes.dex */
public class C2935U6 extends AbstractC2718Qns implements InterfaceC2838Sc {

    /* renamed from: rWxwaT */
    public static final /* synthetic */ int f10784rWxwaT = 0;

    /* renamed from: KLMXS */
    public final C5011zPp f10785KLMXS;

    /* renamed from: cMLeY */
    public final Integer f10786cMLeY;

    /* renamed from: xrEuO */
    public final boolean f10787xrEuO;

    /* renamed from: zvd */
    public final Bundle f10788zvd;

    public C2935U6(Context context, Looper looper, boolean z, C5011zPp c5011zPp, Bundle bundle, AbstractC3726g.mjFkc mjfkc, AbstractC3726g.AZxh aZxh) {
        super(context, looper, 44, c5011zPp, mjfkc, aZxh);
        this.f10787xrEuO = true;
        this.f10785KLMXS = c5011zPp;
        this.f10788zvd = bundle;
        this.f10786cMLeY = c5011zPp.m14105xJ();
    }

    /* renamed from: dm */
    public static Bundle m10469dm(C5011zPp c5011zPp) {
        c5011zPp.m14098JHa();
        Integer numM14105xJ = c5011zPp.m14105xJ();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c5011zPp.m14102mjFkc());
        if (numM14105xJ != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numM14105xJ.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: IEE */
    public final /* synthetic */ IInterface mo7623IEE(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof C3239Yc ? (C3239Yc) iInterfaceQueryLocalInterface : new C3239Yc(iBinder);
    }

    @Override // p131o.AbstractC2308KRckQg, p131o.C3389aqHPIZ.JHa
    /* renamed from: JHa */
    public final int mo7624JHa() {
        return 12451000;
    }

    @Override // p131o.InterfaceC2838Sc
    /* renamed from: VA */
    public final void mo10157VA(InterfaceC2903Tc interfaceC2903Tc) {
        AbstractC2138I3.m8644lgHUyS(interfaceC2903Tc, "Expecting a valid ISignInCallbacks");
        try {
            Account accountM14097AZxh = this.f10785KLMXS.m14097AZxh();
            ((C3239Yc) m9224lB()).m11130Ucbh(new C3961jd(1, new C1972Fd(accountM14097AZxh, ((Integer) AbstractC2138I3.m8648xJ(this.f10786cMLeY)).intValue(), "<<default account>>".equals(accountM14097AZxh.name) ? C4128m7.m12750mjFkc(m9204Gd()).m12751AZxh() : null)), interfaceC2903Tc);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                interfaceC2903Tc.mo8442MiMN(new C4161md(1, new C3613eEOGOh(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // p131o.AbstractC2308KRckQg, p131o.C3389aqHPIZ.JHa
    /* renamed from: YoKzxo */
    public final boolean mo9216YoKzxo() {
        return this.f10787xrEuO;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: mByQ */
    public final String mo7626mByQ() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // p131o.InterfaceC2838Sc
    /* renamed from: rkYL */
    public final void mo10158rkYL() {
        m9228qGY(new AbstractC2308KRckQg.ZfxDd());
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: vI */
    public final Bundle mo7627vI() {
        if (!m9204Gd().getPackageName().equals(this.f10785KLMXS.m14100ZfxDd())) {
            this.f10788zvd.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f10785KLMXS.m14100ZfxDd());
        }
        return this.f10788zvd;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: wJVbdd */
    public final String mo7628wJVbdd() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }
}
