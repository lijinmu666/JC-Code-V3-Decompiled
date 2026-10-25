package p131o;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* renamed from: o.Ad */
/* loaded from: classes.dex */
public final class C1638Ad extends AbstractC2718Qns {

    /* renamed from: xrEuO */
    public final C2874T7 f7384xrEuO;

    public C1638Ad(Context context, Looper looper, C5011zPp c5011zPp, C2874T7 c2874t7, InterfaceC3976jpz interfaceC3976jpz, InterfaceC3338a3 interfaceC3338a3) {
        super(context, looper, 270, c5011zPp, interfaceC3976jpz, interfaceC3338a3);
        this.f7384xrEuO = c2874t7;
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
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof C3896id ? (C3896id) iInterfaceQueryLocalInterface : new C3896id(iBinder);
    }

    @Override // p131o.AbstractC2308KRckQg, p131o.C3389aqHPIZ.JHa
    /* renamed from: JHa */
    public final int mo7624JHa() {
        return 203400000;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: eyqo */
    public final C2987UokA[] mo7625eyqo() {
        return AbstractC3104Wc.f11472AZxh;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: mByQ */
    public final String mo7626mByQ() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: vI */
    public final Bundle mo7627vI() {
        return this.f7384xrEuO.m10217AZxh();
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: wJVbdd */
    public final String mo7628wJVbdd() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }
}
