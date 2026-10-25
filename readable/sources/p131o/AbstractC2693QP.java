package p131o;

import android.content.Context;
import android.util.Log;

/* renamed from: o.QP */
/* loaded from: classes.dex */
public abstract class AbstractC2693QP {

    /* renamed from: mjFkc */
    public static final String[] f10178mjFkc = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: mjFkc */
    public static boolean m10005mjFkc(Context context, Throwable th) {
        try {
            AbstractC2138I3.m8648xJ(context);
            AbstractC2138I3.m8648xJ(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
