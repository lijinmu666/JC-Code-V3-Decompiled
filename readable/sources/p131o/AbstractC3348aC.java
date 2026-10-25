package p131o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* renamed from: o.aC */
/* loaded from: classes.dex */
public abstract class AbstractC3348aC {

    /* renamed from: AZxh */
    public static boolean f12732AZxh;

    /* renamed from: ZfxDd */
    public static int f12733ZfxDd;

    /* renamed from: mjFkc */
    public static final Object f12734mjFkc = new Object();

    /* renamed from: wA */
    public static String f12735wA;

    /* renamed from: AZxh */
    public static void m11307AZxh(Context context) {
        Bundle bundle;
        synchronized (f12734mjFkc) {
            try {
                if (f12732AZxh) {
                    return;
                }
                f12732AZxh = true;
                try {
                    bundle = C1703Bb.m7729mjFkc(context).m12930mjFkc(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
                if (bundle == null) {
                    return;
                }
                f12735wA = bundle.getString("com.google.app.id");
                f12733ZfxDd = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public static int m11308mjFkc(Context context) {
        m11307AZxh(context);
        return f12733ZfxDd;
    }
}
