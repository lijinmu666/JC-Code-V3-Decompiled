package p131o;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* renamed from: o.a */
/* loaded from: classes.dex */
public abstract class AbstractC3334a {

    /* renamed from: AZxh */
    public static C4820wU f12268AZxh;

    /* renamed from: KLFTb */
    public static boolean f12269KLFTb;

    /* renamed from: ZfxDd */
    public static Executor f12270ZfxDd;

    /* renamed from: mjFkc */
    public static final Object f12271mjFkc = new Object();

    /* renamed from: wA */
    public static HandlerThread f12272wA;

    /* renamed from: AZxh */
    public static HandlerThread m11238AZxh() {
        synchronized (f12271mjFkc) {
            try {
                HandlerThread handlerThread = f12272wA;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f12272wA = handlerThread2;
                handlerThread2.start();
                return f12272wA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public static AbstractC3334a m11239mjFkc(Context context) {
        synchronized (f12271mjFkc) {
            try {
                if (f12268AZxh == null) {
                    f12268AZxh = new C4820wU(context.getApplicationContext(), f12269KLFTb ? m11238AZxh().getLooper() : context.getMainLooper(), f12270ZfxDd);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12268AZxh;
    }

    /* renamed from: KLFTb */
    public abstract boolean mo11240KLFTb(C2696QR c2696qr, ServiceConnection serviceConnection, String str, Executor executor);

    /* renamed from: ZfxDd */
    public final void m11241ZfxDd(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        mo11242wA(new C2696QR(str, str2, 4225, z), serviceConnection, str3);
    }

    /* renamed from: wA */
    public abstract void mo11242wA(C2696QR c2696qr, ServiceConnection serviceConnection, String str);
}
