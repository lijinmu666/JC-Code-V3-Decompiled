package p131o;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* renamed from: o.yF */
/* loaded from: classes.dex */
public final class BinderC4936yF extends AbstractBinderC2215JB {

    /* renamed from: AZxh */
    public final int f17488AZxh;

    /* renamed from: mjFkc */
    public AbstractC2308KRckQg f17489mjFkc;

    public BinderC4936yF(AbstractC2308KRckQg abstractC2308KRckQg, int i) {
        this.f17489mjFkc = abstractC2308KRckQg;
        this.f17488AZxh = i;
    }

    @Override // p131o.InterfaceC1729C
    /* renamed from: YoKzxo */
    public final void mo7744YoKzxo(int i, IBinder iBinder, C1885EN c1885en) {
        AbstractC2308KRckQg abstractC2308KRckQg = this.f17489mjFkc;
        AbstractC2138I3.m8644lgHUyS(abstractC2308KRckQg, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC2138I3.m8648xJ(c1885en);
        AbstractC2308KRckQg.m9195WGXroI(abstractC2308KRckQg, c1885en);
        mo7745eyqo(i, iBinder, c1885en.f7982mjFkc);
    }

    @Override // p131o.InterfaceC1729C
    /* renamed from: eyqo */
    public final void mo7745eyqo(int i, IBinder iBinder, Bundle bundle) {
        AbstractC2138I3.m8644lgHUyS(this.f17489mjFkc, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f17489mjFkc.m9230rWxwaT(i, iBinder, bundle, this.f17488AZxh);
        this.f17489mjFkc = null;
    }

    @Override // p131o.InterfaceC1729C
    /* renamed from: qGY */
    public final void mo7746qGY(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
