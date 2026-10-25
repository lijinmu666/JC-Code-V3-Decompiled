package p131o;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* renamed from: o.I3 */
/* loaded from: classes.dex */
public abstract class AbstractC2138I3 {
    /* renamed from: AZxh */
    public static void m8639AZxh(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: Dt */
    public static void m8640Dt(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: JHa */
    public static String m8641JHa(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    /* renamed from: KLFTb */
    public static String m8642KLFTb(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    /* renamed from: ZfxDd */
    public static void m8643ZfxDd(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    /* renamed from: lgHUyS */
    public static Object m8644lgHUyS(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    /* renamed from: mjFkc */
    public static void m8645mjFkc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: qdMbNW */
    public static void m8646qdMbNW(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: wA */
    public static void m8647wA(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* renamed from: xJ */
    public static Object m8648xJ(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null reference");
    }
}
