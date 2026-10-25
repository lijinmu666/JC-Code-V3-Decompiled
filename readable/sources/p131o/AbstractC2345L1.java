package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* renamed from: o.L1 */
/* loaded from: classes.dex */
public abstract class AbstractC2345L1 {
    /* renamed from: AZxh */
    public static int m9298AZxh(Context context, int i, int i2) {
        TypedValue typedValueM8249mjFkc = AbstractC1931F1.m8249mjFkc(context, i);
        return typedValueM8249mjFkc != null ? m9300ETF(context, typedValueM8249mjFkc) : i2;
    }

    /* renamed from: Dt */
    public static int m9299Dt(View view, int i, int i2, float f) {
        return m9306qdMbNW(m9303ZfxDd(view, i), m9303ZfxDd(view, i2), f);
    }

    /* renamed from: ETF */
    public static int m9300ETF(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        return i != 0 ? AbstractC4294ofHOBL.m12996mjFkc(context, i) : typedValue.data;
    }

    /* renamed from: JHa */
    public static ColorStateList m9301JHa(Context context, int i) {
        TypedValue typedValueM8249mjFkc = AbstractC1931F1.m8249mjFkc(context, i);
        if (typedValueM8249mjFkc == null) {
            return null;
        }
        int i2 = typedValueM8249mjFkc.resourceId;
        if (i2 != 0) {
            return AbstractC4294ofHOBL.m12995AZxh(context, i2);
        }
        int i3 = typedValueM8249mjFkc.data;
        if (i3 != 0) {
            return ColorStateList.valueOf(i3);
        }
        return null;
    }

    /* renamed from: KLFTb */
    public static int m9302KLFTb(View view, int i, int i2) {
        return m9298AZxh(view.getContext(), i, i2);
    }

    /* renamed from: ZfxDd */
    public static int m9303ZfxDd(View view, int i) {
        return m9300ETF(view.getContext(), AbstractC1931F1.m8246JHa(view, i));
    }

    /* renamed from: lgHUyS */
    public static int m9304lgHUyS(int i, int i2) {
        return AbstractC4898xfXeiC.m13967xJ(i2, i);
    }

    /* renamed from: mjFkc */
    public static int m9305mjFkc(int i, int i2) {
        return AbstractC4898xfXeiC.m13959ETF(i, (Color.alpha(i) * i2) / 255);
    }

    /* renamed from: qdMbNW */
    public static int m9306qdMbNW(int i, int i2, float f) {
        return m9304lgHUyS(i, AbstractC4898xfXeiC.m13959ETF(i2, Math.round(Color.alpha(i2) * f)));
    }

    /* renamed from: wA */
    public static int m9307wA(Context context, int i, String str) {
        return m9300ETF(context, AbstractC1931F1.m8247KLFTb(context, i, str));
    }

    /* renamed from: xJ */
    public static boolean m9308xJ(int i) {
        return i != 0 && AbstractC4898xfXeiC.m13962ZfxDd(i) > 0.5d;
    }
}
