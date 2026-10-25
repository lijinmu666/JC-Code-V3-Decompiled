package p131o;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* renamed from: o.JT */
/* loaded from: classes.dex */
public final class C2239JT implements Handler.Callback {

    /* renamed from: mjFkc */
    public final /* synthetic */ C4820wU f8978mjFkc;

    public /* synthetic */ C2239JT(C4820wU c4820wU, AbstractC3564dT abstractC3564dT) {
        this.f8978mjFkc = c4820wU;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f8978mjFkc.f17225JHa) {
                try {
                    C2696QR c2696qr = (C2696QR) message.obj;
                    ServiceConnectionC4885xS serviceConnectionC4885xS = (ServiceConnectionC4885xS) this.f8978mjFkc.f17225JHa.get(c2696qr);
                    if (serviceConnectionC4885xS != null && serviceConnectionC4885xS.m13940qdMbNW()) {
                        if (serviceConnectionC4885xS.m13934Dt()) {
                            serviceConnectionC4885xS.m13942xJ("GmsClientSupervisor");
                        }
                        this.f8978mjFkc.f17225JHa.remove(c2696qr);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f8978mjFkc.f17225JHa) {
            try {
                C2696QR c2696qr2 = (C2696QR) message.obj;
                ServiceConnectionC4885xS serviceConnectionC4885xS2 = (ServiceConnectionC4885xS) this.f8978mjFkc.f17225JHa.get(c2696qr2);
                if (serviceConnectionC4885xS2 != null && serviceConnectionC4885xS2.m13939mjFkc() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(c2696qr2), new Exception());
                    ComponentName componentNameM13933AZxh = serviceConnectionC4885xS2.m13933AZxh();
                    if (componentNameM13933AZxh == null) {
                        componentNameM13933AZxh = c2696qr2.m10008mjFkc();
                    }
                    if (componentNameM13933AZxh == null) {
                        String strM10009wA = c2696qr2.m10009wA();
                        AbstractC2138I3.m8648xJ(strM10009wA);
                        componentNameM13933AZxh = new ComponentName(strM10009wA, "unknown");
                    }
                    serviceConnectionC4885xS2.onServiceDisconnected(componentNameM13933AZxh);
                }
            } finally {
            }
        }
        return true;
    }
}
