package p131o;

import java.util.Objects;

/* renamed from: o.V2 */
/* loaded from: classes.dex */
public abstract class AbstractC3003V2 {
    /* renamed from: AZxh */
    public static int m10657AZxh(Object... objArr) {
        return Objects.hash(objArr);
    }

    /* renamed from: ZfxDd */
    public static Object m10658ZfxDd(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: mjFkc */
    public static boolean m10659mjFkc(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    /* renamed from: wA */
    public static Object m10660wA(Object obj) {
        obj.getClass();
        return obj;
    }
}
