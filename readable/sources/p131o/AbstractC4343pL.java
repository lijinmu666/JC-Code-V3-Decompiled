package p131o;

import java.util.Objects;

/* renamed from: o.pL */
/* loaded from: classes.dex */
public abstract class AbstractC4343pL {
    /* renamed from: mjFkc */
    public static void m13124mjFkc(Object obj, Object obj2) {
        if (obj == null) {
            Objects.toString(obj2);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }
}
