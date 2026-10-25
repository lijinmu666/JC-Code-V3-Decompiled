package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* renamed from: o.W1 */
/* loaded from: classes.dex */
public abstract class AbstractC3069W1 {

    /* renamed from: o.W1$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static CharSequence m10751AZxh(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        /* renamed from: Dt */
        public static MenuItem m10752Dt(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        /* renamed from: ETF */
        public static MenuItem m10753ETF(MenuItem menuItem, char c, int i) {
            return menuItem.setNumericShortcut(c, i);
        }

        /* renamed from: JHa */
        public static CharSequence m10754JHa(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        /* renamed from: KLFTb */
        public static int m10755KLFTb(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        /* renamed from: MiMN */
        public static MenuItem m10756MiMN(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }

        /* renamed from: VA */
        public static MenuItem m10757VA(MenuItem menuItem, char c, char c2, int i, int i2) {
            return menuItem.setShortcut(c, c2, i, i2);
        }

        /* renamed from: ZfxDd */
        public static PorterDuff.Mode m10758ZfxDd(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        /* renamed from: lgHUyS */
        public static MenuItem m10759lgHUyS(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        /* renamed from: mjFkc */
        public static int m10760mjFkc(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        /* renamed from: qdMbNW */
        public static MenuItem m10761qdMbNW(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        /* renamed from: wA */
        public static ColorStateList m10762wA(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        /* renamed from: xJ */
        public static MenuItem m10763xJ(MenuItem menuItem, char c, int i) {
            return menuItem.setAlphabeticShortcut(c, i);
        }
    }

    /* renamed from: AZxh */
    public static void m10745AZxh(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC4860x7) {
            ((InterfaceMenuItemC4860x7) menuItem).setContentDescription(charSequence);
        } else {
            mjFkc.m10759lgHUyS(menuItem, charSequence);
        }
    }

    /* renamed from: JHa */
    public static void m10746JHa(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC4860x7) {
            ((InterfaceMenuItemC4860x7) menuItem).setTooltipText(charSequence);
        } else {
            mjFkc.m10756MiMN(menuItem, charSequence);
        }
    }

    /* renamed from: KLFTb */
    public static void m10747KLFTb(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof InterfaceMenuItemC4860x7) {
            ((InterfaceMenuItemC4860x7) menuItem).setNumericShortcut(c, i);
        } else {
            mjFkc.m10753ETF(menuItem, c, i);
        }
    }

    /* renamed from: ZfxDd */
    public static void m10748ZfxDd(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof InterfaceMenuItemC4860x7) {
            ((InterfaceMenuItemC4860x7) menuItem).setIconTintMode(mode);
        } else {
            mjFkc.m10752Dt(menuItem, mode);
        }
    }

    /* renamed from: mjFkc */
    public static void m10749mjFkc(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof InterfaceMenuItemC4860x7) {
            ((InterfaceMenuItemC4860x7) menuItem).setAlphabeticShortcut(c, i);
        } else {
            mjFkc.m10763xJ(menuItem, c, i);
        }
    }

    /* renamed from: wA */
    public static void m10750wA(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof InterfaceMenuItemC4860x7) {
            ((InterfaceMenuItemC4860x7) menuItem).setIconTintList(colorStateList);
        } else {
            mjFkc.m10761qdMbNW(menuItem, colorStateList);
        }
    }
}
