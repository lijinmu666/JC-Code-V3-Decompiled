package p131o;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* renamed from: o.wU */
/* loaded from: classes.dex */
public final class C4820wU extends AbstractC3334a {

    /* renamed from: Dt */
    public final C3748gJsSk f17223Dt;

    /* renamed from: ETF */
    public final long f17224ETF;

    /* renamed from: JHa */
    public final HashMap f17225JHa = new HashMap();

    /* renamed from: MiMN */
    public volatile Executor f17226MiMN;

    /* renamed from: VA */
    public final long f17227VA;

    /* renamed from: lgHUyS */
    public volatile Handler f17228lgHUyS;

    /* renamed from: qdMbNW */
    public final C2239JT f17229qdMbNW;

    /* renamed from: xJ */
    public final Context f17230xJ;

    public C4820wU(Context context, Looper looper, Executor executor) {
        C2239JT c2239jt = new C2239JT(this, null);
        this.f17229qdMbNW = c2239jt;
        this.f17230xJ = context.getApplicationContext();
        this.f17228lgHUyS = new HandlerC4274oL(looper, c2239jt);
        this.f17223Dt = C3748gJsSk.m11989mjFkc();
        this.f17224ETF = 5000L;
        this.f17227VA = 300000L;
        this.f17226MiMN = executor;
    }

    @Override // p131o.AbstractC3334a
    /* renamed from: KLFTb */
    public final boolean mo11240KLFTb(C2696QR c2696qr, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zM13934Dt;
        AbstractC2138I3.m8644lgHUyS(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f17225JHa) {
            try {
                ServiceConnectionC4885xS serviceConnectionC4885xS = (ServiceConnectionC4885xS) this.f17225JHa.get(c2696qr);
                if (executor == null) {
                    executor = this.f17226MiMN;
                }
                if (serviceConnectionC4885xS == null) {
                    serviceConnectionC4885xS = new ServiceConnectionC4885xS(this, c2696qr);
                    serviceConnectionC4885xS.m13937ZfxDd(serviceConnection, serviceConnection, str);
                    serviceConnectionC4885xS.m13936KLFTb(str, executor);
                    this.f17225JHa.put(c2696qr, serviceConnectionC4885xS);
                } else {
                    this.f17228lgHUyS.removeMessages(0, c2696qr);
                    if (serviceConnectionC4885xS.m13938lgHUyS(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + c2696qr.toString());
                    }
                    serviceConnectionC4885xS.m13937ZfxDd(serviceConnection, serviceConnection, str);
                    int iM13939mjFkc = serviceConnectionC4885xS.m13939mjFkc();
                    if (iM13939mjFkc == 1) {
                        serviceConnection.onServiceConnected(serviceConnectionC4885xS.m13933AZxh(), serviceConnectionC4885xS.m13941wA());
                    } else if (iM13939mjFkc == 2) {
                        serviceConnectionC4885xS.m13936KLFTb(str, executor);
                    }
                }
                zM13934Dt = serviceConnectionC4885xS.m13934Dt();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zM13934Dt;
    }

    @Override // p131o.AbstractC3334a
    /* renamed from: wA */
    public final void mo11242wA(C2696QR c2696qr, ServiceConnection serviceConnection, String str) {
        AbstractC2138I3.m8644lgHUyS(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f17225JHa) {
            try {
                ServiceConnectionC4885xS serviceConnectionC4885xS = (ServiceConnectionC4885xS) this.f17225JHa.get(c2696qr);
                if (serviceConnectionC4885xS == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + c2696qr.toString());
                }
                if (!serviceConnectionC4885xS.m13938lgHUyS(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + c2696qr.toString());
                }
                serviceConnectionC4885xS.m13935JHa(serviceConnection, str);
                if (serviceConnectionC4885xS.m13940qdMbNW()) {
                    this.f17228lgHUyS.sendMessageDelayed(this.f17228lgHUyS.obtainMessage(0, c2696qr), this.f17224ETF);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
