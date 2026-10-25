package p131o;

import android.R;
import android.content.Context;
import android.view.Window;

/* renamed from: o.LyQ */
/* loaded from: classes.dex */
public abstract class AbstractC2405LyQ {
    /* renamed from: AZxh */
    public static int m9401AZxh(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return AbstractC2345L1.m9298AZxh(context, R.attr.navigationBarColor, -16777216);
    }

    /* renamed from: JHa */
    public static void m9402JHa(Window window, boolean z) {
        AbstractC2315Ka.m9243mjFkc(window, window.getDecorView()).m12894AZxh(z);
    }

    /* renamed from: KLFTb */
    public static void m9403KLFTb(Window window, boolean z) {
        AbstractC2315Ka.m9243mjFkc(window, window.getDecorView()).m12895mjFkc(z);
    }

    /* renamed from: ZfxDd */
    public static boolean m9404ZfxDd(int i, boolean z) {
        return AbstractC2345L1.m9308xJ(i) || (i == 0 && z);
    }

    /* renamed from: mjFkc */
    public static void m9405mjFkc(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = num == null || num.intValue() == 0;
        boolean z3 = num2 == null || num2.intValue() == 0;
        if (z2 || z3) {
            int iM9298AZxh = AbstractC2345L1.m9298AZxh(window.getContext(), R.attr.colorBackground, -16777216);
            if (z2) {
                num = Integer.valueOf(iM9298AZxh);
            }
            if (z3) {
                num2 = Integer.valueOf(iM9298AZxh);
            }
        }
        AbstractC2315Ka.m9242AZxh(window, !z);
        int iM9406wA = m9406wA(window.getContext(), z);
        int iM9401AZxh = m9401AZxh(window.getContext(), z);
        window.setStatusBarColor(iM9406wA);
        window.setNavigationBarColor(iM9401AZxh);
        m9402JHa(window, m9404ZfxDd(iM9406wA, AbstractC2345L1.m9308xJ(num.intValue())));
        m9403KLFTb(window, m9404ZfxDd(iM9401AZxh, AbstractC2345L1.m9308xJ(num2.intValue())));
    }

    /* renamed from: wA */
    public static int m9406wA(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return AbstractC2345L1.m9298AZxh(context, R.attr.statusBarColor, -16777216);
    }
}
