package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* renamed from: o.J */
/* loaded from: classes.dex */
public abstract class AbstractC2203J {

    /* renamed from: o.J$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static PorterDuff.Mode m8815AZxh(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        /* renamed from: ZfxDd */
        public static void m8816ZfxDd(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }

        /* renamed from: mjFkc */
        public static ColorStateList m8817mjFkc(ImageView imageView) {
            return imageView.getImageTintList();
        }

        /* renamed from: wA */
        public static void m8818wA(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }
    }

    /* renamed from: AZxh */
    public static PorterDuff.Mode m8811AZxh(ImageView imageView) {
        return mjFkc.m8815AZxh(imageView);
    }

    /* renamed from: ZfxDd */
    public static void m8812ZfxDd(ImageView imageView, PorterDuff.Mode mode) {
        mjFkc.m8816ZfxDd(imageView, mode);
    }

    /* renamed from: mjFkc */
    public static ColorStateList m8813mjFkc(ImageView imageView) {
        return mjFkc.m8817mjFkc(imageView);
    }

    /* renamed from: wA */
    public static void m8814wA(ImageView imageView, ColorStateList colorStateList) {
        mjFkc.m8818wA(imageView, colorStateList);
    }
}
