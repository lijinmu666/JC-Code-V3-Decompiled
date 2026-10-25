package p131o;

import java.util.Map;

/* renamed from: o.BE */
/* loaded from: classes.dex */
public abstract class AbstractC1679BE {
    /* renamed from: AZxh */
    public static boolean m7688AZxh(Map map, Object obj) {
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: mjFkc */
    public static Object m7689mjFkc(Map map, Object obj) {
        map.getClass();
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }
}
