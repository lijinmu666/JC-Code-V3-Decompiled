package p131o;

import android.content.Context;
import com.p038google.p079mlkit.p080common.internal.MlKitComponentDiscoveryService;
import java.util.concurrent.Executor;

/* renamed from: o.j2 */
/* loaded from: classes.dex */
public class C3922j2 {

    /* renamed from: AZxh */
    public static final Object f14236AZxh = new Object();

    /* renamed from: wA */
    public static C3922j2 f14237wA;

    /* renamed from: mjFkc */
    public C4865xBQUgd f14238mjFkc;

    /* renamed from: JHa */
    public static Context m12336JHa(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    /* renamed from: KLFTb */
    public static C3922j2 m12337KLFTb(Context context, Executor executor) {
        C3922j2 c3922j2;
        synchronized (f14236AZxh) {
            AbstractC2138I3.m8640Dt(f14237wA == null, "MlKitContext is already initialized");
            C3922j2 c3922j22 = new C3922j2();
            f14237wA = c3922j22;
            Context contextM12336JHa = m12336JHa(context);
            C4865xBQUgd c4865xBQUgdM13921wA = C4865xBQUgd.m13909KLFTb(executor).m13919AZxh(C2883TFbkuO.m10405AZxh(contextM12336JHa, MlKitComponentDiscoveryService.class).m10408mjFkc()).m13920mjFkc(C2957UOnCkw.m10489VA(contextM12336JHa, Context.class, new Class[0])).m13920mjFkc(C2957UOnCkw.m10489VA(c3922j22, C3922j2.class, new Class[0])).m13921wA();
            c3922j22.f14238mjFkc = c4865xBQUgdM13921wA;
            c4865xBQUgdM13921wA.m13915lgHUyS(true);
            c3922j2 = f14237wA;
        }
        return c3922j2;
    }

    /* renamed from: ZfxDd */
    public static C3922j2 m12338ZfxDd(Context context) {
        C3922j2 c3922j2M12337KLFTb;
        synchronized (f14236AZxh) {
            c3922j2M12337KLFTb = m12337KLFTb(context, AbstractC1937F7.f8135mjFkc);
        }
        return c3922j2M12337KLFTb;
    }

    /* renamed from: wA */
    public static C3922j2 m12339wA() {
        C3922j2 c3922j2;
        synchronized (f14236AZxh) {
            AbstractC2138I3.m8640Dt(f14237wA != null, "MlKitContext has not been initialized");
            c3922j2 = (C3922j2) AbstractC2138I3.m8648xJ(f14237wA);
        }
        return c3922j2;
    }

    /* renamed from: AZxh */
    public Context m12340AZxh() {
        return (Context) m12341mjFkc(Context.class);
    }

    /* renamed from: mjFkc */
    public Object m12341mjFkc(Class cls) {
        AbstractC2138I3.m8640Dt(f14237wA == this, "MlKitContext has been deleted");
        AbstractC2138I3.m8648xJ(this.f14238mjFkc);
        return this.f14238mjFkc.mo8924mjFkc(cls);
    }
}
