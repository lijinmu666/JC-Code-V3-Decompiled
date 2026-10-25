package p131o;

/* renamed from: o.J3 */
/* loaded from: classes.dex */
public abstract class AbstractC2207J3 {
    /* renamed from: AZxh */
    public static Object m8883AZxh(Object obj) {
        obj.getClass();
        return obj;
    }

    /* renamed from: ZfxDd */
    public static void m8884ZfxDd(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: mjFkc */
    public static void m8885mjFkc(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: wA */
    public static Object m8886wA(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
