package p131o;

import android.text.Editable;

/* renamed from: o.YDiFPt */
/* loaded from: classes.dex */
public final class C3216YDiFPt extends Editable.Factory {

    /* renamed from: AZxh */
    public static volatile Editable.Factory f11837AZxh;

    /* renamed from: mjFkc */
    public static final Object f11838mjFkc = new Object();

    /* renamed from: wA */
    public static Class f11839wA;

    public C3216YDiFPt() {
        try {
            f11839wA = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C3216YDiFPt.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f11837AZxh == null) {
            synchronized (f11838mjFkc) {
                try {
                    if (f11837AZxh == null) {
                        f11837AZxh = new C3216YDiFPt();
                    }
                } finally {
                }
            }
        }
        return f11837AZxh;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f11839wA;
        return cls != null ? C3541d7.m11697wA(cls, charSequence) : super.newEditable(charSequence);
    }
}
