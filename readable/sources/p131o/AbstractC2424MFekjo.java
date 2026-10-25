package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* renamed from: o.MFekjo */
/* loaded from: classes.dex */
public abstract class AbstractC2424MFekjo {

    /* renamed from: o.MFekjo$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public static Drawable m9497mjFkc(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    /* renamed from: o.MFekjo$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static PorterDuff.Mode m9498AZxh(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        /* renamed from: ZfxDd */
        public static void m9499ZfxDd(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }

        /* renamed from: mjFkc */
        public static ColorStateList m9500mjFkc(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        /* renamed from: wA */
        public static void m9501wA(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }
    }

    /* renamed from: AZxh */
    public static void m9494AZxh(CompoundButton compoundButton, ColorStateList colorStateList) {
        mjFkc.m9501wA(compoundButton, colorStateList);
    }

    /* renamed from: mjFkc */
    public static Drawable m9495mjFkc(CompoundButton compoundButton) {
        return AZxh.m9497mjFkc(compoundButton);
    }

    /* renamed from: wA */
    public static void m9496wA(CompoundButton compoundButton, PorterDuff.Mode mode) {
        mjFkc.m9499ZfxDd(compoundButton, mode);
    }
}
