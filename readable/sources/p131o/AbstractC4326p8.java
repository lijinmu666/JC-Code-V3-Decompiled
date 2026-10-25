package p131o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* renamed from: o.p8 */
/* loaded from: classes.dex */
public abstract class AbstractC4326p8 {

    /* renamed from: mjFkc */
    public static final ThreadLocal f15906mjFkc = new ThreadLocal();

    /* renamed from: AZxh */
    public static final int[] f15900AZxh = {-16842910};

    /* renamed from: wA */
    public static final int[] f15908wA = {R.attr.state_focused};

    /* renamed from: ZfxDd */
    public static final int[] f15904ZfxDd = {R.attr.state_activated};

    /* renamed from: KLFTb */
    public static final int[] f15903KLFTb = {R.attr.state_pressed};

    /* renamed from: JHa */
    public static final int[] f15902JHa = {R.attr.state_checked};

    /* renamed from: xJ */
    public static final int[] f15909xJ = {R.attr.state_selected};

    /* renamed from: lgHUyS */
    public static final int[] f15905lgHUyS = {-16842919, -16842908};

    /* renamed from: qdMbNW */
    public static final int[] f15907qdMbNW = new int[0];

    /* renamed from: Dt */
    public static final int[] f15901Dt = new int[1];

    /* renamed from: AZxh */
    public static int m13063AZxh(Context context, int i) {
        ColorStateList colorStateListM13065KLFTb = m13065KLFTb(context, i);
        if (colorStateListM13065KLFTb != null && colorStateListM13065KLFTb.isStateful()) {
            return colorStateListM13065KLFTb.getColorForState(f15900AZxh, colorStateListM13065KLFTb.getDefaultColor());
        }
        TypedValue typedValueM13064JHa = m13064JHa();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM13064JHa, true);
        return m13066ZfxDd(context, i, typedValueM13064JHa.getFloat());
    }

    /* renamed from: JHa */
    public static TypedValue m13064JHa() {
        ThreadLocal threadLocal = f15906mjFkc;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: KLFTb */
    public static ColorStateList m13065KLFTb(Context context, int i) {
        int[] iArr = f15901Dt;
        iArr[0] = i;
        C1606A8 c1606a8M7574Pq = C1606A8.m7574Pq(context, null, iArr);
        try {
            return c1606a8M7574Pq.m7592wA(0);
        } finally {
            c1606a8M7574Pq.m7585eyqo();
        }
    }

    /* renamed from: ZfxDd */
    public static int m13066ZfxDd(Context context, int i, float f) {
        return AbstractC4898xfXeiC.m13959ETF(m13068wA(context, i), Math.round(Color.alpha(r0) * f));
    }

    /* renamed from: mjFkc */
    public static void m13067mjFkc(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC3407b5.f13015tQ);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f13043yfx)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: wA */
    public static int m13068wA(Context context, int i) {
        int[] iArr = f15901Dt;
        iArr[0] = i;
        C1606A8 c1606a8M7574Pq = C1606A8.m7574Pq(context, null, iArr);
        try {
            return c1606a8M7574Pq.m7576AZxh(0, 0);
        } finally {
            c1606a8M7574Pq.m7585eyqo();
        }
    }
}
