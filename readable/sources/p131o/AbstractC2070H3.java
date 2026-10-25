package p131o;

/* renamed from: o.H3 */
/* loaded from: classes.dex */
public abstract class AbstractC2070H3 {
    /* renamed from: AZxh */
    public static Object m8508AZxh(Object obj) {
        obj.getClass();
        return obj;
    }

    /* renamed from: mjFkc */
    public static void m8509mjFkc(Object obj, Class cls) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    /* renamed from: wA */
    public static Object m8510wA(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
