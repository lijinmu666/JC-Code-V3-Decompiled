package p131o;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* renamed from: o.ua */
/* loaded from: classes.dex */
public abstract class AbstractC4689ua {

    /* renamed from: AZxh */
    public static final boolean f16857AZxh = true;

    /* renamed from: mjFkc */
    public static Method f16858mjFkc;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f16858mjFkc = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f16858mjFkc.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    /* renamed from: mjFkc */
    public static boolean m13718mjFkc(View view) {
        return AbstractC2876T9.m10276huTpC(view) == 1;
    }
}
