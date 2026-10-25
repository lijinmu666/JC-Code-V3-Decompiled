package p131o;

import android.content.Context;

/* renamed from: o.W */
/* loaded from: classes.dex */
public abstract class AbstractC3067W {

    /* renamed from: AZxh */
    public static Boolean f11392AZxh;

    /* renamed from: mjFkc */
    public static Context f11393mjFkc;

    /* renamed from: mjFkc */
    public static synchronized boolean m10744mjFkc(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f11393mjFkc;
        if (context2 != null && (bool = f11392AZxh) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f11392AZxh = null;
        if (AbstractC4856x3.m13891JHa()) {
            f11392AZxh = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f11392AZxh = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f11392AZxh = Boolean.FALSE;
            }
        }
        f11393mjFkc = applicationContext;
        return f11392AZxh.booleanValue();
    }
}
