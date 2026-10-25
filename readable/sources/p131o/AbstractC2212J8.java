package p131o;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: o.J8 */
/* loaded from: classes.dex */
public abstract class AbstractC2212J8 {

    /* renamed from: AZxh */
    public static Method f8883AZxh;

    /* renamed from: mjFkc */
    public static long f8884mjFkc;

    /* renamed from: AZxh */
    public static void m8907AZxh() {
        AbstractC2285K8.m9176AZxh();
    }

    /* renamed from: KLFTb */
    public static boolean m8908KLFTb() {
        try {
            if (f8883AZxh == null) {
                f8884mjFkc = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f8883AZxh = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f8883AZxh.invoke(null, Long.valueOf(f8884mjFkc))).booleanValue();
        } catch (Exception e) {
            m8911wA("isTagEnabled", e);
            return false;
        }
    }

    /* renamed from: ZfxDd */
    public static boolean m8909ZfxDd() {
        try {
            if (f8883AZxh == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return m8908KLFTb();
    }

    /* renamed from: mjFkc */
    public static void m8910mjFkc(String str) {
        AbstractC2285K8.m9177mjFkc(str);
    }

    /* renamed from: wA */
    public static void m8911wA(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}
