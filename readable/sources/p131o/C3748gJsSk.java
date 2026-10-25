package p131o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;

/* renamed from: o.gJsSk */
/* loaded from: classes.dex */
public class C3748gJsSk {

    /* renamed from: AZxh */
    public static final Object f13709AZxh = new Object();

    /* renamed from: wA */
    public static volatile C3748gJsSk f13710wA;

    /* renamed from: mjFkc */
    public final ConcurrentHashMap f13711mjFkc = new ConcurrentHashMap();

    /* renamed from: JHa */
    public static boolean m11987JHa(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof InterfaceC4687uV);
    }

    /* renamed from: ZfxDd */
    public static void m11988ZfxDd(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    /* renamed from: mjFkc */
    public static C3748gJsSk m11989mjFkc() {
        if (f13710wA == null) {
            synchronized (f13709AZxh) {
                try {
                    if (f13710wA == null) {
                        f13710wA = new C3748gJsSk();
                    }
                } finally {
                }
            }
        }
        C3748gJsSk c3748gJsSk = f13710wA;
        AbstractC2138I3.m8648xJ(c3748gJsSk);
        return c3748gJsSk;
    }

    /* renamed from: xJ */
    public static final boolean m11990xJ(Context context, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!AbstractC4856x3.m13898xJ() || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection);
    }

    /* renamed from: AZxh */
    public void m11991AZxh(Context context, ServiceConnection serviceConnection) {
        if (!m11987JHa(serviceConnection) || !this.f13711mjFkc.containsKey(serviceConnection)) {
            m11988ZfxDd(context, serviceConnection);
            return;
        }
        try {
            m11988ZfxDd(context, (ServiceConnection) this.f13711mjFkc.get(serviceConnection));
        } finally {
            this.f13711mjFkc.remove(serviceConnection);
        }
    }

    /* renamed from: KLFTb */
    public final boolean m11992KLFTb(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((C1703Bb.m7729mjFkc(context).m12930mjFkc(packageName, 0).flags & PKIFailureInfo.badSenderNonce) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!m11987JHa(serviceConnection)) {
            return m11990xJ(context, intent, serviceConnection, i, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f13711mjFkc.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zM11990xJ = m11990xJ(context, intent, serviceConnection, i, executor);
            if (zM11990xJ) {
                return zM11990xJ;
            }
            return false;
        } finally {
            this.f13711mjFkc.remove(serviceConnection, serviceConnection);
        }
    }

    /* renamed from: wA */
    public final boolean m11993wA(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        return m11992KLFTb(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
