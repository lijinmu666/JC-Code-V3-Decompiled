package p131o;

import android.util.Log;
import org.conscrypt.BuildConfig;

/* renamed from: o.Rm */
/* loaded from: classes.dex */
public final class C2782Rm {

    /* renamed from: AZxh */
    public static final C2782Rm f10471AZxh = new C2782Rm("VisionKit", 2);

    /* renamed from: mjFkc */
    public final String f10472mjFkc = "VisionKit";

    public C2782Rm(String str, int i) {
    }

    /* renamed from: KLFTb */
    public static final String m10095KLFTb(Object obj, String str, Object... objArr) {
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            String name = obj.getClass().getName();
            if (obj instanceof Class) {
                name = ((Class) obj).getName();
            }
            String[] strArrSplit = name.split("\\.");
            int length = strArrSplit.length;
            str2 = length == 0 ? BuildConfig.f24315FLAVOR : strArrSplit[length - 1];
        }
        return "[" + str2 + "] " + str;
    }

    /* renamed from: AZxh */
    public final void m10096AZxh(Object obj, String str, Object... objArr) {
        if (m10097ZfxDd(4)) {
            Log.i(this.f10472mjFkc, m10095KLFTb(obj, str, objArr));
        }
    }

    /* renamed from: ZfxDd */
    public final boolean m10097ZfxDd(int i) {
        return Log.isLoggable(this.f10472mjFkc, i);
    }

    /* renamed from: mjFkc */
    public final void m10098mjFkc(Throwable th, String str, Object... objArr) {
        if (m10097ZfxDd(6)) {
            Log.e(this.f10472mjFkc, "Error in result from JNI layer", th);
        }
    }

    /* renamed from: wA */
    public final void m10099wA(Object obj, String str, Object... objArr) {
        if (m10097ZfxDd(5)) {
            Log.w(this.f10472mjFkc, m10095KLFTb(obj, str, objArr));
        }
    }
}
