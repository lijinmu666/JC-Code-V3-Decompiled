package p131o;

/* renamed from: o.CC */
/* loaded from: classes.dex */
public abstract class AbstractC1744CC {
    /* renamed from: AZxh */
    public static void m7823AZxh(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj.toString() + "=null");
    }

    /* renamed from: mjFkc */
    public static int m7824mjFkc(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }
}
