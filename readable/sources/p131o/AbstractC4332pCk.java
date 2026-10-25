package p131o;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: o.pCk */
/* loaded from: classes.dex */
public abstract class AbstractC4332pCk {

    /* renamed from: o.pCk$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static boolean m13084AZxh(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        /* renamed from: mjFkc */
        public static int m13085mjFkc(Drawable drawable) {
            return drawable.getLayoutDirection();
        }
    }

    /* renamed from: o.pCk$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static boolean m13086AZxh(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        /* renamed from: JHa */
        public static void m13087JHa(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        /* renamed from: KLFTb */
        public static void m13088KLFTb(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        /* renamed from: ZfxDd */
        public static void m13089ZfxDd(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        /* renamed from: lgHUyS */
        public static void m13090lgHUyS(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        /* renamed from: mjFkc */
        public static void m13091mjFkc(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        /* renamed from: qdMbNW */
        public static void m13092qdMbNW(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        /* renamed from: wA */
        public static ColorFilter m13093wA(Drawable drawable) {
            return drawable.getColorFilter();
        }

        /* renamed from: xJ */
        public static void m13094xJ(Drawable drawable, int i) {
            drawable.setTint(i);
        }
    }

    /* renamed from: AZxh */
    public static int m13072AZxh(Drawable drawable) {
        return AZxh.m13085mjFkc(drawable);
    }

    /* renamed from: Dt */
    public static void m13073Dt(Drawable drawable, PorterDuff.Mode mode) {
        mjFkc.m13092qdMbNW(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ETF */
    public static Drawable m13074ETF(Drawable drawable) {
        return drawable instanceof InterfaceC5022zb ? ((InterfaceC5022zb) drawable).m14124mjFkc() : drawable;
    }

    /* renamed from: JHa */
    public static void m13075JHa(Drawable drawable, int i, int i2, int i3, int i4) {
        mjFkc.m13087JHa(drawable, i, i2, i3, i4);
    }

    /* renamed from: KLFTb */
    public static void m13076KLFTb(Drawable drawable, float f, float f2) {
        mjFkc.m13088KLFTb(drawable, f, f2);
    }

    /* renamed from: VA */
    public static Drawable m13077VA(Drawable drawable) {
        return drawable;
    }

    /* renamed from: ZfxDd */
    public static void m13078ZfxDd(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    /* renamed from: lgHUyS */
    public static void m13079lgHUyS(Drawable drawable, int i) {
        mjFkc.m13094xJ(drawable, i);
    }

    /* renamed from: mjFkc */
    public static void m13080mjFkc(Drawable drawable) {
        drawable.clearColorFilter();
    }

    /* renamed from: qdMbNW */
    public static void m13081qdMbNW(Drawable drawable, ColorStateList colorStateList) {
        mjFkc.m13090lgHUyS(drawable, colorStateList);
    }

    /* renamed from: wA */
    public static boolean m13082wA(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    /* renamed from: xJ */
    public static boolean m13083xJ(Drawable drawable, int i) {
        return AZxh.m13084AZxh(drawable, i);
    }
}
