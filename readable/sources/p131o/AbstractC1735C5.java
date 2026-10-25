package p131o;

import android.R;
import android.content.res.ColorStateList;

/* renamed from: o.C5 */
/* loaded from: classes.dex */
public abstract class AbstractC1735C5 {

    /* renamed from: mjFkc */
    public static final boolean f7559mjFkc = true;

    /* renamed from: AZxh */
    public static final int[] f7551AZxh = {R.attr.state_pressed};

    /* renamed from: wA */
    public static final int[] f7561wA = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: ZfxDd */
    public static final int[] f7557ZfxDd = {R.attr.state_focused};

    /* renamed from: KLFTb */
    public static final int[] f7555KLFTb = {R.attr.state_hovered};

    /* renamed from: JHa */
    public static final int[] f7554JHa = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: xJ */
    public static final int[] f7562xJ = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: lgHUyS */
    public static final int[] f7558lgHUyS = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: qdMbNW */
    public static final int[] f7560qdMbNW = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: Dt */
    public static final int[] f7552Dt = {R.attr.state_selected};

    /* renamed from: ETF */
    public static final int[] f7553ETF = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: VA */
    public static final String f7556VA = AbstractC1735C5.class.getSimpleName();

    /* renamed from: AZxh */
    public static boolean m7749AZxh(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }

    /* renamed from: mjFkc */
    public static ColorStateList m7750mjFkc(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }
}
