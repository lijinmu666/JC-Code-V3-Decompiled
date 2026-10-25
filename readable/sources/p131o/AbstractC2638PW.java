package p131o;

/* renamed from: o.PW */
/* loaded from: classes.dex */
public abstract class AbstractC2638PW {
    /* renamed from: mjFkc */
    public static void m9959mjFkc(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj.toString() + "=null");
    }
}
