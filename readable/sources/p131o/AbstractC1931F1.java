package p131o;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* renamed from: o.F1 */
/* loaded from: classes.dex */
public abstract class AbstractC1931F1 {
    /* renamed from: AZxh */
    public static boolean m8245AZxh(Context context, int i, boolean z) {
        TypedValue typedValueM8249mjFkc = m8249mjFkc(context, i);
        return (typedValueM8249mjFkc == null || typedValueM8249mjFkc.type != 18) ? z : typedValueM8249mjFkc.data != 0;
    }

    /* renamed from: JHa */
    public static TypedValue m8246JHa(View view, int i) {
        return m8247KLFTb(view.getContext(), i, view.getClass().getCanonicalName());
    }

    /* renamed from: KLFTb */
    public static TypedValue m8247KLFTb(Context context, int i, String str) {
        TypedValue typedValueM8249mjFkc = m8249mjFkc(context, i);
        if (typedValueM8249mjFkc != null) {
            return typedValueM8249mjFkc;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    /* renamed from: ZfxDd */
    public static int m8248ZfxDd(Context context, int i, String str) {
        return m8247KLFTb(context, i, str).data;
    }

    /* renamed from: mjFkc */
    public static TypedValue m8249mjFkc(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    /* renamed from: wA */
    public static int m8250wA(Context context, int i, int i2) {
        TypedValue typedValueM8249mjFkc = m8249mjFkc(context, i);
        return (typedValueM8249mjFkc == null || typedValueM8249mjFkc.type != 16) ? i2 : typedValueM8249mjFkc.data;
    }
}
