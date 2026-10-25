package p131o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: o.xS */
/* loaded from: classes.dex */
public final class ServiceConnectionC4885xS implements ServiceConnection, InterfaceC4687uV {

    /* renamed from: JHa */
    public ComponentName f17379JHa;

    /* renamed from: KLFTb */
    public final C2696QR f17380KLFTb;

    /* renamed from: ZfxDd */
    public IBinder f17381ZfxDd;

    /* renamed from: wA */
    public boolean f17383wA;

    /* renamed from: xJ */
    public final /* synthetic */ C4820wU f17384xJ;

    /* renamed from: mjFkc */
    public final Map f17382mjFkc = new HashMap();

    /* renamed from: AZxh */
    public int f17378AZxh = 2;

    public ServiceConnectionC4885xS(C4820wU c4820wU, C2696QR c2696qr) {
        this.f17384xJ = c4820wU;
        this.f17380KLFTb = c2696qr;
    }

    /* renamed from: AZxh */
    public final ComponentName m13933AZxh() {
        return this.f17379JHa;
    }

    /* renamed from: Dt */
    public final boolean m13934Dt() {
        return this.f17383wA;
    }

    /* renamed from: JHa */
    public final void m13935JHa(ServiceConnection serviceConnection, String str) {
        this.f17382mjFkc.remove(serviceConnection);
    }

    /* renamed from: KLFTb */
    public final void m13936KLFTb(String str, Executor executor) {
        this.f17378AZxh = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (AbstractC4856x3.m13896qdMbNW()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            C4820wU c4820wU = this.f17384xJ;
            boolean zM11993wA = c4820wU.f17223Dt.m11993wA(c4820wU.f17230xJ, str, this.f17380KLFTb.m10006AZxh(c4820wU.f17230xJ), this, 4225, executor);
            this.f17383wA = zM11993wA;
            if (zM11993wA) {
                this.f17384xJ.f17228lgHUyS.sendMessageDelayed(this.f17384xJ.f17228lgHUyS.obtainMessage(1, this.f17380KLFTb), this.f17384xJ.f17227VA);
            } else {
                this.f17378AZxh = 2;
                try {
                    C4820wU c4820wU2 = this.f17384xJ;
                    c4820wU2.f17223Dt.m11991AZxh(c4820wU2.f17230xJ, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    /* renamed from: ZfxDd */
    public final void m13937ZfxDd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f17382mjFkc.put(serviceConnection, serviceConnection2);
    }

    /* renamed from: lgHUyS */
    public final boolean m13938lgHUyS(ServiceConnection serviceConnection) {
        return this.f17382mjFkc.containsKey(serviceConnection);
    }

    /* renamed from: mjFkc */
    public final int m13939mjFkc() {
        return this.f17378AZxh;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f17384xJ.f17225JHa) {
            try {
                this.f17384xJ.f17228lgHUyS.removeMessages(1, this.f17380KLFTb);
                this.f17381ZfxDd = iBinder;
                this.f17379JHa = componentName;
                Iterator it = this.f17382mjFkc.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f17378AZxh = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f17384xJ.f17225JHa) {
            try {
                this.f17384xJ.f17228lgHUyS.removeMessages(1, this.f17380KLFTb);
                this.f17381ZfxDd = null;
                this.f17379JHa = componentName;
                Iterator it = this.f17382mjFkc.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f17378AZxh = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: qdMbNW */
    public final boolean m13940qdMbNW() {
        return this.f17382mjFkc.isEmpty();
    }

    /* renamed from: wA */
    public final IBinder m13941wA() {
        return this.f17381ZfxDd;
    }

    /* renamed from: xJ */
    public final void m13942xJ(String str) {
        this.f17384xJ.f17228lgHUyS.removeMessages(1, this.f17380KLFTb);
        C4820wU c4820wU = this.f17384xJ;
        c4820wU.f17223Dt.m11991AZxh(c4820wU.f17230xJ, this);
        this.f17383wA = false;
        this.f17378AZxh = 2;
    }
}
