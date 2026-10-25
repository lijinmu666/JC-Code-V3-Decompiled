package p131o;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: o.awnh */
/* loaded from: classes.dex */
public abstract class AbstractC3397awnh {

    /* renamed from: mjFkc */
    public static final int[] f12835mjFkc = {R.attr.state_checked};

    /* renamed from: AZxh */
    public static final int[] f12834AZxh = new int[0];

    /* renamed from: wA */
    public static final Rect f12836wA = new Rect();

    /* renamed from: AZxh */
    public static void m11432AZxh(Drawable drawable) {
        String name = drawable.getClass().getName();
        if (Build.VERSION.SDK_INT >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        m11435wA(drawable);
    }

    /* renamed from: ZfxDd */
    public static PorterDuff.Mode m11433ZfxDd(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: mjFkc */
    public static boolean m11434mjFkc(Drawable drawable) {
        return true;
    }

    /* renamed from: wA */
    public static void m11435wA(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f12835mjFkc);
        } else {
            drawable.setState(f12834AZxh);
        }
        drawable.setState(state);
    }
}
