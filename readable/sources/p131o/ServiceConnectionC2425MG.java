package p131o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: o.MG */
/* loaded from: classes.dex */
public final class ServiceConnectionC2425MG implements ServiceConnection {

    /* renamed from: AZxh */
    public final /* synthetic */ AbstractC2308KRckQg f9563AZxh;

    /* renamed from: mjFkc */
    public final int f9564mjFkc;

    public ServiceConnectionC2425MG(AbstractC2308KRckQg abstractC2308KRckQg, int i) {
        this.f9563AZxh = abstractC2308KRckQg;
        this.f9564mjFkc = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            AbstractC2308KRckQg.m9197XV(this.f9563AZxh, 16);
            return;
        }
        synchronized (this.f9563AZxh.f9172YoKzxo) {
            try {
                AbstractC2308KRckQg abstractC2308KRckQg = this.f9563AZxh;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC2308KRckQg.f9183rkYL = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1798D)) ? new C2488NB(iBinder) : (InterfaceC1798D) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9563AZxh.m9218bbzow(0, null, this.f9564mjFkc);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f9563AZxh.f9172YoKzxo) {
            this.f9563AZxh.f9183rkYL = null;
        }
        AbstractC2308KRckQg abstractC2308KRckQg = this.f9563AZxh;
        int i = this.f9564mjFkc;
        Handler handler = abstractC2308KRckQg.f9170VA;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
