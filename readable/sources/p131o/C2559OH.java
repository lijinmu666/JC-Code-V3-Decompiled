package p131o;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: o.OH */
/* loaded from: classes.dex */
public final class C2559OH extends AbstractC4396qB {

    /* renamed from: lgHUyS */
    public final /* synthetic */ AbstractC2308KRckQg f9941lgHUyS;

    /* renamed from: xJ */
    public final IBinder f9942xJ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2559OH(AbstractC2308KRckQg abstractC2308KRckQg, int i, IBinder iBinder, Bundle bundle) {
        super(abstractC2308KRckQg, i, bundle);
        this.f9941lgHUyS = abstractC2308KRckQg;
        this.f9942xJ = iBinder;
    }

    @Override // p131o.AbstractC4396qB
    /* renamed from: JHa */
    public final void mo9895JHa(C3613eEOGOh c3613eEOGOh) {
        if (this.f9941lgHUyS.f9169Ucbh != null) {
            this.f9941lgHUyS.f9169Ucbh.mo9236ZfxDd(c3613eEOGOh);
        }
        this.f9941lgHUyS.m9235zvd(c3613eEOGOh);
    }

    @Override // p131o.AbstractC4396qB
    /* renamed from: xJ */
    public final boolean mo9896xJ() throws RemoteException {
        try {
            IBinder iBinder = this.f9942xJ;
            AbstractC2138I3.m8648xJ(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f9941lgHUyS.mo7628wJVbdd().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f9941lgHUyS.mo7628wJVbdd() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceMo7623IEE = this.f9941lgHUyS.mo7623IEE(this.f9942xJ);
            if (iInterfaceMo7623IEE == null || !(AbstractC2308KRckQg.m9188JBhc(this.f9941lgHUyS, 2, 4, iInterfaceMo7623IEE) || AbstractC2308KRckQg.m9188JBhc(this.f9941lgHUyS, 3, 4, iInterfaceMo7623IEE))) {
                return false;
            }
            this.f9941lgHUyS.f9184vI = null;
            AbstractC2308KRckQg abstractC2308KRckQg = this.f9941lgHUyS;
            Bundle bundleM9222huTpC = abstractC2308KRckQg.m9222huTpC();
            if (abstractC2308KRckQg.f9175eyqo == null) {
                return true;
            }
            this.f9941lgHUyS.f9175eyqo.mo9240xJ(bundleM9222huTpC);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
