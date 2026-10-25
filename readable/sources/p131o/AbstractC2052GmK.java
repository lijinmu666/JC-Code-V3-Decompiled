package p131o;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: o.GmK */
/* loaded from: classes.dex */
public abstract class AbstractC2052GmK {
    /* renamed from: AZxh */
    public static PorterDuffColorFilter m8460AZxh(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    /* renamed from: mjFkc */
    public static void m8461mjFkc(Outline outline, Path path) {
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(path);
        } else {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
