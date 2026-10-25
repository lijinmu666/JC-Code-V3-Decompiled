package p131o;

import androidx.fragment.p022app.Fragment;

/* renamed from: o.bL */
/* loaded from: classes.dex */
public abstract class AbstractC3423bL {

    /* renamed from: mjFkc */
    public static final C3074W6 f13093mjFkc = new C3074W6();

    /* renamed from: AZxh */
    public static boolean m11477AZxh(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(m11478wA(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: wA */
    public static Class m11478wA(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C3074W6 c3074w6 = f13093mjFkc;
        C3074W6 c3074w62 = (C3074W6) c3074w6.m10817get(classLoader);
        if (c3074w62 == null) {
            c3074w62 = new C3074W6();
            c3074w6.m10821put(classLoader, c3074w62);
        }
        Class cls = (Class) c3074w62.m10817get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c3074w62.m10821put(str, cls2);
        return cls2;
    }

    /* renamed from: mjFkc */
    public abstract Fragment mo951mjFkc(ClassLoader classLoader, String str);
}
